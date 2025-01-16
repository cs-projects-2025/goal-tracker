package com.goaltracker.goals.service;

import com.goaltracker.goals.models.Measure;
import com.goaltracker.goals.repository.MeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasureServiceImpl implements MeasureService {

    @Autowired
    private MeasureRepository measureRepository;

    @Override
    public Measure createMeasure(Measure measure) {
        return measureRepository.save(measure);
    }

    @Override
    public Measure getMeasureById(int id) {
        return measureRepository.findById(id).orElse(null);
    }

    @Override
    public List<Measure> getAllMeasures() {
        return measureRepository.findAll();
    }

    @Override
    public Measure updateMeasure(int id, Measure measure) {
        if (measureRepository.existsById(id)) {
            measure.setId(id);
            return measureRepository.save(measure);
        } else {
            return null; // Or throw an exception
        }
    }

    @Override
    public boolean deleteMeasure(int id) {
        if (measureRepository.existsById(id)) {
            measureRepository.deleteById(id);
            return true;
        } else {
            return false; // Or throw an exception
        }
    }
}
