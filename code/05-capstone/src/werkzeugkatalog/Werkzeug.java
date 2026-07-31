package werkzeugkatalog;

/*
 * Übungsziel (Modul 05 · Fallstudie):
 * Dieses Paket "werkzeugkatalog" bildet den fachlichen Schnitt "Werkzeugkatalog"
 * aus Kapitel 5 des Moduls ab (siehe HTML-Kapitel "Module schneiden"). Es weiß
 * NICHTS über Ausleihen oder Mitglieder — das wäre eine unnötige Kopplung
 * zwischen fachlich getrennten Zuständigkeiten (siehe Modul 04, hohe Kohäsion /
 * lose Kopplung).
 *
 * Werkzeug ist ein einfaches, unveränderliches Datenobjekt (keine TODOs hier —
 * das ist bewusst der "langweilige" Teil des Systems).
 */
public class Werkzeug {

    private final String id;
    private final String name;
    private final Werkzeugkategorie kategorie;

    public Werkzeug(String id, String name, Werkzeugkategorie kategorie) {
        this.id = id;
        this.name = name;
        this.kategorie = kategorie;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Werkzeugkategorie getKategorie() {
        return kategorie;
    }

    @Override
    public String toString() {
        return name + " (" + kategorie + ")";
    }
}
