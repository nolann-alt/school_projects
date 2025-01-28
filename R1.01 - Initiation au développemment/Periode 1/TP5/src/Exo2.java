/**
 * Programme effectuant plusieurs méthodes de modification de tableau
 * @author N.LESCOP 
 */

class Exo2 {
	void principal() {
		int tab[] = {3, 10, 6, 20, 7};
		int copieTab[] = new int [tab.length];
		
		for (int i = 0; i < tab.length; i++) {
			copieTab[i] = tab[i];
		}
			
		System.out.print("decalerGauche Avant : ");
		displayTab(tab);
		System.out.println();
		System.out.print("decalerGauche Après : ");
		decalerGauche(tab);
		displayTab(tab);

		System.out.println();
		System.out.println();
		
		tab  = copieTab;
		
		System.out.print("decalerGaucheN Avant : ");
		displayTab(tab);
		System.out.println();
		System.out.print("decalerGaucheN Après : ");
		decalerGaucheN(tab, 3);
		displayTab(tab);
		
		System.out.println();
		System.out.println();
		
		System.out.print("Le tableau est : ");
		displayTab(tab);
		System.out.println();
		
		int indice1 = indiceTab(tab, 7);
		System.out.print("Indice 7 : tab[" + indice1 + "]");
		
		System.out.println();
		
		indice1 = indiceTab(tab, 8);
		System.out.print("Indice 8 : tab[" + indice1 + "]");
		
		System.out.println();
		System.out.println();
		
		System.out.print("Le tableau est : ");
		displayTab(tab);
		System.out.println();
		
		decaleValeur(tab, 8);
		System.out.print("decaleValeur (8) : ");
		displayTab(tab);
		
		System.out.println();
		
		decaleValeur(tab, 7);
		System.out.print("decaleValeur (7) : ");
		displayTab(tab);
	}
	
	/**
	* décale les entiers d’un tableau d’une position vers la gauche
	* L’élément en 0 se retrouve à la fin du tableau
	* @param tab tableau d’entiers
	*/
	void decalerGauche (int[] tab) {
		int premierELement = tab[0];
		for (int i = 0; i < tab.length-1; i++){
			tab[i] = tab[i+1];
		}
		tab[tab.length-1] = premierELement;
	}
	
	/**
	* décale les entiers d’un tableau de n positions vers la gauche
	* @param tab tableau d’entiers
	* @param n entier nombre de cases à décaler
	*/
	void decalerGaucheN (int[] tab, int n){
		for (int i = 0; i < n; i++){
			decalerGauche(tab);
		}
	}
	
	/**
	* cherche l’indice de la premiere occurrence d’une valeur dans un tableau
	* @param tab tableau d’entiers
	* @param v valeur à chercher
	* @return l’indice de la première valeur v dans tab si v est dans tab, -1 sinon
	*/
	int indiceTab (int[] tab, int v) {
		int resultat = -1;
		
		for (int i = 0; i < tab.length; i++){
			if (tab[i] == v && resultat == -1){
				resultat = i;
			
			}	
		}
		return resultat;
	}
	
	/**
	* décale les valeurs d’un tableau de manière à ramener la valeur cherchée
	* à l’indice 0
	* Si la valeur n’est pas présente, le tableau n’est pas modifié
	* @param tab tableau d’entiers
	* @param v valeur à chercher
	*/
	void decaleValeur (int[] tab, int v) {
		for (int j = 0; j < tab.length; j++){
			if (tab[j] == v){
				for (int i = 0; tab[0] != v; i++){
				decalerGauche(tab);
				}
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
		System.out.print(t[i]+"} ");

	}	
}
