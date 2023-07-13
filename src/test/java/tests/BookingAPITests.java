package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BookingAPITests {

    private String baseURI = "http://restful-booker.herokuapp.com/";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = baseURI;
    }

    @Test(priority = 1)
    public void createBookingTest() {
        String bookingData = "{\"firstname\":\"John\",\"lastname\":\"Doe\",\"totalprice\":100,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2023-07-15\",\"checkout\":\"2023-07-20\"},\"additionalneeds\":\"Breakfast\"}";

        given()
                .contentType(ContentType.JSON)
                .body(bookingData)
                .when()
                .post("/booking")
                .then()
                .statusCode(200);
    }

    @Test(priority = 2)
    public void getBookingIdsTest() {
        Response response = given()
                .when()
                .get("/booking")
                .then()
                .extract()
                .response();

    }

    @Test(priority = 3)
    public void updateBookingPriceTest() {
        // Внести ідентифікатор бронювання з тесту getBookingIdsTest
        int bookingId = 123;


    }

    @Test(priority = 4)
    public void updateBookingDetailsTest() {
        // Внести ідентифікатор бронювання з тесту getBookingIdsTest
        int bookingId = 456;


    }

    @Test(priority = 5)
    public void deleteBookingTest() {

        int bookingId = 789;

        given()
                .when()
                .delete("/booking/" + bookingId)
                .then()
                .statusCode(200);
    }
}

