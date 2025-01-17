package com.goaltracker.goals.service;

import com.goaltracker.goals.models.Goal;
import com.goaltracker.goals.repository.GoalRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GoalServiceImpl implements GoalService {

    @Autowired
    private GoalRepository goalRepository;

    @Override
    public Goal createGoal(Goal goal) {
        if (goal == null) {
            throw new IllegalArgumentException("Goal cannot be null");
        }
        return goalRepository.save(goal);
    }

    @Override
    public Goal getGoalById(int id) {
        Optional<Goal> optionalGoal = goalRepository.findById(id);
        if (optionalGoal.isPresent()) {
            Goal goal = optionalGoal.get();
            Hibernate.initialize(goal); // Ensure lazy-loaded fields are initialized if needed
            return goal;
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Goal> getAllGoals() {
        try {
            List<Goal> goals = goalRepository.findAll();
            // Initialize goals if there are lazy-loaded fields
            goals.forEach(Hibernate::initialize);
            return goals;
        } catch (Exception e) {
            throw new RuntimeException("Error fetching goals: " + e.getMessage(), e);
        }
    }

    @Override
    public Goal updateGoal(int id, Goal goal) {
        if (goal == null) {
            throw new IllegalArgumentException("Goal cannot be null");
        }
        if (goalRepository.existsById(id)) {
            goal.setId(id);
            return goalRepository.save(goal);
        }
        return null;
    }

    @Override
    public boolean deleteGoal(int id) {
        if (goalRepository.existsById(id)) {
            try {
                goalRepository.deleteById(id);
                return true;
            } catch (Exception e) {
                throw new RuntimeException("Error deleting goal: " + e.getMessage(), e);
            }
        }
        return false;
    }
}
