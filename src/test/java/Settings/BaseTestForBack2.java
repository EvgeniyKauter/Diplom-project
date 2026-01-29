package Settings;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BaseTestForBack2 {

    protected static String token;
    protected static Integer createdBookingId;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        // Получение токена (если потребуется для тестов обновления или удаления)
        token = given()
                .contentType(ContentType.JSON)
                .body("{\"username\" : \"admin\", \"password\" : \"password123\"}")
                .when()
                .post("/auth")
                .then()
                .statusCode(200)
                .extract()
                .path("token");
        System.out.println("Токен: " + token);
    }
}
