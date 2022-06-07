package app.providers;

import app.interfaces.ICsvParser;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This method finds domains in csv file and adds them to an existing set of found domains
 *
 * path - csv file path
 * foundDomains - all domains found so far
 * @throws IOException if there is an error reading file
 */
public class CsvParser implements ICsvParser {
    CSVReader reader;
    public Set<String> csvFindDomains(Path path,
                                      Map<String,String> classificationMap
    ) throws IOException, CsvValidationException {
        Set<String> foundDomains = new HashSet<>();
        reader = new CSVReader(new FileReader(path.toString()));
            String[] lineInArray;
            while ((lineInArray = reader.readNext()) != null) {
                for (String word: lineInArray) {
                    if (classificationMap.containsKey(word.trim())) {
                        foundDomains.add(classificationMap.get(word.trim()));
                    }
                }
            }
            return foundDomains;
    }
}
