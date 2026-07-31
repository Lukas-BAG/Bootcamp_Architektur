package factorymethod;

/*
 * ÜBUNGSZIEL — konkretes Produkt
 * --------------------------------
 * Ein "konkretes Produkt" im Sinne des Patterns. Bereits fertig
 * implementiert — die eigentliche Übung liegt in DokumentFactory.java.
 */
public class PdfDokument implements Dokument {

    @Override
    public String oeffnen() {
        return "Öffne PDF-Dokument mit dem PDF-Renderer.";
    }
}
