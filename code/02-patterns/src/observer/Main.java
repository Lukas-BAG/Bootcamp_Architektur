package observer;

/*
 * ÜBUNGSZIEL — Selbstgrade dich!
 * --------------------------------
 * Läuft von Anfang an ohne Absturz — solange die TODOs in
 * WarenkorbSubjekt.java, PreisAnzeige.java und BestellUebersicht.java
 * offen sind, erscheint unter "Tatsächliche Ausgabe:" einfach nichts.
 * Vergleiche das mit der erwarteten Ausgabe darüber.
 */
public class Main {

    public static void main(String[] args) {
        WarenkorbSubjekt warenkorb = new WarenkorbSubjekt();
        warenkorb.registriere(new PreisAnzeige());
        warenkorb.registriere(new BestellUebersicht());

        System.out.println("=== Observer Pattern: Warenkorb-Benachrichtigung ===");
        System.out.println("Erwartete Ausgabe (sobald alle TODOs erledigt sind):");
        System.out.println("  [Preisanzeige] aktualisiert wegen: Artikel hinzugefügt");
        System.out.println("  [Bestellübersicht] aktualisiert wegen: Artikel hinzugefügt");
        System.out.println();
        System.out.println("Tatsächliche Ausgabe:");
        warenkorb.benachrichtigeAlle("Artikel hinzugefügt");
        System.out.println();
        System.out.println("(Steht oben nichts zwischen den beiden Überschriften, sind");
        System.out.println(" registriere()/benachrichtigeAlle()/aktualisieren() noch nicht fertig.)");
    }
}
