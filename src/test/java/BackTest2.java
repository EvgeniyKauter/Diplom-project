import Settings.BaseTestForBack2;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import jdk.jfr.Description;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BackTest2 extends BaseTestForBack2 {


    @Test
    @Description("Создание бронирования")
    @Order(1)
    public void createBookingTest() {
        String requestBody = "{\n" +
                "  \"firstname\" : \"Dog\",\n" +
                "  \"lastname\" : \"Doe\",\n" +
                "  \"totalprice\" : 120,\n" +
                "  \"depositpaid\" : true,\n" +
                "  \"bookingdates\" : {\n" +
                "    \"checkin\" : \"2024-12-01\",\n" +
                "    \"checkout\" : \"2024-12-10\"\n" +
                "  },\n" +
                "  \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/booking")
                .then()
                .statusCode(200)
                .body("booking.firstname", equalTo("Dog"))
                .extract().response();

        createdBookingId = response.path("bookingid");
        System.out.println("Создано бронирование с ID: " + createdBookingId);
    }

    // 2. Получить бронирование по ID
    @Test
    @Description("Получить бронирование")
    @Order(2)
    public void getBookingTest() {

        given()
                .when()
                .get("/booking/{id}", createdBookingId)
                .then()
                .statusCode(200)
                .body("firstname", equalTo("Dog")); // пример проверки
    }

    // 3. Обновление бронирования по ID
    @Test
    @Description("Обновить бронирование")
    @Order(3)
    public void updateBookingTest() {

        String updateBody = "{\n" +
                "  \"firstname\" : \"UpdatedName\",\n" +
                "  \"lastname\" : \"Doe\",\n" +
                "  \"totalprice\" : 150,\n" +
                "  \"depositpaid\" : false,\n" +
                "  \"bookingdates\" : {\n" +
                "    \"checkin\" : \"2025-01-01\",\n" +
                "    \"checkout\" : \"2025-01-10\"\n" +
                "  },\n" +
                "  \"additionalneeds\" : \"Dinner\"\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + token) // авторизация
                .body(updateBody)
                .when()
                .put("/booking/{id}", createdBookingId)
                .then()
                .statusCode(200)
                .body("firstname", equalTo("UpdatedName"));
    }

    // 4. Удаление бронирования по ID
    @Test
    @Description("Удалить бронирование")
    @Order(4)
    public void deleteBookingTest() {

        given()
                .header("Cookie", "token=" + token)
                .when()
                .delete("/booking/{id}", createdBookingId)
                .then()
                .statusCode(201);
    }

    //mvn clean -Dtest=BackTest2 test
    //mvn allure:serve
}