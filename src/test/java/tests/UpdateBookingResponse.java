package tests;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateBookingResponse {
            private String firstname;
            private String lastname;
            private int totalprice;
            private boolean depositpaid;
            private String checkin;
            private String checkout;
            private String additionalneeds;
 }
