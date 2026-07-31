package ocp;

/**
 * Fuehrt beide Wege aus und vergleicht sie: den "Vorher"-Weg mit
 * einer switch-Anweisung (RabattVorher, bereits fertig) gegen den
 * "Nachher"-Weg mit einer Klasse pro Rabattart (deine Aufgabe -
 * siehe TODOs in StandardRabatt, StudentenRabatt und VipRabatt).
 *
 * Dieses Programm compiliert und laeuft von Anfang an, zeigt dir
 * aber "[FEHLT]" bei allem, was noch nicht implementiert ist.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== OCP-Uebung: switch durch Polymorphismus ersetzen ===\n");

        System.out.println("-- Referenz: RabattVorher (switch-Anweisung) --");
        RabattVorher vorher = new RabattVorher();
        System.out.printf("STANDARD: %.2f, STUDENT: %.2f, VIP: %.2f%n",
                vorher.berechnePreis("STANDARD", 100.0),
                vorher.berechnePreis("STUDENT", 100.0),
                vorher.berechnePreis("VIP", 100.0));

        System.out.println("\n-- Deine Aufgabe: eine Klasse pro Rabattart --");
        Rabatt[] rabatte = { new StandardRabatt(), new StudentenRabatt(), new VipRabatt() };
        String[] namen = { "StandardRabatt", "StudentenRabatt", "VipRabatt" };
        String[] erwartet = { "100.00", "90.00", "80.00" };

        for (int i = 0; i < rabatte.length; i++) {
            double preis = rabatte[i].berechnePreis(100.0);
            pruefen(namen[i], erwartet[i], String.format("%.2f", preis));
        }

        System.out.println("\nProbe aufs Exempel: Fuege eine vierte Klasse 'NeukundenRabatt'");
        System.out.println("hinzu, die Rabatt implementiert - du musst dafuer KEINE der");
        System.out.println("Klassen oben aendern. Genau das ist der Punkt von OCP.");
    }

    private static void pruefen(String schritt, String erwartet, String tatsaechlich) {
        boolean ok = erwartet.equals(tatsaechlich);
        System.out.println((ok ? "[OK]    " : "[FEHLT] ") + schritt
                + " -> erwartet=" + erwartet + ", tatsaechlich=" + tatsaechlich);
    }
}
