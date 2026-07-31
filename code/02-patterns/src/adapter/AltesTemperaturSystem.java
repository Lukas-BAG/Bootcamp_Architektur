package adapter;

/*
 * ÜBUNGSZIEL — die "Alt-Bibliothek" (Adaptee)
 * --------------------------------------------------
 * Stell dir vor, diese Klasse kommt aus einer alten, extern gepflegten
 * Bibliothek — du darfst sie nicht anfassen. Sie liefert Fahrenheit statt
 * des von uns benötigten Celsius. Bereits fertig implementiert (fest
 * verdrahteter Beispielwert, damit die Übung reproduzierbar bleibt).
 */
public class AltesTemperaturSystem {

    public double getTemperaturFahrenheit() {
        return 98.6; // Beispielwert der Alt-Bibliothek.
    }
}
