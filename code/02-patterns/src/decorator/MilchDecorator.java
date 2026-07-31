package decorator;

/*
 * ÜBUNGSZIEL — konkreter Decorator
 * -------------------------------------
 * Fügt Milch hinzu: ", Milch" an die Beschreibung, +0.50 € am Preis.
 * Implementiere beide Methoden unten (überschreibe das Standardverhalten
 * aus KaffeeDecorator).
 */
public class MilchDecorator extends KaffeeDecorator {

    public MilchDecorator(Kaffee innererKaffee) {
        super(innererKaffee);
    }

    @Override
    public String beschreibung() {
        // TODO: super.beschreibung() + ", Milch" zurückgeben.
        return super.beschreibung(); // Platzhalter: Milch fehlt noch in der Beschreibung.
    }

    @Override
    public double preis() {
        // TODO: super.preis() + 0.50 zurückgeben.
        return super.preis(); // Platzhalter: Milch-Aufpreis fehlt noch.
    }
}
