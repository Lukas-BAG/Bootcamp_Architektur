package srp;

/**
 * AUFGABE SRP (Teil 2/3) — Verantwortlichkeit "Drucken".
 * ---------------------------------------------------------------
 * Diese Klasse kuemmert sich NUR um die Text-Formatierung fuer den
 * Ausdruck. Sie bekommt den bereits berechneten Gesamtbetrag von
 * aussen uebergeben (von RechnungsBerechner) - sie berechnet ihn
 * nicht selbst noch einmal. Das ist Absicht: Wuerde diese Klasse
 * auch berechnen, waeren wir wieder bei zwei Verantwortlichkeiten
 * in einer Klasse.
 *
 * TODO: Implementiere drucken(...) so, dass sie genau den gleichen
 *       Text zurueckgibt wie RechnungVorher.drucken():
 *       "Rechnung fuer <Kunde>: <Betrag mit 2 Nachkommastellen> EUR"
 */
public class RechnungsDrucker {

    public String drucken(Rechnung rechnung, double gesamtbetrag) {
        // TODO: "Rechnung fuer " + rechnung.getKunde() + ": " + String.format("%.2f", gesamtbetrag) + " EUR" zurueckgeben.
        return ""; // Sicherer Platzhalter.
    }
}
