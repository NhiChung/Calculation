package com.NhiChung.Selenium.restAssured44;

import com.NhiChung.Selenium.restAssured44.model.Authen;
import com.NhiChung.Selenium.restAssured44.model.User;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class ReqresTesting extends RestAssuredBaseTest {
    String BaseURL = "https://reqres.in/api";

    @Test
    public void getListUsers() {
        String endpoint = BaseURL + "/users";
        RestAssured.given()
                .queryParam("page", 2)
                .when().get(endpoint)
                .then().assertThat()
                .statusCode(200)
                .body("page", Matchers.equalTo(2))
                .body("data[0].id", Matchers.equalTo(7));

    }

    @Test
    public void getSingleUser() {
        int id = 2;
        String endpoint = BaseURL + "/users/" + id;
        RestAssured.given()
                .when().get(endpoint)
                .then().assertThat()
                .statusCode(200)
                .body("data.email", Matchers.equalTo("janet.weaver@reqres.in"))
                .body("data.id", Matchers.equalTo(2));
    }

    @Test
    public void getSingleUserNotFound() {
        int id = 23;
        String endpoint = BaseURL + "/users/" + id;
        RestAssured.given()
                .when().get(endpoint)
                .then().assertThat()
                .statusCode(404);
    }

    @Test
    public void getListResource() {
        String endpoint = BaseURL + "/unknown";
        RestAssured.given()
                .when().get(endpoint)
                .then().assertThat()
                .statusCode(200)
                .body("data[0].name", Matchers.equalTo("cerulean"))
                .body("data[1].year", Matchers.equalTo(2001))
                .body("data[2].color", Matchers.equalTo("#BF1932"))
                .body("page", Matchers.equalTo(1))
                .body("total_pages", Matchers.equalTo(2));

    }

    @Test
    public void getSingleResource() {
        int id = 2;
        String endpoint = BaseURL + "/unknown/" + id;
        RestAssured.given()
                .when().get(endpoint)
                .then().assertThat()
                .statusCode(200)
                .body("data.name", Matchers.equalTo("fuchsia rose"))
                .body("data.year", Matchers.equalTo(2001))
                .body("data.color", Matchers.equalTo("#C74375"))
                .body("support.url", Matchers.equalTo("https://reqres.in/#support-heading"))
                .body("support.text", Matchers.equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

    }

    @Test
    public void getSingleResourceNotFound() {
        int id = 23;
        String endpoint = BaseURL + "/unknown/" + id;
        RestAssured.given()
                .when().get(endpoint)
                .then().assertThat()
                .statusCode(404);
    }

    @Test
    public void createUser() {
        String endpoint = BaseURL + "/users";
        String name = "nhi chung12";
        String job = "tester";
        User user = new User(name, job);
        RestAssured.given().header("Content-Type", "application/json").body(user)
                .when().post(endpoint)
                .then().assertThat()
                .statusCode(201)
                .body("name", Matchers.equalTo(name))
                .body("job", Matchers.equalTo(job));

    }

    @Test
    public void updateUser() {
        int id = 2;
        String endpoint = BaseURL + "/users/" + id;
        String name = "nhi chung";
        String job = "newbie";
        User user = new User(name, job);
        RestAssured.given().header("Content-Type", "application/json").body(user)
                .when().put(endpoint)
                .then().assertThat()
                .statusCode(200)
                .body("name", Matchers.equalTo(name))
                .body("job", Matchers.equalTo(job));

    }

    @Test
    public void deleteUser() {
        int id = 2;
        String endpoint = BaseURL + "/users/" + id;
        RestAssured.given()
                .when().delete(endpoint)
                .then().assertThat()
                .statusCode(204);

    }

    @Test
    public void registerNewUser() {
        String endpoint = BaseURL + "/register";
        String email = "nhi_chung123@epam.com";
        String password = "nhi2602";
        Authen authen = new Authen(email, password);
        RestAssured.given().header("Content-Type", "application/json")
                .body(authen)
                .when().post(endpoint)
                .then().assertThat()
                .statusCode(200);

    }

    @Test
    public void Register_unSuccessful() {
        String endpoint = BaseURL + "/register";
        String email = "nhi_chung@epam.com";
        Authen authen = new Authen(email);
        RestAssured.given().header("Content-Type", "application/json")
                .body(authen)
                .when().post(endpoint)
                .then().assertThat()
                .statusCode(400);

    }

    @Test
    public void Login() {
        String endpoint = BaseURL + "/login";
        String email = "eve.holt@reqres.in";
        String password = "cityslicka";
        Authen authen = new Authen(email, password);
        RestAssured.given().header("Content-Type", "application/json")
                .body(authen)
                .when().post(endpoint)
                .then().assertThat()
                .statusCode(200);

    }

    @Test
    public void Login_unSuccessful() {
        String endpoint = BaseURL + "/register";
        String email = "nhi_chung@epam.com";
        Authen authen = new Authen(email);
        RestAssured.given().header("Content-Type", "application/json")
                .body(authen)
                .when().post(endpoint)
                .then().assertThat()
                .statusCode(400);

    }

    @Test
    public void delayResponse() {
        int timeout = 3;
        String endpoint = BaseURL + "/users";
        RestAssured.given().header("Content-Type", "application/json")
                .queryParam("delay", timeout)
                .when().get(endpoint)
                .then().assertThat()
                .statusCode(200)
                .body("total_pages", Matchers.equalTo(2))
                .body("data[0].id", Matchers.equalTo(1));

    }
}
