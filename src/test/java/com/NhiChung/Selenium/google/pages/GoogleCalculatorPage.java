package com.NhiChung.Selenium.google.pages;

import com.NhiChung.Selenium.core.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *This is a google calculator page class representation
 */
public class GoogleCalculatorPage extends BaseGooglePage{
    private WebElement googleResultCalculator = DriverWrapper.getDriver().findElement(By.id("cwos"));

    /**
     * method get calulator result
     *
     * @return String get calculator result
     */
    public String getCalculatorResult() {
        return googleResultCalculator.getText();
    }
}
