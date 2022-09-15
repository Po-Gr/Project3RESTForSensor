package com.example.springcourse.Project3RESTForSensor.dto;

import java.util.List;

public class AllMeasurementsResponse {
    List<MeasurementDTO> allMeasurements;

    public AllMeasurementsResponse(List<MeasurementDTO> allMeasurements) {
        this.allMeasurements = allMeasurements;
    }

    public List<MeasurementDTO> getAllMeasurements() {
        return allMeasurements;
    }

    public void setAllMeasurements(List<MeasurementDTO> allMeasurements) {
        this.allMeasurements = allMeasurements;
    }
}
