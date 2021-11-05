package com.NhiChung.Selenium.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverWrapper {
    private static WebDriver driver = null;

    private DriverWrapper() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        ChromeDriverService service = ChromeDriverService.createServiceWithConfig(new ChromeOptions());
        driver = new ChromeDriver(service);
    }

    public static WebDriver getDriver(){
        if (driver!=null) {
            return driver;
        } else {
            new DriverWrapper();
            return driver;
        }
    }
}
