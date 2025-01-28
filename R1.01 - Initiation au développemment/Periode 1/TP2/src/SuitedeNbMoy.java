/**
* S’arrête quand l’utilisateur écrit -1
* @author Nolann
*/
class SuitedeNbMoy {
	void principal () {
		int nb;;
		double moy;
		double somme;
		int i;
		
		i=1;
		moy =0;
		nb = SimpleInput.getInt ("Donner un nombre entier: ");
		somme = 0;
		
		while (nb != -1) {
			somme = (somme + nb);
			i = i+1;
			System.out.println(somme);
			nb =SimpleInput.getInt ("Donner un nombre entier : ");
		}
		if (somme == -1) {
			System.out.println("Aucune valeur saisie");
		
		}else{
			System.out.println ("Fin du programme");
			moy = (somme / (i-1));
			System.out.println ("Moyenne: " + moy);
		}
	}
}
