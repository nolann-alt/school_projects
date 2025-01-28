/*
TP3 R1.05 Test de contraintes de création de tables
Nom : LESCOP
Prénom : Nolann
Groupe : 1D1
/*
Enseignant(nomEns(1), prenomEns, adresse, statut)
Cycle(num(1), enseignantResponsable = @Enseignant.nomEns(UQ)(NN) )
Cours(nomCours(1), volumeH, lEnseignant=@Enseignant.nomEns(NN), leCycle=@Cycle.num(NN) )
Requiert([cours=@Cours.nomCours, coursRequis=@Cours.nomCours](1) )
*/

*/
-- ========== Question 1
/*
Q1 : R´e-ex´ecutez votre script de cr´eation de tables de la base Etudes lors du TP2 (exercice 1). Vous
pouvez ´egalement utiliser le script (TP3 script creation tables.sql) disponible sur Moodle.
*/

-- Fait

DROP TABLE Requiert;
DROP TABLE Cours;
DROP TABLE Cycle;
DROP TABLE Enseignant;

CREATE TABLE Enseignant(
    nomEns VARCHAR2(50)
        CONSTRAINT pk_Enseignant PRIMARY KEY,
    prenomEns VARCHAR2(50),
    adresse VARCHAR2(50),
    staut VARCHAR2(50)
);

CREATE TABLE Cycle(
    num NUMBER
        CONSTRAINT pk_num PRIMARY KEY,
    enseignantResponsable VARCHAR2(50)
        CONSTRAINT fk_enseignantResponsable REFERENCES Enseignant(nomEns)
        CONSTRAINT nn_enseignantResponsable NOT NULL
        CONSTRAINT uq_enseignantResponsable UNIQUE   
);

CREATE TABLE Cours(
    nomCours VARCHAR2(50)
        CONSTRAINT pk_nomCours PRIMARY KEY,
    volumeH NUMBER,
    LEnseignant VARCHAR2(50)
        CONSTRAINT pk_LEnseignant REFERENCES Enseignant(nomEns)
        CONSTRAINT nn_LEnseignant NOT NULL,
    leCycle NUMBER
        CONSTRAINT fk_leCycle REFERENCES Cycle(num)
        CONSTRAINT nn_leCycle NOT NULL        
);

CREATE TABLE Requiert(
    cours VARCHAR2(50)
        CONSTRAINT fk_cours REFERENCES Cours(nomCours),
    coursRequis VARCHAR2(50)
        CONSTRAINT fk_coursRequis REFERENCES Cours(nomCours),
    CONSTRAINT pk_Requiert PRIMARY KEY (cours, coursRequis) 
);

-- =========== Question 2
/*
Q2 : Proposez un script avec des insertions de lignes (t-uples) dans les tables cr´e´ees avec au moins 5
enseignants, 3 cycles, 5 cours et quelques requis de cours `a votre choix. Utilisez le syntaxe suivant (vu
dans le cours) :
INSERT INTO TableName [(attribute1, attribute2, ...)] VALUES (value, value2, ...);
*/

-- 5 enseignants
INSERT INTO Enseignant (nomEns, prenomEns) VALUES ('Pham', 'Minhtan');
INSERT INTO Enseignant (nomEns, prenomEns) VALUES ('Lescop', 'Nolann');
INSERT INTO Enseignant (nomEns, prenomEns) VALUES ('LE GOAT', 'Batltasar');
INSERT INTO Enseignant (nomEns, prenomEns) VALUES ('DUPONT', 'Jean');
INSERT INTO Enseignant (nomEns, prenomEns) VALUES ('DURAND', 'Pierre');

-- 3 cycles
INSERT INTO Cycle VALUES (1, 'Lescop');
INSERT INTO Cycle VALUES (2, 'LE GOAT');
INSERT INTO Cycle VALUES (3, 'DUPONT');

-- 5 cours
INSERT INTO Cours VALUES ('Maths', 10, 'Pham', 1);
INSERT INTO Cours VALUES ('Physique', 10, 'Lescop', 2);
INSERT INTO Cours VALUES ('Chimie', 10, 'LE GOAT', 2);
INSERT INTO Cours VALUES ('Informatique', 10, 'DUPONT', 3);
INSERT INTO Cours VALUES ('Anglais', 10, 'DURAND', 3);

-- 3 requis de cours
INSERT INTO Requiert VALUES ('Maths', 'Physique');
INSERT INTO Requiert VALUES ('Maths', 'Chimie');
INSERT INTO Requiert VALUES ('Maths', 'Informatique');

-- =========== Question 3
/*
Q3 : Quels sont des ajouts néecessaires pour fonctionner votre script préecéedent lors d’une rée-exéecution ?
*/

-- Avant de réexecuter il faut supprimer les tuples déjà insérés sinon on aura des erreurs.
-- Il faut donc vider les tables avec la commande suivante :
DELETE FROM ...;

-- =========== Question 4

/*
Q4 : Nous voulons tester les contraintes qui ont ´et´e d´eclar´ees lors de la cr´eation de tables. En utilisant
le syntaxe INSERT INTO ... VALUES ... , ´ecrivez des commandes pour tester :
a) l’existence de la cl´e primaire de la table Enseignant
b) l’unicit´e de la cl´e primaire de la table Enseignant
c) l’existence et l’unicit´e de la cl´e ´etrang`ere dans la table Cycle
*/

-- a) l’existence de la cl´e primaire de la table Enseignant

INSERT INTO Enseignant (nomEns, prenomEns) VALUES (NULL, NULL);

-- Rapport d'erreur -
-- ORA-01400: cannot insert NULL into ("NOLANN"."ENSEIGNANT"."NOMENS")

-- b) l’unicit´e de la cl´e primaire de la table Enseignant

INSERT INTO Enseignant (nomEns, prenomEns) VALUES ('Pham', 'Mihntan');

-- Rapport d'erreur -
-- ORA-00001: unique constraint (NOLANN.PK_ENSEIGNANT) violated

-- c) l’existence et l’unicit´e de la cl´e ´etrang`ere dans la table Cycle

INSERT INTO Cycle VALUES (1, 'Pham');

-- Rapport d'erreur -
-- ORA-00001: unique constraint (NOLANN.PK_NUM) violated


-- =========== Question 5

/*
Q5 : Tous les cours doivent avoir un volume d’heures (volumeH) strictement positif.
a) Ajoutez cette contrainte dans la table Cours utilisant le syntaxe ALTER TABLE ... ADD
CONSTRAINT ... (cf. page 45 du cours). Quel est l’avantage de cette technique par rapport `a l’ajout
de cette contrainte dans votre script de cr´eation de table (cf. Q6 du TP2) ?
b) Ecrivez la commande pour tester cette contrainte ´
c) Utilisant le syntaxe ALTER TABLE ..., ´ecrivez la commande pour supprimer cette contrainte
*/

-- a) Ajoutez cette contrainte dans la table Cours utilisant le syntaxe ALTER TABLE ... ADD CONSTRAINT ... (cf. page 45 du cours). Quel est l’avantage de cette technique par rapport `a l’ajout de cette contrainte dans votre script de cr´eation de table (cf. Q6 du TP2) ?

ALTER TABLE Cours ADD CONSTRAINT nn_volumeH CHECK(volumeH > 0);
-- L'avantage de cette technique est que l'on peut ajouter des contraintes après la création de la table.

-- b) Ecrivez la commande pour tester cette contrainte ´

INSERT INTO Cours VALUES ('Francais', -10, 'Pham', 1);

-- Rapport d'erreur -
-- ORA-02290: check constraint (NOLANN.NN_VOLUMEH) violated

-- c) Utilisant le syntaxe ALTER TABLE ..., ´ecrivez la commande pour supprimer cette contrainte

ALTER TABLE Cours DROP CONSTRAINT nn_volumeH;

-- =========== Question 6

/*
Q6 : Proposez des commandes pour tester les fonctionnalit´es d’ajout et de suppression de colonnes
en utilisant le syntaxe ALTER TABLE ... (cf. page 45 du cours). Faites attention sur la suppression de
colonnes.
*/

-- Ajout de colonnes
ALTER TABLE Enseignant ADD age NUMBER;
ALTER TABLE Enseignant ADD genre VARCHAR2(50);

-- Suppression de colonnes
ALTER TABLE Enseignant DROP COLUMN age;
ALTER TABLE Enseignant DROP COLUMN genre;

-- =========== Question 7

/*
Q7 : Utilisant des syntaxes de UPDATE et DELETE (avec des conditions dans le WHERE, cf. pages 59-60
du cours), proposez des commandes pour effectuer des modifications et des suppressions de donn´ees dans
vos tables.
*/

-- Modification de données
UPDATE Enseignant SET prenomEns = 'Minh Tan' WHERE nomEns = 'Pham';
UPDATE Enseignant SET adresse = 'Rennes' WHERE nomEns = 'Pham';

-- Suppression de données
DELETE FROM Requiert WHERE coursRequis = 'Chimie';
DELETE FROM Requiert WHERE coursRequis = 'Physique';