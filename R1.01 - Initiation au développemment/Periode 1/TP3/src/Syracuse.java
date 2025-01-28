/**
 * Programme qui demande un entier à l’utilisateur. Le programme doit redemander un entier tant que celui entré par l’utilisateur n’est pas strictement positif. Puis, tant que cet entier n’est pas égal à 1, le programme le divise par deux s’il est pair ou le multiplie par trois et lui ajoute un s’il est impair. Ce programme doit afficher le nombre d’étapes pour arriver à la valeur 1 et le nombre maximal rencontré en chemin.
 * @author Nolann
 */

class Syracuse {
	void principal() {
		
		int nb;
		int i = 0;
		int nbmax = 0;
		
		nb = SimpleInput.getInt("Entrez un entier positif : ");
		
		while (nb < 0 || nb == 0){
			nb = SimpleInput.getInt("Entrez un entier positif : ");
			
		}
			
		while (nb != 1){
				
			if (nb % 2 == 0){
				nb = nb / 2;
					
			}else{
				nb = (3 * nb) +1;
			
			}	
			if (nb >= nbmax){
				nbmax = nb;

			}
			i++;
		
		}
		System.out.println("Le nombre d'étapes pour arriver à 1 est de : " + i);	
		System.out.println("Le nombre max rencontrée est : " + nbmax);
		
		
		
	}
}
