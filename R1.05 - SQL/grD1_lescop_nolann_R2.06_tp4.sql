DROP TABLE IF EXISTS Apprenti;
DROP TABLE IF EXISTS Stagiaire;
DROP TABLE IF EXISTS Entreprise;
DROP TABLE IF EXISTS Etudiant;
DROP TABLE IF EXISTS GroupeInfo1;
DROP TABLE IF EXISTS Enseignant;


CREATE TABLE Enseignant (
                            idEns VARCHAR(50),
                            nomEns VARCHAR(50),
                            prenomEns VARCHAR(50),
                            CONSTRAINT pk_idEns PRIMARY KEY (idEns)
);

CREATE TABLE GroupeInfo1 (
                             idGroupe VARCHAR(50),
                             tuteurGroupe VARCHAR(50) NOT NULL,
                             CONSTRAINT pk_idGroupe PRIMARY KEY (idGroupe),
                             CONSTRAINT fk_tuteurGroupe FOREIGN KEY (tuteurGroupe) REFERENCES Enseignant (idEns)
);

CREATE TABLE Etudiant
(
    idEtud INT,
    nomEtud VARCHAR(20),
    prenomEtud VARCHAR(20),
    sexe VARCHAR(5),
    bac VARCHAR(5),
    nomLycee VARCHAR(50),
    depLycee INT,
    leGroupeInfo1 VARCHAR(5) NOT NULL,
    parcoursInfo2 VARCHAR(5),
    formationInfo2 VARCHAR(5),
    poursuiteEtudes VARCHAR(50),
    CONSTRAINT pk_Etudiant PRIMARY KEY (idEtud),
    CONSTRAINT fk_Etudiant_GroupeInfo1 FOREIGN KEY (leGroupeInfo1) REFERENCES GroupeInfo1 (idGroupe)
)
;

CREATE TABLE Entreprise
(
    idEntreprise INT,
    nomEntreprise VARCHAR(50),
    depEntreprise INT,
    CONSTRAINT pk_Entreprise PRIMARY KEY (idEntreprise)
)
;

CREATE TABLE Stagiaire
(
    etudStagiaire INT,
    entrepriseStage INT NOT NULL,
    CONSTRAINT fk_Stagiaire_Etudiant FOREIGN KEY (etudStagiaire) REFERENCES Etudiant (idEtud),
    CONSTRAINT pk_Stagiaire PRIMARY KEY (etudStagiaire),
    CONSTRAINT fk_Stagiaire_Entreprise FOREIGN KEY (entrepriseStage) REFERENCES Entreprise (idEntreprise)
)
;

CREATE TABLE Apprenti
(
    etudApp INT,
    entrepriseApp INT NOT NULL,
    tuteurApp VARCHAR(5) NOT NULL,
    CONSTRAINT fk_Apprenti_Etudiant FOREIGN KEY (etudApp) REFERENCES Etudiant (idEtud),
    CONSTRAINT pk_Apprenti PRIMARY KEY (etudApp),
    CONSTRAINT fk_Apprenti_Entreprise FOREIGN KEY (entrepriseApp) REFERENCES Entreprise (idEntreprise),
    CONSTRAINT fk_Apprenti_Enseignant FOREIGN KEY (tuteurApp) REFERENCES Enseignant (idEns)
)
;


-- LESCOP Nolann 1D1 TP4 R2.06

-- Question 1
SELECT COUNT(*)
FROM Pilote;
/* 1 tuple
# COUNT(*)
'7'
*/

SELECT COUNT(compPil)
FROM Pilote;
/* 1 tuple
# COUNT(compPil)
'6'
*/

SELECT COUNT(DISTINCT compPil)
FROM Pilote;
/*
# COUNT(DISTINCT compPil)
'4'
*/

SELECT MAX(nbHVol)
FROM Pilote;
/*
# MAX(nbHVol)
'3000'
*/

SELECT AVG(nbHVol)
FROM Pilote;
/*
# AVG(nbHVol)
'1457.1429'
*/

SELECT STDDEV(nbHVol)
FROM Pilote;
/*
# STDDEV(nbHVol)
'1029.0177603036832'
*/

SELECT nomPilote
FROM Pilote 
WHERE nbHVol > (SELECT AVG (nbHVol)
				FROM Pilote );
/*
# nomPilote
'Ridard'
'Fleurquin'
'Kamp'
*/

SELECT nomPilote, nbHVol
FROM Pilote 
WHERE nbHVol > (SELECT AVG (nbHVol)
				FROM Pilote );
/*
# nomPilote, nbHVol
'Ridard', '1500'
'Fleurquin', '3000'
'Kamp', '3000'
*/

SELECT compAv, COUNT(*)
FROM Avion
GROUP BY compAv;
/*
# compAv, COUNT(*)
'1', '3'
'2', '1'
'3', '1'
'4', '2'
'5', '2'
*/

SELECT compAv, COUNT(DISTINCT leTypeAvion)
FROM Avion
GROUP BY compAv;
/*
# compAv, COUNT(DISTINCT leTypeAvion)
'1', '3'
'2', '1'
'3', '1'
'4', '2'
'5', '1'
*/

SELECT nomComp, COUNT(DISTINCT leTypeAvion)
FROM Compagnie, Avion
WHERE idComp = compAv
GROUP BY nomComp
ORDER BY nomComp;
/*
# nomComp, COUNT(DISTINCT leTypeAvion)
'Air France', '3'
'American Airlines', '2'
'Corsair Internat', '1'
'EasyJet', '1'
'Ryanair', '1'
*/

SELECT unPilote, COUNT(unTypeAvion)
FROM Qualification
GROUP BY unPilote;
/*
# unPilote, COUNT(unTypeAvion)
'1', '2'
'2', '2'
'3', '1'
'4', '3'
'5', '2'
'7', '2'
*/

SELECT idPilote, COUNT(unTypeAvion)
FROM Pilote
	LEFT JOIN Qualification ON idPilote = unPilote
GROUP BY idPilote;
/*
# idPilote, COUNT(unTypeAvion)
'1', '2'
'2', '2'
'3', '1'
'4', '3'
'5', '2'
'6', '0'
'7', '2'
*/

SELECT compPil, COUNT(idPilote)
FROM Pilote
GROUP BY compPil;
/*
# compPil, COUNT(idPilote)
NULL, '1'
'1', '2'
'3', '1'
'4', '2'
'5', '1'
*/

SELECT idComp, COUNT(idPilote)
FROM Compagnie
	LEFT JOIN Pilote ON idComp = compPil
GROUP BY idComp;
/*
# idComp, COUNT(idPilote)
'1', '2'
'2', '0'
'3', '1'
'4', '2'
'5', '1'
*/

SELECT MAX(nbPilotes)
FROM ( SELECT compPil, COUNT(idPilote) nbPilotes
		FROM Pilote
        GROUP BY compPil
        ) AS SUBQUERY
;
/*
# MAX(nbPilotes)
'2'
*/

SELECT compPil, COUNT(idPilote) nbPilotes
FROM Pilote
GROUP BY compPil
HAVING COUNT(compPil) = 2;
/*
# compPil, nbPilotes
'1', '2'
'4', '2'
*/

SELECT compPil
FROM Pilote
GROUP BY compPil
HAVING COUNT(idPilote) = (SELECT MAX(nb)
							FROM (SELECT COUNT(*) AS nb
                            FROM Compagnie
                            GROUP BY pays) AS SUBQUERY
						  );
/*
# compPil
'1'
'4'
*/

-- Question 2
SELECT COUNT(Etudiant.depLycee)
FROM Etudiant
WHERE depLycee IN (56, 22, 29, 35);
/*
 # COUNT(Etudiant.depLycee)
'81'
 */

-- Question 3
SELECT COUNT(Etudiant.poursuiteEtudes)
FROM Etudiant;
/*
 # COUNT(Etudiant.poursuiteEtudes)
'74'
 */

 -- Question 4
SELECT COUNT(DISTINCT tuteurApp)
FROM Apprenti;
/*
# COUNT(DISTINCT tuteurApp)
'7'
 */

-- Question 5 :
SELECT COUNT(Apprenti.etudApp)
FROM Apprenti
    JOIN Enseignant ON idEns = Apprenti.tuteurApp
        JOIN Entreprise E ON Apprenti.entrepriseApp = idEntreprise
WHERE prenomEns = 'Pascal' AND nomEns = 'Baudont'
AND depEntreprise = '56';
/*
 # COUNT(Apprenti.etudApp)
'4'
 */

 -- Question 6 :
SELECT COUNT(parcoursInfo2) / COUNT(idEtud)
FROM Etudiant;
/*
# COUNT(parcoursInfo2) / COUNT(idEtud)
'0.7664'
 */

-- Question 7 :
SELECT COUNT(DISTINCT tuteurApp) / COUNT(DISTINCT idEns)
FROM Enseignant, Apprenti;
/*
 # COUNT(DISTINCT tuteurApp) / COUNT(DISTINCT idEns)
'0.3333'
 */

-- Question 8 :
SELECT nomEns, COUNT(Apprenti.etudApp) nbApprenti
FROM Enseignant, Apprenti
WHERE idEns = Apprenti.tuteurApp
GROUP BY nomEns
ORDER BY nomEns;
/* 7 tuples
 # nomEns, nbApprenti
'Baudont', '6'
'Fleurquin', '2'
'Kamp', '2'
'Lefevre', '2'
'Mannevy', '7'
'Tonin', '2'
'Tuffigo', '3'
 */

 -- Question 9 :
SELECT Enseignant.nomEns, COUNT(Apprenti.etudApp) nbApprenti
FROM Enseignant
LEFT JOIN Apprenti ON Enseignant.idEns = tuteurApp
GROUP BY nomEns
ORDER BY nbApprenti DESC;
/* 21 tuples
 # nomEns, nbApprenti
'Mannevy', '7'
'Baudont', '6'
'Tuffigo', '3'
'Kamp', '2'
 */

-- Question 10 :
SELECT MAX(nbApprenti)
FROM (SELECT COUNT(Apprenti.etudApp) AS nbApp
      FROM Apprenti
      GROUP BY tuteurApp
      ) AS subQuerry
;
/* 1 tuple
 # MAX(nbApp)
'7'

 */

-- Question 11 :
SELECT Enseignant.nomEns
FROM Apprenti, Enseignant
WHERE idEns = Apprenti.tuteurApp
GROUP BY tuteurApp
HAVING COUNT(etudApp) = (SELECT MAX(nbApp)
                         FROM (SELECT COUNT(etudApp) AS nbApp
                               FROM Apprenti
                               GROUP BY tuteurApp
                               ) AS subQuerry);
/*
 # nomEns
'Mannevy'
 */

 -- Question 12 :
SELECT AVG(nbApp) nbMoyenParTuteur
FROM (SELECT COUNT(Apprenti.etudApp) AS nbApp
      FROM Apprenti
      GROUP BY tuteurApp
      ) AS subQuerry
;
/*
 # nbMoyenParTuteur
'3.4286'
 */

-- Question 13 :
SELECT Enseignant.nomEns
FROM Apprenti, Enseignant
WHERE idEns = Apprenti.tuteurApp
GROUP BY tuteurApp
HAVING COUNT(etudApp) > (SELECT AVG(nbApp)
                         FROM (SELECT COUNT(etudApp) AS nbApp
                               FROM Apprenti
                               GROUP BY tuteurApp
                              ) AS subQuerry);
/*
 # nomEns
'Mannevy'
'Baudont'
 */

-- Question 14
SELECT Etudiant.depLycee, COUNT(DISTINCT idEtud)
FROM Etudiant
GROUP BY depLycee
ORDER BY COUNT(DISTINCT idEtud) DESC;
/* 17 tuples
 # depLycee, COUNT(DISTINCT idEtud)
'56', '34'
'35', '25'
'29', '19'
'44', '7'
NULL, '3'
'22', '3'
 */

-- Question 15
SELECT Etudiant.depLycee, COUNT(DISTINCT idEtud)
FROM Etudiant
WHERE depLycee IN (56, 22, 29, 35)
GROUP BY depLycee
ORDER BY COUNT(DISTINCT idEtud)
LIMIT 1;
/*
 # depLycee, COUNT(DISTINCT idEtud)
'22', '3'
 */

-- Question 16
SELECT Etudiant.poursuiteEtudes, COUNT(Etudiant.idEtud)
FROM Etudiant
WHERE poursuiteEtudes IS NOT NULL
GROUP BY poursuiteEtudes
HAVING COUNT(Etudiant.idEtud) >= 5;
/* 4 tuples
# poursuiteEtudes, COUNT(Etudiant.idEtud)
'ENSIBS cyberdéfense', '11'
'Licence info Vannes', '10'
'Travail', '5'
'Licence Pro Vannes Delice', '5'
 */

-- Question 17
SELECT poursuiteEtudes, COUNT(Etudiant.idEtud)
FROM Etudiant
WHERE poursuiteEtudes IS NOT NULL
GROUP BY poursuiteEtudes
HAVING COUNT(Etudiant.idEtud) = (SELECT MAX(nbApp)
                                 FROM (SELECT COUNT(Etudiant.idEtud) AS nbApp
                                       FROM Etudiant
                                       WHERE poursuiteEtudes IS NOT NULL
                                       GROUP BY poursuiteEtudes
                                      ) AS subQuerry);
/* 1 tuple
# poursuiteEtudes, COUNT(Etudiant.idEtud)
'ENSIBS cyberdéfense', '11'
 */

-- Question 18
/* Afficher les 3 poursuites d’´etudes les plus repr´esent´ees parmi les ´etudiants du parcours
D´eveloppeurs d’Applications (DA). */
SELECT poursuiteEtudes, COUNT(Etudiant.idEtud)
FROM Etudiant
WHERE poursuiteEtudes IS NOT NULL
AND parcoursInfo2 = 'DA'
GROUP BY poursuiteEtudes
ORDER BY COUNT(Etudiant.idEtud) DESC
LIMIT 3;
/* 3 tuples
# poursuiteEtudes, COUNT(Etudiant.idEtud)
'Licence info Vannes', '5'
'Licence Pro Vannes Delice', '5'
'Travail', '3'
 */
