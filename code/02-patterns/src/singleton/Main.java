package singleton;

/*
 * ÜBUNGSZIEL — Selbstgrade dich!
 * --------------------------------
 * Teil 1 läuft bereits vollständig (nichts zu tun) und zeigt dir das
 * Problem: testB() will eigentlich unabhängig von testA() sein, sieht aber
 * wegen des globalen Singleton-Zustands den Wert, den testA() gesetzt hat.
 * Genau das macht Singletons in Unit-Tests unangenehm — Tests, die in
 * Isolation laufen sollen, beeinflussen sich gegenseitig, nur weil sie in
 * einer bestimmten Reihenfolge ausgeführt wurden.
 *
 * Teil 2 läuft von Anfang an ohne Absturz (mit null als Platzhalterwert).
 * Erledige die TODOs in KonfigurationDI.java — dann sind konfigA und
 * konfigB unabhängig voneinander, und beide Zeilen zeigen "OK".
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Teil 1: Das Singleton-Problem (bereits fertig, nur beobachten) ===");
        testA();
        testB();

        System.out.println();
        System.out.println("=== Teil 2: Alternative mit KonfigurationDI (TODOs in KonfigurationDI.java) ===");
        KonfigurationDI konfigA = new KonfigurationDI("test-a");
        KonfigurationDI konfigB = new KonfigurationDI("test-b");
        konfigA.setzeWert("umgebung", "test-a");
        konfigB.setzeWert("umgebung", "test-b");

        pruefe("konfigA", "test-a", konfigA.getWert("umgebung"));
        pruefe("konfigB", "test-b", konfigB.getWert("umgebung"));
    }

    private static void testA() {
        Konfiguration.getInstance().setzeWert("umgebung", "test-a");
        System.out.println("testA() setzt 'umgebung' auf 'test-a' -> liest zurück: "
                + Konfiguration.getInstance().getWert("umgebung"));
    }

    private static void testB() {
        // testB() erwartet eigentlich seine eigene, unabhängige Konfiguration,
        // bekommt aber wegen des globalen Singleton-Zustands den Wert von testA()!
        System.out.println("testB() will unabhängig sein, sieht aber den globalen Zustand von testA(): "
                + Konfiguration.getInstance().getWert("umgebung"));
    }

    private static void pruefe(String name, String erwartet, String tatsaechlich) {
        boolean ok = erwartet.equals(tatsaechlich);
        System.out.printf("%-8s 'umgebung' erwartet: %-8s tatsächlich: %-8s %s%n",
                name, erwartet, tatsaechlich, ok ? "OK" : "-- noch nicht fertig --");
    }
}
