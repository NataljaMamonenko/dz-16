package tests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.restassured.RestAssured;
import lombok.*;

import java.util.List;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateBookingResponse {

    private Integer bookingId;
    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;

    public static void main(String[] args) {
        List<Integer> bookingIds = RestAssured.get("http://restful-booker.herokuapp.com/booking").then().extract().jsonPath().getList("bookingid");
        System.out.println("Booking IDs: " + bookingIds);
    }

}

