package com.goaltracker.goals.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="strategies")
public class Strategy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "goal_id")
    private Goal goal;
    @Column(name = "strategy_name")
    private String strategyName;

    public Strategy() {}

    public Strategy(String strategyName) {
        this.strategyName = strategyName;
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

    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }

    @Override
    public String toString() {
        return "Strategy{" +
                "id=" + id +
                ", goalId=" + goal +
                ", strategyName='" + strategyName + '\'' +
                '}';
    }
}

