package com.example.springcourse.Project3RESTForSensor.services;

import com.example.springcourse.Project3RESTForSensor.models.Measurement;
import com.example.springcourse.Project3RESTForSensor.repositories.MeasurementsRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MeasurementsService{
    private final MeasurementsRepository measurementsRepository;

    public MeasurementsService(MeasurementsRepository measurementsRepository) {
        this.measurementsRepository = measurementsRepository;
    }

    public void saveMeasurement(Measurement measurement) {
        registerMeasurement(measurement);
        measurementsRepository.save(measurement);
    }

    public List<Measurement> getMeasurements() {
        return measurementsRepository.findAll(Sort.by("measuredAt"));
    }

    public Long getRainyDaysCount() {
        //написать метод с обращением к базе данных
        return measurementsRepository.countByRaining(true);
    }

    private void registerMeasurement(Measurement measurement) {
        measurement.setMeasuredAt(LocalDateTime.now());
    }
}
