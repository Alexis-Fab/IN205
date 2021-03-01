# IN205

Projet Bataille Navale Fabrigoule Alexis
==

Le sujet pdf demande à commenter nos fonctions mais les slides de présentation ainsi que les séances avant les vacances confirment qu’il n’est pas demandé de commenter nos fonctions. Il nous faut nous contenter de la javadoc, ce que j’ai fait.

Pour compiler le projet, il faut se placer à la racine et taper :\
mvn clean install exec:java

Exercice 1
-
Pour la méthode print, j’ai opté pour un affichage des grilles côte à côte et de déléguer l’affichage de chaque ligne à une fonction auxiliaire nommé printLine.\
Concernant l’encapsulation, on fait attention à rendre les attribut privés et de définir les getters et setters adéquats.

Problème rencontré : changer la taille des tableaux strikes et ships lorsqu’on spécifie une taille inhabituelle dans l’initialisation du board. En effet, modifier l’attribut boardSize ne modifie pas strikes et ships. Par conséquent, j’ai redéfini ces deux tableaux dans le constructeur.

Exercice 2
-
Nous créons un sous-dossier ships dans ensta qui sert de package indépendant pour les fichiers qui concernent la création des navires. Encore une fois, on fait attention à l’encapsulation.

Problème rencontré : Réussir à importer correctement le package ships ainsi que l’enum Orientation. Il a fallu entre autre sortir l’enum Orientation de la classe AbstractShip.

Exercice 3
-
A ce stade, j’ai décidé de considérer les coordonnées strictement positive comme le rentrerait un joueur et de leur soustraire un lorsqu’on fait un appel à un tableau. Je reviendrai sur cette décision vers la fin du projet pour finalement soustraire un dès que le joueur entre des coordonnées.\
Dans le cas où le navire dépasse de la grille ou qu’il prend sur la place d’un navire déjà présent, on affiche un message adapté au problème rencontré et on renvoie une exception. Cette erreur sera traité par la fonction qui fait appel à putShip et permettra de demander de nouveau de rentrer un navire.\
Il aura fallu modifier Iboard afin de pouvoir retourner une exception.

Exercice 4
-
A l’aide d’un try catch dans Player, on peut demander de placer un navire jusqu’à ce que ce dernier ait pu être correctement placé.

Problème rencontré : J’ai dû modifier InputHelper puisque j’avais pris les conventions de coordonnées strictement positives et j’ai échangé les rôles de x et y. Je suis par la suite revenu sur le choix de coordonnées st. positives.

Exercice 5
-
J’ai eu du mal à comprendre pourquoi il fallait la méthode isSunk à la fois dans ShipState et dans AbstractShip. Cependant une fois l’obstacle de la compréhension passé, le reste c’est déroulé tout seul.\
On change le tableau strikes pour qu’il stocke des Boolean au lieu de boolean ce qui permet de garder une valeur null.

Exercice 6
-
Pour sendHit, nous n’avons pour l’instant pas besoin de stocker les coordonnées du tir puisque l’appel à setHit se fait en interne. Cependant les coordonnées serviront à l’affichage final dans la classe Game.java.\
SendHit fait attention à ne pas autoriser un tir sur un emplacement déjà sélectionné auparavant.
HasShip renvoie bien false lorsque le navire sur place a été détruit.

Exercice 7
-
Là encore, le putShips capture une exception dans le cas d’un placement impossible afin de tenter un nouveau placement aléatoire.\
La méthode canPutShip n’est pas utilisée car j’ai déjà codé ce qu’elle fait dans la méthode putShips de Board.

Exercice 8
-
Il est possible de choisir la taille de la grille. Le nombre de navire est fixé à cinq mais on pourrait facilement imaginer une version où on demander le nombre souhaité pour chaque type de navire.\
makeHitMessage est modifié car le cas d’un bateau détruit est déjà pris en compte dans la méthode toString de Hit. Sinon cela affiche « Sous-marin coulé coulé ». Cela permet d’avoir facilement un tel affichage pour TestGame et TestBoard.

Test
-
Quelques tests primitifs et peu pertinents ont été ajoutés dans le dossier de test.

Problème rencontré : Le code fourni était prévupour l'utilisation de junit3. J'ai donc corrigé le pom.xml et adapté la structure de AppTest.java.

Versionning
-
J'ai rencontré un problème de fusion entre la branche main et la branche master qui s'est résolu en forçant la fusion de branche sans historique commun.\
J'ai donc ensuite supprimé la branche master.
