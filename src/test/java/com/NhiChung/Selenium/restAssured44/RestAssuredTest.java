package com.NhiChung.Selenium.restAssured44;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class RestAssuredTest extends RestAssuredBaseTest {
    @Test
    public void TestingAssuered () {
        String baseUrl = "http://api.weatherapi.com/v1";
        RequestSpecBuilder spec = new RequestSpecBuilder();
        spec
                .setBaseUri(baseUrl)
                .addParam("key", "29bebb4c6e3844ffafe115519210709")
                .addParam("q", "Lviv")
                .addParam("days", "1");
        Response rp = RestAssured.given(spec.build()).get("/current.json");

//        log.info("Nhi Chung");
        rp.then().assertThat().log().all().body("location.name", equalTo("Lviv"));
    }
}
