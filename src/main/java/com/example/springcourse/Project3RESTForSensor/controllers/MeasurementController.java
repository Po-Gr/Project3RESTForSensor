package com.example.springcourse.Project3RESTForSensor.controllers;

import com.example.springcourse.Project3RESTForSensor.dto.MeasurementDTO;
import com.example.springcourse.Project3RESTForSensor.models.Measurement;
import com.example.springcourse.Project3RESTForSensor.services.MeasurementsService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {
    private final MeasurementsService measurementsService;
    private final ModelMapper modelMapper;

    public MeasurementController(MeasurementsService measurementsService, ModelMapper modelMapper) {
        this.measurementsService = measurementsService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> saveMeasurement(@RequestBody @Valid MeasurementDTO measurementDTO,
                                                      BindingResult bindingResult) {
        measurementsService.saveMeasurement(convertToMeasurement(measurementDTO));
        //если все ок возвращать ок иначе JSON с ошибкой
    }

    @GetMapping()
    public List<MeasurementDTO> getMeasurements() {
        return measurementsService.getMeasurements().stream();
    }

    @GetMapping("/rainyDaysCount")
    public Long getRainyDaysCount() {
        return measurementsService.getRainyDaysCount();
        //кажется чего то не хватает
    }

    public Measurement convertToMeasurement(MeasurementDTO measurementDTO) {
        return modelMapper.map(measurementDTO, Measurement.class);
    }

    public MeasurementDTO convertToMeasurementDTO(Measurement measurement) {
        return modelMapper.map(measurement, MeasurementDTO.class);
    }
}
