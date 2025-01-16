package com.goaltracker.goals.service;

import com.goaltracker.goals.models.Measure;

import java.util.List;

public interface MeasureService {
    Measure createMeasure(Measure measure);

    Measure getMeasureById(int id);

    List<Measure> getAllMeasures();

    Measure updateMeasure(int id, Measure measure);

    boolean deleteMeasure(int id);
}
