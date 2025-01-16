package com.goaltracker.goals.service;

import com.goaltracker.goals.models.Strategy;

import java.util.List;

public interface StrategyService {
    Strategy createStrategy(Strategy strategy);

    Strategy getStrategyById(int id);

    List<Strategy> getAllStrategies();

    Strategy updateStrategy(int id, Strategy strategy);

    boolean deleteStrategy(int id);
}
