package com.goaltracker.goals.service;

import com.goaltracker.goals.models.Record;
import com.goaltracker.goals.repository.RecordRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordRepository recordRepository;

    @Override
    public Record createRecord(Record record) {
        if (record == null) {
            throw new IllegalArgumentException("Record cannot be null");
        }
        return recordRepository.save(record);
    }

    @Override
    public Record getRecordById(int id) {
        Optional<Record> optionalRecord = recordRepository.findById(id);
        if (optionalRecord.isPresent()) {
            Record record = optionalRecord.get();
            Hibernate.initialize(record); // Initialize lazy-loaded fields if necessary
            return record;
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Record> getAllRecords() {
        try {
            List<Record> records = recordRepository.findAll();
            // Initialize lazy-loaded fields for each record if applicable
            records.forEach(Hibernate::initialize);
            return records;
        } catch (Exception e) {
            throw new RuntimeException("Error fetching records: " + e.getMessage(), e);
        }
    }

    @Override
    public Record updateRecord(int id, Record record) {
        if (record == null) {
            throw new IllegalArgumentException("Record cannot be null");
        }
        if (recordRepository.existsById(id)) {
            record.setId(id);
            return recordRepository.save(record);
        }
        return null; // Optionally, throw an exception for clearer error signaling
    }

    @Override
    public boolean deleteRecord(int id) {
        if (recordRepository.existsById(id)) {
            try {
                recordRepository.deleteById(id);
                return true;
            } catch (Exception e) {
                throw new RuntimeException("Error deleting record: " + e.getMessage(), e);
            }
        }
        return false;
    }
}
