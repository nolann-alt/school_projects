/**
 * Programme choisissant aléatoirement un nombre entre 0 (inclus) et 100 (exclus) afin d'être deviné par l'utilisateur
 * @author Nolann
 */

class MathRandom {
	void principal() {
		int nb;
		int aléatoire;
		
		aléatoire = (int) (Math.random() * 100);
		nb = SimpleInput.getInt("Choisissez un nombre entre 0 (inclus) et 100 (exclus): ");
		
		if (nb >= 0 && nb <100){
			while (nb != aléatoire){
				nb = SimpleInput.getInt("Choisissez un nombre entre 0 (inclus) et 100 (exclus): ");
			}
			System.out.println("Bravo, vous avez trouvé !");
		
		}else{
			System.out.println("Nombre incorrect");
		}
	}
		
}
