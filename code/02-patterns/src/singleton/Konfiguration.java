package singleton;

import java.util.HashMap;
import java.util.Map;

/*
 * ÜBUNGSZIEL — den Fallstrick BEOBACHTEN, nicht nachbauen
 * ----------------------------------------------------------------
 * Dies ist eine klassische, "naive" Singleton-Implementierung: genau eine
 * Instanz, global über Konfiguration.getInstance() erreichbar. Sieht
 * praktisch aus — bis mehrere Codepfade (z. B. zwei Tests) denselben
 * globalen, veränderlichen Zustand teilen, ohne dass das im Code sichtbar
 * ist.
 *
 * Diese Klasse ist ABSICHTLICH bereits fertig (kein TODO) — schau dir
 * zuerst in Main.java an, WIE das zum Problem wird, bevor du in
 * KonfigurationDI.java die Alternative baust.
 */
public class Konfiguration {

    private static Konfiguration instanz;
    private final Map<String, String> werte = new HashMap<>();

    private Konfiguration() {
        werte.put("umgebung", "produktion");
    }

    public static Konfiguration getInstance() {
        if (instanz == null) {
            instanz = new Konfiguration();
        }
        return instanz;
    }

    public void setzeWert(String schluessel, String wert) {
        werte.put(schluessel, wert);
    }

    public String getWert(String schluessel) {
        return werte.get(schluessel);
    }
}
