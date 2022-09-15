package com.example.springcourse.Project3RESTForSensor.util;

import com.example.springcourse.Project3RESTForSensor.models.Measurement;
import com.example.springcourse.Project3RESTForSensor.models.Sensor;
import com.example.springcourse.Project3RESTForSensor.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class MeasurementValidator implements Validator {
    private final SensorRepository sensorRepository;

    @Autowired
    public MeasurementValidator(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Measurement.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Measurement measurement = (Measurement) target;

        Optional<Sensor> optionalSensor = sensorRepository.findById(measurement.getSensor().getName());

        if (optionalSensor.isEmpty())
            errors.rejectValue("sensor", "", "This measurement comes from unregistered Sensor");
    }
}
