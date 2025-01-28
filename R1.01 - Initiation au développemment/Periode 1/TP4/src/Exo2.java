/**
 * Programme qui rend vrai si q divise p, faux sinon.
 * @author N.LESCOP
 */

class Exo2 {
	void principal() {
		testEstDiviseur();
	}
	
	/**
	* teste la divisibilité de deux entiers
	* @param p entier positif à tester pour la divisibilité
	* @param q diviseur strictement positif
	* @return vrai ssi q divise p
	*/
	boolean estDiviseur (int p, int q){
		boolean result = true;
		
		if ( p % q == 0){ // si le résultat de la division de p / q est 0
			result = true;
		
		}else{
			result = false;
		}
		return result;
		
	}
	
	/**
	* Teste la méthode estdiviseur()
	*/
	void testEstDiviseur() {
		System.out.println ();
		System.out.println ("*** testestDiviseur()");
		testCasEstDiviseur (10, 2, true); //resultat = 0
		testCasEstDiviseur (10, 3, false);	
		
	}
	
	/**
	* teste un appel de estDiviseur
	* @param p entier positif à tester pour la divisibilité
	* @param q diviseur strictement positif
	* @param result est le résultat attendu
	*/
	void testCasEstDiviseur (int p, int q, boolean result) {
		// Affichage
		System.out.print ("Le divisieur (" + q + ") " + " divise (" + p +")" + " \t= " + result + "\t : ");
		// Appel
		boolean resExec = estDiviseur(p, q);
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}	
		

		
}
