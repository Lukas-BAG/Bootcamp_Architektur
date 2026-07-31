package decorator;

/*
 * ÜBUNGSZIEL — Decorator Pattern (strukturell)
 * -------------------------------------------------
 * Ohne Decorator müsste man für jede Kombination eine eigene Unterklasse
 * bauen: KaffeeMitMilch, KaffeeMitZucker, KaffeeMitMilchUndZucker, ... —
 * eine Klassenexplosion, die mit jeder neuen Zutat schlimmer wird.
 * Mit Decorator umhüllt man ein Kaffee-Objekt mit beliebig vielen kleinen
 * "Hüllen", die je eine Zutat hinzufügen und dieselbe Schnittstelle
 * behalten. Das ist die gemeinsame Schnittstelle für "irgendetwas, das man
 * trinken/bestellen kann" — egal ob purer Kaffee oder mehrfach umhüllt.
 */
public interface Kaffee {

    String beschreibung();

    double preis();
}
