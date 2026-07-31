package strategy;

/*
 * ÜBUNGSZIEL — der "Kontext", der die Strategie benutzt
 * ---------------------------------------------------------
 * Der Warenkorb kennt nur die Schnittstelle RabattStrategy, nicht die
 * konkreten Rabattklassen. setStrategie() erlaubt, die Strategie zur
 * Laufzeit auszutauschen — genau das ist der Clou des Patterns: derselbe
 * Warenkorb, unterschiedliches Verhalten, ohne if/else und ohne
 * Codeänderung im Warenkorb selbst.
 */
public class Warenkorb {

    private RabattStrategy strategie;

    public void setStrategie(RabattStrategy strategie) {
        // TODO: das übergebene Strategie-Objekt im Feld "strategie" speichern.
    }

    public double berechneEndpreis(double bestellwert) {
        // TODO: bestellwert - strategie.rabattBetrag(bestellwert) zurückgeben,
        // sobald setStrategie() oben implementiert ist.
        return bestellwert; // Platzhalter: bislang wird kein Rabatt abgezogen.
    }
}
