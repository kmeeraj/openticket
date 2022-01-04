package com.example.openticket.adapter;

public class SeatAvailbilityClient {

    public void checkSeatAvailability() {
        ISeatAvailabilityTarget seatAvailabilityTarget = new SeatAvailabilityAdapter(new SeatAvailabilityAdaptee());
        seatAvailabilityTarget.request();
    }
}
