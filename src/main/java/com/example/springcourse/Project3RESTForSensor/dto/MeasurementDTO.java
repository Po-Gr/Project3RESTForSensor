package com.example.springcourse.Project3RESTForSensor.dto;

import com.example.springcourse.Project3RESTForSensor.models.Sensor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class MeasurementDTO {
//    @NotEmpty(message = "Value should not be empty")
    @Min(value = -100, message = "Value should be greater than -100")
    @Max(value = 100, message = "Value year should be less than 100")
    private double value;

//    @NotEmpty(message = "Parameter is raining should not be empty")
    private Boolean raining;

//    @NotEmpty(message = "Sensor name should not be empty")
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
