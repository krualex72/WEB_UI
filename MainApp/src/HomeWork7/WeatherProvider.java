package HomeWork7;

import java.io.IOException;
import HomeWork7.enums.Periods;

public interface WeatherProvider {

    void getWeather(Periods periods) throws IOException;

}
