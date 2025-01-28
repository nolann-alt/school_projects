/**
* @author Nolann
*/
class Rayon{
	void principal(){
		int rayon;
		double aire;
		double périmètre;
		rayon = SimpleInput.getInt("Rayon du cercle (cm) :");
		aire = 3.14 * (rayon*rayon);
		périmètre = 2 * 3.14 * rayon; 
		System.out.println ("Aire du cercle : "+ aire + " cm carré");
		System.out.println ("Périmètre du cercle : "+ périmètre + " cm");	
		
	}
}
