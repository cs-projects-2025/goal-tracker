package com.goaltracker.goals.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
 * Description: Model data class for a goal. A goal is made up of a name,
 * a list of strategies and a list of measures.
 * Author: Tony Sandoval
 * */
public class Goal {
    private int id;
    private String goalName;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Strategy> strategies;
    private List<Measure> measures;

    public Goal(String goalName, LocalDate startDate, LocalDate endDate) {
        this.goalName = goalName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.strategies = new ArrayList<>();
        this.measures = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<Strategy> getStrategies() {
        return strategies;
    }

    public void setStrategies(List<Strategy> strategies) {
        this.strategies = strategies;
    }

    public List<Measure> getMeasures() {
        return measures;
    }

    public void setMeasures(List<Measure> measures) {
        this.measures = measures;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "id=" + id +
                ", goalName='" + goalName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", strategies=" + strategies +
                ", measures=" + measures +
                '}';
    }
}
