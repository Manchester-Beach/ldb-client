package dev.danennis.ontrack.model.journey;

import java.util.List;

public class JourneyBoard {
    public List<Journey> departures;

    public JourneyBoard(List<Journey> departures) {
        this.departures = departures;
    }

    public JourneyBoard() {
    }

    public List<Journey> getDepartures() {
        return departures;
    }

    public void setDepartures(List<Journey> departures) {
        this.departures = departures;
    }

}
