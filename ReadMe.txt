Compilateur d’un langage de calculette haut-niveau vers du MVàP (avec utilisation d'antlr).


antlr4 Calculette.g4
javac *.java
java org.antlr.v4.gui.TestRig Calculette 'start' -gui > test.mvap
/* écrire la formule ici, par exemple: */
int i
i = 2
print(2+3))
CTRL+D
/* ça ouvre un arbre de dérivation */
java compilateur d’un langage de calculette haut-niveau vers du MVaPAssembler test.mvap
java CBaP test.mvap.cbap
/* ça affiche le résultat */
/* dans le fichier test.mvap se trouve le langage compilateur de votre formule */
