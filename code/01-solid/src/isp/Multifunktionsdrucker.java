package isp;

/**
 * AUFGABE ISP (2/2) — ein Geraet, das tatsaechlich alles kann.
 * ---------------------------------------------------------------
 * Dieses Geraet implementiert alle drei kleinen Interfaces - das ist
 * ISP-konform, weil es hier um eine ECHTE Faehigkeit geht, keine
 * erzwungene wie im "Vorher"-Zustand.
 *
 * TODO: Implementiere alle drei Methoden analog zu
 *       TintenstrahldruckerVorher, mit passenden Vorsilben:
 *       drucken -> "Gedruckt: <Dokument>"
 *       scannen -> "Gescannt: <Dokument>"
 *       faxen   -> "Gefaxt an <Nummer>: <Dokument>"
 */
public class Multifunktionsdrucker implements Druckbar, Scanbar, Faxbar {

    @Override
    public String drucken(String dokument) {
        // TODO: "Gedruckt: " + dokument zurueckgeben.
        return ""; // Sicherer Platzhalter.
    }

    @Override
    public String scannen(String dokument) {
        // TODO: "Gescannt: " + dokument zurueckgeben.
        return ""; // Sicherer Platzhalter.
    }

    @Override
    public String faxen(String dokument, String nummer) {
        // TODO: "Gefaxt an " + nummer + ": " + dokument zurueckgeben.
        return ""; // Sicherer Platzhalter.
    }
}
