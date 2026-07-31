package isp;

/**
 * AUFGABE ISP — "Vorher"-Zustand, die eigentliche Verletzung.
 * ---------------------------------------------------------------
 * WICHTIG: Diese Klasse ist bereits fertig und dient nur als
 * Referenz zum Vergleich. Du musst und sollst sie NICHT aendern.
 *
 * Ein einfacher Tintenstrahldrucker kann NUR drucken - muss aber
 * wegen DruckerVorher auch scannen() und faxen() anbieten. Beide
 * Methoden koennen sinnvoll nur mit einer Exception "implementiert"
 * werden.
 *
 * Das Problem: jeder Aufrufer, der nur eine DruckerVorher-Referenz
 * hat, kann scannen()/faxen() aufrufen und bekommt einen Laufzeit-
 * fehler - obwohl das Interface versprochen hat, dass diese Methoden
 * existieren und funktionieren. Siehe Main.java fuer die Demonstration.
 */
public class TintenstrahldruckerVorher implements DruckerVorher {

    @Override
    public String drucken(String dokument) {
        return "Gedruckt: " + dokument;
    }

    @Override
    public String scannen(String dokument) {
        throw new UnsupportedOperationException("Dieser Drucker kann nicht scannen.");
    }

    @Override
    public String faxen(String dokument, String nummer) {
        throw new UnsupportedOperationException("Dieser Drucker kann nicht faxen.");
    }
}
