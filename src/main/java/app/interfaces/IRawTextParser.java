package app.interfaces;

import app.dataTypes.ClassificationRules;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;

public interface IRawTextParser {
    Set<String> rawTxtFindDomains(
            Path path,
            ClassificationRules classificationRules,
            Set<String> foundDomains
    ) throws IOException;
}
