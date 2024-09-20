package com.example.weather_app.model;

import java.util.List;

public class weatherResponse {
    private String name;
    private Sys sys;
    private Main main;
    private List<Weather> weather;
    private Wind wind;
    private int timezone; // Add this field

    // Getters and Setters for name of the city
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //getter and setter for country code
    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    // for temperature and humidity
    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    //for desription and icon
    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    //for wind speed
    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    // Getter and setter for timezone
    public int getTimezone() { 
        return timezone;
    }

    public void setTimezone(int timezone) { 
        this.timezone = timezone;
    }

    public static class Sys {
        private String country;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }

    public static class Main {
        private double temp;
        private int humidity;

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }
    }

    public static class Weather {
        private String description;
        private String icon;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }

    public static class Wind {
        private double speed;

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }
    }
}
