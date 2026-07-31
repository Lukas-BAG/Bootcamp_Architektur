package lsp;

/**
 * "Nachher"-Basisklasse: enthaelt NUR das, was wirklich alle Voegel
 * gemeinsam haben (hier vereinfacht: einen Namen) - nicht mehr
 * fliegen(), da nicht jeder Vogel fliegen kann. Diese Klasse ist
 * bereits fertig, keine TODOs hier.
 */
public abstract class VogelNachher {

    protected final String name;

    protected VogelNachher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
