/**
 * La classe <code>Polynome</code> permet de simuler le comportement d’un polynôme
 * de la forme a<sub>0</sub> + a<sub>1</sub> x + a<sub>2</sub> x<sup>2</sup> + ... + a<sub>n</sub> x<sup>n</sup>,
 * dont les coefficients sont stockés dans un tableau.
 *
 * <p>
 * Par exemple, pour le tableau de coefficients [2.0, 3.0, 5.0], le polynôme
 * correspondant est : 2 + 3x + 5x².
 * </p>
 *
 * <p>Cette classe offre les opérations suivantes :</p>
 * <ul>
 *   <li>Construction d’un polynôme à partir d’un tableau de coefficients.</li>
 *   <li>Accès et modification des coefficients via un getter et un setter.</li>
 *   <li>Calcul de la somme de deux polynômes (méthode <code>add</code>).</li>
 *   <li>Comparaison de polynômes (méthode <code>isIdentical</code>).</li>
 *   <li>Évaluation du polynôme pour une valeur de x donnée (méthode <code>evaluate</code>).</li>
 *   <li>Récupération du degré du polynôme (méthode <code>getDegree</code>).</li>
 * </ul>
 *
 * @author  R. Fleurquin
 * @version 1.0
 */
public class Polynome {

    /**
     * Tableau contenant les coefficients du polynôme.
     * L’indice i correspond au coefficient du terme x^i.
     */
    private double[] coefficients;

    /**
     * Constructeur qui initialise le polynôme avec le tableau de coefficients fourni.
     * Les coefficients sont supposés être ordonnés de manière croissante par rapport à la puissance de x.
     * Par exemple, <code>coefficients[0]</code> est le coefficient du terme constant (x^0),
     * <code>coefficients[1]</code> celui du terme x^1, etc.
     *
     * @param coeffs Tableau des coefficients du polynôme (non modifié par la classe).
     */
    public Polynome(double[] coeffs) {
        if (coeffs == null) {
            double [] coefficients = {0.0};
            this.coefficients = coefficients;

        } else {
            double [] copie = coeffs.clone();
            this.coefficients = copie;
        }
    }

    /**
     * Getter qui renvoie le coefficient situé à l’indice spécifié.
     * L’indice correspond à la puissance de x.
     *
     * @param index L’indice du tableau, correspondant à la puissance de x.
     * @return Le coefficient associé à x^index.
     */
    public double getCoefficient(int index) {
        double ret=-1;
        if (index < 0 || index >= coefficients.length) {
            System.out.println("L'indice " + index + " est hors limites.");
        }
        else{
            ret=coefficients[index];
        }
        return ret;
    }

    /**
     * Setter qui modifie le coefficient à l’indice spécifié.
     * L’indice correspond à la puissance de x.
     *
     * @param index       L’indice dans le tableau, correspondant à la puissance de x.
     * @param coefficient La nouvelle valeur du coefficient pour x^index.
     */
    public void setCoefficient(int index, double coefficient) {
        if (index < 0 || index >= coefficients.length) {
            System.out.println("L'indice " + index + " est hors limites.");
        }
        else{
            this.coefficients[index] = coefficient;
        }
    }

    /**
     * Méthode qui calcule la somme de ce polynôme avec un autre polynôme.
     * La somme est définie en additionnant les coefficients de même degré (même puissance de x).
     *
     * @param other Le polynôme à ajouter à ce polynôme.
     * @return Un nouveau polynôme qui représente la somme des deux polynômes.
     */
    public Polynome add(Polynome other) {
        if (other == null) {
            System.err.println("Le paramètre de add est null !");
            return new Polynome(this.coefficients);
        }

        int maxLength = Math.max(this.coefficients.length, other.coefficients.length);
        double[] newCoefficients = new double[maxLength];

        for (int i = 0; i < maxLength; i++) {
            double c1 = (i < this.coefficients.length) ? this.coefficients[i] : 0.0;
            double c2 = (i < other.coefficients.length) ? other.coefficients[i] : 0.0;
            newCoefficients[i] = c1 + c2;
        }
        return new Polynome(newCoefficients);
    }

    /**
     * Méthode qui vérifie si deux polynômes sont identiques.
     * Deux polynômes sont considérés identiques s’ils possèdent le même nombre de coefficients
     * et que leurs coefficients respectifs sont égaux.
     *
     * @param other Le polynôme à comparer.
     * @return <code>true</code> si les polynômes ont la même longueur de tableau et les mêmes coefficients,
     *         <code>false</code> sinon.
     */
    public boolean isIdentical(Polynome other) {
        if (other == null) {
            System.err.print("Le paramètre de isIdentical est null ! : ");
            return false;
        }

        int longueurReelActuel = this.coefficients.length;
        int longueurReelAutre = other.coefficients.length;

        while (longueurReelActuel > 0 && this.coefficients[longueurReelActuel - 1] == 0.0) {
            longueurReelActuel--;
        }

        while (longueurReelAutre > 0 && other.coefficients[longueurReelAutre - 1] == 0.0) {
            longueurReelAutre--;
        }

        if (longueurReelActuel != longueurReelAutre) {
            return false;
        }

        for (int i = 0; i < longueurReelAutre; i++) {
            if (Double.compare(this.coefficients[i], other.coefficients[i]) != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Méthode qui calcule la valeur du polynôme pour une valeur réelle donnée de x.
     * Par exemple, si le polynôme est 2 + 3x + 5x² et x = 10, la méthode retournera 2 + 3*10 + 5*100 = 532.
     *
     * @param x La valeur pour laquelle on veut évaluer le polynôme.
     * @return La valeur du polynôme à x.
     */
    public double evaluate(double x) {
        double result = 0.0;
        double puissance = 1.0;  // correspond à x^0

        // Évaluation : a0 + a1*x + a2*x^2 + ...
        for (double coeff : coefficients) {
            result += coeff * puissance;
            puissance *= x;
        }
        return result;
    }

    /**
     * Renvoie le degré du polynôme, c’est-à-dire la plus grande puissance de x
     * ayant un coefficient non nul. Si tous les coefficients sont nuls, la méthode
     * retournera -1 pour indiquer que le polynôme est le polynôme nul.
     *
     * @return Le degré du polynôme, ou -1 si tous les coefficients sont nuls.
     */
    public int getDegree() {
        int deg = coefficients.length - 1;
        while (deg >= 0 && Double.compare(coefficients[deg], 0.0) == 0) {
            deg--;
        }
        return deg; // -1 si tous les coefficients sont nuls
    }

}

