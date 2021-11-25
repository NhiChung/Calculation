package com.NhiChung.Selenium.UITesting;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @DataProvider(name = "browser")
    public Object[][] dataProviderBrowser(){
        return new Object[][]{
                {"firefox","firefox"},{"chrome","chrome"},{"edge","edge"}
        };
    }

    @DataProvider(name = "test-data")
    public Object[][] dataProviderSearch(){
        return new Object[][]{
                {"test1","Hanoi"},{"test2","Paris"},{"test3","Tokyo"}
        };
    }

    @BeforeMethod
    public void preCondition() {
        Configuration.reportsFolder = "test-result/reports";

        WebDriverManager.chromedriver().setup();
        System.setProperty("selenide.browser", "Chrome");

        open("https://www.booking.com/");
    }
}
