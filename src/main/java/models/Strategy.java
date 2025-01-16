package models;

import java.util.List;

public class Strategy {
    private int id;
    private int goalId;
    private String strategyName;

    public Strategy(String strategyName) {
        this.strategyName = strategyName;
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
                ", goalId=" + goalId +
                ", strategyName='" + strategyName + '\'' +
                '}';
    }
}
