package com.NhiChung.Selenium.google.pages;

import com.NhiChung.Selenium.core.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GoogleSearchResultPage extends BaseGooglePage{

    public String getTitle() {
        return DriverWrapper.getDriver().getTitle();
    }
}
