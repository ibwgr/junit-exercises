## Setup

1. Fork https://github.com/ibwgr/junit-exercises
    1. Dazu Button "fork" oben rechts klicken
1. Clone 
1. Neues Projekt in IntelliJ erstellen (File > New > Project From Existing Source)
    1. Order auswählen von geclontem Repository (z.B. C:/Users/hillary/junit-exercises)
    1. Alle Dialoge mit "next" durchklicken
1. Unter Einstellungen nach "Java Compiler" suchen
    1. Unter "Target Byte Version" 1.8 einstellen
    <img src="https://github.com/ibwgr/junit-exercises/doc/compiler.png" width="400">
1. Unter File > Project Structure > Modules "Language Level" auf 8 einstellen
    <img src="https://github.com/ibwgr/junit-exercises/doc/modules.png" width="400">
1. Rechtklick auf PersonTest > Run 'PersonTest'
    1. Die Tests sollten nun alle durchlaufen, wobei die meisten davon mit einer NotImplementedException fehlschlagen