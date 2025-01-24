-- =================== SAE S104 Partie 2 (2024-2025) =========================
/*
Nom : LESCOP et BOEFFARD
Prénom : Nolann et Kevin
Groupe : 1D1
*/


-- ************** Tache 1 : Création des tables **************

DROP TABLE Location;
DROP TABLE Vente;
DROP TABLE Client;
DROP TABLE Bien;
DROP TABLE Agent;
DROP TABLE Agence;

CREATE TABLE Agence (
    numAgence NUMBER
        CONSTRAINT pk_numAgence PRIMARY KEY,
    adresse VARCHAR2(50),
    horaire NUMBER
);

CREATE TABLE Agent (
    numAgent NUMBER
        CONSTRAINT pk_numAgent PRIMARY KEY,
    nom VARCHAR2(50)
        CONSTRAINT nn_nom NOT NULL,
    prenom VARCHAR2(50),
    salaire FLOAT
        CONSTRAINT ck_salaire CHECK (salaire > 2 * 1767),
    estResponsable NUMBER(1)
        CONSTRAINT ck_estResponsable CHECK (estResponsable = 0 OR estResponsable = 1),
    sonAgence NUMBER
        CONSTRAINT nn_sonAgence NOT NULL
        CONSTRAINT fk_sonAgence REFERENCES Agence(numAgence)
);

CREATE TABLE Bien (
    idBien NUMBER
        CONSTRAINT pk_idBien PRIMARY KEY,
    adresse VARCHAR2(50)
        CONSTRAINT nn_adresse NOT NULL
        CONSTRAINT uq_adresse UNIQUE,
    nbPieces NUMBER
        CONSTRAINT nn_nbPieces NOT NULL,
    valeur FLOAT
        CONSTRAINT ck_valeur CHECK (valeur > 0),
    anneeConst NUMBER,
    cave NUMBER(1),
        CONSTRAINT ck_cave CHECK (cave = 0 OR cave = 1),
    parking NUMBER(1),
        CONSTRAINT ck_parking CHECK (parking = 0 OR parking = 1),
    enTravaux NUMBER(1),
        CONSTRAINT ck_enTravaux CHECK (enTravaux = 0 OR enTravaux = 1),
    unAgent NUMBER
        CONSTRAINT nn_unAgent NOT NULL
        CONSTRAINT fk_unAgent REFERENCES Agent(numAgent)
);

CREATE TABLE Client (
    idClient NUMBER
        CONSTRAINT pk_idClient PRIMARY KEY,
    nomClient VARCHAR2(50)
        CONSTRAINT nn_nomClient NOT NULL,
    prenomClient VARCHAR2(50),
    email VARCHAR2(50)
        CONSTRAINT nn_email NOT NULL,
        CONSTRAINT ck_email CHECK (email LIKE '%@%.%'),
    adresse VARCHAR2(50),
    tel VARCHAR2(10)
);

CREATE TABLE Vente (
    leBienV NUMBER
        CONSTRAINT fk_leBienV REFERENCES Bien(idBien),
    leClientV NUMBER
        CONSTRAINT fk_leClientV REFERENCES Client(idClient),
    CONSTRAINT pk_leBienV_leClientV PRIMARY KEY (leBienV, leClientV),
    dateVente DATE,
    prix FLOAT
        CONSTRAINT ck_prix CHECK (prix > 0)
);

CREATE TABLE Location (
    leBienL NUMBER
        CONSTRAINT fk_leBienL REFERENCES Bien(idBien),
    leClientL NUMBER
        CONSTRAINT fk_leClientL REFERENCES Client(idClient),
    CONSTRAINT pk_leBienL_leClientL PRIMARY KEY (leBienL, leClientL),
    dateDebut DATE,
    dateFin DATE,
    CONSTRAINT ck_dateFin CHECK (dateFin > dateDebut),
    loyer FLOAT
        CONSTRAINT ck_loyer CHECK (loyer > 0)
);

/*
 CT :
+ Un bien en travaux ne peut pas être en location
+ Un bien ne peut être loué que s’il est disponible (pas en cours de location)
 */

-- 1) ajouter d’une colonne dans une table (à votre choix)
ALTER TABLE Bien ADD disponible NUMBER(1) CONSTRAINT ck_disponible CHECK (disponible = 0 OR disponible = 1);

-- 2) supprimer la colonne ajoutéee ;
ALTER TABLE Bien DROP COLUMN disponible;

-- 3) ajouter d’une contrainte (à votre choix) ;
ALTER TABLE Bien ADD CONSTRAINT ck_nbPieces CHECK (nbPieces > 0);

-- 4) de supprimer la contrainte ajoutée.
ALTER TABLE Bien DROP CONSTRAINT ck_nbPieces

