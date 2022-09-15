package com.example.springcourse.Project3RESTForSensor.dto;

import com.example.springcourse.Project3RESTForSensor.models.Sensor;

import javax.validation.constraints.*;

public class MeasurementDTO {
    @NotNull(message = "Value should not be empty")
    @Min(value = -100, message = "Value should be greater than -100")
    @Max(value = 100, message = "Value year should be less than 100")
    private double value;

    @NotNull(message = "Parameter is raining should not be empty")
    private Boolean raining;

    @NotNull(message = "Sensor name should not be empty")
    private SensorDTO sensor;

    public MeasurementDTO() {
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Boolean getRaining() {
        return raining;
    }

    public void setRaining(Boolean raining) {
        this.raining = raining;
    }

    public SensorDTO getSensor() {
        return sensor;
    }

    public void setSensor(SensorDTO sensor) {
        this.sensor = sensor;
    }
}
