package observer;

/*
 * ÜBUNGSZIEL — Observer Pattern (verhaltensbezogen)
 * ------------------------------------------------------
 * Ein Beobachter (Observer) ist alles, was benachrichtigt werden will, wenn
 * sich das Subjekt (hier: der Warenkorb) ändert. Das Subjekt kennt seine
 * Beobachter nur über diese Schnittstelle — es weiß nicht, WIE VIELE es
 * gibt oder was sie mit der Nachricht tun.
 */
public interface Beobachter {

    /** Wird vom Subjekt aufgerufen, wenn sich etwas geändert hat. */
    void aktualisieren(String ereignis);
}
