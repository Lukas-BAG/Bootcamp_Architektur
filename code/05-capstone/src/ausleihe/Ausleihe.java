package ausleihe;

import java.time.LocalDate;
import nutzerverwaltung.Mitglied;
import werkzeugkatalog.Werkzeug;

/*
 * Übungsziel (Modul 05 · Fallstudie):
 * Ausleihe ist das zentrale Datenobjekt des Moduls "ausleihe" — es verknüpft
 * bewusst als einziges Paket "werkzeugkatalog" und "nutzerverwaltung"
 * miteinander (siehe Kapitel "Module schneiden" im HTML-Modul: die anderen
 * beiden Pakete kennen sich NICHT gegenseitig).
 *
 * Kein TODO in dieser Datei.
 */
public class Ausleihe {

    private final Werkzeug werkzeug;
    private final Mitglied mitglied;
    private final LocalDate start;
    private final LocalDate ende;
    private boolean storniert = false;

    public Ausleihe(Werkzeug werkzeug, Mitglied mitglied, LocalDate start, LocalDate ende) {
        this.werkzeug = werkzeug;
        this.mitglied = mitglied;
        this.start = start;
        this.ende = ende;
    }

    public Werkzeug getWerkzeug() {
        return werkzeug;
    }

    public Mitglied getMitglied() {
        return mitglied;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnde() {
        return ende;
    }

    public boolean istStorniert() {
        return storniert;
    }

    public void storniere() {
        this.storniert = true;
    }

    /** Anzahl der Ausleihtage, inklusive Start- und Endtag. */
    public long getTage() {
        return java.time.temporal.ChronoUnit.DAYS.between(start, ende) + 1;
    }

    /**
     * Prüft, ob sich dieser Zeitraum mit einem anderen [andererStart, anderesEnde]
     * überschneidet. Zwei Zeiträume überschneiden sich, wenn keiner der beiden
     * komplett vor dem anderen liegt.
     */
    public boolean ueberschneidetSichMit(LocalDate andererStart, LocalDate anderesEnde) {
        return !this.ende.isBefore(andererStart) && !anderesEnde.isBefore(this.start);
    }

    @Override
    public String toString() {
        return werkzeug.getName() + " an " + mitglied.getName()
                + " (" + start + " bis " + ende + ")" + (storniert ? " [storniert]" : "");
    }
}
