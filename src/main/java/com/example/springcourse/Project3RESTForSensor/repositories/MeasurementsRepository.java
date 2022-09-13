package com.example.springcourse.Project3RESTForSensor.repositories;

import com.example.springcourse.Project3RESTForSensor.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeasurementsRepository  extends JpaRepository<Measurement, Integer> {
    public long countByRaining(Boolean b);

    public long countDistinctMeasuredAtByRaining(Boolean b);
}
