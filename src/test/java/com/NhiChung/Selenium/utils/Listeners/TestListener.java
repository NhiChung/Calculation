package com.NhiChung.Selenium.utils.Listeners;

import com.NhiChung.Selenium.BaseTest;
import com.NhiChung.Selenium.core.DriverWrapper;
import com.NhiChung.Selenium.core.logger.MyLogger;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseTest implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    //Text attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG (WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    //Text attachments for Allure
    @Attachment (value = "(0)", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        MyLogger.LOGGER.info("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
        saveScreenshotPNG(DriverWrapper.getDriver());
    }
}
