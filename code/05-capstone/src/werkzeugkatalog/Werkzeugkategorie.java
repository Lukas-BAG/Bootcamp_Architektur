package werkzeugkatalog;

/*
 * Übungsziel (Modul 05 · Fallstudie):
 * Die Kategorie eines Werkzeugs entscheidet später, welche Gebühr-Strategie
 * (Strategy-Pattern, siehe Paket ausleihe.gebuehr) zur Anwendung kommt.
 * STANDARD-Werkzeuge (z. B. Akkuschrauber) sind für Vereinsmitglieder kostenlos,
 * PREMIUM-Werkzeuge (z. B. der 3D-Drucker) kosten einen Tagessatz, weil ihr
 * Verschleiß/Materialkosten höher sind.
 *
 * Das ist bewusst ein einfaches Enum und kein eigenes Modul — die Kategorie
 * ist ein Attribut des Werkzeugkatalogs, keine eigenständige Fachlichkeit.
 */
public enum Werkzeugkategorie {
    STANDARD,
    PREMIUM
}
