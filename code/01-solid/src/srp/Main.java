package srp;

/**
 * Fuehrt beide Wege aus und vergleicht sie: den "Vorher"-Weg mit
 * einer einzigen Klasse fuer alles (RechnungVorher, bereits fertig)
 * gegen den "Nachher"-Weg mit drei aufgeteilten Klassen (deine
 * Aufgabe - siehe TODOs in RechnungsBerechner, RechnungsDrucker und
 * RechnungsSpeicher).
 *
 * Dieses Programm compiliert und laeuft von Anfang an, zeigt dir
 * aber "[FEHLT]" bei allem, was noch nicht implementiert ist. Fuelle
 * die TODOs eins nach dem anderen, bis ueberall "[OK]" steht.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== SRP-Uebung: Rechnung aufteilen ===\n");

        System.out.println("-- Referenz: RechnungVorher (eine Klasse, drei Aufgaben) --");
        RechnungVorher vorher = new RechnungVorher("Mia Muster", new double[]{19.99, 5.50, 120.0});
        System.out.println(vorher.drucken());
        System.out.println("Gespeichert: " + vorher.speichern());

        System.out.println("\n-- Deine Aufgabe: drei aufgeteilte Klassen --");
        Rechnung rechnung = new Rechnung("Mia Muster", new double[]{19.99, 5.50, 120.0});

        RechnungsBerechner berechner = new RechnungsBerechner();
        double betrag = berechner.berechneGesamtbetrag(rechnung);
        pruefen("1) Gesamtbetrag berechnen", "145.49", String.format("%.2f", betrag));

        RechnungsDrucker drucker = new RechnungsDrucker();
        String druckText = drucker.drucken(rechnung, betrag);
        pruefen("2) Rechnung drucken", "Rechnung fuer Mia Muster: 145.49 EUR", druckText);

        RechnungsSpeicher speicher = new RechnungsSpeicher();
        boolean gespeichert = speicher.speichern(rechnung, betrag);
        pruefen("3) Rechnung speichern", "true", String.valueOf(gespeichert));
    }

    private static void pruefen(String schritt, String erwartet, String tatsaechlich) {
        boolean ok = erwartet.equals(tatsaechlich);
        System.out.println((ok ? "[OK]    " : "[FEHLT] ") + schritt
                + " -> erwartet=\"" + erwartet + "\", tatsaechlich=\"" + tatsaechlich + "\"");
    }
}
