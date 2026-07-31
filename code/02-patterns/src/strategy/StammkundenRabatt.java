package strategy;

/*
 * ÜBUNGSZIEL — eigene Strategie implementieren
 * -----------------------------------------------
 * Stammkunden bekommen 5 % Rabatt auf den Bestellwert. Implementiere die
 * Berechnung unten. Orientiere dich an StandardRabatt.java.
 */
public class StammkundenRabatt implements RabattStrategy {

    @Override
    public double rabattBetrag(double bestellwert) {
        // TODO: 5 % von bestellwert zurückgeben (bestellwert * 0.05).
        return 0.0; // Platzhalter, bis das TODO oben erledigt ist.
    }
}
