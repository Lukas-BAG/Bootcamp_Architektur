package todoapp.data;

import todoapp.domain.Aufgabe;

import java.util.ArrayList;
import java.util.List;

/*
 * ÜBUNGSZIEL DIESER KLASSE
 * ------------------------
 * Das ist der "Adapter" aus Modul 03, Kapitel 3: die konkrete technische
 * Umsetzung des TodoRepository-Ports. Hier — und wirklich NUR hier — steht
 * Code, der weiß, wie Aufgaben tatsächlich gespeichert werden (in diesem Fall
 * ganz einfach in einer Liste im Arbeitsspeicher, statt in einer echten
 * Datenbank). Würde man das später gegen eine SQL- oder Datei-basierte
 * Implementierung austauschen, würde sich nur diese Klasse ändern — die
 * Domain-Schicht (TodoService) bekommt davon nichts mit, weil sie nur das
 * TodoRepository-Interface kennt.
 */
public class InMemoryTodoRepository implements TodoRepository {

    private final List<Aufgabe> aufgaben = new ArrayList<>();

    @Override
    public Aufgabe speichern(Aufgabe aufgabe) {
        aufgaben.add(aufgabe);
        return aufgabe;
    }

    @Override
    public Aufgabe findeNachId(int id) {
        for (Aufgabe a : aufgaben) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    @Override
    public List<Aufgabe> findeAlle() {
        return new ArrayList<>(aufgaben);
    }
}
