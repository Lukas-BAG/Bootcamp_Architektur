package lsp;

/**
 * AUFGABE LSP — "Vorher"-Zustand, Basisklasse.
 * ---------------------------------------------------------------
 * WICHTIG: Diese Klasse (und PinguinVorher) ist bereits fertig und
 * dient nur als Referenz zum Vergleich. Du musst und sollst sie
 * NICHT aendern.
 *
 * Vogel definiert fliegen() als Teil des Vertrags, den JEDE
 * Unterklasse erbt - unabhaengig davon, ob sie diesen Vertrag
 * tatsaechlich einhalten kann.
 */
public class VogelVorher {

    protected final String name;

    public VogelVorher(String name) {
        this.name = name;
    }

    public String fliegen() {
        return "Der " + name + " fliegt.";
    }
}
