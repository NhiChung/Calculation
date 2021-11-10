package com.NhiChung.Selenium.selenium4;

import com.NhiChung.Selenium.core.logger.MyLogger;
import com.NhiChung.Selenium.google.pages.GoogleHomeSearchPage;
import com.NhiChung.Selenium.utils.Listeners.TestListener;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
@Epic("Regression Tests")
@Feature("Search Homepage Tests")
public class Selenium4Test extends SeleniumBaseTest {

    @Test
    public void testingChromeAndSeleniumBasic() {
        Assert.assertEquals(true, true);
    }

    @Test(priority = 0, description = "Search a normal test and get relative results")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: search with valid input")
    @Story("valid input")
    public void testingBasingSearchOnGoogleMainPage() {
        MyLogger.LOGGER.info("start hello");
        String title = new GoogleHomeSearchPage()
                .setTextToSearchField("Vietnam")
                .clickGoogleSearchButton().getTitle();
        Assert.assertTrue(title.contains("Vietnam"));
        MyLogger.LOGGER.info("finish hello");
    }

    @Test
    void searchNormalText() {
        MyLogger.LOGGER.info("Start verify Search normal test");

        String title = new GoogleHomeSearchPage()
                .setTextToSearchField("Vietnam")
                .clickGoogleSearchButton()
                .getTitle();
        Assert.assertTrue(title.contains("Vietnam"));

        MyLogger.LOGGER.info("Pass");
    }

    @Test
    void trimText() {
        // Trim method() is the method returns a new string, without any of the leading or the trailing white spaces.
        MyLogger.LOGGER.info("Start verify trim function of search field");

        String title = new GoogleHomeSearchPage()
                .setTextToSearchField("        Vietnam       ")
                .clickGoogleSearchButton().getTitle();
        Assert.assertTrue(title.contains("Vietnam"));

        MyLogger.LOGGER.info("Pass");
    }

    @Test
    void googleCalculator() {
        MyLogger.LOGGER.info("Verify Google Calculator");
        String result = new GoogleHomeSearchPage()
                .setTextToSearchField("1+5")
                .goToCalculatorPage()
                .getCalculatorResult();

        Assert.assertTrue(result.equals("6"));
        MyLogger.LOGGER.info("Pass");
    }

    @Test
    void googleTranslate() {
        MyLogger.LOGGER.info("Verify google Translate");

        String result = new GoogleHomeSearchPage()
                .setTextToSearchField("translate")
                .goToTranslatePage()
                .getTranslateResult("xin chao");

        Assert.assertTrue(result.equals("hello") || result.equals("Hello") || result.equals("Hi") || result.equals("Hi"));

        MyLogger.LOGGER.info("Pass");
    }

    @Test
    void googleTranslate2() {
        MyLogger.LOGGER.info("Verify google Translate");

        String result = new GoogleHomeSearchPage()
                .setTextToSearchField("Vietnamese to English")
                .goToTranslatePage()
                .getTranslateResult("Xin chao");

        Assert.assertTrue(result.equals("hello") || result.equals("Hello") || result.equals("Hi") || result.equals("Hi"));

        MyLogger.LOGGER.info("Pass");
    }

    @Test
    void colorPicker() {
        MyLogger.LOGGER.info("Verify google Color Picker");

        new GoogleHomeSearchPage()
                .setTextToSearchField("color picker")
                .goToColorPickerPage()
                .changeColorPicker("kyN4Jf3TGqF__slider-background");

        Assert.assertEquals(true, true);
        MyLogger.LOGGER.info("Pass");

    }
}
