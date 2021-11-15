package main.java.com.NhiChung.google.pages;

import main.java.com.NhiChung.core.DriverWrapper;
import main.java.com.NhiChung.google.pages.BaseGooglePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *This is a google color picker page class representation
 */
public class GoogleColorPickerPage extends BaseGooglePage {
    private WebElement googleColorPicker;

    /**
     * method go to Calculator page
     *
     * @param id string variable representing the element we will click on the color picker field
     * @return GoogleCalculatorPage
     */
    public void changeColorPicker(String id) {
        googleColorPicker = DriverWrapper.getDriver().findElement(By.id(id));
    }

}
