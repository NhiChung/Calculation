package com.NhiChung.Selenium.UITesting;

import com.NhiChung.Selenium.PageObject.BookingHomePage;
import org.testng.annotations.Test;

public class UITesting extends BaseTest{
    
    @Test
    public void BookingCheck2() {
        new BookingHomePage()
                .chooseLanguage()
                .setTextToLocationField("Paris")
                .chooseMonth("February")
                .chooseDate()
                .chooseAdult(2)
                .clickSearchButton()
                .checkLocationSearchResult("Paris");
    }
}
