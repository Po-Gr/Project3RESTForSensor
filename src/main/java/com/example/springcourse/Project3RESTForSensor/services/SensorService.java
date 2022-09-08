package com.example.springcourse.Project3RESTForSensor.services;

import com.example.springcourse.Project3RESTForSensor.models.Sensor;
import com.example.springcourse.Project3RESTForSensor.repositories.SensorRepository;
import org.springframework.stereotype.Service;

@Service
public class SensorService {
    private final SensorRepository sensorRepository;

    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public void registerSensor(Sensor sensor) {
        sensorRepository.save(sensor);
    }
}
