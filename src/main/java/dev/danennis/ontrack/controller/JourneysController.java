package dev.danennis.ontrack.controller;

import dev.danennis.ontrack.model.journey.JourneyBoard;
import dev.danennis.ontrack.service.JourneysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:3000", "http://beach-train-app.herokuapp.com", "https://beach-train-app.herokuapp.com", "http://beach-train-app-qa.herokuapp.com", "https://beach-train-app-qa.herokuapp.com"})
@RestController
public class JourneysController {
    @Autowired
    JourneysService journeysService;
    @GetMapping(value = "/journeys/{origin}/{destination}")
    public ResponseEntity getJourneys(@PathVariable(value = "origin")String originCRS, @PathVariable(value = "destination")String destinationCRS) {
        JourneyBoard response = journeysService.getJourneys(originCRS, destinationCRS);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }
}
