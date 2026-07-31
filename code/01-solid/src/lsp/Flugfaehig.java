package lsp;

/**
 * Abstraktion NUR fuer Voegel, die tatsaechlich fliegen koennen.
 * Nur wer diese Faehigkeit wirklich hat, implementiert dieses
 * Interface - das ist der Kern der LSP-konformen Loesung: der
 * Vertrag "fliegen() funktioniert" wird nur von Klassen versprochen,
 * die ihn auch einhalten koennen.
 */
public interface Flugfaehig {
    String fliegen();
}
