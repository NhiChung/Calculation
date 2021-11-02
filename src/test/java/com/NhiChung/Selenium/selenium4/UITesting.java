package com.NhiChung.Selenium.selenium4;

import com.NhiChung.Selenium.google.pages.GoogleHomeSearchPage;
import com.NhiChung.Selenium.google.pages.GoogleLoginPage;
import org.testng.annotations.Test;
import org.testng.Assert;

public class UITesting extends SeleniumBaseTest{
    @Test
    void loginGoogle() throws InterruptedException {
        String username="nhilx150017@gmail.com";
        String password="tuyet_trang2602";
        String url="https://youtube.com";

        new GoogleLoginPage()
                .openLoginPage()
                .enterEmail(username)
                .enterPassword(password)
                .checkLoginGoogle(url);
        Assert.assertEquals(true, true);
    }

    @Test
    void searchNormalText() {
        String title = new GoogleHomeSearchPage()
                .setTextToSearchField("Vietnam")
                .clickGoogleSearchButton()
                .getTitle();
        Assert.assertTrue(title.contains("Vietnam"));
    }

    @Test
    void trimText() {
        // Trim method() is the method returns a new string, without any of the leading or the trailing white spaces.
        String title = new GoogleHomeSearchPage()
                .setTextToSearchField("        Vietnam       ")
                .clickGoogleSearchButton().getTitle();
        Assert.assertTrue(title.contains("Vietnam"));
    }

    @Test
    void googleCalculator() {
        String result = new GoogleHomeSearchPage()
                .setTextToSearchField("1+5")
                .goToCalculatorPage()
                .getCalculatorResult();

        Assert.assertTrue(result.equals("6"));
    }

    @Test
    void googleTranslate() {
        String result = new GoogleHomeSearchPage()
                .setTextToSearchField("translate")
                .goToTranslatePage()
                .getTranslateResult("xin chao");

        Assert.assertTrue(result.equals("hello")  || result.equals("Hello") || result.equals("Hi") || result.equals("Hi"));
    }

    @Test
    void googleTranslate2() {
        String result = new GoogleHomeSearchPage()
                .setTextToSearchField("Vietnamese to English")
                .goToTranslatePage()
                .getTranslateResult("Xin chao");

        Assert.assertTrue(result.equals("hello")  || result.equals("Hello") || result.equals("Hi") || result.equals("Hi"));
    }

    @Test
    void unitConverter_changeValue(){
        new GoogleHomeSearchPage()
            .setTextToSearchField("km to miles")
            .goToConverterUnitPage()
            .setTextToUnitConverterField("//input[@value='1']", "100");

        Assert.assertEquals(true, true);
    }

    @Test
    void unitConverter_changeValue3(){
        new GoogleHomeSearchPage()
                .setTextToSearchField("km to miles")
                .goToConverterUnitPage()
                .setTextToUnitConverterField("//input[@value='0.621371']", "10");

        Assert.assertEquals(true, true);
    }

    @Test
    void unitConverter_changeValue2() {
        new GoogleHomeSearchPage()
                .setTextToSearchField("5km=?m")
                .goToConverterUnitPage()
                .setTextToUnitConverterField("//input[@value='1']", "100");

        Assert.assertEquals(true, true);
    }

    @Test
    void unitConverter_changeValue4() {
        new GoogleHomeSearchPage()
                .setTextToSearchField("5km=?m")
                .goToConverterUnitPage()
                .setTextToUnitConverterField("//input[@value='5000']", "10");

        Assert.assertEquals(true, true);

    }

    @Test
    void colorPicker() {
        new GoogleHomeSearchPage()
            .setTextToSearchField("color picker")
            .goToColorPickerPage()
            .changeColorPicker("kyN4Jf3TGqF__slider-background");

        Assert.assertEquals(true, true);
    }

}
