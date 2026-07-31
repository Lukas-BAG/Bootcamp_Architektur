package todoapp;

import todoapp.presentation.TodoController;

/*
 * ÜBUNGSZIEL DIESES PROJEKTS ("03-architecture" — Aufgabenverwaltung)
 * =====================================================================
 * Dieses Mini-Projekt zeigt eine simple Schichtenarchitektur (Modul 03,
 * Kapitel 1) mit drei Schichten in drei Paketen:
 *
 *   todoapp.presentation  — TodoController: nimmt Befehle entgegen, formatiert Ausgabe
 *   todoapp.domain        — TodoService, Aufgabe: Geschäftslogik & fachliche Regeln
 *   todoapp.data           — TodoRepository (Port) + InMemoryTodoRepository (Adapter)
 *
 * Diese Datei kompiliert und läuft von Anfang an — auch bevor du die TODOs
 * in TodoService und TodoController gelöst hast. Sie tut das aber gerade
 * NICHT so, wie es eine saubere Architektur verlangt: Aktuell erzeugen sich
 * TodoService und TodoController ihre Abhängigkeiten (Repository bzw.
 * Service) intern selbst per "new" (siehe TODOs in den jeweiligen Dateien).
 *
 * DEINE AUFGABE
 * -------------
 * 1) Öffne TodoService.java und TodoController.java, lies die TODO-Kommentare
 *    und ergänze dort jeweils einen Konstruktor, der die Abhängigkeit
 *    entgegennimmt (Konstruktor-Injection), statt sie selbst zu erzeugen.
 * 2) Entferne in beiden Klassen die interne "new ...()"-Instanziierung.
 * 3) Verdrahte die drei Schichten stattdessen HIER in main() — Main ist der
 *    einzige Ort im ganzen Projekt, an dem "new" auf konkrete Klassen
 *    (InMemoryTodoRepository, TodoService, TodoController) verwendet wird.
 *    Das nennt man den "Composition Root": die eine Stelle, die entscheidet,
 *    welche konkreten Implementierungen zusammengesteckt werden. Ersetze dazu
 *    die Zeile "TodoController controller = new TodoController();" unten
 *    durch die drei auskommentierten Zeilen darüber (und entferne die
 *    Kommentarzeichen).
 *
 * ERWARTETE AUSGABE
 * ------------------
 * Sobald die TODOs gelöst sind, ändert sich die Konsolenausgabe NICHT — das
 * Verhalten des Programms bleibt exakt gleich. Das ist Absicht: Guter
 * Architektur-Umbau (Refactoring der Verdrahtung) verändert nicht, WAS ein
 * Programm tut, nur WIE die Teile zusammenhängen. Erwartete Ausgabe (Auszug):
 *
 *   Angelegt: [ ] #1 Bootcamp-Modul 03 durcharbeiten
 *   Angelegt: [ ] #2 Java-Übung 03-architecture lösen
 *   Fehler beim Anlegen: Der Titel einer Aufgabe darf nicht leer sein.
 *   Aufgabe #1 als erledigt markiert.
 *   Fehler beim Erledigen: Aufgabe 'Bootcamp-Modul 03 durcharbeiten' ist bereits erledigt.
 *   Fehler beim Erledigen: Keine Aufgabe mit ID 99 gefunden.
 *   --- Aufgabenliste (2) ---
 *   [x] #1 Bootcamp-Modul 03 durcharbeiten
 *   [ ] #2 Java-Übung 03-architecture lösen
 */
public class Main {

    public static void main(String[] args) {
        // TODO: Nach dem Lösen der TODOs in TodoService/TodoController die
        //       nächsten drei Zeilen einkommentieren und die Zeile danach
        //       ("TodoController controller = new TodoController();") löschen:
        //
        // TodoRepository repository = new InMemoryTodoRepository();
        // TodoService service = new TodoService(repository);
        // TodoController controller = new TodoController(service);

        TodoController controller = new TodoController();

        controller.szenarioDurchspielen();
    }
}
