/**
 * Programme décalant d'une case vers la fin le contenu d'un tableau int [] déjà saisi
 * @author Nolann
 */

class décalage {
	void principal() {
			
			int [] t = {5, 7, 0, 6, 10, 8, 4, 1};
			System.out.print("Avant : ");
			displayTab(t);
			
			int i = (t.length-1); // i = 7 soit le ddeuxième élément
			int dernierélement = t[t.length-1]; // dernierélément = 1
						
			while (i > 0) { // tant que i est inférieur à 8
				t[i] = t[i-1]; // t[i] soit 1 = t[i-1] soit 4 le terme avant dans le tabelau
				i--; // 7-1=6

			}
			t[0] = dernierélement; // t[0] = 5
			System.out.print("Après : ");
			displayTab(t);
			
		
	}
	void displayTab (int [] t){
		int i = 0;
		System.out.print("{");
		
		while(i<t.length-1){
			System.out.print(t[i] + ",");
			i=i+1;
		}
		System.out.println(t[i]+"}");

	}
}
