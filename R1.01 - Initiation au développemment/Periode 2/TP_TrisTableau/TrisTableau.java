/**
 * Cette classe effectue des opérations plus complexes sur un tableaux d'entiers : recherche dichotomique, tris, etc. La taille d'un tableau est
 * par définition le nombre TOTAL de cases = tab.length. Un tableau d'entiers créé possède nbElem élements qui ne correspond pas
 * forcément à la taille du tableau. Il faut donc toujours considéré que nbElem infèrieur ou égal à tab.length (= taille).
 *
 * Il est fait usage de la classe SimplesTableau pour accéder aux méthodes de cette classe.
 *
 * @author N.LESCOP - novembre 2024
 * @version 1.1.0
 */
public class TrisTableau {

	/**
	 * Objet de la classe SimplesTableau
	 */
	SimplesTableau monSpleTab = new SimplesTableau();

	/**
	 * Codes ANSI pour la couleur rouge
	 */
	String ROUGE = "\033[31m";
	/**
	 * Codes ANSI pour la couleur verte
	 */
	String VERT = "\033[32m";
	/**
	 * Codes ANSI pour la couleur bleu
	 */
	String BLEU = "\033[34m";
	/**
	 * Codes ANSI pour la couleur violette
	 */
	String VIOLET = "\033[35m";
	/**
	 * Codes ANSI pour supprimer la couleur
	 */
	String SUPPR = "\033[0m";

	/**
	 * Compteur d'opérations élémentaires
	 */
	long cpt = 0;

	/**
	 * point d’entree de l’execution
	 */
	void principal() {
		// Appel des méthodes de test

		testRechercheSeq();
		testRechercheSeqEfficacite();

		testVerifTri();

		testRechercheDicho();
		testRechercheDichoEfficacite();

		testTriSimple();
		testTriSimpleEfficacite();

		testSeparer();

		testTriRapideRec();

		testTriRapide();
		testTriRapideEfficacite();

		testCreerTabFreq();

		testTriParComptageFreq();
		testTriParComptageFreqEfficacite();

		testTriABulles();
		testTriABullesEfficacite();
	}

	/* =============================================================================
	   = 							rechercheSeq								   =
	   =============================================================================
	*/

	/**
	 * Recherche séquentielle d'une valeur dans un tableau. La valeur à rechercher peut exister en plusieurs exemplaires mais la recherche
	 * s'arrête dès qu'une première valeur est trouvée. On suppose que le tableau passé en paramètre est créé et possède au moins une
	 * valeur (nbElem > 0). Ceci ne doit donc pas être vérifié.
	 *
	 * @param leTab le tableau d'entiers
	 * @param nbElem le nombre d'éléments du tableau
	 * @param aRech l'élément à rechercher
	 * @return l'indice de l'élément recherché ou -1 si non trouvé
	 */
	int rechercheSeq(int[] leTab, int nbElem, int aRech){
		// variables locales
		int i ;
		boolean trouve ;
		// initialisations
		i = 0;
		trouve = false;
		// boucle
		while ( !trouve && ( i < nbElem ) ){
			if ( aRech == leTab[i] ){
				trouve = true;

			}else{
				i++;
			}
			cpt++;
		}
		// terminaison
		if ( !trouve ){
			i = -1;
		}
		return i ;
	}

	/**
	 * Test de la méthode rechercheSeq
	 */
	void testRechercheSeq(){
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		System.out.println(VIOLET + "=                             Test de rechercheSeq                       =" + SUPPR);
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		// Cas normal : élément trouvé
		System.out.println(BLEU + "Cas normal : élément trouvé" + SUPPR);
		testCasRechercheSeq(new int [] {1,2,3,4,5,6,7,8,9,10}, 10, 5, 4);
		System.out.println();
		// Cas normal : élément non trouvé
		System.out.println(BLEU + "Cas normal : élément non trouvé" + SUPPR);
		testCasRechercheSeq(new int [] {1,2,3,4,5,6,7,8,9,10}, 10, 11, -1);
		System.out.println();
		// Cas normal : élément en première position
		System.out.println(BLEU + "Cas normal : élément en première position" + SUPPR);
		testCasRechercheSeq(new int [] {1,2,3,4,5,6,7,8,9,10}, 10, 1, 0);
		System.out.println();
		// Cas normal : élément en dernière position
		System.out.println(BLEU + "Cas normal : élément en dernière position" + SUPPR);
		testCasRechercheSeq(new int [] {1,2,3,4,5,6,7,8,9,10}, 10, 10, 9);
		System.out.println();
		// Cas normal : élément en position quelconque
		System.out.println(BLEU + "Cas normal : élément en position quelconque" + SUPPR);
		testCasRechercheSeq(new int [] {1,2,3,4,5,6,7,8,9,10}, 10, 7, 6);
		System.out.println();
	}

	/**
	 * Test de la méthode rechercheSeq
	 *
	 * @param leTab le tableau d'entiers
	 * @param nbElem le nombre d'éléments du tableau
	 * @param aRech l'élément à rechercher
	 * @param resAttendu l'indice attendu
	 */
	void testCasRechercheSeq(int [] leTab, int nbElem, int aRech, int resAttendu){
		// variables locales
		int resObtenu ;
		// appel de la méthode
		resObtenu = rechercheSeq(leTab, nbElem, aRech);
		// vérification
		if ( resObtenu == resAttendu ){
			System.out.println("Element a trouvé : " + aRech);
			System.out.println("Indice attendu : " + resAttendu);
			System.out.print("Element trouvé à l'indice " + resObtenu);
			System.out.println("\t" + VERT + "Test réussi" + SUPPR);
		}else{
			System.out.println("Element trouvé à l'indice " + resObtenu);
			System.out.print("Indice attendu : " + resAttendu);
			System.out.println("\t" + ROUGE + "Test échoué" + SUPPR);
		}
	}

	/**
	 * Test de la méthode rechercheSeq en termes d'efficacité
	 */
	void testRechercheSeqEfficacite() { // Ɵ(n)
		System.out.println();
		System.out.println(VIOLET + "***testRechercheSeqEfficacite***" + SUPPR);

		// Variables locales
		int position;
		int[] tab;
		int n;
		long t1, t2, diffT;

		// Initialisation
		n = 1_000_000;

		// Multiplication de n par 2 à chaque tour (3 expériences)
		for (int i = 1; i <= 3; i++) {
			tab = new int[n];
			cpt = 0;

			System.out.println("Nombre d'éléments du tableau : " + n);

			// Remplissage aléatoire du tableau
			monSpleTab.remplirAleatoire(tab, n, 1, 1000000);

			// Recherche d'une valeur absente (simule le pire cas)
			t1 = System.nanoTime();
			position = rechercheSeq(tab, n, 0);
			t2 = System.nanoTime();

			// Calcul de la différence de temps
			diffT = (t2 - t1);

			// Affichage des résultats
			System.out.println("Temps = " +  diffT / 1_000 + " us");
			System.out.println("cpt/n = " + (double) cpt / n);

			// Double la taille du tableau pour la prochaine itération
			n = n * 2;
			System.out.println();
		}
	}

	/*
	 * =============================================================================
	 * = 							verifTri								   	   =
	 * =============================================================================
	 */

	/**
	 * Vérifie que le tableau passé en paramètre est trié par ordre croissant des valeurs. On suppose que le tableau passé en paramètre est
	 * créé et possède au moins une valeur (nbElem > 0). Ceci ne doit donc pas être vérifié.
	 *
	 * @param leTab le tableau à vérifier (trié en ordre croissant)
	 * @param nbElem le nombre d'entiers présents dans le tableau
	 * @return true si le tableau est trié
	 */
	boolean verifTri(int[] leTab, int nbElem){
		boolean ok = monSpleTab.verifTab(leTab, nbElem);
		boolean ret = true;
		// variables locales
		int i = 0;
		// vérification
		if (ok){
			while (ret == true && i < nbElem-1 ) {
				if (leTab[i] > leTab[i+1]) {
					ret = false;
				}
				i++;
			}
		// retour
		}else{
			System.out.println(ROUGE + "Le tableau n'est pas valide" + SUPPR);;
		}
		return ret;
	}

	/**
	 * Test de la méthode verifTri
	 */
	void testVerifTri(){
		System.out.println();
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		System.out.println(VIOLET + "=                             Test de verifTri                           =" + SUPPR);
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		// Cas normal : tableau trié
		System.out.println(BLEU + "Cas normal : tableau trié" + SUPPR);
		testCasVerifTri(new int [] {1,2,3,4,5,6,7,8,9,10}, 10, true);
		System.out.println();
		// Cas normal : tableau non trié
		System.out.println(BLEU + "Cas normal : tableau non trié" + SUPPR);
		testCasVerifTri(new int [] {10,9,8,7,6,5,4,3,2,1}, 10, false);
		System.out.println();
		// Cas normal : tableau avec des doublons
		System.out.println(BLEU + "Cas normal : tableau avec des doublons" + SUPPR);
		testCasVerifTri(new int [] {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10}, 20, true);
		System.out.println();
		// Cas normal : tableau avec des nombres négtifs
		System.out.println(BLEU + "Cas normal : tableau avec des nombres négtifs" + SUPPR);
		testCasVerifTri(new int [] {-10,-9,-8,-7,-6,-5,-4,-3,-2,-1}, 10, true);
		System.out.println();
	}

	/**
	 * Test de la méthode verifTri
	 *
	 * @param leTab le tableau à vérifier (trié en ordre croissant)
	 * @param nbELem le nombre d'entiers présents dans le tableau
	 * @param resAttendu le résultat attendu
	 */
	void testCasVerifTri(int[] leTab, int nbELem, boolean resAttendu){
		boolean ok = verifTri(leTab, nbELem);
		// vérification si le tableau est trié
		if(ok == resAttendu){
			System.out.println("Tableau a vérifié : ");
			afficherTab(leTab, nbELem);
			System.out.println();
			System.out.println("reultat attendu : " + resAttendu);
			System.out.print("Tableau trié : " + ok);
			System.out.println("\t" + VERT + "Test réussi" + SUPPR);
		// sinon afficher que le test a échoué
		}else{
			System.out.println("Tableau a vérifié : ");
			afficherTab(leTab, nbELem);
			System.out.println();
			System.out.println("reultat attendu : " + resAttendu);
			System.out.print("Tableau trié : " + ok);
			System.out.println("\t" + ROUGE + "Test échoué" + SUPPR);
		}
	}

	/* =============================================================================
	   = 							rechercheDicho								   =
	   =============================================================================
	*/

	/**
	 * Recherche dichotomique d'une valeur dans un tableau. On suppose que le tableau est trié par ordre croissant. La valeur à
	 * rechercher peut exister en plusieurs exemplaires, dans ce cas, c'est la valeur à l'indice le + faible qui sera trouvé. On suppose
	 * également que le tableau passé en paramètre est créé et possède au moins une valeur (nbElem > 0). Ceci ne doit donc pas être
	 * vérifié.
	 *
	 * @param leTab le tableau trié par ordre croissant dans lequel effectuer la recherche
	 * @param nbElem nombre d'entiers que contient le tableau
	 * @param aRech l'élément à rechercher
	 * @return l'indice de l'élément recherché ou -1 si non trouvé
	 */
	int rechercheDicho(int[] leTab, int nbElem, int aRech){
		int indD, indF, indM, ret; // 4 op
		// initialisations
		indD = 0; // 1 op
		indF = nbElem - 1; // 2 op
		// tant que indD est différent de indF
		while ( indD != indF ) { // 1 op
			// calcul de l'indice médian
			indM = ( indD + indF ) / 2; // 3 op
			// si la valeur recherchée est supérieure à la valeur médiane on décale l'indice de début
			if ( aRech > leTab[indM] ) { // 1 op
				indD = indM + 1; // 2 op

			} else {
				indF = indM; // 1 op
			}
			cpt++;
		}
		// vérification de la valeur trouvée
		if ( aRech == leTab [indD] ) {
			ret = indD; // 2 op

		} else {
			ret = -1; // 1 op
		}
		return ret;
	}

	/**
	 * Test de la méthode rechercheDicho
	 */
	void testRechercheDicho(){
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		System.out.println(VIOLET + "=                             Test de rechercheDicho                     =" + SUPPR);
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		// Cas normal : élément trouvé
		System.out.println(BLEU + "Cas normal : élément trouvé" + SUPPR);
		testCasRechercheDicho(new int [] {1,2,3,4,5,6,7,8,9,10}, 10, 5, 4);
		System.out.println();
		// Cas normal : élément non trouvé
		System.out.println(BLEU + "Cas normal : élément non trouvé" + SUPPR);
		testCasRechercheDicho(new int [] {1,2,3,4,5,6,7,8,9,10}, 10, 11, -1);
		System.out.println();
		// Cas normal : élément en première position
		System.out.println(BLEU + "Cas normal : élément en première position" + SUPPR);
		testCasRechercheDicho(new int [] {1,2,3,4,5,6,7,8,9,10}, 10, 1, 0);
		System.out.println();
		// Cas normal : élément en dernière position
		System.out.println(BLEU + "Cas normal : élément en dernière position" + SUPPR);
		testCasRechercheDicho(new int [] {1,2,3,4,5,6,7,8,9,10}, 10, 10, 9);
		System.out.println();
		// Cas normal : élément en position quelconque
		System.out.println(BLEU + "Cas normal : élément en position quelconque" + SUPPR);
		testCasRechercheDicho(new int [] {1,2,3,4,5,6,7,8,9,10}, 10, 7, 6);
		System.out.println();
	}

	/**
	 * Test de la méthode rechercheDicho
	 *
	 * @param leTab le tableau d'entiers
	 * @param nbElem le nombre d'éléments du tableau
	 * @param aRech l'élément à rechercher
	 * @param resAttendu l'indice attendu
	 */
	void testCasRechercheDicho(int[] leTab, int nbElem, int aRech, int resAttendu){
		// variables locales
		int resObtenu ;
		// appel de la méthode
		resObtenu = rechercheDicho(leTab, nbElem, aRech);
		// vérification
		if ( resObtenu == resAttendu ){
			System.out.println("Element a trouvé : " + aRech);
			System.out.println("Indice attendu : " + resAttendu);
			System.out.print("Element trouvé à l'indice " + resObtenu);
			System.out.println("\t" + VERT + "Test réussi" + SUPPR);
		}else{
			System.out.println("Element trouvé à l'indice " + resObtenu);
			System.out.print("Indice attendu : " + resAttendu);
			System.out.println("\t" + ROUGE + "Test échoué" + SUPPR);
		}
	}

	/**
	 * test de la méthode rechercheDicho en terme d'efficacité
	 */
	void testRechercheDichoEfficacite() { //Ɵ(log2n)
		System.out.println();
		System.out.println(VIOLET + "***testRechercheDichoEfficacite***" + SUPPR);

		// variables locales
		int[] tab;
		int n, indice;
		long t1, t2, diffT;
		double log2n;

		// initialisation
		n = (int) Math.pow(2, 15);

		// multiplication de n par « 2 » à chaque tour
		// 6 expériences
		for ( int i = 1; i <= 6; i++ ) {
			tab = new int[n];
			cpt = 0; // variable globale « long »
			t1 = System.nanoTime();
			indice = rechercheDicho ( tab, n, -1 );
			t2 = System.nanoTime();
			diffT = (t2 - t1); // en nanosecondes
			System.out.println ( "Tps = " + diffT + " ns" );
			log2n = Math.log10(n) / Math.log10(2);

			// Affichage des résultats
			System.out.println ( "cpt/log2n = " + (double)cpt/log2n + " constant = 1" );
			System.out.println("Nombre d'operations elementaires : " + cpt);
			// multiplication de n par « 2 » à chaque tour
			n = n * 2;
			System.out.println();
		}
	}

	/* =============================================================================
	   = 								triSimple								   =
	   =============================================================================
	*/

	/**
	 * Tri simple d'un tableau d'entiers par ordre croissant. Le tri est effectué sur le tableau passé en paramètre. On suppose que le tableau
	 * passé en paramètre est créé et possède au moins une valeur (nbElem > 0). Ceci ne doit donc pas être vérifié.
	 *
	 * @param leTab le tableau d'entiers
	 * @param n le nombre d'éléments du tableau
	 */
	void triSimple ( int [] leTab, int n ) {
		// variables locales
		int i, p, k, min, tmp;
		// initialisations
		i = 0;
		// première boucle = celle qui parcourt le tableau de 0
		// à (n – 2) y compris
		for ( i = 0; i <= (n-2); i++ ) {
		// sélectionner la + petite valeur sur le sous-tableau
		// allant de i à (n-1) : on identifie une case « k »
			min = leTab[i];
			k = i;
			for ( p=(i+1); p <= (n-1); p++ ) {
				if ( leTab[p] < min ) {
					min = leTab[p];
					k = p;
				}
				cpt++;
			}
			// ensuite échanger cette case « k » avec « i »
			tmp = leTab[k];
			leTab[k] = leTab[i];
			leTab[i] = tmp;
		}
	}

	/**
	 * Test de la méthode triSimple
	 */
	void testTriSimple(){
		System.out.println();
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		System.out.println(VIOLET + "=                             Test de triSimple                          =" + SUPPR);
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		// Cas normal : tableau non trié
		System.out.println(BLEU + "Cas normal : tableau non trié" + SUPPR);
		testCasTriSimple(new int [] {10,9,8,7,6,5,4,3,2,1}, 10, new int [] {1,2,3,4,5,6,7,8,9,10});
		System.out.println();
		// Cas normal : tableau déjà trié
		System.out.println(BLEU + "Cas normal : tableau déjà trié" + SUPPR);
		testCasTriSimple(new int [] {1,2,3,4,5,6,7,8,9,10}, 10, new int [] {1,2,3,4,5,6,7,8,9,10});
		System.out.println();
		// Cas normal : tableau trié en sens inverse
		System.out.println(BLEU + "Cas normal : tableau trié en sens inverse" + SUPPR);
		testCasTriSimple(new int [] {10,9,8,7,6,5,4,3,2,1}, 10, new int [] {1,2,3,4,5,6,7,8,9,10});
		System.out.println();
		// Cas normal : tableau avec des doublons
		System.out.println(BLEU + "Cas normal : tableau avec des doublons" + SUPPR);
		testCasTriSimple(new int [] {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10}, 20, new int [] {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10});
		System.out.println();
		// Cas normal : tableau avec des nombres négtifs
		System.out.println(BLEU + "Cas normal : tableau avec des nombres négtifs" + SUPPR);
		testCasTriSimple(new int [] {-10,-9,-8,-7,-6,-5,-4,-3,-2,-1}, 10, new int [] {-10,-9,-8,-7,-6,-5,-4,-3,-2,-1});
		System.out.println();
	}

	/**
	 * Test de la méthode triSimple
	 *
	 * @param leTab le tableau d'entiers
	 * @param n le nombre d'éléments du tableau
	 * @param resAttendu le tableau attendu
	 */
	void testCasTriSimple(int [] leTab, int n, int [] resAttendu) {
		// appel de la méthode
		triSimple(leTab, n);
		boolean egaux = monSpleTab.egalite(leTab, resAttendu, leTab.length, leTab.length);
		// vérification
		if (egaux) {
			System.out.print("Tableau trié : ");
			afficherTab(leTab, leTab.length);
			System.out.println();
			System.out.print("Tableau attendu : ");
			afficherTab(resAttendu, leTab.length);
			System.out.println("\t" + VERT + "Test réussi" + SUPPR);

			System.out.println("Nombre d'operations elementaires : " + cpt);
			cpt = 0;
		} else {
			System.out.print("Tableau trié : ");
			afficherTab(leTab, leTab.length);
			System.out.println();
			System.out.print("Tableau attendu : ");
			afficherTab(resAttendu, leTab.length);
			System.out.println("\t" + ROUGE + "Test échoué" + SUPPR);
		}
	}

	/**
	 * test de la méthode triSimple en terme d'efficacité
	 */
	void testTriSimpleEfficacite() { //Ɵ(n2)
		System.out.println();
		System.out.println(VIOLET + "***testTriSimpleEfficacite***" + SUPPR);
		// variables locales
		int[] tab;
		int n;
		long t1, t2, diffT;
		double n2;
		// initialisation
		n = 2000;
		// multiplication de n par « 2 » à chaque tour
		// 5 expériences
		for (int i = 1; i <= 5; i++) {
			tab = new int[n];
			cpt = 0; // variable globale « long »
			t1 = System.nanoTime();
			triSimple(tab, n);
			t2 = System.nanoTime();
			diffT = (t2 - t1); // en nanosecondes
			System.out.println("Tps = " + diffT / 1000 + " us");
			n2 = n * n;

			// Affichage
			System.out.println("cpt/n2 = " + (double) cpt / n2);
			System.out.println("Nombre d'operations elementaires : " + cpt);
			System.out.println(n);

			// multiplication de n par « 2 » à chaque tour
			n = n * 2;
			System.out.println();
		}
	}

	/*
	 * =============================================================================
	 * = 								separer									   =
	 * =============================================================================
	 */

	/**
	 * Cette méthode doit placer correctement le pivot
	 * dans le tableau délimité par les indices indL et indR.
	 * Au final, la place du pivot dans le tableau est tel que
	 * tous les éléments à sa gauche sont nécessairement
	 * + petits ou égaux et tous les éléments à sa droite
	 * sont nécessairement + grands ou égaux.

	 * @param tab le tableau dans lequel placer le pivot
	 * @param indL l’indice de début du tableau
	 * @param indR l’indice de fin du tableau
	 * @return l’indice du tableau où se trouve le pivot
	 */
	int separer(int[] tab, int indL, int indR){
		// variables locales
		int i = indR + 1;
		int pivot = tab[indL];

		// tant que j est supérieur à l'indice de gauche
		for (int j = indR; j > indL; j--) {
			// si tab[j] est supérieur au pivot
			if (tab[j] > pivot) {
				// décrémenter i
				i--;
				// si i est différent de j, échanger tab[i] et tab[j]
				if (i != j) {
					echange(tab, i, j);
				}
			}
			cpt++;
		}
		// échanger tab[i - 1] et tab[indL]
		echange(tab, i - 1, indL);
		return i - 1;
	}

	/**
	 * test de la méthode separer
	 */
	void testSeparer() {
		System.out.println();
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		System.out.println(VIOLET + "=                             Test de separer                           =" + SUPPR);
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		// Cas normal : tableau non trié
		System.out.println(BLEU + "Cas normal : tableau non trié" + SUPPR);
		testCasSeparer(new int [] {2, 6, 3, 8, 5, 7, 4, 9, 1}, 0, 8, 1);
		System.out.println();
		// Cas normal : tableau déjà trié
		System.out.println(BLEU + "Cas normal : tableau déjà trié" + SUPPR);
		testCasSeparer(new int [] {1,2,3,4,5,6,7,8,9,10}, 0, 9, 0);
		System.out.println();
		// Cas normal : tableau trié en sens inverse
		System.out.println(BLEU + "Cas normal : tableau trié en sens inverse" + SUPPR);
		testCasSeparer(new int [] {10,9,8,7,6,5,4,3,2,1}, 0, 9, 9);
		System.out.println();
		// Cas normal : tableau avec des doublons
		System.out.println(BLEU + "Cas normal : tableau avec des doublons" + SUPPR);
		testCasSeparer(new int [] {10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1}, 0, 19, 19);
		System.out.println();
		// Cas normal : tableau avec des nombres négtifs
		System.out.println(BLEU + "Cas normal : tableau avec des nombres négatifs" + SUPPR);
		testCasSeparer(new int [] {-10,-9,-8,-7,-6,-5,-4,-3,-2,-1}, 0, 9, 0);
		System.out.println();
		// Cas normal : un taleau avec des éléments différents
		System.out.println(BLEU + "Cas normal : un taleau avec des éléments différents" + SUPPR);
		testCasSeparer(new int [] {44, 12, 65, 46, 42, 23, 18, 55}, 0, 7, 4);
		System.out.println();
	}

	/**
	 * Test différent cas de la méthode separer
	 *
	 * @param leTab le tableau d'entiers
	 * @param indL l’indice de début du tableau
	 * @param indR l’indice de fin du tableau
	 * @param resAttendu l’indice attendu
	 */
	void testCasSeparer(int[] leTab, int indL, int indR, int resAttendu){
		// appel de la méthode
		int resObtenu = separer(leTab, indL, indR);
		// vérification
		if (resObtenu == resAttendu){
			System.out.print("Tableau : ");
			afficherTab(leTab, leTab.length);
			System.out.println();
			System.out.print("Indice attendu : " + resAttendu + " Indice obtenu : " + resObtenu);
			System.out.println();
			System.out.print("Pivot : " + leTab[resObtenu]);
			System.out.println("\t" + VERT + "Test réussi" + SUPPR);

			System.out.println("Nombre d'operations elementaires : " + cpt);
			cpt = 0;
		}else{
			System.out.print("Tableau : ");
			afficherTab(leTab, leTab.length);
			System.out.println();
			System.out.print("Indice attendu : " + " Indice obtenu : " + resObtenu);
			System.out.println();
			System.out.print("Pivot : " + leTab[resObtenu]);
			System.out.println("\t" + ROUGE + "Test échoué" + SUPPR);
			}
	}

	/*
	 * =============================================================================
	 * = 							triRapideRec								   =
	 * =============================================================================
	 */

	/**
	 * Méthode de tri récursive selon le principe de séparation. La méthode s'appelle elle-même sur les tableaux gauche et droite par
	 * rapport à un pivot.
	 *
	 * @param tab le tableau d'entiers
	 * @param indL l’indice de début du tableau
	 * @param indR l’indice de fin du tableau
	 */
	void triRapideRec(int[] tab, int indL, int indR){
		if (indL < indR) {
			int iPivot = separer(tab, indL, indR);
			triRapideRec(tab, indL, iPivot - 1);
			triRapideRec(tab, iPivot + 1, indR);
		}
	}

	/**
	 * Test de la méthode triRapideRec
	 */
	void testTriRapideRec(){
		System.out.println();
		System.out.println(VIOLET +"==========================================================================" + SUPPR);
		System.out.println(VIOLET + "=                             Test de triRapideRec                      =" + SUPPR);
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		// Cas normal : tableau non trié
		System.out.println(BLEU + "Cas normal : tableau non trié" + SUPPR);
		testCasTriRapideRec(new int [] {10,9,8,7,6,5,4,3,2,1}, 0, 9, new int [] {1,2,3,4,5,6,7,8,9,10});
		System.out.println();
		// Cas normal : tableau déjà trié
		System.out.println(BLEU + "Cas normal : tableau déjà trié" + SUPPR);
		testCasTriRapideRec(new int [] {1,2,3,4,5,6,7,8,9,10}, 0, 9, new int [] {1,2,3,4,5,6,7,8,9,10});
		System.out.println();
		// Cas normal : tableau trié en sens inverse
		System.out.println(BLEU + "Cas normal : tableau trié en sens inverse" + SUPPR);
		testCasTriRapideRec(new int [] {10,9,8,7,6,5,4,3,2,1}, 0, 9, new int [] {1,2,3,4,5,6,7,8,9,10});
		System.out.println();
		// Cas normal : tableau avec des doublons
		System.out.println(BLEU + "Cas normal : tableau avec des doublons" + SUPPR);
		testCasTriRapideRec(new int [] {10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1}, 0, 19, new int [] {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10});
		System.out.println();
	}

	/**
	 * Test de la méthode triRapideRec
	 *
	 * @param leTab le tableau d'entiers
	 * @param indL l’indice de début du tableau
	 * @param indR l’indice de fin du tableau
	 * @param resAttendu le tableau attendu
	 */
	void testCasTriRapideRec(int[] leTab, int indL, int indR, int[] resAttendu){
		boolean ok = monSpleTab.verifTab(leTab, leTab.length);
		// appel de la méthode
		triRapideRec(leTab, indL, indR);
		boolean egaux = monSpleTab.egalite(leTab, resAttendu, leTab.length, leTab.length);
		// vérification
		if (ok){
			if (egaux)
				System.out.print("Tableau trié : ");
			afficherTab(leTab, leTab.length);
			System.out.println();
			System.out.print("Tableau attendu : ");
			afficherTab(resAttendu, leTab.length);
			System.out.println("\t" + VERT + "Test réussi" + SUPPR);

			System.out.println("Nombre d'operations elementaires : " + cpt);
			cpt = 0;
		}else{
			System.out.println("\t" + ROUGE + "Test échoué" + SUPPR);
		}
	}

	/*
	 * =============================================================================
	 * = 								triRapide								   =
	 * =============================================================================
	 */

	/**
	 * Tri par ordre croissant d'un tableau selon la méthode du tri rapide (QuickSort). On suppose que le tableau passé en paramètre est
	 * créé et possède au moins une valeur (nbElem > 0). Ceci ne doit donc pas être vérifié. Cette méthode appelle triRapideRec(...) qui elle
	 * effectue réellement le tri rapide selon la méthode de séparation récursive
	 *
	 * @param leTab le tableau à trier par ordre croissant
	 * @param nbElem le nombre d'entiers que contient le tableau
	 */
    void triRapide(int[] leTab, int nbElem){
		// Appel de la méthode verifTab
		triRapideRec ( leTab, 0, (nbElem-1) );
	}

	/**
	 * Test de la méthode triRapide
	 */
	void testTriRapide(){
		System.out.println();
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		System.out.println(VIOLET + "=                             Test de triRapide                          =" + SUPPR);
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		// Cas normal : tableau non trié
		System.out.println(BLEU + "Cas normal : tableau non trié" + SUPPR);
		testCasTriRapide(new int [] {10,9,8,7,6,5,4,3,2,1}, 10, new int [] {1,2,3,4,5,6,7,8,9,10});
		System.out.println();
		// Cas normal : tableau déjà trié
		System.out.println(BLEU + "Cas normal : tableau déjà trié" + SUPPR);
		testCasTriRapide(new int [] {1,2,3,4,5,6,7,8,9,10}, 10, new int [] {1,2,3,4,5,6,7,8,9,10});
		System.out.println();
		// Cas normal : tableau trié en sens inverse
		System.out.println(BLEU + "Cas normal : tableau trié en sens inverse" + SUPPR);
		testCasTriRapide(new int [] {10,9,8,7,6,5,4,3,2,1}, 10, new int [] {1,2,3,4,5,6,7,8,9,10});
		System.out.println();
		// Cas normal : tableau avec des doublons
		System.out.println(BLEU + "Cas normal : tableau avec des doublons" + SUPPR);
		testCasTriRapide(new int [] {10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1}, 20, new int [] {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10});
		System.out.println();

	}

	/**
	 * Test de la méthode triRapide
	 *
	 * @param leTab le tableau à trier par ordre croissant
	 * @param nbElem le nombre d'entiers que contient le tableau
	 * @param resAttendu le tableau attendu
	 */
	void testCasTriRapide(int[] leTab, int nbElem, int[] resAttendu){
		boolean ok = monSpleTab.verifTab(leTab, nbElem);
		// appel de la méthode
		triRapide(leTab, nbElem);
		boolean egaux = monSpleTab.egalite(leTab, resAttendu, nbElem, nbElem);
		// vérification
		if (ok){
			if (egaux)
				System.out.print("Tableau trié : ");
				afficherTab(leTab, nbElem);
				System.out.println();
				System.out.print("Tableau attendu : ");
				afficherTab(resAttendu, nbElem);
				System.out.println("\t" + VERT + "Test réussi" + SUPPR);

				System.out.println("Nombre d'operations elementaires : " + cpt);
				cpt = 0;
		}else{
			System.out.println("\t" + ROUGE + "Test échoué" + SUPPR);
		}
	}

	/**
	 * Test de la méthode de l'efficacité de triRapide
	 */
	void testTriRapideEfficacite() { //Ɵ(nlog2n)
		System.out.println(VIOLET + "***testTriRapideEfficacite***" + SUPPR);
		// variables locales
		int nbElem = 150000;
		for(int i =0 ; i < 5; i++) {
			cpt = 0;
			int[] tab = new int[nbElem];
			// remplir le tableau
			monSpleTab.remplirAleatoire(tab, nbElem, 1, 1000000);
			// vérification
			boolean ok = monSpleTab.verifTab(tab, nbElem);
			if (ok) {
				// tri
				long t1 = System.nanoTime();
				triRapide(tab, nbElem);
				long t2 = System.nanoTime();
				long TpsEx = (t2 - t1);
				System.out.println("Temps d'exécution : " + TpsEx/1000 + " us");
				double nlog2n = nbElem * (Math.log(nbElem)/Math.log(2));

				// Affichage
				System.out.println("Cas Normal : Tableau de " + nbElem + " éléments");
				System.out.println("cpt/nlog2n = " + (double) cpt/nlog2n);
				System.out.println();


			} else {
				System.out.println(ROUGE + "Le tableau n'est pas valide" + SUPPR);
			}
			nbElem = nbElem * 2;
		}
	}

	/*
	 * =============================================================================
	 * = 								triParComptageFreq						   =
	 * =============================================================================
	 */

	/**
	 * A partir d'un tableau initial passé en paramètre "leTab", cette méthode renvoie un nouveau tableau "tabFreq" d'entiers où chaque
	 * case contient la fréquence d'apparition des valeurs dans le tableau initial. Pour simplifier, on suppose que le tableau initial ne contient
	 * que des entiers compris entre 0 et max (supèrieur à 0). Dès lors le tableau "tabFreq" se compose de (max+1) cases et chaque case "i"
	 * (0 inf ou égal à i inf ou égal à max) contient le nombre de fois que l'entier "i" apparait dans le tableau initial. On suppose que le tableau passé en
	 * paramètre est créé et possède au moins une valeur (nbElem supèrieur 0). Ceci ne doit donc pas être vérifié. Par contre, on vérifiera que le
	 * min est supèrieur ou égal à 0. Dans le cas contraire, renvoyer un tableau "null".
	 *
	 * @param leTab le tableau initial
	 * @param nbElem le nombre d'entiers présents dans le tableau
	 * @return le tableau des fréquences de taille (max+1) ou null si la méthode ne s'applique pas
	 */
	int[] creerTabFreq(int[] leTab, int nbElem){
		// appel de la méthode
		verifTabNegatif(leTab, nbElem);
		// variables locales
		int min = leTab[0];
		int max = leTab[0];
		// verification du min et du max
		for (int i = 1; i < nbElem; i++){
			if (leTab[i] < min){
				min = leTab[i];
			}
			if (leTab[i] > max){
				max = leTab[i];
			}
		}
		// tableau de fréquence
		int [] tabFreq = new int [max - min +1];
		// remplissage du tableau de fréquence
		for (int i = 0; i < nbElem; i++) {
			tabFreq[leTab[i] - min]++;
			cpt++;
		}
		return tabFreq;
	}

	/**
	 * Test de la méthode creerTabFreq
	 */
	void testCreerTabFreq(){
		System.out.println();
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		System.out.println(VIOLET + "=                             Test de creerTabFreq                      =" + SUPPR);
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		// Cas normal : tableau non trié
		System.out.println(BLEU + "Cas normal : tableau non trié" + SUPPR);
		testCasCreerTabFreq(new int [] {10,9,8,7,6,5,4,3,2,1}, 10, new int [] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
		System.out.println();
		// Cas normal : tableau déjà trié
		System.out.println(BLEU + "Cas normal : tableau déjà trié" + SUPPR);
		testCasCreerTabFreq(new int [] {1,2,3,4,5,6,7,8,9,10}, 10, new int [] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
		System.out.println();
		// Cas normal : tableau avec des doublons
		System.out.println(BLEU + "Cas normal : tableau avec des doublons" + SUPPR);
		testCasCreerTabFreq(new int [] {45, 0, 45, 10, 15, 0, 5, 10, 45}, 9, new int [] {2, 0, 0, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3});
		System.out.println();
		// Cas normal : tableau avec des nombres négtifs
		System.out.println(BLEU + "Cas normal : tableau avec des nombres négatifs" + SUPPR);
		testCasCreerTabFreq(new int [] {-10,-9,-8,-7,-6,-5,-4,-3,-2,-1}, 10, new int [] {1,1,1,1,1,1,1,1,1,1});
		System.out.println();
	}

	/**
	 * Test de la méthode creerTabFreq
	 *
	 * @param leTab le tableau d'entiers
	 * @param nbElem le nombre d'entiers présents dans le tableau
	 * @param resAttendu le tableau des fréquences attendu
	 */
	void testCasCreerTabFreq(int[] leTab, int nbElem, int[] resAttendu){
		// appel de la méthode
		int[] resObtenu = creerTabFreq(leTab, nbElem);
		// vérification
		boolean egaux = monSpleTab.egalite(resObtenu, resAttendu, resObtenu.length, resAttendu.length);
		if (egaux){
			System.out.print("Tableau de fréquence : ");
			afficherTab(resObtenu, resObtenu.length);
			System.out.println();
			System.out.print("Tableau de fréquence attendu : ");
			afficherTab(resAttendu, resAttendu.length);
			System.out.println("\t" + VERT + "Test réussi" + SUPPR);
		}else{
			System.out.print("Tableau de fréquence : ");
			afficherTab(resObtenu, resObtenu.length);
			System.out.println();
			System.out.print("Tableau de fréquence attendu : ");
			afficherTab(resAttendu, resAttendu.length);
			System.out.println("\t" + ROUGE + "Test échoué" + SUPPR);
		}
	}

	/**
	 * Tri par ordre croissant d'un tableau selon la méthode du tri par comptage de fréquences. On suppose que le tableau passé en
	 * paramètre est créé et possède au moins une valeur (nbElem > 0). Ceci ne doit donc pas être vérifié.
	 *
	 * @param leTab le tableau à trier par ordre croissant
	 * @param nbElem le nombre d'entiers que contient le tableau
	 */
	void triParComptageFreq(int[] leTab, int nbElem){
		boolean ok = monSpleTab.verifTab(leTab, nbElem);
		int[] tabFreq = creerTabFreq(leTab, nbElem);
		// variables locales
		int ind = 0;
		// vérification si le tableau est valide
		if (ok){
			// variables locales
			int min = leTab[0];
			int max = leTab[0];
			// verification du min et du max
			for (int i = 1; i < nbElem; i++){
				if (leTab[i] < min){
					min = leTab[i];
				}
				if (leTab[i] > max){
					max = leTab[i];
				}
			}
			// remplissage du tableau en remplissant le tableau initial et en tenant compte des fréquences
			for (int i = 0; i < tabFreq.length; i++){
				cpt++;
				if (tabFreq[i] != 0){
					for (int j = 0; j < tabFreq[i]; j++){

						leTab[ind] = i + min;
						ind++;
					}
				}
			}
		}
	}

	/**
	 * Test de la méthode triParComptageFreq
	 */
	void testTriParComptageFreq(){
		System.out.println();
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		System.out.println(VIOLET + "=                             Test de triParComptageFreq                =" + SUPPR);
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		// Cas normal : tableau non trié
		System.out.println(BLEU + "Cas normal : tableau non trié" + SUPPR);
		testCasTriParComptageFreq(new int [] {10,9,8,7,6,5,4,3,2,1}, 10, new int [] {1,2,3,4,5,6,7,8,9,10});
		System.out.println();
		// Cas normal : tableau déjà trié
		System.out.println(BLEU + "Cas normal : tableau déjà trié" + SUPPR);
		testCasTriParComptageFreq(new int [] {1,2,3,4,5,6,7,8,9,10}, 10, new int [] {1,2,3,4,5,6,7,8,9,10});
		System.out.println();
		// Cas normal : tableau trié en sens inverse
		System.out.println(BLEU + "Cas normal : tableau trié en sens inverse" + SUPPR);
		testCasTriParComptageFreq(new int [] {10,9,8,7,6,5,4,3,2,1}, 10, new int [] {1,2,3,4,5,6,7,8,9,10});
		System.out.println();
		// Cas normal : tableau avec des doublons
		System.out.println(BLEU + "Cas normal : tableau avec des doublons" + SUPPR);
		testCasTriParComptageFreq(new int [] {10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1}, 20, new int [] {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10});
		System.out.println();
	}

	/**
	 * Test de la méthode triParComptageFreq
	 *
	 * @param leTab le tableau d'entiers
	 * @param nbElem le nombre d'entiers que contient le tableau
	 * @param resAttendu le tableau attendu
	 */
	void testCasTriParComptageFreq(int[] leTab, int nbElem, int[] resAttendu){
		// appel de la méthode
		triParComptageFreq(leTab, nbElem);
		boolean egaux = monSpleTab.egalite(leTab, resAttendu, nbElem, nbElem);
		// vérification
		if (egaux){
			System.out.print("Tableau trié : ");
			afficherTab(leTab, nbElem);
			System.out.println();
			System.out.print("Tableau attendu : ");
			afficherTab(resAttendu, nbElem);
			System.out.println("\t" + VERT + "Test réussi" + SUPPR);

			System.out.println("Nombre d'operations elementaires : " + cpt);
			cpt = 0;
		}else{
			System.out.print("Tableau trié : ");
			afficherTab(leTab, nbElem);
			System.out.println();
			System.out.print("Tableau attendu : ");
			afficherTab(resAttendu, nbElem);
			System.out.println("\t" + ROUGE + "Test échoué" + SUPPR);
		}
	}

	/**
	 * Test l'efficacité de la méthode triParComptageFreq
	 */
	void testTriParComptageFreqEfficacite() { //Ɵ(n + k)
		System.out.println();
		System.out.println(VIOLET + "***testTriParComptageFreqEfficacite***" + SUPPR);
		// variables locales
		int[] tab;
		int n;
		long t1, t2, diffT;
		// initialisation
		n = 1000000;
		// multiplication de n par « 2 » à chaque tour
		// 6 expériences
		for (int i = 1; i <= 6; i++) {
			tab = new int[n];
			cpt = 0; // variable globale « long »
			monSpleTab.remplirAleatoire(tab, n, 1, 1000000);
			// Recherche du min et du max
			int min = tab[0];
			int max = tab[0];

			for (int j = 1; j < n; j++){
				if (tab[j] < min){
					min = tab[j];
				}
				if (tab[j] > max){
					max = tab[j];
				}
			}

			t1 = System.nanoTime();
			triParComptageFreq(tab, n);
			t2 = System.nanoTime();
			diffT = (t2 - t1); // en nanosecondes

			//Affichage
			System.out.println("Tps = " + diffT /1000 + " us");
			System.out.println("cpt/n = " + (double) cpt / (n + max - min + 1));

			// multiplication de n par « 2 » à chaque tour
			n = n * 2;
			System.out.println();
		}
	}

	/*
	 * =============================================================================
	 * = 								triABulles								   =
	 * =============================================================================
	 */

	/**
	 * Tri par ordre croissant d'un tableau selon la méthode du tri à bulles : tant que le tableau qu'il reste à trier a au moins 2 cases,
	 * permuter le contenu de 2 cases successives si leTab[i] > leTab[i+1]. On suppose que le tableau passé en paramètre est créé et
	 * possède au moins une valeur (nbElem > 0). Ceci ne doit donc pas être vérifié.
	 *
	 * @param leTab le tableau à trier par ordre croissant
	 * @param nbElem le nombre d'entiers que contient le tableau
	 */
	void triABulles(int[] leTab, int nbElem){
		// variables locales
		int temp = 0;
		// tri à bulles
		for(int i = 0; i < nbElem -1; i++) {
			// parcours le tableau et reduit la taille du tableau à chaque itération
			for (int j = 0; j < nbElem-1-i; j++){
				// si leTab[j] > leTab[j+1], on permute
				if (leTab[j] > leTab[j+1]) {
					temp = leTab[j];
					leTab[j] = leTab[j+1];
					leTab[j+1] = temp;
				}
				cpt++;
			}
		}
	}

	/**
	 * Test de la méthode triABulles
	 */
	void testTriABulles(){
		System.out.println();
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		System.out.println(VIOLET + "=                             Test de triABulles                         =" + SUPPR);
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		// Cas normal : tableau non trié
		System.out.println(BLEU + "Cas normal : tableau non trié" + SUPPR);
		testCasTriABulles(new int [] {10,9,8,7,6,5,4,3,2,1}, 10, new int [] {1,2,3,4,5,6,7,8,9,10});
		System.out.println();
		// Cas normal : tableau déjà trié
		System.out.println(BLEU + "Cas normal : tableau déjà trié" + SUPPR);
		testCasTriABulles(new int [] {1,2,3,4,5,6,7,8,9,10}, 10, new int [] {1,2,3,4,5,6,7,8,9,10});
		System.out.println();
		// Cas normal : tableau trié en sens inverse
		System.out.println(BLEU + "Cas normal : tableau trié en sens inverse" + SUPPR);
		testCasTriABulles(new int [] {10,9,8,7,6,5,4,3,2,1}, 10, new int [] {1,2,3,4,5,6,7,8,9,10});
		System.out.println();
		// Cas normal : tableau avec des doublons
		System.out.println(BLEU + "Cas normal : tableau avec des doublons" + SUPPR);
		testCasTriABulles(new int [] {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10}, 20, new int [] {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10});
		System.out.println();
		// Cas normal : tableau avec des nombres négatifs
		System.out.println(BLEU + "Cas normal : tableau avec des nombres négatifs" + SUPPR);
		testCasTriABulles(new int [] {-10,-9,-8,-7,-6,-5,-4,-3,-2,-1}, 10, new int [] {-10,-9,-8,-7,-6,-5,-4,-3,-2,-1});
		System.out.println();
	}

	/**
	 * Test de la méthode triABulles
	 *
	 * @param leTab le tableau d'entiers
	 * @param nbElem le nombre d'entiers que contient le tableau
	 * @param resAttendu le tableau attendu
	 */
	void testCasTriABulles(int[] leTab, int nbElem, int[] resAttendu){
		// appel de la méthode
		triABulles(leTab, nbElem);
		boolean egaux = monSpleTab.egalite(leTab, resAttendu, nbElem, nbElem);
		// vérification
		if (egaux){
			System.out.print("Tableau trié : ");
			afficherTab(leTab, nbElem);
			System.out.println();
			System.out.print("Tableau attendu : ");
			afficherTab(resAttendu, nbElem);
			System.out.println("\t" + VERT + "Test réussi" + SUPPR);

			System.out.println("Nombre d'operations elementaires : " + cpt);
			cpt = 0;
		}else{
			System.out.print("Tableau trié : ");
			afficherTab(leTab, nbElem);
			System.out.println();
			System.out.print("Tableau attendu : ");
			afficherTab(resAttendu, nbElem);
			System.out.println("\t" + ROUGE + "Test échoué" + SUPPR);
		}
	}

	/**
	 * Test l'efficacité de la méthode triABulles
	 */
	void testTriABullesEfficacite() { //Ɵ(n2)
		System.out.println();
		System.out.println(VIOLET + "***testTriABullesEfficacite***" + SUPPR);
		// variables locales
		int[] tab;
		int n;
		long t1, t2, diffT;
		// initialisation
		n = 2000;
		// multiplication de n par « 2 » à chaque tour
		// 6 expériences
		for (int i = 1; i <= 5; i++) {
			tab = new int[n];
			cpt = 0; // variable globale « long »
			monSpleTab.remplirAleatoire(tab, n, 1, 1000000);
			t1 = System.nanoTime();
			triABulles(tab, n);
			t2 = System.nanoTime();
			diffT = (t2 - t1); // en nanosecondes

			//Affichage
			System.out.println("Tps = " + diffT / 1000 + " us");
			System.out.println("cpt/n2 = " + (double) cpt / (n*n));

			// multiplication de n par « 2 » à chaque tour
			n = n * 2;
			System.out.println();
		}
	}

	/**
	 * Cette methode affiche les elements d'un tableau.
	 *
	 * @param leTab  tableau d'entiers
	 * @param nbElem nombre d'elements du tableau
	 */
	void afficherTab(int leTab[], int nbElem) {
		boolean ok = monSpleTab.verifTab(leTab, nbElem);
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
	 * Cette méthode échange deux éléments d'un tableau.
	 *
	 * @param leTab le tableau d'entiers
	 * @param ind1 l'indice du premier élément
	 * @param ind2 l'indice du deuxième élément
	 */
	void echange(int[] leTab, int ind1, int ind2){
		// Appel de la méthode verifTab
		boolean ok = monSpleTab.verifTab(leTab, leTab.length);
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
	 * Cette méthode vérifie si un tableau contient des nombres négatifs.
	 *
	 * @param leTab  le tableau d'entiers
	 * @param nbElem le nombre d'éléments du tableau
	 */
	void verifTabNegatif(int [] leTab, int nbElem){
		int i = 0;

		boolean estNegatif = false;

		while (i < nbElem && !estNegatif){
			if (leTab[i] < 0){
				estNegatif = true;
				System.out.println("Erreur : le tableau contient des nombres négatifs");
			}
			i++;
		}
	}
}
