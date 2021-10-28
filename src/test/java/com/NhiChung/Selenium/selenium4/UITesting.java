package com.NhiChung.Selenium.selenium4;

import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class UITesting extends SeleniumBaseTest{
    private WebDriver driver;

    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void loginGoogle() throws InterruptedException {
            String username="nhilx150017@gmail.com";
            String password="tuyet_trang2602";

            driver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[2]/a")).click();
            driver.findElement(By.xpath("//input[@type=\"email\"]")).sendKeys(username);
            driver.findElement(By.xpath("//*[@id=\"identifierNext\"]")).click();
            TimeUnit.SECONDS.sleep(1);
            driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(password);
            driver.findElement(By.xpath("//*[@id=\"passwordNext\"]")).click();
            TimeUnit.SECONDS.sleep(1);

            driver.get("https://youtube.com");
            TimeUnit.SECONDS.sleep(5);
    }

    @Test
    void searchNormalText() throws InterruptedException {
            WebElement input = driver.findElement(By.name("q"));
            input.sendKeys("How to use Selenium");
            input.submit();

            TimeUnit.SECONDS.sleep(1);
            driver.findElement(By.xpath("//a[contains(@href, 'selenium.dev')]")).click();

    }

    @Test
    void trimText() {
        // Trim method() is the method returns a new string, without any of the leading or the trailing white spaces.
             WebElement input = driver.findElement(By.name("q"));
            input.sendKeys("       Selenium    ");
            input.submit();
            driver.findElement(By.xpath("//input[@value='Selenium']"));
    }

    @Test
    void googleCalculator() {
            WebElement input = driver.findElement(By.name("q"));
            input.sendKeys("1+5");
            input.submit();

            String result = driver.findElement(By.xpath("//*[@id=\"cwos\"]")).getText();

            Assert.assertEquals("6", result);
    }

    @Test
    void googleTranslate() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        WebElement input = driver.findElement(By.name("q"));
        input.sendKeys("translate");
        input.submit();

        driver.findElement(By.xpath("//*[@id=\"tw-source-text-ta\"]")).sendKeys("ni hao");
        TimeUnit.SECONDS.sleep(2);
        String result = driver.findElement(By.xpath("//*[@id=\"kAz1tf\"]")).getText();

        boolean result1 = result.equals("Hello") ||
                result.equals("Hi") ||
                result.equals("hello") ||
                result.equals("hi");
        softAssert.assertTrue(result1);
//        if(result.equals("hello") || result.equals("hi") || result.equals("Hi") || result.equals("Hello")){
//            System.out.println("Pass");
//        }
//        else {
//            System.out.println("Fail");
//        }

    }

    @Test
    void googleTranslate2() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        WebElement input = driver.findElement(By.name("q"));
        input.sendKeys("chinese to english");
        input.submit();

        driver.findElement(By.xpath("//*[@id=\"tw-source-text-ta\"]")).sendKeys("ni hao");
        TimeUnit.SECONDS.sleep(2);
        String result = driver.findElement(By.xpath("//*[@id=\"kAz1tf\"]")).getText();

        boolean result1 = result.equals("Hello") ||
                result.equals("Hi") ||
                result.equals("hello") ||
                result.equals("hi");
        softAssert.assertTrue(result1);

//        if(result.equals("hello") || result.equals("hi") || result.equals("Hi") || result.equals("Hello")){
//            System.out.println("Pass");
//        }
//        else {
//            System.out.println("Fail");
//        }

    }

    @Test
    void unitConverter_changeValue(){
            WebElement input = driver.findElement(By.name("q"));
            input.sendKeys("km to miles");
            input.submit();

            WebElement convertValue = driver.findElement(By.xpath("//input[@value='1']"));
            convertValue.clear();
            convertValue.sendKeys("100");

            WebElement convertValue2 = driver.findElement(By.xpath("//input[@value='0.621371']"));
            convertValue2.clear();
            convertValue2.sendKeys("10");

    }

    @Test
    void unitConverter_changeValue2() {
            WebElement input = driver.findElement(By.name("q"));
            input.sendKeys("5km=?m");
            input.submit();

            WebElement convertValue = driver.findElement(By.xpath("//input[@value='1']"));
            convertValue.clear();
            convertValue.sendKeys("100");

            WebElement convertValue2 = driver.findElement(By.xpath("//input[@value='5000']"));
            convertValue2.clear();
            convertValue2.sendKeys("10");

    }

    @Test
    void colorPicker() {
            WebElement input = driver.findElement(By.name("q"));
            input.sendKeys("color picker");
            input.submit();

            WebElement convertValue = driver.findElement(By.id("kyN4Jf3TGqF__slider-background"));

    }

    @Test
    void unitConverter_ChangeUnitType() {
            WebElement input = driver.findElement(By.name("q"));
            input.sendKeys("km to miles");
            input.submit();

            Select selector1 =  new Select(driver.findElement(By.id("ssSucf")));
            selector1.selectByVisibleText("Meter");

            Select selector2 =  new Select(driver.findElement(By.xpath("//div[@id='NotFQb']/select")));
            selector2.selectByVisibleText("Millimetre");

    }

}
