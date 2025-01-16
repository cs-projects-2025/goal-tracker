package com.goaltracker.goals.controller;

import com.goaltracker.goals.models.Strategy;
import com.goaltracker.goals.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/strategies")
public class StrategyController {

    @Autowired
    private StrategyService strategyService;

    @PostMapping
    public ResponseEntity<Strategy> createStrategy(@RequestBody Strategy strategy) {
        Strategy createdStrategy = strategyService.createStrategy(strategy);
        return new ResponseEntity<>(createdStrategy, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Strategy> getStrategy(@PathVariable int id) {
        Strategy strategy = strategyService.getStrategyById(id);
        if (strategy != null) {
            return new ResponseEntity<>(strategy, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Strategy>> getAllStrategies() {
        List<Strategy> strategies = strategyService.getAllStrategies();
        return new ResponseEntity<>(strategies, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Strategy> updateStrategy(@PathVariable int id, @RequestBody Strategy strategy) {
        Strategy updatedStrategy = strategyService.updateStrategy(id, strategy);
        if (updatedStrategy != null) {
            return new ResponseEntity<>(updatedStrategy, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStrategy(@PathVariable int id) {
        boolean deleted = strategyService.deleteStrategy(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
