package com.goaltracker.goals.controller;

import com.goaltracker.goals.models.Measure;
import com.goaltracker.goals.service.MeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measures")
public class MeasureController {

    @Autowired
    private MeasureService measureService;

    @PostMapping
    public ResponseEntity<Measure> createMeasure(@RequestBody Measure measure) {
        Measure createdMeasure = measureService.createMeasure(measure);
        return new ResponseEntity<>(createdMeasure, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Measure> getMeasure(@PathVariable int id) {
        Measure measure = measureService.getMeasureById(id);
        if (measure != null) {
            return new ResponseEntity<>(measure, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Measure>> getAllMeasures() {
        List<Measure> measures = measureService.getAllMeasures();
        return new ResponseEntity<>(measures, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Measure> updateMeasure(@PathVariable int id, @RequestBody Measure measure) {
        Measure updatedMeasure = measureService.updateMeasure(id, measure);
        if (updatedMeasure != null) {
            return new ResponseEntity<>(updatedMeasure, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeasure(@PathVariable int id) {
        boolean deleted = measureService.deleteMeasure(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
