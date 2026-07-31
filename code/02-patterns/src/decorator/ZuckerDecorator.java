package decorator;

/*
 * ÜBUNGSZIEL — konkreter Decorator
 * -------------------------------------
 * Fügt Zucker hinzu: ", Zucker" an die Beschreibung, +0.20 € am Preis.
 * Implementiere beide Methoden unten (überschreibe das Standardverhalten
 * aus KaffeeDecorator).
 */
public class ZuckerDecorator extends KaffeeDecorator {

    public ZuckerDecorator(Kaffee innererKaffee) {
        super(innererKaffee);
    }

    @Override
    public String beschreibung() {
        // TODO: super.beschreibung() + ", Zucker" zurückgeben.
        return super.beschreibung(); // Platzhalter: Zucker fehlt noch in der Beschreibung.
    }

    @Override
    public double preis() {
        // TODO: super.preis() + 0.20 zurückgeben.
        return super.preis(); // Platzhalter: Zucker-Aufpreis fehlt noch.
    }
}
