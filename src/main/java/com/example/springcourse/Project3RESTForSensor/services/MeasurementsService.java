package com.example.springcourse.Project3RESTForSensor.services;

import com.example.springcourse.Project3RESTForSensor.models.Measurement;
import com.example.springcourse.Project3RESTForSensor.repositories.MeasurementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MeasurementsService{
    private final MeasurementsRepository measurementsRepository;

    @Autowired
    public MeasurementsService(MeasurementsRepository measurementsRepository) {
        this.measurementsRepository = measurementsRepository;
    }

    @Transactional
    public void saveMeasurement(Measurement measurement) {
        registerMeasurement(measurement);
        measurementsRepository.save(measurement);
    }

    @Transactional(readOnly = true)
    public List<Measurement> getMeasurements() {
        return measurementsRepository.findAll(Sort.by("measuredAt"));
    }

    @Transactional(readOnly = true)
    public Long getRainyDaysCount() {
        //написать метод с обращением к базе данных
        return measurementsRepository.countDistinctMeasuredAtByRaining(true);
    }

    private void registerMeasurement(Measurement measurement) {
        measurement.setMeasuredAt(LocalDateTime.now());
    }
}
