package com.NhiChung.Selenium.selenium4;

import com.NhiChung.Selenium.google.pages.GoogleHomeSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium4Test extends SeleniumBaseTest {
    @Test
    public void testingChromeAndSeleniumBasic() {
        Assert.assertEquals(true, true);
    }

    @Test
    public void testingBasingSearchOnGoogleMainPage() {
        log.info("start hello");
        String title = new GoogleHomeSearchPage()
                .setTextToSearchField("Vietnam")
                .clickGoogleSearchButton().getTitle();
        Assert.assertTrue(title.contains("Vietnam"));
        log.info("finish hello");
    }

    @Test
    void searchNormalText() {
        log.info("Start verify Search normal test");

        String title = new GoogleHomeSearchPage()
                .setTextToSearchField("Vietnam")
                .clickGoogleSearchButton()
                .getTitle();
        Assert.assertTrue(title.contains("Vietnam"));

        log.info("Pass");
    }

    @Test
    void trimText() {
        // Trim method() is the method returns a new string, without any of the leading or the trailing white spaces.
        log.info("Start verify trim function of search field");

        String title = new GoogleHomeSearchPage()
                .setTextToSearchField("        Vietnam       ")
                .clickGoogleSearchButton().getTitle();
        Assert.assertTrue(title.contains("Vietnam"));

        log.info("Pass");
    }

    @Test
    void googleCalculator() {
        log.info("Verify Google Calculator");
        String result = new GoogleHomeSearchPage()
                .setTextToSearchField("1+5")
                .goToCalculatorPage()
                .getCalculatorResult();

        Assert.assertTrue(result.equals("6"));
        log.info("Pass");
    }

    @Test
    void googleTranslate() {
        log.info("Verify google Translate");

        String result = new GoogleHomeSearchPage()
                .setTextToSearchField("translate")
                .goToTranslatePage()
                .getTranslateResult("xin chao");

        Assert.assertTrue(result.equals("hello")  || result.equals("Hello") || result.equals("Hi") || result.equals("Hi"));

        log.info("Pass");
    }

    @Test
    void googleTranslate2() {
        log.info("Verify google Translate");

        String result = new GoogleHomeSearchPage()
                .setTextToSearchField("Vietnamese to English")
                .goToTranslatePage()
                .getTranslateResult("Xin chao");

        Assert.assertTrue(result.equals("hello")  || result.equals("Hello") || result.equals("Hi") || result.equals("Hi"));

        log.info("Pass");
    }

    @Test
    void colorPicker() {
        log.info("Verify google Color Picker");

        new GoogleHomeSearchPage()
                .setTextToSearchField("color picker")
                .goToColorPickerPage()
                .changeColorPicker("kyN4Jf3TGqF__slider-background");

        Assert.assertEquals(true, true);
        log.info("Pass");

    }
}
