package com.goaltracker.goals.service;

import com.goaltracker.goals.models.Record;

import java.util.List;

public interface RecordService {
    Record createRecord(Record record);

    Record getRecordById(int id);

    List<Record> getAllRecords();

    Record updateRecord(int id, Record record);

    boolean deleteRecord(int id);
}
