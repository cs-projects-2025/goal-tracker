package com.goaltracker.goals.repository;

import com.goaltracker.goals.models.Measure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasureRepository extends JpaRepository<Measure, Integer> {

}
