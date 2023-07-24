package tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONObject;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BookingAPITests {

    public static String TOKEN_VALUE;
    public static final String TOKEN = "token";
    private ResponseSpecification responseSpec;

    @BeforeClass
    public void generateToken() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();

        JSONObject body = new JSONObject();
        body.put("password", "password123");
        body.put("username", "admin");

        Response response = given()
                .body(body.toString())
                .post("/auth");
        response.prettyPrint();
        TOKEN_VALUE = response.then().extract().jsonPath().get(TOKEN);

        responseSpec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();
    }

    @Test(priority = 1)
    public void createBookingTest() throws ParseException {
        Date date = new Date();
        SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dmyFormat.format(date);

        Date chekinDate = dmyFormat.parse(formattedDate);
        Date checkoutDate = dmyFormat.parse(formattedDate);

        BookingDates bookingdates = BookingDates.builder()
                .checkin(formattedDate)
                .checkout(formattedDate)
                .build();

        CreateBookingBody body = CreateBookingBody.builder()
                .firstname("Jim")
                .lastname("Brown")
                .totalprice(111)
                .depositpaid(true)
                .checkin("2018-01-01")
                .checkout("2019-01-01")
                .additionalneeds("Breakfast")
                .build();

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
//                .contentType(ContentType.JSON)
//                .accept(ContentType.JSON)
                .body(body)
                .post("/booking");

        response.then().assertThat().contentType(ContentType.JSON);

        response.prettyPrint();
        CreateBookingResponse bookingResponse = response.as(CreateBookingResponse.class);
    }


    @Test(priority = 2)
    public void getAllBookingTest() {
        Response response1 = RestAssured.get("/booking");
        response1.then().statusCode(200);
        response1.prettyPrint();
    }

    @Test(priority = 3)
    public void updateBookingPriceTest() {
        int bookingId = findFirstBooking();
        String requestBody = "{\n" + "  \"totalprice\": 150\n" + "}";

        given()
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .header("Cookie", TOKEN)
                .body(requestBody)
                .when()
                .patch("/booking/" + bookingId)
                .then()
//                .statusCode(200)
                .body("totalprice", equalTo(150));
//
        Response response10 = RestAssured.get("/booking");
        response10.prettyPrint();
        UpdateBookingResponse bookingResponse = response10.as(UpdateBookingResponse.class);
    }

    @Test(priority = 4)
    public void updateBookingDetailsTest() {
        int bookingId = findFirstBooking();
        JSONObject body = new JSONObject();
        body.put("firstname", "James");
        body.put("additionalneeds", "Dinner");

        Response updatedBooking = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .cookie(TOKEN, TOKEN)
                .body(body.toString())
                .when()
                .put("/booking/" + bookingId);

        updatedBooking.prettyPrint();
//        updatedBooking.then().statusCode(200);
    }

    @Test(priority = 5)
    public void deleteBookingTest() {
        int bookingId = findFirstBooking();
        Response response2 = RestAssured.delete("/booking/{id}", bookingId);
        response2.prettyPrint();
    }

    private int findFirstBooking() {
        Response getBookings = RestAssured.get("/booking");
        return getBookings.then().extract().jsonPath().getInt("bookingid[0]");
    }

    @AfterTest(alwaysRun = true)
    public void cleanUp() {
    }
}
