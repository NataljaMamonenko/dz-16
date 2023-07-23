package tests;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UpdateBookingPriceTest {

    @Test
    public void updateBookingPriceTest() {
        int bookingId = 1;
        String requestBody = "{\n" +
                "  \"totalprice\": 150\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .patch("/booking/" + bookingId)
                .then()
                .statusCode(200)
                .body("totalprice", equalTo(150));
    }

}
