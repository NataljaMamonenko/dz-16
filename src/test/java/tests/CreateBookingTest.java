package tests;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.netty.handler.codec.http.HttpHeaders.addHeader;

public class CreateBookingTest {

//    @BeforeTest
//    public void setup() {
//        RestAssured.baseURI = "http://restful-booker.herokuapp.com/booking";
////        RestAssured.requestSpecification = new RequestSpecBuilder()
//                .addHeader("Content-Type", "application/json")
//                .addHeader("Accept", "application/json")
//                .build();
//        ResponseSpecification responseSpec = new ResponseSpecBuilder()
//                .expectContentType("application/json")
//                .build();
//        RestAssured.responseSpecification = responseSpec;
//    }

    @Test
    public void createBookingTest() {
        CreateBookingBody body = CreateBookingBody.builder()
                .firstname("Jim")
                .lastname("Brown")
                .totalprice(111)
                .depositpaid(true)
                .checkin("2018-08-01")
                .checkout("2019-08-05")
                .additionalneeds("Breakfast")
                .build();

        Response response = RestAssured.given()
                .body(body)
                .post("/create");

        response.prettyPrint();

        response.as(CreateBookingResponse.class);
//        response.as(CreateBookingResponse.class).getData().getId();
    }
}


//JSONObject response2=new JSONObject(response.asString());
//      (JSONObject) response2.get("id");

//        if (response.statusCode() == 200) {
//            int bookingId = response.jsonPath().getInt("bookingid");
//            System.out.println("Бронювання створено успішно. ID бронювання: " + bookingId);
//        } else {
//            System.out.println("Сталася помилка при створенні бронювання. Відповідь сервера: " + response.getBody().asString());
//        }


//    public static void main(String[] args) {
//        List<Integer> bookingIds = RestAssured.get("http://restful-booker.herokuapp.com/booking").then().extract().jsonPath().getList("bookingid");
//        System.out.println("Booking IDs: " + bookingIds);
//    }
