/**
 * Programme qui vérifie si deux tableaux n’ont aucun entier en commun.
 * @author N.LESCOP
 */

class Exo1 {
	void principal() {
		testsontTousDiff();
	}
	/**
	* vérifie si deux tableaux n’ont aucune valeur commune
	* @param tab1 premier tableau
	* @param tab2 deuxième tableau
	* @return vrai si les tableaux tab1 et tab2 n’ont aucune valeur commune, faux sinon
	*/
	boolean sontTousDiff (int[] tab1, int[] tab2) {
		boolean difference = true;
		
		if (tab1.length == 0 || tab2.length == 0){
			difference = true;
		
		}
		for (int i = 0; i < tab1.length; i++){
				for (int j = 0; j < tab2.length; j++){
					if (tab1[i] == tab2[j]){
						difference = false;
					}
				}
			
		}
		return difference; 
		
	}


	/**
	* Teste la méthode sontTousDiff()
	*/
	void testsontTousDiff() {
		System.out.println ();
		System.out.println ("*** testsontTousDiff()");
		testCasSontTousDiff (new int [] {1, 2, 3, 4, 5, 6}, new int [] {1, 2, 3, 4, 5, 6}, false);
		testCasSontTousDiff (new int [] {1, 2, 3}, new int [] {4, 5, 6}, true);
		testCasSontTousDiff (new int [] {1, 2, 3, 4, 5}, new int [] {5, 6, 7, 8}, false);
		testCasSontTousDiff (new int [] {}, new int [] {}, true);
		
	}
	
	/**
	* teste un appel de sontTousDiff
	* @param tab1 premier tableau
	* @param tab2 deuxième tableau
	* @param result est le resultat attendu
	*/
	void testCasSontTousDiff (int[] tab1, int[] tab2, boolean result) {
		// Affichage
		if (tab1.length == 0 || tab2.length == 0){
			System.out.print("SontTousDiff (");
			System.out.print("{}");
			System.out.print(", ");
			System.out.print("{}");
			System.out.print(")");
			System.out.print("\t = " + result + " : ");
			System.out.println("OK");
		}else{
			System.out.print("SontTousDiff (");
			displayTab(tab1);
			System.out.print(", ");
			displayTab(tab2);
			System.out.print(")");
			System.out.print("\t = " + result + " : ");
			// Appel
			boolean resExec = sontTousDiff(tab1, tab2);
			// Verification
			if (resExec == result){
				System.out.println ("OK");
			} else {
				System.err.println ("ERREUR");
			}
		}
		
	}	
	
	/**
	* Affiche un tableau
	*/ 
	void displayTab (int [] t){
		int i = 0;
		System.out.print("{");
		
		while(i<t.length-1){
			System.out.print(t[i] + ",");
			i=i+1;
		}
		System.out.print(t[i]+"}");

	}	
	
}
