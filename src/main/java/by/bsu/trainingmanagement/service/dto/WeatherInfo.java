package by.bsu.trainingmanagement.service.dto;

/**
 * Created by anyab on 21.12.2017.
 */
public class WeatherInfo {
    private String weatherText;
    private double celsiusDegrees;

    public WeatherInfo(String weatherText, double celsiusDegrees) {
        this.weatherText = weatherText;
        this.celsiusDegrees = celsiusDegrees;
    }

    public String getWeatherText() {
        return weatherText;
    }

    public void setWeatherText(String weatherText) {
        this.weatherText = weatherText;
    }

    public double getCelsiusDegrees() {
        return celsiusDegrees;
    }

    public void setCelsiusDegrees(double celsiusDegrees) {
        this.celsiusDegrees = celsiusDegrees;
    }
}
