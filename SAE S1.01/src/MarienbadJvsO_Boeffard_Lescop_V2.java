/**
 * Ce programme permet de jouer au jeu de Marienbad contre un ordinateur et contre un autre joueur, elle permet aussi de lancer des tests unitaires.
 * Le jeu consiste à retirer des allumettes d'un tableau de jeu, le dernier joueur à retirer une allumette perd.
 * L'ordinateur utilise une stratégie gagnante basée sur le XOR des longueurs des lignes pour gagner.
 * Le jeu est joué en alternance entre le joueur humain et l'ordinateur jusqu'à ce que toutes les allumettes soient retirées.
 * Le programme demande à l'utilisateur s'il souhaite lancer les tests ou une partie.
 *
 * @version 1.0
 * @author K.Boeffard
 * @author N.Lescop
 */
class MarienbadJvsO_Boeffard_Lescop_V2 {

    /**
     * Point d'entrée du programme.
     * Demande à l'utilisateur s'il souhaite lancer les tests ou une partie.
     */
    void principal() {
        // Demande à l'utilisateur s'il veut lancer les tests
        char reponse = SimpleInput.getChar("Voulez-vous lancer les tests ? (o/n) ");

        // Lancement des tests ou de la partie en fonction de la réponse de l'utilisateur
        if (reponse == 'o') {
            lanceTest();
        } else {
            lancePartie();
        }
    }

    // ----- Lancement de la partie -----

    /**
     * Lance une partie de Marienbad. Le jeu alterne entre le joueur humain et l'ordinateur
     * jusqu'à ce que toutes les allumettes soient retirées. Le dernier à prendre une allumette perd.
     */
    void lancePartie() {
        // Saisie du nom du joueur humain
        String joueurHumain = SimpleInput.getString("Entrez le nom du joueur : ");
        String joueurOrdi = "Ordinateur";  // Nom fixe pour l'ordinateur

        // Détermine aléatoirement qui commence
        String joueurEnJeux = Math.random() < 0.5 ? joueurHumain : joueurOrdi;

        // Demande du nombre de lignes de jeu et création du tableau de jeu
        int ligneJeux = getLigne(2, 15);
        String[] tabJeux = createTabJeux(ligneJeux);

        boolean partieLancee = true;

        // Boucle principale de jeu
        while (partieLancee) {
            // Affichage de l'état actuel du tableau de jeu
            affiche(tabJeux);

            System.out.println("Au tour du joueur : " + joueurEnJeux);

            // Tour de l'ordinateur
            if (joueurEnJeux == joueurOrdi) {
                if (strategieGagnante(tabJeux)) {
                    System.out.println("L'ordinateur utilise la stratégie gagnante.");
                    jouerCoupGagnant(tabJeux);
                } else {
                    System.out.println("L'ordinateur joue un coup aléatoire.");
                    jouerCoupAleatoire(tabJeux);
                }
            }
            // Tour du joueur humain
            else {
                int ligneJoue = getLigneNotVide(0, ligneJeux - 1, tabJeux);
                retirerAllumettes(ligneJoue, tabJeux);
            }

            // Vérifie si la partie est terminée
            partieLancee = !partieTerminee(tabJeux);

            // Si la partie est terminée, annonce le vainqueur
            if (!partieLancee) {
                System.out.println("Le joueur " + joueurEnJeux + " a gagné !");
            }

            // Changement de joueur (alternance entre humain et ordinateur)
            if (joueurEnJeux == joueurHumain) {
                joueurEnJeux = joueurOrdi;
            } else {
                joueurEnJeux = joueurHumain;
            }
        }
    }

    // ----- Gestion des stratégies -----

    /**
     * Détermine si une stratégie gagnante est possible.
     * @param tabJeux Tableau de l'état actuel du jeu
     * @return true si une stratégie gagnante est possible, sinon false
     */
    boolean strategieGagnante(String[] tabJeux) {
        return getXor(tabJeux) != 0;
    }

    /**
     * Calcule le XOR des longueurs des lignes dans le tableau de jeu.
     * @param tabJeux Tableau représentant l'état actuel du jeu
     * @return Le résultat du XOR de toutes les lignes
     */
    int getXor(String[] tabJeux) {
        int xor = 0;
        for (int i = 0; i < tabJeux.length; i++) {
            xor ^= tabJeux[i].length();
        }
        return xor;
    }

    /**
     * Joue un coup gagnant basé sur la stratégie de Marienbad.
     * @param tabJeux Tableau représentant l'état actuel du jeu
     */
    void jouerCoupGagnant(String[] tabJeux) {
        int xorTotal = getXor(tabJeux);

        // Variables pour stocker la ligne et le nombre d'allumettes à retirer
        int ligneARetirer = -1;
        int nbAllumettesARetirer = 0;

        // Parcourt chaque ligne pour trouver où jouer le coup gagnant
        for (int i = 0; i < tabJeux.length; i++) {
            int nbAllumettes = tabJeux[i].length();
            int resteApresRetrait = nbAllumettes ^ xorTotal;

            // Si le reste est inférieur aux allumettes actuelles, on stocke les informations
            if (resteApresRetrait < nbAllumettes && ligneARetirer == -1) {
                ligneARetirer = i;
                nbAllumettesARetirer = nbAllumettes - resteApresRetrait;
            }
        }

        // Exécute la modification si une ligne a été trouvée
        if (ligneARetirer != -1) {
            System.out.println("L'ordinateur retire " + nbAllumettesARetirer + " allumettes de la ligne " + ligneARetirer);
            tabJeux[ligneARetirer] = genererAllumettes(tabJeux[ligneARetirer].length() - nbAllumettesARetirer);
        }
    }


    /**
     * Joue un coup aléatoire si aucune stratégie gagnante n'est disponible.
     * @param tabJeux Tableau représentant l'état actuel du jeu
     */
    void jouerCoupAleatoire(String[] tabJeux) {
        // Choisit une ligne au hasard tant qu'elle n'est pas vide
        int ligneJoue = (int) (Math.random() * tabJeux.length);
        while (tabJeux[ligneJoue].length() == 0) {
            ligneJoue = (int) (Math.random() * tabJeux.length);
        }

        // Retire un nombre aléatoire d'allumettes sur cette ligne
        int nbAllumettes = tabJeux[ligneJoue].length();
        int nbAllumettesSuppr = (int) (Math.random() * nbAllumettes) + 1;
        System.out.println("L'ordinateur retire " + nbAllumettesSuppr + " allumettes de la ligne " + ligneJoue);
        tabJeux[ligneJoue] = genererAllumettes(nbAllumettes - nbAllumettesSuppr);
    }

    // ----- Création et gestion des allumettes -----

    /**
     * Crée un tableau de jeux avec un nombre de lignes donné.
     * @param ligne Nombre de lignes du tableau
     * @return Tableau représentant l'état initial du jeu
     */
    String[] createTabJeux(int ligne) {
        String[] tabJeux = new String[ligne];
        for (int j = 0; j < ligne; j++) {
            tabJeux[j] = genererAllumettes(2 * j + 1);
        }
        return tabJeux;
    }

    /**
     * Génère une chaîne représentant un certain nombre d'allumettes.
     * @param nombre Nombre d'allumettes à générer
     * @return Chaîne contenant des '|' pour représenter les allumettes
     */
    String genererAllumettes(int nombre) {
        String allumettes = "";
        for (int i = 0; i < nombre; i++) {
            allumettes += "|";  // Ajoute une allumette
        }
        return allumettes;
    }

    // ----- Affichage du jeu et gestion des saisies utilisateur -----

    /**
     * Affiche l'état actuel du tableau de jeu.
     * @param tabJeux Tableau représentant l'état actuel du jeu
     */
    void affiche(String[] tabJeux) {
        for (int i = 0; i < tabJeux.length; i++) {
            if (i < 10) {
                System.out.print(" ");
            }
            System.out.println(i + " : " + tabJeux[i]);
        }
    }

    /**
     * Demande à l'utilisateur de saisir un nombre de lignes valide pour le jeu.
     * @param a Borne inférieure du nombre de lignes
     * @param b Borne supérieure du nombre de lignes
     * @return Le nombre de lignes saisi par l'utilisateur
     */
    int getLigne(int a, int b) {
        int ligne = SimpleInput.getInt("Entrez le nombre de lignes du tableau de jeux : ");
        while (ligne < a || ligne > b) {
            System.out.println("Le nombre de lignes doit être entre " + a + " et " + b);
            ligne = SimpleInput.getInt("Entrez le nombre de lignes du tableau de jeux : ");
        }
        return ligne;
    }

    /**
     * Demande à l'utilisateur de saisir une ligne non vide.
     * @param a Borne inférieure du numéro de ligne
     * @param b Borne supérieure du numéro de ligne
     * @param tabJeux Tableau représentant l'état actuel du jeu
     * @return Le numéro de la ligne saisi par l'utilisateur
     */
    int getLigneNotVide(int a, int b, String[] tabJeux) {
        int ligne = SimpleInput.getInt("Entrez le numéro de la ligne : ");
        while (ligne < a || ligne > b || tabJeux[ligne].length() == 0) {
            System.out.println("La ligne doit être non vide et entre " + a + " et " + b);
            ligne = SimpleInput.getInt("Entrez le numéro de la ligne : ");
        }
        return ligne;
    }

    /**
     * Retire un certain nombre d'allumettes d'une ligne donnée.
     * @param ligneJoue Numéro de la ligne d'où retirer les allumettes
     * @param tabJeux Tableau représentant l'état actuel du jeu
     */
    void retirerAllumettes(int ligneJoue, String[] tabJeux) {
        int nbAllumettes = tabJeux[ligneJoue].length();
        int nbAllumettesSuppr = SimpleInput.getInt("Combien d'allumettes voulez-vous supprimer ? ");
        while (nbAllumettesSuppr < 1 || nbAllumettesSuppr > nbAllumettes) {
            System.out.println("Le nombre d'allumettes doit être entre 1 et " + nbAllumettes);
            nbAllumettesSuppr = SimpleInput.getInt("Combien d'allumettes voulez-vous supprimer ? ");
        }
        tabJeux[ligneJoue] = genererAllumettes(nbAllumettes - nbAllumettesSuppr);
    }

    // ----- Fin de la partie -----

    /**
     * Détermine si la partie est terminée (toutes les lignes sont vides).
     * @param tabJeux Tableau représentant l'état actuel du jeu
     * @return true si toutes les lignes sont vides, sinon false
     */
    boolean partieTerminee(String[] tabJeux) {
        boolean returnVal = true;
        for (int i = 0; i < tabJeux.length; i++) {
            if (tabJeux[i].length() != 0) {
                returnVal = false;  // S'il reste des allumettes, la partie n'est pas terminée
            }
        }
        return returnVal;  // Toutes les lignes sont vides, la partie est terminée
    }

    // ----- Lancement des tests -----

    /**
     * Lance les tests unitaires du jeu.
     */
    void lanceTest() {
        // Tests des fonctions principales du jeu
        testCompareTableaux();
        testCreateTabJeux();
        testPartieTerminee();
        testStrategieGagnante();
        testRetirerAllumettes();
        testGetXor();
    }

    // ----- Test de comparaison de tableaux -----

    /**
     * Teste la fonction compareTableaux
     */
    void testCompareTableaux() {
        System.out.println();
        System.out.println("*** testCompareTableaux()");
        testCasCompareTableaux(new String[]{"|", "|||", "|||||"}, new String[]{"|", "|||", "|||||"}, true);
        testCasCompareTableaux(new String[]{"|"}, new String[]{"|", "|||"}, false);
        testCasCompareTableaux(new String[]{"|", "|||"}, new String[]{"|", "||"}, false);
    }

    /**
     * Teste un cas de la fonction compareTableaux
     * @param tab1 premier tableau à comparer
     * @param tab2 deuxième tableau à comparer
     * @param result résultat attendu
     */
    void testCasCompareTableaux(String[] tab1, String[] tab2, boolean result) {
        System.out.print("compareTableaux(");
        afficheTest(tab1);
        System.out.print(", ");
        afficheTest(tab2);
        System.out.print(") \t= " + result + "\t:");

        boolean test = compareTableaux(tab1, tab2);
        if (test == result) {
            System.out.println("OK");
        } else {
            System.out.println("ERREUR");
        }
    }

    /**
     * Teste la fonction createTabJeux
     */
    void testCreateTabJeux() {
        System.out.println();
        System.out.println("*** testCreateTabJeux()");
        testCasCreateTabJeux(3, new String[]{"|", "|||", "|||||"});
        testCasCreateTabJeux(1, new String[]{"|"});
        testCasCreateTabJeux(0, new String[]{});
        testCasCreateTabJeux(5, new String[]{"|", "|||", "|||||", "|||||||", "|||||||||"});
    }

    /**
     * Teste un cas de la fonction createTabJeux
     * @param ligne nombre de lignes du tableau
     * @param result résultat attendu
     */
    void testCasCreateTabJeux(int ligne, String[] result) {
        System.out.print("createTabJeux(" + ligne + ") \t= ");
        afficheTest(result);
        System.out.print("\t:");

        String[] test = createTabJeux(ligne);
        if (compareTableaux(test, result)) {
            System.out.println("OK");
        } else {
            System.out.println("ERREUR");
        }
    }

    /**
     * Teste la fonction partieTerminee
     */
    void testPartieTerminee() {
        System.out.println();
        System.out.println("*** testPartieTerminee()");
        testCasPartieTerminee(new String[]{"", "", ""}, true);
        testCasPartieTerminee(new String[]{"|", "||", ""}, false);
        testCasPartieTerminee(new String[]{"|", "|", "|"}, false);
        testCasPartieTerminee(new String[]{""}, true);
        testCasPartieTerminee(new String[]{"", "|||", ""}, false);
    }

    /**
     * Teste un cas de la fonction partieTerminee
     * @param tabJeux tableau de jeux
     * @param result résultat attendu
     */
    void testCasPartieTerminee(String[] tabJeux, boolean result) {
        System.out.print("partieTerminee(");
        afficheTest(tabJeux);
        System.out.print(") \t= " + result + "\t:");

        boolean test = partieTerminee(tabJeux);
        if (test == result) {
            System.out.println("OK");
        } else {
            System.out.println("ERREUR");
        }
    }

    /**
     * Compare deux tableaux de chaînes de caractères
     * @param tab1 premier tableau à comparer
     * @param tab2 deuxième tableau à comparer
     * @return true si les tableaux sont identiques, false sinon
     */
    boolean compareTableaux(String[] tab1, String[] tab2) {
        boolean sontIdentiques = tab1.length == tab2.length;
        for (int i = 0; i < tab1.length && sontIdentiques; i++) {
            if (!tab1[i].equals(tab2[i])) {
                sontIdentiques = false;
            }
        }
        return sontIdentiques;
    }

    /**
     * Affiche un tableau de chaînes de caractères
     * @param tab tableau à afficher
     */
    void afficheTest(String[] tab) {
        System.out.print("{");
        for (int i = 0; i < tab.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print("\"" + tab[i] + "\"");
        }
        System.out.print("}");
    }

    // Tests de stratégie gagnante
    void testStrategieGagnante() {
        System.out.println();
        System.out.println("*** testStrategieGagnante()");
        testCasStrategieGagnante(new String[]{"|", "|||", "|||||"}, true);  // Stratégie gagnante disponible
        testCasStrategieGagnante(new String[]{"|", "|", "|"}, true);  // Stratégie gagnante disponible
        testCasStrategieGagnante(new String[]{"", "|||", ""}, true);  // Stratégie gagnante disponible
        testCasStrategieGagnante(new String[]{"|||", "|||"}, false);  // Stratégie gagnante non disponible
        testCasStrategieGagnante(new String[]{"||", "||", "||"}, true);  // Stratégie gagnante non disponible
        testCasStrategieGagnante(new String[]{"", "|||"}, true);  // Stratégie gagnante non disponible
    }

    /**
     * Teste un cas de la méthode strategieGagnante
     * @param tabJeux tableau de jeux
     * @param result résultat attendu
     */
    void testCasStrategieGagnante(String[] tabJeux, boolean result) {
        System.out.print("strategieGagnante(");
        afficheTest(tabJeux);
        System.out.print(") \t= " + result + "\t:");

        boolean test = strategieGagnante(tabJeux);
        if (test == result) {
            System.out.println("OK");
        } else {
            System.out.println("ERREUR");
        }
    }


    /**
     * Teste la méthode retirerAllumettes()
     */
    void testRetirerAllumettes() {
        System.out.println();
        System.out.println("*** testRetirerAllumettes()");
        testCasRetirerAllumettes(new String[]{"|", "|||", "|||||"}, 1, 2, new String[]{"|", "|", "|||||"});  // Suppression de 2 allumettes
        testCasRetirerAllumettes(new String[]{"|", "|||", "|||||"}, 0, 1, new String[]{"", "|||", "|||||"});  // Suppression de 1 allumette
        testCasRetirerAllumettes(new String[]{"|", "|||", "|||||"}, 2, 5, new String[]{"|", "|||", ""});  // Suppression de 5 allumettes
        testCasRetirerAllumettes(new String[]{"|", "|||", "|||||"}, 1, 1, new String[]{"|", "||", "|||||"});  // Suppression de 1 allumette
        testCasRetirerAllumettes(new String[]{"", "|||", "|||||"}, 1, 3, new String[]{"", "", "|||||"});  // Suppression de toutes les allumettes sur la ligne 1
        testCasRetirerAllumettes(new String[]{"", "", "|||||"}, 2, 4, new String[]{"", "", "|"});  // Suppression de 4 allumettes sur la ligne 2
    }


    /**
     * Teste un cas de la méthode retirerAllumettes
     * @param tabJeux tableau de jeux avant le retrait
     * @param ligneJoue numéro de la ligne
     * @param nbAllumettesSuppr nombre d'allumettes à retirer
     * @param result tableau de jeux après le retrait
     */
    void testCasRetirerAllumettes(String[] tabJeux, int ligneJoue, int nbAllumettesSuppr, String[] result) {
        System.out.print("retirerAllumettes(" + ligneJoue + ", " + nbAllumettesSuppr + ") \t: ");
        afficheTest(tabJeux);
        System.out.print(" -> ");
        afficheTest(result);

        // Simuler le retrait
        tabJeux[ligneJoue] = "|".repeat(tabJeux[ligneJoue].length() - nbAllumettesSuppr);
        if (compareTableaux(tabJeux, result)) {
            System.out.println(" OK");
        } else {
            System.out.println(" ERREUR");
        }
    }

    /**
     * Teste la méthode getXor()
     */
    void testGetXor() {
        System.out.println();
        System.out.println("*** testGetXor()");
        testCasGetXor(new String[]{"|", "|||", "|||||"}, 7);  // XOR de 1, 3 et 5 = 7
        testCasGetXor(new String[]{"|", "|", "|"}, 1);  // XOR de 1, 1 et 1 = 1
        testCasGetXor(new String[]{"|||", "|||", "|||"}, 3);  // XOR de 3, 3 et 3 = 0
        testCasGetXor(new String[]{""}, 0);  // XOR d'une ligne vide = 0
        testCasGetXor(new String[]{"", "|", "|||"}, 2);  // XOR de 0, 1 et 3 = 2
    }

    /**
     * Teste un cas de la méthode getXor
     * @param tabJeux tableau de jeux
     * @param result résultat attendu
     */
    void testCasGetXor(String[] tabJeux, int result) {
        System.out.print("getXor(");
        afficheTest(tabJeux);
        System.out.print(") \t= " + result + "\t:");

        int test = getXor(tabJeux);
        if (test == result) {
            System.out.println("OK");
        } else {
            System.out.println("ERREUR");
        }
    }


}
