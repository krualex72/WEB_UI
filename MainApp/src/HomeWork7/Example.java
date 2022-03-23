package HomeWork7;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import HomeWork7.entity.WeatherData;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Headline",
        "DailyForecasts"
})

public class Example {

    @JsonProperty("Headline")
    private Headline headline;
    @JsonProperty("DailyForecasts")
    private List<DailyForecast> dailyForecasts = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @Override
    public String toString() {
        return "" + dailyForecasts;
    }

    public void printDailyForecasts() throws SQLException {
        DatabaseRepositorySQLiteImpl dbWeather = new DatabaseRepositorySQLiteImpl();// Создаем экземпляр по работе с БД

        for (int i = 0; i < 5; i++) {
            System.out.println("В " + ApplicationGlobalState.getInstance().getSelectedCity() + " " + dailyForecasts.get(i));
            Double dailyTemperature = dailyForecasts.get(i).getTemperature().getMaximum().getValue();
            WeatherData newDbRecord = new WeatherData(ApplicationGlobalState.getInstance().getSelectedCity(), dailyForecasts.get(i).getDate().substring(0,10), dailyForecasts.get(i).getDay().getIconPhrase(), dailyTemperature);

            dbWeather.saveWeatherData(newDbRecord);
        }
    }

    @JsonProperty("Headline")
    public Headline getHeadline() {
        return headline;
    }

    @JsonProperty("Headline")
    public void setHeadline(Headline headline) {
        this.headline = headline;
    }

    @JsonProperty("DailyForecasts")
    public List<DailyForecast> getDailyForecasts() {
        return dailyForecasts;
    }

    @JsonProperty("DailyForecasts")
    public void setDailyForecasts(List<DailyForecast> dailyForecasts) {
        this.dailyForecasts = dailyForecasts;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
