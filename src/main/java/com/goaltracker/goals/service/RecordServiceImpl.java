package com.goaltracker.goals.service;

import com.goaltracker.goals.models.Record;
import com.goaltracker.goals.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordRepository recordRepository;

    @Override
    public Record createRecord(Record record) {
        return recordRepository.save(record);
    }

    @Override
    public Record getRecordById(int id) {
        return recordRepository.findById(id).orElse(null);
    }

    @Override
    public List<Record> getAllRecords() {
        return recordRepository.findAll();
    }

    @Override
    public Record updateRecord(int id, Record record) {
        if (recordRepository.existsById(id)) {
            record.setId(id);
            return recordRepository.save(record);
        } else {
            return null; // Or throw an exception
        }
    }

    @Override
    public boolean deleteRecord(int id) {
        if (recordRepository.existsById(id)) {
            recordRepository.deleteById(id);
            return true;
        } else {
            return false; // Or throw an exception
        }
    }
}
