package HomeWork7;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import HomeWork7.enums.Functionality;
import HomeWork7.enums.Periods;

public class Controller {

    WeatherProvider weatherProvider = new AccuWeatherProvider();
    Map<Integer, Functionality> variantResult = new HashMap();
    DatabaseRepositorySQLiteImpl newConnection = new DatabaseRepositorySQLiteImpl();

    public Controller() {
        variantResult.put(1, Functionality.GET_CURRENT_WEATHER);
        variantResult.put(2, Functionality.GET_WEATHER_IN_NEXT_5_DAYS);
        variantResult.put(3, Functionality.GET_WEATHER_FROM_DATABASE);
    }

    public void onUserInput(String input) throws IOException {
        int command = Integer.parseInt(input);
        if (!variantResult.containsKey(command)) {
            throw new IOException("There is no command for command-key " + command);
        }


        switch (variantResult.get(command)) {
            case GET_CURRENT_WEATHER:
                getCurrentWeather();
                break;
            case GET_WEATHER_IN_NEXT_5_DAYS:
                getWeatherIn5Days();
                break;
            case GET_WEATHER_FROM_DATABASE:
                getWeatherFromDatabase();
                break;
        }
    }

    private void getWeatherFromDatabase() throws IOException  {
// тут нужно дорабатывать и думать
    }

    public void getCurrentWeather() throws IOException {
        weatherProvider.getWeather(Periods.NOW);
    }

    public void getWeatherIn5Days() throws IOException {
        weatherProvider.getWeather(Periods.FIVE_DAYS);
    }
}
