package com.NhiChung.Selenium.UITesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @BeforeMethod
    public void preCondition() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("selenide.browser", "Chrome");

        open("https://www.booking.com/");
    }
}
