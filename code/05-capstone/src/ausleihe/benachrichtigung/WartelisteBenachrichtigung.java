package ausleihe.benachrichtigung;

import ausleihe.Ausleihe;

/*
 * Übungsziel (Modul 05 · Fallstudie — Observer-Pattern, konkreter Beobachter):
 * Wenn eine Ausleihe storniert wird, soll intern vermerkt werden, dass das
 * Werkzeug wieder frei ist — z. B. um später eine Warteliste zu bedienen
 * (Erweiterung, die hier nur angedeutet wird).
 *
 * TODO (für dich):
 * Implementiere aktualisieren(...) so, dass NUR bei ereignis.equals("STORNIERT")
 * eine Zeile auf der Konsole ausgegeben wird, z. B.:
 *   "[Warteliste] \"3D-Drucker\" ist wieder frei — pruefe Warteliste fuer offene Anfragen."
 * Bei allen anderen Ereignissen soll die Methode nichts tun.
 *
 * Solange das TODO offen ist, bleibt diese Methode leer — Main.java läuft
 * durch, aber du siehst nach einer Stornierung KEINE Warteliste-Meldung.
 * Das ist der sichtbare Hinweis, dass hier noch etwas fehlt.
 */
public class WartelisteBenachrichtigung implements AusleiheBeobachter {

    @Override
    public void aktualisieren(Ausleihe ausleihe, String ereignis) {
        // TODO: Bedingung auf ereignis.equals("STORNIERT") prüfen und Meldung ausgeben.
    }
}
