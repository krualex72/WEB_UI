package HomeWork7;

import HomeWork7.project.enum.Periods;

import java.io.IOException;

public interface WeatherProvider {

    void getWeather(Periods periods) throws IOException;

}
