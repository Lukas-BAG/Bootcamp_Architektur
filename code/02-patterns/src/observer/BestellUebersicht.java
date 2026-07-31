package observer;

/*
 * ÜBUNGSZIEL — konkreter Beobachter
 * -------------------------------------
 * Ein zweiter, unabhängiger UI-Teil, der auf dieselbe Warenkorb-Änderung
 * reagiert wie PreisAnzeige — ohne dass die beiden voneinander wissen.
 * Implementiere die Reaktion unten.
 */
public class BestellUebersicht implements Beobachter {

    @Override
    public void aktualisieren(String ereignis) {
        // TODO: eine Zeile ausgeben, die zeigt, dass die Bestellübersicht reagiert hat, z. B.:
        // System.out.println("  [Bestellübersicht] aktualisiert wegen: " + ereignis);
    }
}
