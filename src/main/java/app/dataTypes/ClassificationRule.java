package app.dataTypes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ClassificationRule {
    @JsonProperty("domain")
    private String domain;
    @JsonProperty("indicators")
    private List<String> indicators;

    public String getDomain() {
        return domain;
    }
    public List<String> getIndicators() {
        return indicators;
    }
}
