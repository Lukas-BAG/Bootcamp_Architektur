package lsp;

/**
 * Fuehrt beide Wege aus und vergleicht sie: den "Vorher"-Weg, bei
 * dem PinguinVorher.fliegen() zur Laufzeit abstuerzt (bereits
 * fertig, dient als Demonstration), gegen den "Nachher"-Weg mit
 * einer eigenen Flugfaehig-Abstraktion (deine Aufgabe - siehe TODOs
 * in Sperling und Pinguin).
 *
 * Dieses Programm compiliert und laeuft von Anfang an, zeigt dir
 * aber "[FEHLT]" bei allem, was noch nicht implementiert ist.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== LSP-Uebung: Vogel/Pinguin richtig modellieren ===\n");

        System.out.println("-- Referenz: VogelVorher/PinguinVorher (fliegen() fuer alle geerbt) --");
        VogelVorher spatzVorher = new VogelVorher("Spatz");
        System.out.println(spatzVorher.fliegen());

        VogelVorher pinguinVorher = new PinguinVorher("Pinguin");
        try {
            System.out.println(pinguinVorher.fliegen());
        } catch (UnsupportedOperationException e) {
            System.out.println("[ERWARTETER ABSTURZ] " + e.getMessage()
                    + "  <- genau das ist die LSP-Verletzung: der Vertrag von VogelVorher.fliegen() wird gebrochen.");
        }

        System.out.println("\n-- Deine Aufgabe: Flugfaehig als eigene Abstraktion --");
        Sperling sperling = new Sperling("Sperling");
        pruefen("Sperling.fliegen()", "Der Sperling fliegt.", sperling.fliegen());

        Pinguin pinguin = new Pinguin("Pinguin");
        pruefen("Pinguin.schwimmen()", "Der Pinguin schwimmt.", pinguin.schwimmen());

        System.out.println("\nHinweis: Pinguin hat gar keine fliegen()-Methode mehr. Ein Aufruf");
        System.out.println("wie 'pinguin.fliegen()' waere ein KOMPILIERFEHLER - nicht erst ein");
        System.out.println("Laufzeitfehler wie oben bei PinguinVorher. Das ist der Gewinn von");
        System.out.println("LSP-konformem Design: falsche Aufrufe werden schon beim Compilieren verhindert.");
    }

    private static void pruefen(String schritt, String erwartet, String tatsaechlich) {
        boolean ok = erwartet.equals(tatsaechlich);
        System.out.println((ok ? "[OK]    " : "[FEHLT] ") + schritt
                + " -> erwartet=\"" + erwartet + "\", tatsaechlich=\"" + tatsaechlich + "\"");
    }
}
