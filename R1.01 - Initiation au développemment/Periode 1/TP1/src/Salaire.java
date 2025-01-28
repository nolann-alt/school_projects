/**
* @author Nolann
*/
class Salaire{
	void principal(){
		double salbrut;
		double assurancemaladie;
		double assurancevieillessedéplafonnée;
		double assurancevieillesseplafonnée;
		double fraispro;
		double contributionsocialegénérailisée;
		double crds;
		double chômage;
		double total;
		double totalnet;
		salbrut = SimpleInput.getDouble("Entrez votre salaire brut (euros): ");
		
		assurancemaladie = (salbrut * (0.75/100));
		System.out.println ("Assurance Maladie: "+ assurancemaladie + " euros");
		
		assurancevieillessedéplafonnée = (salbrut * (0.1/100));
		System.out.println ("Assurance Vieillesse Déplafonnée: "+ assurancevieillessedéplafonnée + " euros");
		
		assurancevieillesseplafonnée = (salbrut * (6.75/100));
		System.out.println ("Assurance Vieillesse Plafonnée: "+ assurancevieillesseplafonnée + " euros");
		
		fraispro = (salbrut * (1.75/100));
		System.out.println ("Frais Professionnels: "+ fraispro + " euros");
		
		contributionsocialegénérailisée = ((salbrut - fraispro) * (7.5/100));
		System.out.println ("Contribution Sociale Générailisée: "+ contributionsocialegénérailisée + " euros");
		
		crds = ((salbrut - fraispro) * (0.5/100));
		System.out.println ("CDRS: "+ Math.round(crds) + " euros");
		
		chômage = (salbrut * (2.4/100));
		System.out.println ("Chômage: "+ chômage + " euros");
		
		total = (assurancemaladie + assurancevieillessedéplafonnée + assurancevieillesseplafonnée + fraispro + contributionsocialegénérailisée + crds + chômage);
		System.out.println ("Total: " + total + " euros");
		
		totalnet = (salbrut - (assurancemaladie + assurancevieillessedéplafonnée + assurancevieillesseplafonnée + fraispro + contributionsocialegénérailisée + crds + chômage));
		System.out.println ("Salaire Net: " + totalnet + " euros");
			
	}	
}		
		
