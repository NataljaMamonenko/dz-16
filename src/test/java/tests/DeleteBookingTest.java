package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteBookingTest {

    @Test
    public void deleteBookingTest() {
        Response response =  RestAssured.get("http://restful-booker.herokuapp.com/booking/{id}", 10);
        response.prettyPrint();
    }
}
