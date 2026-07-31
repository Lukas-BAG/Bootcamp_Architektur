package srp;

/**
 * Einfache Datenklasse fuer eine Rechnung.
 *
 * Bewusst OHNE jede Berechnungs-, Druck- oder Speicherlogik: SRP
 * verlangt, Daten (was eine Rechnung IST) von Verhalten (was man
 * DAMIT macht) zu trennen, sobald das Verhalten mehrere unabhaengige
 * Gruende hat, sich zu aendern. Diese Klasse hat genau einen Grund,
 * sich zu aendern: wenn sich aendert, WELCHE Daten eine Rechnung hat.
 */
public class Rechnung {

    private final String kunde;
    private final double[] positionen;

    public Rechnung(String kunde, double[] positionen) {
        this.kunde = kunde;
        this.positionen = positionen;
    }

    public String getKunde() {
        return kunde;
    }

    public double[] getPositionen() {
        return positionen;
    }
}
