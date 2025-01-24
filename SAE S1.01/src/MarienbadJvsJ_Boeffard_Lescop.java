/**
 * S1.01 : SAE Jeu de Nim (Joueur contre Joueur)
 * @author K.Boeffard
 * @author N.Lescop
 */

class MarienbadJvsJ_Boeffard_Lescop {

    /**
     * Méthode principale qui demande à l'utilisateur s'il veut lancer les tests ou une partie.
     */
    void principal() {

        // Demande si l'utilisateur souhaite lancer les tests ou commencer une partie
        char reponse = SimpleInput.getChar("Voulez-vous lancer les tests ? (o/n) ");

        // Si la réponse est 'o', on lance les tests, sinon on commence une partie
        if (reponse == 'o') {
            lanceTest();
        } else {
            lancePartie();
        }
    }

    // ----- Lancement d'une partie -----

    /**
     * Lance une partie de Marienbad entre deux joueurs.
     */
    void lancePartie() {
        // Création d'un tableau pour stocker les noms des deux joueurs
        String[] listJoueur = new String[2];

        // Demande les noms des deux joueurs
        for (int i = 0; i < listJoueur.length; i++) {
            listJoueur[i] = SimpleInput.getString("Entrez le nom du joueur : ");
        }

        // Sélection aléatoire du joueur qui commence
        String joueurEnJeux;
        if (Math.random() < 0.5) {
            joueurEnJeux = listJoueur[0];
        } else {
            joueurEnJeux = listJoueur[1];
        }

        // Saisie du nombre de lignes pour le jeu et création du tableau de jeu
        int ligneJeux = getLigne(2, 15);
        String[] tabJeux = createTabJeux(ligneJeux);

        // Variable pour contrôler si la partie continue
        boolean partieLancee = true;

        // Boucle principale de jeu
        while (partieLancee) {
            // Affichage de l'état du jeu
            affiche(tabJeux);
            System.out.println("Au tour du joueur : " + joueurEnJeux);

            // Demande à l'utilisateur de sélectionner une ligne non vide et de retirer des allumettes
            int ligneJoue = getLigneNotVide(0, ligneJeux - 1, tabJeux);
            retirerAllumettes(ligneJoue, tabJeux);

            // Vérification si la partie est terminée
            partieLancee = !partieTerminee(tabJeux);

            // Si la partie est terminée, annonce du gagnant
            if (!partieLancee) {
                System.out.println("Le joueur " + joueurEnJeux + " a gagné !");
            }

            // Changement de joueur
            if (joueurEnJeux == listJoueur[0]) {
                joueurEnJeux = listJoueur[1];
            } else {
                joueurEnJeux = listJoueur[0];
            }
        }
    }

    // ----- Lancement des tests -----

    /**
     * Lance les tests unitaires de la classe.
     */
    void lanceTest() {
        // Tests des différentes fonctions du jeu
        testCompareTableaux();
        testCreateTabJeux();
        testPartieTerminee();
    }

    // ----- Création et gestion du tableau de jeu -----

    /**
     * Crée un tableau de jeux de Marienbad avec un nombre de lignes donné.
     * @param ligne Nombre de lignes du tableau
     * @return Un tableau de chaînes représentant le jeu
     */
    String[] createTabJeux(int ligne) {
        String[] tabJeux = new String[ligne];

        // Remplissage du tableau avec le nombre d'allumettes correspondant
        for (int j = 0; j < ligne; j++) {
            tabJeux[j] = genererAllumettes(2 * j + 1); // Génère les allumettes pour chaque ligne
        }
        return tabJeux;
    }

    /**
     * Génère une chaîne d'allumettes (ex: "|||").
     * @param nombre Nombre d'allumettes à générer
     * @return Chaîne avec le nombre d'allumettes spécifié
     */
    String genererAllumettes(int nombre) {
        String allumettes = "";
        for (int i = 0; i < nombre; i++) {
            allumettes = allumettes + "|";  // Ajoute une allumette à chaque itération
        }
        return allumettes;
    }

    /**
     * Affiche un tableau de jeux de Marienbad.
     * @param tabJeux Tableau de chaînes représentant l'état actuel du jeu
     */
    void affiche(String[] tabJeux) {
        for (int i = 0; i < tabJeux.length; i++) {
            if (i < 10) {
                System.out.print(" ");
            }
            System.out.println(i + " : " + tabJeux[i]);
        }
    }

    // ----- Gestion des saisies utilisateur -----

    /**
     * Demande à l'utilisateur de saisir un nombre de lignes pour le jeu.
     * @param a Borne inférieure du nombre de lignes
     * @param b Borne supérieure du nombre de lignes
     * @return Le nombre de lignes choisi par l'utilisateur
     */
    int getLigne(int a, int b) {
        int ligne = SimpleInput.getInt("Entrez le nombre de lignes du tableau de jeux : ");

        // Vérification que le nombre de lignes est dans les bornes spécifiées
        while (ligne < a || ligne > b) {
            System.out.println("Le nombre de lignes doit être entre " + a + " et " + b);
            ligne = SimpleInput.getInt("Entrez le nombre de lignes du tableau de jeux : ");
        }
        return ligne;
    }

    /**
     * Demande à l'utilisateur de choisir une ligne non vide.
     * @param a Borne inférieure pour le choix de la ligne
     * @param b Borne supérieure pour le choix de la ligne
     * @param tabJeux Tableau de l'état actuel du jeu
     * @return Le numéro de la ligne choisie
     */
    int getLigneNotVide(int a, int b, String[] tabJeux) {
        int ligne = SimpleInput.getInt("Entrez le numéro de la ligne : ");

        // Vérifie que la ligne est dans les bornes et non vide
        while (ligne < a || ligne > b || tabJeux[ligne].length() == 0) {
            System.out.println("La ligne doit être non vide et entre " + a + " et " + b);
            ligne = SimpleInput.getInt("Entrez le numéro de la ligne : ");
        }
        return ligne;
    }

    // ----- Gestion des allumettes -----

    /**
     * Retire un nombre d'allumettes d'une ligne donnée.
     * @param ligneJoue Numéro de la ligne sélectionnée
     * @param tabJeux Tableau de l'état actuel du jeu
     */
    void retirerAllumettes(int ligneJoue, String[] tabJeux) {
        int nbAllumettes = tabJeux[ligneJoue].length();
        int nbAllumettesSuppr = SimpleInput.getInt("Combien d'allumettes voulez-vous supprimer ? ");

        // Vérifie que le nombre d'allumettes à retirer est valide
        while (nbAllumettesSuppr < 1 || nbAllumettesSuppr > nbAllumettes) {
            System.out.println("Le nombre d'allumettes doit être entre 1 et " + nbAllumettes);
            nbAllumettesSuppr = SimpleInput.getInt("Combien d'allumettes voulez-vous supprimer ? ");
        }

        // Met à jour la ligne en retirant les allumettes
        tabJeux[ligneJoue] = genererAllumettes(nbAllumettes - nbAllumettesSuppr);
    }

    // ----- Vérification de la fin de partie -----

    /**
     * Vérifie si la partie est terminée (si toutes les lignes sont vides).
     * @param tabJeux Tableau représentant l'état actuel du jeu
     * @return true si la partie est terminée, false sinon
     */
    boolean partieTerminee(String[] tabJeux) {
        boolean partieFinie = true;

        // Vérifie chaque ligne du tableau
        for (int i = 0; i < tabJeux.length; i++) {
            if (tabJeux[i].length() > 0) { // Si une ligne contient encore des allumettes
                partieFinie = false;
            }
        }
        return partieFinie; // Retourne true si toutes les lignes sont vides
    }

    // ----- Méthodes de test -----

    /**
     * Affiche un tableau de chaînes pour les tests.
     * @param tab Tableau à afficher
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

    /**
     * Compare deux tableaux de chaînes.
     * @param tab1 Premier tableau à comparer
     * @param tab2 Deuxième tableau à comparer
     * @return true si les deux tableaux sont identiques, false sinon
     */
    /**
     * Compare deux tableaux de chaînes sans utiliser equals() ni break.
     * @param tab1 Premier tableau à comparer
     * @param tab2 Deuxième tableau à comparer
     * @return true si les deux tableaux sont identiques, false sinon
     */
    boolean compareTableaux(String[] tab1, String[] tab2) {
        boolean identiques = true;

        // Si les tailles des tableaux diffèrent, ils ne sont pas identiques
        if (tab1.length != tab2.length) {
            identiques = false;
        } else {
            // Comparaison des éléments des deux tableaux caractère par caractère
            for (int i = 0; i < tab1.length && identiques; i++) {
                if (tab1[i].length() != tab2[i].length()) {
                    identiques = false;
                } else {
                    // Comparer chaque caractère des chaînes
                    for (int j = 0; j < tab1[i].length(); j++) {
                        if (tab1[i].charAt(j) != tab2[i].charAt(j)) {
                            identiques = false;
                        }
                    }
                }
            }
        }
        return identiques;
    }


    // ----- Tests unitaires -----

    /**
     * Teste la méthode compareTableaux().
     */
    void testCompareTableaux() {
        System.out.println();
        System.out.println("*** testCompareTableaux()");

        // Test de tableaux identiques
        testCasCompareTableaux(new String[]{"|", "|||", "|||||"}, new String[]{"|", "|||", "|||||"}, true);

        // Test de tableaux de tailles différentes
        testCasCompareTableaux(new String[]{"|"}, new String[]{"|", "|||"}, false);

        // Test de tableaux de même taille mais avec des éléments différents
        testCasCompareTableaux(new String[]{"|", "|||"}, new String[]{"|", "||"}, false);
    }

    /**
     * Teste un cas de la méthode compareTableaux().
     * @param tab1 Premier tableau à comparer
     * @param tab2 Deuxième tableau à comparer
     * @param result Résultat attendu
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
     * Teste la méthode createTabJeux().
     */
    void testCreateTabJeux() {
        System.out.println();
        System.out.println("*** testCreateTabJeux()");

        // Test avec plusieurs cas de création de tableau
        testCasCreateTabJeux(3, new String[]{"|", "|||", "|||||"});  // Tableau avec 3 lignes
        testCasCreateTabJeux(1, new String[]{"|"});  // Tableau avec 1 ligne
        testCasCreateTabJeux(0, new String[]{});  // Tableau vide
        testCasCreateTabJeux(5, new String[]{"|", "|||", "|||||", "|||||||", "|||||||||"});  // Tableau avec 5 lignes
    }

    /**
     * Teste un cas de la méthode createTabJeux().
     * @param ligne Nombre de lignes attendu dans le tableau
     * @param result Tableau attendu
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
     * Teste la méthode partieTerminee().
     */
    void testPartieTerminee() {
        System.out.println();
        System.out.println("*** testPartieTerminee()");

        // Tests avec différents scénarios de partie terminée ou non
        testCasPartieTerminee(new String[]{"", "", ""}, true);  // Toutes les lignes sont vides
        testCasPartieTerminee(new String[]{"|", "||", ""}, false);  // Au moins une ligne non vide
        testCasPartieTerminee(new String[]{"|", "|", "|"}, false);  // Toutes les lignes sont pleines
        testCasPartieTerminee(new String[]{""}, true);  // Une seule ligne vide
        testCasPartieTerminee(new String[]{"", "|||", ""}, false);  // Une ligne non vide au milieu
    }

    /**
     * Teste un cas de la méthode partieTerminee().
     * @param tabJeux Tableau représentant l'état actuel du jeu
     * @param result Résultat attendu
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

}
