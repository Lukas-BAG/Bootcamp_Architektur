package nutzerverwaltung;

import java.util.HashMap;
import java.util.Map;

/*
 * Übungsziel (Modul 05 · Fallstudie):
 * Eine bewusst einfach gehaltene "Registry" für Mitglieder — im echten System wäre
 * das eine Datenbank-Anbindung (ein Adapter im Sinne der Hexagonal Architecture
 * aus Modul 03/ADR-005 im HTML-Kapitel). Für diese Übung reicht eine einfache
 * In-Memory-Map, damit du dich auf den Modul-Schnitt und die Patterns
 * konzentrieren kannst, nicht auf Datenbank-Boilerplate.
 *
 * Kein TODO in dieser Klasse.
 */
public class Nutzerverwaltung {

    private final Map<String, Mitglied> mitglieder = new HashMap<>();

    public void registriere(Mitglied mitglied) {
        mitglieder.put(mitglied.getId(), mitglied);
    }

    public Mitglied findeMitglied(String id) {
        Mitglied gefunden = mitglieder.get(id);
        if (gefunden == null) {
            throw new IllegalArgumentException("Kein Mitglied mit ID " + id + " registriert.");
        }
        return gefunden;
    }
}
