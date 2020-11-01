## Setup

1. Fork https://github.com/ibwgr/junit-exercises
    1. Dazu Button "fork" oben rechts klicken
1. Clone 
1. Neues Projekt in IntelliJ erstellen (File > New > Open)
    1. Order auswählen von geclontem Repository (z.B. C:/Users/hillary/junit-exercises)
    1. Alle Dialoge mit "next" durchklicken
1. Rechtsklick auf PersonTest > Run 'PersonTest'
    1. Die Tests sollten nun alle durchlaufen, wobei die meisten davon mit einer IllegalArgumentException fehlschlagen
1. `git remote add upstream https://github.com/ibwgr/junit-exercises.git`
    1. Lokalen master aktualisieren mit Änderungen vom Lehrer (z.B. Musterlösungen oder neuen Übungen): `git pull upstream master`
    
    
### Bei Problemen
* Unter Einstellungen nach "Java Compiler" suchen
    * Unter "Target Byte Version" 1.8 einstellen
    
    <img src="https://github.com/ibwgr/junit-exercises/raw/master/doc/compiler.png" width="400">
    
* Unter File > Project Structure > Modules "Language Level" auf 8 einstellen
    
    <img src="https://github.com/ibwgr/junit-exercises/raw/master/doc/modules.png" width="400">
    
* Unter Einstellungen > Version Control <Project> (roter Eintrag) mit "-" Löschen, und den Eintrag unter "unregistered" mit "+" Hinzufügen
    