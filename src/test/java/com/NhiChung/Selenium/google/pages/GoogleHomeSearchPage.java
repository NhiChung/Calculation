package com.NhiChung.Selenium.google.pages;

import com.NhiChung.Selenium.core.DriverWrapper;
import com.NhiChung.Selenium.core.logger.MyLogger;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
*This is a google search home page class representation
*/
public class GoogleHomeSearchPage extends BaseGooglePage{
    private WebElement googleLoginButton = DriverWrapper.getDriver().findElement(By.xpath("//*[@id=\"gb\"]/div/div[2]/a"));
    private WebElement googleSearchField = DriverWrapper.getDriver().findElement(By.name("q"));

    /**
     * method send %text% to the google search field
     *
     * @param text - string variable representing the text we will input into the search field
     * @return GoogleHomeSearchPage .this
     */
    @Step("Enter Search Field with text: [0]")
    public GoogleHomeSearchPage setTextToSearchField(String text) {
        MyLogger.LOGGER.info(String.format("Set %s to Search field ", text));
        /**
         * sending keys
         */
        googleSearchField.sendKeys(text);

        int waitTime = 500;
        MyLogger.LOGGER.info(String.format("waiting for the page to load for " + waitTime));
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return this;
    }

    /**
     * method go to the result page
     *
     * @return GoogleSearchResultPage
     */
    public GoogleSearchResultPage clickGoogleSearchButton() {
        MyLogger.LOGGER.info("click Google Search button");
        googleSearchField.submit();

        int waitTime = 500;
        MyLogger.LOGGER.info(String.format("waiting for the page to load for " + waitTime));
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new GoogleSearchResultPage();
    }

    /**
     * method go to translate page
     *
     * @return GoogleTranslatePage
     */
    public GoogleTranslatePage goToTranslatePage() {
        googleSearchField.submit();

        MyLogger.LOGGER.info("Go to Translate page");
        return new GoogleTranslatePage();
    }

    /**
     * method go to translate page
     *
     * @return GoogleColorPickerPage
     */
    public GoogleColorPickerPage goToColorPickerPage() {
        googleSearchField.submit();

        MyLogger.LOGGER.info("Go o Color Picker page");
        return new GoogleColorPickerPage();
    }

    /**
     * method go to Calculator page
     *
     * @return GoogleCalculatorPage
     */
    public GoogleCalculatorPage goToCalculatorPage() {
        googleSearchField.submit();

        MyLogger.LOGGER.info("Go to Calculator page");
        return new GoogleCalculatorPage();
    }

}
