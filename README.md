# ⚽ Projet COO - Compétitions Sportives V3 ⚽
## Noms et prenoms: 

 - Ismail Aymane : aymane.ismail.etu@univ-lille.fr
 - Hachour Mohammed ouramdane : mohammed.hachour.etu@univ-lille.fr 

Groupe 1 - Licence 3 Informatique - 2022/2023

## Introduction sur le sujet du projet
##### Ce projet permet d'organiser et de simuler une competition sportive au cours de laquelle des équipes s'affrontent :

- **Les championnats (League)** se jouent en matchs aller/retour. Chaque competiteur rencontre donc 2 fois chacun
des autres competiteurs du championnat. A l’issue du championnat, le vainqueur est donc le competiteur ayant
cumul´e le plus grand nombre de victoires.

- **Les tournois (Tournament)** a elimination directe se deroulent sur plusieurs tours. Seuls les competiteurs ayant
gagne leur match lors d’un tour participent au tour suivant. Les vainqueurs de chaque match se rencontrent
ainsi entre eux jusqu’a ce qu’il n’en reste plus qu’un, declare alors vainqueur du tournoi. Ce dernier a donc
obtenu autant de victoires que le nombre de tours joues... L’organisation de tels tournois necessite un nombre
de competiteurs puissance de 2.
 
- **Master** : La competition commence par une phase de poules a l’issue de laquelle certains competiteurs sont selectionnes pour disputer la phase finale du tournoi. Les poules sont organisees sour forme de championnat tandis que la phase finale se
d´eroule sous la forme d’un tournoi a elimination directe.



## How To 

### Recupération du dépot

    git clone https://gitlab-etu.fil.univ-lille.fr/mohammed.hachour.etu/coo_hachour_ismail

<br>

## *Toutes les commandes suivantes sont a executer a la racine du projet :*

### Commande de génération de la documentation se trouvant dans ./docs :

    make javadoc
OU

    javadoc -sourcepath src -d docs -subpackages main

### Commande pour Compiler les sources :

    make compil
OU

    javac -sourcepath src -d classes src/main/*/*.java

### Commande pour Executer les sources :

#### Pour obtenir une execution de League :

    make league
OU

    java -classpath classes main.main.MainLeague

#### Pour obtenir une execution de Tournament :

    make tournament
OU

    java -classpath classes main.main.MainTournament

#### Pour obtenir une execution de Master :

    make
OU

    java -classpath classes main.main.MainMaster

 
### Commande de génération de l’archive du projet (par defaut Master / au choix avec les 3 commandes):

    make createJar
OU (1 parmis les 3)

    jar cvfe game.jar main.main.MainMaster -C classes .  
    jar cvfe game.jar main.main.MainLeague -C classes .
    jar cvfe game.jar main.main.MainTournament -C classes . 

### Commande d'exécution de l’archive du projet:

    make executeJar
OU

    java -jar game.jar

### Commande de compilation des tests:

    javac -cp classes:junit-platform-console-standalone-1.9.1.jar -d classes test/*/*.java
OU

    make compiltest

### Commande d'exécution des tests :

    java -jar junit-platform-console-standalone-1.9.1.jar -cp classes --scan-class-path
OU

    make runTest

### Presentation d'elements de code saillants :

 - Réalisation d'un Makefile afin de faciliter le rendu du projet 
 - Gestion des erreurs de constructeurs : Impossible de faire un match avec 2 équipes identiques 
 - Gestion des erreurs de constructeur Tournament : Impossible de creer un tournoi avec un nombre d'équipe qui n'est pas une puissance de 2 
 - Execution du programme au choix : MasterMain OU MasterLeague OU MasterTournament
 - Choix de la strategy de selection de Master dans le main
 - Choix des Bookmakers et des Journalists dans les mains (PS : La côte minimale pour un competiteur est 1 & decommenter le code pour choisir)
 - Liste des équipes dans le main pour modifier/ajouter des equipes rapidement
 - Respect de la documentation du code | des tests | UML fourni | conception (TDD, heritage, heritage de tests, ...)
 - Design Pattern : Factory Method / Composite / Strategy / Observer/Observable
 - Avancement regulier du projet et presence / participation en TD/TP 
 - Respect de toutes les consignes de rendu

## UML

![UML](./uml.png)



