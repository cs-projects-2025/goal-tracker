package com.goaltracker.goals.service;

import com.goaltracker.goals.models.Strategy;
import com.goaltracker.goals.repository.StrategyRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StrategyServiceImpl implements StrategyService {

    @Autowired
    private StrategyRepository strategyRepository;

    @Override
    public Strategy createStrategy(Strategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Strategy cannot be null");
        }
        return strategyRepository.save(strategy);
    }

    @Override
    public Strategy getStrategyById(int id) {
        Optional<Strategy> optionalStrategy = strategyRepository.findById(id);
        if (optionalStrategy.isPresent()) {
            Strategy strategy = optionalStrategy.get();
            Hibernate.initialize(strategy); // Ensure lazy-loaded fields are initialized if needed
            return strategy;
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Strategy> getAllStrategies() {
        try {
            List<Strategy> strategies = strategyRepository.findAll();
            // Initialize strategies if there are lazy-loaded fields
            strategies.forEach(Hibernate::initialize);
            return strategies;
        } catch (Exception e) {
            throw new RuntimeException("Error fetching strategies: " + e.getMessage(), e);
        }
    }

    @Override
    public Strategy updateStrategy(int id, Strategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Strategy cannot be null");
        }
        if (strategyRepository.existsById(id)) {
            strategy.setId(id);
            return strategyRepository.save(strategy);
        }
        return null;
    }

    @Override
    public boolean deleteStrategy(int id) {
        if (strategyRepository.existsById(id)) {
            try {
                strategyRepository.deleteById(id);
                return true;
            } catch (Exception e) {
                throw new RuntimeException("Error deleting strategy: " + e.getMessage(), e);
            }
        }
        return false;
    }
}
