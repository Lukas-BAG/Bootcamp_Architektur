import ausleihe.Ausleihe;
import ausleihe.Ausleihenverwaltung;
import ausleihe.benachrichtigung.KonsolenBenachrichtigung;
import ausleihe.benachrichtigung.WartelisteBenachrichtigung;
import java.time.LocalDate;
import nutzerverwaltung.Mitglied;
import nutzerverwaltung.Nutzerverwaltung;
import werkzeugkatalog.Werkzeug;
import werkzeugkatalog.Werkzeugkategorie;

/*
 * ══════════════════════════════════════════════════════════════════════════
 * CAPSTONE-ÜBUNG · Modul 05 — Werkzeugausleihe eines Makerspace
 * ══════════════════════════════════════════════════════════════════════════
 * Dieses Programm ist die Code-Fallstudie zum HTML-Modul
 * 05_Fallstudie_Kleines_System.html. Es setzt den dort erarbeiteten
 * Modul-Schnitt (werkzeugkatalog / nutzerverwaltung / ausleihe) und die
 * beiden Patterns (Strategy für Gebühren, Observer für Benachrichtigungen)
 * um.
 *
 * Öffne einfach den Ordner "05-capstone" als Projekt in IntelliJ (den Ordner
 * "src" als Sources Root markieren, falls IntelliJ das nicht automatisch
 * erkennt) und führe diese Klasse aus — kein Maven/Gradle nötig.
 *
 * WICHTIG: Dieses Programm compiliert und läuft bereits jetzt durch, OHNE
 * dass du etwas ändern musst — aber drei Stellen sind nur als Platzhalter
 * (TODO) implementiert:
 *   1) ausleihe.Ausleihenverwaltung.istVerfuegbar(...)   — meldet fälschlich
 *      IMMER "verfügbar", auch bei Terminüberschneidung.
 *   2) ausleihe.gebuehr.PremiumGebuehrStrategie           — berechnet aktuell
 *      immer 0,00 € statt des Tagessatzes.
 *   3) ausleihe.benachrichtigung.WartelisteBenachrichtigung — gibt aktuell
 *      NICHTS aus, wenn eine Ausleihe storniert wird.
 *
 * ERWARTETE AUSGABE, NACHDEM DU ALLE DREI TODOs GELÖST HAST (sinngemäß,
 * exakte Formatierung kann leicht abweichen):
 *
 *   [Reserviert] Anna -> Akkuschrauber (3 Tag(e), Gebühr: 0,00 €)
 *   [E-Mail an Anna] Deine Ausleihe von "Akkuschrauber" hat den Status: RESERVIERT
 *   [Reserviert] Anna -> 3D-Drucker (2 Tag(e), Gebühr: 5,00 €)
 *   [E-Mail an Anna] Deine Ausleihe von "3D-Drucker" hat den Status: RESERVIERT
 *   [Abgelehnt] 3D-Drucker ist im Zeitraum 2026-08-05 bis 2026-08-06 NICHT verfügbar.
 *   [Storniert] 3D-Drucker für Anna
 *   [E-Mail an Anna] Deine Ausleihe von "3D-Drucker" hat den Status: STORNIERT
 *   [Warteliste] "3D-Drucker" ist wieder frei — pruefe Warteliste fuer offene Anfragen.
 *   [Reserviert] Bruno -> 3D-Drucker (2 Tag(e), Gebühr: 5,00 €)
 *   [E-Mail an Bruno] Deine Ausleihe von "3D-Drucker" hat den Status: RESERVIERT
 *
 * Solange die TODOs offen sind, wirst du u. a. sehen: eine Gebühr von 0,00 €
 * für den 3D-Drucker, eine fälschlich angenommene Reservierung trotz
 * Überschneidung, und KEINE Warteliste-Meldung nach der Stornierung. Das ist
 * gewollt — so siehst du direkt, ob dein Fix wirkt.
 */
public class Main {

    public static void main(String[] args) {

        // ── 1) Werkzeugkatalog befüllen ──────────────────────────────────
        Werkzeug akkuschrauber = new Werkzeug("W1", "Akkuschrauber", Werkzeugkategorie.STANDARD);
        Werkzeug drucker3d = new Werkzeug("W2", "3D-Drucker", Werkzeugkategorie.PREMIUM);

        // ── 2) Mitglieder registrieren ───────────────────────────────────
        Nutzerverwaltung nutzerverwaltung = new Nutzerverwaltung();
        Mitglied anna = new Mitglied("M1", "Anna");
        Mitglied bruno = new Mitglied("M2", "Bruno");
        nutzerverwaltung.registriere(anna);
        nutzerverwaltung.registriere(bruno);

        // ── 3) Ausleihenverwaltung aufsetzen und Beobachter registrieren ─
        // (Observer-Pattern: Ausleihenverwaltung kennt nur die Schnittstelle
        // AusleiheBeobachter, nicht diese konkreten Klassen.)
        Ausleihenverwaltung verwaltung = new Ausleihenverwaltung();
        verwaltung.registriereBeobachter(new KonsolenBenachrichtigung());
        verwaltung.registriereBeobachter(new WartelisteBenachrichtigung());

        // ── 4) Szenario: Anna leiht den Akkuschrauber (kostenlos, STANDARD) ─
        Ausleihe annaSchrauber = verwaltung.reserviere(
                akkuschrauber, anna, LocalDate.of(2026, 8, 3), LocalDate.of(2026, 8, 5));

        // ── 5) Anna leiht zusätzlich den 3D-Drucker (kostenpflichtig, PREMIUM) ─
        Ausleihe annaDrucker = verwaltung.reserviere(
                drucker3d, anna, LocalDate.of(2026, 8, 5), LocalDate.of(2026, 8, 6));

        // ── 6) Bruno versucht, den 3D-Drucker im selben Zeitraum zu leihen ─
        // Das MUSS abgelehnt werden, sobald istVerfuegbar(...) korrekt
        // implementiert ist (Überschneidung mit Annas Buchung).
        Ausleihe brunoDruckerVersuch = verwaltung.reserviere(
                drucker3d, bruno, LocalDate.of(2026, 8, 5), LocalDate.of(2026, 8, 6));

        // ── 7) Anna storniert ihre Drucker-Ausleihe ──────────────────────
        // Löst Observer-Benachrichtigungen aus, u. a. die Warteliste-Meldung.
        if (annaDrucker != null) {
            verwaltung.storniere(annaDrucker);
        }

        // ── 8) Jetzt sollte Bruno den 3D-Drucker im selben Zeitraum bekommen ─
        Ausleihe brunoDrucker = verwaltung.reserviere(
                drucker3d, bruno, LocalDate.of(2026, 8, 5), LocalDate.of(2026, 8, 6));
    }
}
