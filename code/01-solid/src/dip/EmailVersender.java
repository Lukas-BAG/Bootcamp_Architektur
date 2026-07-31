package dip;

/**
 * AUFGABE DIP (1/2) — Low-Level-Klasse, die von der Abstraktion abhaengt.
 * ---------------------------------------------------------------
 * TODO: Implementiere senden(...) so, dass sie den gleichen Text
 *       liefert wie EmailVersenderVorher.senden():
 *       "E-Mail an <Empfaenger>: <Text>"
 */
public class EmailVersender implements Nachrichtenversender {

    @Override
    public String senden(String empfaenger, String text) {
        // TODO: "E-Mail an " + empfaenger + ": " + text zurueckgeben.
        return ""; // Sicherer Platzhalter.
    }
}
