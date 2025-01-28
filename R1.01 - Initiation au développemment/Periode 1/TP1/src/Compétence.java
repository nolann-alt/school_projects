/**
* @author Nolann
*/
class Compétence{
	void principal(){
		double noteC1;
		double noteC2;
		double noteC3;
		double noteC4;
		double noteC5;
		double noteC6;
		
		noteC1 = SimpleInput.getDouble("Note C1: ");
		noteC2 = SimpleInput.getDouble("Note C2: ");
		noteC3 = SimpleInput.getDouble("Note C3: ");
		noteC4 = SimpleInput.getDouble("Note C4: ");
		noteC5 = SimpleInput.getDouble("Note C5: ");
		noteC6 = SimpleInput.getDouble("Note C6: ");
		
		if (noteC1 + noteC2 + noteC3 + noteC4 + noteC5 + noteC6 >= 56) {
			if (noteC1 >= 10 && noteC2 >= 10 && noteC3 >= 10 && noteC4 >= 10 && noteC5 >= 10 && noteC6 >= 10){
				System.out.println ("Vous avez votre année avec en C1 " + noteC1 + " en C2: " + noteC2 + " en C3: " + noteC3 + " en C4: " + noteC4 + " en C5: " + noteC5 + " en C6: " + noteC6);	
			
			}else if (noteC1 >= 8 && noteC2 >= 10 && noteC3 >= 10 && noteC4 >= 10 && noteC5 >= 10 && noteC6 >= 10){
				System.out.println ("Vous avez votre année avec en C1 " + noteC1 + " en C2: " + noteC2 + " en C3: " + noteC3 + " en C4: " + noteC4 + " en C5: " + noteC5 + " en C6: " + noteC6);
			
			}else if (noteC1 >= 10 && noteC2 >= 8 && noteC3 >= 10 && noteC4 >= 10 && noteC5 >= 10 && noteC6 >= 10){
				System.out.println ("Vous avez votre année avec en C1 " + noteC1 + " en C2: " + noteC2 + " en C3: " + noteC3 + " en C4: " + noteC4 + " en C5: " + noteC5 + " en C6: " + noteC6);
			
			}else if (noteC1 >= 10 && noteC2 >= 10 && noteC3 >= 8 && noteC4 >= 10 && noteC5 >= 10 && noteC6 >= 10){
				System.out.println ("Vous avez votre année avec en C1 " + noteC1 + " en C2: " + noteC2 + " en C3: " + noteC3 + " en C4: " + noteC4 + " en C5: " + noteC5 + " en C6: " + noteC6);
				
			}else if (noteC1 >= 10 && noteC2 >= 10 && noteC3 >= 10 && noteC4 >= 8 && noteC5 >= 10 && noteC6 >= 10){
				System.out.println ("Vous avez votre année avec en C1 " + noteC1 + " en C2: " + noteC2 + " en C3: " + noteC3 + " en C4: " + noteC4 + " en C5: " + noteC5 + " en C6: " + noteC6);	
			
			}else if (noteC1 >= 10 && noteC2 >= 10 && noteC3 >= 10 && noteC4 >= 10 && noteC5 >= 8 && noteC6 >= 10){
				System.out.println ("Vous avez votre année avec en C1 " + noteC1 + " en C2: " + noteC2 + " en C3: " + noteC3 + " en C4: " + noteC4 + " en C5: " + noteC5 + " en C6: " + noteC6);
				
			}else if (noteC1 >= 10 && noteC2 >= 10 && noteC3 >= 10 && noteC4 >= 10 && noteC5 >= 10 && noteC6 >= 8){
				System.out.println ("Vous avez votre année avec en C1 " + noteC1 + " en C2: " + noteC2 + " en C3: " + noteC3 + " en C4: " + noteC4 + " en C5: " + noteC5 + " en C6: " + noteC6);
				
			}else if (noteC1 >= 8 && noteC2 >= 8 && noteC3 >= 10 && noteC4 >= 10 && noteC5 >= 10 && noteC6 >= 10){
				System.out.println ("Vous avez votre année avec en C1 " + noteC1 + " en C2: " + noteC2 + " en C3: " + noteC3 + " en C4: " + noteC4 + " en C5: " + noteC5 + " en C6: " + noteC6);
				
			}else if (noteC1 >= 8 && noteC2 >= 10 && noteC3 >= 8 && noteC4 >= 10 && noteC5 >= 10 && noteC6 >= 10){
				System.out.println ("Vous avez votre année avec en C1 " + noteC1 + " en C2: " + noteC2 + " en C3: " + noteC3 + " en C4: " + noteC4 + " en C5: " + noteC5 + " en C6: " + noteC6);
				
			}else if (noteC1 >= 8 && noteC2 >= 10 && noteC3 >= 10 && noteC4 >= 8 && noteC5 >= 10 && noteC6 >= 10){
				System.out.println ("Vous avez votre année avec en C1 " + noteC1 + " en C2: " + noteC2 + " en C3: " + noteC3 + " en C4: " + noteC4 + " en C5: " + noteC5 + " en C6: " + noteC6);
				
			}else if (noteC1 >= 8 && noteC2 >= 10 && noteC3 >= 10 && noteC4 >= 10 && noteC5 >= 8 && noteC6 >= 10){
				System.out.println ("Vous avez votre année avec en C1 " + noteC1 + " en C2: " + noteC2 + " en C3: " + noteC3 + " en C4: " + noteC4 + " en C5: " + noteC5 + " en C6: " + noteC6);
				
			}else if (noteC1 >= 8 && noteC2 >= 10 && noteC3 >= 10 && noteC4 >= 10 && noteC5 >= 10 && noteC6 >= 8){
				System.out.println ("Vous avez votre année avec en C1 " + noteC1 + " en C2: " + noteC2 + " en C3: " + noteC3 + " en C4: " + noteC4 + " en C5: " + noteC5 + " en C6: " + noteC6);
				
			}else if (noteC1 >= 10 && noteC2 >= 8 && noteC3 >= 8 && noteC4 >= 10 && noteC5 >= 10 && noteC6 >= 10){
				System.out.println ("Vous avez votre année avec en C1 " + noteC1 + " en C2: " + noteC2 + " en C3: " + noteC3 + " en C4: " + noteC4 + " en C5: " + noteC5 + " en C6: " + noteC6);
				
			}else if (noteC1 >= 10 && noteC2 >= 8 && noteC3 >= 10 && noteC4 >= 8 && noteC5 >= 10 && noteC6 >= 10){
				System.out.println ("Vous avez votre année avec en C1 " + noteC1 + " en C2: " + noteC2 + " en C3: " + noteC3 + " en C4: " + noteC4 + " en C5: " + noteC5 + " en C6: " + noteC6);
				
			}else if (noteC1 >= 10 && noteC2 >= 8 && noteC3 >= 10 && noteC4 >= 10 && noteC5 >= 8 && noteC6 >= 10){
				System.out.println ("Vous avez votre année avec en C1 " + noteC1 + " en C2: " + noteC2 + " en C3: " + noteC3 + " en C4: " + noteC4 + " en C5: " + noteC5 + " en C6: " + noteC6);
				
			}else if (noteC1 >= 10 && noteC2 >= 8 && noteC3 >= 10 && noteC4 >= 10 && noteC5 >= 10 && noteC6 >= 8){
				System.out.println ("Vous avez votre année avec en C1 " + noteC1 + " en C2: " + noteC2 + " en C3: " + noteC3 + " en C4: " + noteC4 + " en C5: " + noteC5 + " en C6: " + noteC6);
				
			}else if (noteC1 >= 10 && noteC2 >= 10 && noteC3 >= 8 && noteC4 >= 8 && noteC5 >= 10 && noteC6 >= 10){
				System.out.println ("Vous avez votre année avec en C1 " + noteC1 + " en C2: " + noteC2 + " en C3: " + noteC3 + " en C4: " + noteC4 + " en C5: " + noteC5 + " en C6: " + noteC6);
				
			}else if (noteC1 >= 10 && noteC2 >= 10 && noteC3 >= 8 && noteC4 >= 10 && noteC5 >= 10 && noteC6 >= 8){
				System.out.println ("Vous avez votre année avec en C1 " + noteC1 + " en C2: " + noteC2 + " en C3: " + noteC3 + " en C4: " + noteC4 + " en C5: " + noteC5 + " en C6: " + noteC6);
				
			}else if (noteC1 >= 10 && noteC2 >= 10 && noteC3 >= 10 && noteC4 >= 8 && noteC5 >= 8 && noteC6 >= 10){
				System.out.println ("Vous avez votre année avec en C1 " + noteC1 + " en C2: " + noteC2 + " en C3: " + noteC3 + " en C4: " + noteC4 + " en C5: " + noteC5 + " en C6: " + noteC6);
				
			}else if (noteC1 >= 10 && noteC2 >= 10 && noteC3 >= 10 && noteC4 >= 8 && noteC5 >= 10 && noteC6 >= 8){
				System.out.println ("Vous avez votre année avec en C1 " + noteC1 + " en C2: " + noteC2 + " en C3: " + noteC3 + " en C4: " + noteC4 + " en C5: " + noteC5 + " en C6: " + noteC6);
				
			}else if (noteC1 >= 10 && noteC2 >= 10 && noteC3 >= 10 && noteC4 >= 10 && noteC5 >= 8 && noteC6 >= 8){
				System.out.println ("Vous avez votre année avec en C1 " + noteC1 + " en C2: " + noteC2 + " en C3: " + noteC3 + " en C4: " + noteC4 + " en C5: " + noteC5 + " en C6: " + noteC6);
				
			}else if (noteC1 >= 10 && noteC2 >= 10 && noteC3 >= 8 && noteC4 >= 10 && noteC5 >= 8 && noteC6 >= 10){
				System.out.println ("Vous avez votre année avec en C1 " + noteC1 + " en C2: " + noteC2 + " en C3: " + noteC3 + " en C4: " + noteC4 + " en C5: " + noteC5 + " en C6: " + noteC6);
				
			}														
		}else{
			System.out.println("Vous n'avez pas votre année car il y a une ou plusieurs compétences dans lesquelles vous avez moins de 8 ou encore, plus de 2 compétences en dessous de 10");
		} 
	}
}
