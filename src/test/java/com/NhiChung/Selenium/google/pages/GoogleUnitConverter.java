package com.NhiChung.Selenium.google.pages;

import com.NhiChung.Selenium.core.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GoogleUnitConverter extends BaseGooglePage{
    private WebElement googleUnitConverterField;

    public GoogleUnitConverter setTextToUnitConverterField(String xpath, String value) {
        googleUnitConverterField = DriverWrapper.getDriver().findElement(By.xpath(xpath));
        googleUnitConverterField.clear();
        googleUnitConverterField.sendKeys(value);

        return this;
    }

}
