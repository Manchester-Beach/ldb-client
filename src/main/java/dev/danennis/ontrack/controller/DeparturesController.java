package dev.danennis.ontrack.controller;

import dev.danennis.ontrack.model.DepartureBoard;
import dev.danennis.ontrack.service.DeparturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class DeparturesController {

    @Autowired
    DeparturesService departuresService;

    @GetMapping("/departures")
    public ResponseEntity getDeparturesForStation(@RequestParam String crs, @RequestParam int number) {
        DepartureBoard response = departuresService.getDepartures(crs, number);
            return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }
}