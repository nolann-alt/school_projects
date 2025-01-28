/**
 * Programme qui cherche combien de fois un caractère est présent dans une chaîne de caractères
 * @author N.LESCOP
 */

class Exo5 {
	void principal() {
		testNbOcc();
		
	}
	
	/**
	* cherche combien de fois un caractère est présent dans une chaîne de caractères
	* @param chaine Chaine de caractère
	* @param char Caractere a rechercher
	* @return nombre d’occurences de car dans chaine
	*/
	int nbOcc (String chaine, char c) {
		int result = 0;
		
		for (int i = 0; i < chaine.length(); i++) { //Parcourir la chaîne de caractère
			
			if (chaine.charAt(i) == c){ //si un caractère de la chaine est égal au caractère de la variable c
				result = result + 1;
			}
			
		}
		return result;	
	
	}	
		
	/**
	* Teste la méthode NbOcc()
	*/
	void testNbOcc () {
		System.out.println ();
		System.out.println ("*** testNbOcc)");
		testCasNbOcc ("hello", 'l', 2 );
		testCasNbOcc ("programme", 'm', 2 );
		testCasNbOcc ("aaaaa", 'a', 5 );
		
	}
	
	/**
	* teste un appel de NbOcc
	* @param chaine Chaine de caractère
	* @param char Caractere a rechercher
	* @param result est le résultat attendu
	* 
	*/
	void testCasNbOcc (String chaine, char c, int result) {
		// Affichage
		System.out.print("nbOcc(" + chaine + ", " + c + ")" + "\t = " + result + " : ");
		// Appel
		int resExec = nbOcc(chaine, c);
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}	
	
		
}
