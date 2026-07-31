package ocp;

/**
 * AUFGABE OCP (3/3) — Rabattart "VIP".
 * ---------------------------------------------------------------
 * TODO: 20% Rabatt - der Bruttopreis wird mit 0.80 multipliziert.
 *       Vergleiche mit dem Fall "VIP" in RabattVorher.
 */
public class VipRabatt implements Rabatt {

    @Override
    public double berechnePreis(double bruttoPreis) {
        // TODO: bruttoPreis * 0.80 zurueckgeben.
        return 0.0; // Sicherer Platzhalter.
    }
}
