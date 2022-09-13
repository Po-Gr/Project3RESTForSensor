package com.example.springcourse.Project3RESTForSensor.controllers;

import com.example.springcourse.Project3RESTForSensor.dto.MeasurementDTO;
import com.example.springcourse.Project3RESTForSensor.models.Measurement;
import com.example.springcourse.Project3RESTForSensor.services.MeasurementsService;
import com.example.springcourse.Project3RESTForSensor.util.MeasurementNotCreatedException;
import com.example.springcourse.Project3RESTForSensor.util.SensorErrorResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {
    private final MeasurementsService measurementsService;
    private final ModelMapper modelMapper;

    @Autowired
    public MeasurementController(MeasurementsService measurementsService, ModelMapper modelMapper) {
        this.measurementsService = measurementsService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> saveMeasurement(@RequestBody @Valid MeasurementDTO measurementDTO,
                                                      BindingResult bindingResult) {

        //если все ок возвращать ок иначе JSON с ошибкой

        if (bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error: errors) {
                errorMsg.append(error.getField())
                        .append(" - ").append(error.getDefaultMessage())
                        .append("; ");
            }

            throw new MeasurementNotCreatedException(errorMsg.toString());
        }

        measurementsService.saveMeasurement(convertToMeasurement(measurementDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping()
    public List<MeasurementDTO> getMeasurements() {
        return measurementsService.getMeasurements().stream()
                .map(this::convertToMeasurementDTO).collect(Collectors.toList());
    }

    @GetMapping("/rainyDaysCount")
    public Long getRainyDaysCount() {
        return measurementsService.getRainyDaysCount();
        //кажется чего то не хватает
    }

    @ExceptionHandler
    private ResponseEntity<SensorErrorResponse> handleException(MeasurementNotCreatedException e) {
        SensorErrorResponse response = new SensorErrorResponse(e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    public Measurement convertToMeasurement(MeasurementDTO measurementDTO) {
        return modelMapper.map(measurementDTO, Measurement.class);
    }

    public MeasurementDTO convertToMeasurementDTO(Measurement measurement) {
        return modelMapper.map(measurement, MeasurementDTO.class);
    }
}
