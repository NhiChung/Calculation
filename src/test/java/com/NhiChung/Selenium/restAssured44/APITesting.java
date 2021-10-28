package com.NhiChung.Selenium.restAssured44;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class APITesting extends RestAssuredBaseTest{

    @Test
    public void Current_checkStatusCode () {
        String baseUrl = "http://api.weatherapi.com/v1";
        RequestSpecBuilder spec = new RequestSpecBuilder();
        spec
                .setBaseUri(baseUrl)
                .addParam("key", "29bebb4c6e3844ffafe115519210709")
                .addParam("q", "VietNam");
        Response rp = RestAssured.given(spec.build()).get("/current.json");

        rp.then().assertThat().log().all().statusCode(200);

    }

    @Test
    public void Forecast_checkStatusCode_PositiveTest () {
        String baseUrl = "http://api.weatherapi.com/v1";
        RequestSpecBuilder spec = new RequestSpecBuilder();
        spec
                .setBaseUri(baseUrl)
                .addParam("key", "29bebb4c6e3844ffafe115519210709")
                .addParam("q", "VietNam")
                .addParam("days", "5")
                .addParam("api", "no")
                .addParam("alerts", "no");
        Response rp = RestAssured.given(spec.build()).get("/forecast.json");

        rp.then().assertThat().log().all().statusCode(200);

    }

    @Test
    public void Forecast_checkStatusCode_NegativeTest () {
        String baseUrl = "http://api.weatherapi.com/v1";
        RequestSpecBuilder spec = new RequestSpecBuilder();
        spec
                .setBaseUri(baseUrl)
                .addParam("key", "29bebb4c6e3844ffafe115519210709")
                .addParam("q", "VietNam")
                .addParam("days", "VietNam")
                .addParam("api", "VietNam")
                .addParam("alerts", "VietNam");
        Response rp = RestAssured.given(spec.build()).get("/forecast.json");

        rp.then().assertThat().log().all().statusCode(200);

    }

    @Test
    public void Forecast_checkStatusCode_NegativeTest2 () {
        String baseUrl = "http://api.weatherapi.com/v1";
        RequestSpecBuilder spec = new RequestSpecBuilder();
        spec
                .setBaseUri(baseUrl)
                .addParam("key", "29bebb4c6e3844ffafe115519210709")
                .addParam("q", "VietNam");
        Response rp = RestAssured.given(spec.build()).get("/forecast.json");

        rp.then().assertThat().log().all().statusCode(200);

    }

    @Test
    public void Current_checkReponseResult () {
        String baseUrl = "http://api.weatherapi.com/v1";
        RequestSpecBuilder spec = new RequestSpecBuilder();
        spec
                .setBaseUri(baseUrl)
                .addParam("key", "29bebb4c6e3844ffafe115519210709")
                .addParam("q", "VietNam");
        Response rp = RestAssured.given(spec.build()).get("/current.json");

        rp.then().assertThat().log().all().body("location.name", Matchers.equalTo("Hanoi"));

    }

    @Test
    public void Timezone_checkStatusCode_PositiveTest () {
        String baseUrl = "http://api.weatherapi.com/v1";
        RequestSpecBuilder spec = new RequestSpecBuilder();
        spec
                .setBaseUri(baseUrl)
                .addParam("key", "29bebb4c6e3844ffafe115519210709")
                .addParam("q", "VietNam");
        Response rp = RestAssured.given(spec.build()).get("/timezone.json");

        rp.then().assertThat().log().all().statusCode(200);

    }

    @Test
    public void Timezone_checkStatusCode_NegativeTest () {
        String baseUrl = "http://api.weatherapi.com/v1";
        RequestSpecBuilder spec = new RequestSpecBuilder();
        spec
                .setBaseUri(baseUrl)
                .addParam("key", "29bebb4c6e3844ffafe115519210709")
                .addParam("q", "VietNam")
                .addParam("days", "VietNam")
                .addParam("api", "VietNam")
                .addParam("alerts", "VietNam");
        Response rp = RestAssured.given(spec.build()).get("/timezone.json");

        rp.then().assertThat().log().all().statusCode(200);

    }

    @Test
    public void Timezone_checkResponseResult_PositiveTest () {
        String baseUrl = "http://api.weatherapi.com/v1";
        RequestSpecBuilder spec = new RequestSpecBuilder();
        spec
                .setBaseUri(baseUrl)
                .addParam("key", "29bebb4c6e3844ffafe115519210709")
                .addParam("q", "VietNam");
        Response rp = RestAssured.given(spec.build()).get("/timezone.json");

        rp.then().assertThat().log().all().body("location.name", Matchers.equalTo("Hanoi"));

    }

    @Test
    public void Timezone_checkResponseResult_NegativeTest () {
        String baseUrl = "http://api.weatherapi.com/v1";
        RequestSpecBuilder spec = new RequestSpecBuilder();
        spec
                .setBaseUri(baseUrl)
                .addParam("key", "29bebb4c6e3844ffafe115519210709")
                .addParam("q", "VietNam")
                .addParam("days", "VietNam")
                .addParam("api", "VietNam")
                .addParam("alerts", "VietNam");
        Response rp = RestAssured.given(spec.build()).get("/timezone.json");

        rp.then().assertThat().log().all().body("location.name", Matchers.equalTo("Hanoi"));

    }

}
