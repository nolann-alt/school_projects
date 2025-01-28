/**
* @author Nolann
*/
class Bowling{
	void principal(){
		int NbQuilles;
		int NbQuilles2;
		NbQuilles = SimpleInput.getInt("Nombre de quilles premier lancer: ");
		if (NbQuilles >= 0 &&  NbQuilles <= 10){
			if (NbQuilles == 10){
				System.out.println ("Strike !");	
			} else {
				NbQuilles2 = SimpleInput.getInt("Nombre de quilles deuxième lancer: ");
				if (NbQuilles + NbQuilles2 <= 10) {
					if (NbQuilles + NbQuilles2 == 10){
						System.out.println ("Spare");
					}else{
						System.out.println ("Vous avez renversée(s): " + (NbQuilles + NbQuilles2) + " quilles");
					}
				}else{
					System.out.println ("Nombres de quilles total incorrect");
				}
			}	
		}else{
			System.out.println ("Nombre Incorrect");
		}
	}
}

