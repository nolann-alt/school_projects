/**
 * Programme affichant un Morpion jouable
 * @author N.LESCOP
 */

class Morpion {
	void principal() {
		char[][] morpion = {{'X','O','X'},{' ','X',' '},{'O','O',' '}};
		affichePlateau(morpion);
	}
	
	/**
	* Affichage du plateau de Morpion avec les indices de lignes
	* et de colonnes
	* @param plateau le tableau a afficher
	*/
	void affichePlateau(char[][] plateau) {
		for(int i = 0; i < plateau.length; i++){
			for (int j = 0; j < plateau[i].length; j++){
				System.out.print(plateau[i][j]);
				
			}
		}
		
	}
}
