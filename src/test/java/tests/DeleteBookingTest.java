package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteBookingTest {

    @Test
    public void deleteBookingTest() {
        int booking_Id = 3900;

        given()
                .header("Accept", "application/json")
                .when()
                .delete("/booking/" + booking_Id)
                .then()
                .statusCode(200);
    }
}
