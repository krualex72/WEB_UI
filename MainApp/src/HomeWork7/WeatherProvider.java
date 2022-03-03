package HomeWork7;

import HomeWork7.enum.Periods;

import java.io.IOException;

public interface WeatherProvider {

    void getWeather(Periods periods) throws IOException;

}
