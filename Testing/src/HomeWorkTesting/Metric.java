package HomeWorkTesting;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Metric {
    private float Value;

    @JsonCreator
    public Metric(@JsonProperty("Value") float Value) {
        this.Value = Value;
    }

    @Override
    public String toString() {
        return "" + Value;
    }

    // Getter Methods
    public float getValue() {
        return Value;
    }

    // Setter Methods
    public void setValue(float Value) {
        this.Value = Value;
    }

}