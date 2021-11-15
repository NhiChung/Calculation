package main.java.com.NhiChung.google.pages;

import main.java.com.NhiChung.core.DriverWrapper;

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
