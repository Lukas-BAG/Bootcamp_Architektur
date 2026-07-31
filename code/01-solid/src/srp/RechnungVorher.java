package srp;

import java.util.ArrayList;
import java.util.List;

/**
 * AUFGABE SRP — "Vorher"-Zustand.
 * ---------------------------------------------------------------
 * WICHTIG: Diese Klasse ist bereits fertig und dient nur als
 * Referenz zum Vergleich. Du musst und sollst sie NICHT aendern.
 *
 * Sie zeigt den Code-Geruch, um den es in dieser Uebung geht: EINE
 * Klasse macht DREI Dinge gleichzeitig, die eigentlich nichts
 * miteinander zu tun haben:
 *
 *   1) Sie BERECHNET den Gesamtbetrag einer Rechnung.
 *   2) Sie FORMATIERT einen Text fuer den Ausdruck.
 *   3) Sie SPEICHERT die Rechnung (hier vereinfacht: in einer Liste
 *      statt einer echten Datenbank).
 *
 * Das Problem ist nicht, dass hier drei Methoden existieren -
 * sondern dass diese Klasse damit DREI unabhaengige Gruende hat,
 * sich zu aendern:
 *   - Die Rabatt-/Steuerlogik aendert sich (Buchhaltung).
 *   - Das Layout des Ausdrucks aendert sich (Design/Marketing).
 *   - Das Speicherformat aendert sich (IT-/Datenbankteam).
 * Jedes Team, das an EINEM dieser Gruende arbeitet, riskiert dabei,
 * versehentlich Code der beiden anderen Verantwortlichkeiten mit zu
 * veraendern - weil alles in derselben Klasse liegt.
 *
 * Deine eigentliche Aufgabe liegt in RechnungsBerechner,
 * RechnungsDrucker und RechnungsSpeicher (siehe die TODOs dort):
 * baue dieselbe Funktionalitaet nach, aber sauber auf drei Klassen
 * aufgeteilt. Main.java fuehrt am Ende beide Wege nebeneinander aus.
 */
public class RechnungVorher {

    private final String kunde;
    private final double[] positionen;
    private static final List<String> DATENBANK_VORHER = new ArrayList<>();

    public RechnungVorher(String kunde, double[] positionen) {
        this.kunde = kunde;
        this.positionen = positionen;
    }

    /** Verantwortlichkeit 1: Berechnung. */
    public double berechneGesamtbetrag() {
        double summe = 0.0;
        for (double p : positionen) {
            summe += p;
        }
        return summe;
    }

    /** Verantwortlichkeit 2: Druck-Formatierung. */
    public String drucken() {
        double betrag = berechneGesamtbetrag();
        return "Rechnung fuer " + kunde + ": " + String.format("%.2f", betrag) + " EUR";
    }

    /** Verantwortlichkeit 3: Speicherung. */
    public boolean speichern() {
        double betrag = berechneGesamtbetrag();
        return DATENBANK_VORHER.add(kunde + ":" + String.format("%.2f", betrag));
    }
}
