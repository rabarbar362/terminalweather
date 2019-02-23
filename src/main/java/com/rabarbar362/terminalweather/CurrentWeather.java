package com.rabarbar362.terminalweather;

import com.google.gson.JsonObject;

public class CurrentWeather {
    private String lastUpdatedDate, windDirection, conditionsDescription;
    private float tempC, windKph, precipitationMm, feelsLike;
    private int pressureMb, humidity, cloudCover;

    public CurrentWeather(JsonObject currentWeatherJson) {

        this.lastUpdatedDate = currentWeatherJson.get("last_updated").getAsString();
        this.windDirection = currentWeatherJson.get("wind_dir").getAsString();
        this.conditionsDescription = currentWeatherJson.getAsJsonObject("condition").get("text").getAsString();

        this.tempC = currentWeatherJson.get("temp_c").getAsFloat();
        this.windKph = currentWeatherJson.get("wind_kph").getAsFloat();
        this.pressureMb = currentWeatherJson.get("pressure_mb").getAsInt();
        this.precipitationMm = currentWeatherJson.get("precip_mm").getAsFloat();
        this.feelsLike = currentWeatherJson.get("feelslike_c").getAsFloat();

        this.humidity = currentWeatherJson.get("humidity").getAsInt();
        this.cloudCover = currentWeatherJson.get("cloud").getAsInt();

    }

    @Override
    public String toString() {
        return "Last updated: " + lastUpdatedDate + ".\n" + conditionsDescription + ".\n" +
                "The temperature is " + tempC + " Celsius, but it feels like " + feelsLike + " Celsius.\n" +
                "The wind blows with the speed of " + windKph + " kph in the " + windDirection + " direction.\n" +
                "The pressure equals " + pressureMb + " mb.\n" +
                "Clouds cover " + cloudCover + "% of the sky.\n" +
                "Humidity: " + humidity +"%, precipitation: " + precipitationMm + " mm.\n";
    }
}
