/**
 * Programme simulant un distributeur automatique
 * @author Nolann 
 */

class Distributeur {
	
	void principal() {
		int prix;
		int montant;
		int montanttotal;
		int ajout;
		int rendu;
		
		montanttotal = 0;
	
		prix = SimpleInput.getInt("Donnez le prix de ce que vous voulez achetez en euros: ");
		montant = SimpleInput.getInt("Donnez le montant que vous voulez entrez dans la machine en euros: ");
		
		montanttotal =  montant;
		
		if (prix <= 0) {
			System.out.println("Vous ne pouvez pas rien achetez, ne rien rendre, ou volez de l'argent au distributeur !");
		
		}else if (montant <= 0){
			System.out.println("Vous ne pouvez pas rien achetez, ne rien rendre, ou volez de l'argent au distributeur !");
				
		}else{
			
			while (montanttotal < prix) {
				ajout = SimpleInput.getInt("Donnez un montant supèrieur au prix de l'article ");
				montanttotal = montanttotal + ajout;
			}
			if (montanttotal == prix) {
				System.out.println("Pas de rendu monnaie");
			
			}else if (montanttotal > prix){
				
				rendu = montanttotal - prix;
				
				while (rendu != 0) {
					if (rendu >= 50){
						rendu = rendu -50;
						System.out.println("Voici un billet de 50 euros");
					
					}else if (rendu >= 20){
						rendu = rendu - 20;
						System.out.println("Voici un billet de 20 euros");
					
					}else if (rendu >= 10){
						rendu = rendu -10;
						System.out.println("Voici un billet de 10 euros");
					
					}else if (rendu >= 5){
						rendu = rendu -5;
						System.out.println("Voici un billet de 5 euros");
					
					}else if (rendu >= 2){
						rendu = rendu -2;
						System.out.println("Voici une pièce de 2 euros");
					
					}else if (rendu >= 1) {
						rendu = rendu -1;
						System.out.println("Voici une pièce de 1 euro");
					
					}else if (rendu == 0){
						System.out.println("La monnaie a été rendu");
					}
				}
			}
			System.out.println("Produit Acheté");
			System.out.println("Monnaie rendu: " + (montanttotal - prix) + " euros");
		}
			
	}
	
}
