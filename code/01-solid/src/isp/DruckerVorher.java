package isp;

/**
 * AUFGABE ISP — "Vorher"-Zustand, das "fette" Interface.
 * ---------------------------------------------------------------
 * WICHTIG: Dieses Interface (und TintenstrahldruckerVorher) ist
 * bereits fertig und dient nur als Referenz zum Vergleich. Du musst
 * und sollst es NICHT aendern.
 *
 * Ein Interface, das ALLE Faehigkeiten eines High-End-Multifunktions-
 * geraets verlangt - auch von Klassen, die davon nur einen Bruchteil
 * tatsaechlich koennen.
 */
public interface DruckerVorher {
    String drucken(String dokument);
    String scannen(String dokument);
    String faxen(String dokument, String nummer);
}
