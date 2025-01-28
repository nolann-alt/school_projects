import java.util.Scanner;

class Devine1 {

    void principal() {
        int proposition;
        int valMax;
        int valMin;
        char réponse;
        char pensez;

        // Initialisation des bornes
        valMin = 0;
        valMax = 1000;
        réponse = ' ';
        
        // Scanner pour lire les entrées utilisateur
        Scanner scanner = new Scanner(System.in);
        
        // Demander à l'utilisateur de penser à un nombre
        System.out.println("Pensez à un nombre entre 0 et 1000, puis entrez '1' lorsque vous êtes prêt.");
        pensez = scanner.next().charAt(0);

        // Si l'utilisateur est prêt
        if (pensez == '1') {
            // Boucle pour deviner le bon nombre
            do {
                // Proposition = milieu des bornes
                proposition = valMin + (valMax - valMin) / 2;
                System.out.println("Proposition: " + proposition);
                
                // Demander si c'est supérieur, inférieur ou égal
                System.out.println("La proposition est-elle supérieure (+), inférieure (-) ou égale (=) ?");
                réponse = scanner.next().charAt(0);

                // Mise à jour des bornes selon la réponse
                if (réponse == '+') {
                    valMin = proposition + 1;  // Exclure la proposition actuelle
                } else if (réponse == '-') {
                    valMax = proposition - 1;  // Exclure la proposition actuelle
                }
                
            } while (réponse != '=');

            // Quand la boucle se termine
            System.out.println("J'ai réussi ! Le nombre est " + proposition);

        } else {
            System.out.println("Vous n'avez pas entré '1'.");
        }

        // Fermer le scanner
        scanner.close();
    }
}
