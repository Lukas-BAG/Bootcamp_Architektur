package adapter;

/*
 * ÜBUNGSZIEL — Adapter Pattern (strukturell)
 * -----------------------------------------------
 * Das ist die Schnittstelle, die unser (neues) System erwartet: Celsius.
 * Die Alt-Bibliothek (AltesTemperaturSystem) liefert aber Fahrenheit und
 * darf NICHT verändert werden (z. B. weil sie von einer anderen Abteilung
 * gepflegt wird oder als externe .jar vorliegt). Der Adapter überbrückt
 * diesen Unterschied, ohne dass eine der beiden Seiten geändert werden muss.
 */
public interface TemperaturSensor {

    double getTemperaturCelsius();
}
