package srp;

import java.util.ArrayList;
import java.util.List;

/**
 * AUFGABE SRP (Teil 3/3) — Verantwortlichkeit "Speichern".
 * ---------------------------------------------------------------
 * Diese Klasse kuemmert sich NUR um die Speicherung. Hier wird eine
 * einfache Liste als "Datenbank" simuliert, damit die Uebung ohne
 * echte Datenbank-Anbindung lauffaehig ist - das Prinzip bleibt
 * dasselbe wie bei einer echten DB.
 *
 * TODO: Implementiere speichern(...) so, dass ein Eintrag
 *       "<Kunde>:<Betrag mit 2 Nachkommastellen>" zur DATENBANK
 *       hinzugefuegt wird und true zurueckgegeben wird, wenn das
 *       Hinzufuegen erfolgreich war (List.add(...) gibt das schon zurueck).
 */
public class RechnungsSpeicher {

    private static final List<String> DATENBANK = new ArrayList<>();

    public boolean speichern(Rechnung rechnung, double gesamtbetrag) {
        // TODO: DATENBANK.add(rechnung.getKunde() + ":" + String.format("%.2f", gesamtbetrag)) zurueckgeben.
        return false; // Sicherer Platzhalter.
    }

    public static List<String> getDatenbank() {
        return DATENBANK;
    }
}
