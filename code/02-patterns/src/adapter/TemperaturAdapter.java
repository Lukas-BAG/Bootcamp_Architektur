package adapter;

/*
 * ÜBUNGSZIEL — der Adapter selbst
 * -----------------------------------
 * Implementiert die vom neuen System erwartete Schnittstelle
 * (TemperaturSensor) und übersetzt die Anfrage intern in einen Aufruf an
 * die Alt-Bibliothek (AltesTemperaturSystem). Weder das neue System noch
 * die Alt-Bibliothek müssen dafür geändert werden — nur diese Klasse
 * dazwischen ist neu.
 */
public class TemperaturAdapter implements TemperaturSensor {

    private final AltesTemperaturSystem altesSystem;

    public TemperaturAdapter(AltesTemperaturSystem altesSystem) {
        this.altesSystem = altesSystem;
    }

    @Override
    public double getTemperaturCelsius() {
        // TODO: altesSystem.getTemperaturFahrenheit() holen und nach Celsius
        //       umrechnen: Celsius = (Fahrenheit - 32) * 5 / 9
        return 0.0; // Platzhalter, bis das TODO oben erledigt ist.
    }
}
