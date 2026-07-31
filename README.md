# Bootcamp: Softwarearchitektur & frühe Projektplanung

Ein selbstgetakteter Bootcamp — kein Klausurbezug, kein festes Enddatum. Er bringt dir bei, ein Softwareprojekt sinnvoll zu planen, bevor die erste Zeile Code entsteht, und Code danach so zu strukturieren, dass er in einem Jahr noch änderbar ist.

## Wie du anfängst

Öffne **`lehrkurse/index.html`** direkt im Browser (Doppelklick reicht, es braucht keinen Server). Von dort aus verlinkt jede Seite zur nächsten.

## Was hier drin ist

| Ordner | Inhalt |
|---|---|
| `lehrkurse/` | 6 interaktive HTML-Module (Theorie + Grafiken + Übungen: Multiple/Single Choice, Lückentext, Drag & Drop, Umklapp-Karten, Kontrollfragen) |
| `code/` | Zu jedem Modul passende Java-Übungen — als reine `.java`-Dateien, in IntelliJ direkt per Play-Button lauffähig, keine Maven/Gradle nötig |
| `css/` | `colorpalett.css` (Design-Tokens) + `styles.css` (Layout/Komponenten) — **eine** zentrale Design-Quelle für alle Modul-Seiten |
| `js/quiz.js` | die gemeinsame Übungs-Engine hinter allen interaktiven Aufgaben |
| `canvas/Mindmap_Architektur.canvas` | Mindmap aller Themen und ihrer Zusammenhänge (öffnen mit [Obsidian](https://obsidian.md)) |
| `Lernpfad.md` | vorgeschlagene Reihenfolge/Session-Einteilung, ohne feste Termine |

## Die 6 Module

0. **Vom Problem zum Plan** — Anforderungen, User Stories, MVP-Scoping, Architecture Decision Records, Tech-Stack-Entscheidungen
1. **SOLID-Prinzipien** — die fünf Grundprinzipien für wartbaren objektorientierten Code
2. **Design Patterns** — Strategy, Factory Method, Observer, Adapter, Decorator, Singleton-Fallstricke
3. **Architekturstile** — Schichtenarchitektur, MVC, Clean/Hexagonal Architecture, Monolith vs. Microservices
4. **Modularität, Kopplung & Kohäsion** — wie man Module so schneidet, dass Änderungen lokal bleiben
5. **Fallstudie** — ein kleines System von der Anforderung bis zur Architekturentscheidung durchdenken, alles Vorherige im Zusammenspiel

## Wie du am meisten mitnimmst

- **Lies nicht nur, rechne mit.** Jedes Modul hat Übungen direkt im Text — überspring sie nicht, auch wenn die Antwort "offensichtlich" scheint.
- **Bearbeite die Java-Übung zum Modul, bevor du weitergehst.** Die HTML-Module erklären das *Warum*, `code/` gibt dir das *Selbst-tun*. Beides zusammen bleibt hängen, keins davon allein.
- **Die Fallstudie (Modul 05) ist der eigentliche Test.** Wenn du sie ohne ständiges Zurückblättern durchgehst, hast du den Bootcamp verstanden.

## Über die Design-Entscheidungen dieses Bootcamps

Alle 6 Modul-Seiten teilen sich `css/styles.css` und `js/quiz.js`, statt dass jede Seite ihr eigenes Styling/Skripting mitbringt — das hält das Design an *einer* Stelle änderbar (siehe `Migration ins Hauptprojekt/SKILL_Interactive_Bootcamp_Format.md` für die Details, falls du das Format für ein anderes Thema wiederverwenden willst).

Die ursprünglichen Stil-Referenzdateien (`Stylevorgabe/`, `Canvas_Beispiel.canvas`) wurden entfernt, nachdem ihr Muster in `css/` und `canvas/` überführt wurde — sie werden nicht mehr gebraucht.
