package com.NhiChung.Selenium.google.pages;

import com.NhiChung.Selenium.core.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GoogleCalculatorPage extends BaseGooglePage{
    private WebElement googleResultCalculator = DriverWrapper.getDriver().findElement(By.xpath("//*[@id=\"cwos\"]"));

    public String getCalculatorResult() {
        return googleResultCalculator.getText();
    }
}
