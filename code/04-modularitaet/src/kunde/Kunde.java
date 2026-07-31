package kunde;

import bestellung.Bestellung;

import java.util.ArrayList;
import java.util.List;

/*
 * ÜBUNGSZIEL — Modul 04: Zyklische Abhängigkeiten auflösen
 * ══════════════════════════════════════════════════════
 *
 * Diese Klasse hat aktuell ein Problem: Sie importiert "bestellung.Bestellung",
 * damit ein Kunde die Summe seiner Bestellungen ausrechnen kann. Gleichzeitig
 * importiert bestellung.Bestellung (siehe die Datei im Nachbar-Package) diese
 * Klasse "Kunde", um an den Namen des Kunden zu kommen.
 *
 * Ergebnis: kunde ↔ bestellung ist ein ZYKLUS. Java lässt dich das zwar
 * problemlos kompilieren (anders als z. B. Modul-Systeme mit echten
 * Zyklus-Checks) — aber verstehen, testen oder unabhängig ändern lässt sich
 * keines der beiden Packages mehr. Das ist das "Verständnisproblem", um das es
 * in dieser Übung geht. Sieh dir Main.java an für die ausführliche Erklärung.
 *
 * DEINE AUFGABE (bitte in dieser Reihenfolge über alle Dateien hinweg):
 *   TODO 1 — zuerst in gemeinsam/Kundenreferenz.java
 *   TODO 2 — hier in dieser Datei (zwei Teilschritte, siehe unten)
 *   TODO 3 — in bestellung/Bestellung.java
 *   TODO 4 — in Main.java
 *
 * Die Grundidee: Kunde muss GAR NICHTS über Bestellungen wissen. Dass ein Kunde
 * bisher seine eigenen Bestellungen verwaltet hat, war die eigentlich unnötige
 * Abhängigkeitsrichtung (vgl. Modul 04, Kapitel 3 "Abhängigkeitsrichtung" und
 * Kapitel 4 "Zyklische Abhängigkeiten" im Lehrkurs). Am Ende hängt NUR NOCH
 * bestellung von einer stabilen Abstraktion aus gemeinsam ab — nicht mehr von
 * der konkreten Klasse Kunde. Und kunde hängt überhaupt nicht mehr von
 * bestellung ab. Der Zyklus ist damit vollständig aufgelöst.
 */
public class Kunde {

    private final String name;
    private final String kundennummer;

    /*
     * TODO 2a: Entferne dieses Feld sowie die beiden Methoden
     * bestellungHinzufuegen(...) und gesamtausgaben() weiter unten
     * VOLLSTÄNDIG aus dieser Klasse. Kunde soll nicht wissen müssen, welche
     * Bestellungen zu ihm gehören — diese Zuordnung übernimmt ab jetzt
     * Main.java direkt (siehe TODO 4 dort).
     *
     * TODO 2b: Entferne danach den "import bestellung.Bestellung;" ganz oben
     * in dieser Datei — er wird nicht mehr gebraucht, sobald 2a erledigt ist.
     * Ergänze stattdessen "implements gemeinsam.Kundenreferenz" an der
     * Klassendeklaration oben (nachdem du TODO 1 in Kundenreferenz.java
     * erledigt hast) und setze ein @Override über getName(). Damit hängt
     * kunde nicht mehr von bestellung ab, sondern nur noch von der stabilen,
     * gemeinsamen Abstraktion — der Zyklus ist von dieser Seite aus
     * durchbrochen.
     */
    private final List<Bestellung> bestellungen = new ArrayList<>();

    public Kunde(String name, String kundennummer) {
        this.name = name;
        this.kundennummer = kundennummer;
    }

    public String getName() {
        return name;
    }

    public String getKundennummer() {
        return kundennummer;
    }

    /* TODO 2a betrifft auch die beiden folgenden Methoden — siehe oben. */
    public void bestellungHinzufuegen(Bestellung bestellung) {
        bestellungen.add(bestellung);
    }

    public double gesamtausgaben() {
        double summe = 0;
        for (Bestellung b : bestellungen) {
            summe += b.getBetrag();
        }
        return summe;
    }
}
