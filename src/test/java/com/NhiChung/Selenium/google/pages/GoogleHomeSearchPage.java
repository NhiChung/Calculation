package com.NhiChung.Selenium.google.pages;

import com.NhiChung.Selenium.core.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GoogleHomeSearchPage extends BaseGooglePage{

    private WebElement googleSearchField = DriverWrapper.getDriver().findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
    private WebElement googleSearchButton = DriverWrapper.getDriver().findElement(By.name("btnK"));

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
        googleSearchButton.click();
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

    public GoogleUnitConverter goToConverterUnitPage() {
        googleSearchField.submit();

        return new GoogleUnitConverter();
    }

    public GoogleColorPickerPage goToColorPickerPage() {
        googleSearchField.submit();

        return new GoogleColorPickerPage();
    }

    public GoogleCalculatorPage goToCalculatorPage() {
        googleSearchField.submit();

        return new GoogleCalculatorPage();
    }
}
