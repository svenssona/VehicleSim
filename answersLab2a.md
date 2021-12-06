# Answers for lab2a

## Uppgift 2

Vilka klasser är beroende av varandra som inte bör vara det?
- Det cykliska beroendet mellan CarView och CarController.

Finns det starkare beroenden än nödvändigt?
- Fråga TA:s om agregation är svagare än composition för CarControl och Car.

Kan ni identifiera några brott mot övriga designprinciper vi pratat om i kursen?
- Lösningen med Scania och turbo i CarController är ett brott mot openclose.

## Uppgift 3

Med avseende på Separation of Concern (SoC) och Single Responsibility Principle (SRP). 
- CarController har en main som tas ut till en annan klass CarApplication. Detta ger
tydligare ansvar (SoC & SRP).

TODO


##Refactoring plan for lab2b

TODO: Skriv denna.
Lös application samt cykliska dependencies.
