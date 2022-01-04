package com.example.openticket.proxy;

import com.example.openticket.domain.SeatSelection;

public class LazyScreenSeatSelectionProxy implements IScreenSeatSelection {
    private ScreenSeatSelection screenSeatSelection = null;
    private SeatSelection seatSelection = null;
    public LazyScreenSeatSelectionProxy(SeatSelection seatSelection) {
        this.seatSelection = seatSelection;
    }
    @Override
    public void setSeatSelection() {
        if(this.screenSeatSelection == null) {
            this.screenSeatSelection = new ScreenSeatSelection(this.seatSelection);
        }
        this.screenSeatSelection.setSeatSelection();
    }
}
