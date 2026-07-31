package strategy;

/*
 * ÜBUNGSZIEL — Strategy Pattern (verhaltensbezogen)
 * --------------------------------------------------
 * In Modul 01 (SOLID, Kapitel "Open/Closed") gab es eine Rabattberechnung,
 * die per if/else-Kaskade über den Kundentyp entschied. Jeder neue
 * Kundentyp bedeutete: die bestehende Methode anfassen und riskieren, dass
 * bereits funktionierender Code kaputtgeht — ein klarer OCP-Verstoß.
 *
 * Diese Schnittstelle ist der gemeinsame Vertrag aller Rabatt-"Strategien".
 * Der Warenkorb (siehe Warenkorb.java) kennt nur diese Schnittstelle, nicht
 * die konkreten Klassen dahinter. Neue Rabattarten kommen als NEUE Klasse
 * hinzu (siehe StammkundenRabatt, PremiumRabatt) — ohne bestehenden Code zu
 * verändern. Das ist der Kern von Strategy: austauschbares Verhalten zur
 * Laufzeit statt einer fest verdrahteten Fallunterscheidung.
 */
public interface RabattStrategy {

    /**
     * Berechnet, wie viel Euro Rabatt bei gegebenem Bestellwert abgezogen
     * werden. Der Rückgabewert ist der ABZUZIEHENDE Betrag, nicht der
     * Endpreis.
     */
    double rabattBetrag(double bestellwert);
}
