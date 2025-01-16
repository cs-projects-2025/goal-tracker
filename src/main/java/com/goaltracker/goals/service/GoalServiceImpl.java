package com.goaltracker.goals.service;

import com.goaltracker.goals.models.Goal;
import com.goaltracker.goals.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalServiceImpl implements GoalService {

    @Autowired
    private GoalRepository goalRepository;

    @Override
    public Goal createGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    @Override
    public Goal getGoalById(int id) {
        return goalRepository.findById(id).orElse(null);
    }

    @Override
    public List<Goal> getAllGoals() {
        return goalRepository.findAll();
    }

    @Override
    public Goal updateGoal(int id, Goal goal) {
        if (goalRepository.existsById(id)) {
            goal.setId(id);
            return goalRepository.save(goal);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteGoal(int id) {
        if (goalRepository.existsById(id)) {
            goalRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
