package dip;

/**
 * AUFGABE DIP (2/2) — eine ZWEITE Low-Level-Klasse, ganz ohne
 * Aenderung an Benachrichtigungsdienst.
 * ---------------------------------------------------------------
 * Das ist der eigentliche Beweis fuer DIP: diese Klasse kommt neu
 * dazu, und die High-Level-Klasse Benachrichtigungsdienst (siehe
 * dort) muss dafuer nicht ein einziges Zeichen geaendert werden -
 * sie kennt ohnehin nur das Interface Nachrichtenversender.
 *
 * TODO: Implementiere senden(...) so, dass sie zurueckgibt:
 *       "SMS an <Empfaenger>: <Text>"
 */
public class SmsVersender implements Nachrichtenversender {

    @Override
    public String senden(String empfaenger, String text) {
        // TODO: "SMS an " + empfaenger + ": " + text zurueckgeben.
        return ""; // Sicherer Platzhalter.
    }
}
