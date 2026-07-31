package dip;

/**
 * "Nachher"-Zustand: die High-Level-Klasse haengt nur vom Interface
 * Nachrichtenversender ab. Welche konkrete Klasse tatsaechlich
 * verwendet wird, entscheidet der Aufrufer (siehe Main.java) beim
 * Erzeugen des Objekts - nicht diese Klasse selbst.
 *
 * Das ist Dependency Injection ueber den Konstruktor: die konkrete
 * Technik wird "von aussen hineingereicht", statt selbst mit "new"
 * erzeugt zu werden. Diese Klasse ist bereits fertig, keine TODOs
 * hier - deine Aufgabe liegt in EmailVersender und SmsVersender.
 */
public class Benachrichtigungsdienst {

    private final Nachrichtenversender versender;

    public Benachrichtigungsdienst(Nachrichtenversender versender) {
        this.versender = versender;
    }

    public String benachrichtige(String empfaenger, String text) {
        return versender.senden(empfaenger, text);
    }
}
