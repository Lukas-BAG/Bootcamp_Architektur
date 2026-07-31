package bestellung;

import kunde.Kunde;

/*
 * ÜBUNGSZIEL — Modul 04: Zyklische Abhängigkeiten auflösen
 * ══════════════════════════════════════════════════════
 *
 * Diese Klasse importiert "kunde.Kunde", um an den Namen des Kunden zu
 * kommen, der die Bestellung aufgegeben hat. Das Nachbar-Package kunde
 * importiert im Gegenzug "bestellung.Bestellung" (siehe kunde/Kunde.java) —
 * zusammen ergibt das einen ZYKLUS zwischen den Packages bestellung und
 * kunde.
 *
 * Das eigentliche Problem: Bestellung braucht von einem Kunden wirklich nur
 * eine winzige Information (den Namen). Trotzdem hängt Bestellung an der
 * KOMPLETTEN konkreten Klasse Kunde — inklusive aller Details, die Kunde
 * sonst noch hat oder in Zukunft bekommt. Das ist enge Kopplung über eine
 * konkrete Klasse statt über ein Interface (vgl. Modul 04, Kapitel 2).
 *
 * DEINE AUFGABE (siehe auch die TODOs in den anderen Dateien):
 *   TODO 1 — zuerst in gemeinsam/Kundenreferenz.java (falls noch nicht erledigt)
 *   TODO 2 — in kunde/Kunde.java (falls noch nicht erledigt)
 *   TODO 3 — hier in dieser Datei
 *   TODO 4 — in Main.java
 */
public class Bestellung {

    /*
     * TODO 3: Ändere den Typ dieses Feldes (und des Konstruktor-Parameters
     * unten) von der konkreten Klasse "Kunde" auf das Interface
     * "gemeinsam.Kundenreferenz". Passe den Import ganz oben entsprechend an
     * ("import gemeinsam.Kundenreferenz;" statt "import kunde.Kunde;").
     *
     * Damit hängt bestellung nur noch von der stabilen Abstraktion in
     * gemeinsam ab — nicht mehr von der konkreten, volatilen Klasse Kunde
     * (vgl. Modul 01 — Dependency Inversion Principle — und Modul 04,
     * Kapitel 3 "Abhängigkeitsrichtung", jetzt auf Modulebene angewendet).
     */
    private final Kunde kunde;
    private final double betrag;

    public Bestellung(Kunde kunde, double betrag) {
        this.kunde = kunde;
        this.betrag = betrag;
    }

    public double getBetrag() {
        return betrag;
    }

    /*
     * Diese Methode braucht nach TODO 3 keine Änderung mehr — sie ruft schon
     * jetzt nur getName() auf, egal ob "kunde" vom Typ Kunde oder vom Typ
     * Kundenreferenz ist. Genau das ist der Punkt: Bestellung merkt nichts
     * von der Umstellung, weil sie immer schon nur diese eine Methode
     * gebraucht hat.
     */
    public String kundenname() {
        return kunde.getName();
    }
}
