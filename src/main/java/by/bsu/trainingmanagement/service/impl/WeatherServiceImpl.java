package by.bsu.trainingmanagement.service.impl;

import by.bsu.trainingmanagement.service.IWeatherService;
import by.bsu.trainingmanagement.service.dto.WeatherInfo;
import by.bsu.trainingmanagement.service.util.HttpClientUtil;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.json.JsonObject;
import java.io.IOException;

import static by.bsu.trainingmanagement.service.util.HttpClientUtil.convertStringToJsonObject;
import static by.bsu.trainingmanagement.service.util.HttpClientUtil.createHttpGetForJson;

/**
 * Created by anyab on 21.12.2017.
 */
@Service
public class WeatherServiceImpl implements IWeatherService{
    private static final String WEATHER_TEXT_PARAM = "WeatherText";
    private static final String TEMPERATURE_PARAM = "Temperature";
    private static final String METRIC_PARAM = "Metric";
    private static final String VALUE_PARAM = "Value";
    private static final String WEATHER_API_URL =
            "http://apidev.accuweather.com/currentconditions/v1/28580.json?language=en&apikey=hoArfRosT1215";
    @Override
    public WeatherInfo viewCurrentWeather() throws IOException {
        WeatherInfo weather;
        String weatherText;
        double celsiusDegrees;
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = createHttpGetForJson(WEATHER_API_URL);

        JsonObject json = HttpClientUtil.getJsonObjectFromResponse(client, httpGet);

        String weatherString = json.get(WEATHER_TEXT_PARAM).toString();
        weatherText = deleteQuotes(weatherString);

        String temperatureJson = json.get(TEMPERATURE_PARAM).toString();
        JsonObject temperature = convertStringToJsonObject(temperatureJson);

        String metricJson = temperature.get(METRIC_PARAM).toString();
        JsonObject metric = convertStringToJsonObject(metricJson);

        String degrees = metric.get(VALUE_PARAM).toString();
        celsiusDegrees = Double.parseDouble(degrees);

        weather = new WeatherInfo(weatherText, celsiusDegrees);
        client.close();
        return weather;
    }

    private static String deleteQuotes(String text){
        return text.replaceAll("\"", "");
    }
}
