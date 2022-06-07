package app.providers;

import app.dataTypes.ClassificationRule;
import app.dataTypes.ClassificationRules;
import app.interfaces.IRawTextParser;
import org.ahocorasick.trie.Trie;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class RawTxtParser implements IRawTextParser {
    Trie trie;
    /**
     * This method does something extremely useful ...
     *
     * @param path - raw text file path.
     * @param classificationRules - ClassificationRules object with array of rules.
     * @throws FileNotFoundException if scanner initialization with file that is not found.
     */
    public Set<String> rawTxtFindDomains(
            Path path,
            ClassificationRules classificationRules,
            Set<String> foundDomains
    ) throws IOException {
        Set<String> newFoundDomains = new HashSet<>();
        for (ClassificationRule classificationRule: classificationRules.getClassificationRules()) {
            if (foundDomains.contains(classificationRule.getDomain())) {
                continue;
            }
            String content = new String(
                    Files.readAllBytes(Paths.get(path.toString())),
                    StandardCharsets.US_ASCII);
            trie = Trie.builder().addKeywords(classificationRule.getIndicators()).build();
            if(trie.containsMatch(content)) {
                newFoundDomains.add(classificationRule.getDomain());
            }
        }
        return newFoundDomains;
    }
}
