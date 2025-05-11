/*
SQL - TP7 - Administration MySQL
Prénom : Nolann
Nom : LESCOP
Groupe 1D1
*/


-- Question 9 :
/* Ecrire un script de test, personnel et commenté, le plus complet possible. Ce script permet de
tester les privilèges de chaque utilisateur créé dans la question 5. Vous pouvez utiliser Shell ou
Workbench pour effectuer les tests. Illustrer bien les résultats de test dans votre script (dans les
blocs de commentaires).*/


/* Test des rôles suivants :
• kamp@localhost : lecture et écriture sur la base
• evenas@localhost : lecture sur la base et écriture sur Etudiant et GroupeInfo1
• baudont@localhost : lecture sur la base et écriture sur vue Etud App Ent
• fleurquin@localhost : lecture sur la base et écriture sur la colonne poursuiteEtudes de la table Etudiant
 */


-- Pour tout les utilisateurs :
SET SQL_SAFE_UPDATES = 0;



------------------------------------------
-- Workbench / kamp@localhost --
------------------------------------------

-- Test pour kamp (lecture et écriture globale) ----------------------------------------------------------------------------------------------------------------------------
use bd_iut;

-- Requêtes fonctionnelles
SELECT * From Etudiant; -- lecture d'une table de la base de donnée
/* 107 tuples
# idEtud, nomEtud, prenomEtud, sexe, bac, nomLycee, depLycee, leGroupeInfo1, parcoursInfo2, formationInfo2, poursuiteEtudes
'21702527', 'VIAUD', 'BENJAMIN', 'M', 'S', 'LYCEE GEN TECH PRIVE NOTRE DAME DU VOEU', '29', 'C', 'IA', 'FI', 'Licence Info Rennes'
'21802862', 'JOSSE', 'ELOUAN', 'M', 'S', 'LPO LYCEE DES METIERS COLBERT', '56', 'D', 'DA', 'FI', NULL
'21807519', 'LEBORGNE', 'AYMERICK', 'M', 'S', 'LYCEE GENERAL ET TECHNOLOGIQUE JOLIOT-CU', '56', 'A', 'IA', 'App', 'Licence info Rennes'
'21900078', 'RECOLIN', 'ANGELE', 'F', 'S', 'LYCEE POLYVALENT LES BOURDONNIERES', '44', 'B', 'DA', 'FI', 'Licence Pro Nantes'
'21900144', 'GUENNEC', 'PAUL', 'M', 'S', 'LYCEE GEN. TECHNO VICTOR HUGO (HENNEBONT', '56', 'D', 'IA', 'FI', 'ENSIBS cyberdéfense'
 */

INSERT INTO Enseignant VALUES ('A', 'Lescop', 'Nolann'); -- Insertion d'un enseignant dans la base de donnée
/* 22 tuples
# idEns, nomEns, prenomEns
'A', 'Lescop', 'Nolann'
'EL', 'Lemaitre', 'Elodie'
'FL', 'Lesueur', 'Francois'
'FME', 'Merciol', 'Francois'
'GK', 'Kerbellec', 'Goulven'
 */

DELETE FROM Enseignant WHERE idEns = '1';

UPDATE Enseignant SET prenomEns = 'Matthieu' WHERE idEns = A;
UPDATE Enseignant SET nomEns = 'Gouélo' WHERE idEns = A;
/* 22 tuples
# idEns, nomEns, prenomEns
'A', 'Gouélo', 'Matthieu'
'EL', 'Lemaitre', 'Elodie'
'FL', 'Lesueur', 'Francois'
'FME', 'Merciol', 'Francois'
*/





------------------------------------------
-- Workbench / evenas@localhost --
------------------------------------------

-- Test pour evenas (lecture globale et écriture sur Etudiant et GroupeInfo1) ----------------------------------------------------------------------------------------------
use bd_iut;

-- Activation du rôle
SELECT CURRENT_ROLE();
SET ROLE bd_iut_lecture;
SELECT CURRENT_ROLE();

SELECT * FROM GroupeInfo1;
/* 4 tuples
# idGroupe, tuteurGroupe
'B', 'HT'
'C', 'LN'
'D', 'PT'
'A', 'TG'
*/

SELECT * FROM Etudiant;
/* 107 tuples
 # idEtud, nomEtud, prenomEtud, sexe, bac, nomLycee, depLycee, leGroupeInfo1, parcoursInfo2, formationInfo2, poursuiteEtudes
'21702527', 'VIAUD', 'BENJAMIN', 'M', 'S', 'LYCEE GEN TECH PRIVE NOTRE DAME DU VOEU', '29', 'C', 'IA', 'FI', 'Licence Info Rennes'
'21802862', 'JOSSE', 'ELOUAN', 'M', 'S', 'LPO LYCEE DES METIERS COLBERT', '56', 'D', 'DA', 'FI', NULL
'21807519', 'LEBORGNE', 'AYMERICK', 'M', 'S', 'LYCEE GENERAL ET TECHNOLOGIQUE JOLIOT-CU', '56', 'A', 'IA', 'App', 'Licence info Rennes'
'21900078', 'RECOLIN', 'ANGELE', 'F', 'S', 'LYCEE POLYVALENT LES BOURDONNIERES', '44', 'B', 'DA', 'FI', 'Licence Pro Nantes'
'21900144', 'GUENNEC', 'PAUL', 'M', 'S', 'LYCEE GEN. TECHNO VICTOR HUGO (HENNEBONT', '56', 'D', 'IA', 'FI', 'ENSIBS cyberdéfense'
 */

SELECT * FROM Enseignant;
/*
 # idEns, nomEns, prenomEns
'A', 'Gouélo', 'Matthieu'
'EL', 'Lemaitre', 'Elodie'
'FL', 'Lesueur', 'Francois'
'FME', 'Merciol', 'Francois'
'GK', 'Kerbellec', 'Goulven'
*/

INSERT INTO GroupeInfo1 (idGroupe, tuteurGroupe) VALUES ('G1', 'A');
/* 5 tuples
# idGroupe, tuteurGroupe
'G1', 'A'
'B', 'HT'
'C', 'LN'
'D', 'PT'
'A', 'TG'
*/

UPDATE GroupeInfo1 SET tuteurGroupe = 'EL' WHERE idGroupe = 'G1';
/* 5 tuples
# idGroupe, tuteurGroupe
'G1', 'EL'
'B', 'HT'
'C', 'LN'
'D', 'PT'
'A', 'TG'
 */

DELETE FROM GroupeInfo1 WHERE idGroupe = 'G1';
/* 4 tuples
# idGroupe, tuteurGroupe
'B', 'HT'
'C', 'LN'
'D', 'PT'
'A', 'TG'
 */

-- Erreur
DELETE FROM Enseignant WHERE idEns = 'A';
/*
 15:27:07	DELETE FROM Enseignant WHERE idEns = 'A'	Error Code: 1142. DELETE command denied to user 'evenas'@'localhost' for table 'enseignant'	0.000 sec
*/





------------------------------------------
-- Workbench / baudont@localhost --
------------------------------------------

-- Test pour baudont (lecture globale et écriture sur vue Etud_App_Ent) ----------------------------------------------------------------------------------------------------
use bd_iut;

-- Activation du rôle
SELECT CURRENT_ROLE();
SET ROLE bd_iut_lecture;
SELECT CURRENT_ROLE();

SELECT * FROM Enseignant;
/* 22 tuples
# idEns, nomEns, prenomEns
'A', 'Gouélo', 'Matthieu'
'EL', 'Lemaitre', 'Elodie'
'FL', 'Lesueur', 'Francois'
'FME', 'Merciol', 'Francois'
'GK', 'Kerbellec', 'Goulven'
 */

SELECT * FROM vue_Etud_App_Ent;
/* 24 tuples
# idEtud, nomEtud, prenomEtud, sexe, bac, nomLycee, depLycee, leGroupeInfo1, parcoursInfo2, formationInfo2, poursuiteEtudes, etudApp, entrepriseApp, tuteurApp, idEntreprise, nomEntreprise, depEntreprise
'21807519', 'LEBORGNE', 'AYMERICK', 'M', 'S', 'LYCEE GENERAL ET TECHNOLOGIQUE JOLIOT-CU', '56', 'A', 'IA', 'App', 'Licence info Rennes', '21807519', '5', 'RF', '5', 'ANVERGUR', '56'
'21900162', 'MADELAINE', 'DYLAN', 'M', 'S', 'LYCEE GEN ET TECHNOL PRIVE ST SAUVEUR', '35', 'C', 'DA', 'App', 'Licence info Vannes', '21900162', '49', 'MM', '49', 'MENBAT', '56'
'21900219', 'LE PORS', 'YANIS', 'M', 'S', 'LYCEE POLYVALENT PAUL SERUSIER', '29', 'A', 'IA', 'App', 'Licence info Brest', '21900219', '49', 'MM', '49', 'MENBAT', '56'
'21900234', 'PLOQUIN', 'NATHAN', 'M', 'S', 'LY ST JOSEPH VANNES', '56', 'C', 'IA', 'App', 'ENSIBS cyberdéfense', '21900234', '71', 'MM', '71', 'YOGOKO', '35'
'21900238', 'TIRLEMONT', 'KIERIAN', 'M', 'S', 'LYCEE GENERAL ET TECHNOLOGIQUE JULLIOT D', '50', 'D', 'IA', 'App', 'ESIEA Laval', '21900238', '64', 'MM', '64', 'SMARTMOOV', '35'
*/

-- Erreur attendue : INSERT non autorisé car la vue est protégée
INSERT INTO vue_Etud_App_Ent (idEtud, nomEtud, entrepriseApp, nomEntreprise) VALUES (2403222, 'Lescop', 72, 'Imagina');

-- Erreur
INSERT INTO GroupeInfo1 (idGroupe, tuteurGroupe) VALUES ('G1', 'A');
/*
 15:47:15	INSERT INTO GroupeInfo1 (idGroupe, tuteurGroupe) VALUES ('G1', 'A')	Error Code: 1142. INSERT command denied to user 'baudont'@'localhost' for table 'groupeinfo1'	0.000 sec
*/





------------------------------------------
-- Workbench / fleurquin@localhost --
------------------------------------------

-- Test pour fleurquin (lecture globale et écriture sur colonne poursuiteEtudes) ------------------------------------------------------------------------------------------
use bd_iut;

-- Activation du rôle
SELECT CURRENT_ROLE();
SET ROLE bd_iut_lecture;
SELECT CURRENT_ROLE();

SELECT * FROM Enseignant;
/* 22 tuples
# idEns, nomEns, prenomEns
'A', 'Gouélo', 'Matthieu'
'EL', 'Lemaitre', 'Elodie'
'FL', 'Lesueur', 'Francois'
'FME', 'Merciol', 'Francois'
'GK', 'Kerbellec', 'Goulven'
 */

-- Test autorisé : Mise à jour de poursuiteEtudes
UPDATE Etudiant SET poursuiteEtudes = 'Doctorat' WHERE idEtud = 2403222;
-- Vérification
SELECT * FROM Etudiant;
/* 108 tuples
# idEtud, nomEtud, prenomEtud, sexe, bac, nomLycee, depLycee, leGroupeInfo1, parcoursInfo2, formationInfo2, poursuiteEtudes
'2403222', 'Lescop', NULL, NULL, NULL, NULL, NULL, 'G1', NULL, NULL, 'Doctorat'
'21702527', 'VIAUD', 'BENJAMIN', 'M', 'S', 'LYCEE GEN TECH PRIVE NOTRE DAME DU VOEU', '29', 'C', 'IA', 'FI', 'Licence Info Rennes'
'21802862', 'JOSSE', 'ELOUAN', 'M', 'S', 'LPO LYCEE DES METIERS COLBERT', '56', 'D', 'DA', 'FI', NULL
'21807519', 'LEBORGNE', 'AYMERICK', 'M', 'S', 'LYCEE GENERAL ET TECHNOLOGIQUE JOLIOT-CU', '56', 'A', 'IA', 'App', 'Licence info Rennes'
'21900078', 'RECOLIN', 'ANGELE', 'F', 'S', 'LYCEE POLYVALENT LES BOURDONNIERES', '44', 'B', 'DA', 'FI', 'Licence Pro Nantes'
*/

-- Erreur attendue : Mise à jour d'une colonne non autorisée
UPDATE Etudiant SET sexe = 'H' WHERE idEtud = 2403222;
/*
15:52:50	UPDATE Etudiant SET sexe = 'H' WHERE idEtud = 2403222	Error Code: 1143. UPDATE command denied to user 'fleurquin'@'localhost' for column 'sexe' in table 'etudiant'	0.000 sec
*/



