/*
TP1 R2.06 Rappels LDD/LMD avec Oracle SQL
Nom : LESCOP
Prénom : Nolann
Groupe : 1D1
*/

-- Question 1
-- Schéma relationnel
/*
Enseignant (idEns(1), nomEns, prenomEns)
GroupeInfo1 (idGroupe(1), tuteurGroupe=@Enseignant.idEns)
Etudiant (idEtud(1), nomEtud, prenomEtud, sexe, bac, nomLycee, depLycee, leGroupeInfo1=@leGroupeInfos.idGroupe, parcoursInfo2, formationInfo2, poursuiteEtudes)
Entreprise (idEntreprise(1), nomEntreprise, depEntreprise)
Stagiaire (etudStagiaire=@Etudiant.idEtu(1), entrepriseStage=@Entreprise.idEntreprise)
Apprenti (etudApp=@Etudiant.idEtud(1), entrepriseApp=@Entreprise.idEntreprise, tuteurApp=@Enseignant.idEns)
*/

-- Question 3
DROP TABLE Apprenti;
DROP TABLE Stagiaire;
DROP TABLE Entreprise;
DROP TABLE Etudiant;
DROP TABLE GroupeInfo1;
DROP TABLE Enseignant;


CREATE TABLE Enseignant (
    idEns VARCHAR2(50)
        CONSTRAINT pk_idEns PRIMARY KEY,
    nomEns VARCHAR2(50),
    prenomEns VARCHAR2(50)
);

CREATE TABLE GroupeInfo1 (
    idGroupe VARCHAR2(50)
        CONSTRAINT pk_idGroupe PRIMARY KEY,
    tuteurGroupe VARCHAR2(50)
        CONSTRAINT fk_tuteurGroupe REFERENCES Enseignant(idEns)
);

CREATE TABLE Etudiant (
    idEtud NUMBER
      CONSTRAINT pk_idEtud PRIMARY KEY,
    nomEtud VARCHAR2(50),
    prenomEtud VARCHAR2(50),
    sexe VARCHAR2(1),
    bac VARCHAR2(50),
    nomLycee VARCHAR2(50),
    depLycee VARCHAR2(50),
    leGroupeInfo1 VARCHAR2(50)
        CONSTRAINT fk_leGroupeInfo1 REFERENCES GroupeInfo1(idGroupe),
    parcoursInfo2 VARCHAR2(50),
    formationInfo2 VARCHAR2(50),
    poursuiteEtudes VARCHAR2(50)
);

CREATE TABLE Entreprise (
    idEntreprise NUMBER
        CONSTRAINT pk_idEntreprise PRIMARY KEY,
    nomEntreprise VARCHAR2(50),
    depEntreprise VARCHAR2(50)
);

CREATE TABLE Stagiaire (
    etudStagiaire NUMBER
        CONSTRAINT pk_etudStagiaire PRIMARY KEY
        CONSTRAINT fk_etudStagiaire REFERENCES Etudiant(idEtud),
    entrepriseStage NUMBER
        CONSTRAINT fk_entrepriseStage REFERENCES Entreprise(idEntreprise)
);

CREATE TABLE Apprenti (
    etudApp NUMBER
        CONSTRAINT pk_etudApp PRIMARY KEY
        CONSTRAINT fk_etudApp REFERENCES Etudiant(idEtud),
    entrepriseApp NUMBER
        CONSTRAINT fk_entrepriseApp REFERENCES Entreprise(idEntreprise),
    tuteurApp VARCHAR2(50)
        CONSTRAINT fk_tuteurApp REFERENCES Enseignant(idEns)
);

-- Question 5
SELECT * FROM Enseignant;
SELECT * FROM GroupeInfo1;
SELECT * FROM Etudiant;
SELECT * FROM Entreprise;
SELECT * +FROM Stagiaire;
SELECT * FROM Apprenti;

-- Question 6

-- projection + restriction
/* les noms des entreprises bretonnes triés par l'odre alphabétique */

SELECT DISTINCT UPPER(nomEntreprise)
FROM Entreprise
WHERE depEntreprise IN (22, 29, 35, 56)
ORDER BY UPPER(nomEntreprise);

/*
 --------------------------------------------------
SOLIDR
UBS
VIDEOR INFORMATIQUE
WINNOVE MEDICAL
YOGOKO

49 lignes sélectionnées.
 */

/* Les ids des enseignants qui ne sont pas tuteur d'apprentis */
SELECT DISTINCT UPPER(idEns)
FROM Enseignant
MINUS
SELECT DISTINCT UPPER(tuteurApp)
FROM Apprenti;

/*

UPPER(IDENS)
--------------------------------------------------
EL
FL
FME
GK
IB
LN
MLL
MTP
MV
NLS
PJ

UPPER(IDENS)
--------------------------------------------------
SR
TG
XR

14 lignes sélectionnées.
 */

/* Les entreprises dans le Morbhian qui proposent des stages ? */
SELECT DISTINCT UPPER(nomEntreprise)
FROM Entreprise, Stagiaire
WHERE entrepriseStage=idEntreprise
    AND depEntreprise = 56;

/*
 UPPER(NOMENTREPRISE)
--------------------------------------------------
EXOTIC ANIMALS
SOLIDR
IOLE SOLUTIONS
SMURFIT KAPPA FRANCE
CGI
BYSTAMP
COLLEGE SACRE COEUR
ERCII
CONSEIL DEPARTEMENTAL DU MORBIHAN
DIOTAL SAS
SEM LORIENT KEROMAN

UPPER(NOMENTREPRISE)
--------------------------------------------------
IRISA, EQUIPE OBELIX
JULIANA MULTIMEDIA
DAWIZZ
PLASTEOL
ADAPEI56
CREDIT AGRICOLE
ENSIBS
ADM
SCM VIAUD-FORMAGNE
OPTIC PERFORMANCE

21 lignes sélectionnées.
 */