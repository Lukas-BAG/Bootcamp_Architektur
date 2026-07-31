package ocp;

/**
 * Abstraktion fuer eine Rabattart.
 *
 * Der ganze Witz von OCP steckt in diesem winzigen Interface: jede
 * neue Rabattart wird eine neue Klasse, die Rabatt implementiert -
 * OHNE dass bestehender Code (wie eine zentrale berechnePreis-Methode
 * mit switch-Anweisung, siehe RabattVorher) angefasst werden muss.
 */
public interface Rabatt {
    double berechnePreis(double bruttoPreis);
}
