/**
 * This class can be used to create an object Etudiant with the following attributes: nom, bulletin, MATIERES, COEFFICIENTS
 * This class allows to set the name of a student, get the name of the student, the number of subjects, a note, the average of a subject, the general average and the best note
 *
 * @author N.LESCOP
 * @version 1.0
 * @since 29/01/2025
 */
public class Etudiant {
    /** The name of the student */
    private String nom;
    /** The notes of the student */
    private double [] [] bulletin;
    /** The list of subjects */
    private String [] MATIERES;
    /** The list of coefficients */
    private double [] COEFFICIENTS;

    /**
     * Constructor of the class Etudiant with the following parameters: nom, matieres, coeff, nbNotes
     * The constructor initializes the attributes of the class Etudiant
     *
     * @param nom the na of the student
     * @param matieres the list of subjects
     * @param coeff the list of coefficients
     * @param nbNotes the number of notes
     */
    public Etudiant(String nom, String [] matieres, double [] coeff, int nbNotes) {
        if (nom == null || nom == "") {
            System.out.println("Votre nom n'est pas correct !");
        } else {
            this.nom = nom;
        }

        if ((matieres == null) || (matieres.length == 0) || (matieres.length != coeff.length)) {
            System.out.println("La matière n'est pas renseigné ou mal renseigné");
            this.MATIERES = new String[0];
        } else {
            String [] copieMatiere = matieres.clone();
            this.MATIERES = copieMatiere;
        }

        if (coeff == null || coeff.length == 0 || coeff.length != matieres.length) {
            System.out.println("Les coefficients ne sont pas renseigné ou mal renseigné");
            this.COEFFICIENTS = new double[0];
        } else {
            double [] copieCoefficients = coeff.clone();
            this.COEFFICIENTS = copieCoefficients;
        }

        if (nbNotes < 1) {
            System.out.println("le nombre de note est inférieur à 1");
        } else {
            this.bulletin = new double [matieres.length] [nbNotes];
            initialisation();
        }
    }

    /**
     * This method allows to set the name of a student
     *
     * @param nom the name of the student
     */
    public void setNom(String nom) {
        if (this.nom == null || this.nom == "") {
            System.out.println("Votre nom n'est pas renseigné");
            this.nom = "nom inconnu";
        } else {
            this.nom = nom;
        }
    }

    /**
     * This method allows to get the name of the student
     *
     * @return the name of the student
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * This method allows to get the number of subjects
     *
     * @return the number of subjects
     */
    public int getNbMatieres() {
        return this.MATIERES.length;
    }

    /**
     * This method allows to get a note with the index of the subject and the index of the note
     *
     * @param iMatieres the index of the subject
     * @param i the index of the note
     * @return the note
     */
    public double getUneNote (int iMatieres, int i)  {
        double ret;
        // prog def, verfier que les indices sont dans les bonnes plages
        if (iMatieres < 0 || iMatieres >= bulletin.length) {
            System.out.println("L'indice de la matière n'est pas correct");
            ret = -1;
        } else if (i < 0 || i >= bulletin[i].length) {
            System.out.println("L'indice d'une note n'est pas correct");
            ret = -1;
        } else {
            ret = this.bulletin[iMatieres][i];
        }
        return ret;
    }

    /**
     * This method allows to initialize the notes of the student
     */
    private void initialisation() {
        for (int i = 0; i < this.MATIERES.length; i++) {
            for (int j = 0; j < this.bulletin[i].length; j++) {
                this.bulletin[i][j] = 20 * Math.random();
                this.bulletin[i][j] *= 10;
                this.bulletin[i][j] = Math.round(this.bulletin[i][j]);
                this.bulletin[i][j] /= 10;
            }
        }
    }

    /**
     * This method allows to get the average of a subject with the index of the subject
     *
     * @param iMatiere the index of the subject
     * @return the average of the subject
     */
    public double moyenneMatiere (int iMatiere) {
        double moyenne = 0;
        if (iMatiere < 0 || iMatiere >= this.bulletin.length) {
            System.out.println("Le paramètre iMatiere n'est pas correct");
            moyenne = -1;
        } else {
            double somme = 0;
            for (int i = 0; i < this.bulletin[iMatiere].length; i++) {
                somme += this.bulletin[iMatiere][i];
            }
            moyenne = somme / this.bulletin[iMatiere].length;

        }
        moyenne *= 10;
        moyenne = Math.round(moyenne);
        moyenne /= 10;
        return moyenne;
    }

    /**
     * This method allows to get the general average of the student
     *
     * @return the general average of the student
     */
    public double moyenneGenerale() {
        double moyenneG = 0;
        double somme = 0;
        int compteurCoeff = 0;
        for(int i = 0; i < this.bulletin.length; i++) {
            somme += moyenneMatiere(i) * this.COEFFICIENTS[i];
            compteurCoeff += this.COEFFICIENTS[i];
        }
        moyenneG = somme / compteurCoeff;
        moyenneG *= 10;
        moyenneG = Math.round(moyenneG);
        moyenneG /= 10;
        return moyenneG;
    }

    /**
     * This method allows to get the best note of the student in all subjects
     *
     * @return the best note of the student
     */
    public String melleureNote() {
        double note = 0;
        for(int i = 0; i < this.bulletin.length; i++) {
            for (int j = 0; j < this.bulletin[i].length; j++) {
                if (note < this.bulletin[i][j]) {
                    note = this.bulletin[i][j];
                }
            }
        }
        String noteMax = String.valueOf(note);
        return noteMax;
    }

    /**
     * This method allows to display the name of the student and his notes
     *
     * @return the name of the student and his notes
     */
    public String toString () {
        System.out.println();
        String chaine = this.getNom();
        chaine += "\n";

        for (int i = 0; i < this.bulletin.length; i++) {
            chaine += this.MATIERES[i];
            chaine += " : ";
            for (int j = 0; j < this.bulletin[i].length; j++) {
                chaine += this.bulletin[i][j];
                chaine += " | ";
            }
            chaine += "\n";
        }
        return chaine;
    }

}
