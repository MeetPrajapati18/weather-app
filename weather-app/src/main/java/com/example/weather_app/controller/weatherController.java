package com.example.weather_app.controller;

import com.example.weather_app.model.weatherResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.time.*;
import java.time.format.DateTimeFormatter;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class weatherController {

    private final String API_KEY = "82d4e3b2585a6e4fe1ba475e9e73a473"; // API key
    private final String API_URL = "https://api.openweathermap.org/data/2.5/weather"; // API URL

    @GetMapping("/")
    public String getIndex() {
        return "index"; //index.html filename
    }

    @GetMapping("/weather")
    public String getWeather(@RequestParam String city, Model model) {
        String apiKey = "82d4e3b2585a6e4fe1ba475e9e73a473"; //api key
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric"; //url for api

        RestTemplate restTemplate = new RestTemplate();
        weatherResponse response = restTemplate.getForObject(url, weatherResponse.class); //object of weatherResponse class
        weatherResponse weatherResponse = restTemplate.getForObject(url, weatherResponse.class); //Another Object of weatherResponse class

        if (response != null) {
            model.addAttribute("city", response.getName()); //to get name of city 
            model.addAttribute("country", response.getSys().getCountry()); // if country code is provided
            model.addAttribute("temperature", response.getMain().getTemp()); // to get temperature
            model.addAttribute("humidity", response.getMain().getHumidity()); // to get humidity
            model.addAttribute("windSpeed", response.getWind().getSpeed()); // to get windspped
            model.addAttribute("weatherDescription", response.getWeather().get(0).getDescription()); // to get weather description
            model.addAttribute("weatherIcon", "wi wi-owm-" + response.getWeather().get(0).getIcon()); // to get weather icon

            // get local time of the city
            long currentTimeInSeconds = Instant.now().getEpochSecond();
            ZonedDateTime localTime = ZonedDateTime.ofInstant(Instant.ofEpochSecond(currentTimeInSeconds + weatherResponse.getTimezone()), ZoneId.of("UTC"));
            model.addAttribute("localTime", localTime.toString());
        } else {
            model.addAttribute("error", "Could not fetch weather data.");
        }

        return "weather"; // This returns weather.html
    }
}
