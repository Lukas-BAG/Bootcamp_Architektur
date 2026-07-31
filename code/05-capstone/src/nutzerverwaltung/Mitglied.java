package nutzerverwaltung;

/*
 * Übungsziel (Modul 05 · Fallstudie):
 * Das Paket "nutzerverwaltung" bildet den fachlichen Schnitt "Nutzerverwaltung"
 * ab. Auch hier gilt: keine Abhängigkeit zu "ausleihe" oder "werkzeugkatalog" —
 * ein Mitglied weiß nichts davon, was oder wie es ausleiht. Die Verknüpfung
 * passiert ausschließlich im Paket "ausleihe", das beide Seiten kennen darf.
 */
public class Mitglied {

    private final String id;
    private final String name;

    public Mitglied(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
