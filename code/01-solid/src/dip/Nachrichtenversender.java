package dip;

/**
 * Die Abstraktion, von der sowohl die High-Level-Klasse
 * (Benachrichtigungsdienst) als auch alle Low-Level-Klassen
 * (EmailVersender, SmsVersender) abhaengen sollen - das ist der Kern
 * von DIP: nicht das High-Level-Modul haengt vom Low-Level-Modul ab,
 * sondern beide haengen von dieser gemeinsamen Abstraktion ab.
 */
public interface Nachrichtenversender {
    String senden(String empfaenger, String text);
}
