/**
 * Programme effectuant des operations elementaires sur un ou plusieurs tableaux d'entiers.
 *
 * @author N.LESCOP - novembre 2024
 * @version 1.1.0
 */
public class SimplesTableau {
	/** Codes ANSI pour la couleur rouge */
	String ROUGE = "\033[31m";
	/** Codes ANSI pour la couleur verte */
	String VERT = "\033[32m";
	/** Codes ANSI pour la couleur bleu */
	String BLEU = "\033[34m";
	/** Codes ANSI pour la couleur jaune */
	String SUPPR = "\033[0m";

	/**
	 * point d’entree de l’execution
	 */
	void principal() {
		testVerifTab();
		testAfficheTab();;
		testEgalite();
		testremplirAleatoire();
		testTirerAleatoire();
		testCopier();
		testleMax();
		testInverse();
		testEchange();
		testMelange();
		testDecalerGauche();
		testSupprimerUneValeur();
		testInclusion();
		testRemplirToutesDiff();
	}

	/**
	 * Cette methode test si le tableau est valide,
	 * il n'est pas valide lorsque celui-ci est inexistant ou si le
	 * nombre d'elements qu'il contiendra est incompatible avec sa taille.
	 *
	 * @param tab le tableau a verifier
	 * @param nbElem le nombre d'elements du tableau
	 * @return vrai si le tableau est valide, faux sinon
	 */
	boolean verifTab(int tab[], int nbElem) {
		// Initialisation de la variable de retour
		boolean ret = false;
		//test si le tableau est valide
		if (tab != null) {
			// Test si le nombre d'elements est correct
			if ((nbElem <= tab.length) && (nbElem > 0)) {
				ret = true;

			} else {
				System.err.print(ROUGE + "(verifTab " + "Erreur : nb ELem incorrect)"+ SUPPR + "\t");
			}
		} else {
			System.err.print(ROUGE + "(verifTab " + "Erreur : tableau inexistant)" + SUPPR + "\t");
		}
		return ret;
	}

	/**
	 * Cette methode test differentes situations pour la methode verifTab.
	 */
	void testVerifTab() {
		int[] tab;
		int nbElem;
		System.out.println(BLEU + "***testVerifTab***" + SUPPR);
		// Cas normal : un tableau avec des entiers
		tab = new int[4];
		nbElem = 4;
		System.out.print("Cas normal : un tableau avec des entiers : ");
		testCasVerifTab(tab, nbElem, true);
		System.out.println();
		// Cas normal : un tableau avec des entiers mais avec un nombre nombre d'elements infèrieur au nombre d'elements reels
		System.out.print("Cas normal : un tableau avec des entiers mais avec un nombre nombre d'elements infèrieur au nombre d'elements reels : ");
		testCasVerifTab(new int[]{1, 2, 3, 4}, 3, true);
		System.out.println();
		// Cas limite : un tableau avec un entier
		System.out.print("Cas limite : un tableau avec un entier : ");
		testCasVerifTab(new int[]{1}, 1, true);
		System.out.println();
		// Cas limite : un tableau avec des elements egaux
		System.out.print("Cas limite : un tableau avec des elements egaux : ");
		testCasVerifTab(new int[]{1, 1, 1, 1}, 4, true);
		System.out.println();
		// Cas d'erreur : un tableau vide
		System.out.print("Cas d'erreur : un tableau vide : ");
		testCasVerifTab(new int[]{}, 0, false);
		System.out.println();
		// Cas d'erreur : un tableau avec des entiers mais avec un nombre nombre d'elements supèrieur au nombre d'elements reels
		System.out.print("Cas d'erreur : un tableau avec des entiers mais avec un nombre nombre d'elements supèrieur au nombre d'elements reels : ");
		testCasVerifTab(new int[]{1, 2, 3, 4}, 6, false);
		System.out.println();
		// Cas d'erreur : un tableau avec des entiers mais avec un nombre d'elements négatif
		System.out.print("Cas d'erreur : un tableau avec des entiers mais avec un nombre d'elements négatif : ");
		testCasVerifTab(new int[]{1, 2, 3, 4}, -1, false);
		System.out.println();
		// Cas d'erreur : un tableau null
		System.out.print("Cas d'erreur : un tableau null : ");
		testCasVerifTab(null, 0, false);
		System.out.println();
	}

	/**
	 * Cette methode test si le tableau affiche OK si le tableau est valide et ERREUR sinon.
	 *
	 * @param tab le tableau a verifier
	 * @param nbElem le nombre d'elements du tableau
	 * @param rep reponse attendu
	 */
	void testCasVerifTab(int[] tab, int nbElem, boolean rep) {
		// Appel de la méthode verifTab
		boolean ok;
		ok = verifTab(tab, nbElem);

		if (ok == rep) {
			System.out.print("\t" + VERT + "OK" + SUPPR);
			System.out.println();

		}else{
			System.err.print("\t" + ROUGE + "ERREUR" + SUPPR);
		}
	}

	// ------------------------------ afficherTab ------------------------------

	/**
	 * Cette methode affiche les elements d'un tableau.
	 *
	 * @param leTab  tableau d'entiers
	 * @param nbElem nombre d'elements du tableau
	 */
	void afficherTab(int leTab[], int nbElem) {
		boolean ok = verifTab(leTab, nbElem);
		if (ok){
			System.out.print("{");
			// Parcours du tableau
			for (int i = 0; i < nbElem; i++) {
				System.out.print(leTab[i]);
				// Affiche une virgule si l'indice est inferieur au nombre d'elements - 1
				if (i < nbElem - 1) {
					System.out.print(", ");
				}
			}
			System.out.print("}");
		}else{
			System.err.print("(afficherTab : Le tableau n'est pas valide) ");
		}
	}

	/**
	 * Cette methode test differentes situations pour la methode afficherTab.
	 */
	void testAfficheTab() {
		System.out.println();
		System.out.println(BLEU + "***testAfficheTab***" + SUPPR);
		System.out.println("Cas normal : un tableau avec des entiers : ");
		testCasAfficheTab(new int[]{1, 2, 3, 4}, 4);
		System.out.println();
		System.out.println("Cas normal : un tableau avec des entiers mais avec un nombre nombre d'elements infèrieur au nombre d'elements reels : ");
		testCasAfficheTab(new int[]{-1, 2, 0, 1, 5}, 5);
		System.out.println();
		System.out.println("Cas limite : un tableau avec un entier : ");
		testCasAfficheTab(new int[]{1}, 1);
		System.out.println();
		System.out.println("Cas d'erreur : un tableau vide : ");
		testCasAfficheTab(new int[]{}, 0);
		System.out.println();
	}

	/**
	 * Cette methode test si le tableau est valide, affiche OK si le tableau est valide et ERREUR sinon.
	 *
	 * @param leTab  tableau d'entiers
	 * @param nbElem nombre d'elements du tableau
	 */
	void testCasAfficheTab(int leTab[], int nbElem) {
		// Si le tableau est valide, on l'affiche
		if (leTab.length == nbElem) {
			afficherTab(leTab, nbElem);
			System.out.println("\t" + VERT + "OK" + SUPPR);
		// Si le tableau n'est pas valide, on affiche un message d'erreur
		}else{
			afficherTab(leTab, nbElem);
			System.err.println("\t" + ROUGE + "ERREUR" + SUPPR);
		}
		
	}

	// ------------------------------ egalite ------------------------------

	/**
	 * Cette methode compare deux tableaux d'entiers.
	 *
	 * @param tab1    tableau d'entiers
	 * @param tab2    tableau d'entiers
	 * @param nbElem1 nombre d'elements du tableau 1
	 * @param nbElem2 nombre d'elements du tableau 2
	 * @return vrai si les tableaux sont identiques, faux sinon
	 */
	boolean egalite(int[] tab1, int[] tab2, int nbElem1, int nbElem2) {
		// Initialisation de la variable de retour
		boolean ret = true;
		// Test si les tableaux sont valides
		boolean ok1 = verifTab(tab1, nbElem1);
		boolean ok2 = verifTab(tab2, nbElem2);
		// Verfie si les tableaux sont valides
		if (ok1 && ok2) {
			// Test si les tableaux sont identiques
			if (nbElem1 != nbElem2) {
				ret = false;

			} else {
				// Parcours des tableaux
				for (int i = 0; i < nbElem1; i++) {
					// Test si l'indice est superieur à la taille des tableaux
					if (i >= tab1.length || i >= tab2.length) {
						ret = false;
					}
					// Verifie si la premiere valeur est differente de la deuxieme
					if (tab1[i] != tab2[i]) {
						ret = false;
					}
				}
			}
		}else{
			System.err.print(": L'un des tableaux n'est pas valide ou les deux tableaux ne sont pas valides");
			ret = false;

		}
		return ret;
	}

	/**
	 * Cette methode test differentes situations pour la methode egalite.
	 */
	void testEgalite() {
		System.out.println();
		System.out.println(BLEU + "***testEgalite***" + SUPPR);
		// Cas normal : 2 tableaux avec des entiers identiques et de meme taille
		System.out.println("Cas normal : 2 tableaux avec des entiers identiques et de meme taille : ");
		testCasEgalite(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}, 4, 4, true);
		System.out.println();
		// Cas normal : 2 tableaux avec des entiers differents et de meme taille
		System.out.println("Cas normal : 2 tableaux avec des entiers differents et de même taille : ");
		testCasEgalite(new int[]{1, 2, 3, 4}, new int[]{4, 3, 2, 1}, 4, 4, false);
		System.out.println();
		// Cas normal : 2 tableaux avec des entiers identiques mais de tailles differentes
		System.out.println("Cas normal : 2 tableaux avec des entiers identiques mais de tailles differentes : ");
		testCasEgalite(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3}, 4, 3, false);
		System.out.println();
		// Cas normal : 2 tableaux de grande taille avec des entiers identiques
		System.out.println("Cas normal : 2 tableaux de grande taille avec des entiers identiques : ");
		testCasEgalite(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10, 10, true);
		System.out.println();
		// Cas normal : 2 tableaux de grande taille avec des entiers differents
		System.out.println("Cas normal : 2 tableaux de grande taille avec des entiers différents : ");
		testCasEgalite(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, 10, 10, false);
		System.out.println();
		// Cas normal : 2 tableaux identiques avec des valeurs négatives
		System.out.println("Cas normal : 2 tableaux identiques avec des valeurs négatives : ");
		testCasEgalite(new int[]{-1, -2, -3, -4}, new int[]{-1, -2, -3, -4}, 4, 4, true);
		System.out.println();
		// Cas normal : 2 tableaux identiques avec des valeurs nulles et positives
		System.out.println("Cas normal : 2 tableaux identiques avec des valeurs nulles et positives : ");
		testCasEgalite(new int[]{0, 1, 2, 3}, new int[]{0, 1, 2, 3}, 4, 4, true);
		System.out.println();
		// Cas limite : 1 tableau avec des valeurs positives et un tableau vide
		System.out.println("Cas limite : 1 tableau avec des valeurs positives et un tableau vide : ");
		testCasEgalite(new int[]{1, 2, 3, 4}, new int[]{}, 4, 0, false);
		System.out.println();
		// Cas limite : 2 tableaux avec un seul entier identique
		System.out.println("Cas limite : 2 tableaux avec un seul entier identique : ");
		testCasEgalite(new int[]{1}, new int[]{1}, 1, 1, true);
		System.out.println();
		// Cas d'erreur : 2 tableaux vides
		System.out.println("Cas d'erreur : 2 tableaux vides : ");
		testCasEgalite(new int[]{}, new int[]{}, 0, 0, false);
		System.out.println();
		// Cas d'erreur : premier tableau null
		System.out.println("Cas d'erreur : premier tableau null : ");
		testCasEgalite(null, new int[]{1, 2, 3, 4}, 0, 4, false);
		System.out.println();
		// Cas d'erreur : deuxième tableau null
		System.out.println("Cas d'erreur : deuxième tableau null : ");
		testCasEgalite(new int[]{1, 2, 3, 4}, null, 4, 0, false);
		System.out.println();
		// Cas d'erreur : les deux tableaux null
		System.out.println("Cas d'erreur : les deux tableaux null : ");
		testCasEgalite(null, null, 0, 0, false);
		System.out.println();
	}

	/**
	 * Cette methode test si le tableau est valide, affiche OK si le tableau est valide et ERREUR sinon.
	 *
	 * @param tab1    tableau d'entiers
	 * @param tab2    tableau d'entiers
	 * @param nbElem1 nombre d'elements du tableau 1
	 * @param nbElem2 nombre d'elements du tableau 2
	 * @param rep     reponse attendu
	 */
	void testCasEgalite(int[] tab1, int[] tab2, int nbElem1, int nbElem2, boolean rep) {
		// Appel de la méthode egalite
		boolean ok;
		ok = egalite(tab1, tab2, nbElem1, nbElem2);
		// Vérification si le tableau n'est pas null et si le nombre d'elements 1 est superieur à la taille du premier tableau
		if (ok == true && rep == true) {
			afficherTab(tab1, nbElem1);
			System.out.print("\t");
			afficherTab(tab2, nbElem2);
			System.out.println("\t" + VERT + "OK" + SUPPR);
		// Si les tableaux ne sont pas identiques, on affiche un message d'erreur
		} else if (ok == false && rep == false){
			System.out.print(ROUGE + " (Les 2 tableaux ne correspondent pas)" + SUPPR);
			System.out.println(" :" + "\t" + VERT + "OK" + SUPPR);

		}else{
			System.err.println("\t" + ROUGE + "ERREUR" + SUPPR);
		}
	}

	// ------------------------------ remplirAleatoire ------------------------------

	/**
	 * Cette methode remplit aléatoirement un tableau de nbElem valeurs comprises entre min et max
	 *
	 * @param leTab un tableau d'entiers
	 * @param nbElem le nombre d'elements du tableau
	 * @param min la valeur minimale
	 * @param max la valeur maximale
	 */
	void remplirAleatoire(int[] leTab, int nbElem, int min, int max) {
		// Appel de la méthode verifTab
		boolean ok = verifTab(leTab, nbElem);
		// Remplissage du tableau
		if (min <= max && min > 0) {
			// Si le tableau est valide, on le remplit
			if (ok == true) {
				for (int i = 0; i < nbElem; i++) {
					leTab[i] = tirerAleatoire(min, max);
				}
			// Si le tableau n'est pas valide, on affiche un message d'erreur
			} else {
				System.err.print(": L'un des tableaux n'est pas valide ou les deux tableaux ne sont pas valides :");
			}
		// Si min est supérieur à max ou min est négatif, on affiche un message d'erreur
		} else {
			System.err.print(" Le minimum est superieur au maximum ou le minimum est inferieur à 0 :");
		}
	}

	/**
	 * Cette methode test differentes situations pour la methode remplirAleatoire.
	 */
	void testremplirAleatoire() {
		System.out.println();
		System.out.println(BLEU + "***testremplirAleatoire***" + SUPPR);
		// Cas normal : 1 tableau avec des entiers et des valeurs min/max valides
		System.out.println("Cas normal : 1 tableau avec des entiers, valeurs aléatoires entre 1 et 10 : ");
		testCasremplirAleatoire(new int[]{0, 0, 0, 0}, 4, 1, 10);
		System.out.println();
		// Cas normal : les valeurs min et max couvrent un grand intervalle
		System.out.println("Cas normal : valeurs aléatoires entre 1 et 1000 : ");
		testCasremplirAleatoire(new int[]{0, 0, 0, 0, 0, 0}, 6, 1, 1000);
		System.out.println();
		// Cas limite : `min` et `max` sont égaux et différents de zéro
		System.out.println("Cas limite : valeurs aléatoires entre 7 et 7 : ");
		testCasremplirAleatoire(new int[]{0, 0, 0, 0}, 4, 7, 7); // Valeur attendue : chaque élément devrait être 7
		System.out.println();
		// Cas limite : tableau de taille 1
		System.out.println("Cas limite : tableau de taille 1, valeurs aléatoires entre 5 et 5 (même valeur min et max) : ");
		testCasremplirAleatoire(new int[]{0}, 1, 5, 5); // Valeur attendue : chaque élément devrait être 5
		System.out.println();
		// Cas d'erreur : tableau vide
		System.out.println("Cas d'erreur : tableau vide : ");
		testCasremplirAleatoire(new int[]{}, 0, 1, 10);
		System.out.println();
		// Cas d'erreur : min supérieur à max
		System.out.println("Cas d'erreur : min > max : ");
		testCasremplirAleatoire(new int[]{0, 0, 0, 0}, 4, 10, 1); // Doit afficher une erreur
		System.out.println();
		// Cas d'erreur : min est négatif
		System.out.println("Cas d'erreur : min négatif : ");
		testCasremplirAleatoire(new int[]{0, 0, 0, 0}, 4, -5, 10); // Doit afficher une erreur
		System.out.println();
		// Cas d'erreur : tableau null
		System.out.println("Cas d'erreur : tableau null : ");
		testCasremplirAleatoire(null, 4, 1, 10); // Doit afficher une erreur
		System.out.println();
		// Cas d'erreur : nbElem est supérieur à la taille du tableau
		System.out.println("Cas d'erreur : nbElem supérieur à la taille du tableau : ");
		testCasremplirAleatoire(new int[]{0, 0, 0}, 5, 1, 10); // Doit afficher une erreur
		System.out.println();
	}

	/**
	 * Cette methode test si le tableau est valide, affiche OK si le tableau est valide et ERREUR sinon.
	 *
	 * @param tab le tableau a verifier
	 * @param nbElem le nombre d'elements du tableau
	 * @param min la valeur minimale
	 * @param max la valeur maximale
	 */
	void testCasremplirAleatoire(int[] tab, int nbElem, int min, int max) {
		System.out.print("Avant : ");
		afficherTab(tab, nbElem);
		remplirAleatoire(tab, nbElem, min, max);
		System.out.print(" Après : ");
		afficherTab(tab, nbElem);
		System.out.println();
	}

	/**
	 * Cette methode tire un entier aléatoire entre min et max
	 *
	 * @param min la valeur minimale
	 * @param max la valeur maximale
	 * @return un entier aléatoire
	 */
	int tirerAleatoire(int min, int max) {
		// Initialisation de la variable de retour
		int entierAleatoire = 0;
		// Si min est inférieur ou égal à max et min est supérieur à 0, on tire un entier aléatoire
		if (min <= max && min >= 0) {
			entierAleatoire = (int) (Math.random() * (max - min + 1) + min);
			// Si min est supérieur à max ou min est négatif, on affiche un message d'erreur
		} else {
			System.err.println("Erreur : min > max ou min < 0");
			entierAleatoire += -1;
		}
		return entierAleatoire;
	}

	/**
	 * Cette methode test differentes situations pour la methode tirerAleatoire.
	 */
	void testTirerAleatoire() {
		System.out.println();
		System.out.println(BLEU + "***testTirerAleatoire***" + SUPPR);
		// Cas normal : valeurs aléatoires entre 1 et 10
		System.out.println("Cas normal : valeurs aléatoires entre 1 et 10");
		testCasTirerAleatoire(1, 10);
		System.out.println();
		// Cas normal : valeurs aléatoires entre 1 et 1000
		System.out.println("Cas normal : valeurs aléatoires entre 1 et 1000");
		testCasTirerAleatoire(1, 1000);
		System.out.println();
		// Cas limite : valeurs aléatoires entre 7 et 7
		System.out.println("Cas limite : valeurs aléatoires entre 7 et 7");
		testCasTirerAleatoire(7, 7); // Valeur attendue : 7
		System.out.println();
		// Cas d'erreur : min supérieur à max
		System.out.println("Cas d'erreur : min > max");
		testCasTirerAleatoire(10, 1); // Doit afficher une erreur
		System.out.println();
		// Cas d'erreur : min est négatif
		System.out.println("Cas d'erreur : min négatif");
		testCasTirerAleatoire(-5, 10); // Doit afficher une erreur
		System.out.println();
	}

	/**
	 * Cette methode test si le tableau est valide, affiche OK si le tableau est valide et ERREUR sinon.
	 *
	 * @param min la valeur minimale
	 * @param max la valeur maximale
	 */
	void testCasTirerAleatoire(int min, int max) {
		// Si min est supérieur à max, on affiche un message d'erreur
		if (min > max) {
			System.out.print("minimum : " + min + "\t" + "maximum : " + max);
			System.err.println(ROUGE + " ERREUR : le min est supérieur au max" + SUPPR + "\t" + VERT + "OK" + SUPPR);
			// Si min est négatif, on affiche un message d'erreur
		} else if (min < 0) {
			System.out.print("minimum : " + min + "\t" + "maximum : " + max);
			System.err.println(ROUGE + " ERREUR : le min est supérieur au max" + SUPPR + "\t" + VERT + "OK" + SUPPR);
			// Si aucune erreur, on appelle tirerAleatoire et affiche le minimum et le maximum
		} else {
			tirerAleatoire(min, max);
			System.out.print("minimum : " + min + "\t" + "maximum : " + max);
			System.out.println(" :" + "\t" + VERT + "OK" + SUPPR);
		}
	}

	// ------------------------------ copier ------------------------------

	/**
	 * Cette methode copie les nbElem premiers elements du tableau tabToCopy dans un nouveau tableau.
	 *
	 * @param tabToCopy le tableau a copier
	 * @param nbElem le nombre d'elements a copier
	 * @return le tableau copie
	 */
	int[] copier(int[] tabToCopy, int nbElem) {
			// Appel de la méthode verifTab
			boolean ok = verifTab(tabToCopy, nbElem);
			// Initialisation du tableau de copie
			int[] tabCopy = new int[0];
			// Si le tableau est valide, on copie les elements
			if (ok){
				tabCopy = new int [nbElem];
				// Copie des elements
				for (int i = 0; i < nbElem; i++) {
					tabCopy[i] = tabToCopy[i];
				}
			}
			// Retourne le tableau copié
			return tabCopy;
	}

	/**
	 * Cette methode test differentes situations pour la methode copier.
	 */
	void testCopier() {
		System.out.println();
		System.out.println(BLEU + "***testCopier***" + SUPPR);
		// Cas normal : 1 tableau avec des entiers
		System.out.println("Cas normal : 1 tableau avec des entiers : ");
		testCasCopier(new int[]{1, 2, 3, 4}, 4);
		System.out.println();
		// Cas normal : 1 tableau avec des entiers mais avec un nombre nombre d'elements infèrieur au nombre d'elements reels
		System.out.println("Cas normal : 1 tableau avec des entiers mais avec un nombre nombre d'elements infèrieur au nombre d'elements reels : ");
		testCasCopier(new int[]{1, 2, 3, 4}, 3);
		System.out.println();
		// Cas limite : 1 tableau avec un entier
		System.out.println("Cas limite : 1 tableau avec un entier : ");
		testCasCopier(new int[]{1}, 1);
		System.out.println();
		// Cas limite : 1 tableau avec des elements egaux
		System.out.println("Cas limite : 1 tableau avec des elements egaux : ");
		testCasCopier(new int[]{1, 1, 1, 1}, 4);
		System.out.println();
		// Cas d'erreur : 1 tableau vide
		System.out.println("Cas d'erreur : 1 tableau vide : ");
		testCasCopier(new int[]{}, 0);
		System.out.println();
		// Cas d'erreur : 1 tableau avec des entiers mais avec un nombre nombre d'elements supèrieur au nombre d'elements reels
		System.out.println("Cas d'erreur : 1 tableau avec des entiers mais avec un nombre nombre d'elements supèrieur au nombre d'elements reels : ");
		testCasCopier(new int[]{1, 2, 3, 4}, 6);
		System.out.println();
		// Cas d'erreur : 1 tableau avec des entiers mais avec un nombre d'elements négatif
		System.out.println("Cas d'erreur : 1 tableau avec des entiers mais avec un nombre d'elements négatif : ");
		testCasCopier(new int[]{1, 2, 3, 4}, -1);
		System.out.println();
		// Cas d'erreur : 1 tableau null
		System.out.println("Cas d'erreur : 1 tableau null : ");
		testCasCopier(null, 0);
		System.out.println();
	}

	/**
	 * Cette methode test si le tableau est valide, affiche OK si le tableau est valide et ERREUR sinon.
	 *
	 * @param tabToCopy le tableau à copier
	 * @param nbElem    le nombre d'elements à copier
	 */
	void testCasCopier(int[] tabToCopy, int nbElem) {
		// Si le tableau est valide, on copie les elements
		System.out.print("Avant : ");
		afficherTab(tabToCopy, nbElem);
		copier(tabToCopy, nbElem);
		System.out.print(" Après : ");
		afficherTab(tabToCopy, nbElem);
		System.out.print("\t" + VERT + "OK" + SUPPR);
		System.out.println();
	}

	// ------------------------------ leMax ------------------------------

	/**
	 * Cette methode retourne la valeur maximale d'un tableau.
	 *
	 * @param leTab  le tableau d'entiers
	 * @param nbElem le nombre d'elements du tableau
	 * @return la valeur maximale
	 */
	int leMax(int[] leTab, int nbElem) {
		boolean ok = verifTab(leTab, nbElem);
		// Initialisation de la variable de retour
		int valMax = 0;
		// Si le tableau est valide, on recherche la valeur maximale
		if (ok){
			// Recherche de la valeur maximale
			for (int i = 0; i < nbElem; i++) {
				// Si la valeur est superieur à la valeur maximale, on la valeur du tableau devient la valeur maximale
				if (leTab[i] > valMax) {
					valMax = leTab[i];
				}
			}
		}
		// Retourne la valeur maximale
		return valMax;
	}

	/**
	 * Cette methode test differentes situations pour la methode leMax.
	 */
	void testleMax() {
		System.out.println();
		System.out.println();
		System.out.println(BLEU + "***testleMax***" + SUPPR);
		// Cas normal : 1 tableau avec des entiers
		System.out.println("Cas normal : 1 tableau avec des entiers : ");
		testCasleMax(new int[]{1, 2, 3, 4}, 4, 4);
		System.out.println();
		// Cas normal : 1 tableau avec des entiers poistifs et négatifs
		System.out.println("Cas normal : 1 tableau avec des entiers poistifs et négatifs : ");
		testCasleMax(new int[]{1, -2, 3, -4}, 4, 3);
		System.out.println();
		// Cas limite : 1 tableau avec des entiers mais avec un nombre nombre d'elements infèrieur au nombre d'elements reels
		System.out.println("Cas limite : 1 tableau avec des entiers mais avec un nombre nombre d'elements infèrieur au nombre d'elements reels : ");
		testCasleMax(new int[]{1, 2, 3, 4}, 3, 3);
		System.out.println();
		// Cas limite : 1 tableau avec un entier
		System.out.println("Cas limite : 1 tableau avec un entier : ");
		testCasleMax(new int[]{1}, 1, 1);
		System.out.println();
		// Cas limite : 1 tableau avec des elements egaux
		System.out.println("Cas limite : 1 tableau avec des elements egaux : ");
		testCasleMax(new int[]{1, 1, 1, 1}, 4, 1);
		System.out.println();
		// Cas d'erreur : 1 tableau vide
		System.out.println("Cas d'erreur : 1 tableau vide : ");
		testCasleMax(new int[]{}, 0, 0);
		System.out.println();
		// Cas d'erreur : 1 tableau avec des entiers mais avec un nombre nombre d'elements supèrieur au nombre d'elements reels
		System.out.println("Cas d'erreur : 1 tableau avec des entiers mais avec un nombre nombre d'elements supèrieur au nombre d'elements reels : ");
		testCasleMax(new int[]{1, 2, 3, 4}, 6, 0);
		System.out.println();
		// Cas d'erreur : 1 tableau avec des entiers mais avec un nombre d'elements négatif
		System.out.println("Cas d'erreur : 1 tableau avec des entiers mais avec un nombre d'elements négatif : ");
		testCasleMax(new int[]{1, 2, 3, 4}, -1, 0);
		System.out.println();
		// Cas d'erreur : 1 tableau null
		System.out.println("Cas d'erreur : 1 tableau null : ");
		testCasleMax(null, 0, 0);
		System.out.println();
	}

	/**
	 * Cette methode test si le tableau est valide, affiche OK si le tableau est valide et ERREUR sinon.
	 *
	 * @param leTab le tableau à copier
	 * @param nbElem le nombre d'elements à copier
	 * @param resAttendu le resultat attendu
	 */
	void testCasleMax(int[] leTab, int nbElem, int resAttendu) {
		// Appel de la méthode leMax
		int ok = leMax(leTab, nbElem);
		// Si la variable ok correspond au resultat attendu, on affiche OK
		if (ok == resAttendu) {
			System.out.print(" Tableau avant : ");
			afficherTab(leTab, nbElem);
			System.out.print(" Tableau après : ");
			afficherTab(leTab, nbElem);
			System.out.print(" Resultat attendu : " + resAttendu + " : ");
			System.out.println("\t" + VERT + "OK" + SUPPR);
		// Si la variable ok ne correspond pas au resultat attendu, on affiche ERREUR
		} else {
			System.err.println(ROUGE + "ERREUR" + SUPPR);
		}
	}

	// ------------------------------ inverse ------------------------------

	/**
	 * Cette methode renvoie un nouveau tableau qui est l'inverse de celui en paramètre.
	 *
	 * @param leTab  le tableau d'entiers
	 * @param nbElem le nombre d'elements à inverser
	 * @return le tableau inversé
	 */
	int[] inverse(int[] leTab, int nbElem) {
		boolean ok = verifTab(leTab, nbElem);
		// Initialisation du tableau de retour
		int[] newLeTab = new int[0];
		// Si le tableau est valide, on inverse les elements
		if (ok) {
			// Initialisation du tableau de retour
			newLeTab = new int[nbElem];
			// Inversion du tableau
			for (int i = 0; i < nbElem; i++) {
				newLeTab[i] = leTab[nbElem - 1 - i];
			}
		}
		// Retourne le tableau inversé
		return newLeTab;
	}

	/**
	 * Cette methode test differentes situations pour la methode inverse.
	 */
	void testInverse() {
		System.out.println();
		System.out.println(BLEU + "***testInverse***" + SUPPR);
		// Cas normal : 1 tableau avec des entiers
		System.out.println("Cas normal : 1 tableau avec des entiers");
		testCasInverse(new int[]{1, 2, 3, 4}, 4, new int[]{4, 3, 2, 1});
		System.out.println();
		// Cas normal : 1 tableau avec des entiers poistifs et négatifs
		System.out.println("Cas normal : 1 tableau avec des entiers poistifs et négatifs");
		testCasInverse(new int[]{1, -2, 3, -4}, 4, new int[]{-4, 3, -2, 1});
		System.out.println();
		// Cas limite : 1 tableau avec des entiers mais avec un nombre nombre d'elements infèrieur au nombre d'elements reels
		System.out.println("Cas limite : 1 tableau avec des entiers mais avec un nombre nombre d'elements infèrieur au nombre d'elements reels");
		testCasInverse(new int[]{1, 2, 3, 4}, 3, new int[]{3, 2, 1});
		System.out.println();
		// Cas limite : 1 tableau avec un entier
		System.out.println("Cas limite : 1 tableau avec un entier");
		testCasInverse(new int[]{1}, 1, new int[]{1});
		System.out.println();
		// Cas limite : 1 tableau avec des elements egaux
		System.out.println("Cas limite : 1 tableau avec des elements egaux");
		testCasInverse(new int[]{1, 1, 1, 1}, 4, new int[]{1, 1, 1, 1});
		System.out.println();
		// Cas d'erreur : 1 tableau vide
		System.out.println("Cas d'erreur : 1 tableau vide");
		testCasInverse(new int[]{}, 0, new int[]{});
		System.out.println();
		// Cas d'erreur : 1 tableau avec des entiers mais avec un nombre nombre d'elements supèrieur au nombre d'elements reels
		System.out.println("Cas d'erreur : 1 tableau avec des entiers mais avec un nombre nombre d'elements supèrieur au nombre d'elements reels");
		testCasInverse(new int[]{1, 2, 3, 4}, 6, new int[]{});
		System.out.println();
		// Cas d'erreur : 1 tableau avec des entiers mais avec un nombre d'elements négatif
		System.out.println("Cas d'erreur : 1 tableau avec des entiers mais avec un nombre d'elements négatif");
		testCasInverse(new int[]{1, 2, 3, 4}, -1, new int[]{});
		System.out.println();
		// Cas d'erreur : 1 tableau null
		System.out.println("Cas d'erreur : 1 tableau null");
		testCasInverse(null, 0, new int[]{});
		System.out.println();
	}

	/**
	 * Cette methode test si le tableau est valide, affiche OK si le tableau est valide et ERREUR sinon.
	 *
	 * @param leTab le tableau à copier
	 * @param nbElem le nombre d'elements à copier
	 * @param resAttendu le resultat attendu
	 */
	void testCasInverse(int[] leTab, int nbElem, int[] resAttendu) {
		// Appel de la méthode inverse
		int[] ok = inverse(leTab, nbElem);
		// Appel de la méthode egalite
		boolean egaux = egalite(ok, resAttendu, nbElem, nbElem);
		// Si les tableaux sont égaux, on affiche OK
		if (egaux) {
			System.out.print("Tableau avant : ");
			afficherTab(leTab, nbElem);
			System.out.print(" Tableau après inversion : ");
			afficherTab(ok, nbElem);
			System.out.print(" Résultat attendu : ");
			afficherTab(resAttendu, nbElem);
			System.out.println("\t" + VERT + "OK" + SUPPR);
		// Si les tableaux ne sont pas égaux, on affiche une erreur
		}else{
			System.out.print("\t" + "(Erreur : Les tableaux ne sont pas inversibles)");
			System.err.println("\t" + VERT + "OK" + SUPPR);
		}

	}

	// ------------------------------ echange ------------------------------

	/**
	 * Cette methode échange les éléments d'indices ind1 et ind2 dans le tableau leTab.
	 *
	 * @param leTab  le tableau d'entiers
	 * @param nbElem le nombre d'elements du tableau
	 * @param ind1   l'indice du premier élément à échanger
	 * @param ind2   l'indice du deuxième élément à échanger
	 */
	void echange(int[] leTab, int nbElem, int ind1, int ind2) {
		// Appel de la méthode verifTab
		boolean ok = verifTab(leTab, nbElem);
		// Initialisation d'une variable temporaire
		int temp = 0;
		// Si le tableau est valide, on échange les éléments
		if (ok) {
			// Echange des éléments
			temp = leTab[ind1];
			leTab[ind1] = leTab[ind2];
			leTab[ind2] = temp;
		}
	}

	/**
	 * Cette methode test differentes situations pour la methode echange.
	 */
	void testEchange() {
		System.out.println();
		System.out.println(BLEU + "***testEchange***" + SUPPR);
		// Cas normal : 1 tableau avec des entiers
		System.out.println("Cas normal : 1 tableau avec des entiers : ");
		testCasEchange(new int[]{1, 2, 3, 4}, 4, 1, 2, new int[]{1, 3, 2, 4});
		System.out.println();
		// Cas normal : 1 tableau avec des entiers poistifs et négatifs
		System.out.println("Cas normal : 1 tableau avec des entiers poistifs et négatifs : ");
		testCasEchange(new int[]{1, -2, 3, -4}, 4, 1, 2, new int[]{1, 3, -2, -4});
		System.out.println();
		// Cas limite : 1 tableau avec des entiers mais avec un nombre nombre d'elements infèrieur au nombre d'elements reels
		System.out.println("Cas limite : 1 tableau avec des entiers mais avec un nombre nombre d'elements infèrieur au nombre d'elements reels : ");
		testCasEchange(new int[]{1, 2, 3, 4}, 3, 1, 2, new int[]{1, 3, 2});
		System.out.println();
		// Cas limite : 1 tableau avec un entier
		System.out.println("Cas limite : 1 tableau avec un entier : ");
		testCasEchange(new int[]{1}, 1, 0, 0, new int[]{1});
		System.out.println();
		// Cas limite : 1 tableau avec des elements egaux
		System.out.println("Cas limite : 1 tableau avec des elements egaux : ");
		testCasEchange(new int[]{1, 1, 1, 1}, 4, 1, 2, new int[]{1, 1, 1, 1});
		System.out.println();
		// Cas d'erreur : 1 tableau vide
		System.out.println("Cas d'erreur : 1 tableau vide : ");
		testCasEchange(new int[]{}, 0, 0, 0, new int[]{});
		System.out.println();
		// Cas d'erreur : 1 tableau avec des entiers mais avec un nombre nombre d'elements supèrieur au nombre d'elements reels
		System.out.println("Cas d'erreur : 1 tableau avec des entiers mais avec un nombre nombre d'elements supèrieur au nombre d'elements reels : ");
		testCasEchange(new int[]{1, 2, 3, 4}, 6, 1, 2, new int[]{});
		System.out.println();
		// Cas d'erreur : 1 tableau avec des entiers mais avec un nombre d'elements négatif
		System.out.println("Cas d'erreur : 1 tableau avec des entiers mais avec un nombre d'elements négatif : ");
		testCasEchange(new int[]{1, 2, 3, 4}, -1, 1, 2, new int[]{});
		System.out.println();
		// Cas d'erreur : 1 tableau null
		System.out.println("Cas d'erreur : 1 tableau null : ");
		testCasEchange(null, 0, 0, 0, new int[]{});
		System.out.println();
	}

	/**
	 * Cette methode test si le tableau est valide, affiche OK si le tableau est valide et ERREUR sinon.
	 *
	 * @param leTab le tableau à copier
	 * @param nbElem le nombre d'elements à copier
	 * @param ind1 l'indice du premier élément à échanger
	 * @param ind2 l'indice du deuxième élément à échanger
	 * @param resAttendu le resultat attendu
	 */
	void testCasEchange(int[] leTab, int nbElem, int ind1, int ind2, int[] resAttendu) {
		// Appel de la méthode inverse
		int[] copieLeTab = copier(leTab, nbElem);
		// Appel de la méthode echange
		echange(leTab, nbElem, ind1, ind2);
		// Appel de la méthode egalite
		boolean egaux = egalite(leTab, resAttendu, nbElem, nbElem);
		// Si les tableaux sont égaux, on affiche OK
		if (egaux) {
			System.out.print("Tableau avant : ");
			afficherTab(copieLeTab, nbElem);
			System.out.print(" Tableau après échange : ");
			afficherTab(leTab, nbElem);
			System.out.print(" Résultat attendu : ");
			afficherTab(resAttendu, nbElem);
			System.out.println("\t" + VERT + "OK" + SUPPR);
		// Si les tableaux ne sont pas égaux, on affiche une erreur
		}else{
			System.out.print("\t" + "(Erreur : Les tableaux ne sont pas echangeables)");
			System.err.println("\t" + VERT + "OK" + SUPPR);
		}
	}

	// ------------------------------ melange ------------------------------

	/**
	 * Cette methode mélange les éléments d'un tableau avec les methodes tirerAleatoire et echange.
	 *
	 * @param leTab  le tableau d'entiers
	 * @param nbElem le nombre d'elements du tableau
	 * @return le tableau mélangé
	 */
	int[] melange(int[] leTab, int nbElem) {
		// Appel de la méthode verifTab
		boolean ok = verifTab(leTab, nbElem);
		// Initialisation du tableau de retour
		int[] leTabMelange = new int[0];
		// Si le tableau est valide, on mélange les éléments
		if (ok) {
			// Initialisation du tableau de retour
			leTabMelange = new int[nbElem];
			// Copie les éléments de leTab dans leTabMelange jusqu'à nbElem
			for (int i = 0; i < nbElem; i++) {
				leTabMelange[i] = leTab[i];
			}
			// Mélange les éléments du tableau
			for (int i = nbElem - 1; i > 0; i--) {
				// Génère un indice aléatoire j tel que 0 <= indice <= nbElem -1
				int j = tirerAleatoire(0, nbElem - 1);
				// Vérifie que j est valide avant d’échanger
				if (j >= 0 && j < nbElem) {
					echange(leTabMelange, nbElem, i, j);
				}
			}
		}
		// Retourne le tableau mélangé ou inchangé en cas d'erreur
		return leTabMelange;
	}

	/**
	 * Cette methode test differentes situations pour la methode melange.
	 */
	void testMelange() {
		System.out.println();
		System.out.println(BLEU + "***testMelange***" + SUPPR);
		// Cas normal : 1 tableau avec des entiers
		System.out.println("Cas normal : 1 tableau avec des entiers : ");
		testCasMelange(new int[]{1, 5, 8, 4}, 4);
		System.out.println();
		// Cas normal : 1 tableau avec des entiers poistifs et négatifs
		System.out.println("Cas normal : 1 tableau avec des entiers poistifs et négatifs : ");
		testCasMelange(new int[]{1, -2, 3, -4}, 4);
		System.out.println();
		// Cas limite : 1 tableau avec des entiers mais avec un nombre nombre d'elements infèrieur au nombre d'elements reels
		System.out.println("Cas limite : 1 tableau avec des entiers mais avec un nombre nombre d'elements infèrieur au nombre d'elements reels : ");
		testCasMelange(new int[]{1, 2, 3, 4}, 3);
		System.out.println();
		// Cas limite : 1 tableau avec un entier
		System.out.println("Cas limite : 1 tableau avec un entier : ");
		testCasMelange(new int[]{1}, 1);
		System.out.println();
		// Cas limite : 1 tableau avec des elements egaux
		System.out.println("Cas limite : 1 tableau avec des elements egaux : ");
		testCasMelange(new int[]{1, 1, 1, 1}, 4);
		System.out.println();
		// Cas d'erreur : 1 tableau vide
		System.out.println("Cas d'erreur : 1 tableau vide : ");
		testCasMelange(new int[]{}, 0);
		System.out.println();
		// Cas d'erreur : 1 tableau avec des entiers mais avec un nombre nombre d'elements supèrieur au nombre d'elements reels
		System.out.println("Cas d'erreur : 1 tableau avec des entiers mais avec un nombre nombre d'elements supèrieur au nombre d'elements reels : ");
		testCasMelange(new int[]{1, 2, 3, 4}, 6);
		System.out.println();
		// Cas d'erreur : 1 tableau avec des entiers mais avec un nombre d'elements négatif
		System.out.println("Cas d'erreur : 1 tableau avec des entiers mais avec un nombre d'elements négatif : ");
		testCasMelange(new int[]{1, 2, 3, 4}, -1);
		System.out.println();
		// Cas d'erreur : 1 tableau null
		System.out.println("Cas d'erreur : 1 tableau null : ");
		testCasMelange(null, 0);
		System.out.println();
	}

	/**
	 * Cette methode test si le tableau est valide, affiche OK si le tableau est valide et ERREUR sinon.
	 *
	 * @param leTab le tableau à copier
	 * @param nbElem le nombre d'elements à copier
	 */
	void testCasMelange(int[] leTab, int nbElem) {
		// Appel de la méthode melange
		int[] leTabMelange = melange(leTab, nbElem);
		// Appel de la méthode egalite
		boolean ok = false;
		// Initialisation du compteur
		int compteur = 0;
		// Vérifie que le tableau est mélangé
		if (leTabMelange.length == nbElem) {
			for (int i = 0; i < nbElem; i++) {
				for (int j = 0; j < nbElem; j++) {
					if (leTabMelange[i] == leTab[j]) {
						compteur++;
					}
				}
			}
			if (compteur == nbElem) {
				ok = true;
			}
		}
		// Si le tableau est valide, on affiche OK
		if (ok){
			System.out.print("Le tableau avant le melange : ");
			afficherTab(leTab, nbElem);
			System.out.print(" Après : ");
			afficherTab(leTabMelange, nbElem);
			System.out.println("\t" + VERT + "OK" + SUPPR);
		// Si le tableau n'est pas valide, on affiche une erreur
		}else{
			System.out.print("(Erreur : Le tableau n'a pas pu être melangé)");
			System.err.println("\t" + VERT + "OK" + SUPPR);
		}
	}

	// ------------------------------ decalerDroite ------------------------------

	/**
	 * Cette methode décale les éléments d'un tableau vers la droite à partir d'un indice donné.
	 *
	 * @param leTab  le tableau d'entiers
	 * @param nbElem le nombre d'elements du tableau
	 * @param ind    l'indice à partir duquel on décale les éléments
	 */
	void decalerGche(int[] leTab, int nbElem, int ind){
		// Appel de la méthode verifTab
		boolean ok = verifTab(leTab, nbElem);
		// Si le tableau est valide, on décale les éléments
		if (ok) {
			// Si l'indice est valide, on décale les éléments
			if (ind >= 0 && ind <= nbElem - 2) {
				// Décalage des éléments
				for (int i = ind; i < nbElem - 1; i++) {
					leTab[i] = leTab[i + 1];
				}
				leTab[nbElem - 1] = 0;
			}
		}
	}

	/**
	 * Cette methode test differentes situations pour la methode decalerGche.
	 */
	void testDecalerGauche(){
		System.out.println();
		System.out.println(BLEU + "***testDecalerGauche***" + SUPPR);
		// Cas normal : 1 tableau avec des entiers
		System.out.println("Cas normal : 1 tableau avec des entiers : ");
		testCasDecalerGauche(new int[]{1, 2, 3, 4}, 4, 1, new int[]{1, 3, 4, 4});
		System.out.println();
		// Cas normal : 1 tableau avec des entiers poistifs et négatifs
		System.out.println("Cas normal : 1 tableau avec des entiers poistifs et négatifs : ");
		testCasDecalerGauche(new int[]{1, -2, 3, -4}, 4, 2, new int[]{1, -2, -4, -4});
		System.out.println();
		// Cas limite : 1 tableau avec des entiers mais avec un nombre nombre d'elements infèrieur au nombre d'elements reels
		System.out.println("Cas limite : 1 tableau avec des entiers mais avec un nombre nombre d'elements infèrieur au nombre d'elements reels : ");
		testCasDecalerGauche(new int[]{1, 2, 3, 4}, 3, 1, new int[]{1, 3, 4});
		System.out.println();
		// Cas limite : 1 tableau avec un entier
		System.out.println("Cas limite : 1 tableau avec un entier : ");
		testCasDecalerGauche(new int[]{1}, 1, 0, new int[]{1});
		System.out.println();
		// Cas limite : 1 tableau avec des elements egaux
		System.out.println("Cas limite : 1 tableau avec des elements egaux : ");
		testCasDecalerGauche(new int[]{1, 1, 1, 1}, 4, 1, new int[]{1, 1, 1, 1});
		System.out.println();
		// Cas d'erreur : 1 tableau vide
		System.out.println("Cas d'erreur : 1 tableau vide : ");
		testCasDecalerGauche(new int[]{}, 0, 0, new int[]{});
		System.out.println();
		// Cas d'erreur : 1 tableau avec des entiers mais avec un nombre nombre d'elements supèrieur au nombre d'elements reels
		System.out.println("Cas d'erreur : 1 tableau avec des entiers mais avec un nombre nombre d'elements supèrieur au nombre d'elements reels : ");
		testCasDecalerGauche(new int[]{1, 2, 3, 4}, 6, 1, new int[]{});
		System.out.println();
		// Cas d'erreur : 1 tableau avec des entiers mais avec un indice negatif
		System.out.println("Cas d'erreur : 1 tableau avec des entiers mais avec un indice negatif : ");
		testCasDecalerGauche(new int[]{1, 2, 3, 4}, 4, -1, new int[]{0});
		System.out.println();
		// Cas d'erreur : 1 tableau avec des entiers mais avec un nombre d'elements négatif
		System.out.println("Cas d'erreur : 1 tableau avec des entiers mais avec un nombre d'elements négatif : ");
		testCasDecalerGauche(new int[]{1, 2, 3, 4}, -1, 1, new int[]{});
		System.out.println();
		// Cas d'erreur : 1 tableau null
		System.out.println("Cas d'erreur : 1 tableau null : ");
		testCasDecalerGauche(null, 0, 0, new int[]{});
		System.out.println();
	}

	/**
	 * Cette methode test si le tableau est valide, affiche OK si le tableau est valide et ERREUR sinon.
	 *
	 * @param leTab le tableau à copier
	 * @param nbElem le nombre d'elements à copier
	 * @param ind l'indice à partir duquel on décale les éléments
	 * @param resAttendu le resultat attendu
	 */
	void testCasDecalerGauche(int[] leTab, int nbElem, int ind, int[] resAttendu){
		// Appel de la méthode copier
		int[] copieLeTab = copier(leTab, nbElem);
		// Appel de la méthode decalerGche
		decalerGche(leTab, nbElem, ind);
		// Appel de la méthode egalite
		boolean egaux = egalite(leTab, resAttendu, nbElem, nbElem);
		// Si les tableaux sont égaux, on affiche OK
		if (egaux) {
			System.out.print("Avant : ");
			afficherTab(copieLeTab, nbElem);
			System.out.print(" Après : ");
			afficherTab(leTab, nbElem);
			System.out.print(" Résultat attendu : ");
			afficherTab(resAttendu, nbElem);
			System.out.println("\t" + VERT + "OK" + SUPPR);
		// Si les tableaux ne sont pas égaux, on affiche une erreur
		}else{
			System.out.print("(Erreur : Le tableau n'a pas pu être décalé)");
			System.err.println("\t" + VERT + "OK" + SUPPR);
		}
	}

	// ------------------------------ supprimerUneValeur ------------------------------

	/**
	 * Cette methode supprime une valeur donnée dans un tableau et renvoie le nombre d'elements du tableau après suppression.
	 *
	 * @param leTab  le tableau d'entiers
	 * @param nbElem le nombre d'elements du tableau
	 * @param valeur la valeur à supprimer
	 * @return le nombre d'elements du tableau après suppression
	 */
	int supprimerUneValeur(int[] leTab, int nbElem, int valeur){
		// Appel de la méthode verifTab
		boolean ok = verifTab(leTab, nbElem);
		// Si le tableau est valide, on supprime la valeur
		if (ok) {
			// Suppression de la valeur
			for (int i = 0; i < nbElem; i++){
				if (valeur == leTab[i]) {
					decalerGche(leTab, nbElem, i);
					nbElem--;
					i--;
				}
			}
		}
		// Retourne le nombre d'elements du tableau après suppression
		return nbElem;
	}

	/**
	 * Cette methode test differentes situations pour la methode supprimerUneValeur.
	 */
	void testSupprimerUneValeur(){
		System.out.println();
		System.out.println(BLEU + "***testSupprimerUneValeur***" + SUPPR);
		// Cas normal : 1 tableau avec des entiers
		System.out.println("Cas normal : 1 tableau avec des entiers : ");
		testCasSupprimerUneValeur(new int[]{1, 2, 3, 4}, 4, 1, 3);
		System.out.println();
		// Cas normal : 1 tableau avec des entiers poistifs et négatifs
		System.out.println("Cas normal : 1 tableau avec des entiers");
		testCasSupprimerUneValeur(new int[]{1, 2, 3, 4}, 4, 3, 3);
		System.out.println();
		// Cas normal : 1 tableau avec des entiers poistifs et négatifs
		System.out.println("Cas normal : 1 tableau avec des entiers poistifs et négatifs : ");
		testCasSupprimerUneValeur(new int[]{1, -2, 3, -4}, 4, -2, 3);
		System.out.println();
		// Cas limite : 1 tableau avec des entiers mais avec un nombre nombre d'elements infèrieur au nombre d'elements reels
		System.out.println("Cas limite : 1 tableau avec des entiers mais avec un nombre nombre d'elements infèrieur au nombre d'elements reels : ");
		testCasSupprimerUneValeur(new int[]{1, 2, 3, 4}, 3, 1, 2);
		System.out.println();
		// Cas limite : 1 tableau avec un entier
		System.out.println("Cas limite : 1 tableau avec un entier : ");
		testCasSupprimerUneValeur(new int[]{1}, 1, 1, 0);
		System.out.println();
		// Cas limite : 1 tableau avec des elements egaux
		System.out.println("Cas limite : 1 tableau avec des elements egaux : ");
		testCasSupprimerUneValeur(new int[]{1, 1, 1, 1}, 4, 1, 3);
		System.out.println();
		// Cas d'erreur : 1 tableau vide
		System.out.println("Cas d'erreur : 1 tableau vide : ");
		testCasSupprimerUneValeur(new int[]{}, 0, 0, 0);
		System.out.println();
		// Cas d'erreur : 1 tableau avec des entiers mais avec un nombre nombre d'elements supèrieur au nombre d'elements reels
		System.out.println("Cas d'erreur : 1 tableau avec des entiers mais avec un nombre nombre d'elements supèrieur au nombre d'elements reels : ");
		testCasSupprimerUneValeur(new int[]{1, 2, 3, 4}, 6, 1, 0);
		System.out.println();
		// Cas d'erreur : 1 tableau avec des entiers mais avec un nombre d'elements négatif
		System.out.println("Cas d'erreur : 1 tableau avec des entiers mais avec un nombre d'elements négatif : ");
		testCasSupprimerUneValeur(new int[]{1, 2, 3, 4}, -1, 1, 0);
		System.out.println();
		// Cas d'erreur : 1 tableau null
		System.out.println("Cas d'erreur : 1 tableau null : ");
		testCasSupprimerUneValeur(null, 0, 0, 0);
		System.out.println();
	}

	/**
	 * Cette methode test si le tableau est valide, affiche OK si le tableau est valide et ERREUR sinon.
	 *
	 * @param leTab le tableau à copier
	 * @param nbElem le nombre d'elements à copier
	 * @param valeur la valeur à supprimer
	 * @param resAttendu le resultat attendu
	 */
	void testCasSupprimerUneValeur(int[] leTab, int nbElem, int valeur, int resAttendu){
		// Appel de la méthode copier
		int[] tabCopie = copier(leTab, nbElem);
		// Appel de la méthode supprimerUneValeur
		int ok = supprimerUneValeur(leTab, nbElem, valeur);
		// Si le tableau est valide, on affiche OK
		if (ok == resAttendu){
			System.out.print("Avant : ");
			afficherTab(tabCopie, nbElem);
			System.out.print(" Après : ");
			afficherTab(leTab, nbElem);
			System.out.print(" Résultat attendu : ");
			System.out.print(resAttendu);
			System.out.println("\t" + VERT + "OK" + SUPPR);
		// Si le tableau n'est pas valide, on affiche une erreur
		}else{
			System.out.print("(Erreur : Le tableau n'a pas pu être modifié)");
			System.err.println("\t" + VERT + "OK" + SUPPR);
		}
	}

	// ------------------------------ inclusion ------------------------------

	/**
	 * Cette methode vérifie si un tableau est inclus dans un autre tableau.
	 *
	 * @param tab1 le premier tableau d'entiers
	 * @param tab2 le deuxième tableau d'entiers
	 * @param nbElem1 le nombre d'elements du premier tableau
	 * @param nbElem2 le nombre d'elements du deuxième tableau
	 * @return true si le premier tableau est inclus dans le deuxième, false sinon
	 */
	boolean inclusion(int[] tab1, int[] tab2, int nbElem1, int nbElem2){
		// Appel de la méthode verifTab
		boolean ok1 = verifTab(tab1, nbElem1);
		boolean ok2 = verifTab(tab2, nbElem2);
		// Initialisation du compteur
		int compteur = 0;
		// Initialisation de la variable inclus
		boolean inclus = false;
		// Si les tableaux sont valides, on vérifie si le premier tableau est inclus dans le deuxième
		if (ok1 && ok2){
			// Vérifie si le premier tableau est inclus dans le deuxième
			for (int i = 0; i < nbElem1; i++){
				for (int j = 0; j < nbElem2; j++){
					// Si les éléments sont égaux, on incrémente le compteur
					if (tab1[i] == tab2[j]){
						compteur++;
					}
					// Si le compteur est égal au nombre d'elements du premier tableau, le premier tableau est inclus dans le deuxième
					if (compteur == nbElem1){
						inclus = true;
					}
				}
			}
		}
		// Retourne true si le premier tableau est inclus dans le deuxième, false sinon
		return inclus;
	}

	/**
	 * Cette methode test differentes situations pour la methode inclusion.
	 */
	void testInclusion() {
		System.out.println();
		System.out.println(BLEU + "***testInclusion***" + SUPPR);
		// Cas normal : 2 tableaux avec des entiers
		System.out.println("Cas normal : 2 tableaux avec des entiers : ");
		testCasInclusion(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4, 5, 6}, 4, 6, true);
		System.out.println();
		// Cas normal : 2 tableaux avec des entiers poistifs et négatifs
		System.out.println("Cas normal : 2 tableaux avec des entiers poistifs et négatifs : ");
		testCasInclusion(new int[]{1, -2, 3, -4}, new int[]{1, -2, 3, -4, 5, 6}, 4, 6, true);
		System.out.println();
		// Cas limite : 2 tableaux avec des entiers mais avec un nombre nombre d'elements infèrieur au nombre d'elements reels
		System.out.println("Cas limite : 2 tableaux avec des entiers mais avec un nombre nombre d'elements infèrieur au nombre d'elements reels : ");
		testCasInclusion(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4, 5, 6}, 3, 6, true);
		System.out.println();
		// Cas limite : 2 tableaux avec un entier
		System.out.println("Cas limite : 2 tableaux avec un entier : ");
		testCasInclusion(new int[]{1}, new int[]{1}, 1, 1, true);
		System.out.println();
		// Cas limite : 2 tableaux avec des elements egaux
		System.out.println("Cas limite : 2 tableaux avec des elements egaux : ");
		testCasInclusion(new int[]{1, 1, 1, 1}, new int[]{1, 1, 1, 1}, 4, 4, true);
		System.out.println();
		// Cas d'erreur : 1 tableau vide
		System.out.println("Cas d'erreur : 1 tableau vide : ");
		testCasInclusion(new int[]{}, new int[]{1, 2, 3, 4, 5, 6}, 0, 6, false);
		System.out.println();
		// Cas d'erreur : 1 tableau avec des entiers mais avec un nombre nombre d'elements supèrieur au nombre d'elements reels
		System.out.println("Cas d'erreur : 1 tableau avec des entiers mais avec un nombre nombre d'elements supèrieur au nombre d'elements reels : ");
		testCasInclusion(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4, 5, 6}, 6, 6, false);
		System.out.println();
		// Cas d'erreur : 1 tableau avec des entiers mais avec un nombre d'elements négatif
		System.out.println("Cas d'erreur : 1 tableau avec des entiers mais avec un nombre d'elements négatif : ");
		testCasInclusion(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4, 5, 6}, -1, 6, false);
		System.out.println();
		// Cas d'erreur : 1 tableau null
		System.out.println("Cas d'erreur : 1 tableau null : ");
		testCasInclusion(null, new int[]{1, 2, 3, 4, 5, 6}, 0, 6, false);
		System.out.println();
	}

	/**
	 * Cette methode test si le tableau est inclus dans un autre tableau, affiche OK si le tableau est inclus et ERREUR sinon.
	 *
	 * @param tab1 le premier tableau d'entiers
	 * @param tab2 le deuxième tableau d'entiers
	 * @param nbElem1 le nombre d'elements du premier tableau
	 * @param nbElem2 le nombre d'elements du deuxième tableau
	 * @param resAttendu le resultat attendu
	 */
	void testCasInclusion(int[] tab1, int[] tab2, int nbElem1, int nbElem2, boolean resAttendu) {
		// Appel de la méthode inclusion
		boolean ok = inclusion(tab1, tab2, nbElem1, nbElem2);
		// Si le tableau est inclus, on affiche OK
		if (ok == resAttendu) {
			System.out.print("Tableau 1 : ");
			afficherTab(tab1, nbElem1);
			System.out.print(" Tableau 2 : ");
			afficherTab(tab2, nbElem2);
			System.out.print(" Résultat attendu : ");
			System.out.print(resAttendu);
			System.out.println("\t" + VERT + " OK" + SUPPR);
		// Si le tableau n'est pas inclus, on affiche une erreur
		}else{
			System.out.print("(Erreur : le tableau 1 n'est pas inclus dans le tableau 2)");
			System.err.println("\t" + VERT + "OK" + SUPPR);
		}
	}

	// ------------------------------ remplirToutesDiff ------------------------------

	/**
	 * Cette methode remplit un tableau avec des valeurs différentes si les valeurs entrées sont différentes du tableau initial.
	 *
	 * @param leTab  le tableau d'entiers
	 * @param nbElem le nombre d'elements du tableau
	 */
	void remplirToutesDiff(int[] leTab, int nbElem){
		// Appel de la méthode verifTab
		boolean ok = verifTab(leTab, nbElem);
		// Initialisation de la variable presence
		boolean presence;
		// Si le tableau est valide, on remplit le tableau avec des valeurs différentes
		if (ok){
			// Remplissage du tableau avec des valeurs différentes
			for (int i = 0; i < nbElem; i++) {
				int valeur;
				// Demande une valeur différente de 0
				do {
					valeur = SimpleInput.getInt("Donner une valeur differente de 0 : ");
				} while (valeur == 0);

				presence = false;
				// Vérifie que la valeur n'est pas déjà présente dans le tableau
				for (int j = 0; j < nbElem; j++) {
					if (leTab[j] == valeur) {
						presence = true;
					}
				}
				// Si la valeur est déjà présente, on demande une autre valeur
				while (presence) {
					valeur = SimpleInput.getInt("Valeur deja présente dans le tableau, donner une autre valeur : ");
					presence = false;
					// Vérifie que la valeur n'est pas déjà présente dans le tableau
					for (int j = 0; j < nbElem; j++) {
						if (leTab[j] == valeur) {
							presence = true;
						}
					}
				}
				// Remplissage du tableau avec la valeur
				leTab[i] = valeur;
			}
		}
	}

	/**
	 * Cette methode test differentes situations pour la methode remplirToutesDiff.
	 */
	void testRemplirToutesDiff(){
		System.out.println();
		System.out.println(BLEU + "***testRemplirToutesDiff***" + SUPPR);
		// Cas normal : 1 tableau avec des entiers
		System.out.println("Cas normal : 1 tableau avec des entiers : ");
		testCasRemplirToutesDiff(new int[]{1, 2, 3, 4}, 4);
		System.out.println();
		// Cas normal : 1 tableau avec des entiers poistifs et négatifs
		System.out.println("Cas normal : 1 tableau avec des entiers poistifs et négatifs : ");
		testCasRemplirToutesDiff(new int[]{1, -2, 3, -4}, 4);
		System.out.println();
		// Cas limite : 1 tableau avec des entiers mais avec un nombre nombre d'elements infèrieur au nombre d'elements reels
		System.out.println("Cas limite : 1 tableau avec des entiers mais avec un nombre nombre d'elements infèrieur au nombre d'elements reels : ");
		testCasRemplirToutesDiff(new int[]{1, 2, 3, 4}, 3);
		System.out.println();
		// Cas limite : 1 tableau avec un entier
		System.out.println("Cas limite : 1 tableau avec un entier : ");
		testCasRemplirToutesDiff(new int[]{1}, 1);
		System.out.println();
		// Cas limite : 1 tableau avec des elements egaux
		System.out.println("Cas limite : 1 tableau avec des elements egaux : ");
		testCasRemplirToutesDiff(new int[]{1, 1, 1, 1}, 4);
		System.out.println();
		// Cas d'erreur : 1 tableau vide
		System.out.println("Cas d'erreur : 1 tableau vide : ");
		testCasRemplirToutesDiff(new int[]{}, 0);
		System.out.println();
		// Cas d'erreur : 1 tableau avec des entiers mais avec un nombre nombre d'elements supèrieur au nombre d'elements reels
		System.out.println("Cas d'erreur : 1 tableau avec des entiers mais avec un nombre nombre d'elements supèrieur au nombre d'elements reels : ");
		testCasRemplirToutesDiff(new int[]{1, 2, 3, 4}, 6);
		System.out.println();
		// Cas d'erreur : 1 tableau avec des entiers mais avec un nombre d'elements négatif
		System.out.println("Cas d'erreur : 1 tableau avec des entiers mais avec un nombre d'elements négatif : ");
		testCasRemplirToutesDiff(new int[]{1, 2, 3, 4}, -1);
		System.out.println();
		// Cas d'erreur : 1 tableau null
		System.out.println("Cas d'erreur : 1 tableau null : ");
		testCasRemplirToutesDiff(null, 0);
		System.out.println();
	}

	/**
	 * Cette methode test si le tableau est valide, affiche OK si le tableau est valide et ERREUR sinon.
	 *
	 * @param leTab le tableau à copier
	 * @param nbElem le nombre d'elements à copier
	 */
	void testCasRemplirToutesDiff(int[] leTab, int nbElem){
		System.out.print("Tableau avant : ");
		afficherTab(leTab, nbElem);
		System.out.print(" Nombre d'elements : " + nbElem + " ");
		remplirToutesDiff(leTab, nbElem);
		System.out.print(" Tableau après : ");
		afficherTab(leTab, nbElem);
		System.out.print("\t" + VERT + "OK" + SUPPR);
		System.out.println();
	}
}