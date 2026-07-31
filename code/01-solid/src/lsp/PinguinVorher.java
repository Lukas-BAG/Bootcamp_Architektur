package lsp;

/**
 * AUFGABE LSP — "Vorher"-Zustand, die eigentliche Verletzung.
 * ---------------------------------------------------------------
 * WICHTIG: Diese Klasse ist bereits fertig und dient nur als
 * Referenz zum Vergleich. Du musst und sollst sie NICHT aendern.
 *
 * PinguinVorher erbt von VogelVorher - und damit auch fliegen(),
 * obwohl ein Pinguin nicht fliegen kann. Die einzige "Loesung" hier
 * ist, die geerbte Methode zu ueberschreiben und eine Exception zu
 * werfen.
 *
 * Das ist die klassische LSP-Verletzung: ueberall im Code, wo mit
 * einer VogelVorher-Referenz gearbeitet und fliegen() aufgerufen
 * wird (z.B. in einer Schleife ueber eine Liste von Voegeln), kann
 * ein PinguinVorher-Objekt das Programm zum Absturz bringen - obwohl
 * der aufrufende Code laut Vertrag der Basisklasse (fliegen() gibt
 * einen String zurueck) niemals eine Exception erwarten musste.
 * Siehe Main.java fuer die Demonstration dieses Absturzes.
 */
public class PinguinVorher extends VogelVorher {

    public PinguinVorher(String name) {
        super(name);
    }

    @Override
    public String fliegen() {
        throw new UnsupportedOperationException(name + " kann nicht fliegen!");
    }
}
