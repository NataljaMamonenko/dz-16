package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class UpdateBookingDetailsTest {
    private static final String TOKEN = "abc123";

    @Test
    public void updateBookingDetailsTest() {
        int bookingId = 919;

        JSONObject body = new JSONObject();
        body.put("firstname", "John");
        body.put("additionalneeds", "Extra pillows");

        Response updatedBooking = RestAssured.given()
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .cookie(TOKEN, TOKEN)
                .body(body.toString())
                .when()
                .put("/booking/" + bookingId);

        updatedBooking.prettyPrint();
        updatedBooking.then().statusCode(200);
    }
}
