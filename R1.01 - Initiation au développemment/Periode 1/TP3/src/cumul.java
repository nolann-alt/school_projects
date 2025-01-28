/**
 * programme qui calcule le cumul des valeurs d’un tableau int[] t dans une tableau int[] cumul
 * @author Nolann
 */

class cumul {
	void principal() {
		
		int nb = SimpleInput.getInt("Entrez le nombre de valeurs que vous voulez dans le tableau (positive): ");
			
		if (nb < 0){
			System.out.println("Valeurs négatives interdites !");
		
		}else{
			
			int t[] = new int [nb];
			int f = 0;
			
			while (f < t.length){
				t[f] = SimpleInput.getInt("Valeur (x): ");
				f++;
			}
			
			System.out.print("Avant : ");
			displayTab (t);
			int cumul1[] = new int[t.length];
			int i = 1;
			
			cumul1[0] = t[0];
			
			while (i < t.length){
				cumul1[i] = (cumul1[i-1] + t[i]);
				i++;
			}
			System.out.print("Après : ");
			displayTab (cumul1);
		}
			
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
