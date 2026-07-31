package ausleihe.gebuehr;

import werkzeugkatalog.Werkzeug;

/*
 * Übungsziel (Modul 05 · Fallstudie — Strategy-Pattern):
 * Dies ist die Schnittstelle des Strategy-Patterns (siehe Modul 02). Warum
 * Strategy und nicht ein simples if/else in Ausleihenverwaltung?
 *
 *   - Neue Werkzeugkategorien (z. B. "VERLEIH_MIT_KAUTION") sollen später
 *     hinzukommen können, OHNE bestehenden Code zu ändern — das ist das
 *     Open/Closed-Prinzip aus Modul 01, konkret angewendet.
 *   - Die Gebührenlogik einer Kategorie ist von allem anderen (Verfügbarkeits-
 *     prüfung, Benachrichtigung) unabhängig testbar.
 *
 * Kein TODO in dieser Datei — die Schnittstelle selbst ist bereits vollständig.
 */
public interface GebuehrStrategie {

    /**
     * Berechnet die Gebühr für eine Ausleihe.
     *
     * @param werkzeug das ausgeliehene Werkzeug
     * @param tage     Anzahl der Ausleihtage (mindestens 1)
     * @return Gebühr in Euro
     */
    double berechneGebuehr(Werkzeug werkzeug, long tage);
}
