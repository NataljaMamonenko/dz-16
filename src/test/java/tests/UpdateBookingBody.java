package tests;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class UpdateBookingBody {

        private String firstname;
        private String lastname;
        private int totalprice;
        private boolean depositpaid;
        private String checkin;
        private String checkout;
        private String additionalneeds;
    }

