package HomeWorkTesting;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	String serverAnswer = "{\"LocalObservationDateTime\":\"2022-03-08T13:02:00+05:30\",\"EpochTime\":1646724720,\"WeatherText\":\"Солнечно, дымка\",\"WeatherIcon\":5,\"HasPrecipitation\":false,\"PrecipitationType\":null,\"IsDayTime\":true,\"Temperature\":{\"Metric\":{\"Value\":36.0,\"Unit\":\"C\",\"UnitType\":17},\"Imperial\":{\"Value\":97.0,\"Unit\":\"F\",\"UnitType\":18}},\"MobileLink\":\"http://www.accuweather.com/ru/in/anaparthy/2833602/current-weather/2833602\",\"Link\":\"http://www.accuweather.com/ru/in/anaparthy/2833602/current-weather/2833602\"}"; // write your code here
    System.out.println(serverAnswer); // ленивый способ (реализуем для 1-дневного прогноза)
    ObjectMapper objectMapper1day = new ObjectMapper();
        //byte[] jsonString = new byte[0];
        JsonNode weatherText = objectMapper1day // текстовое значение погоды
                .readTree(serverAnswer)
                .at("/WeatherText");
        JsonNode currentTemperetura = objectMapper1day // текстовое значение погоды
                .readTree(serverAnswer)
                .at("/Temperature/Metric/Value");
        System.out.println("ПРИМЕР БЕЗ СЕРИАЛИЗАЦИИ Сейчас: " + weatherText.asText() +", температура: " + currentTemperetura);
        //Metric currentTempr = objectMapper1day.readValue(serverAnswer, Metric.class);
    WeatherResponse weatherResponse = objectMapper1day.readValue(serverAnswer, WeatherResponse.class);
    //System.out.println( "Weather responce " + weatherResponse);
    System.out.println( "ПРИМЕР С СЕРИАЛИЗАЦИЕЙ Сейчас: " + weatherResponse.getWeatherText() + weatherResponse.getTemperature());
    }
}
