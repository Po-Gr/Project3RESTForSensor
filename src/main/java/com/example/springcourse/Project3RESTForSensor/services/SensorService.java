package com.example.springcourse.Project3RESTForSensor.services;

import com.example.springcourse.Project3RESTForSensor.models.Sensor;
import com.example.springcourse.Project3RESTForSensor.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SensorService {
    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Transactional
    public void registerSensor(Sensor sensor) {
        sensorRepository.save(sensor);
    }
}
