package ausleihe.benachrichtigung;

import ausleihe.Ausleihe;

/*
 * Übungsziel (Modul 05 · Fallstudie — Observer-Pattern, konkreter Beobachter):
 * Dieser Beobachter steht stellvertretend für einen echten E-Mail-Versand
 * (in einem realen System wäre das ein Adapter, der einen Mailserver
 * anspricht). Für diese Übung genügt eine Konsolenausgabe, damit du das
 * Verhalten ohne externe Abhängigkeiten nachvollziehen kannst.
 *
 * Kein TODO in dieser Datei — sie ist bereits vollständig und dient dir als
 * Vorlage für WartelisteBenachrichtigung (siehe Nachbardatei, dort wartet
 * ein TODO).
 */
public class KonsolenBenachrichtigung implements AusleiheBeobachter {

    @Override
    public void aktualisieren(Ausleihe ausleihe, String ereignis) {
        System.out.println("[E-Mail an " + ausleihe.getMitglied().getName() + "] "
                + "Deine Ausleihe von \"" + ausleihe.getWerkzeug().getName() + "\" hat den Status: " + ereignis);
    }
}
