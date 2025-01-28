/**
* @author Nolann
*/
class Syntaxe{
	void principal(){

		int val1, Val2;
		int val3;

		val1 = SimpleInput.getInt("Premier entier :");
		Val2 = SimpleInput.getInt("Deuxième entier :");
		val3 = SimpleInput.getInt("Troisième entier :");

		if (val1<val3&&Val2<val3) {
			System.out.println("Le troisième entier " + val3 + " est le plus grand ");
		} else if (val1<Val2&&val3<Val2) {
			System.out.println("Le deuxième entier " + Val2 + " est le plus grand ");
		} else if (Val2<val1&&val3<val1) {
			System.out.println("Le premier entier " + val1 + " est le plus grand ");
		}
	}
}
