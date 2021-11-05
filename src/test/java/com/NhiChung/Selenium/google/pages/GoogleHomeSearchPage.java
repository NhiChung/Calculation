package com.NhiChung.Selenium.google.pages;

import com.NhiChung.Selenium.core.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GoogleHomeSearchPage extends BaseGooglePage{
    private WebElement googleLoginButton = DriverWrapper.getDriver().findElement(By.xpath("//*[@id=\"gb\"]/div/div[2]/a"));
    private WebElement googleSearchField = DriverWrapper.getDriver().findElement(By.name("q"));

    public GoogleHomeSearchPage setTextToSearchField(String text) {
        googleSearchField.sendKeys(text);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(String.format("Set %s to Search field ", text));

        return this;
    }

    public GoogleSearchResultPage clickGoogleSearchButton() {
        googleSearchField.submit();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("click Google Search button");

        return new GoogleSearchResultPage();
    }

    public GoogleTranslatePage goToTranslatePage() {
        googleSearchField.submit();

        log.info("Go to Translate page");
        return new GoogleTranslatePage();
    }

    public GoogleColorPickerPage goToColorPickerPage() {
        googleSearchField.submit();

        log.info("Go o Color Picker page");
        return new GoogleColorPickerPage();
    }

    public GoogleCalculatorPage goToCalculatorPage() {
        googleSearchField.submit();

        log.info("Go to Calculator page");
        return new GoogleCalculatorPage();
    }

    public GoogleLoginPage goToLoginPage() {
        googleLoginButton.click();

        log.info("Go to Login page");
        return new GoogleLoginPage();
    }
}
