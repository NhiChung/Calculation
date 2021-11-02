package com.NhiChung.Selenium.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverWrapper {
    private static WebDriver driver = null;

    private DriverWrapper() {
        ChromeDriverService service = ChromeDriverService.createServiceWithConfig(new ChromeOptions());
        driver = new ChromeDriver(service);

//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
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
