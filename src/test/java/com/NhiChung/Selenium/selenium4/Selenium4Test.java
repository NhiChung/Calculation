package com.NhiChung.Selenium.selenium4;

import com.NhiChung.Selenium.google.pages.GoogleHomeSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium4Test extends SeleniumBaseTest {
    @Test
    public void testingChromeAndSeleniumBasic() {
        Assert.assertEquals(true, true);
    }

//    @Test
//    public void testingChromeAndSeleniumBasic() {
//        DriverWrapper.getDriver().navigate().to("https://mvnrepository.com/");
//        DriverWrapper.getDriver().quit();
//        Assert.assertEquals(true, true);
//    }

    @Test
    public void testingBasingSearchOnGoogleMainPage() {
        String title = new GoogleHomeSearchPage()
                .setTextToSearchField("Vietnam")
                .clickGoogleSearchButton().getTitle();
        Assert.assertTrue(title.contains("Vietnam"));
    }
}
