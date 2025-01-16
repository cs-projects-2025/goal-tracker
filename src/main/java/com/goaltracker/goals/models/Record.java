package com.goaltracker.goals.models;

import java.time.LocalDate;

public class Record {
    private int id;
    private double value;
    private LocalDate date;

    public Record(double value, LocalDate date) {
        this.value = value;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", value=" + value +
                ", date=" + date +
                '}';
    }
}
