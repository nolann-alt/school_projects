
/**
 * La classe <code>TestPolynome</code> permet de jouer (un peu) avec la classe Polynome
 * Elle n'est pas un bon exemple de test unitaire!
 *
 * @author  R. Fleurquin
 * @version 1.0
 */
public class TestPolynome0 {


    /**
     * Méthode d’exemple pour tester rapidement la classe <code>Polynome</code>.
     * <p><strong>Cette méthode main est à titre de démonstration seulement.</strong></p>
     *
     * @param args Arguments passés au programme (non utilisés).
     */
    public static void main(String[] args) {
        // Exemples de coefficients
        double[] coeffs1 = {2.0, 3.0, 5.0}; // 2 + 3x + 5x^2
        double[] coeffs2 = {1.0, 4.0};      // 1 + 4x
        double[] coeffs3 = {-3.0, -1.0, 2.0, 3.0}; // -3 -x +2x^2 + 3x^3

        Polynome p1 = new Polynome(coeffs1);
        Polynome p2 = new Polynome(coeffs2);
        Polynome p4 = new Polynome(coeffs3);

        // Évaluation de p1 en x = 2
        System.out.println("p1(2) = " + p1.evaluate(2.0));

        // Somme des deux polynômes
        Polynome p3 = p1.add(p2);
        System.out.println("p3 est : " + p3.getCoefficient(0)
                +"+"
                +p3.getCoefficient(1)
                +"x+"
                +p3.getCoefficient(2)
                +"x^2");

        // Degré des polynômes
        System.out.println("Degré de p1 : " + p1.getDegree());
        System.out.println("Degré de p2 : " + p2.getDegree());
        System.out.println("Degré de p3 : " + p3.getDegree());

        // Test de la méthode isIdentical
        System.out.println("p1 est identique à p2 ? " + p1.isIdentical(p2));
        System.out.println("p1 est identique à p1 ? " + p1.isIdentical(p1));

        // Question 4 :
        Polynome somme = p3.add(p4);
        System.out.println("p4 est : " + somme.getCoefficient(0)
                +"+"
                +somme.getCoefficient(1)
                +"x+"
                +somme.getCoefficient(2)
                +"x^2"
                +somme.getCoefficient(3)
                +"x^3");
        p4.setCoefficient(2, -3.0);
        System.out.println("p4 est : " + p4.getCoefficient(0)
                +"+"
                +p4.getCoefficient(1)
                +"x+"
                +p4.getCoefficient(2)
                +"x^2"
                +p4.getCoefficient(3)
                +"x^3");
        System.out.println("En x=2 : " + p4.evaluate(2));
        System.out.println("Comparaison : " + p4.isIdentical(p3));
    }
}

