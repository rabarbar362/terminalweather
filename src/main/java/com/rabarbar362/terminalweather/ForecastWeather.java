package com.rabarbar362.terminalweather;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class ForecastWeather {
    private static final int DAYS_IN_ONE_ROW = 3;
    private int printedDays = 0;
    private JsonArray forecastJsonArray;
    private JsonElement day;
    private String[][] forecast;
    private String date, conditions, sunrise, sunset;
    private float maxTempC, minTempC, maxWindKph, totalPrecipitation;
    private int humidity;

    public ForecastWeather(JsonObject forecastWeather) {

        forecastJsonArray = forecastWeather.getAsJsonArray("forecastday");
        forecast = new String[forecastJsonArray.size()][];
        for (int i = 0; i < forecastJsonArray.size(); i++) {
            this.day = forecastJsonArray.getAsJsonArray().get(i);

            JsonObject dayDay = day.getAsJsonObject().get("day").getAsJsonObject();
            JsonObject astro = day.getAsJsonObject().get("astro").getAsJsonObject();

            date = day.getAsJsonObject().get("date").getAsString();
            conditions = dayDay.get("condition").getAsJsonObject().get("text").getAsString();
            sunrise = astro.get("sunrise").getAsString();
            sunset = astro.get("sunset").getAsString();
            maxTempC = dayDay.get("maxtemp_c").getAsFloat();
            minTempC = dayDay.get("mintemp_c").getAsFloat();
            maxWindKph = dayDay.get("maxwind_kph").getAsFloat();
            totalPrecipitation = dayDay.get("totalprecip_mm").getAsFloat();
            humidity = dayDay.get("avghumidity").getAsInt();

            forecast[i] = new String[]{"Forecast for " + date,
                    conditions,
                    "Max temperature: " + maxTempC + "\u00b0C",
                    "Min temperature: " + minTempC + "\u00b0C",
                    "Max wind speed: " + maxWindKph + " Kph",
                    "Total precipitation: " + totalPrecipitation + "mm.",
                    "Average humidity: " + humidity + "%",
                    "Sunrise: " + sunrise,
                    "Sunset: " + sunset};
        }
    }

    private String[][] prepareToPrint() {

        String[][] forecastArray = new String[9][forecast.length];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < forecast.length; j++) {
                forecastArray[i][j] = forecast[j][i];
            }
        }
        return forecastArray;
    }

    public void printForecast() {
        String[][] forecastW = prepareToPrint();
        int numberOfRows = forecastJsonArray.size() / DAYS_IN_ONE_ROW;
        while (numberOfRows > 0) {
            print(forecastW, DAYS_IN_ONE_ROW);
            numberOfRows--;
            printedDays += 3;
        }

        int restOfDays = forecastJsonArray.size() % DAYS_IN_ONE_ROW;
        if (restOfDays > 0) {
            print(forecastW, restOfDays);
        }

    }

    private void print(String[][] forecastW, int daysToPrint) {
        for (int j = 0; j < daysToPrint; j++) {
            System.out.format("%-32s" + "|  ", "------------------------------");
        }
        System.out.println();

        for (int j = 0; j < daysToPrint; j++) {
            System.out.format("%-32s" + "|  ", forecastW[0][printedDays + j]);
        }

        System.out.println();

        for (int j = 0; j < daysToPrint; j++) {
            System.out.format("%-32s" + "|  ", "------------------------------");
        }
        System.out.println();

        for (int i = 1; i < forecastW.length; i++) {
            for (int j = 0; j < daysToPrint; j++) {
                System.out.format("%-32s" + "|  ", forecastW[i][printedDays + j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}

