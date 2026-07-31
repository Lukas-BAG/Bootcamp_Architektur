package factorymethod;

/*
 * ÜBUNGSZIEL — die eigentliche Factory Method
 * ------------------------------------------------
 * Hier entscheidet sich, welche konkrete Klasse erzeugt wird — der
 * aufrufende Code (siehe Main.java) übergibt nur einen Typ-String und
 * bekommt ein fertiges Dokument zurück, ohne "new PdfDokument()" oder
 * "new WordDokument()" selbst zu schreiben. Das entkoppelt den Aufrufer
 * vollständig von den konkreten Klassen.
 */
public class DokumentFactory {

    public static Dokument erstelleDokument(String typ) {
        // TODO: bei typ.equals("pdf") ein neues PdfDokument zurückgeben.
        // TODO: bei typ.equals("word") ein neues WordDokument zurückgeben.
        // TODO: bei jedem anderen Typ eine IllegalArgumentException werfen,
        //       z. B. throw new IllegalArgumentException("Unbekannter Dokumenttyp: " + typ);
        return null; // Platzhalter-Rückgabe, bis die TODOs oben erledigt sind.
    }
}
