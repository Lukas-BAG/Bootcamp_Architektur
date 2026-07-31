package strategy;

/*
 * ÜBUNGSZIEL — Referenzimplementierung
 * -------------------------------------
 * Diese Klasse ist bereits fertig und dient dir als Vorbild dafür, wie eine
 * konkrete Strategie aussieht: eine kleine Klasse, die RabattStrategy
 * implementiert und genau eine Regel kennt. Standardkunden bekommen keinen
 * Rabatt — orientiere dich hieran für StammkundenRabatt und PremiumRabatt.
 */
public class StandardRabatt implements RabattStrategy {

    @Override
    public double rabattBetrag(double bestellwert) {
        return 0.0; // Kein Rabatt für Standardkunden.
    }
}
