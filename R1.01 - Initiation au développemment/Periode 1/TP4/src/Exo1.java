/**
 * Programme calculant les factorielles de plusieurs nombres
 * @author N.LESCOP
 */

class Exo1 {
	void principal() {
		testFactorielle();
		testCombinaison();
		
	}
	/**
	* calcul de la factorielle du paramètre
	* @param n valeur de la factoriel à calculer, n>=0
	* @return factorielle de n
	*/
	int factorielle (int n) {
		int result = 1;
		
		for (int i=1; i <= n; i++){
			result = result * i;
		}
		return result;
	}
		
	
	
	
	/**
	* calcul de la combinaison k parmi n
	* @param n cardinalité de l’ensemble
	* @param k nombre d’éléments dans n avec 0<=k<=n
	* @return nombre de combinaisons de k parmi n
	*/
	int combinaison (int n, int k){
		
		return (factorielle(n) / (factorielle(k)*(factorielle (n-k))));
	}
	
	/**
	* Teste la méthode factorielle()
	*/
	void testFactorielle () {
		System.out.println ();
		System.out.println ("*** testFactorielle()");
		testCasFactorielle (5, 120);
		testCasFactorielle (0, 1);
		testCasFactorielle (1, 1);
		testCasFactorielle (2, 2);
	}
	
	/**
	* teste un appel de factorielle
	* @param n valeur de la factorielle à calculer
	* @param result resultat attendu
	*/
	void testCasFactorielle (int n, int result) {
		// Affichage
		System.out.print ("factorielle (" + n + ") \t= " + result + "\t : ");
		// Appel
		int resExec = factorielle(n);
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}	
	
	
	/**
	* Teste la méthode Combinaison()
	*/
	void testCombinaison () {
		System.out.println ();
		System.out.println ("*** testCombinaison()");
		testCasCombinaison (5, 3, 10); // C(5, 3) = 10
		testCasCombinaison (6, 2, 15);
		testCasCombinaison (4, 2, 6);
		testCasCombinaison (5, 0, 1);
		
	}
	
	/**
	* teste un appel de Combinaison
	* @param n valeur de la combinaison à calculer
	* @param k valeur de la combinaison (k < n)
	* @param result résultat attendu
	*/
	void testCasCombinaison (int n, int k, int result) {
		// Affichage
		System.out.print ("combinaison (" + n +", " + k + ") \t= " + result + "\t : ");
		// Appel
		int resExec = combinaison(n, k);
		//Verfication
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");

		}
		
	}
}	
