-- *********** Requêtes en SQL ***********
/*
Nom : LESCOP et BOEFFARD
Prénom : Nolann et Kevin
Groupe : 1D1
*/

-- ************** Tache 3 : Requêtes avec algèbre relationnelle **************

-- Insertion de données
-- Remplissage de la table Agence
INSERT INTO Agence (numAgence, adresse, horaire) VALUES (1, '10 Rue des Lilas', 9);
INSERT INTO Agence (numAgence, adresse, horaire) VALUES (2, '25 Avenue des Fleurs', 8);

-- Remplissage de la table Agent
INSERT INTO Agent (numAgent, nom, prenom, salaire, estResponsable, sonAgence) VALUES (101, 'Lescop', 'Nolann', 4000, 1, 1);
INSERT INTO Agent (numAgent, nom, prenom, salaire, estResponsable, sonAgence) VALUES (102, 'Prime', 'Baltasar', 3600, 0, 1);
INSERT INTO Agent (numAgent, nom, prenom, salaire, estResponsable, sonAgence) VALUES (103, 'Martin', 'Bertrand', 4500, 1, 2);
INSERT INTO Agent (numAgent, nom, prenom, salaire, estResponsable, sonAgence) VALUES (104, 'Lescop', 'Jean-Luc', 3800, 0, 2);

-- Remplissage de la table Bien
INSERT INTO Bien (idBien, adresse, nbPieces, valeur, anneeConst, cave, parking, enTravaux, unAgent) VALUES (1, '15 Rue des Érables', 3, 150000, 2005, 1, 1, 0, 101);
INSERT INTO Bien (idBien, adresse, nbPieces, valeur, anneeConst, cave, parking, enTravaux, unAgent) VALUES (2, '50 Boulevard Saint-Michel', 4, 200000, 2010, 0, 1, 1, 101);
INSERT INTO Bien (idBien, adresse, nbPieces, valeur, anneeConst, cave, parking, enTravaux, unAgent) VALUES (3, '78 Rue Lafayette', 2, 120000, 2000, 1, 0, 0, 102);
INSERT INTO Bien (idBien, adresse, nbPieces, valeur, anneeConst, cave, parking, enTravaux, unAgent) VALUES (4, '5 Place de la République', 5, 300000, 2018, 1, 1, 0, 103);
INSERT INTO Bien (idBien, adresse, nbPieces, valeur, anneeConst, cave, parking, enTravaux, unAgent) VALUES (5, '3 Rue des Peupliers', 3, 180000, 2015, 1, 1, 0, 101);
-- Remplissage de la table Client
INSERT INTO Client (idClient, nomClient, prenomClient, email, adresse, tel) VALUES (1, 'Brocart', 'Celian', 'celian.brocart@gmail.com', '12 Rue des Acacias', 1234567890);
INSERT INTO Client (idClient, nomClient, prenomClient, email, adresse, tel) VALUES (2, 'Potay', 'Glen', 'glen.potay@gmail.com', '8 Rue des Ormes', 9876543210);
INSERT INTO Client (idClient, nomClient, prenomClient, email, adresse, tel) VALUES (3, 'Gouelo', 'Matthieu', 'matthieu.gouelo@gmail.com', '16 Avenue de la Gare', 4561237890);
INSERT INTO Client (idClient, nomClient, prenomClient, email, adresse, tel) VALUES (4, 'Le Peintre', 'Dimitri', 'dimitri.lepeintre@gmail.com', '17 Avenue de leglise', '0611223344');
INSERT INTO Client (idClient, nomClient, prenomClient, email, adresse, tel) VALUES (5, 'Le Cadre', 'Jean-Claude', 'jean-claude.lecadre@gmail.com', '1 Avenue des Petales', '0612223344');

-- Remplissage de la table Vente
INSERT INTO Vente (leBienV, leClientV, dateVente, prix) VALUES (1, 1, TO_DATE('2023-01-15', 'YYYY-MM-DD'), 150000);
INSERT INTO Vente (leBienV, leClientV, dateVente, prix) VALUES (2, 2, TO_DATE('2023-06-10', 'YYYY-MM-DD'), 300000);

-- Remplissage de la table Location
INSERT INTO Location (leBienL, leClientL, dateDebut, dateFin, loyer) VALUES (1, 1, TO_DATE('2023-02-01', 'YYYY-MM-DD'), TO_DATE('2023-12-31', 'YYYY-MM-DD'), 1200);
INSERT INTO Location (leBienL, leClientL, dateDebut, dateFin, loyer) VALUES (2, 2, TO_DATE('2023-03-01', 'YYYY-MM-DD'), TO_DATE('2023-10-01', 'YYYY-MM-DD'), 1500);

-- ******************************************************************************************************************************************************

-- a) projection avec restriction (2 requêtes)

-- Requête 1 :
/* Afficher les noms et prénoms des agents ayant un salaire supérieur à 4000
   AR : Agent {salaire > 4000} [nom, prenom]
   SQL :
 */
SELECT DISTINCT UPPER(nom), UPPER(prenom)
FROM Agent
WHERE salaire > 4000;

/* Resultat execution
   UPPER(NOM)                                         UPPER(PRENOM)
-------------------------------------------------- --------------------------------------------------
MARTIN                                             BERTRAND
 */

-- Requête 2 :
/* Lister les adresses des biens en travaux.
   AR: Bien {enTravaux = 1} [adresse]
   SQL :
 */
SELECT DISTINCT UPPER(adresse)
FROM Bien
WHERE enTravaux = 1;

/* Resultat execution :
   UPPER(ADRESSE)
--------------------------------------------------
50 BOULEVARD SAINT-MICHEL
 */

-- ******************************************************************************************************************************************************

-- b) union, intersection, différence ensembliste (3 requêtes)

-- Union :
/* Lister toutes les adresses présentes dans la table Agence et celles des biens.
   AR : Agence[adresse] UNION Bien[adresse]
   SQL :
 */
SELECT DISTINCT UPPER(adresse)
FROM Agence
UNION
SELECT DISTINCT UPPER(adresse)
FROM Bien;

/* Resultat execution :
   UPPER(ADRESSE)
--------------------------------------------------
10 RUE DES LILAS
15 RUE DES ÉRABLES
25 AVENUE DES FLEURS
5 PLACE DE LA RÉPUBLIQUE
50 BOULEVARD SAINT-MICHEL
78 RUE LAFAYETTE

6 lignes sélectionnées.
 */

-- Intersection :
/* Lister les clients ayant acheté un bien et qui ont également loué un autre bien.
   AR : Vente[leClientV] INTERSECT Location[leClientL]
   SQL :
 */
SELECT DISTINCT leClientV
FROM Vente
INTERSECT
SELECT DISTINCT leClientL
FROM Location;

/* Resultat execution :
    LECLIENTV
----------
         1
         2
 */

-- différence ensembliste
/* Lister les clients qui n'ont pas encore acheté de bien.
   AR : Client[idClient] - Vente[leClientV]
   SQL :
 */
SELECT DISTINCT idClient
FROM Client
MINUS
SELECT DISTINCT leClientV
FROM Vente;

/* Resultat execution :
  IDCLIENT
----------
         3
 */

-- ******************************************************************************************************************************************************

-- c) tri avec restriction

/* Lister les biens ayant plus de 3 pièces, triés par la valeur décroissante.
   AR : Bien {nbPieces > 3} [nbPieces, valeur] (valeur <)
   SQL :
 */
SELECT DISTINCT nbPieces, valeur
FROM Bien
WHERE nbPieces > 3
ORDER BY valeur DESC

/* Resultat execution :
     NBPIECES     VALEUR
---------- ----------
         5     300000
         4     200000
 */

-- ******************************************************************************************************************************************************

-- d) tri multi-attributs avec restriction

/* Lister les clients ayant un numéro de téléphone commençant par "06",
   triés par leur prénom croissant puis par leur adresse décroissante.
   AR : Client {tel LIKE '06%'} [idClient, nomClient, prenomClient, adresse] (prenom >, adresse <)
   SQL :
 */
SELECT DISTINCT idClient, UPPER(nomClient), UPPER(prenomClient), UPPER(adresse)
FROM Client
WHERE tel LIKE '06%'
ORDER BY prenomClient ASC, adresse DESC;

/* Resultat execution :
     IDCLIENT UPPER(NOMCLIENT)                                   UPPER(PRENOMCLIENT)                                UPPER(ADRESSE)
---------- -------------------------------------------------- -------------------------------------------------- --------------------------------------------------
         4 LE PEINTRE                                         DIMITRI                                            17 AVENUE DE LEGLISE
         5 LE CADRE                                           JEAN-CLAUDE                                        1 AVENUE DES PETALES

 */

-- ******************************************************************************************************************************************************

-- e) tri + limitation (avec ROWNUM)

/* Affichez les 3 premiers clients triés par ordre alphabétique de leur prénom.
   AR : Client {ROWNUM <= 3} [idClient, prenomClient, nomClient, email] (prenomClient>)
   SQL :
 */
SELECT *
FROM (
    SELECT DISTINCT idClient, UPPER(prenomClient), UPPER(nomClient), UPPER(email)
    FROM Client
    ORDER BY prenomClient
)
WHERE ROWNUM <= 3;

/* Resultat execution :
     IDCLIENT UPPER(PRENOMCLIENT)                                UPPER(NOMCLIENT)                                   UPPER(EMAIL)
---------- -------------------------------------------------- -------------------------------------------------- --------------------------------------------------
         1 CELIAN                                             BROCART                                            CELIAN.BROCART@GMAIL.COM
         4 DIMITRI                                            LE PEINTRE                                         DIMITRI.LEPEINTRE@GMAIL.COM
         2 GLEN                                               POTAY                                              GLEN.POTAY@GMAIL.COM
 */

-- ******************************************************************************************************************************************************

-- f) jointure de 2 tables (2 jointures de 2 tables)

-- Jointure 1 :
/* Lister les agents avec les informations de l'agence à laquelle ils sont affectés.
   AR : Agent[numAgence = sonAgence]Agence [numAgent, nom, prenom, adresse, horaire]
   SQL :
 */
SELECT DISTINCT numAgent, UPPER(nom), UPPER(prenom), UPPER(adresse), horaire
FROM Agent, Agence
WHERE numAgence = sonAgence;

/* Resultat execution :
     NUMAGENT UPPER(NOM)                                         UPPER(PRENOM)                                      UPPER(ADRESSE)                                        HORAIRE
---------- -------------------------------------------------- -------------------------------------------------- -------------------------------------------------- ----------
       102 PRIME                                              BALTASAR                                           10 RUE DES LILAS                                            9
       104 LESCOP                                             JEAN-LUC                                           25 AVENUE DES FLEURS                                        8
       101 LESCOP                                             NOLANN                                             10 RUE DES LILAS                                            9
       103 MARTIN                                             BERTRAND                                           25 AVENUE DES FLEURS                                        8
 */

-- Jointure 2 :
/* Listez les informations des clients ayant acheté des bien (nom, prénom, email, adresse).
   AR : Client[idClient = leClientV] [idClient, nomClient, prenomClient, email, adresse]
   SQL :
 */
SELECT DISTINCT idClient, UPPER(nomCLient), UPPER(prenomCLient), UPPER(email), UPPER(adresse)
FROM Client, Vente
WHERE idClient = leClientV;

/* Resultat execution :
     IDCLIENT UPPER(NOMCLIENT)                                   UPPER(PRENOMCLIENT)                                UPPER(EMAIL)                                       UPPER(ADRESSE)
---------- -------------------------------------------------- -------------------------------------------------- -------------------------------------------------- --------------------------------------------------
         2 POTAY                                              GLEN                                               GLEN.POTAY@GMAIL.COM                               8 RUE DES ORMES
         1 BROCART                                            CELIAN                                             CELIAN.BROCART@GMAIL.COM                           12 RUE DES ACACIAS
 */

-- ******************************************************************************************************************************************************

-- g) jointure de 3 tables

/* Affichez les informations des biens (adresse, valeur) avec le nom et le prenom de l’agent qui les gère et l’adresse de l’agence à laquelle appartient cet agent.
   AR : Agence[numAgence = sonAgence]Agent[numAgent = unAgent]Bien [Bien.adresse, valeur, nom, prenom, Agence.adresse]
   SQL :
 */
SELECT DISTINCT Bien.adresse, valeur, UPPER(nom), UPPER(prenom), Agence.adresse
FROM Agence, Agent, Bien
WHERE numAgence = sonAgence
    AND numAgent = unAgent;

/* Resultat execution :
   ADRESSE                                                VALEUR UPPER(NOM)                                         UPPER(PRENOM)                                      ADRESSE
-------------------------------------------------- ---------- -------------------------------------------------- -------------------------------------------------- --------------------------------------------------
78 Rue Lafayette                                       120000 PRIME                                              BALTASAR                                           10 Rue des Lilas
5 Place de la République                               300000 MARTIN                                             BERTRAND                                           25 Avenue des Fleurs
50 Boulevard Saint-Michel                              200000 LESCOP                                             NOLANN                                             10 Rue des Lilas
15 Rue des Érables                                     150000 LESCOP                                             NOLANN                                             10 Rue des Lilas
 */

-- ******************************************************************************************************************************************************

-- h) auto-jointure

/* Lister les paires de biens situés ayant le même nombre de pièces, avec leur identifiant et leur valeur respective.
   AR : Bien B1[B1.idBien != B2.idBien AND B1.nbPieces = B2.nbPieces]Bien B2 [B1.idBien, B2.idBien, B1.nbPieces, B2.nbPieces]
   SQL :
 */
SELECT DISTINCT B1.idBien, B2.idBien, B1.nbPieces, B2.nbPieces
FROM Bien B1, Bien B2
WHERE B1.idBien != B2.idBien
    AND B1.nbPieces = B2.nbPieces;

/* Resultat execution :
       IDBIEN     IDBIEN   NBPIECES   NBPIECES
---------- ---------- ---------- ----------
         5          1          3          3
         1          5          3          3
 */

-- ******************************************************************************************************************************************************

-- i) jointure externe (sans algèbre relationnelle) (2 jointures externes)

-- SQL jointure externe 1 :
/* Listez tous les clients et leurs informations de location, même si certains clients n'ont pas de location enregistrée. Affichez l'ID du client, l'ID du bien, et le montant du loyer. */
SELECT DISTINCT idClient, leBienL, loyer
FROM Client
LEFT OUTER JOIN Location ON idClient = leClientL;

/* Resultat execution :
     IDCLIENT    LEBIENL      LOYER
---------- ---------- ----------
         2          2       1500
         4
         3
         1          1       1200
         5
 */

-- SQL jointure externe 2 :
/* Listez tous les clients et tous les biens, en incluant les clients sans location et les biens qui ne sont pas associés à une location.
   Affichez l'ID du client, l'ID du bien, et le montant du loyer. */
SELECT DISTINCT idClient, leBienL, loyer
FROM Client
FULL OUTER JOIN Location ON idClient = leClientL;

/* Resultat execution :
     IDCLIENT    LEBIENL      LOYER
---------- ---------- ----------
         2          2       1500
         3
         4
         1          1       1200
         5
 */