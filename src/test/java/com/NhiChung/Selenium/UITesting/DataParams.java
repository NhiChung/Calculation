package com.NhiChung.Selenium.UITesting;

import org.testng.annotations.DataProvider;
import org.testng.collections.Lists;

import java.util.Arrays;
import java.util.List;

public class DataParams {
    private final String env = System.getProperty("environment");
    public String baseURL = "https://www.booking.com/";

    @DataProvider(name = "browser")
    public Object[][] testBrowsers(){
        if (env.equals("ALL") || env == null) {
            return new Object[][]{
                    {"EDGE"},{"FIREFOX"},{"CHROME"}
            };
        } else {
            return new Object[][]{{env}};
        }
    }

    @DataProvider(name = "test-data")
    public Object[][] testData(){
        return new Object[][]{
                {"Hanoi", "February", 13, 15, 2, "Hanoi"},
                {"Paris", "November", 25, 30, 3, "Paris"},
                {"Tokyo", "December", 10, 20, 1, "Tokyo"},
        };
    }

    /*@DataProvider(name="dp")
    public Object[][] dataProvider() {
        List<Object[]> result = Lists.newArrayList();
        result.addAll(Arrays.asList(testData()));
        result.addAll(Arrays.asList(testBrowsers()));
        return result.toArray(new Object[result.size()][]);
    }*/
}
