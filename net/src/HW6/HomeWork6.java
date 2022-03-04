package HW6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class HomeWork6 {

    static Properties prop = new Properties();
    //private static final String BASE_HOST = "api.openweathermap.org";
    //private static final String API_VERSION = "data/2.5";
    //private static final String WEATHER_API = "onecall";

    public static void main(String[] args) throws IOException {
        loadProperties();
        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .followRedirects(true)
                .retryOnConnectionFailure(true)
                .build();
        // http://mytestservice.com/v2/companies/2?only_manufactures=true&in_top_100=true
        // https://api.openweathermap.org/data/2.5/onecall?lat=59.938732&lon=30.316229&units=metric&cnt=5&
        // exclude=current,minutely,hourly,alerts&lang=ru&appid=01eac0de5d2affe081c7741a740ea3b4
        HttpUrl url1 = new HttpUrl.Builder()
                .scheme("https")
                .host(prop.getProperty("BASE_HOST"))
                .addPathSegment(prop.getProperty("API_VERSION"))
                .addPathSegment(prop.getProperty("WEATHER_API"))
                .addQueryParameter("lat", prop.getProperty("LATITUDE")) // широта
                .addQueryParameter("lon", prop.getProperty("LONGITUDE")) // долгота
                .addQueryParameter("units", prop.getProperty("UNITS")) // единицы измерений
                .addQueryParameter("exclude", prop.getProperty("EXCLUDE")) // исключения прогнозов
                .addQueryParameter("lang", "ru") // язык
                .addQueryParameter("appid", prop.getProperty("APPID")) // токен
                .build();

        // Экземпляр класса Request создаём через Builder
        Request request = new Request.Builder()
                .url(url1)
                .build();

        // Получение объекта ответа от сервера
        Response response = client.newCall(request).execute();

        // Тело сообщения возвращается методом body объекта Response
        String body = response.body().string();

        System.out.println("url: " + url1);
        System.out.println("Code: " + response.code());
        System.out.println("Headers: " + response.headers());
        System.out.println("Body (JSON Response): " + body);
        System.out.println("Redirect?: " + response.isRedirect());
        System.out.println("Successful?: " + response.isSuccessful());
        System.out.println("Protocol:  " + response.protocol());
        System.out.println("Mills: " + response.receivedResponseAtMillis());

        ObjectMapper objectMapper = new ObjectMapper();
 //       System.out.println("JSON Response:");
//        String jsonResponse = client.newCall(request).execute().body().string();
//        System.out.println(jsonResponse);

    }
    private static void loadProperties() throws IOException {
        try(FileInputStream configFile = new FileInputStream("src/HW6/HomeWork6.properties")){
            prop.load(configFile);
        }
    }
}
