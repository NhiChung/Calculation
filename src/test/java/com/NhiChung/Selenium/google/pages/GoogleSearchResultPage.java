package com.NhiChung.Selenium.google.pages;

import com.NhiChung.Selenium.core.DriverWrapper;

/**
 *This is a google search result page class representation
 */
public class GoogleSearchResultPage extends BaseGooglePage{

    /**
     * method getTitle of the page
     *
     * @return String
     */
    public String getTitle() {
        return DriverWrapper.getDriver().getTitle();
    }
}
