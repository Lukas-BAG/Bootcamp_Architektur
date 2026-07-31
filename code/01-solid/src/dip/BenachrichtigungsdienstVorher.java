package dip;

/**
 * AUFGABE DIP — "Vorher"-Zustand, die High-Level-Klasse.
 * ---------------------------------------------------------------
 * WICHTIG: Diese Klasse ist bereits fertig und dient nur als
 * Referenz zum Vergleich. Du musst und sollst sie NICHT aendern.
 *
 * Die High-Level-Klasse (Geschaeftslogik: "wie benachrichtige ich
 * jemanden") erzeugt sich ihre Low-Level-Abhaengigkeit SELBST mit
 * "new". Damit haengt wichtiger Geschaeftslogik-Code direkt von
 * einer austauschbaren Implementierungsdetail-Klasse ab - willst du
 * spaeter SMS statt E-Mail verschicken, musst du GENAU DIESE Klasse
 * aendern (und jede andere Stelle im Code, die ebenfalls
 * "new EmailVersenderVorher()" geschrieben hat).
 */
public class BenachrichtigungsdienstVorher {

    private final EmailVersenderVorher versender = new EmailVersenderVorher();

    public String benachrichtige(String empfaenger, String text) {
        return versender.senden(empfaenger, text);
    }
}
