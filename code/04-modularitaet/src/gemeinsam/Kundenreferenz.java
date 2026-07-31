package gemeinsam;

/*
 * ÜBUNGSZIEL — Modul 04: Zyklische Abhängigkeiten auflösen
 * ══════════════════════════════════════════════════════
 *
 * Dies ist das "dritte, neutrale Modul", von dem der Lehrkurs in Kapitel 4
 * spricht: eine gemeinsame, stabile Abstraktion, von der sowohl bestellung
 * als auch kunde abhängen dürfen, OHNE dass dadurch ein Zyklus entsteht.
 * gemeinsam selbst hängt von niemandem ab — genau das macht es "neutral" und
 * stabil.
 *
 * Der Trick: Bestellung braucht von einem Kunden nur eine winzige Information
 * (aktuell: den Namen). Genau diese Information — nicht mehr — gehört in
 * dieses Interface. Kunde implementiert es; bestellung hängt nur noch von
 * diesem Interface ab, nie mehr von der konkreten Klasse Kunde.
 *
 * DEINE AUFGABE:
 *   TODO 1 (zuerst!): Definiere hier die Methode(n), die Bestellung von einem
 *   Kunden wirklich braucht. Tipp: Wirf einen Blick in
 *   bestellung/Bestellung.java, Methode kundenname() — genau die dort
 *   aufgerufene Methode gehört hier ins Interface.
 *
 * Nach TODO 1 geht es weiter mit TODO 2 in kunde/Kunde.java.
 */
public interface Kundenreferenz {

    // TODO 1: z. B. "String getName();" — siehe Erklärung oben.

}
