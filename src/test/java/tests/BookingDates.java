package tests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.json.JSONPropertyIgnore;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BookingDates {

    private String checkin;
    private String checkout;
}

