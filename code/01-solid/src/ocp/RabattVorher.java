package ocp;

/**
 * AUFGABE OCP — "Vorher"-Zustand.
 * ---------------------------------------------------------------
 * WICHTIG: Diese Klasse ist bereits fertig und dient nur als
 * Referenz zum Vergleich. Du musst und sollst sie NICHT aendern.
 *
 * berechnePreis(...) unterscheidet per switch zwischen Rabattarten.
 * Das Problem: jede NEUE Rabattart (z.B. "NEUKUNDE") zwingt dich,
 * GENAU DIESE Methode zu aendern - obwohl sie fuer STANDARD, STUDENT
 * und VIP bereits fertig, getestet und in Produktion war. Jede
 * Aenderung an dieser Methode ist ein Risiko fuer bereits
 * funktionierende Faelle. Das verletzt OCP: der Code ist nicht
 * geschlossen fuer Aenderung, sobald eine neue Variante dazukommt.
 *
 * Deine Aufgabe liegt in StandardRabatt, StudentenRabatt und
 * VipRabatt (siehe die TODOs dort): baue dasselbe Verhalten nach,
 * aber je Rabattart in einer eigenen Klasse, die das Rabatt-Interface
 * implementiert. Modul 02 (Design Patterns) nennt dieses Vorgehen das
 * "Strategy-Pattern".
 */
public class RabattVorher {

    public double berechnePreis(String rabattTyp, double bruttoPreis) {
        switch (rabattTyp) {
            case "STANDARD":
                return bruttoPreis;
            case "STUDENT":
                return bruttoPreis * 0.90;
            case "VIP":
                return bruttoPreis * 0.80;
            default:
                throw new IllegalArgumentException("Unbekannter Rabatttyp: " + rabattTyp);
        }
    }
}
