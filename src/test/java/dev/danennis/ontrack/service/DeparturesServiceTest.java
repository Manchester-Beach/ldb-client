package dev.danennis.ontrack.service;
import dev.danennis.ontrack.model.DepartureBoard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

@SpringBootTest
class DeparturesServiceTest {
    @Autowired
    DeparturesService departuresService;
    @Test
    public void doesReturnCorrectNumberOfDepartures() {
        int responseLength = 10;
        String CRS = "MCV";
        DepartureBoard departures = departuresService.getDepartures(CRS, responseLength);
        assertThat(departures.getDepartures().size()).isEqualTo(10);
    }
    @Test
    public void doesReturnDeparturesFromCorrectStation() {
        int responseLength = 10;
        String CRS = "MCV";
        String departureStation = departuresService.getDepartures(CRS, responseLength).getStationName();
        assertThat(departureStation).isEqualTo("Manchester Victoria");
    }
}