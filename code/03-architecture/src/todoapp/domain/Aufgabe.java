package todoapp.domain;

/*
 * ÜBUNGSZIEL DIESER KLASSE
 * ------------------------
 * Aufgabe ist ein reines Domain-Objekt: Es enthält Zustand (Titel, erledigt-Status)
 * und die Regeln, die direkt an diesem Zustand hängen. Es kennt NICHTS von der
 * Konsole (Presentation) und NICHTS von Speicherung/SQL (Data) — genau das ist der
 * Punkt der Schichtenarchitektur aus Modul 03: Die Domain-Schicht ist fachlich,
 * nicht technisch. Diese Klasse hätte in einer Web-App, einer Desktop-App oder
 * einem Batch-Job exakt denselben Code — sie weiß nicht, wie sie benutzt wird.
 */
public class Aufgabe {

    private final int id;
    private final String titel;
    private boolean erledigt;

    public Aufgabe(int id, String titel) {
        this.id = id;
        this.titel = titel;
        this.erledigt = false;
    }

    public int getId() {
        return id;
    }

    public String getTitel() {
        return titel;
    }

    public boolean isErledigt() {
        return erledigt;
    }

    /**
     * Fachliche Regel: Eine bereits erledigte Aufgabe kann nicht erneut
     * als erledigt markiert werden. Das ist Business-Logik — sie gehört
     * genau hierher (Domain) und nicht in den Controller oder das Repository.
     */
    public void alsErledigtMarkieren() {
        if (erledigt) {
            throw new IllegalStateException("Aufgabe '" + titel + "' ist bereits erledigt.");
        }
        erledigt = true;
    }

    @Override
    public String toString() {
        return "[" + (erledigt ? "x" : " ") + "] #" + id + " " + titel;
    }
}
