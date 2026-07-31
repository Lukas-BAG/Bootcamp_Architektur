package decorator;

/*
 * ÜBUNGSZIEL — Selbstgrade dich!
 * --------------------------------
 * Läuft von Anfang an ohne Absturz. Erledige die TODOs in
 * MilchDecorator.java und ZuckerDecorator.java, dann sollten beide Zeilen
 * "OK" zeigen.
 */
public class Main {

    public static void main(String[] args) {
        Kaffee bestellung = new ZuckerDecorator(new MilchDecorator(new Espresso()));

        String erwarteteBeschreibung = "Espresso, Milch, Zucker";
        double erwarteterPreis = 2.00 + 0.50 + 0.20;

        System.out.println("=== Decorator Pattern: Kaffee-Bestellung ===");

        String tatsaechlicheBeschreibung = bestellung.beschreibung();
        boolean beschreibungOk = erwarteteBeschreibung.equals(tatsaechlicheBeschreibung);
        System.out.printf("Beschreibung erwartet: %-28s tatsächlich: %-28s %s%n",
                erwarteteBeschreibung, tatsaechlicheBeschreibung, beschreibungOk ? "OK" : "-- noch nicht fertig --");

        double tatsaechlicherPreis = bestellung.preis();
        boolean preisOk = Math.abs(erwarteterPreis - tatsaechlicherPreis) < 0.001;
        System.out.printf("Preis        erwartet: %6.2f €                    tatsächlich: %6.2f €                    %s%n",
                erwarteterPreis, tatsaechlicherPreis, preisOk ? "OK" : "-- noch nicht fertig --");
    }
}
