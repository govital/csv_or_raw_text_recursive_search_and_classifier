package app.handlers;

import app.interfaces.IMessaging;

import java.util.Set;

public class MessagingHandler implements IMessaging {

    public void askScanningPath(){
        writeMessage(" Enter path in the filesystem representing" +
                " a file or a folder that should be scanned: ");
    }

    public void askJsonRulesPath(){
        writeMessage("Enter Path to a JSON file," +
                " representing the list of classification rules:");
    }

    public void returnFoundDomains(Set<String> foundDomains) {
        for (String domain: foundDomains) {
            writeMessage(domain);
        }
    };

    private void writeMessage(String messageBody) {
        System.out.println(messageBody);
    }

}
