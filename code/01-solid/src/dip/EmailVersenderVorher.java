package dip;

/**
 * AUFGABE DIP — "Vorher"-Zustand, die konkrete Low-Level-Klasse.
 * ---------------------------------------------------------------
 * WICHTIG: Diese Klasse ist bereits fertig und dient nur als
 * Referenz zum Vergleich. Du musst und sollst sie NICHT aendern.
 *
 * Bewusst OHNE Interface - genau das ist der Punkt: im "Vorher"-
 * Zustand gibt es keine Abstraktion, nur diese eine konkrete Klasse,
 * die von BenachrichtigungsdienstVorher direkt mit "new" erzeugt wird.
 */
public class EmailVersenderVorher {

    public String senden(String empfaenger, String text) {
        return "E-Mail an " + empfaenger + ": " + text;
    }
}
