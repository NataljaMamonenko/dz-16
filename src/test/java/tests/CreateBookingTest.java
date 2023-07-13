package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CreateBookingTest{

    @Test
    public void createBookingTest() {
        RestAssured.baseURI = "http://restful-booker.herokuapp.com/";

        String bookingData = "{\"firstname\":\"John\",\"lastname\":\"Doe\",\"totalprice\":100,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2023-07-15\",\"checkout\":\"2023-07-20\"},\"additionalneeds\":\"Breakfast\"}";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .body(bookingData)
                .when()
                .post("/booking")
                .then()
                .extract()
                .response();

        if (response.statusCode() == 200) {
            int bookingId = response.jsonPath().getInt("bookingid");
            System.out.println("Бронювання створено успішно. ID бронювання: " + bookingId);
        } else {
            System.out.println("Сталася помилка при створенні бронювання. Відповідь сервера: " + response.getBody().asString());
        }
    }
}
