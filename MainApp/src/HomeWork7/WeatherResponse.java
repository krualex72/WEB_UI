package HomeWork7;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class WeatherResponse {
    @JsonIgnore
    private String LocalObservationDateTime;
    @JsonIgnore
    private float EpochTime;
    private String WeatherText;
//    @JsonIgnore
//    private float WeatherIcon;
//    @JsonIgnore
//    private boolean HasPrecipitation;
//    @JsonIgnore
//    private String PrecipitationType;
//    @JsonIgnore
//    private boolean IsDayTime;
    Temperature TemperatureObject;
    @JsonIgnore
    private String MobileLink;
    @JsonIgnore
    private String Link;

    @JsonCreator
    public WeatherResponse(@JsonProperty("WeatherText") String WeatherText, @JsonProperty("Temperature") Temperature TemperatureObject) {
        this.WeatherText = WeatherText;
        this.TemperatureObject = TemperatureObject;
    }

    @Override
    public String toString() {
        return "Current WeatherText{" +
                "погода= " + WeatherText +
                ", температура= " + TemperatureObject + '\'' +
                '}';
    }

    // Getter Methods

    public String getLocalObservationDateTime() {
        return LocalObservationDateTime;
    }

//    public float getEpochTime() {
//        return EpochTime;
//    }

    public String getWeatherText() {
        return WeatherText;
    }

//    public float getWeatherIcon() {
//        return WeatherIcon;
//    }
//
//    public boolean getHasPrecipitation() {
//        return HasPrecipitation;
//    }

//    public String getPrecipitationType() {
//        return PrecipitationType;
//    }
//
//    public boolean getIsDayTime() {
//        return IsDayTime;
//    }
//
    public Temperature getTemperature() {
        return TemperatureObject;
    }

//    public String getMobileLink() {
//        return MobileLink;
//    }
//
//    public String getLink() {
//        return Link;
//    }

    // Setter Methods

    public void setLocalObservationDateTime(String LocalObservationDateTime) {
        this.LocalObservationDateTime = LocalObservationDateTime;
    }

//    public void setEpochTime(float EpochTime) {
//        this.EpochTime = EpochTime;
//    }

    public void setWeatherText(String WeatherText) {
        this.WeatherText = WeatherText;
    }

//    public void setWeatherIcon(float WeatherIcon) {
//        this.WeatherIcon = WeatherIcon;
//    }

//    public void setHasPrecipitation(boolean HasPrecipitation) {
//        this.HasPrecipitation = HasPrecipitation;
//    }
//
//    public void setPrecipitationType(String PrecipitationType) {
//        this.PrecipitationType = PrecipitationType;
//    }
//
//    public void setIsDayTime(boolean IsDayTime) {
//        this.IsDayTime = IsDayTime;
//    }

    public void setTemperature(Temperature TemperatureObject) {
        this.TemperatureObject = TemperatureObject;
    }

//    public void setMobileLink(String MobileLink) {
//        this.MobileLink = MobileLink;
//    }
//
//    public void setLink(String Link) {
//        this.Link = Link;
//    }
}
