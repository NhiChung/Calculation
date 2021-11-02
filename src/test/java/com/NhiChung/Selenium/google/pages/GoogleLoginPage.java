package com.NhiChung.Selenium.google.pages;

import com.NhiChung.Selenium.core.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GoogleLoginPage extends BaseGooglePage{
    private WebElement googleLoginButton = DriverWrapper.getDriver().findElement(By.xpath("//*[@id=\"gb\"]/div/div[2]/a"));
    private WebElement googleSubmitEmailButton = DriverWrapper.getDriver().findElement(By.xpath("//*[@id=\"identifierNext\"]"));
    private WebElement googleEmailInput = DriverWrapper.getDriver().findElement(By.xpath("//input[@type=\"email\"]"));
    private WebElement googlePasswordInput = DriverWrapper.getDriver().findElement(By.xpath("//input[@type=\"password\"]"));
    private WebElement googleSubmitPasswordButton = DriverWrapper.getDriver().findElement(By.xpath("//*[@id=\"passwordNext\"]"));

    public GoogleLoginPage openLoginPage() {
        googleLoginButton.click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public GoogleLoginPage enterEmail(String text) {
        googleEmailInput.sendKeys(text);
        googleSubmitEmailButton.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public GoogleLoginPage enterPassword(String text) {
        googlePasswordInput.sendKeys(text);
        googleSubmitPasswordButton.click();
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
