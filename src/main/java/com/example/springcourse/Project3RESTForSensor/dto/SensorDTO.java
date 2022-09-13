package com.example.springcourse.Project3RESTForSensor.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SensorDTO {
    @NotEmpty(message = "Sensor name should not be empty")
    @Size(min = 3, max = 30, message = "Sensor name should be from 3 to 30 symbols")
    private String name;

    public SensorDTO() {
    }

    public SensorDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
