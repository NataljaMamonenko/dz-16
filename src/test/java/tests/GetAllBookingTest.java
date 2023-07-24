package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllBookingTest {

    @Test
    public void getAllBookingsTest1() {
        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
//        RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking";
//
//        Response response = given()
//                .header("Accept", "application/json")
//                .when()
//                .get("/booking")
//                .then()
//                .statusCode(200)
//                .contentType(ContentType.JSON)
//                .extract()
//                .response();
//
//        Booking[] bookings = response.getBody().as(Booking[].class);
//
//    }
//}
