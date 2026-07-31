package observer;

import java.util.ArrayList;
import java.util.List;

/*
 * ÜBUNGSZIEL — das "Subjekt" (Publisher)
 * ------------------------------------------
 * Reales Beispiel: Ein Warenkorb, der sich ändert (Artikel hinzugefügt),
 * muss mehrere UI-Teile informieren — die Preisanzeige, die
 * Bestellübersicht, eventuell noch eine Versandkostenberechnung. Ohne
 * Observer müsste der Warenkorb jeden dieser Teile einzeln kennen und
 * direkt aufrufen. Mit Observer kennt er nur eine Liste von Beobachter,
 * die sich selbst registrieren.
 */
public class WarenkorbSubjekt {

    private final List<Beobachter> beobachter = new ArrayList<>();

    public void registriere(Beobachter b) {
        // TODO: den übergebenen Beobachter der Liste "beobachter" hinzufügen.
    }

    public void benachrichtigeAlle(String ereignis) {
        // TODO: aktualisieren(ereignis) auf jedem Eintrag in "beobachter" aufrufen
        //       (z. B. mit einer for-Schleife oder beobachter.forEach(...)).
    }
}
