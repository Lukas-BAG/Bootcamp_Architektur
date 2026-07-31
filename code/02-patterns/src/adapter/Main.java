package adapter;

/*
 * ÜBUNGSZIEL — Selbstgrade dich!
 * --------------------------------
 * Läuft von Anfang an ohne Absturz (mit 0.0 als Platzhalterwert). Erledige
 * das TODO in TemperaturAdapter.java, dann sollte die Zeile "OK" zeigen.
 */
public class Main {

    public static void main(String[] args) {
        AltesTemperaturSystem legacy = new AltesTemperaturSystem();
        TemperaturSensor sensor = new TemperaturAdapter(legacy);

        double erwartet = (legacy.getTemperaturFahrenheit() - 32) * 5 / 9;
        double tatsaechlich = sensor.getTemperaturCelsius();
        boolean ok = Math.abs(erwartet - tatsaechlich) < 0.01;

        System.out.println("=== Adapter Pattern: Temperatursensor ===");
        System.out.printf("erwartet: %.2f °C   tatsächlich: %.2f °C   %s%n",
                erwartet, tatsaechlich, ok ? "OK" : "-- noch nicht fertig --");
    }
}
