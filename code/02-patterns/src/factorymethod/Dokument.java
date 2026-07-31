package factorymethod;

/*
 * ÜBUNGSZIEL — Factory Method (erzeugend)
 * ------------------------------------------
 * Das Ziel dieses Patterns: der aufrufende Code soll ein Dokument bekommen,
 * OHNE zu wissen (und ohne "new PdfDokument()" oder "new WordDokument()"
 * selbst schreiben zu müssen), welche konkrete Klasse dahintersteckt. Er
 * kennt nur diese Schnittstelle. Welche konkrete Klasse erzeugt wird,
 * entscheidet DokumentFactory.java.
 */
public interface Dokument {

    /** Liefert eine Beschreibung, wie das Dokument geöffnet würde. */
    String oeffnen();
}
