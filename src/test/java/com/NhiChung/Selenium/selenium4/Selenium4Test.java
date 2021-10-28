package com.NhiChung.Selenium.selenium4;

import org.openqa.selenium.WebDriver;
import com.NhiChung.Selenium.core.DriverWrapper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium4Test extends SeleniumBaseTest {
    @Test
    public void testingChromeAndSeleniumBasic() {
        DriverWrapper.getDriver().navigate().to("https://mvnrepository.com/");
        DriverWrapper.getDriver().quit();
        Assert.assertEquals(true, true);
    }
}
