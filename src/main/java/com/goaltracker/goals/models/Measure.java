package com.goaltracker.goals.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="measures")
public class Measure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "goal_id")
    private Goal goal;
    private double baseline;
    private double target;
    @OneToMany(mappedBy = "measure", cascade = CascadeType.ALL, orphanRemoval = true)

    private List<Record> records;

    public Measure() {}

    public Measure(String name, double baseline, double target) {
        this.name = name;
        this.baseline = baseline;
        this.target = target;
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

    public Goal getGoalId() {
        return goal;
    }

    public void setGoalId(Goal goalId) {
        this.goal = goal;
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
                ", goalId=" + goal +
                ", baseline=" + baseline +
                ", target=" + target +
                ", records=" + records +
                '}';
    }
}
