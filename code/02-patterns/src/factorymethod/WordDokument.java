package factorymethod;

/*
 * ÜBUNGSZIEL — konkretes Produkt
 * --------------------------------
 * Ein "konkretes Produkt" im Sinne des Patterns. Bereits fertig
 * implementiert — die eigentliche Übung liegt in DokumentFactory.java.
 */
public class WordDokument implements Dokument {

    @Override
    public String oeffnen() {
        return "Öffne Word-Dokument mit dem Textverarbeitungsmodul.";
    }
}
