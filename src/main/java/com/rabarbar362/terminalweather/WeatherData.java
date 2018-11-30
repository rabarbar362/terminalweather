package com.rabarbar362.terminalweather;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WeatherData {
    private JsonObject currentWeather;
    private JsonObject forecastWeather;

    public WeatherData(double latitude, double longitude, int forecastDays) throws IOException {
        String urlString = "http://api.apixu.com/v1/forecast.json?key=d6ae5e5cbc4f487ba61192956182410&q="+latitude+","+longitude+"&days="+forecastDays;
        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        String result = rd.readLine();
        JsonObject weatherObject = new JsonParser().parse(result).getAsJsonObject();

        if (forecastDays == 0) {
            currentWeather = weatherObject.getAsJsonObject("current");
        } else {
            currentWeather = weatherObject.getAsJsonObject("current");
            forecastWeather = weatherObject.getAsJsonObject("forecast");
        }
    }

    public JsonObject getCurrentWeather() {
        return currentWeather;
    }

    public JsonObject getForecastWeather() {
        return forecastWeather;
    }
}
