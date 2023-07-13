package tests;

import java.time.LocalDate;

public class Booking {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;

    public static class BookingDates {
        private LocalDate checkin;
        private LocalDate checkout;

        public LocalDate getCheckin() {
            return checkin;
        }

        public void setCheckin(LocalDate checkin) {
            this.checkin = checkin;
        }

        public LocalDate getCheckout() {
            return checkout;
        }

        public void setCheckout(LocalDate checkout) {
            this.checkout = checkout;
        }
    }

}

