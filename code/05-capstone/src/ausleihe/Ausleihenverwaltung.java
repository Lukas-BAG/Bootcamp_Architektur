package ausleihe;

import ausleihe.benachrichtigung.AusleiheBeobachter;
import ausleihe.gebuehr.GebuehrStrategie;
import ausleihe.gebuehr.PremiumGebuehrStrategie;
import ausleihe.gebuehr.StandardGebuehrStrategie;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import nutzerverwaltung.Mitglied;
import werkzeugkatalog.Werkzeug;
import werkzeugkatalog.Werkzeugkategorie;

/*
 * Übungsziel (Modul 05 · Fallstudie):
 * Ausleihenverwaltung ist der fachliche Kern des Moduls "ausleihe". Sie ist
 * gleichzeitig:
 *   - das "Subject" im Observer-Pattern (verwaltet die Liste der Beobachter
 *     und benachrichtigt sie bei Ereignissen),
 *   - der "Context" im Strategy-Pattern (wählt die passende GebuehrStrategie
 *     je nach Werkzeugkategorie aus, statt die Berechnung selbst zu kennen).
 *
 * In einer echten Hexagonal-Architecture (siehe ADR im HTML-Kapitel 3) wäre
 * diese Klasse der Domänen-Kern, der über Ports mit Adaptern (Datenbank,
 * E-Mail-Server, REST-API) verbunden wird — hier reicht In-Memory, damit du
 * dich auf Modul-Schnitt + Patterns konzentrieren kannst.
 *
 * TODO (für dich):
 * Die Methode istVerfuegbar(...) ist absichtlich als Platzhalter implementiert
 * und meldet IMMER "verfügbar", auch wenn sich Zeiträume überschneiden. Nutze
 * Ausleihe.ueberschneidetSichMit(...), um für jede bereits bestehende, NICHT
 * stornierte Ausleihe DESSELBEN Werkzeugs zu prüfen, ob sich der neue Zeitraum
 * überschneidet. Sobald eine Überschneidung gefunden wird, ist das Werkzeug
 * NICHT verfügbar.
 */
public class Ausleihenverwaltung {

    private final List<Ausleihe> ausleihen = new ArrayList<>();
    private final List<AusleiheBeobachter> beobachter = new ArrayList<>();

    public void registriereBeobachter(AusleiheBeobachter b) {
        beobachter.add(b);
    }

    /**
     * Versucht, eine neue Ausleihe anzulegen.
     *
     * @return die angelegte Ausleihe, oder null, wenn das Werkzeug im
     *         gewünschten Zeitraum nicht verfügbar ist.
     */
    public Ausleihe reserviere(Werkzeug werkzeug, Mitglied mitglied, LocalDate start, LocalDate ende) {
        if (!istVerfuegbar(werkzeug, start, ende)) {
            System.out.println("[Abgelehnt] " + werkzeug.getName() + " ist im Zeitraum " + start + " bis " + ende + " NICHT verfügbar.");
            return null;
        }

        Ausleihe ausleihe = new Ausleihe(werkzeug, mitglied, start, ende);
        ausleihen.add(ausleihe);

        GebuehrStrategie strategie = waehleStrategie(werkzeug);
        double gebuehr = strategie.berechneGebuehr(werkzeug, ausleihe.getTage());

        // Locale.GERMANY erzwingen: sonst hängt "," vs. "." bei der Gebühr
        // vom System des Studenten ab (Locale-Falle — ein guter Nebenlerneffekt).
        System.out.printf(Locale.GERMANY, "[Reserviert] %s -> %s (%d Tag(e), Gebühr: %.2f €)%n",
                mitglied.getName(), werkzeug.getName(), ausleihe.getTage(), gebuehr);

        benachrichtigeAlle(ausleihe, "RESERVIERT");
        return ausleihe;
    }

    public void storniere(Ausleihe ausleihe) {
        ausleihe.storniere();
        System.out.println("[Storniert] " + ausleihe.getWerkzeug().getName() + " für " + ausleihe.getMitglied().getName());
        benachrichtigeAlle(ausleihe, "STORNIERT");
    }

    private void benachrichtigeAlle(Ausleihe ausleihe, String ereignis) {
        for (AusleiheBeobachter b : beobachter) {
            b.aktualisieren(ausleihe, ereignis);
        }
    }

    /** Strategy-Auswahl: welche Gebühr-Strategie passt zur Werkzeugkategorie? */
    private GebuehrStrategie waehleStrategie(Werkzeug werkzeug) {
        if (werkzeug.getKategorie() == Werkzeugkategorie.PREMIUM) {
            return new PremiumGebuehrStrategie();
        }
        return new StandardGebuehrStrategie();
    }

    private boolean istVerfuegbar(Werkzeug werkzeug, LocalDate start, LocalDate ende) {
        // TODO: Platzhalter ersetzen. Aktuell wird jeder Zeitraum als frei gemeldet,
        // auch wenn er sich mit einer bestehenden, nicht stornierten Ausleihe
        // desselben Werkzeugs überschneidet. Das ist fachlich falsch — behebe es,
        // indem du "ausleihen" nach genau so einer Überschneidung durchsuchst.
        return true;
    }
}
