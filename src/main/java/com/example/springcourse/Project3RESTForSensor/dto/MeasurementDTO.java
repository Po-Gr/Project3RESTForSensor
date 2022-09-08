package com.example.springcourse.Project3RESTForSensor.dto;

import com.example.springcourse.Project3RESTForSensor.models.Sensor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class MeasurementDTO {
    @NotEmpty(message = "Value should not be empty")
    @Size(min = -100, max = 100, message = "Value should be from -100 to 100")
    private double value;

    @NotEmpty(message = "Parameter is raining should not be empty")
    private Boolean raining;

    @NotEmpty(message = "Sensor name should not be empty")
    private Sensor sensor;

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

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
