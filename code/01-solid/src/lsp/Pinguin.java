package lsp;

/**
 * AUFGABE LSP (2/2) — ein Vogel, der NICHT fliegen kann.
 * ---------------------------------------------------------------
 * Pinguin implementiert Flugfaehig bewusst NICHT - es gibt schlicht
 * keine fliegen()-Methode mehr. Stattdessen bekommt er eine
 * Faehigkeit, die er tatsaechlich hat: schwimmen().
 *
 * TODO: Implementiere schwimmen() so, dass sie "Der <Name> schwimmt."
 *       zurueckgibt.
 */
public class Pinguin extends VogelNachher {

    public Pinguin(String name) {
        super(name);
    }

    public String schwimmen() {
        // TODO: "Der " + getName() + " schwimmt." zurueckgeben.
        return ""; // Sicherer Platzhalter.
    }
}
