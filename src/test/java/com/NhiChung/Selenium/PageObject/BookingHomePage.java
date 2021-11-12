package com.NhiChung.Selenium.PageObject;

import com.NhiChung.Selenium.Core.MyLogger;
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
        MyLogger.LOGGER.info("Open the Language Modal");
        buttonShowLanguageModal.click();

        MyLogger.LOGGER.info("Choose Language: English");
        buttonEnglishLanguage.click();
        return this;
    }


    public BookingHomePage setTextToLocationField(String text) {
        MyLogger.LOGGER.info("Search Location: " + text);
        searchLocationField.setValue(text);

        return this;
    }

    public BookingHomePage chooseMonth(String text) {
        MyLogger.LOGGER.info("Open Date Picker");
        searchDateField.click();

        MyLogger.LOGGER.info("Select Month: " + text);
        String month = searchDateLabel.getText().split(" ")[0];

        while (!month.equals(text)) {
            MyLogger.LOGGER.info("This month isn't expected month: " + month);
            MyLogger.LOGGER.info("Click next button to check next month");
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

        MyLogger.LOGGER.info("From date" + from + "to date" + to);
        fromDate.click();
        toDate.click();

        return this;
    }

    public BookingHomePage chooseAdult(int value) {
        MyLogger.LOGGER.info("Open person modal");
        searchAdultField.click();

        int adult = Integer.parseInt(searchAdultLabel.getText());
        MyLogger.LOGGER.info("Number of adults current: " + adult);

        while (adult != value) {
            if (adult > value) {
                MyLogger.LOGGER.info("Decrease number of adults");
                searchAdultDecreaseButton.click();
                adult--;
            } else if (adult < value) {
                MyLogger.LOGGER.info("Increase number of adults");
                searchAdultIncreaseButton.click();
                adult++;
            }
            MyLogger.LOGGER.info("Number of adults current: " + adult);
        }

        return this;
    }

    public BookingResultPage clickSearchButton() {
        MyLogger.LOGGER.info("Click search button");
        searchButton.click();

        return new BookingResultPage();
    }
}
