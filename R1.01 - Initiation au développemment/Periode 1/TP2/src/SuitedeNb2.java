/**
* S’arrête quand l’utilisateur écrit -1
* @author Nolann
*/
class SuitedeNb2 {
	void principal () {
		int nb;
		do {
			nb =SimpleInput.getInt ("Donner un nombre : ");
		} while (nb != -1);
		
		System.out.println ("Fin du programme");
	}
}
