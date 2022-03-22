package HomeWork7;

import java.io.IOException;
import java.sql.SQLException;

import HomeWork7.entity.WeatherData;
import HomeWork7.enums.Periods;


public interface WeatherProvider {
    //void getWeather1(Periods periods) throws IOException;

    WeatherData getWeather(Periods periods) throws IOException, SQLException;

    WeatherData getAllFromDb() throws IOException;

}
