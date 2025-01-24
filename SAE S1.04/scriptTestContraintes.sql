-- *********** script qui effectue un jeu de test des contraintes déclarées lors de la créeation de tables ***********
/*
Nom : LESCOP et BOEFFARD
Prénom : Nolann et Kevin
Groupe : 1D1
*/

-- ************** Tache 2 : Tests des contraintes **************

-- a) existence de la clée primaire dans la table Client
INSERT INTO Client (idClient) VALUES (NULL);

/* Rapport d'erreur -
    Erreur commençant à la ligne: 1 de la commande -
    INSERT INTO Client (idClient) VALUES (NULL)
    Rapport d'erreur -
    ORA-01400: cannot insert NULL into ("NOLANN"."CLIENT"."IDCLIENT")
 */

-- ******************************************************************************************************************************************************

-- b) unicitée de la clée candidate dans la table Bien
INSERT INTO Agence (numAgence) VALUES (1);
INSERT INTO Agent (numAgent, nom, sonAgence) VALUES (1, 'Pham', 1);
INSERT INTO Bien (idBien, adresse, nbPieces, unAgent) VALUES (1, '1 impasse de Lyon', 3,1);
INSERT INTO Bien (idBien, adresse, nbPieces, unAgent) VALUES (2, '1 impasse de Lyon', 4,2);

/* Rapport d'erreur -
Erreur commençant à la ligne: 4 de la commande -
INSERT INTO Bien (idBien, adresse, nbPieces, unAgent) VALUES (2, '1 impasse de Lyon', 4,2)
Rapport d'erreur -
ORA-00001: unique constraint (NOLANN.UQ_ADRESSE) violated

 */

-- ******************************************************************************************************************************************************

-- c) intégrité référentielle de la clé étrangère dans la table Bien
INSERT INTO Bien (idBien, adresse, nbPieces) VALUES (1, '1 impasse de Lyon', 3);ù

/* Rapport d'erreur -
Erreur commençant à la ligne: 1 de la commande -
INSERT INTO Bien (idBien, adresse, nbPieces) VALUES (1, '1 impasse de Lyon', 3)
Rapport d'erreur -
ORA-01400: cannot insert NULL into ("NOLANN"."BIEN"."UNAGENT")
 */

-- ******************************************************************************************************************************************************

-- d) intégrité référentielle de la clé étrangère dans la table AgentImmo
INSERT INTO Agent (numAgent, nom) VALUES (1, 'Pham');

/* Rapport d'erreur -
Erreur commençant à la ligne: 1 de la commande -
INSERT INTO Agent (numAgent, nom) VALUES (1, 'Pham')
Rapport d'erreur -
ORA-01400: cannot insert NULL into ("NOLANN"."AGENT"."SONAGENCE")
 */

-- ******************************************************************************************************************************************************

-- e) CHECK de valeurs de l'attribut salaire
INSERT INTO Agent (numAgent, nom, salaire, sonAgence) VALUES (1, 'Pham', 1000, 1);

/* Rapport d'erreur -
Erreur commençant à la ligne: 1 de la commande -
INSERT INTO Agent (numAgent, nom, salaire, sonAgence) VALUES (1, 'Pham', 1000, 1)
Rapport d'erreur -
ORA-02290: check constraint (NOLANN.CK_SALAIRE) violated
 */

-- ******************************************************************************************************************************************************

-- f) CHECK de contrainte dateFin > dateDebut d'une location
INSERT INTO Location (leBienL, leClientL, dateDebut, dateFin) VALUES (1, 1, TO_DATE('01/01/2022','DD/MM/YYYY'), TO_DATE('01/01/2021','DD/MM/YYYY'));

/* Rapport d'erreur -
Erreur commençant à la ligne: 1 de la commande -
INSERT INTO Location (leBienL, leClientL, dateDebut, dateFin) VALUES (1, 1, TO_DATE('01/01/2022','DD/MM/YYYY'), TO_DATE('01/01/2021','DD/MM/YYYY'))
Rapport d'erreur -
ORA-02290: check constraint (NOLANN.CK_DATEFIN) violated
 */