/**
 * Programme qui compte le nombre de valeurs différentes dans un tableau passé en paramètre.
 * @author N.LESCOP
 */

class Exo3 {
	void principal() {
		testCompteDiffVal();
	}
	
	/**
	* compte le nombre de valeurs différentes dans un tableau
	* @param tab tableau d’entiers
	* @return le nombre de valeurs différentes du tableau
	*/
	int compteDiffVal(int[] tab) {
		int compteur = 0;
		
		for (int j = 0; j < tab.length; j++){
			boolean unique = true; //La valeur devient unique
			
			for (int i = 0; i < j; i++){
				if (tab[j] == tab[i]) {
					unique = false; //La valeur unique ne devient plus unique et le compteur ne la prendra pas en compte
				}
			}
			
			if (unique){
				compteur ++; //Ajoute 1 au compteur si la valeur du tableau est unique
			}
		
		}
		return compteur;
	}
	
	/**
	* Teste la méthode compteDiffVal()
	*/
	void testCompteDiffVal() {
		System.out.println ();
		System.out.println ("*** testCompteDiffVal()");
		testCasCompteDiffVal (new int [] {0, 0, 2, 3, 0, 2, 1, 3, 3, 0}, 4);
		testCasCompteDiffVal (new int [] {0, 1, 2, 3, 4}, 5);
		testCasCompteDiffVal (new int [] {0, 0, 0, 0, 0}, 1);
		testCasCompteDiffVal (new int [] {}, 0);
		

	}
	
	/**
	* teste un appel de compteDiffVal
	* @param tab tableau d’entiers
	* @param result est le resultat attendu
	*/
	void testCasCompteDiffVal (int[] tab, int result) {
		int i = 0;
		// Affichage
		if (i == tab.length){
			System.out.print("compteDiffVal : ");
			System.out.print("{}");
			System.out.print("\t = " + result + " : ");
			System.out.println("OK");
		
		}else{
			System.out.print ("compteDiffVal :");
			displayTab(tab);
			System.out.print("\t= " + result + "\t : ");
			// Appel
			int resExec = compteDiffVal(tab);
			//Verfication
			if (resExec == result){
				System.out.print ("OK");
			} else {
				System.err.print ("ERREUR");

			}
			System.out.println();
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
