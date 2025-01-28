/**
 * Ce programme permet de jouer une partie de morpion
 * @author N.LESCOP
 */
class Morpion {

    void principal() {
        jouer();
    }
    /**
     * Affiche le plateau de jeu
     * @param plateau
     */
    void affichePlateau(char[][] plateau) {
        System.out.print("    ");
        for (int h = 0; h < plateau.length; h++) {
            System.out.print(h + "   ");
        }
        System.out.println();
        for (int i = 0; i < plateau.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < plateau[i].length; j++) {
                System.out.print("| " + plateau[i][j] + " ");
            }
            System.out.println("|");
        }
    }
    /**
     * Creer un plateau de jeu
     * @param lg
     * @return plateau
     */
    char[][] creerPlateau(int lg) {
        char[][] plateau = new char[lg][lg];
        for (int i = 0; i < lg; i++) {
            for (int j = 0; j < lg; j++) {
                plateau[i][j] = ' ';
            }
        }
        return plateau;
    }
    /**
     * Ajoute un pion sur le plateau
     * @param plateau
     * @param joueur
     */
    void ajoutePion(char[][] plateau, char joueur) {
        boolean valide = false;
        while (!valide) {
            int ligne = SimpleInput.getInt("Veuillez entrer le numero de ligne : ");
            int colonne = SimpleInput.getInt("Veuillez entrer le numero de colonne : ");
            if (ligne >= 0 && ligne < plateau.length && colonne >= 0 && colonne < plateau.length) {
                if (plateau[ligne][colonne] == ' ') {
                    plateau[ligne][colonne] = joueur;
                    valide = true;
                } else {
                    System.out.println("Cette case est deja occupee.");
                }
            } else {
                System.out.println("Coordonnees non valides.");
            }
        }
    }

    /**
     * Verifie si le plateau est rempli
     * @param plateau
     * @return
     */
    boolean estRempli(char[][] plateau) {
        boolean resultat = true;
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau[i].length; j++) {
                if (plateau[i][j] == ' ') {
                    resultat = false;
                }
            }
        }
        return resultat;

    }

    /**
     * Verifie si le plateau est aligne horizontalement
     * @param plateau
     * @return
     */
    boolean alignHorizontal(char[][] plateau) {
        boolean resultat = false;
        for (int i = 0; i < plateau.length; i++) {
            if (plateau[i][0] != ' ' && plateau[i][0] == plateau[i][1] && plateau[i][1] == plateau[i][2]) {
                resultat = true;
            }
        }
        return resultat;
    }

    /**
     * Change le joueur courant
     * @param joueurInitial un caractère représentant le joueur : X ou O
     * @return si le joueur ’X’ est en parametre alors renvoie ’O’
     * sinon renvoie ’X’
     */
    char changeJoueur(char joueurInitial) {
        if (joueurInitial == 'X') {
            return 'O';
        } else {
            return 'X';
        }
    }

    /**
     * Joue une partie de morpion
     */
    void jouer() {
        int taille = SimpleInput.getInt("Veuillez entrer la taille du plateau : ");
        char[][] morpion = creerPlateau(taille);
        char joueur = 'X';

        while (!estRempli(morpion) && !alignHorizontal(morpion)) {
            affichePlateau(morpion);
            ajoutePion(morpion, joueur);
            joueur = changeJoueur(joueur);
        }

        affichePlateau(morpion);

        if (alignHorizontal(morpion)) {
            joueur = changeJoueur(joueur);
            System.out.println("Le joueur " + joueur + " a gagne !");
        } else {
            System.out.println("Match nul !");
        }
    }
}
