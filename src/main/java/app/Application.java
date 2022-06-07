package app;

import app.dataTypes.ClassificationRule;
import app.dataTypes.ClassificationRules;
import app.enums.FileSuffix;
import app.interfaces.*;
import app.utils.FileUtils;
import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class Application {
    private IUserInput inputProvider;
    private IMessaging messageHandler;
    private IMapper mapper;
    private IRawTextParser rawTxtParser;
    private ICsvParser csvParser;
    private Map<String,String> csvClassificationMap;
    private Set<String> foundDomains;
    private FileUtils fileUtils;
    private ClassificationRules classificationRules;

    public Application(IUserInput inputProvider,
                       IMessaging messageProvider,
                       IMapper mapper,
                       IRawTextParser rawTxtParser,
                       ICsvParser csvParser
    ) {
        this.inputProvider = inputProvider;
        this.messageHandler = messageProvider;
        this.mapper = mapper;
        this.csvClassificationMap = new HashMap<>();
        this.foundDomains = new HashSet<>();
        this.rawTxtParser = rawTxtParser;
        this.fileUtils = new FileUtils();
        this.csvParser = csvParser;
        this.classificationRules = new ClassificationRules();
    }

    public void run() throws Exception {
        messageHandler.askJsonRulesPath();
        populateClassificationMap(inputProvider.getUserInput());
        messageHandler.askScanningPath();
        findDomains();
        messageHandler.returnFoundDomains(foundDomains);
    }

    private void populateClassificationMap(String jsonPath) throws IOException {
        classificationRules = mapper.jsonToObj(jsonPath, ClassificationRules.class);
        for (ClassificationRule rule: classificationRules.getClassificationRules()) {
            for (String indicator: rule.getIndicators()) {
                csvClassificationMap.put(indicator, rule.getDomain());
            }
        }
    }

    private void findDomains() throws IOException, CsvValidationException {
        for (Path path: fileUtils.getPaths(inputProvider.getUserInput())) {
            if (fileUtils.getExtension(path.toString()).equalsIgnoreCase(FileSuffix.CSV.name()  )
                    && path.toFile().isFile()) {
                foundDomains.addAll(csvParser.csvFindDomains(path, csvClassificationMap));
            }else if (path.toFile().isFile()){
                foundDomains.addAll(rawTxtParser.rawTxtFindDomains(path, classificationRules, foundDomains));
            }
        }
    }

}
