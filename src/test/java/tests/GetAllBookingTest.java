package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import tests.Booking;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;

public class GetAllBookingTest {
    @Test
    public void getAllBookingsTest() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking";

        Response response = given()
                .header("Accept", "application/json")
                .when()
                .get("/booking")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .response();

        Booking[] bookings = response.getBody().as(Booking[].class);

    }
}
