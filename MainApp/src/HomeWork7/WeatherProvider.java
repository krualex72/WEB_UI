package HomeWork7;


import java.io.IOException;

import Homework7.enum.Periods;

public interface WeatherProvider {

    void getWeather(Periods periods) throws IOException;

}
