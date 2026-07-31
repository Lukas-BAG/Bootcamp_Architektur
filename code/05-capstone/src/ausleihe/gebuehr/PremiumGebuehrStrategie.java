package ausleihe.gebuehr;

import werkzeugkatalog.Werkzeug;

/*
 * Übungsziel (Modul 05 · Fallstudie — Strategy-Pattern, konkrete Strategie):
 * PREMIUM-Werkzeuge (z. B. der 3D-Drucker) kosten einen Tagessatz, weil ihr
 * Verschleiß und Materialverbrauch höher sind als bei Standard-Werkzeugen.
 *
 * TODO (für dich):
 * Implementiere die Gebührenberechnung: Tagessatz TAGESSATZ_EURO pro Tag,
 * multipliziert mit der Anzahl der Ausleihtage. Nutze dazu die Konstante
 * TAGESSATZ_EURO weiter unten (nicht "2.5" hart im Code verstreuen).
 *
 * Solange das TODO offen ist, gibt diese Methode 0.0 zurück — Main.java
 * läuft trotzdem durch, meldet aber eine Gebühr von 0,00 € für den
 * 3D-Drucker, was fachlich falsch ist. Genau daran erkennst du, ob dein
 * Fix funktioniert: Nach der Implementierung muss die Ausgabe in Main
 * einen Betrag > 0 für den 3D-Drucker zeigen.
 */
public class PremiumGebuehrStrategie implements GebuehrStrategie {

    private static final double TAGESSATZ_EURO = 2.50;

    @Override
    public double berechneGebuehr(Werkzeug werkzeug, long tage) {
        // TODO: TAGESSATZ_EURO * tage zurückgeben, statt des Platzhalters unten.
        return 0.0;
    }
}
