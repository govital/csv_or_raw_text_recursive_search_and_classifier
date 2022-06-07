package app.interfaces;

import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Set;

public interface ICsvParser {
    Set<String> csvFindDomains(Path path,
                               Map<String,String> classificationMap
    )throws IOException, CsvValidationException;
}
