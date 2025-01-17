package com.goaltracker.goals.service;

import com.goaltracker.goals.models.Measure;
import com.goaltracker.goals.repository.MeasureRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MeasureServiceImpl implements MeasureService {

    @Autowired
    private MeasureRepository measureRepository;

    @Override
    public Measure createMeasure(Measure measure) {
        if (measure == null) {
            throw new IllegalArgumentException("Measure cannot be null");
        }
        return measureRepository.save(measure);
    }

    @Override
    public Measure getMeasureById(int id) {
        Optional<Measure> optionalMeasure = measureRepository.findById(id);
        if (optionalMeasure.isPresent()) {
            Measure measure = optionalMeasure.get();
            Hibernate.initialize(measure); // Initialize lazy-loaded fields if necessary
            return measure;
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Measure> getAllMeasures() {
        try {
            List<Measure> measures = measureRepository.findAll();
            // Initialize lazy-loaded fields for each measure if applicable
            measures.forEach(Hibernate::initialize);
            return measures;
        } catch (Exception e) {
            throw new RuntimeException("Error fetching measures: " + e.getMessage(), e);
        }
    }

    @Override
    public Measure updateMeasure(int id, Measure measure) {
        if (measure == null) {
            throw new IllegalArgumentException("Measure cannot be null");
        }
        if (measureRepository.existsById(id)) {
            measure.setId(id);
            return measureRepository.save(measure);
        }
        return null; // Optionally, throw an exception for a clearer error state
    }

    @Override
    public boolean deleteMeasure(int id) {
        if (measureRepository.existsById(id)) {
            try {
                measureRepository.deleteById(id);
                return true;
            } catch (Exception e) {
                throw new RuntimeException("Error deleting measure: " + e.getMessage(), e);
            }
        }
        return false;
    }
}
