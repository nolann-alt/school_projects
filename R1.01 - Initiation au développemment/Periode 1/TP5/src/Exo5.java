/**
 * Programme qui trie un tableau par ordre croissant
 * @author N.LESCOP
 */

class Exo5 {
	final int LG_TAB = 10;  // Taille du tableau définie
	void principal() {
		int tableauTrier[] = saisirEtTrier();
		System.out.print("Voici le tableau trier : ");
		displayTab(tableauTrier);
	}
	
	/**
	* Crée et saisit un tableau trié de LG_TAB entiers
	* @return tableau trié de LG-TAB entiers
	*/
	int[] saisirEtTrier () {
		int[] t = new int[LG_TAB];
		int i = 0;
		
		while (i < t.length) {
			t[i] = SimpleInput.getInt ("Entrer un entier : ");
			
			// insertion de la valeur en ordre croissant dans t
			
			for (int j = i; j > 0 && t[j] < t[j -1]; j--){ 
				
				int temp = t[j]; // variable temporaire pour stocker t[j]
				t[j] = t[j - 1]; 
				t[j -1] = temp;  
				
			}
			i = i + 1;
		}
		return t;
	}
	
	/**
	* Affiche un tableau
	*/ 
	void displayTab (int [] t){
		int i = 0;
		System.out.print("{");
		
		while(i<t.length-1){
			System.out.print(t[i] + ", ");
			i=i+1;
		}
		System.out.print(t[i]+"}");

	}	
}
