/**
 * Programme s'arrêtant si le nombre saisi est supèrieur au précédent
 * @author 
 */

class Superieur {
	
	void principal() {
		int val1;
		int val2;
		
		val1 = SimpleInput.getInt("Donnez un premier nombre: ");
		val2 = SimpleInput.getInt("Donnez un deuxième nombre: ");
		
		while (val2 <= val1) {
			val1 = SimpleInput.getInt("Donnez un premier nombre: ");
			val2 = SimpleInput.getInt("Donnez un deuxième nombre: ");
		
		}
		System.out.println("Nombre supèrieur au précédent");
	}
}

