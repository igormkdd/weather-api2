package com.igor.weatherapi2.service;

import com.igor.weatherapi2.model.SensorData;
import com.igor.weatherapi2.repository.SensorDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorDataService {

    private final SensorDataRepository sensorDataRepository;

    public SensorDataService(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
    }

    public List<SensorData> getAllRecords() {
        return sensorDataRepository.findAll();
    }

    public Optional<SensorData> getRecord(String id) {
        return sensorDataRepository.findById(id);
    }

    public void createRecord(SensorData sensorData) {
        sensorDataRepository.insert(sensorData);
    }

    public void updateRecord(SensorData sensorData, String id) {
        SensorData savedSensorData = sensorDataRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot find sensor data for ID %s", id)
                ));

        savedSensorData.setTemperature(sensorData.getTemperature());
        savedSensorData.setHumidity(sensorData.getHumidity());
        savedSensorData.setDate(sensorData.getDate());

        sensorDataRepository.save(sensorData);
    }

    public void deleteRecord(String id) {
        sensorDataRepository.deleteById(id);
    }

}
