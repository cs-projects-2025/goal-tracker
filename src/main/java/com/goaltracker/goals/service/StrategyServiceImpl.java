package com.goaltracker.goals.service;

import com.goaltracker.goals.models.Strategy;
import com.goaltracker.goals.repository.StrategyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StrategyServiceImpl implements StrategyService {

    @Autowired
    private StrategyRepository strategyRepository;

    @Override
    public Strategy createStrategy(Strategy strategy) {
        return strategyRepository.save(strategy);
    }

    @Override
    public Strategy getStrategyById(int id) {
        return strategyRepository.findById(id).orElse(null);
    }

    @Override
    public List<Strategy> getAllStrategies() {
        return strategyRepository.findAll();
    }

    @Override
    public Strategy updateStrategy(int id, Strategy strategy) {
        if (strategyRepository.existsById(id)) {
            strategy.setId(id);
            return strategyRepository.save(strategy);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteStrategy(int id) {
        if (strategyRepository.existsById(id)) {
            strategyRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
