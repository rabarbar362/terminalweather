package com.rabarbar362.terminalweather;

import java.io.IOException;

public class Main {

    private static void currentWeather(WeatherData weatherData) {
        CurrentWeather currentWeather = new CurrentWeather(weatherData.getCurrentWeather());
        currentWeather.printCurrentWeather();
    }

    private static void forecastWeather(WeatherData weatherData) {
        ForecastWeather forecastWeather = new ForecastWeather(weatherData.getForecastWeather());
        forecastWeather.printForecast();
    }

    public static void main(String[] args) throws IOException {

        int numberOfDays;

        if (args.length > 0) {
            try {
                numberOfDays = Integer.parseInt(args[0]);
                UserIPAddress IPAddress = new UserIPAddress();
                System.out.println("Your IP address is: " + IPAddress.getIPAddress());
                UserLocation userLocation = new UserLocation(IPAddress.getIPAddress());

                if (numberOfDays > 7) {
                    WeatherData data = new WeatherData(userLocation.getLatitude(), userLocation.getLongitude(),numberOfDays);
                    currentWeather(data);
                    System.out.println("--------- The forecast is available only for 7 days ahead! --------- \n");
                    forecastWeather(data);
                } else if (numberOfDays == 0) {
                    WeatherData data = new WeatherData(userLocation.getLatitude(), userLocation.getLongitude(),numberOfDays);
                    currentWeather(data);
                } else {
                    WeatherData data = new WeatherData(userLocation.getLatitude(), userLocation.getLongitude(),numberOfDays);
                    currentWeather(data);
                    forecastWeather(data);
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid arguments.");
            }
        }
    }
}
