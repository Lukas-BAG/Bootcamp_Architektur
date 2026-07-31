package observer;

/*
 * ÜBUNGSZIEL — konkreter Beobachter
 * -------------------------------------
 * Ein UI-Teil, der auf Warenkorb-Änderungen reagiert. Implementiere die
 * Reaktion unten.
 */
public class PreisAnzeige implements Beobachter {

    @Override
    public void aktualisieren(String ereignis) {
        // TODO: eine Zeile ausgeben, die zeigt, dass die Preisanzeige reagiert hat, z. B.:
        // System.out.println("  [Preisanzeige] aktualisiert wegen: " + ereignis);
    }
}
