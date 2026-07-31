package isp;

/**
 * AUFGABE ISP (1/2) — der einfache Drucker, richtig modelliert.
 * ---------------------------------------------------------------
 * Diese Klasse implementiert absichtlich NUR Druckbar - sie muss
 * (anders als im "Vorher"-Zustand) keine scannen()/faxen()-Methoden
 * mehr vortaeuschen, die sie sowieso nicht anbieten kann.
 *
 * TODO: Implementiere drucken(...) so, dass sie den gleichen Text
 *       liefert wie TintenstrahldruckerVorher.drucken():
 *       "Gedruckt: <Dokument>"
 */
public class Tintenstrahldrucker implements Druckbar {

    @Override
    public String drucken(String dokument) {
        // TODO: "Gedruckt: " + dokument zurueckgeben.
        return ""; // Sicherer Platzhalter.
    }
}
