/**
 * Programme qui détermine la longueur de la plus grande séquence croissante d’un tableau int[] t déjà saisi et qui donne l'indice de début et de fin de la plus grande suite croissante
 * @author Nolann
 */

class indice {
	void principal() {
		
		int t[] = {5, 7, 9, 10, 10, 12, 4, 1};
		System.out.print("Voici le tableau : ");
		displayTab (t);
		int min = 1; // longueur minimal d'un séquence croissante
		int longueur1 = 1; // variable pour la longueur de la séquence max
		int i = 1;
		
		boolean terminaison;
		int arrêt = 0; 
		
		int indice1 = 0;
		int indice2 = 0;
		int indice1provisoire = 0;
		
		terminaison = true;
		
		while (i < t.length && terminaison){
			
			if (t[i] > t[i-1]){
				longueur1 ++; // on augmente la longueur de la séquece de +1
			
			}else{
				
				if (longueur1 > min){
					min = longueur1; // la longueur min deviens la plus grande séquence croissante
					indice1 = indice1provisoire;
					indice2 = i-1;
					arrêt = t[i-1];
				}
				
				if (min >= (t.length / 2)) { // Si la séquence est suffisamment longue on sort de du tabelau
					terminaison = false;
				}

				longueur1 = 1; // recommencer à 1 afin de chercher une autre séquence croissante plus longue
				indice1provisoire = i;
		
			}
			i++;
		}
	
		if (longueur1 > min){ // si la longueur 1 est supèrieur à la longeur minimal de la séquence croissante
			min = longueur1; // la longueur min deviens la plus grande séquence croissante
			indice1 = indice1provisoire; // misa à jour de l'indice de début de la plus grande séquence croisante
			arrêt = t[indice2];
		}	

		System.out.println("La plus grande séquence croissante dans le tableau est de : " + min);
		System.out.println("De l'indice " + indice1 + " à l'indice " + indice2 );
		System.out.println("La séquence croissante c'est arrêtée à t["+ indice2 +"] = " + arrêt);
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
