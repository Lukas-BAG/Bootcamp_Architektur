import bestellung.Bestellung;
import kunde.Kunde;

/*
 * ÜBUNGSZIEL — Modul 04: Zyklische Abhängigkeiten auflösen
 * ══════════════════════════════════════════════════════
 *
 * Dieses Programm läuft SOFORT, ohne dass du etwas ändern musst — probier es
 * aus (Rechtsklick auf diese Datei in IntelliJ → Run 'Main.main()'). Es zeigt
 * dir den "VORHER"-Zustand: die Packages kunde und bestellung hängen
 * wechselseitig voneinander ab (siehe die Kommentare in kunde/Kunde.java und
 * bestellung/Bestellung.java für die Details).
 *
 * Deine Aufgabe: Löse die TODOs 1 bis 4 (verteilt über vier Dateien:
 * gemeinsam/Kundenreferenz.java, kunde/Kunde.java, bestellung/Bestellung.java
 * und diese Datei hier) in genau dieser Reihenfolge. Am Ende hängt bestellung
 * nur noch von der Abstraktion gemeinsam.Kundenreferenz ab, und kunde hängt
 * überhaupt nicht mehr von bestellung ab — der Zyklus ist aufgelöst.
 *
 * Achtung: Solange du nur EINEN Teil der TODOs erledigt hast, kompiliert das
 * Projekt möglicherweise nicht mehr — das ist normal bei einem Refactoring,
 * das mehrere Dateien gleichzeitig betrifft. Führe TODO 1 bis 4 der Reihe
 * nach komplett aus, dann kompiliert und läuft alles wieder, diesmal ohne
 * Zyklus.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== VORHER: zyklische Abhaengigkeit zwischen kunde und bestellung ===");

        Kunde kunde = new Kunde("Erika Musterfrau", "K-1001");
        Bestellung b1 = new Bestellung(kunde, 49.90);
        Bestellung b2 = new Bestellung(kunde, 15.00);

        // Kunde muss "wissen", welche Bestellungen zu ihm gehoeren, um seine
        // Gesamtausgaben selbst auszurechnen -> genau das ist die unnoetige
        // Abhaengigkeit kunde -> bestellung, die zum Zyklus fuehrt.
        kunde.bestellungHinzufuegen(b1);
        kunde.bestellungHinzufuegen(b2);

        System.out.println("Kunde: " + kunde.getName());
        System.out.println("Gesamtausgaben (berechnet INNERHALB von Kunde, ueber kunde.gesamtausgaben()): "
                + kunde.gesamtausgaben());
        System.out.println("Bestellung 1 gehoert zu: " + b1.kundenname());
        System.out.println();
        System.out.println("Problem: kunde.Kunde importiert bestellung.Bestellung (fuer die Liste der");
        System.out.println("Bestellungen), UND bestellung.Bestellung importiert kunde.Kunde (fuer den");
        System.out.println("Kundennamen). Keine der beiden Klassen laesst sich mehr unabhaengig lesen,");
        System.out.println("testen oder austauschen -- ein klassischer Zyklus (siehe Lehrkurs Modul 04,");
        System.out.println("Kapitel 4).");
        System.out.println();
        System.out.println("=== Deine Aufgabe: loese TODO 1 bis TODO 4 in den vier Dateien dieses Projekts ===");

        /*
         * TODO 4 (zuletzt, nachdem TODO 1-3 in den anderen Dateien erledigt
         * sind): Kunde kennt seine Bestellungen dann nicht mehr. Verwalte die
         * Zuordnung Kunde -> Bestellungen deshalb HIER in Main, z. B. ueber
         * eine eigene Liste, und berechne die Gesamtausgaben direkt hier,
         * statt ueber eine Methode auf Kunde:
         *
         *   java.util.List<Bestellung> bestellungenVonErika =
         *       java.util.List.of(b1, b2);
         *   double summe = 0;
         *   for (Bestellung b : bestellungenVonErika) {
         *       summe += b.getBetrag();
         *   }
         *
         *   System.out.println("=== NACHHER: Abhaengigkeiten laufen nur noch in eine Richtung ===");
         *   System.out.println("Kunde: " + kunde.getName());
         *   System.out.println("Gesamtausgaben (jetzt AUSSERHALB von Kunde, hier in Main berechnet): " + summe);
         *   System.out.println("Bestellung 1 gehoert zu: " + b1.kundenname());
         *   System.out.println();
         *   System.out.println("kunde.Kunde importiert bestellung.Bestellung nicht mehr. bestellung.Bestellung");
         *   System.out.println("haengt nur noch von der Abstraktion gemeinsam.Kundenreferenz ab. Kein Zyklus mehr.");
         *
         * Entferne die /* ... *\/-Kommentarzeichen um den Block oben, sobald
         * du bereit bist, und loesche im Gegenzug den "vorher"-Block weiter
         * oben in dieser Methode (die Zeilen mit kunde.bestellungHinzufuegen
         * und kunde.gesamtausgaben() gibt es dann ja nicht mehr).
         */
    }
}
