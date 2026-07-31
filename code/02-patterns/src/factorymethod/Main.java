package factorymethod;

/*
 * ÜBUNGSZIEL — Selbstgrade dich!
 * --------------------------------
 * Läuft von Anfang an ohne Absturz (auch wenn erstelleDokument() noch null
 * zurückgibt). Erledige das TODO in DokumentFactory.java, dann sollten
 * beide Zeilen "OK" zeigen.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Factory Method: DokumentFactory ===");
        test("pdf", "Öffne PDF-Dokument mit dem PDF-Renderer.");
        test("word", "Öffne Word-Dokument mit dem Textverarbeitungsmodul.");
    }

    private static void test(String typ, String erwartet) {
        Dokument dokument = DokumentFactory.erstelleDokument(typ);
        String tatsaechlich = dokument == null ? "(null - Factory noch nicht implementiert)" : dokument.oeffnen();
        boolean ok = erwartet.equals(tatsaechlich);
        System.out.printf("Typ '%-4s' erwartet: %-45s tatsächlich: %-45s %s%n",
                typ, erwartet, tatsaechlich, ok ? "OK" : "-- noch nicht fertig --");
    }
}
