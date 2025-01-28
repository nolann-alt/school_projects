/**
 * Programme s'arrêtant si le nombre saisi est supèrieur au précédent
 * @author Nolann
 */

class Inferieur {
	
	void principal() {
		int val1;
		int val2;
		
		val1 = SimpleInput.getInt("Donnez un premier nombre: ");
		val2 = SimpleInput.getInt("Donnez un deuxième nombre: ");
		
		while (val2 > val1) {
			val1 = val2;
			val2 = SimpleInput.getInt("Donnez un autre nombre: ");
		
		}
		if (val1 == val2){
			System.out.println("Ne donnez pas 2 fois le même nombre");
		
		}else{
			System.out.println("Nombre inférieur au précédent");
		}
	}
}

