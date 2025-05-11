/*
SQL - TP7 - Administration MySQL
Prénom : Nolann
Nom : LESCOP
Groupe 1D1
*/

------------------------------
-- Shell / root@localhost --
------------------------------

-- Question 1
/* Se connecter à la base de donnée en tant que root*/
-- / \connect root@localhost


/* Afficher les bases de données et les utilisateurs existants. Puis, supprimer les bases et les utilisateurs
que vous avez crées (pas ceux du système), sauf votre base pour la SAE. */

-- Se mettre en SQL dans le terminal avec la commande : \sql

-- Lister les utilisateurs
SELECT user, host FROM mysql.user ;
/*
 +------------------+-----------+
| user             | host      |
+------------------+-----------+
| lescop           | localhost |
| mysql.infoschema | localhost |
| mysql.session    | localhost |
| mysql.sys        | localhost |
| root             | localhost |
+------------------+-----------+
5 rows in set (0.0007 sec)
*/

-- Lister les bases de données
SHOW DATABASES ;
/*
+--------------------+
| Database           |
+--------------------+
| bd_r206            |
| information_schema |
| mysql              |
| performance_schema |
| sae_s2_04          |
| sys                |
+--------------------+
6 rows in set (0.0015 sec)
*/

-- Supprimer les bases de données existantes sauf pour la SAE
DROP DATABASE bd_r206 ;
/* Query OK, 32 rows affected (0.2210 sec) */

-- Supprimer les utilisateurs que vous avez créez
DROP USER lescop@localhost ;
/* Query OK, 0 rows affected, 1 warning (0.0055 sec)
Warning (code 4005): User 'lescop'@'localhost' is referenced as a definer account in a view.
*/


/*
2. Créer :
• la base de données appelée bd_iut
• l’utilisateur pham@localhost de mot de passe mdp pham muni du rôle prédéfini DBA avec :
GRANT ALL PRIVILEGES ON *.* TO pham@localhost WITH GRANT OPTION;
*/
CREATE DATABASE bd_iut ;
/* Query OK, 1 row affected (0.0047 sec) */
-- Vérification
SHOW DATABASES ;
/*
+--------------------+
| Database           |
+--------------------+
| bd_iut             |
| information_schema |
| mysql              |
| performance_schema |
| sae_s2_04          |
| sys                |
+--------------------+
6 rows in set (0.0013 sec)
*/

CREATE USER pham@localhost IDENTIFIED BY 'mdp_pham' ;
/* Query OK, 0 rows affected (0.0084 sec) */
-- Vérification
SELECT user, host FROM mysql.user ;
/*
+------------------+-----------+
| user             | host      |
+------------------+-----------+
| mysql.infoschema | localhost |
| mysql.session    | localhost |
| mysql.sys        | localhost |
| pham             | localhost |
| root             | localhost |
+------------------+-----------+
5 rows in set (0.0012 sec)
*/

GRANT ALL PRIVILEGES ON *.* TO pham@localhost WITH GRANT OPTION;
/* Query OK, 0 rows affected (0.0052 sec) */


------------------------------
-- Workbench / pham@localhost --
------------------------------

-- Question 4 :
/*
4. Créer les vues suivantes avec WITH CHECK OPTION 2 :
• vue Etud Stag Ent réalisant la jointure entre les tables Etudiant, Stagiaire et Entreprise
• vue Etud App Ent réalisant la jointure entre les tables Etudiant, Apprentis et Entreprise
*/

CREATE OR REPLACE VIEW vue_Etud_Stag_Ent AS
SELECT *
FROM Etudiant
    JOIN Stagiaire ON etudStagiaire = idEtud
        JOIN Entreprise ON entrepriseStage = idEntreprise;

-- Consultation :
SELECT * FROM vue_Etud_Stag_Ent;
/* 58 tuples
21900078	RECOLIN	ANGELE	F	S	LYCEE POLYVALENT LES BOURDONNIERES	44	B	DA	FI	Licence Pro Nantes	21900078	1	1	ACCENTURE	75
21903040	LAGUE	PIERRE	M	S	LYCEE GENERAL FRANCOIS RENE DE CHATEAUBR	35	C	IA	FI	Licence info Vannes	21903040	1	1	ACCENTURE	75
21902500	BERNIER	ALLAN	M	STI2D	LYCEE GENERAL ET TECHNOLOGIQUE JOLIOT-CU	35	C	DA	FI	EPITECH Rennes	21902500	2	2	ADAPEI56	56
21900834	LENOBLE	ALEXANDRE	M	S	LYCEE GEN ET TECHNOL PRIVE ST PAUL	56	A	IA	FI	Licence info Vannes	21900834	3	3	ADM	56
21902446	DINEL	ROMAIN	M	S	LYCEE F.R de Chateaubriand COMBOURG - CO	35	D	IA	FI	EPITECH Rennes	21902446	6	6	APRAS	35
21900858	LE GARREC	VINCENT	M	S	LYCEE GEN. TECHNO VICTOR HUGO (HENNEBONT	56	A	IA	FI	ENSIBS cyberdéfense	21900858	9	9	BYSTAMP	56
21900316	GODET	LOUIS-XAVIER	M	STI2D	LYCEE TECHNOLOGIQUE PRIVE LES RIMAINS	35	A	IA	FI	Licence Info Poitiers	21900316	10	10	CADIOU INDUSTRIE	29
21902833	GONTARD	ALICE	F	S	LYCEE GENERAL ET TECHNO DE CORNOUAILLE	29	B	IA	FI	ESNA	21902833	11	11	CAISSE DEPARGNE LOIRE DROME ARDECHE	42
*/

CREATE OR REPLACE VIEW vue_Etud_App_Ent AS
SELECT *
FROM Etudiant
         JOIN Apprenti ON etudApp = idEtud
            JOIN Entreprise ON entrepriseApp = idEntreprise;

-- Consultation :
SELECT * FROM vue_Etud_App_Ent;
/* 24 tuples
21807519	LEBORGNE	AYMERICK	M	S	LYCEE GENERAL ET TECHNOLOGIQUE JOLIOT-CU	56	A	IA	App	Licence info Rennes	21807519	5	RF	5	ANVERGUR	56
21900162	MADELAINE	DYLAN	M	S	LYCEE GEN ET TECHNOL PRIVE ST SAUVEUR	35	C	DA	App	Licence info Vannes	21900162	49	MM	49	MENBAT	56
21900219	LE PORS	YANIS	M	S	LYCEE POLYVALENT PAUL SERUSIER	29	A	IA	App	Licence info Brest	21900219	49	MM	49	MENBAT	56
21900234	PLOQUIN	NATHAN	M	S	LY ST JOSEPH VANNES	56	C	IA	App	ENSIBS cyberdéfense	21900234	71	MM	71	YOGOKO	35
*/

------------------------------
-- Schell / root@localhost --
------------------------------

-- Quetion 5 :
/*
Créer les utilisateurs :
• kamp@localhost de mot de passe mdp kamp
• evenas@localhost de mot de passe mdp evenas
• baudont@localhost de mot de passe mdp baudont
• fleurquin@localhost de mot de passe mdp fleurquin
*/

CREATE USER kamp@localhost IDENTIFIED BY 'kamp';
CREATE USER evenas@localhost IDENTIFIED BY 'evenas';
CREATE USER baudont@localhost IDENTIFIED BY 'baudont';
CREATE USER fleurquin@localhost IDENTIFIED BY 'fleurquin';

-- Verifiaction :
SELECT user, host FROM mysql.user ;
/* 9 tuples
 MySQL  localhost:33060+ ssl  SQL > SELECT user, host FROM mysql.user ;
+------------------+-----------+
| user             | host      |
+------------------+-----------+
| baudont          | localhost |
| evenas           | localhost |
| fleurquin        | localhost |
| kamp             | localhost |
| mysql.infoschema | localhost |
| mysql.session    | localhost |
| mysql.sys        | localhost |
| pham             | localhost |
| root             | localhost |
+------------------+-----------+
*/


-- Question 6 :
/*
6. Créer les rôles :
• bd iut lecture accordant tous les droits de lecture sur la base
• bd iut ecriture accordant tous les droits d’écriture sur la base
*/
CREATE ROLE bd_iut_lecture;
GRANT SELECT ON bd_iut.* TO bd_iut_lecture;

CREATE ROLE bd_iut_ecriture;
GRANT INSERT, UPDATE, DELETE ON bd_iut.* TO bd_iut_ecriture;

-- Verification :
SHOW GRANTS FOR bd_iut_lecture;
/* 2 tuples
+----------------------------------------------------+
| Grants for bd_iut_lecture@%                        |
+----------------------------------------------------+
| GRANT USAGE ON *.* TO `bd_iut_lecture`@`%`         |
| GRANT SELECT ON `bd_iut`.* TO `bd_iut_lecture`@`%` |
+----------------------------------------------------+
2 rows in set (0.0006 sec)
*/

SHOW GRANTS FOR bd_iut_ecriture;
/* 2 tuples
+---------------------------------------------------------------------+
| Grants for bd_iut_ecriture@%                                        |
+---------------------------------------------------------------------+
| GRANT USAGE ON *.* TO `bd_iut_ecriture`@`%`                         |
| GRANT INSERT, UPDATE, DELETE ON `bd_iut`.* TO `bd_iut_ecriture`@`%` |
+---------------------------------------------------------------------+
2 rows in set (0.0007 sec)
*/


-- Question 7 :
/*
Accorder aux utilisateurs, en vous aidant des rôles, les privilèges suivants :
• kamp@localhost : lecture et écriture sur la base
• evenas@localhost : lecture sur la base et écriture sur Etudiant et GroupeInfo1
• baudont@localhost : lecture sur la base et écriture sur vue Etud App Ent
• fleurquin@localhost : lecture sur la base et écriture sur la colonne poursuiteEtudes de la
table Etudiant
*/

GRANT bd_iut_ecriture, bd_iut_lecture TO 'kamp'@'localhost';

GRANT bd_iut_lecture TO 'evenas'@'localhost';
GRANT SELECT ON bd_iut.GroupeInfo1 TO 'evenas'@'localhost';
GRANT INSERT, UPDATE, DELETE ON bd_iut.Etudiant TO 'evenas'@'localhost';
GRANT INSERT, UPDATE, DELETE ON bd_iut.GroupeInfo1 TO 'evenas'@'localhost';

GRANT bd_iut_lecture TO 'baudont'@'localhost';
GRANT INSERT, UPDATE, DELETE ON bd_iut.vue_Etud_App_Ent TO 'baudont'@'localhost';

GRANT bd_iut_lecture TO 'fleurquin'@'localhost';
GRANT UPDATE (poursuiteEtudes) ON bd_iut.Etudiant TO 'fleurquin'@'localhost';

-- Valider les rôles
SET DEFAULT ROLE ALL TO 'kamp'@'localhost', 'evenas'@'localhost', 'baudont'@'localhost', 'fleurquin'@'localhost';


-- Question 8 :
/*
8. Vérifier la bonne prise en compte des droits :
• Directement avec Workbench
• En interrogeant les tables de la base mysql avec Workbench
• Avec SHOW GRANTS depuis le Shell
*/

-- Avec workbench, se connecter en tant que root pour voir ensuite les droits de chaque utilisateurs.
-- Selectionner la base de donnée bd_iut et cliquer ensuite sur Administration.
-- Dirigez-vous vers l'onglet "Users ans Privileges" puis cliquez sur l'utilisateur souhaité afin de voir les privilèges sur la base de donnée.

-- Verification :
SHOW GRANTS FOR 'kamp'@'localhost';
/* 2 tuples
| Grants for kamp@localhost                                              |
+------------------------------------------------------------------------+
| GRANT USAGE ON *.* TO `kamp`@`localhost`                               |
| GRANT `bd_iut_ecriture`@`%`,`bd_iut_lecture`@`%` TO `kamp`@`localhost` |
+----------------------------
*/

-- Verfication :
SHOW GRANTS FOR 'evenas'@'localhost';
/* 4 tuples
+----------------------------------------------------------------------------------------+
| Grants for evenas@localhost                                                            |
+----------------------------------------------------------------------------------------+
| GRANT USAGE ON *.* TO `evenas`@`localhost`                                             |
| GRANT INSERT, UPDATE, DELETE ON `bd_iut`.`etudiant` TO `evenas`@`localhost`            |
| GRANT SELECT, INSERT, UPDATE, DELETE ON `bd_iut`.`groupeinfo1` TO `evenas`@`localhost` |
| GRANT `bd_iut_lecture`@`%` TO `evenas`@`localhost`                                     |
+----------------------------------------------------------------------------------------+
4 rows in set (0.0007 sec)
*/

-- Verification :
SHOW GRANTS FOR 'baudont'@'localhost';
/* 3 tuples
+--------------------------------------------------------------------------------------+
| Grants for baudont@localhost                                                         |
+--------------------------------------------------------------------------------------+
| GRANT USAGE ON *.* TO `baudont`@`localhost`                                          |       |
| GRANT INSERT, UPDATE, DELETE ON `bd_iut`.`vue_etud_app_ent` TO `baudont`@`localhost` |
| GRANT `bd_iut_lecture`@`%` TO `baudont`@`localhost`                                  |
+--------------------------------------------------------------------------------------+
3 rows in set (0.0007 sec)
*/

-- Verification :
SHOW GRANTS FOR 'fleurquin'@'localhost';
/* 3 tuples
+------------------------------------------------------------------------------------+
| Grants for fleurquin@localhost                                                     |
+------------------------------------------------------------------------------------+
| GRANT USAGE ON *.* TO `fleurquin`@`localhost`                                      |
| GRANT UPDATE (`poursuiteEtudes`) ON `bd_iut`.`etudiant` TO `fleurquin`@`localhost` |
| GRANT `bd_iut_lecture`@`%` TO `fleurquin`@`localhost`                              |
+------------------------------------------------------------------------------------+
3 rows in set (0.0010 sec)
*/


