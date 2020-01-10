package dev.danennis.ontrack.service;
import com.thalesgroup.rtti._2017_10_01.ldb.StationBoardWithDetailsResponseType;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ArrayOfServiceItemsWithCallingPoints;
import com.thalesgroup.rtti._2017_10_01.ldb.types.StationBoardWithDetails;
import dev.danennis.ontrack.model.Departure;
import dev.danennis.ontrack.model.DepartureBoard;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class DeparturesServiceTest {
    @Autowired
    DeparturesService departuresService;
    @Test
    public void doesReturnCorrectNumberOfDepartures() {
        int responseLength = 10;
        String CRS = "MCV";
        DepartureBoard departures = departuresService.getDepartures(CRS, responseLength);
        assertThat(departures.getDepartureList().size()).isEqualTo(10);
    }
    @Test
    public void doesReturnDeparturesFromCorrectStation() {
        int responseLength = 10;
        String CRS = "MCV";
        String departureStation = departuresService.getDepartures(CRS, responseLength).getStationName();
        assertThat(departureStation).isEqualTo("Manchester Victoria");
    }
}