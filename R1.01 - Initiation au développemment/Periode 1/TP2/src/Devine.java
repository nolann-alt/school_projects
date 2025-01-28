/**
 * Programme devinant un chiffre entre 0 et 1000 choisi par l'utilisateur
 * @author Nolann
 */

class Devine {
	void principal() {
		int proposition;
		int valMax;
		int valMin;
		char plus = '+';
		char moins = '-';
		char égal = '=';
		char réponse;
		char pensez;
		
		
		valMin = 0;
		valMax = 1001;
		réponse = ' ';
		proposition = (int) (Math.random() * (valMax - valMin)); // générer aléatoirement un nombre entre 0 et 1000
		
		pensez = SimpleInput.getChar("Pensez à un nombre entre 0 et 1000 et écrivez (1) lorsque c'est bon: ");
		
		if (pensez == '1'){ // condition de démarrage du programme
			
			System.out.println("Proposition: " + proposition);
			réponse = SimpleInput.getChar("La proposition est-elle supérieure (+), inférieur (-) ou égal (=) ? ");
			
			if ( réponse == '+' || réponse == '-' || réponse == '='){
				
				do{
					
				if(réponse == '-'){ // si la réponse est un "-"
					valMin = proposition;
					proposition = (int) (Math.random() * (valMax - valMin) + valMin);
					System.out.println("Proposition: " + proposition);
					réponse = SimpleInput.getChar("La proposition est-elle supérieure (+), inférieur (-) ou égal (=) ? ");
					
				}else if (réponse == '+'){ // si la réponse est un "+"
					valMax = proposition;
					proposition = (int) (Math.random() * (valMax - valMin) + valMin);
					System.out.println("Proposition: " + proposition);
					réponse = SimpleInput.getChar("La proposition est-elle supérieure (+), inférieur (-) ou égal (=) ? ");
				}
					
				}while (réponse != '=' ); 
			
				System.out.println("Le nombre a été deviné !");
				
			}else{
				System.out.println("Vous n'avez pas entrez le bon caractère !");
			}	
							
		}else{
			System.out.println("Vous n'avez pas entré le chiffre (1)");
		
		}
		
	}

}
