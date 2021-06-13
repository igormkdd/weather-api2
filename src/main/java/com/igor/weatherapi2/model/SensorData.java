package com.igor.weatherapi2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("sensors")
public class SensorData {
    @Id
    private String id;
    private String temperature;
    private String humidity;
    private Date date;

    public SensorData(String id, String temperature, String humidity, Date date) {
        super();
        this.id = id;
        this.temperature = temperature;
        this.humidity = humidity;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
