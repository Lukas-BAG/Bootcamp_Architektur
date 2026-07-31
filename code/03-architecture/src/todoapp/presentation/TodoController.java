package todoapp.presentation;

import todoapp.domain.Aufgabe;
import todoapp.domain.TodoService;

import java.util.List;

/*
 * ÜBUNGSZIEL DIESER KLASSE
 * ------------------------
 * TodoController ist die Presentation-Schicht — hier allerdings ganz bewusst
 * als simpler Konsolen-"Controller" statt einer grafischen Oberfläche: Er
 * nimmt "Eingaben" entgegen (hier: einfache Methodenaufrufe, die einen
 * Nutzer-Befehl simulieren) und formatiert die Ausgabe für die Konsole. Die
 * eigentliche Entscheidung, OB eine Aufgabe gültig ist oder als erledigt
 * markiert werden darf, trifft NICHT diese Klasse, sondern TodoService
 * (Domain-Schicht) — der Controller fängt nur die Fehler ab und formatiert
 * eine verständliche Meldung. Genau diese Aufteilung (Presentation validiert
 * nur die Form/fängt Fehler ab, Domain entscheidet fachlich) ist Thema der
 * Drag & Drop-Übung im Lehrkurs zu diesem Modul.
 *
 * ACHTUNG — das ist die eigentliche Übung:
 * Aktuell erzeugt sich TodoController seinen TodoService selbst (siehe Zeile
 * mit "new TodoService()" unten) — derselbe Verstoß gegen Dependency
 * Inversion wie bei TodoService/TodoRepository.
 *
 * TODO: Ergänze einen Konstruktor "TodoController(TodoService service)",
 *       der die Abhängigkeit von außen entgegennimmt, und entferne die
 *       direkte Instanziierung "new TodoService()" unten.
 */
public class TodoController {

    // Platzhalter, bis die Konstruktor-Injection eingebaut ist (siehe TODO oben).
    private TodoService service = new TodoService();

    public void befehlAufgabeAnlegen(String titel) {
        try {
            Aufgabe aufgabe = service.aufgabeAnlegen(titel);
            System.out.println("Angelegt: " + aufgabe);
        } catch (IllegalArgumentException e) {
            System.out.println("Fehler beim Anlegen: " + e.getMessage());
        }
    }

    public void befehlAufgabeErledigen(int id) {
        try {
            service.aufgabeAlsErledigtMarkieren(id);
            System.out.println("Aufgabe #" + id + " als erledigt markiert.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Fehler beim Erledigen: " + e.getMessage());
        }
    }

    public void befehlAufgabenAuflisten() {
        List<Aufgabe> aufgaben = service.alleAufgaben();
        System.out.println("--- Aufgabenliste (" + aufgaben.size() + ") ---");
        for (Aufgabe aufgabe : aufgaben) {
            System.out.println(aufgabe);
        }
    }

    /**
     * Spielt ein kleines, festes Szenario durch. Die Konsolenausgabe davon
     * lässt sich 1:1 mit einer erwarteten Ausgabe vergleichen (siehe README-
     * Kommentar in Main.java).
     */
    public void szenarioDurchspielen() {
        befehlAufgabeAnlegen("Bootcamp-Modul 03 durcharbeiten");
        befehlAufgabeAnlegen("Java-Übung 03-architecture lösen");
        befehlAufgabeAnlegen("");                 // absichtlich ungültig (leerer Titel)
        befehlAufgabeErledigen(1);
        befehlAufgabeErledigen(1);                // absichtlich ungültig (schon erledigt)
        befehlAufgabeErledigen(99);                // absichtlich ungültig (existiert nicht)
        befehlAufgabenAuflisten();
    }
}
