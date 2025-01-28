/**
* S’arrête quand l’utilisateur écrit -1
* @author Nolann
*/
class SuitedeNb {
	void principal () {
		int nb;
		nb = SimpleInput.getInt ("Donner un nombre: ");
		while (nb != -1) {
			nb =SimpleInput.getInt ("Donner un nombre : ");
		}
		System.out.println ("Fin du programme");
	}
}
