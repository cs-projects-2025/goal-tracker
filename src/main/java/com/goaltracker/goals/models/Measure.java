package com.goaltracker.goals.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Measure {
    private int id;
    private String name;
    private int goalId;
    private double baseline;
    private double target;
    private List<Record> records;

    public Measure(int id, String name, double baseline, double target, List<Record> records) {
        this.id = id;
        this.name = name;
        this.baseline = baseline;
        this.target = target;
        this.records = records;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoalId() {
        return goalId;
    }

    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }

    public double getBaseline() {
        return baseline;
    }

    public void setBaseline(double baseline) {
        this.baseline = baseline;
    }

    public double getTarget() {
        return target;
    }

    public void setTarget(double target) {
        this.target = target;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public void addRecord(double value, LocalDate date) {
        Record newRecord = new Record(value, date);
        this.records.add(newRecord);
    }

    public List<Record> getRecords() {
        return records;
    }

    @Override
    public String toString() {
        return "Measure{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", goalId=" + goalId +
                ", baseline=" + baseline +
                ", target=" + target +
                ", records=" + records +
                '}';
    }
}
