package by.bsu.trainingmanagement.controller;

import by.bsu.trainingmanagement.service.IWeatherService;
import by.bsu.trainingmanagement.service.dto.WeatherInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by anyab on 21.12.2017.
 */
@RestController
@RequestMapping(value = "/api")
public class WeatherController {
    private final IWeatherService weatherService;

    @Autowired
    public WeatherController(IWeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping(value = "/weather/current")
    public WeatherInfo viewCurrentWeather(){
        return weatherService.viewCurrentWeather();
    }

}
