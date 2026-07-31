package decorator;

/*
 * ÜBUNGSZIEL — die gemeinsame Basis aller Decorators
 * ---------------------------------------------------------
 * Jeder Decorator umhüllt ein anderes Kaffee-Objekt ("innererKaffee") —
 * das kann sowohl die Basiskomponente (Espresso) als auch ein bereits
 * umhüllter Kaffee sein (deshalb lassen sich Decorators stapeln!). Diese
 * Basisklasse reicht Aufrufe standardmäßig unverändert an den inneren
 * Kaffee weiter; die konkreten Decorators (MilchDecorator, ZuckerDecorator)
 * überschreiben das und ergänzen jeweils etwas. Hier ist nichts zu tun —
 * lies den Code und schau dir an, wie die konkreten Decorators unten
 * darauf aufbauen.
 */
public abstract class KaffeeDecorator implements Kaffee {

    protected final Kaffee innererKaffee;

    protected KaffeeDecorator(Kaffee innererKaffee) {
        this.innererKaffee = innererKaffee;
    }

    @Override
    public String beschreibung() {
        return innererKaffee.beschreibung();
    }

    @Override
    public double preis() {
        return innererKaffee.preis();
    }
}
