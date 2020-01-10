package dev.danennis.ontrack.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartureBoard {
    private List<Departure> departureList;
    private String stationName;

    public DepartureBoard(String stationName, List<Departure> departureList) {
        this.departureList = departureList;
        this.stationName = stationName;
    }

    public List<Departure> getDepartureList() {
        return departureList;
    }

    public String getStationName() {
        return stationName;
    }
}
