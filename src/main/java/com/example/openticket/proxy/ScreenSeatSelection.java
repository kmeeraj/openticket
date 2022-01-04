package com.example.openticket.proxy;

import com.example.openticket.domain.SeatSelection;

public class ScreenSeatSelection implements IScreenSeatSelection {
    SeatSelection seatSelection;
    public ScreenSeatSelection(SeatSelection seatSelection) {
        this.seatSelection = seatSelection;
    }
    @Override
    public void setSeatSelection() {

    }
}
