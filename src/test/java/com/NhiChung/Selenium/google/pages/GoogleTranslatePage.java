package com.NhiChung.Selenium.google.pages;

import com.NhiChung.Selenium.core.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GoogleTranslatePage extends BaseGooglePage{
    private WebElement googleTranslateField = DriverWrapper.getDriver().findElement(By.xpath("//*[@id=\"tw-source-text-ta\"]"));
    private WebElement googleTranslateResult = DriverWrapper.getDriver().findElement(By.xpath("//*[@id=\"kAz1tf\"]"));

    public String getTranslateResult(String text) {
        googleTranslateField.sendKeys(text);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info(String.format("Set %s to the Translate field", text));
        return googleTranslateResult.getText();
    }

}
