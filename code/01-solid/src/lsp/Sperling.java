package lsp;

/**
 * AUFGABE LSP (1/2) — ein Vogel, der wirklich fliegen kann.
 * ---------------------------------------------------------------
 * TODO: Implementiere fliegen() so, dass sie den gleichen Text
 *       liefert wie VogelVorher.fliegen(): "Der <Name> fliegt."
 *       Nutze dafuer getName() aus VogelNachher.
 */
public class Sperling extends VogelNachher implements Flugfaehig {

    public Sperling(String name) {
        super(name);
    }

    @Override
    public String fliegen() {
        // TODO: "Der " + getName() + " fliegt." zurueckgeben.
        return ""; // Sicherer Platzhalter.
    }
}
