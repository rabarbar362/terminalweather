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

    public void printCurrentWeather() {
        System.out.println("Last updated: " + lastUpdatedDate + ".");
        System.out.println(conditionsDescription + ".");
        System.out.println("The temperature is " + tempC + " Celsius, but it feels like " + feelsLike + " Celsius.");
        System.out.println("The wind blows with the speed of " + windKph + " kph in the " + windDirection + " direction.");
        System.out.println("The pressure equals " + pressureMb + " mb.");
        System.out.println("Clouds cover " + cloudCover + "% of the sky.");
        System.out.println("Humidity: " + humidity +"%, precipitation: " + precipitationMm + " mm.");
        System.out.println();
    }
}
