# Neptune Messages (NM)

Op-only Paper-Plugin (1.21.x): Mit `/nm` öffnest du ein Menü, schreibst einen Text,
färbst ihn (MiniMessage oder `&`-Codes) und sendest ihn als „Neptune SMP“ an alle Spieler in allen Welten.
Es wird nie ein Absender angezeigt.

## Bauen

Lokal: `mvn package` (Java 21) -> `target/NeptuneMessages-1.0.0.jar` in den `plugins`-Ordner legen.

Auf GitHub: Jeder Push startet den Build (Reiter **Actions** -> Lauf öffnen -> Artifact **NeptuneMessages**).
Ein Tag wie `v1.0.0` erstellt zusätzlich ein Release mit der Jar.

## Befehle

- `/nm` – Menü öffnen
- `/nm <text>` – Text setzen und Menü öffnen
- `/nm reload` – Config neu laden

Berechtigung: `neptunemessages.use` (nur Op).
