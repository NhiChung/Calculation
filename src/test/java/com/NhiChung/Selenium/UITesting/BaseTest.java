package com.NhiChung.Selenium.UITesting;

import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @BeforeMethod
    public void preCondition() {
        open("https://www.booking.com/");
    }

}
