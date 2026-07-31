package dip;

/**
 * Fuehrt beide Wege aus und vergleicht sie: den "Vorher"-Weg, bei
 * dem BenachrichtigungsdienstVorher seine Abhaengigkeit selbst
 * erzeugt (bereits fertig, dient als Demonstration), gegen den
 * "Nachher"-Weg mit Konstruktor-Injection ueber das
 * Nachrichtenversender-Interface (deine Aufgabe - siehe TODOs in
 * EmailVersender und SmsVersender).
 *
 * Dieses Programm compiliert und laeuft von Anfang an, zeigt dir
 * aber "[FEHLT]" bei allem, was noch nicht implementiert ist.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== DIP-Uebung: Abhaengigkeit von der Abstraktion statt vom Konkreten ===\n");

        System.out.println("-- Referenz: BenachrichtigungsdienstVorher (erzeugt EmailVersenderVorher selbst) --");
        BenachrichtigungsdienstVorher vorher = new BenachrichtigungsdienstVorher();
        System.out.println(vorher.benachrichtige("mia@example.com", "Ihre Bestellung ist unterwegs."));

        System.out.println("\n-- Deine Aufgabe: EmailVersender/SmsVersender ueber das Interface einbinden --");
        Benachrichtigungsdienst perEmail = new Benachrichtigungsdienst(new EmailVersender());
        pruefen("Benachrichtigung per E-Mail",
                "E-Mail an mia@example.com: Ihre Bestellung ist unterwegs.",
                perEmail.benachrichtige("mia@example.com", "Ihre Bestellung ist unterwegs."));

        Benachrichtigungsdienst perSms = new Benachrichtigungsdienst(new SmsVersender());
        pruefen("Benachrichtigung per SMS",
                "SMS an 0176123456: Ihre Bestellung ist unterwegs.",
                perSms.benachrichtige("0176123456", "Ihre Bestellung ist unterwegs."));

        System.out.println("\nHinweis: Benachrichtigungsdienst.java musste fuer den zweiten");
        System.out.println("Versandweg (SMS) NICHT geaendert werden - nur eine andere");
        System.out.println("Implementierung wurde beim Erzeugen uebergeben. Genau das ist DIP.");
    }

    private static void pruefen(String schritt, String erwartet, String tatsaechlich) {
        boolean ok = erwartet.equals(tatsaechlich);
        System.out.println((ok ? "[OK]    " : "[FEHLT] ") + schritt
                + " -> erwartet=\"" + erwartet + "\", tatsaechlich=\"" + tatsaechlich + "\"");
    }
}
