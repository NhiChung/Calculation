package com.NhiChung.Selenium.UITesting;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import static com.codeborne.selenide.Selenide.open;
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

    public void chooseBrowser(String browser) {
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
}
