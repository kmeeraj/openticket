package com.example.openticket.adapter;

public class SeatAvailabilityAdapter implements ISeatAvailabilityTarget{
    private SeatAvailabilityAdaptee seatAvailabilityAdaptee;
    public SeatAvailabilityAdapter(SeatAvailabilityAdaptee seatAvailabilityAdaptee){
        this.seatAvailabilityAdaptee = seatAvailabilityAdaptee;
    }
    @Override
    public void request() {
        this.seatAvailabilityAdaptee.getSeatAvailability();
    }
}
