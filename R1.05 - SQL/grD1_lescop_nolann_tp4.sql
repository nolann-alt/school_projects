/*
TP4 R1.05 Base de données VENTEVOITURE
Nom : LESCOP
Prénom : Nolann
Groupe : 1D1
*/

-- ================= Question 2
/*
 Vehicule (immat (1), leModele = @Modele.idModele, dateAchat)
Client (idClient (1), nom (NN), prenom, adresse)
Modele (idModele (1), marque, couleur, puissance)
Location (unClient = @Client.idClient (1), unVehicule = @Vehicule.immat (1), dateLocation, duree)
Contraintes textuelles :
a) les attributs idClient, idModele, puissance et duree sont de type NUMBER.
b) les attributs dateAchat et dateLocation sont de type DATE
c) les autres attributs sont de type VARCHAR2(.)
d) la date de location d’un v´ehicule ne peut pas ˆetre avant sa date d’achat.
e) la puissance (en nombre de chevaux fiscaux) et la dur´ee (en nombre de jours) doivent ˆetre strictement
positives
 */

/*
 Q2 : Ecrire le code SQL permettant de cr´eer les tables ´ Vehicule et Location (supposant que les tables
Client et Modele ont ´et´e cr´e´ees) en tenant bien compte des contraintes textuelles.
Quelle est la contrainte nous ne pouvons pas traiter dans le script de cr´eation de tables ? Pourquoi ?
 */

CREATE TABLE Vehicule (
    immat VARCHAR2(50)
        CONSTRAINT pk_immat PRIMARY KEY,
    leModele VARCHAR2(50)
        CONSTRAINT fk_leModele REFERENCES Modele(nomModele),
    dateAchat DATE
)

CREATE TABLE Location (
    unClient VARCHAR2(50)
        CONSTRAINT fk_unClient REFERENCES Client(idClient),
    unVehicule VARCHAR2(50)
        CONSTRAINT fk_unVehicule REFERENCES Vehicule(immat),
    dateLocation DATE,
    duree NUMBER
    CONSTRAINT pk_Location PRIMARY KEY (unClient, unVehicule)
)

-- La contrainte que nous ne pouvons pas traiter dans le script de création de tables est la contrainte textuelle d) car on ne peut pas vérifier si la date de location d'un vehicule est supérieure à la date d'achat du véhicule

-- ================= Question 3

/*
 Q3 : Apr`es r´eflexion, la date d’achat doit ˆetre renseign´ee. Ecrire le code SQL permettant d’ajouter ´
cette contrainte sans modifier le script de cr´eation de la table Vehicule.
 */

ALTER TABLE Vehicule ADD CONSTRAINT nn_dateAchat CHECK (dateAchat IS NOT NULL);

-- ================= Question 4

/*
 Q4 : Ecrire un code SQL permettant de tester la contrainte d’int´egrit´e r´ef´erentielle sur la cl´e ´etrang`ere ´
unClient de la table Location (effectuer des insertions n´ecessaires dans les autres tables pour pouvoir le
faire).
 */

INSERT INTO Client VALUES (1, 'LeBreton', 'Bernard')
INSERT INTO Modele (1, 'Dacia', 'Rouge', 1000)
INSERT INTO Vehicule VALUES (1234, 1, '20/10/2022');
INSERT INTO Location VALUES (2, 1, '22/5/2023');

-- ================= Question 5

/*
Q5 : Traduire le diagramme de classes UML suivant (compl´et´e par des contraintes textuelles) en sch´ema
relationnel.
*/

/*

Concession(idConc(1), nomConc, capital)
Constructeur(idConst(1), nomConst(NN))
Client(idClient(1), nomClient(2), prenomClient(2))
Voiture(immat(1), modele(NN), couleur, concess = @Concession.idConc, acheteur = @Client.idClient, livreur = @constructeur.idConst(NN))
Assurance([LeConstructeur = @Constructeur.idConst, LeClient = @Client.idClient](1), dateContrat)
Travail([UnConc = @Concession.idConc, UnConst = @Constructeur.idConst](1))

Contraintes :
- Voiture[leClient] = Client[idClient] (Tout client doit avoir au moins une voiture)
- Une Concession... 1Constructeur (1 concession doit avoir au moins un constructeur)
- Un Constructeur... 2Concession (Un constructeur doit avoir au moins 2 concessions)
- Un Client doit être assuré par au mois un constructeur

*/

-- ================= Question 6
/*
Q6 : Ecrire un script SQL permettant de cr´eer les tables en tenant bien compte des contraintes tex- ´
tuelles. Quelles sont des contraintes qui ne peuvent pas ˆetre prises en compte par le script de cr´eation de
tables ?
*/

DROP TABLE Travail;
DROP TABLE Assurance;
DROP TABLE Voiture;
DROP TABLE Client;
DROP TABLE Constructeur;
DROP TABLE Concession;

CREATE TABLE Concession(
    idConc VARCHAR2(50)
        CONSTRAINT pk_idConc PRIMARY KEY,
    nomConc VARCHAR2(50),
    capital NUMBER
);

CREATE TABLE Constructeur(
    idConst VARCHAR2(50)
        CONSTRAINT pk_idConst PRIMARY KEY,
    nomConst VARCHAR2(50)
        CONSTRAINT nn_nomConst NOT NULL
);

CREATE TABLE Client(
    idClient VARCHAR(50)
        CONSTRAINT pk_idClient PRIMARY KEY,
    nomClient VARCHAR(50)
        CONSTRAINT nn_nomClient NOT NULL,
    prenomClient VARCHAR(50)
        CONSTRAINT nn_prenomClient NOT NULL,
    CONSTRAINT uq_Client UNIQUE (nomClient, prenomClient)
);

CREATE TABLE Voiture(
    immat VARCHAR2(50)
        CONSTRAINT pk_immat PRIMARY KEY,
    modele VARCHAR2(50)
        CONSTRAINT nn_modele NOT NULL,
    couleur VARCHAR2(50),
    concess VARCHAR2(50)
        CONSTRAINT fk_concess REFERENCES Concession(idConc),
    acheteur VARCHAR2(50)
        CONSTRAINT fk_acheteur REFERENCES Client(idClient),
    livreur VARCHAR2(50)
        CONSTRAINT fk_livreur REFERENCES Constructeur(idConst)
);

CREATE TABLE Assurance(
    LeConstructeur VARCHAR2(50)
        CONSTRAINT fk_LeConstructeur REFERENCES Constructeur(idConst),
    LeClient VARCHAR2(50)
        CONSTRAINT fk_LeClient REFERENCES Client(idClient),
    dateContrat DATE,
    CONSTRAINT pk_Assurance PRIMARY KEY (LeConstructeur, LeClient)    
);

CREATE TABLE Travail(
    UnConc VARCHAR2(50)
        CONSTRAINT fk_UnConc REFERENCES Concession(idConc),
    UnConst VARCHAR2(50)
        CONSTRAINT fk_UnConst REFERENCES Constructeur(idConst),
    CONSTRAINT pk_Travail PRIMARY KEY (UnConc, UnConst)
);

-- Les contraintes qui ne peuvent pas être prises en compte par le script de création de tables sont les contraintes textuelles

-- ================= Question 7

/*
Q7 : La date de contrat doit absolument ˆetre renseign´ee. Ecrire le code SQL permettant d’ajouter cette ´
contrainte.
*/

ALTER TABLE Assurance ADD CONSTRAINT nn_dateContrat CHECK (dateContrat IS NOT NULL);

-- ================= Question 8

/*
Q8 : Apr`es r´eflexion, nous voulons ajouter une colonne pour stocker les adresses email des clients.
Ajouter l’attribut email dans la table Client avec une v´erification de la bonne syntaxe.
*/

ALTER TABLE Client ADD email VARCHAR2(50) CONSTRAINT ck_email CHECK (email LIKE '%@%.%');

/*
 Q9 : Ecrire un script SQL permettant d’ins´erer 2 tuples dans la table Voiture. Effectuer les insertions ´
n´ecessaires dans d’autres tables pour pouvoir le faire.
 */

INSERT INTO Concession VALUES ('1', 'Concession 1', 100000);
INSERT INTO Constructeur VALUES ('1', 'Constructeur 1');
INSERT INTO Client VALUES ('1', 'LEBRETON', 'Bernard', NULL);
INSERT INTO Voiture VALUES ('1', 'Dacia', 'Rouge', '1', '1', '1');

-- Supprimer un EMAIL : ALTER TABLE Client DROP COLUMN EMAIL;


 /*
  Q10 : A partir des tables remplies, effectuer des tester de contraintes d’int´egrit´e r´ef´erentielle `a votre
choix (avec INSERT INTO et avec DELETE FROM). Ensuite, proposer des commandes SQL pour la modification de table avec ALTER TABLE et la modification des donn´ees avec UPDATE.
  */

INSERT INTO Travail VALUES ('1', '1');
DELETE FROM Travail WHERE UnConc = '1' AND UnConst = '1';

INSERT INTO Constructeur VALUES ('2', 'Constructeur 2');
DELETE FROM Constructeur WHERE idConst = '2' AND nomConst = 'Constructeur 2';

ALTER TABLE Concession ADD adresse VARCHAR2(50);

UPDATE Concession SET adresse = 'Adresse 1' WHERE idConc = '1';

