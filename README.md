Avant de compiler avec javac pour tester un fichier en particulier :
CLASSPATH=~/Documents/IN205/bataille-navale/src/main/java/ensta/

Compilation du projet :

Se placer dans le dossier racine (bataille-navale)
mvn clean
mvn compile
mvn package


Remarques sur Junit :
Pour passer en junit 4, il faut remplacer les imports par:
import org.junit.Test;
import org.junit.TestCase;
import org.junit.TestSuite;
