/**
 * Programme qui test un nombre entier tel que la somme de ses diviseurs (autres que lui-même) est égale à ce nombre.
 * @author 
 */

class Exo3 {
	void principal() {
		testEstParfait();
		quatreNbParfaits();
	}
	
	/**
	* teste si un nombre est parfait
	* @param a entier positif
	* @return vrai ssi a est un nombre parfait
	*/
	boolean estParfait (int a) {
		int somme = 0;
		
		for (int i = 1; i < a; i++) {
			if (estDiviseur(a, i)){
				somme = somme + i;
			}
			
		}
		return somme == a; //retourne la valeur de a lorsque i >= a
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
	* Teste la méthode estParfait()
	*/
	void testEstParfait() {
		System.out.println ();
		System.out.println ("*** testestParfait()");
		testCasEstParfait (6, true); //somme des diviseurs doit être égale à 6
		testCasEstParfait (28, true);
		testCasEstParfait (27, false);
		
	}
	
	/**
	* teste un appel de estParfait
	* @param a un entier positif
	* @param result est le résultat attendu
	* 
	*/
	void testCasEstParfait (int a, boolean result) {
		// Affichage
		System.out.print ("(" + a + ") " + "est Parfait ?"+ " \t= " + result + "\t : ");
		// Appel
		boolean resExec = estParfait(a);
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}	
	
	/**
	* Affiche les quatre premiers nombres parfaits
	*/
	void quatreNbParfaits(){
		int compteur = 0; //Compteur pour savoir le nombre de nombre parfaits trouvé
		int nombre = 1; //Le premier nombre à tester
		
		while (compteur < 4) {
			if (estParfait(nombre)){
				compteur = compteur + 1;
				System.out.println("Nombre parfait : " + nombre);
			
			}
			nombre = nombre + 1; // On teste le nombre suivant
				
		}	
		
	}	
	
	
	
}
