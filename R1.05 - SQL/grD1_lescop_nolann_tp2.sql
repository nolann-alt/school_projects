/*
TP2 R1.05 Création de tables
Nom : LESCOP
Prénom : Nolann
Groupe : 1D1
*/
-- Exercice 1
/*
Schéma relationnel :
Enseignant(nomEns(1), prenomEns, adresse, statut)
Cycle(num(1), enseignantResponsable = @Enseignant.nomEns(UQ)(NN) )
Cours(nomCours(1), volumeH, lEnseignant=@Enseignant.nomEns(NN), leCycle=@Cycle.num(NN) )
Requiert([cours=@Cours.nomCours, coursRequis=@Cours.nomCours](1) )
--Avec :
- Les 2 attributs num et volumeH sont de type NUMBER(precision,scale)
- Les autres attributs sont des chaînes de caractèeres (type VARCHAR2(length) en SQL ORACLE)
*/

-- Q1:
-- ordre de créarion des tables :
    Enseignant, Cycle, Cours
-- ordre de desruction des tableaux :
    Cours, Cycle, Enseignant

-- Q2: script de création de tables

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
        volumeH NUMBER (2, 1),
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

--Q3: Quels sont des ajouts néecessaires pour fonctionner votre script de créeation de tables lors d’une ree-exeecution ?
-- Il faut ajouter DROP pour chaque table dans le sens inverse de création : 
/* 
DROP TABLE Requiert;
DROP TABLE Cours;
DROP TABLE Cycle;
DROP TABLE Enseignant;
*/

-- Exercice 2 :

--Q4:
/*
Ecrire le script de cr´eation de tables de la base de donn´ees ´ Bateau suivant :
Proprietaire(idProprietaire(1), nomProprietaire(2), prenomProprietaire(2), emailProprietaire(UQ)(NN))
Emplacement(idEmplacement(1), longueurEmplacement(NN), coutJournalier(NN))
Bateau(idBateau(1), nomBateau, longueurBateau(NN), leProprietaire = @Proprietaire.idProprietaire(NN), leStationnement = @Emplacement.idEmplacement(UQ) )
Reservation(idReservation(1), dateDebut(NN), dateFin(NN), leBateau = @Bateau.idBateau(NN),
lEmplacement = @Emplacement.idEmplacement(NN))
——Avec :
- Les attributs d’identifiant et de taille sont de type NUMBER
- Les autres attributs sont de type VARCHAR2
- Les attributs dateDebut et dateFin sont de type DATE
*/

DROP TABLE Reservation;
DROP TABLE Bateau;
DROP TABLE Emplacement;
DROP TABLE Proprietaire;


CREATE TABLE Proprietaire(
    idProprietaire NUMBER
        CONSTRAINT pk_idProprietaire PRIMARY KEY,
    nomProprietaire VARCHAR2(50)
        CONSTRAINT nn_nomProprietaire NOT NULL,
    prenomProprietaire VARCHAR2(50)
        CONSTRAINT nn_prenomProprietaire NOT NULL,
    CONSTRAINT uq_Proprietaire UNIQUE (nomProprietaire, prenomProprietaire),
    emailProprietaire VARCHAR2(100)
        CONSTRAINT nn_emailProprietaire NOT NULL
        CONSTRAINT uq_emailProprietaire UNIQUE
        CONSTRAINT ck_emailFormat CHECK (emailProprietaire LIKE '%@%.%') -- Q5 c)
);

CREATE TABLE Emplacement (
    idEmplacement NUMBER
        CONSTRAINT pk_idEmplacement PRIMARY KEY,
    longueurEmplacement NUMBER
        CONSTRAINT nn_longueurEmplacement NOT NULL,
    coutJournalier NUMBER
        CONSTRAINT nn_coutJournalier NOT NULL
);

CREATE TABLE Bateau (
    idBateau NUMBER
        CONSTRAINT pk_idBateau PRIMARY KEY,
    nomBateau VARCHAR2(50),
    longueurBateau NUMBER
        CONSTRAINT nn_longueurBateau NOT NULL
        CONSTRAINT ck_longueurBateau CHECK (longueurBateau <= 20), -- Q5 a)
    leProprietaire NUMBER
        CONSTRAINT nn_leProprietaire NOT NULL
        CONSTRAINT fk_leProprietaire REFERENCES Proprietaire(idProprietaire),
    leStationnement NUMBER
        CONSTRAINT uq_leStationnement UNIQUE
        CONSTRAINT fk_leStationnement REFERENCES Emplacement(idEmplacement)
);

CREATE TABLE Reservation (
    idReservation NUMBER
        CONSTRAINT pk_idReservation PRIMARY KEY,
    dateDebut DATE
        CONSTRAINT nn_dateDebut NOT NULL,
    dateFin DATE
        CONSTRAINT nn_dateFin NOT NULL,
    CONSTRAINT ck_dateFinApresDateDebut CHECK (dateFin > dateDebut), -- Q5 b)
    leBateau NUMBER
        CONSTRAINT nn_leBateau NOT NULL
        CONSTRAINT fk_leBateau REFERENCES Bateau(idBateau),
    lEmplacement NUMBER
        CONSTRAINT nn_lEmplacement NOT NULL
        CONSTRAINT fk_lEmplacement REFERENCES Emplacement(idEmplacement)
);

