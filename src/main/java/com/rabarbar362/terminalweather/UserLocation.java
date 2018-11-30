package com.rabarbar362.terminalweather;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UserLocation {
    private double latitude, longitude;

    public UserLocation(String IP) {
        try {
            String urlString = "http://ip-api.com/json/"+ IP;
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String result = rd.readLine();
            JsonObject localizationObject = new JsonParser().parse(result).getAsJsonObject();

            latitude = Double.parseDouble(localizationObject.get("lat").toString());
            longitude = Double.parseDouble(localizationObject.get("lon").toString());

            System.out.println("Your estimated location is: " + latitude + ", " + longitude);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    double getLatitude() {

        return latitude;
    }

    double getLongitude() {

        return longitude;
    }
}
