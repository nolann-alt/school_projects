/**
 * Classe de test pour la classe Duree
 *
 * @author N.LESCOP - novembre 2024
 * @version 1.1.0
 */
public class TestDuree {
	/** Codes ANSI pour la couleur rouge */
	String ROUGE = "\033[31m";
	/** Codes ANSI pour la couleur verte */
	String VERT = "\033[32m";
	/** Codes ANSI pour la couleur bleu */
	String BLEU = "\033[34m";
	/** Codes ANSI pour la couleur jaune */
	String SUPPR = "\033[0m";
	/**
	 * Codes ANSI pour la couleur violette
	 */
	String VIOLET = "\033[35m";

	/**
	 * point d’entree de l’execution
	 */
	void principal() {
		testConstructeur1EtGetLeTemps() ;
		testConstructeur2EtGetLeTemps() ;
		testAjouter() ;
		testSoustraire() ;
		testCompareA() ;
		testEnTexte() ;

	}

	// ========================= testConstructeur1EtGetLeTemps =========================

	/**
	 * Methode de test pour le constructeur 1 et getLeTemps
	 */
	void testConstructeur1EtGetLeTemps () {
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		System.out.println(VIOLET + "=                        testConstructeur1EtGetLeTemps                   =" + SUPPR);
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
	    // Cas normal : un temps en milisecondes
		System.out.println(BLEU + "Cas normal : un temps en milisecondes" + SUPPR);
		testCasConstructeur1EtGetLeTemps(99, 99);
		System.out.println();
		// Cas limite : un temps égal à 0
		System.out.println(BLEU + "Cas limite : un temps égal à 0" + SUPPR);
		testCasConstructeur1EtGetLeTemps(0, 0);
		System.out.println();
		// Cas d'erreur : un temps négatif
		System.out.println(BLEU + "Cas d'erreur : un temps négatif" + SUPPR);
		testCasConstructeur1EtGetLeTemps(-1, 0);
		System.out.println();
	}

	/**
	 * Methode de test pour le constructeur 1 et getLeTemps
	 *
	 * @param leTemps le temps en milisecondes
	 * @param resAttendu le resultat attendu
	 */
	void testCasConstructeur1EtGetLeTemps(int leTemps, int resAttendu){
		Duree d1 = new Duree (leTemps);
		int temps = d1.getLeTemps();
		if (temps == resAttendu) {
			System.out.print("le temps : " + leTemps + "\t" + "resultat attendu : " + resAttendu);
			System.out.println(VERT + "\t" + "OK" + SUPPR);

		} else {
			System.out.print("le temps : " + leTemps + "\t" + "resultat attendu : " + resAttendu);
			System.err.println(ROUGE + "\t" + "ERREUR" + SUPPR);
		}
	}

	// ========================= testConstructeur2EtGetLeTemps =========================

	/**
	 * Methode de test pour le constructeur 2 et getLeTemps
	 */
	void testConstructeur2EtGetLeTemps () {
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		System.out.println(VIOLET + "=                        testConstructeur2EtGetLeTemps                   =" + SUPPR);
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		// Cas normal : un temps en milisecondes
		System.out.println(BLEU + "Cas normal : un temps en heures, minutes, secondes" + SUPPR);
		testCasConstructeur2EtGetLeTemps(2, 30, 30, 9030000);
		System.out.println();
		// Cas limite : un temps égal à 0
		System.out.println(BLEU + "Cas limite : un temps égal à 0" + SUPPR);
		testCasConstructeur2EtGetLeTemps(0, 0, 0, 0);
		System.out.println();
		// Cas d'erreur : un temps négatif
		System.out.println(BLEU + "Cas d'erreur : un temps négatif" + SUPPR);
		testCasConstructeur2EtGetLeTemps(-1, 0, 0,  0);
		System.out.println();
	}

	/**
	 * Methode de test pour le constructeur 2 et getLeTemps
	 *
	 * @param heures les heures
	 * @param minutes les minutes
	 * @param secondes les secondes
	 * @param resAttendu le resultat attendu
	 */
	void testCasConstructeur2EtGetLeTemps(int heures, int minutes, int secondes, int resAttendu){
		Duree d1 = new Duree (heures, minutes, secondes);
		int temps = d1.getLeTemps();
		if (temps == resAttendu) {
			System.out.print("le temps : " + temps + "\t" + "resultat attendu : " + resAttendu);
			System.out.println(VERT + "\t" + "OK" + SUPPR);

		} else {
			System.out.print("le temps : " + temps + "\t" + "resultat attendu : " + resAttendu);
			System.err.println(ROUGE + "\t" + "ERREUR" + SUPPR);
		}
	}

	// ========================= testAjouter =========================

	/**
	 * Methode de test pour la methode ajouter
	 */
	void testAjouter(){
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		System.out.println(VIOLET + "=                        		  testAjouter                    =" + SUPPR);
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		// Cas normal : un temps en milisecondes
		System.out.println(BLEU + "Cas normal : un temps en milisecondes" + SUPPR);
		testCasAjouter(new Duree (99), new Duree(1), new Duree(100));
		System.out.println();
		// Cas limite : un temps égal à 0
		System.out.println(BLEU + "Cas limite : un temps égal à 0" + SUPPR);
		testCasAjouter(new Duree(99), new Duree (0), new Duree (99));
		System.out.println();
		// Cas limite : un temps à ajouter negatif
		System.out.println(BLEU + "Cas limite : un temps à ajouter negatif" + SUPPR);
		testCasAjouter(new Duree(99), new Duree (-1), new Duree (99));
		System.out.println();
		// Cas d'erreur : un temps null
		System.out.println(BLEU + "Cas d'erreur : un temps null" + SUPPR);
		testCasAjouter(new Duree(0), null, new Duree (0));
		System.out.println();
	}

	/**
	 * Methode de test pour la methode ajouter
	 *
	 * @param leTemps le temps en milisecondes
	 * @param tempsAajouter le temps à ajouter
	 * @param resAttendu le resultat attendu
	 */
	void testCasAjouter(Duree leTemps, Duree tempsAajouter, Duree resAttendu) {
		leTemps.ajouter(tempsAajouter);

		int tempsFinal = leTemps.getLeTemps();
		int tempsAttendu = resAttendu.getLeTemps();

		if (tempsFinal == tempsAttendu) {
			System.out.print("le temps : " + tempsFinal + "\t" + "resultat attendu : " + tempsAttendu);
			System.out.println(VERT + "\t" + "OK" + SUPPR);

		} else {
			System.out.print("le temps : " + tempsFinal + "\t" + "resultat attendu : " + tempsAttendu);
			System.err.println(ROUGE + "\t" + "ERREUR" + SUPPR);
		}
	}

	// ========================= testSoustraire =========================

	/**
	 * Methode de test pour la methode soustraire
	 */
	void testSoustraire(){
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		System.out.println(VIOLET + "=                     testSoustraire                  		         =" + SUPPR);
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		// Cas normal : un temps en milisecondes
		System.out.println(BLEU + "Cas normal : un temps en milisecondes" + SUPPR);
		testCasSoustraire(new Duree (99), new Duree(1), new Duree(98));
		System.out.println();
		// Cas limite : un temps égal à 0
		System.out.println(BLEU + "Cas limite : un temps égal à 0" + SUPPR);
		testCasSoustraire(new Duree(99), new Duree (0), new Duree (99));
		System.out.println();
		// Cas limite : un temps à soustraire negatif
		System.out.println(BLEU + "Cas limite : un temps à soustraire negatif" + SUPPR);
		testCasSoustraire(new Duree(99), new Duree (-1), new Duree (99));
		System.out.println();
		// Cas d'erreur : un temps à soustraire negatif et plus grand que le temps initial
		System.out.println(BLEU + "Cas d'erreur : un temps à soustraire negatif et plus grand que le temps initial" + SUPPR);
		testCasSoustraire(new Duree(99), new Duree (-100), new Duree (99));
		System.out.println();
		// Cas d'erreur : un temps null
		System.out.println(BLEU + "Cas d'erreur : un temps null" + SUPPR);
		testCasSoustraire(new Duree(0), null, new Duree (0));
		System.out.println();
	}

	/**
	 * Methode de test pour la methode soustraire
	 *
	 * @param leTemps le temps en milisecondes
	 * @param autreDuree le temps à soustraire
	 * @param resAttendu le resultat attendu
	 */
	void testCasSoustraire(Duree leTemps, Duree autreDuree, Duree resAttendu) {
		leTemps.soustraire(autreDuree);

		int tempsFinal = leTemps.getLeTemps();
		int tempsAttendu = resAttendu.getLeTemps();

		if (tempsFinal == tempsAttendu) {
			System.out.print("le temps : " + tempsFinal + "\t" + "resultat attendu : " + tempsAttendu);
			System.out.println(VERT + "\t" + "OK" + SUPPR);

		} else {
			System.out.print("le temps : " + tempsFinal + "\t" + "resultat attendu : " + tempsAttendu);
			System.err.println(ROUGE + "\t" + "ERREUR" + SUPPR);
		}
	}

	// ========================= testCompareA =========================

	/**
	 * Methode de test pour la methode compareA
	 */
	void testCompareA(){
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		System.out.println(VIOLET + "=                     testCompareA                  		         =" + SUPPR);
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		// Cas normal : si la durée courante est + petite que autreDuree
		System.out.println(BLEU + "Cas normal : si la durée courante est + petite que autreDuree" + SUPPR);
		testCasCompareA(new Duree (99), new Duree(100), -1);
		System.out.println();
		// Cas normal : si la durée courante est égale à autreDuree
		System.out.println(BLEU + "Cas normal : si la durée courante est égale à autreDuree" + SUPPR);
		testCasCompareA(new Duree (100), new Duree(100), 0);
		System.out.println();
		// Cas normal : si la durée courante est + grande que autreDuree
		System.out.println(BLEU + "Cas normal : si la durée courante est + grande que autreDuree" + SUPPR);
		testCasCompareA(new Duree (100), new Duree(99), 1);
		System.out.println();
		// Cas limite : un temps égal à 0
		System.out.println(BLEU + "Cas limite : un temps égal à 0" + SUPPR);
		testCasCompareA(new Duree(0), new Duree(0), 0);
		System.out.println();
		// Cas d'erreur : un temps à comparer negatif
		System.out.println(BLEU + "Cas d'erreur : un temps à comparer negatif" + SUPPR);
		testCasCompareA(new Duree(99), new Duree(-1), 1);
		System.out.println();
		// Cas d'erreur : un temps null
		System.out.println(BLEU + "Cas d'erreur : un temps null" + SUPPR);
		testCasCompareA(new Duree(100), null, -2);
		System.out.println();
	}

	/**
	 * Methode de test pour la methode compareA
	 *
	 * @param leTemps le temps en milisecondes
	 * @param autreDuree le temps à comparer
	 * @param resAttendu le resultat attendu
	 */
	void testCasCompareA(Duree leTemps, Duree autreDuree, int resAttendu) {
		int resObtenu = leTemps.compareA(autreDuree);

		if (resObtenu == resAttendu) {
			System.out.print("le resultat obtenu : " + resObtenu + "\t" + "resultat attendu : " + resAttendu);
			System.out.println(VERT + "\t" + "OK" + SUPPR);

		} else {
			System.out.print("le resultat obtenu : " + resObtenu + "\t" + "resultat attendu : " + resAttendu);
			System.err.println(ROUGE + "\t" + "ERREUR" + SUPPR);
		}
	}

	// ========================= testEnTexte =========================

	/**
	 * Methode de test pour la methode enTexte
	 */
	void testEnTexte() {
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		System.out.println(VIOLET + "=                     testEnTexte                  		         =" + SUPPR);
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		// Cas normal : mode 'J'
		System.out.println(BLEU + "Cas normal : un temps en milisecondes, format 'J'" + SUPPR);
		testCasEnTexte(new Duree(158400000), 'J', "01 jours 20 h");
		System.out.println();
		// Cas normal : mode 'H'
		System.out.println(BLEU + "Cas normal : un temps en milisecondes, mode 'H'" + SUPPR);
		testCasEnTexte(new Duree(158400000), 'H', "44:00:00");
		System.out.println();
		// Cas normal : mode 'M'
		System.out.println(BLEU + "Cas normal : un temps en milisecondes, mode 'M'" + SUPPR);
		testCasEnTexte(new Duree(158400000), 'M', "158400000 millisec");
		System.out.println();
		// Cas normal : mode 'S'
		System.out.println(BLEU + "Cas normal : un temps en milisecondes, mode 'S'" + SUPPR);
		testCasEnTexte(new Duree(158400000), 'S', "158400.0 sec");
		System.out.println();
		// Cas normal : mode 'incorrect'
		System.out.println(BLEU + "Cas d'erreur : un temps en milisecondes, mode incorrect 'T'" + SUPPR);
		testCasEnTexte(new Duree(158400000), 'T', "null");
		System.out.println();
	}

	/**
	 * Methode de test pour la methode enTexte
	 *
	 * @param leTemps le temps en milisecondes
	 * @param mode le mode
	 * @param resAttendu le resultat attendu
	 */
	void testCasEnTexte(Duree leTemps, char mode, String resAttendu) {
		String resObtenu = leTemps.enTexte(mode);

		if (resObtenu != null && resObtenu.equals(resAttendu)) {
			System.out.print("le resultat obtenu : " + resObtenu + "\t" + "resultat attendu : " + resAttendu);
			System.out.println(VERT + "\t" + "OK" + SUPPR);

		} else if (resObtenu == null && resAttendu == "null"){
			System.out.print("le resultat obtenu : " + resObtenu + "\t" + "resultat attendu : " + resAttendu);
			System.out.println(VERT + "\t" + "OK" + SUPPR);

		} else {
			System.out.print("le resultat obtenu : " + resObtenu + "\t" + "resultat attendu : " + resAttendu);
			System.err.println(ROUGE + "\t" + "ERREUR" + SUPPR);
		}
	}
}