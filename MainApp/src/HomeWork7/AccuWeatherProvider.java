package HomeWork7;

import HomeWork7.enums.Periods;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.StringReader;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AccuWeatherProvider implements WeatherProvider {

    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST_ENDPOINT = "forecasts";
    private static final String FORECAST_TYPE = "daily";
    private static final String FORECAST_PERIOD ="5day";
    private static final String CURRENT_CONDITIONS_ENDPOINT = "currentconditions";
    private static final String API_VERSION = "v1";
    private static final String API_KEY = ApplicationGlobalState.getInstance().getApiKey();

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void getWeather(Periods periods) throws IOException {
        String cityKey = detectCityKey();
        if (periods.equals(Periods.NOW)) {
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(CURRENT_CONDITIONS_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(cityKey)
                    .addQueryParameter("language", "ru-ru") // язык
                    .addQueryParameter("apikey", API_KEY)
                    .build();
            // System.out.println("link = " + url); // прямая ссылка на зарос API
            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();
            String body = removeFirstAndLastChar(response.body().string()); // для упрощения десериализации
            // System.out.println( "New body " + body); вывод ответа с сервера в "удобном" формате
            ObjectMapper objectMapper1day = new ObjectMapper();
            JsonNode weatherText = objectMapper1day // текстовое значение погоды
                    .readTree(body)
                    .at("/WeatherText");
            JsonNode currentTemperetura = objectMapper1day // значение температуры
                    .readTree(body)
                    .at("/Temperature/Metric/Value");
            System.out.println("ПРИМЕР БЕЗ ДЕСЕРИАЛИЗАЦИИ Сейчас в " + ApplicationGlobalState.getInstance().getSelectedCity() + ": " + weatherText.asText() +", температура: " + currentTemperetura);

            WeatherResponse weatherResponse = objectMapper1day.readValue(body, WeatherResponse.class);
            System.out.println( "ПРИМЕР С ДЕСЕРИАЛИЗАЦИЕЙ Сейчас в " + ApplicationGlobalState.getInstance().getSelectedCity() + ": " + weatherResponse.getWeatherText() + weatherResponse.getTemperature());
        } else {
            if (periods.equals(Periods.FIVE_DAYS)) {
                OkHttpClient client = new OkHttpClient();
                // Сегментированное построение URL
                HttpUrl url = new HttpUrl.Builder()
                        .scheme("http")
                        .host(BASE_HOST)
                        .addPathSegment(FORECAST_ENDPOINT)
                        .addPathSegment(API_VERSION)
                        .addPathSegment(FORECAST_TYPE)
                        .addPathSegment(FORECAST_PERIOD)
                        .addPathSegment(cityKey)
                        .addQueryParameter("apikey", API_KEY)
                        .addQueryParameter("language", "ru-ru")
                        .addQueryParameter("metric", "true")
                        .build();

//                System.out.println("5 days url = " + url.toString()); // исключительно для самопроверки

                Request requesthttp = new Request.Builder()
                        .addHeader("accept", "application/json")
                        .url(url)
                        .build();

                String jsonResponse = client.newCall(requesthttp).execute().body().string();
//              Ниже типичный ответ сервера (для решения задачи и отработки в автономном режиме)
//                String jsonResponse = "{\"Headline\":{\"EffectiveDate\":\"2022-03-09T19:00:00+03:00\",\"EffectiveEpochDate\":1646841600,\"Severity\":5,\"Text\":\"Среда, ночь: при отсутствии защитной одежды вероятно переохлаждение\",\"Category\":\"cold\",\"EndDate\":\"2022-03-10T07:00:00+03:00\",\"EndEpochDate\":1646884800,\"MobileLink\":\"http://www.accuweather.com/ru/ru/moscow/294021/daily-weather-forecast/294021?unit=c\",\"Link\":\"http://www.accuweather.com/ru/ru/moscow/294021/daily-weather-forecast/294021?unit=c\"},\"DailyForecasts\":[{\"Date\":\"2022-03-08T07:00:00+03:00\",\"EpochDate\":1646712000,\"Temperature\":{\"Minimum\":{\"Value\":-11.1,\"Unit\":\"C\",\"UnitType\":17},\"Maximum\":{\"Value\":-2.2,\"Unit\":\"C\",\"UnitType\":17}},\"Day\":{\"Icon\":22,\"IconPhrase\":\"Снег\",\"HasPrecipitation\":true,\"PrecipitationType\":\"Snow\",\"PrecipitationIntensity\":\"Light\"},\"Night\":{\"Icon\":8,\"IconPhrase\":\"Пасмурно\",\"HasPrecipitation\":false},\"Sources\":[\"AccuWeather\"],\"MobileLink\":\"http://www.accuweather.com/ru/ru/moscow/294021/daily-weather-forecast/294021?day=1&unit=c\",\"Link\":\"http://www.accuweather.com/ru/ru/moscow/294021/daily-weather-forecast/294021?day=1&unit=c\"},{\"Date\":\"2022-03-09T07:00:00+03:00\",\"EpochDate\":1646798400,\"Temperature\":{\"Minimum\":{\"Value\":-14.5,\"Unit\":\"C\",\"UnitType\":17},\"Maximum\":{\"Value\":-5.9,\"Unit\":\"C\",\"UnitType\":17}},\"Day\":{\"Icon\":1,\"IconPhrase\":\"Солнечно\",\"HasPrecipitation\":false},\"Night\":{\"Icon\":33,\"IconPhrase\":\"Ясно\",\"HasPrecipitation\":false},\"Sources\":[\"AccuWeather\"],\"MobileLink\":\"http://www.accuweather.com/ru/ru/moscow/294021/daily-weather-forecast/294021?day=2&unit=c\",\"Link\":\"http://www.accuweather.com/ru/ru/moscow/294021/daily-weather-forecast/294021?day=2&unit=c\"},{\"Date\":\"2022-03-10T07:00:00+03:00\",\"EpochDate\":1646884800,\"Temperature\":{\"Minimum\":{\"Value\":-14.3,\"Unit\":\"C\",\"UnitType\":17},\"Maximum\":{\"Value\":-4.5,\"Unit\":\"C\",\"UnitType\":17}},\"Day\":{\"Icon\":1,\"IconPhrase\":\"Солнечно\",\"HasPrecipitation\":false},\"Night\":{\"Icon\":33,\"IconPhrase\":\"Ясно\",\"HasPrecipitation\":false},\"Sources\":[\"AccuWeather\"],\"MobileLink\":\"http://www.accuweather.com/ru/ru/moscow/294021/daily-weather-forecast/294021?day=3&unit=c\",\"Link\":\"http://www.accuweather.com/ru/ru/moscow/294021/daily-weather-forecast/294021?day=3&unit=c\"},{\"Date\":\"2022-03-11T07:00:00+03:00\",\"EpochDate\":1646971200,\"Temperature\":{\"Minimum\":{\"Value\":-11.6,\"Unit\":\"C\",\"UnitType\":17},\"Maximum\":{\"Value\":-1.3,\"Unit\":\"C\",\"UnitType\":17}},\"Day\":{\"Icon\":1,\"IconPhrase\":\"Солнечно\",\"HasPrecipitation\":false},\"Night\":{\"Icon\":34,\"IconPhrase\":\"Преимущественно ясно\",\"HasPrecipitation\":false},\"Sources\":[\"AccuWeather\"],\"MobileLink\":\"http://www.accuweather.com/ru/ru/moscow/294021/daily-weather-forecast/294021?day=4&unit=c\",\"Link\":\"http://www.accuweather.com/ru/ru/moscow/294021/daily-weather-forecast/294021?day=4&unit=c\"},{\"Date\":\"2022-03-12T07:00:00+03:00\",\"EpochDate\":1647057600,\"Temperature\":{\"Minimum\":{\"Value\":-3.8,\"Unit\":\"C\",\"UnitType\":17},\"Maximum\":{\"Value\":2.2,\"Unit\":\"C\",\"UnitType\":17}},\"Day\":{\"Icon\":6,\"IconPhrase\":\"Преимущественно облачно\",\"HasPrecipitation\":false},\"Night\":{\"Icon\":8,\"IconPhrase\":\"Пасмурно\",\"HasPrecipitation\":false},\"Sources\":[\"AccuWeather\"],\"MobileLink\":\"http://www.accuweather.com/ru/ru/moscow/294021/daily-weather-forecast/294021?day=5&unit=c\",\"Link\":\"http://www.accuweather.com/ru/ru/moscow/294021/daily-weather-forecast/294021?day=5&unit=c\"}]}";
//                System.out.println(jsonResponse);
                ObjectMapper mapper = new ObjectMapper();
                StringReader reader = new StringReader(jsonResponse);

                Example example = mapper.readValue(reader, Example.class);
//                System.out.println("Погода на 5 дней в " + ApplicationGlobalState.getInstance().getSelectedCity());
//                System.out.println(example);
                example.printDailyForecasts();

            }
        }

    }

    public static String removeFirstAndLastChar(String s) {
        return (s.substring(1, s.length() - 1));
    }

    public String detectCityKey() throws IOException {
        String selectedCity = ApplicationGlobalState.getInstance().getSelectedCity();

        HttpUrl detectLocationURL = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment("locations")
                .addPathSegment(API_VERSION)
                .addPathSegment("cities")
                .addPathSegment("autocomplete")
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", selectedCity)
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(detectLocationURL)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Невозможно прочесть информацию о городе. " +
                    "Код ответа сервера = " + response.code() + " тело ответа = " + response.body().string());
        }
        String jsonResponse = response.body().string();
        System.out.println("Произвожу поиск города " + selectedCity);

        if (objectMapper.readTree(jsonResponse).size() > 0) {
            String cityName = objectMapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
            String countryName = objectMapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();
            System.out.println("Найден город " + cityName + " в стране " + countryName);
        } else throw new IOException("Server returns 0 cities");

        return objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();
        // return "1";
   }
}
