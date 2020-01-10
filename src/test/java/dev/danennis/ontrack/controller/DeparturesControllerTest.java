package dev.danennis.ontrack.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.danennis.ontrack.model.Departure;
import dev.danennis.ontrack.model.DepartureBoard;
import dev.danennis.ontrack.service.DeparturesService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DeparturesController.class)
class DeparturesControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    DeparturesService departuresService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void doesReturnDepartures() throws Exception {
        // Given
        String uri = "/departures";
        String crs = "LIV";
        int number = 1;
        String url = String.format("%s?crs=%s&number=%s", uri, crs, number);

        when(departuresService.getDepartures(crs, number)).thenReturn(getDeparturesObject());

        // When
        String response = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        // Then
        assertThat(response).isEqualTo(objectMapper.writeValueAsString(getDeparturesObject()));
    }
    public DepartureBoard getDeparturesObject(){

        return new DepartureBoard("Liverpool Lime Street",
                new ArrayList<Departure>(Arrays.asList(
                        new Departure("MCV", false, "13:00", "13:50", "1", "13:00")
                )));
    }
    //does get departures
    //does return bad request for incomplete params
}