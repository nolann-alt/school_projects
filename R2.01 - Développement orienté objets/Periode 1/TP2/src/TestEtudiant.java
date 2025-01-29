/**
 * This class allows to test the class Etudiant
 *
 * @author N.LESCOP
 * @version 1.0
 * @since 29/01/2025
 */
public class TestEtudiant {

    /**
     * This method allows to test the class Etudiant
     *
     * @param args Arguments passed to the program (not used)
     */
    public static void main(String[]args) {
        Etudiant e1;
        String[] mat = {"BD", "Prog", "Math"};
        double[] coef = {1.0, 2.0, 1.0};
        e1 = new Etudiant("toto", mat, coef, 3);
        System.out.println(e1);
        e1.setNom("titi");
        System.out.println("Le nom : " + e1.getNom());
        System.out.println("Une note : "  + e1.getUneNote(1, 1));
        System.out.println("Nombre de matières : " + e1.getNbMatieres());
        System.out.println("Moyenne matière (Prog) : " + e1.moyenneMatiere(1));
        System.out.println("Moyenne générale : " + e1.moyenneGenerale());
        System.out.println("Meilleur note : " + e1.melleureNote());
    }
}
