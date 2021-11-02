package com.NhiChung.Selenium.google.pages;

import com.NhiChung.Selenium.core.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GoogleColorPickerPage extends BaseGooglePage{
    private WebElement googleColorPicker;

    public void changeColorPicker(String id) {
        googleColorPicker = DriverWrapper.getDriver().findElement(By.id(id));
    }

}
