package com.example.springcourse.Project3RESTForSensor.repositories;

import com.example.springcourse.Project3RESTForSensor.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, String> {
}
