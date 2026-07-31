package isp;

/**
 * Fuehrt beide Wege aus und vergleicht sie: den "Vorher"-Weg mit
 * einem fetten DruckerVorher-Interface (bereits fertig, dient als
 * Demonstration des Problems) gegen den "Nachher"-Weg mit
 * aufgeteilten Interfaces (deine Aufgabe - siehe TODOs in
 * Tintenstrahldrucker und Multifunktionsdrucker).
 *
 * Dieses Programm compiliert und laeuft von Anfang an, zeigt dir
 * aber "[FEHLT]" bei allem, was noch nicht implementiert ist.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== ISP-Uebung: Ein fettes Interface aufsplitten ===\n");

        System.out.println("-- Referenz: DruckerVorher (ein Interface fuer alles) --");
        TintenstrahldruckerVorher vorher = new TintenstrahldruckerVorher();
        System.out.println(vorher.drucken("Rechnung.pdf"));
        try {
            vorher.scannen("Rechnung.pdf");
        } catch (UnsupportedOperationException e) {
            System.out.println("[ERWARTETER FEHLER] " + e.getMessage()
                    + "  <- erzwungen durch DruckerVorher, obwohl dieses Geraet gar nicht scannen kann.");
        }

        System.out.println("\n-- Deine Aufgabe: aufgeteilte Interfaces --");
        Tintenstrahldrucker drucker = new Tintenstrahldrucker();
        pruefen("Tintenstrahldrucker.drucken()", "Gedruckt: Rechnung.pdf", drucker.drucken("Rechnung.pdf"));

        Multifunktionsdrucker mfg = new Multifunktionsdrucker();
        pruefen("Multifunktionsdrucker.drucken()", "Gedruckt: Vertrag.pdf", mfg.drucken("Vertrag.pdf"));
        pruefen("Multifunktionsdrucker.scannen()", "Gescannt: Vertrag.pdf", mfg.scannen("Vertrag.pdf"));
        pruefen("Multifunktionsdrucker.faxen()", "Gefaxt an 0123456: Vertrag.pdf", mfg.faxen("Vertrag.pdf", "0123456"));

        System.out.println("\nHinweis: Tintenstrahldrucker implementiert NUR Druckbar - es gibt");
        System.out.println("bei ihm gar keine scannen()/faxen()-Methode mehr, die man versehentlich");
        System.out.println("aufrufen und die zur Laufzeit abstuerzen koennte.");
    }

    private static void pruefen(String schritt, String erwartet, String tatsaechlich) {
        boolean ok = erwartet.equals(tatsaechlich);
        System.out.println((ok ? "[OK]    " : "[FEHLT] ") + schritt
                + " -> erwartet=\"" + erwartet + "\", tatsaechlich=\"" + tatsaechlich + "\"");
    }
}
