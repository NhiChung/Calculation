package com.NhiChung.Selenium.PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;

public class BookingResultPage {

    private SelenideElement searchLocationField = $(By.name("ss"));

    public void checkLocationSearchResult(String text) {
        searchLocationField.shouldHave(value(text));
    }
}
