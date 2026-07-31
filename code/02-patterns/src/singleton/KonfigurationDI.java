package singleton;

import java.util.HashMap;
import java.util.Map;

/*
 * ÜBUNGSZIEL — die Alternative zum Singleton
 * -----------------------------------------------
 * Statt einer versteckten, globalen Instanz (Konfiguration.getInstance())
 * verwaltet hier der AUFRUFER selbst genau eine Instanz und reicht sie
 * explizit weiter (Dependency Injection im Kleinen: der Konstruktor nimmt
 * entgegen, was er braucht, statt es sich selbst über einen globalen
 * Zugriffspunkt zu holen). Jeder Aufrufer kann seine eigene, unabhängige
 * Instanz erzeugen — dadurch beeinflussen sich zwei "Tests" (siehe
 * Main.java, Teil 2) nicht mehr gegenseitig.
 *
 * Implementiere die drei TODOs unten.
 */
public class KonfigurationDI {

    private final Map<String, String> werte = new HashMap<>();

    public KonfigurationDI(String startUmgebung) {
        // TODO: "umgebung" -> startUmgebung in "werte" speichern (werte.put(...)).
    }

    public void setzeWert(String schluessel, String wert) {
        // TODO: schluessel/wert in "werte" speichern.
    }

    public String getWert(String schluessel) {
        // TODO: den zu schluessel gehörenden Wert aus "werte" zurückgeben.
        return null; // Platzhalter, bis das TODO oben erledigt ist.
    }
}
