/**
 * Compte le nombre de jours entre deux dates
 * @author Stagiaire LN
 */
class ADebugger {
    
    void principal () {
		System.out.println(nombreJour(14, 06, 2006, 15, 10, 2024));
    }
    
    
    // Pas important mais ne supprimez pas ! 
    
    /**
     * Calcul le nombre d'annee bissextile
     * @param le nombre d'annee
    */ 
    boolean bissextile (int annee){
        return (annee%4 == 0 && annee%100 !=0)||(annee%400 == 0);
    }
    
    // Pas important mais ne supprimez pas ! 
    
    /**
     * calcul le nombre de jour dans une annee en prenant en compte les annee bissextile
     * @param nombre d'annee
    */
    int nombreJourAnnee (int annee){
        int nombreAnnee = 0;
        
        if (bissextile(annee)){
			nombreAnnee = 366;
		
		}else{
			nombreAnnee = 365;
		}
        
        
        
        return nombreAnnee;
    }
       
    // Pas important mais ne supprimez pas ! 
    
    /**
     * Calcul le nombre de jour dans un mois
     * @param nombre de mois
     * @param nombre d'annee
    */
    int nombreJourMois (int mois, int annee){
        int nombreJour = 0;
        
        if (mois == 2){
			if (bissextile(annee)){
				nombreJour = 29;
				
			}else{
				nombreJour = 28;
			}
		}else if(mois <= 7){
			nombreJour = 30 + mois%2;
				
		}else{
			nombreJour = 31 - mois%2;
		
		}	 
        return nombreJour;
        
    }
    
    // C'est celle la qui fait ce que l'on veut !
     
    // Attention : a/b/c est avant d/e/f
    
    /**
     * Calcul le nombre de jour entre 2 dates
     * @param jour de naissance 
     * @param mois de naissance
     * @param annee de naissance
     * @param jour actuel
     * @param mois actuel
     * @param annee actuel
    */
    int nombreJour(int jourNaissance, int moisNaissance, int anneeNaissance, int jourActuel, int moisActuel, int anneeActuel){
        int nombre = 0;
        int i = anneeNaissance +1;

        while (i < anneeActuel) {
			nombre += nombreJourAnnee (i);
			i++;
        }
		
        
        while (i <= 12) {
			nombre += nombreJourMois (i, anneeNaissance);
			i++;
        }
		nombre += nombreJourMois (moisNaissance, anneeNaissance) - jourNaissance;
		
        i = 1;
        while (i < moisActuel) {
			nombre += nombreJourMois (i, anneeActuel);
			i++;
        }
        nombre += jourActuel;

        return nombre;
        
    }


}   

