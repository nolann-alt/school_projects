/**
 * Programme qui teste si les valeurs d’un tableau sont triées par ordre croissant.
 * @author N.LESCOP
 */

class Exo4 {
	
	void principal() {
		testEstCroissant();
	}
	
	/**
	* teste si les valeurs d’un tableau sont triées par ordre croissant
	* @param t tableau d’entiers
	* @return vrai ssi les valeurs du tableau sont en ordre croissant
	*/
	boolean estCroissant (int[] t) {
		boolean result = true;
		
		for (int i = 0; i < t.length-1; i++){
			
			if (t[i] > t[i+1]){
				result = false;
			
			}
		
		}
		return result;
	}
		
	/**
	* Teste la méthode estCroissant()
	*/
	void testEstCroissant () {
		System.out.println ();
		System.out.println ("*** testestCroissant()");
		testCasEstCroissant (new int [] {1,2,4,9,12}, true);
		testCasEstCroissant (new int [] {1,8,10,18}, true);
		testCasEstCroissant (new int [] {1,1,5,7,9}, true);
		testCasEstCroissant (new int [] {1,0,5,7,9}, false);
		
	}
	
	/**
	* teste un appel de estCroissant
	* @param t un tableau avec des valeurs croissantes
	* @param result est le résultat attendu
	* 
	*/
	void testCasEstCroissant (int [] t, boolean result) {
		// Affichage
		displayTab(t); 
		System.out.print("est triée par ordre croissant ?"+ " \t= " + result + "\t : ");
		// Appel
		boolean resExec = estCroissant(t);
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}	
	
	
	void displayTab (int [] t){
		int i = 0;
		System.out.print("{");
		
		while(i<t.length-1){
			System.out.print(t[i] + ",");
			i=i+1;
		}
		System.out.print(t[i]+"} ");

	}	
}
