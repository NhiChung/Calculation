package com.NhiChung.Selenium.google.pages;

import com.NhiChung.Selenium.core.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GoogleHomeSearchPage extends BaseGooglePage{
    private WebElement googleLoginButton = DriverWrapper.getDriver().findElement(By.xpath("//*[@id=\"gb\"]/div/div[2]/a"));
    private WebElement googleSearchField = DriverWrapper.getDriver().findElement(By.name("q"));
//    private WebElement googleSearchButton = DriverWrapper.getDriver().findElement(By.name("btnK"));

    public GoogleHomeSearchPage setTextToSearchField(String text) {
        googleSearchField.sendKeys(text);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return this;
    }

    public GoogleSearchResultPage clickGoogleSearchButton() {
        googleSearchField.submit();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new GoogleSearchResultPage();
    }

    public GoogleTranslatePage goToTranslatePage() {
        googleSearchField.submit();

        return new GoogleTranslatePage();
    }

    public GoogleColorPickerPage goToColorPickerPage() {
        googleSearchField.submit();

        return new GoogleColorPickerPage();
    }

    public GoogleCalculatorPage goToCalculatorPage() {
        googleSearchField.submit();

        return new GoogleCalculatorPage();
    }

    public GoogleLoginPage goToLoginPage() {
        googleLoginButton.click();

        return new GoogleLoginPage();
    }
}
