package ocp;

/**
 * AUFGABE OCP (1/3) — Rabattart "Standard".
 * ---------------------------------------------------------------
 * TODO: Kein Rabatt (0%) - der Bruttopreis bleibt unveraendert.
 *       Vergleiche mit dem Fall "STANDARD" in RabattVorher.
 */
public class StandardRabatt implements Rabatt {

    @Override
    public double berechnePreis(double bruttoPreis) {
        // TODO: bruttoPreis unveraendert zurueckgeben.
        return 0.0; // Sicherer Platzhalter.
    }
}
