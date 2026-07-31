package decorator;

/*
 * ÜBUNGSZIEL — die "Basiskomponente"
 * --------------------------------------
 * Der pure Kaffee ohne jede Hülle. Bereits fertig implementiert — die
 * eigentliche Übung liegt in MilchDecorator.java und ZuckerDecorator.java.
 */
public class Espresso implements Kaffee {

    @Override
    public String beschreibung() {
        return "Espresso";
    }

    @Override
    public double preis() {
        return 2.00;
    }
}
