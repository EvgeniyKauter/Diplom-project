package Settings;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

public class BaseTestForBack {

    private static final String BASE_URL = "https://restful-booker.herokuapp.com";
    private static String token; // Для хранения авторизационного токена

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = BASE_URL;
        // Получение токена для дальнейших операций
        String authPayload = "{ \"username\" : \"admin\", \"password\" : \"password123\" }";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(authPayload)
                .post("/auth");
        response.then().statusCode(200);
        token = response.jsonPath().getString("token");
        Assertions.assertNotNull(token, "Token should not be null");
    }


}
