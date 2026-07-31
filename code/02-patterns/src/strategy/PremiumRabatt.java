package strategy;

/*
 * ÜBUNGSZIEL — eigene Strategie implementieren
 * -----------------------------------------------
 * Premium-Kunden bekommen 15 % Rabatt auf den Bestellwert. Implementiere
 * die Berechnung unten. Orientiere dich an StandardRabatt.java.
 */
public class PremiumRabatt implements RabattStrategy {

    @Override
    public double rabattBetrag(double bestellwert) {
        // TODO: 15 % von bestellwert zurückgeben (bestellwert * 0.15).
        return 0.0; // Platzhalter, bis das TODO oben erledigt ist.
    }
}
