package strategy;

/*
 * ÜBUNGSZIEL — Selbstgrade dich!
 * --------------------------------
 * Führe diese Klasse aus (Rechtsklick -> Run 'Main.main()' in IntelliJ).
 * Sie läuft von Anfang an, ohne Absturz — aber erst wenn du die TODOs in
 * StammkundenRabatt.java, PremiumRabatt.java und Warenkorb.java erledigt
 * hast, stimmen "erwartet" und "tatsächlich" überein.
 */
public class Main {

    public static void main(String[] args) {
        double bestellwert = 200.0;
        Warenkorb warenkorb = new Warenkorb();

        System.out.println("=== Strategy Pattern: Rabattberechnung (Bestellwert 200,00 €) ===");
        testStrategie(warenkorb, new StandardRabatt(), "StandardRabatt (0%)", bestellwert, 200.0);
        testStrategie(warenkorb, new StammkundenRabatt(), "StammkundenRabatt (5%)", bestellwert, 190.0);
        testStrategie(warenkorb, new PremiumRabatt(), "PremiumRabatt (15%)", bestellwert, 170.0);
    }

    private static void testStrategie(Warenkorb warenkorb, RabattStrategy strategie, String name,
                                       double bestellwert, double erwartet) {
        warenkorb.setStrategie(strategie);
        double tatsaechlich = warenkorb.berechneEndpreis(bestellwert);
        boolean ok = Math.abs(erwartet - tatsaechlich) < 0.001;
        System.out.printf("%-24s erwartet: %6.2f €   tatsächlich: %6.2f €   %s%n",
                name, erwartet, tatsaechlich, ok ? "OK" : "-- noch nicht fertig --");
    }
}
