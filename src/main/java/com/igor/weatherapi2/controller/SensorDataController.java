package com.igor.weatherapi2.controller;

import com.igor.weatherapi2.model.SensorData;
import com.igor.weatherapi2.service.SensorDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensors/dht")
public class SensorDataController {

    private final SensorDataService sensorDataService;

    public SensorDataController(SensorDataService sensorDataService) {
        this.sensorDataService = sensorDataService;
    }

    @GetMapping
    public ResponseEntity<List<SensorData>> getAllRecords() {
        return ResponseEntity.ok(sensorDataService.getAllRecords());
    }

    @GetMapping("/{id}")
    public ResponseEntity getRecord(@PathVariable String id) {
        sensorDataService.getRecord(id);
        return ResponseEntity.ok(sensorDataService.getRecord(id));
    }

    @PostMapping
    public ResponseEntity<Object> createRecord(@RequestBody SensorData sensorData) {
        sensorDataService.createRecord(sensorData);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateRecord(@RequestBody SensorData sensorData, @PathVariable String id) {
        sensorDataService.updateRecord(sensorData, id);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRecord(@PathVariable String id) {
        sensorDataService.deleteRecord(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
