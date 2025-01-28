/**
 * Rôle à deviner
 * @author Nolann
 */

class AdevinerWhile {
	
	void principal() {
		int val1;
		int val2;
			
		val1 = SimpleInput.getInt ("Première valeur positive: ");
		val2 = SimpleInput.getInt ("Deuxième valeur positive: ");
			
		while (val1 < 0 || val2 < 0){

			val1 = SimpleInput.getInt ("Première valeur positive: ");
			val2 = SimpleInput.getInt ("Deuxième valeur positive: ");
		
		}		
		while (val1 != val2) {
			if (val1 > val2) {
				val1 = val1 - val2;
			} else {
				val2 = val2 - val1;
			}
		}
		System.out.println("Le pgcd est : " + val1);
		
	}
}


