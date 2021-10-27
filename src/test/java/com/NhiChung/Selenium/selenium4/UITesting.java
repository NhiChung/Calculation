package com.NhiChung.Selenium.selenium4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
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
        try {
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

        } catch (Exception e) {
        }

    }

    @Test
    void searchNormalText() {
        try {
            WebElement input = driver.findElement(By.name("q"));
            input.sendKeys("How to use Selenium");
            input.submit();

            TimeUnit.SECONDS.sleep(2);
            driver.findElement(By.xpath("//a[contains(@href, 'selenium.dev')]")).click();
            TimeUnit.SECONDS.sleep(5);


        } catch (Exception e) {

        }
    }

    @Test
    void trimText() {
        // Trim method() is the method returns a new string, without any of the leading or the trailing white spaces.
        try {
            WebElement input = driver.findElement(By.name("q"));
            input.sendKeys("       Selenium    ");
            input.submit();
            TimeUnit.SECONDS.sleep(2);
            driver.findElement(By.xpath("//input[@value='Selenium']"));


        } catch (Exception e) {

        }
    }

    @Test
    void googleCalculator() {
        try {
            WebElement input = driver.findElement(By.name("q"));
            input.sendKeys("1+5");
            input.submit();

            TimeUnit.SECONDS.sleep(2);
            String result = driver.findElement(By.xpath("//*[@id=\"cwos\"]")).getText();

            if(result.equals("6")){
                System.out.println("Pass");
            }
            else {
                System.out.println("Fail");
            }

        } catch (Exception e) {

        }
    }

    @Test
    void googleTranslate() {
        try {
            WebElement input = driver.findElement(By.name("q"));
            input.sendKeys("translate");
            input.submit();

            driver.findElement(By.xpath("//*[@id=\"tw-source-text-ta\"]")).sendKeys("ni hao");
            TimeUnit.SECONDS.sleep(2);
            String result = driver.findElement(By.xpath("//*[@id=\"kAz1tf\"]")).getText();

            if(result.equals("hello") || result.equals("hi") || result.equals("Hi") || result.equals("Hello")){
                System.out.println("Pass");
            }
            else {
                System.out.println("Fail");
            }


        } catch (Exception e) {

        }
    }

    @Test
    void googleTranslate2() {
        try {
            WebElement input = driver.findElement(By.name("q"));
            input.sendKeys("chinese to english");
            input.submit();

            driver.findElement(By.xpath("//*[@id=\"tw-source-text-ta\"]")).sendKeys("ni hao");
            TimeUnit.SECONDS.sleep(2);
            String result = driver.findElement(By.xpath("//*[@id=\"kAz1tf\"]")).getText();

            if(result.equals("hello") || result.equals("hi") || result.equals("Hi") || result.equals("Hello")){
                System.out.println("Pass");
            }
            else {
                System.out.println("Fail");
            }


        } catch (Exception e) {

        }
    }

    @Test
    void unitConverter_changeValue() {
        try {
            WebElement input = driver.findElement(By.name("q"));
            input.sendKeys("km to miles");
            input.submit();

            WebElement convertValue = driver.findElement(By.xpath("//input[@value='1']"));
            convertValue.clear();
            convertValue.sendKeys("100");
            TimeUnit.SECONDS.sleep(2);

            WebElement convertValue2 = driver.findElement(By.xpath("//input[@value='0.621371']"));
            convertValue2.clear();
            convertValue2.sendKeys("10");

        } catch (Exception e) {

        }
    }

    @Test
    void unitConverter_changeValue2() {
        try {
            WebElement input = driver.findElement(By.name("q"));
            input.sendKeys("5km=?m");
            input.submit();

            WebElement convertValue = driver.findElement(By.xpath("//input[@value='1']"));
            convertValue.clear();
            convertValue.sendKeys("100");
            TimeUnit.SECONDS.sleep(2);

            WebElement convertValue2 = driver.findElement(By.xpath("//input[@value='5000']"));
            convertValue2.clear();
            convertValue2.sendKeys("10");

        } catch (Exception e) {

        }
    }

    @Test
    void colorPicker() {
        try {
            WebElement input = driver.findElement(By.name("q"));
            input.sendKeys("color picker");
            input.submit();

            WebElement convertValue = driver.findElement(By.id("kyN4Jf3TGqF__slider-background"));



        } catch (Exception e) {

        }
    }

    @Test
    void unitConverter_ChangeUnitType() {
        // use selection of unit converter
        try {
            WebElement input = driver.findElement(By.name("q"));
            input.sendKeys("km to miles");
            input.submit();

            Select selector1 =  new Select(driver.findElement(By.id("ssSucf")));
            selector1.selectByVisibleText("Meter");

            Select selector2 =  new Select(driver.findElement(By.xpath("//div[@id='NotFQb']/select")));
            selector2.selectByVisibleText("Millimetre");


        } catch (Exception e) {

        }
    }

}
