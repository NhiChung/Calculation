package com.NhiChung.Selenium.UITesting.Test;

import com.NhiChung.Core.MyLogger;
import com.NhiChung.Selenium.UITesting.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import main.java.com.NhiChung.PageObject.BookingHomePage;
import org.testng.annotations.Test;

public class TestStaysTab extends BaseTest {

//    @Test(dataProvider = "dp", priority = 1, description = "Search a normal test and get relative results")
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("Test Description: search with valid input")
//    public void BookingCheck(String location, String month, int startDate, int endDate, int adult, String locationResult, String browser) {
//        preCondition(browser);
//        MyLogger.LOGGER.info("Verify search feature");
//        new BookingHomePage()
//                .chooseLanguage()
//                .setTextToLocationField(location)
//                .chooseMonth(month)
//                .chooseDate(startDate, endDate)
//                .chooseAdult(adult)
//                .clickSearchButton()
//                .checkLocationSearchResult(locationResult);
//
//        MyLogger.LOGGER.info("Search feature do well");
//    }

    @Test(dataProvider = "browser", priority = 1, description = "Search a normal test and get relative results")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: search with valid input")
    public void BookingCheck(String browser) {
        preCondition(browser);
        MyLogger.LOGGER.info("Verify search feature");
        new BookingHomePage()
                .chooseLanguage()
                .setTextToLocationField("Ha Noi")
                .chooseMonth("February")
                .chooseDate(13, 15)
                .chooseAdult(2)
                .clickSearchButton()
                .checkLocationSearchResult("Ha Noi");

        MyLogger.LOGGER.info("Search feature do well");
    }
}
