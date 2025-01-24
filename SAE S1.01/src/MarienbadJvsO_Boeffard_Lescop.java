/**
 * Programme Marienbad Joueur contre Joueur
 * @author K.Boeffard
 * @author N.Lescop
 */

class MarienbadJvsO_Boeffard_Lescop {

    void principal() {
        // Demande à l'utilisateur s'il veut lancer les tests
        char reponse = ' ';
        while (reponse != 'O' && reponse != 'N') {
            reponse = SimpleInput.getChar("Voulez-vous lancez les tests ? (repondez par (O) si oui ou par (N) si non) : ");
        }

        // Lancement des tests ou de la partie en fonction de la réponse de l'utilisateur
        if (reponse == 'O') {
            lanceTest();
        } else {
            lancement();
        }

    }

    /**
     * Lancement du programme
     */
    void lancement() {

        // - Message de Bienvenue

        System.out.println("Bienvenue dans le jeu de Marienbad !");
        System.out.println("Les regles sont simples, le but du jeu est d'etre le dernier joueur a retirer une ou plusieurs allumettes.");
        System.out.println("Vous ne pouvez retirer qu'une ou plusieurs allumettes d'une seule ligne a la fois.");
        System.out.println();

        // - Enregistrement des noms des joueurs

        String[] listJoueur = new String[2];
        listJoueur[0] = SimpleInput.getString("Entrez le nom du joueur : ");
        System.out.println();

        while (listJoueur[0] == ""){
            listJoueur[0] = SimpleInput.getString("Entrez le nom du joueur : ");
        }

        // - Demande si l'utilisateur veut jouer contre un ordinateur expert ou debutant
        char reponseJoueur = ' ';
        while (reponseJoueur != 'O' && reponseJoueur != 'N') {
            reponseJoueur = SimpleInput.getChar("Voulez-vous jouer contre un ordinateur expert ? (O/N) ");
        }
        if (reponseJoueur == 'O') {
            listJoueur[1] = "Ordinateur expert";
            System.out.println();
            System.out.println("Vous allez jouer contre un ordinateur expert");
        } else {
            System.out.println();
            System.out.println("Vous allez jouer contre un ordinateur debutant");
            listJoueur[1] = "Ordinateur debutant";
        }

        // - Choix du joueur

        String joueurEnJeux = listJoueur[(int) (Math.random() * 2)];

        // - Création du tableau de jeux

        int ligneJeux = getLigne(2, 15);

        String[] tabJeux = createTabJeux(ligneJeux);

        // - Lancement du jeu

        boolean partieLancee = true;
        while (partieLancee) {

            // - Affichage de la partie

            affiche(tabJeux);
            System.out.println("Au tour du joueur : " + joueurEnJeux);
            System.out.println();

            // - Tour du Joueur ou de l'ordinateur

            if (joueurEnJeux == "Ordinateur expert") {
                ordinateurExpert(tabJeux);


            }else if (joueurEnJeux == "Ordinateur debutant") {
                OrdinateurDebutant(tabJeux);

            }else {
                int ligneJoue = getLigneNotVide(0, ligneJeux - 1, tabJeux);
                retirerAllumettesJoueur(ligneJoue, tabJeux); // Suppression des allumettes
            }

            // - Vérification de la fin de la partie

           partieLancee = !partieTerminee(tabJeux);

            // Si la partie est terminée, annonce le vainqueur

            if (!partieLancee) {
                System.out.println("Le joueur " + joueurEnJeux + " a gagne !");
            }

            // - Changement de joueur

            if (joueurEnJeux == (listJoueur[0])) {
                joueurEnJeux = listJoueur[1];
            } else{
                joueurEnJeux = listJoueur[0];
            }

        }

    }

    // -----  Création de l'ordinateur débutant -----

    /**
     * L'ordinateur débutant joue
     * @param tabJeux tableau de jeux
     */
    void OrdinateurDebutant(String[] tabJeux){
        int ligne = (int) (Math.random() * tabJeux.length);
        while (tabJeux[ligne].length() == 0){
            ligne = (int) (Math.random() * tabJeux.length);
        }
        int nbAllumettes = (int) (Math.random() * tabJeux[ligne].length()) + 1;
        retirerAllumettesOrdinateur(ligne, nbAllumettes, tabJeux);
        System.out.println("L'ordinateur a retire : " + nbAllumettes + " allumette(s), a la ligne : " + ligne);
        System.out.println();
    }

    // -----  Création de l'ordinateur expert -----

    /**
     * Détermine si une stratégie gagnante est possible.
     * @param tabJeux Tableau de l'état actuel du jeu
     * @return true si une stratégie gagnante est possible, sinon false
     */
    boolean strategieGagnante(String[] tabJeux) {
        return calculXor(tabJeux) != 0;
    }

    /**
     * Calcul du xor
     * Explication :
     * Le XOR (ou "exclusive OR") est une opération logique qui prend deux bits en entrée et retourne un bit en sortie.
     * La règle de base du XOR est que le résultat est 1 si et seulement si les deux bits d'entrée sont différents.
     * @param tabJeux tableau de jeux
     * @return résultat du xor
     */
    int calculXor(String[] tabJeux) {
        int resXor = 0; // Initialisation du résultat du XOR à 0

        // Parcourt chaque ligne du tableau de jeu
        for (int i = 0; i < tabJeux.length; i++) {
            int nbAllumettes = tabJeux[i].length(); // Nombre d'allumettes dans la ligne
            resXor ^= nbAllumettes; // Effectue l'opération XOR avec le nombre d'allumettes
        }

        return resXor; // Retourne le résultat du XOR
    }

    /**
     * L'ordinateur expert joue
     * @param tabJeux tableau de jeux
     */
    void ordinateurExpert(String[] tabJeux) {
        int resXor = calculXor(tabJeux); // Calcul du XOR de toutes les lignes
        boolean coupJoue = false; // Indicateur pour savoir si un coup a été joué

        // Si le résultat du XOR est 0, l'ordinateur est en position perdante
        if (resXor == 0) {
            // Cherche une ligne non vide et retire une allumette
            for (int i = 0; i < tabJeux.length && !coupJoue; i++) {
                if (tabJeux[i].length() > 0) {
                    retirerAllumettesOrdinateur(i, 1, tabJeux); // Enlève une allumette
                    coupJoue = true; // Indique qu'un coup a été joué
                }
            }
        } else {
            // Si le XOR n'est pas égal à 0, l'ordinateur peut trouver une combinaison gagnante
            for (int i = 0; i < tabJeux.length && !coupJoue; i++) {
                int tailleLigne = tabJeux[i].length(); // Taille actuelle de la ligne
                int nouvelleTailleLigne = tailleLigne ^ resXor; // Nouvelle taille après XOR

                // Si la nouvelle taille est inférieure à la taille actuelle, c'est un coup gagnant
                if (nouvelleTailleLigne < tailleLigne) {
                    int allumettesAenlever = tailleLigne - nouvelleTailleLigne; // Nombre d'allumettes à enlever
                    retirerAllumettesOrdinateur(i, allumettesAenlever, tabJeux); // Retire les allumettes
                    System.out.println("L'ordinateur a retire : " + allumettesAenlever + " allumette(s), à la ligne : " + i);
                    System.out.println();
                    coupJoue = true; // Indique qu'un coup a été joué
                }
            }
        }
    }

    /**
     * Retirer des allumettes par l'ordinateur
     * @param ligne numéro de la ligne
     * @param allumettesAenlever nombre d'allumettes à enlever
     * @param tabJeux tableau de jeux
     */
    void retirerAllumettesOrdinateur(int ligne, int allumettesAenlever, String[] tabJeux){
        int nouvelleLongueur = tabJeux[ligne].length() - allumettesAenlever;
        char [] nouvelleLigne = new char [nouvelleLongueur];

        for (int i = 0; i < nouvelleLongueur; i++){
            nouvelleLigne[i] = '|';
        }
        tabJeux[ligne] = new String(nouvelleLigne);
    }

    // ----- Gestion des allumettes -----

    /**
     * Création du tableau de jeu
     * @param ligne nombre de lignes du tableau de jeux
     * @return tableau de jeux
     */
    String[] createTabJeux(int ligne) {
        String[] tabJeux = new String[ligne];
        for (int j = 0; j < ligne; j++) {
            String builder = "";
            int nbChar = 2 * j + 1;
            for(int i = 0; i < nbChar; i++) {
                builder += "|";
            }
            tabJeux[j] = builder;
        }
        return tabJeux;
    }

    // ----- Affichage du jeu et gestion des saisies utilisateur -----

    /**
     * Affichage du tableau de jeu
     */
    void affiche(String[] tabJeux) {
        for (int i = 0; i < tabJeux.length; i++) {
            String ligneAvecEspaces = ""; // Chaine pour stocker la ligne avec des espaces

            // Ajoute un espacte après chaque allumette
            for (int j = 0; j < tabJeux[i].length(); j++) {
                ligneAvecEspaces += tabJeux[i].charAt(j) + " ";
            }

            // Affiche la ligne
            int ligne = tabJeux[i].length(); // Nombre d'allumettes dans la ligne
            if (i < 10) {
                System.out.println("Ligne : " + i + " : " + " " + ligneAvecEspaces + " (" + ligne + ")");
            } else {
                System.out.println("Ligne : " + i + " : " + ligneAvecEspaces + " (" + ligne + ")");
            }
        }
    }

    /**
     * Vérification de la ligne
     * @param ligne nombre de lignes du tableau de jeux
     * @param a borne inférieure
     * @param b borne supérieure
     * @return vrai si la ligne est en dehors des bornes
     */
    boolean verifLigne(int ligne, int a, int b) {
        boolean Valeur = false;
        if (ligne < a || ligne > b) {
            Valeur = true;
        }
        return Valeur;
    }

    /**
     * Vérification du nombre de lignes du tableau de jeux
     * @param a borne inférieure
     * @param b borne supérieure
     * @return nombre de lignes du tableau de jeux
     */
    int getLigne(int a, int b) {
        int ligne = SimpleInput.getInt("Entrez le nombre de lignes du tableau de jeux (entre 2 et 15) : ");
        System.out.println();

        while (verifLigne(ligne, a, b)) {
            System.out.println("Le nombre de ligne doit etre entre " + a + " et " + b + " compris");
            ligne = SimpleInput.getInt("Entrez le nombre de lignes du tableau de jeux : ");
        }
        return ligne;
    }

    /**
     * Vérification de la ligne non vide
     * @param a borne inférieure
     * @param b borne supérieure
     * @param tabJeux tableau de jeux
     * @return numéro de la ligne
     */
    int getLigneNotVide(int a, int b, String[] tabJeux) {
        int ligne = SimpleInput.getInt("Entrez le numero de la ligne : ");
        while (verifLigne(ligne, a, b) || tabJeux[ligne].length() == 0) {
            System.out.println("La ligne doit etre entre " + a + " et " + b + " compris et non vide");
            ligne = SimpleInput.getInt("Entrez le numero de la ligne : ");
        }
        return ligne;
    }

    /**
     * Retirer des allumettes
     * @param ligneJoue numéro de la ligne
     * @param tabJeux tableau de jeux
     */
    void retirerAllumettesJoueur(int ligneJoue, String[] tabJeux) {
        int nbAllumettes = tabJeux[ligneJoue].length();
        int nbAllumettesSuppr = SimpleInput.getInt("Combien d'allumettes voulez-vous supprimer ? ");
        System.out.println();

        while (nbAllumettesSuppr < 1 || nbAllumettesSuppr > nbAllumettes) {
            System.out.println("Le nombre d'allumettes doit etre entre 1 et " + nbAllumettes + " compris");
            nbAllumettesSuppr = SimpleInput.getInt("Combien d'allumettes voulez-vous supprimer ? ");
            System.out.println();
        }

        int nouvelleLongueur = nbAllumettes - nbAllumettesSuppr;
        char[] nouvelleLigne = new char[nouvelleLongueur];

        for (int i = 0; i < nouvelleLongueur; i++) {
            nouvelleLigne[i] = '|';
        }

        tabJeux[ligneJoue] = new String(nouvelleLigne);
    }

    // ----- Fin de la partie -----

    /**
     * Détermine si la partie est terminée (toutes les lignes sont vides).
     * @param tabJeux Tableau représentant l'état actuel du jeu
     * @return true si toutes les lignes sont vides, sinon false
     */
    boolean partieTerminee(String[] tabJeux) {
        boolean partieTerminee = true;
        for (int i = 0; i < tabJeux.length; i++) {
            if (tabJeux[i].length() != 0) {
                partieTerminee = false;  // S'il reste des allumettes, la partie n'est pas terminée
            }
        }
        return partieTerminee;  // Toutes les lignes sont vides, la partie est terminée
    }

    // -----  Lancement des tests -----

    /**
     * Lance les tests unitaires du jeu.
     */
    void lanceTest() {
        // Tests des fonctions principales du jeu
        testCompareTableaux();
        testCreateTabJeux();
        testVerifLigne();
        testPartieTerminee();
        testStrategieGagnante();
        testRetirerAllumettes();
        testCalculXor();
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
     * Teste la méthode createTabJeux()
     */
    void testCreateTabJeux() {
        System.out.println();
        System.out.println("*** testCreateTabJeux()");
        testCasCreateTabJeux(3, new String[]{"|", "|||", "|||||"});  // Tableau avec 3 lignes
        testCasCreateTabJeux(1, new String[]{"|"});  // Tableau avec 1 ligne
        testCasCreateTabJeux(0, new String[]{});  // Tableau vide
        testCasCreateTabJeux(5, new String[]{"|", "|||", "|||||", "|||||||", "|||||||||"});  // Tableau avec 5 lignes
    }

    /**
     * Teste un appel de la méthode createTabJeux
     * @param ligne nombre de lignes du tableau
     * @param result tableau attendu
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

    /**
     * Teste la méthode verifLigne()
     */
    void testVerifLigne() {
        System.out.println();
        System.out.println("*** testVerifLigne()");
        testCasVerifLigne(1, 2, 5, true);   // Ligne hors des bornes inférieures
        testCasVerifLigne(3, 2, 5, false);  // Ligne dans les bornes
        testCasVerifLigne(5, 2, 5, false);  // Ligne égale à la borne supérieure
        testCasVerifLigne(6, 2, 5, true);   // Ligne hors des bornes supérieures
        testCasVerifLigne(2, 2, 5, false);  // Ligne égale à la borne inférieure
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
            System.out.println("  :OK");
        } else {
            System.out.println("  :ERREUR");
        }
    }

    /**
     * Teste un appel de la méthode verifLigne
     * @param ligne ligne à vérifier
     * @param a borne inférieure
     * @param b borne supérieure
     * @param result résultat attendu
     */
    void testCasVerifLigne(int ligne, int a, int b, boolean result) {
        System.out.print("verifLigne(" + ligne + ", " + a + ", " + b + ") \t= " + result + "\t:");
        boolean test = verifLigne(ligne, a, b);
        if (test == result) {
            System.out.println("OK");
        } else {
            System.out.println("ERREUR");
        }
    }

    /**
     * Teste la méthode getXor()
     */
    void testCalculXor() {
        System.out.println();
        System.out.println("*** testCalculXor()");
        testCasCalculXor(new String[]{"|", "|||", "|||||"}, 7);  // XOR de 1, 3 et 5 = 7
        testCasCalculXor(new String[]{"|", "|", "|"}, 1);  // XOR de 1, 1 et 1 = 1
        testCasCalculXor(new String[]{"|||", "|||", "|||"}, 3);  // XOR de 3, 3 et 3 = 0
        testCasCalculXor(new String[]{""}, 0);  // XOR d'une ligne vide = 0
        testCasCalculXor(new String[]{"", "|", "|||"}, 2);  // XOR de 0, 1 et 3 = 2
    }

    /**
     * Teste un cas de la méthode getXor
     * @param tabJeux tableau de jeux
     * @param result résultat attendu
     */
    void testCasCalculXor(String[] tabJeux, int result) {
        System.out.print("getXor(");
        afficheTest(tabJeux);
        System.out.print(") \t= " + result + "\t:");

        int test = calculXor(tabJeux);
        if (test == result) {
            System.out.println("OK");
        } else {
            System.out.println("ERREUR");
        }
    }

    /**
     * Méthode utilitaire pour afficher un tableau de chaînes
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

}