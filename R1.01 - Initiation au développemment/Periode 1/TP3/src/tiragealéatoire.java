/**
 * programme qui tire aléatoirement 1000 entiers entre 0 et 9 (inclus) et qui stocke dans un tableau le nombre de fois où chaque valeur a été tirée. 
 * @author Nolann
 */

class tiragealéatoire {
	void principal() {
		
		int t [] = new int [10];
		int aléatoire;
		
		
		int i;
		
		for (i = 1; i <= 1000; i++){
			aléatoire = (int) (Math.random()*10);
			
			if (aléatoire == 0){
				t[0] = t[0] + 1;
				
			}else if (aléatoire == 1){
				t[1] = t[1] + 1;
				
			}else if (aléatoire == 2){
				t[2] = t[2] + 1;
				
			}else if (aléatoire == 3){
				t[3] = t[3] + 1;
			
			}else if (aléatoire == 4){
				t[4] = t[4] + 1;

			}else if (aléatoire == 5){
				t[5] = t[5] + 1;
				
			}else if (aléatoire == 6){
				t[6] = t[6] + 1;
				
			}else if (aléatoire == 7){
				t[7] = t[7] + 1;
				
			}else if (aléatoire == 8){
				t[8] = t[8] + 1;
				
			}else if (aléatoire == 9){
				t[9] = t[9] + 1;

			}
			
		}
		System.out.print("Voici le nombre de tirages pour respectivement les valeurs suivantes : {0, 1, 2, 3, 4, 5, 6, 7, 8, 9} : ");
		displayTab (t);
	
		
		
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
