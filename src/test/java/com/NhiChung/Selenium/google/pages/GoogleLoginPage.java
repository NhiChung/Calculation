package com.NhiChung.Selenium.google.pages;

import com.NhiChung.Selenium.core.DriverWrapper;
import org.openqa.selenium.By;

public class GoogleLoginPage extends BaseGooglePage{

    public GoogleLoginPage enterEmail(String text) {
        DriverWrapper.getDriver().findElement(By.xpath("//input[@type=\"email\"]")).sendKeys(text);
        DriverWrapper.getDriver().findElement(By.xpath("//*[@id=\"identifierNext\"]")).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public GoogleLoginPage enterPassword(String text) {
        DriverWrapper.getDriver().findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(text);
        DriverWrapper.getDriver().findElement(By.xpath("//*[@id=\"passwordNext\"]")).click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public void checkLoginGoogle(String url) {
        DriverWrapper.getDriver().get(url);
    }
}
