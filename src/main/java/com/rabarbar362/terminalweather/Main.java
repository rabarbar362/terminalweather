package com.rabarbar362.terminalweather;

import java.io.IOException;

public class Main {

    public static void main(String args[]) throws IOException {

        int numberOfDays;

        if (args.length > 0) {
            try {
                numberOfDays = Integer.parseInt(args[0]);

                if (numberOfDays >7) {
                    System.out.println("--------- The forecast is available only for 7 days ahead! --------- \n");
                }

                    UserIPAddress IPAddress = new UserIPAddress();
                    System.out.println("Your IP address is: " + IPAddress.getIPAddress());
                    UserLocation userLocation = new UserLocation(IPAddress.getIPAddress());
                    WeatherData weatherData = new WeatherData(userLocation.getLatitude(), userLocation.getLongitude(), numberOfDays);
                    CurrentWeather currentWeather = new CurrentWeather(weatherData.getCurrentWeather());
                    currentWeather.printCurrentWeather();
                    ForecastWeather forecastWeather = new ForecastWeather(weatherData.getForecastWeather());
                    forecastWeather.printForecast();


            } catch (NumberFormatException e) {
                System.out.println("Invalid arguments.");
            }
        } else {
            numberOfDays = 0;
            UserIPAddress IPAddress = new UserIPAddress();
            System.out.println("Your IP address is: " + IPAddress.getIPAddress());
            UserLocation userLocation = new UserLocation(IPAddress.getIPAddress());
            WeatherData weatherData = new WeatherData(userLocation.getLatitude(), userLocation.getLongitude(), numberOfDays);
            CurrentWeather currentWeather = new CurrentWeather(weatherData.getCurrentWeather());
            currentWeather.printCurrentWeather();
        }
    }
}
