import java.util.*;
import java.io.*;

/**
 * Programme mettant en œuvre la planification des trajets et des horaires
 *
 * @author N.LESCOP - novembre 2024
 * @version 1.1.0
 */
class Planification {
	/** Codes ANSI pour la couleur rouge */
	String ROUGE = "\033[31m";
	/** Codes ANSI pour la couleur verte */
	String VERT = "\033[32m";
	/** Codes ANSI pour la couleur bleu */
	String BLEU = "\033[34m";
	/** Codes ANSI pour la couleur jaune */
	String SUPPR = "\033[0m";
	/** Codes ANSI pour la couleur violette */
	String VIOLET = "\033[35m";

	// Variables globales accessibles par toutes les méthodes
	/** Collection des trajets */
	ArrayList<String> trajets = new ArrayList<String>();
	/** Collection des horaires */
	ArrayList<Integer> horaires = new ArrayList<Integer>();

	/**
	 * point d’entree de l’execution
	 */
	void principal() {
		testRemplirLesCollections();
		testAfficherHorairesEtDureeTrajets2Gares();
		testChercherCorrespondances();
		testObtenirInfosUnTrajet();
		testObtenirInfosUnHoraire();
		testTrouverTousLesTrajets();
	}

	// ================================= remplireLesCollections =================================

	/**
	 * La méthode remplirLesCollections permet de lire les informations des trajets et des horaires dans le fichier trajectsEtHoraires.txt
	 * et de les stocker dans les collections trajets et horaires de façon à ce que les informations des trajets et horraires puissent être
	 * facilement accessibles pour les autres méthodes
	 *
	 * @param nomFich nom du fichier contenant les informations
	 */
	void remplirLesCollections(String nomFich) {
		this.trajets.clear();
		this.horaires.clear();
		// Variables locales
		boolean eof = false;
		BufferedReader tampon;
		String ligne;
		int compteurLigne = 0;
		int k = 0;
		// Lire le fichier
		try {
			// Créer un tampon de lecture
			tampon = new BufferedReader(new FileReader(nomFich));
			// tant que le fichier n’est pas fini on lit les lignes
			while (!eof) {
				ligne = tampon.readLine();

				if (ligne == null) {
					eof = true;
				} else {
					String[] lesInfos = ligne.split(" / ");
					// Si la ligne est paire on récupère les informations des trajets
					if ((compteurLigne % 2) == 0) {
						while (k < lesInfos.length) {
							trajets.add(lesInfos[k]);
							k++;
						}
					// Sinon on récupère les informations des horaires
					} else {
						for (int i = 0; i < lesInfos.length; i++) {
							String horaire = lesInfos[i];
							int horaireInt = Integer.parseInt(horaire.trim());
							horaires.add(horaireInt);
						}
					}
					k = 0;
					compteurLigne++;
				}
			}
			tampon.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	// ================================= afficherHorairesEtDureeTousTrajets =================================

	/**
	 * La méthode afficherHorairesEtDureeTousTrajets permet d’afficher les horaires de départ et d’arrivée de tous les trajets
	 * ainsi que la durée de chaque trajet
	 */
	void afficherHorairesEtDureeTousTrajets() {
		boolean trouve = false;
		int j = 0;
		// Parcourir la liste des trajets
		for (int i = 0; i < trajets.size()-4 ; i += 4) {
			// Récupérer les informations
			int id_trajet = Integer.parseInt(trajets.get(0 + i));
			String type_train = trajets.get(1 + i);
			String gareDep = trajets.get(2 + i);
			String gareDest = trajets.get(3 + i);
			// Parcourir la liste des horaires
			do {
				// Si l'horaire est égal à l’identifiant du trajet passé en paramètre on récupère les informations
				if (horaires.get(j) == Integer.parseInt(trajets.get(0 + i))) {
					trouve = true;

				} else {
					j += 5;
				}
			} while (trouve != true);
			// Récupérer les informations
			int heureDepart = horaires.get(j + 1);
			int minutesDepart = horaires.get(j + 2);
			int heureArrivee = (horaires.get(j + 3));
			int minutesArrivee = horaires.get(j + 4);
			// Créer des objets Duree pour l’heure de départ et l’heure d’arrivée
			Duree tempsDepart = new Duree(heureDepart, minutesDepart, 0);
			Duree tempsArrivee = new Duree(heureArrivee, minutesArrivee, 0);
			// Afficher les informations
			System.out.println("Train " + type_train + " numéro " + id_trajet + " :");
			System.out.println("\t" + "Départ de " + gareDep + " à " + tempsDepart.enTexte('H'));
			System.out.println("\t" + "Arrivée à " + gareDest + " à " + tempsArrivee.enTexte('H'));
			tempsArrivee.soustraire(tempsDepart);
			System.out.println("\t" + "Durée du trajet - " + tempsArrivee.enTexte('H'));
			System.out.println();
		}
	}

	// ================================= afficherHorairesEtDureeTrajets2Gares =================================

	/**
	 * La méthode afficherHorairesEtDureeTrajets2Gares permet d’afficher les horaires de départ et d’arrivée de tous les trajets
	 * ainsi que la durée de chaque trajet entre deux gares données
	 *
	 * @param gareDep nom de la gare de départ
	 * @param gareDest nom de la gare de destination
	 */
	void afficherHorairesEtDureeTrajets2Gares ( String gareDep, String gareDest ){
		boolean trouve = false;
		int j = 0;
		// Parcourir la liste des trajets
		for (int i = 0; i < trajets.size() ; i += 4) {
			// Si la gare de départ et la gare de destination sont égales aux gares passées en paramètre on récupère les informations
			if (trajets.get(i + 2).equals(gareDep) && trajets.get(i + 3).equals(gareDest)) {
				int id_trajet = Integer.parseInt(trajets.get(0 + i));
				String type_train = trajets.get(1 + i);
				// Parcourir la liste des horaires
				do {
					// Si l'horaire est égal à l’identifiant du trajet passé en paramètre on récupère les informations
					if (horaires.get(j) == Integer.parseInt(trajets.get(0 + i))) {
						trouve = true;

					} else {
						j += 5;
					}
				} while (trouve != true);
				// Récupérer les informations
				int heureDepart = horaires.get(j + 1);
				int minutesDepart = horaires.get(j + 2);
				int heureArrivee = (horaires.get(j + 3));
				int minutesArrivee = horaires.get(j + 4);
				// Créer des objets Duree pour l’heure de départ et l’heure d’arrivée
				Duree tempsDepart = new Duree(heureDepart, minutesDepart, 0);
				Duree tempsArrivee = new Duree(heureArrivee, minutesArrivee, 0);
				// Afficher les informations
				System.out.println("Train " + type_train + " numéro " + id_trajet + " :");
				System.out.println("\t" + "Départ de " + gareDep + " à " + tempsDepart.enTexte('H'));
				System.out.println("\t" + "Arrivée à " + gareDest + " à " + tempsArrivee.enTexte('H'));
				tempsArrivee.soustraire(tempsDepart);
				System.out.println("\t" + "Durée du trajet - " + tempsArrivee.enTexte('H'));
				System.out.println();
			}
		}
	}

	// ================================= chercherCorrespondances =================================
	/**
	 * La méthode chercherCorrespondances permet de chercher les correspondances possibles pour un train qui part d’une gare donnée
	 * à une heure donnée
	 *
	 * @param gare nom de la gare de départ
	 * @param heure heure de départ
	 * @return identifiantTrajet un tableau contenant les identifiants des trajets
	 */
	ArrayList<String> chercherCorrespondances ( String gare, Duree heure ){
		ArrayList<String> identifiantTrajet = trouverTousLesTrajets(gare);
		int j = 0;
		// Parcourir la liste des identifiants des trajets
		for (int i = 0; i < identifiantTrajet.size(); i++) {
			// Obtenir les informations d’un horaire
			int [] infoHoraires = obtenirInfosUnHoraire(identifiantTrajet.get(i));
			// Créer un objet Duree pour l’heure de départ
			Duree heureDepart = new Duree(infoHoraires[j], infoHoraires[j + 1], 0);
			// Comparer l’heure de départ avec l’heure passée en paramètre
			int correspondance = heure.compareA(heureDepart);
			// Si l’heure de départ est inférieure à l’heure passée en paramètre
			if (correspondance == -1) {
				identifiantTrajet.remove(i);
			}
		}
		return identifiantTrajet;
	}

	// ================================= obtenirInfosUnTrajet =================================

	/**
	 * Cette méthode renvoie dans un tableau de String 3 informations : le type de
	 * train, la gare de départ et la gare de destination.
	 *
	 * @param idTrajet le numéro du train
	 * @return tableauInfos un tableau contenant le type de train, la gare de départ et la gare de destination
	 */
	String[] obtenirInfosUnTrajet ( String idTrajet ) {
		String[] tableauInfos = new String[3];
		// Parcourir la liste des trajets
		for (int i = 0; i < trajets.size() ; i += 4) {
			// Si le numéro du train est égal à l’identifiant du train passé en paramètre on récupère les informations
			if (trajets.get(i).equals(idTrajet)) {
				String typeTrain = trajets.get(i + 1);
				String gareDepart = trajets.get(i + 2);
				String gareDestination = trajets.get(i + 3);
				// On les stocke dans un tableau
				tableauInfos[0] = typeTrain;
				tableauInfos[1] = gareDepart;
				tableauInfos[2] = gareDestination;
			}
		}
		return tableauInfos;
	}

	// ================================= obtenirInfosUnHoraire =================================

	/**
	 * Cette méthode renvoie dans un tableau d’entiers 4 informations : heure
	 * départ, minutes départ, heure arrivée, minutes arrivée.
	 *
	 * @param idTrajet le numéro du train
	 * @return tableauEntiers un tableau contenant heure départ, minutes départ, heure arrivée, minutes arrivée
	 */
	int[] obtenirInfosUnHoraire ( String idTrajet ) {
		int[] tableauEntiers = new int[4];
		// Parcourir la liste des horaires
		for (int i = 0; i < horaires.size(); i += 5) {
			// Si l’identifiant du trajet est égal à l’identifiant du trajet passé en paramètre on récupère les informations
			if (horaires.get(i) == Integer.parseInt(idTrajet)) {
				int heureDepart = horaires.get(i + 1);
				int minutesDepart = horaires.get(i + 2);
				int heureArrivee = horaires.get(i + 3);
				int minutesArrivee = horaires.get(i + 4);
				// On les stocke dans un tableau
				tableauEntiers[0] = heureDepart;
				tableauEntiers[1] = minutesDepart;
				tableauEntiers[2] = heureArrivee;
				tableauEntiers[3] = minutesArrivee;
			}
		}
		return tableauEntiers;
	}

	// ================================= trouverTousLesTrajets =================================

	/**
	 * Cette méthode renvoie dans un tableau de String tous les identifiants des trajets
	 * qui partent de la gare de départ passée en paramètre
	 *
	 * @param gareDep nom de la gare de départ
	 * @return identifiantTrajet un tableau contenant les identifiants des trajets
	 */
	ArrayList<String> trouverTousLesTrajets ( String gareDep ) {
		ArrayList<String> identifiantTrajet = new ArrayList<>();
		// Parcourir la liste des trajets
		for (int i = 0; i < trajets.size(); i += 4) {
			// Si la gare de départ est égale à la gare de départ passée en paramètre on récupère les informations
			if (trajets.get(i + 2).equals(gareDep)) {
				identifiantTrajet.add(trajets.get(i));
			}
		}
		return identifiantTrajet;
	}

// ============================================= ***les méthodes de test*** =============================================

	/**
	 * Test de la méthode remplirLesCollections
	 */
	void testRemplirLesCollections() {
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		System.out.println(VIOLET + "=                          testRemplirLesCollections                     =" + SUPPR);
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		// Appel de la méthode à tester “cas normal”
		remplirLesCollections("./TrajetsEtHoraires.txt");
		System.out.println();
		// Test VISUEL de la bonne lecture du fichier
		afficherHorairesEtDureeTousTrajets();
		System.out.println();
	}

	/**
	 * Test de la méthode afficherHorairesEtDureeTrajets2Gares
	 */
	void testAfficherHorairesEtDureeTrajets2Gares() {
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		System.out.println(VIOLET + "=                    testAfficherHorairesEtDureeTrajets2Gares            =" + SUPPR);
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		// D’abord remplir les collections
		remplirLesCollections("./TrajetsEtHoraires.txt");
		System.out.println();
		// Appel de la méthode à tester “cas normal”
		afficherHorairesEtDureeTrajets2Gares( "Vannes", "Redon" );
		System.out.println();
	}

	/**
	 * Test de la méthode chercherCorrespondances
	 */
	void testChercherCorrespondances() {
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		System.out.println(VIOLET + "=                          testChercherCorrespondances                   =" + SUPPR);
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		// Appel de la méthode à tester “cas normal”
		ArrayList<String> identifiantTrajet = chercherCorrespondances("Vannes", new Duree(10, 30, 0));
		ArrayList<String> resAttendu = new ArrayList<>(Arrays.asList("1", "2", "7", "5", "8"));
		if (identifiantTrajet.equals(resAttendu)) {
			System.out.println("Le resultat attendu : " + resAttendu);
			System.out.print("Le resultat obtenu : " + identifiantTrajet);
			System.out.println("\t" + VERT + "OK" + SUPPR);
		} else {
			System.out.println("Le resultat attendu : " + resAttendu);
			System.out.print("Le resultat obtenu : " + identifiantTrajet);
			System.out.println("\t" + ROUGE + "ERREUR" + SUPPR);
		}
		System.out.println();
	}

	/**
	 * Test de la méthode obtenirInfosUnTrajet
	 */
	void testObtenirInfosUnTrajet() {
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		System.out.println(VIOLET + "=                          testObtenirInfosUnTrajet                      =" + SUPPR);
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		obtenirInfosUnTrajet("9");
		// Cas normal : affichage des informations du trajet 9
		String [] tableauInfos = obtenirInfosUnTrajet("9");
		System.out.println(Arrays.toString(tableauInfos));
		String [] resAttendu = {"TGV", "Rennes", "Nantes"};
		if (Arrays.equals(tableauInfos, resAttendu)) {
			System.out.println("Le resultat attendu : " + Arrays.toString(resAttendu));
			System.out.print("Le resultat obtenu : " + Arrays.toString(tableauInfos));
			System.out.println("\t" + VERT + "OK" + SUPPR);
		} else {
			System.out.println("Le resultat attendu : " + Arrays.toString(resAttendu));
			System.out.print("Le resultat obtenu : " + Arrays.toString(tableauInfos));
			System.out.println("\t" + ROUGE + "ERREUR" + SUPPR);
		}
		System.out.println();
	}

	/**
	 * Test de la méthode obtenirInfosUnHoraire
	 */
	void testObtenirInfosUnHoraire() {
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		System.out.println(VIOLET + "=                          testObtenirInfosUnHoraire                     =" + SUPPR);
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		obtenirInfosUnTrajet("9");
		int [] tableauEntiers = obtenirInfosUnHoraire("9");
		System.out.println(Arrays.toString(tableauEntiers));
		int [] resAttendu = {10, 12, 11, 28};
		if (Arrays.equals(tableauEntiers, resAttendu)) {
			System.out.println("Le resultat attendu : " + Arrays.toString(resAttendu));
			System.out.print("Le resultat obtenu : " + Arrays.toString(tableauEntiers));
			System.out.println("\t" + VERT + "OK" + SUPPR);
		} else {
			System.out.println("Le resultat attendu : " + Arrays.toString(resAttendu));
			System.out.print("Le resultat obtenu : " + Arrays.toString(tableauEntiers));
			System.out.println("\t" + ROUGE + "ERREUR" + SUPPR);
		}
		System.out.println();
	}

	/**
	 * Test de la méthode trouverTousLesTrajets
	 */
	void testTrouverTousLesTrajets() {
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		System.out.println(VIOLET + "=                          testTrouverTousLesTrajets                     =" + SUPPR);
		System.out.println(VIOLET + "==========================================================================" + SUPPR);
		trouverTousLesTrajets("Vannes");
		ArrayList<String> identifiantTrajet = trouverTousLesTrajets("Vannes");
		ArrayList<String> resAttendu = new ArrayList<>(Arrays.asList("1", "2", "6", "7", "5", "8"));
		if (identifiantTrajet.equals(resAttendu)) {
			System.out.println("Le resultat attendu : " + resAttendu);
			System.out.print("Le resultat obtenu : " + identifiantTrajet);
			System.out.println("\t" + VERT + "OK" + SUPPR);
		} else {
			System.out.println("Le resultat attendu : " + resAttendu);
			System.out.print("Le resultat obtenu : " + identifiantTrajet);
			System.out.println("\t" + ROUGE + "ERREUR" + SUPPR);
		}
		System.out.println();
	}
}