package app.dataTypes;

import app.dataTypes.ClassificationRule;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ClassificationRules {
    @JsonProperty("classification_rules")
    private List<ClassificationRule> classificationRules;
    public List<ClassificationRule> getClassificationRules() {
        return classificationRules;
    }
}
