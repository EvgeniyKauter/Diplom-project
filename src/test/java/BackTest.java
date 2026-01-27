import Settings.BaseTestForBack;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BackTest extends BaseTestForBack {

    private int createdBookingId; // ID созданного бронирования
    private static String token;

    @Test
    @Order(1)
    public void testCreateBooking() {

        String bookingJson = "{ \"firstname\" : \"Ivan\", \"lastname\" : \"Petrov\", " +
                "\"totalprice\" : 150, \"depositpaid\" : true, " +
                "\"bookingdates\" : {\"checkin\" : \"2023-10-01\", \"checkout\" : \"2023-10-10\"}, " +
                "\"additionalneeds\" : \"Breakfast\" }";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(bookingJson)
                .post("/booking");
        response.then()
                .statusCode(200)
                .body("bookingid", notNullValue());

        createdBookingId = response.jsonPath().getInt("bookingid");
        Assertions.assertTrue(createdBookingId > 0, "Booking ID should be positive");
    }

    @Test
    @Order(2)
    public void testGetBooking() {
        Assumptions.assumeTrue(createdBookingId > 0, "Create booking first");
        RestAssured.get("/booking/" + createdBookingId)
                .then()
                .statusCode(200)
                .body("firstname", equalTo("Ivan"))
                .body("lastname", equalTo("Petrov"));
    }

    @Test
    @Order(3)
    public void testUpdateBooking() {
        Assumptions.assumeTrue(createdBookingId > 0, "Create booking first");
        String updateJson = "{ \"firstname\" : \"Ivan\", \"lastname\" : \"Petrov\", " +
                "\"totalprice\" : 200, \"depositpaid\" : true, " +
                "\"bookingdates\" : {\"checkin\" : \"2023-10-05\", \"checkout\" : \"2023-10-15\"}, " +
                "\"additionalneeds\" : \"Lunch\" }";

        RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                //.cookie("token", token)
                .body(updateJson)
                .put("/booking/" + createdBookingId);

//        RestAssured.given()
//                .contentType(ContentType.JSON)
//                .header("Cookie", "token=" + token)
//                .body(updateJson)
//                .put("/booking/" + createdBookingId)
//                .then()
//                .statusCode(200)
//                .body("totalprice", equalTo(200))
//                .body("additionalneeds", equalTo("Lunch"));
    }

    @Test
    @Order(4)
    public void testDeleteBooking() {
        Assumptions.assumeTrue(createdBookingId > 0, "Create booking first");

        Response deleteResponse = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .delete("/booking/" + createdBookingId);

        System.out.println("Токен: " + token);
        System.out.println("Status code after delete: " + deleteResponse.getStatusCode());

        // Проверка успешного удаления (подставьте правильный статус, например, 200 или 204)
        assertEquals(200, deleteResponse.getStatusCode());

        // Проверка, что бронирование больше не существует
        RestAssured.get("/booking/" + createdBookingId)
                .then()
                .statusCode(404);
    }

//    public void testDeleteBooking() {
//        Assumptions.assumeTrue(createdBookingId > 0, "Create booking first");
//
//        RestAssured.given()
////                .header("Cookie", "token=" + token)
//                .header("Authorization", "Bearer " + token)
//                .delete("/booking/" + createdBookingId)
//                .then()
//                .statusCode(200);
//
//        Response deleteResponse = RestAssured.given()
//                .header("Authorization", "Bearer " + token)
//                .delete("/booking/" + createdBookingId);
//
//        System.out.println("Status code after delete: " + deleteResponse.getStatusCode());
//
//        // Проверка, что бронирование удалено
//        RestAssured.get("/booking/" + createdBookingId)
//                .then()
//                .statusCode(404);
//    }
}
