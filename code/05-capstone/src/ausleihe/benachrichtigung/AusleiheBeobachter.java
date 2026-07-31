package ausleihe.benachrichtigung;

import ausleihe.Ausleihe;

/*
 * Übungsziel (Modul 05 · Fallstudie — Observer-Pattern):
 * Ausleihenverwaltung (das "Subject") kennt nur diese Schnittstelle, nicht
 * ihre konkreten Umsetzungen. Warum Observer statt eines direkten Aufrufs
 * wie "emailVersand.sende(...)" in Ausleihenverwaltung?
 *
 *   - Heute soll die Konsole benachrichtigt werden (Platzhalter für
 *     "eigentlich E-Mail"), später vielleicht zusätzlich eine Warteliste,
 *     noch später eventuell ein Push-Kanal. Ausleihenverwaltung muss dafür
 *     NICHT geändert werden — neue Beobachter registrieren sich einfach.
 *   - Das ist lose Kopplung im Sinne von Modul 04: Ausleihenverwaltung und
 *     die Benachrichtigungskanäle können unabhängig voneinander geändert
 *     werden.
 *
 * Kein TODO in dieser Datei — die Schnittstelle ist bereits vollständig.
 */
public interface AusleiheBeobachter {

    /**
     * Wird von Ausleihenverwaltung aufgerufen, wenn sich der Zustand einer
     * Ausleihe ändert.
     *
     * @param ausleihe die betroffene Ausleihe
     * @param ereignis kurze Beschreibung, z. B. "RESERVIERT" oder "STORNIERT"
     */
    void aktualisieren(Ausleihe ausleihe, String ereignis);
}
