package app.interfaces;

import java.util.Set;

public interface IMessaging {
    void askScanningPath();
    void askJsonRulesPath();
    void returnFoundDomains(Set<String> foundDomains);
}
