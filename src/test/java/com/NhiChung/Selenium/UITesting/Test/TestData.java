package com.NhiChung.Selenium.UITesting.Test;

import com.NhiChung.Core.MyLogger;
import com.NhiChung.Selenium.UITesting.BaseTest;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import main.java.com.NhiChung.PageObject.BookingHomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.open;

public class TestData extends BaseTest {
    @BeforeMethod
    public void preCondition() {
        Configuration.reportsFolder = "test-result/reports";
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        open(baseURL);
    }

    @AfterMethod
    public void postCondition() {
        clearBrowserCookies();
    }

    @Test(dataProvider = "test-data", priority = 1, description = "Search a normal test and get relative results")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: search with valid input")
    public void BookingCheck(String location, String month, int startDate, int endDate, int adult, String locationResult) {
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
