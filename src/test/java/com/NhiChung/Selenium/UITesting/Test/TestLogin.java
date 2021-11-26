package com.NhiChung.Selenium.UITesting.Test;

import com.NhiChung.Core.MyLogger;
import com.NhiChung.Selenium.UITesting.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import main.java.com.NhiChung.PageObject.BookingHomePage;
import org.testng.annotations.Test;

public class TestLogin extends BaseTest {

    @Test(dataProvider = "test-data", priority = 1, description = "Search a normal test and get relative results")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: search with valid input")
    public void Login(String location, String month, int startDate, int endDate, int adult, String locationResult, String browser) {
        MyLogger.LOGGER.info("Verify search feature");
        new BookingHomePage()
                .chooseLanguage()
                .setTextToLocationField(location)
                .chooseMonth(month)
                .chooseDate(startDate, endDate)
                .chooseAdult(adult)
                .clickSearchButton()
                .checkLocationSearchResult(locationResult);

        MyLogger.LOGGER.info("Search feature do well");
    }
}
