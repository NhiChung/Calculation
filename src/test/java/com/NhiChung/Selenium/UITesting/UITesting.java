package com.NhiChung.Selenium.UITesting;

import com.NhiChung.Core.MyLogger;
import com.NhiChung.PageObject.BookingHomePage;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class UITesting extends BaseTest{
    @Test
    public void BookingCheck() {
        MyLogger.LOGGER.info("Verify search feature");

        new BookingHomePage()
                .chooseLanguage()
                .setTextToLocationField("Paris")
                .chooseMonth("February")
                .chooseDate(13, 15)
                .chooseAdult(2)
                .clickSearchButton()
                .checkLocationSearchResult("Paris");

        MyLogger.LOGGER.info("Search feature do well");
    }
}
