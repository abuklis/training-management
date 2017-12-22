package by.bsu.trainingmanagement.service;

import by.bsu.trainingmanagement.service.dto.WeatherInfo;

import java.io.IOException;

/**
 * Created by anyab on 21.12.2017.
 */
public interface IWeatherService {

    WeatherInfo viewCurrentWeather() throws IOException;
}
