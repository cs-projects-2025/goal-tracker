package com.goaltracker.goals.service;

import com.goaltracker.goals.models.Goal;

import java.util.List;

public interface GoalService {
    Goal createGoal(Goal goal);

    Goal getGoalById(int id);

    List<Goal> getAllGoals();

    Goal updateGoal(int id, Goal goal);

    boolean deleteGoal(int id);
}
