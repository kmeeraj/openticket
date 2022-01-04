package com.example.openticket.domain;

import lombok.Data;

@Data
public class SeatAvailability {
    private int[][] activeSeats;

    public int availableSeats() {
        return 0;
    }

    public boolean bookSeats(int[][][] bookSeats){
        return true;
    }
}
