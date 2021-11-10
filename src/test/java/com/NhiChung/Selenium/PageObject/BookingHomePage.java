package com.NhiChung.Selenium.PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BookingHomePage {
    private SelenideElement searchDateField = $(By.xpath("//*[@data-mode=\"checkin\"]"));
    private SelenideElement buttonCalendarNext = $(By.xpath("//*[@data-bui-ref=\"calendar-next\"]"));
    private SelenideElement searchDateLabel = $(".bui-calendar__month");
    private SelenideElement fromDate;
    private SelenideElement toDate;
    private SelenideElement searchAdultField = $(".xp__guests__count");
    private SelenideElement searchAdultLabel = $(By.xpath("//*[@data-bui-ref=\"input-stepper-value\"]"));
    private SelenideElement searchAdultDecreaseButton = $(By.xpath("//*[@data-bui-ref=\"input-stepper-subtract-button\"]"));
    private SelenideElement searchAdultIncreaseButton = $(By.xpath("//*[@data-bui-ref=\"input-stepper-add-button\"]"));
;
    private SelenideElement searchButton = $(".sb-searchbox__button ");
    private SelenideElement buttonShowLanguageModal = $(By.xpath("//*[@data-modal-id=\"language-selection\"]"));
    private SelenideElement buttonEnglishLanguage = $(By.xpath("//*[@data-lang=\"en-gb\"]"));
    private SelenideElement searchLocationField = $(By.name("ss"));

    public BookingHomePage chooseLanguage() {
        buttonShowLanguageModal.click();
        buttonEnglishLanguage.click();
        return this;
    }


    public BookingHomePage setTextToLocationField(String text) {
        searchLocationField.setValue(text);

        return this;
    }

    public BookingHomePage chooseMonth(String text) {
        searchDateField.click();

        String month = searchDateLabel.getText().split(" ")[0];
        while (!month.equals(text)) {
            buttonCalendarNext.click();
            month = searchDateLabel.getText().split(" ")[0];
        }

        return this;
    }

    public BookingHomePage chooseDate(int from, int to) {
        String xpathFromDate = "//span[text()='" + from + "']";
        String xpathToDate = "//span[text()='" + to + "']";

        fromDate = $(By.xpath(xpathFromDate));
        toDate = $(By.xpath(xpathToDate));
        fromDate.click();
        toDate.click();

        return this;
    }

    public BookingHomePage chooseAdult(int value) {

        searchAdultField.click();

        int adult = Integer.parseInt(searchAdultLabel.getText());
        while (adult != value) {
            if (adult > value) {
                searchAdultDecreaseButton.click();
                adult--;
            } else if (adult < value) {
                searchAdultIncreaseButton.click();
                adult++;
            }
        }

        return this;
    }

    public BookingResultPage clickSearchButton() {
        searchButton.click();

        return new BookingResultPage();
    }
}
