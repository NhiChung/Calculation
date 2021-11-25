package com.NhiChung.PageObject;

import com.NhiChung.Core.MyLogger;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;

public class BookingResultPage {

    private SelenideElement searchLocationField = $(By.name("ss"));

    public void checkLocationSearchResult(String text) {
        MyLogger.LOGGER.info("Check the location result: " + text);
        searchLocationField.shouldHave(value(text));
    }
}
