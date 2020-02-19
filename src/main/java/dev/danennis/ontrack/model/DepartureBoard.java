package dev.danennis.ontrack.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartureBoard {
    private List<Departure> departures;
    private String stationName;

    public DepartureBoard(String stationName, List<Departure> departures) {
        this.departures = departures;
        this.stationName = stationName;
    }

    public List<Departure> getDepartures() {
        return departures;
    }

    public String getStationName() {
        return stationName;
    }
}
