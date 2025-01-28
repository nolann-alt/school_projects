	/**
	 * Programme qui détermine si une chaîne est présente dans une autre
	 * @author N.LESCOP
	 */

	class Exo4 {
		void principal() {
			testEstSousChaine();
		}
		
		/**
		 * teste si une chaîne est une sous-chaîne d’une autre
		 * @param mot chaîne de caractères
		 * @param phrase chaîne de caractères
		 * @return vrai si mot est présent dans phrase
		 */
		boolean estSousChaine(String mot, String phrase) {
			boolean presence = false;

			int i = 0;
			while (i <= phrase.length() - mot.length()) { 
				boolean correspondance = true;
				
				int j = 0; 
				
				while (j < mot.length() && correspondance) {
					if (phrase.charAt(i + j) != mot.charAt(j)) { 
						correspondance = false;
					}
					j++;
				}
				
				if (correspondance) {
					presence = true;
				}
				
				i++;
			}
    
    return presence; 
}

		
		/**
		* Teste la méthode estSousChaine()
		*/
		void testEstSousChaine() {
			System.out.println ();
			System.out.println ("*** testEstSousChaine()");
			testCasEstSousChaine("ses", "abcdsesdef", true);
			testCasEstSousChaine("ses", "abcdef", false);
			testCasEstSousChaine("ses", "abcdefse", false);
			

		}
		
		/**
		* teste un appel de compteDiffVal
		* @param tab tableau d’entiers
		* @param result est le resultat attendu
		*/
		void testCasEstSousChaine (String mot, String phrase, boolean result) {
			// Affichage
			System.out.print ("estSousChaine : le mot '" + mot + "' est dans la phrase : " + phrase);
			System.out.print("\t= " + result + "\t : ");
			// Appel
			boolean resExec = estSousChaine(mot, phrase);
			//Verfication
			if (resExec == result){
				System.out.print ("OK");
			} else {
				System.err.print ("ERREUR");
			}
			System.out.println();
		}
				
		
		
	}
