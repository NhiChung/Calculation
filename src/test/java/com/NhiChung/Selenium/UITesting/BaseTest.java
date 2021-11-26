package com.NhiChung.Selenium.UITesting;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.Configuration;
public class BaseTest extends DataParams {

    public void setUpChromeDrive() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
    }

    public void setUpFirefoxDrive() {
        WebDriverManager.firefoxdriver().setup();
        Configuration.browser = "firefox";
    }

    public void setUpEdgeDrive() {
        WebDriverManager.edgedriver().setup();
        Configuration.browser = "edge";
    }

    public void preCondition(String browser) {
        Configuration.reportsFolder = "test-result/reports";

        switch (browser) {
            case "FIREFOX":
                setUpFirefoxDrive();
                break;
            case "CHROME":
                setUpChromeDrive();
                break;
            case  "EDGE":
                setUpEdgeDrive();
                break;
        }

        open(baseURL);
    }

    @AfterMethod
    public void postCondition() {
        Selenide.closeWebDriver();
        clearBrowserCookies();
    }
}
