package com.goaltracker.goals.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "records")
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "measure_id")
    private Measure measure;
    private double value;
    private LocalDate date;

    public Record() {}

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

    public Measure getMeasureId() {
        return measure;
    }

    public void setMeasureId(Measure measureId) {
        this.measure = measureId;
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
                ", measureId=" + measure +
                ", value=" + value +
                ", date=" + date +
                '}';
    }
}
