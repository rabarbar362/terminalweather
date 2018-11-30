package com.rabarbar362.terminalweather;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class ForecastWeather {
    private static final double DAYS_IN_ONE_ROW = 3.0;
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

    //TODO printing the forecast properly, 3 days in one row
    public void printForecast() {
        String[][] forecastW = prepareToPrint();

        int rowsOfDays = (int) Math.ceil(forecastJsonArray.size() / DAYS_IN_ONE_ROW);


        for (int t=0; t < rowsOfDays; t++) {

            for (int j = 3*t; j < forecastJsonArray.size(); j++) {
                System.out.format("%-32s" + "|  ", "------------------------------");
            }
            System.out.println();

            for (int j = 3*t; j < forecastJsonArray.size(); j++) {
                System.out.format("%-32s" + "|  ", forecastW[0][j]);
            }

            System.out.println();

            for (int j = 3*t; j < forecastJsonArray.size(); j++) {
                System.out.format("%-32s" + "|  ", "------------------------------");
            }
            System.out.println();

            for (int i = 1; i < forecastW.length; i++) {
                for (int j = 3*t; j < forecastJsonArray.size(); j++) {
                    System.out.format("%-32s" + "|  ", forecastW[i][j]);
                }
                System.out.println();
            }
            System.out.println();

        }


       /* for (int j = 0; j < 3; j++) {
            System.out.format("%-32s" + "|  ", "------------------------------");
        }
        System.out.println();

        for (int j = 0; j < 3; j++) {
            System.out.format("%-32s" + "|  ", forecastW[0][j]);
        }

        System.out.println();

        for (int j = 0; j < 3; j++) {
            System.out.format("%-32s" + "|  ", "------------------------------");
        }
        System.out.println();

        for (int i = 1; i < forecastW.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.format("%-32s" + "|  ", forecastW[i][j]);
            }
            System.out.println();
        }
        System.out.println();







            for (int j = 3; j < 6; j++) {
                System.out.format("%-32s" + "|  ", "------------------------------");
            }
            System.out.println();

            for (int j = 3; j < 6; j++) {
                System.out.format("%-32s" + "|  ", forecastW[0][j]);
            }

            System.out.println();

            for (int j = 3; j < 6; j++) {
                System.out.format("%-32s" + "|  ", "------------------------------");
            }
            System.out.println();

            for (int x = 1; x < forecastW.length; x++) {
                for (int j = 3; j < 6; j++) {
                    System.out.format("%-32s" + "|  ", forecastW[x][j]);
                }
                System.out.println();
            }
        System.out.println();




                for (int j = 6; j < 7; j++) {
                    System.out.format("%-32s" + "|  ", "------------------------------");
                }
                System.out.println();

                for (int j = 6; j < 7; j++) {
                    System.out.format("%-32s" + "|  ", forecastW[0][j]);
                }

                System.out.println();

                for (int j = 6; j < 7; j++) {
                    System.out.format("%-32s" + "|  ", "------------------------------");
                }
                System.out.println();

                for (int x = 1; x < forecastW.length; x++) {
                    for (int j = 6; j < 7; j++) {
                        System.out.format("%-32s" + "|  ", forecastW[x][j]);
                    }
                    System.out.println();
                }*/



        /*
        int rowsOfDays = (int) Math.ceil(forecastJsonArray.size() / DAYS_IN_ONE_ROW);
        int currentIndex;

        for (int q = 0; q < rowsOfDays; q++) {

            String[][] forecast3Days = new String[9][3];

            for (currentIndex = 0; currentIndex < forecastJsonArray.size();currentIndex++){


                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 3; j++) {
                        forecast3Days[i][j] = forecastW[i][currentIndex];
                    }
                }

                for (int j = 0; j < forecast3Days[0].length; j++) {
                    System.out.format("%-32s" + "|  ", "------------------------------");
                }
                System.out.println();

                for (int j = 0; j < forecast3Days[0].length; j++) {
                    System.out.format("%-32s" + "|  ", forecast3Days[0][currentIndex]);
                }

                System.out.println();

                for (int j = 0; j < forecast3Days[0].length; j++) {
                    System.out.format("%-32s" + "|  ", "------------------------------");
                }
                System.out.println();

                for (int i = 1; i < forecast3Days.length; i++) {
                    for (int j = 0; j < forecast3Days[i].length; j++) {
                        System.out.format("%-32s" + "|  ", forecast3Days[i][currentIndex]);
                    }
                    System.out.println();
                }
            }
        }

       int rowsOfDays = (int) Math.ceil(forecastJsonArray.size()/DAYS_IN_ONE_ROW);

        for (int q = 0; q < rowsOfDays; q++) {

            printHorizontalDivider();

            for (int j = 0; j < DAYS_IN_ONE_ROW; j++) {
                System.out.format("%-32s" + "|  ", forecastW[0][j]);
            }
            System.out.println();

            printHorizontalDivider();

            for (int i = 1; i < forecastW.length; i++) {
                for (int j = 0; j < DAYS_IN_ONE_ROW; j++) {
                    System.out.format("%-32s" + "|  ", forecastW[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println();*/

    }
}


