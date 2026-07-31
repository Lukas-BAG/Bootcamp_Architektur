package ausleihe.gebuehr;

import werkzeugkatalog.Werkzeug;

/*
 * Übungsziel (Modul 05 · Fallstudie — Strategy-Pattern, konkrete Strategie):
 * STANDARD-Werkzeuge (z. B. der Akkuschrauber) sind für Vereinsmitglieder
 * kostenlos ausleihbar — das ist die einfachste mögliche Strategie und dient
 * dir als Vorlage dafür, wie PremiumGebuehrStrategie (siehe Nachbardatei,
 * dort wartet ein TODO) aussehen soll.
 *
 * Kein TODO in dieser Datei — sie ist bereits vollständig und dient als
 * Referenz-Implementierung.
 */
public class StandardGebuehrStrategie implements GebuehrStrategie {

    @Override
    public double berechneGebuehr(Werkzeug werkzeug, long tage) {
        return 0.0;
    }
}
