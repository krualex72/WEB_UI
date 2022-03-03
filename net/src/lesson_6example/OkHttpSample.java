package lesson_6example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OkHttpSample {

    public static void main(String[] args) throws IOException {

        // Экземпляр класса OkHttpClient выполняет всю работу по созданию и отправке запросов
        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .followRedirects(true)
                .retryOnConnectionFailure(true)
                .build();

        // Экземпляр класса Request создается через Builder (см. паттерн проектирования "Строитель")
        Request request = new Request.Builder()
                .url("https://gb.ru")
                .build();

        // Получение объекта ответа от сервера
        Response response = client.newCall(request).execute();

        // Тело сообщения возвращается методом body объекта Response
        String body = response.body().string();

        System.out.println(response.code());
        System.out.println(response.headers());
        System.out.println(response.isRedirect());
        System.out.println(response.isSuccessful());
        System.out.println(response.protocol());
        System.out.println(response.receivedResponseAtMillis());
    }
}

