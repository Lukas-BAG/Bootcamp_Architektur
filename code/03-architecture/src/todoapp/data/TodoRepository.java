package todoapp.data;

import todoapp.domain.Aufgabe;

import java.util.List;

/*
 * ÜBUNGSZIEL DIESER SCHNITTSTELLE
 * --------------------------------
 * Dieses Interface ist der "Port" aus Modul 03, Kapitel 3 (Clean/Hexagonal
 * Architecture): Es beschreibt, WAS die Domain-Schicht braucht (Aufgaben
 * speichern und wiederfinden), aber nicht WIE das technisch passiert.
 *
 * Die Domain-Schicht (TodoService) hängt nur von diesem Interface ab, nie von
 * einer konkreten Implementierung wie InMemoryTodoRepository. Das ist das
 * Dependency Inversion Principle (Modul 01) angewendet auf Architekturebene:
 * Ein Wechsel der Speichertechnologie (z. B. später eine echte Datenbank statt
 * In-Memory) betrifft NUR eine neue Implementierung dieses Interfaces —
 * TodoService muss dafür keine einzige Zeile ändern.
 */
public interface TodoRepository {

    Aufgabe speichern(Aufgabe aufgabe);

    Aufgabe findeNachId(int id);

    List<Aufgabe> findeAlle();
}
