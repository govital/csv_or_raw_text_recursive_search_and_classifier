package app;

import app.handlers.MessagingHandler;
import app.providers.RawTxtParser;
import app.handlers.UserInputHandler;
import app.interfaces.*;
import app.providers.CsvParser;
import app.providers.MapperProvider;

public class TextClassifier {

    public static void main(String[] args) {
        IUserInput userInput = new UserInputHandler();
        IMessaging messaging = new MessagingHandler();
        IMapper mapper = new MapperProvider();
        IRawTextParser rawTextParser = new RawTxtParser();
        ICsvParser csvParser = new CsvParser();
        Application app = new Application(
                userInput,
                messaging,
                mapper,
                rawTextParser,
                csvParser
        );
        try {
            app.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
