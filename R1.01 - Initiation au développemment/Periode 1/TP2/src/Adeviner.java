/**
 * Rôle à deviner
 * @author Nolann
 */

class Adeviner {
	
	void principal() {
		int val1;
		int val2;
			
		val1 = SimpleInput.getInt ("Première valeur : ");
		val2 = SimpleInput.getInt ("Deuxième valeur : ");
			
		while (val1 != val2) {
			if (val1 > val2) {
				val1 = val1 - val2;
			} else {
				val2 = val2 - val1;
			}
		}
		System.out.println("Le résultat est : " + val1);
		
	}
}


