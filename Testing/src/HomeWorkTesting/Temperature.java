package HomeWorkTesting;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Temperature {
    Metric MetricObject;

    @JsonCreator
    public Temperature(@JsonProperty("Metric") Metric MetricObject) {
        this.MetricObject = MetricObject;
    }

    @Override
    public String toString() {
        return ", температура воздуха: " + MetricObject;
    }

    // Getter Methods
    public Metric getMetric() {
        return MetricObject;
    }

    // Setter Methods
    public void setMetric(Metric MetricObject) {
        this.MetricObject = MetricObject;
    }

}
