package com.igor.weatherapi2.repository;

import com.igor.weatherapi2.model.SensorData;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface SensorDataRepository extends MongoRepository<SensorData, String> {
}
