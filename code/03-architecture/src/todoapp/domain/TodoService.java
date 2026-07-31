package todoapp.domain;

import todoapp.data.InMemoryTodoRepository;
import todoapp.data.TodoRepository;

import java.util.List;

/*
 * ÜBUNGSZIEL DIESER KLASSE
 * ------------------------
 * TodoService ist die Domain-Schicht: Hier lebt die Geschäftslogik (Aufgaben
 * anlegen, validieren, als erledigt markieren) — unabhängig davon, ob die
 * Aufgabe später über Konsole, Web-Oberfläche oder REST-API angestoßen wird,
 * und unabhängig davon, WO die Daten am Ende landen.
 *
 * ACHTUNG — das ist die eigentliche Übung:
 * Aktuell erzeugt sich TodoService sein TodoRepository selbst (siehe Zeile
 * mit "new InMemoryTodoRepository()" unten). Das funktioniert, verstößt aber
 * gegen das Dependency Inversion Principle aus Modul 01: Die Domain-Schicht
 * kennt damit eine KONKRETE Data-Klasse, statt nur die Abstraktion (das
 * TodoRepository-Interface) zu kennen. Außerdem lässt sich TodoService so
 * nicht mit einem anderen Repository (z. B. einem Test-Repository) verwenden,
 * ohne den Quellcode zu ändern.
 *
 * TODO: Ergänze einen Konstruktor "TodoService(TodoRepository repository)",
 *       der die Abhängigkeit von außen entgegennimmt (Konstruktor-Injection),
 *       und entferne die direkte Instanziierung "new InMemoryTodoRepository()"
 *       unten. Wer TodoService erzeugt (das wird am Ende Main.java sein),
 *       entscheidet dann, welche konkrete Repository-Implementierung verwendet
 *       wird — TodoService selbst muss das nicht mehr wissen.
 */
public class TodoService {

    // Platzhalter, bis die Konstruktor-Injection eingebaut ist (siehe TODO oben).
    private TodoRepository repository = new InMemoryTodoRepository();
    private int naechsteId = 1;

    public Aufgabe aufgabeAnlegen(String titel) {
        if (titel == null || titel.isBlank()) {
            throw new IllegalArgumentException("Der Titel einer Aufgabe darf nicht leer sein.");
        }
        Aufgabe aufgabe = new Aufgabe(naechsteId++, titel.trim());
        return repository.speichern(aufgabe);
    }

    public void aufgabeAlsErledigtMarkieren(int id) {
        Aufgabe aufgabe = repository.findeNachId(id);
        if (aufgabe == null) {
            throw new IllegalArgumentException("Keine Aufgabe mit ID " + id + " gefunden.");
        }
        aufgabe.alsErledigtMarkieren(); // fachliche Regel steckt in Aufgabe selbst
    }

    public List<Aufgabe> alleAufgaben() {
        return repository.findeAlle();
    }
}
