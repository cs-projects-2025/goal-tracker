package com.goaltracker.goals.controller;

import com.goaltracker.goals.models.Record;
import com.goaltracker.goals.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @PostMapping
    public ResponseEntity<Record> createRecord(@RequestBody Record record) {
        Record createdRecord = recordService.createRecord(record);
        return new ResponseEntity<>(createdRecord, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Record> getRecord(@PathVariable int id) {
        Record record = recordService.getRecordById(id);
        if (record != null) {
            return new ResponseEntity<>(record, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Record>> getAllRecords() {
        List<Record> records = recordService.getAllRecords();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Record> updateRecord(@PathVariable int id, @RequestBody Record record) {
        Record updatedRecord = recordService.updateRecord(id, record);
        if (updatedRecord != null) {
            return new ResponseEntity<>(updatedRecord, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable int id) {
        boolean deleted = recordService.deleteRecord(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
