
/**
 * La classe <code>TestPolynome</code> permet de jouer (un peu) avec la classe Polynome
 *
 * @author  N.LESCOP
 * @version 1.0
 */
public class TestPolynome {


    /**
     * Méthode d’exemple pour tester rapidement la classe <code>Polynome</code>.
     * <p><strong>Cette méthode main est à titre de démonstration seulement.</strong></p>
     *
     * @param args Arguments passés au programme (non utilisés).
     */
    public static void main(String[] args) {
        testConstructeur();
        testGetCoefficient();
        testAdd();
        testIsIdentical();
    }

    public static void testConstructeur() {
        System.out.println("***Test du constructeur***");
        double[] tab = {-3.0, 5.0}; // -3 +5x^2;
        Polynome p1 = new Polynome(tab);
        System.out.println("tab : {-3.0, 5.0}");
        System.out.println("p1 de tab est : " + p1.getCoefficient(0) + "+" + p1.getCoefficient(1) + "x^2");

        double[] tab1 = {0.0}; // 0
        Polynome p2 = new Polynome(tab1);
        System.out.println("tab1 : {0.0}");
        System.out.println("p2 de tab1 est : " + p2.getCoefficient(0));

        double[] tab2 = null; // null
        Polynome p3 = new Polynome(tab2);
        System.out.println("tab2 est null");
        System.out.println("p3 de tab2 est : " + p3.getCoefficient(0));

        double [] tab3 = {2.0, 4.0}; // 2 + 4x
        Polynome p4 = new Polynome(tab3);
        System.out.println("tab3 : {2.0, 4.0}");
        System.out.println("p4 avant modification de tab3 : " + p4.getCoefficient(0) + "+" + p4.getCoefficient(1) + "x");
        tab3[0] = 1.0;
        System.out.println("p4 après modification de tab3 : " + p4.getCoefficient(0) + "+" + p4.getCoefficient(1) + "x");
        System.out.println();
    }

    public static void testGetCoefficient() {
        System.out.println("***Test de la méthode getCoefficient***");
        double[] tab = {-3.0, 5.0}; // -3 +5x^2;
        Polynome p1 = new Polynome(tab);
        System.out.println("tab : {-3.0, 5.0}");
        System.out.println("p1 est : " + p1.getCoefficient(0) + "+" + p1.getCoefficient(1) + "x^2");

        double[] tab1 = {0.0}; // 0
        Polynome p2 = new Polynome(tab1);
        System.out.println("tab1 : {0.0}");
        System.out.println("p2 est : " + p2.getCoefficient(0));

        double [] tab2 = {2.0, 4.0}; // 2 + 4x
        Polynome p3 = new Polynome(tab2);
        System.out.println("tab3 : {2.0, 4.0}");
        System.out.println("p3 en cherchant l'indice 2 de tab2 : " + p3.getCoefficient(0) + "+" + p3.getCoefficient(1) + "x" + p3.getCoefficient(2));
        // Le problème est gèrer facilement dans le setter car le setter ne revoie rien, il affiche juste une erreur
        System.out.println();
    }

    public static void testAdd() {
        System.out.println("***Test de la méthode add***");
        double[] tab = {-3.0, 5.0}; // -3 +5x;
        Polynome p1 = new Polynome(tab);

        double [] tab1 = null;
        Polynome p2 = new Polynome(tab1);

        double[] tab2 = {1.0, -2.0}; // 1 +-2x;
        Polynome p3 = new Polynome(tab2);

        System.out.println("p1 : -3+5x, p2 : null et p3 1-2x");

        Polynome somme = p1.add(p3);
        System.out.println("somme de p1 et p3 est : " + somme.getCoefficient(0) + "+" + somme.getCoefficient(1) + "x");

        Polynome somme1 = p1.add(p2);
        System.out.println("somme de p1 et p2 est : " + somme1.getCoefficient(0) + "+" + somme1.getCoefficient(1) + "x");

        Polynome somme2 = p1.add(null);
        System.out.println("somme de p1 et null est : " + somme2.getCoefficient(0) + "+" + somme2.getCoefficient(1) + "x");
        System.out.println();
    }

    public static void testIsIdentical() {
        System.out.println("***Test de la méthode isIdentical***");
        double[] tab = {4.0, 2.0};
        Polynome p1 = new Polynome(tab);

        double [] tab1 = {1.0, 2.0};
        Polynome p2 = new Polynome(tab1);

        double [] tab2 = {4.0, 2.0, 0.0};
        Polynome p3 = new Polynome(tab2);

        System.out.println("p1 : 4+2X, p2 : 1+2x et p3 : 4+2x+0x^2");
        System.out.println("Pour p1 et p2 :");
        testCasIsIdentical(p1, p2, false);
        System.out.println("Pour p1 et null:");
        testCasIsIdentical(p1, null, false);
        System.out.println("Pour p1 et p3:");
        testCasIsIdentical(p1, p3, true);
    }

    public static void testCasIsIdentical(Polynome p1, Polynome p2, boolean resultatAttendu) {
        System.out.print("Est identique : " +  p1.isIdentical(p2) + ": ");
        if (p1.isIdentical(p2) == resultatAttendu) {
            System.out.print("OK");
        } else {
            System.out.print("ERREUR");
        }
        System.out.println();
    }

}

