package com.example.springcourse.Project3RESTForSensor.util;

import com.example.springcourse.Project3RESTForSensor.models.Sensor;
import com.example.springcourse.Project3RESTForSensor.repositories.SensorRepository;
import com.fasterxml.jackson.datatype.jdk8.OptionalSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class SensorValidator implements Validator {
    private final SensorRepository sensorRepository;

    @Autowired
    public SensorValidator(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Sensor.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Sensor sensor = (Sensor) target;
        Optional<Sensor> optionalSensor = sensorRepository.findById(sensor.getName());

        if (optionalSensor.isPresent())
            errors.rejectValue("name", "", "This Sensor is already exist");
    }
}
