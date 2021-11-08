package com.NhiChung.Selenium.selenium4;

import com.NhiChung.Selenium.BaseTest;
import com.NhiChung.Selenium.core.DriverWrapper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public abstract class SeleniumBaseTest extends BaseTest {
    @BeforeMethod
    public void preCondition() {
        DriverWrapper.getDriver().get("https://www.google.com");
    }

    @AfterTest
    public void postCondition() {
        DriverWrapper.getDriver().quit();
    }
}
