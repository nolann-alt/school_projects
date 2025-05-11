/*
-- création d'une nouvelle base de données
CREATE DATABASE bd_banque ;
USE bd_banque;

Schéma relationnel :
--------------------
Agence(numAgence (1), telAgence, adAgence)
Agent(numAgent (1), nomAgent, prenomAgent, salaire, 
	estDirecteur, sonAgence=@Agence.numAgence NN)
Client(numClient (1), nomClient, prenomClient, adClient, 
	dateNaissClient, sonAgent=@Agent.numAgent NN)
Compte(numCompte (1), solde, typeCompte)
Operation(numOperation (1), dateOperation, 
	typeOperation, montant, leClient=@Client.numClient NN,
	leCompte=@Compte.numCompte NN)
Appartient([unCompte=@Compte.numCompte, unClient=@Client.numClient] (1))

*/

DROP TABLE IF EXISTS Appartient;
DROP TABLE IF EXISTS Operation;
DROP TABLE IF EXISTS Compte;
DROP TABLE IF EXISTS Client;
DROP TABLE IF EXISTS Agent;
DROP TABLE IF EXISTS Agence;

CREATE TABLE Agence
	(
	numAgence INTEGER,
	telAgence VARCHAR(30),
	adAgence VARCHAR(30),

    CONSTRAINT pk_Agence PRIMARY KEY(numAgence)
	);
	
CREATE TABLE Agent
	(
	numAgent INTEGER,
	nomAgent VARCHAR(30),
	prenomAgent VARCHAR(30),
	salaire FLOAT,
    directeur INTEGER,
    sonAgence INTEGER NOT NULL,

    CONSTRAINT pk_Agent PRIMARY KEY(numAgent),
	CONSTRAINT ck_salaire CHECK(salaire>=1480),
	CONSTRAINT ck_directeur CHECK(directeur=0 OR directeur=1),
	CONSTRAINT fk_Agent_Agence FOREIGN KEY(sonAgence) REFERENCES Agence(numAgence)
	);
	
CREATE TABLE Client
	(
	numClient INTEGER,
	nomClient VARCHAR(30) NOT NULL,
	prenomClient VARCHAR(30) NOT NULL,
	adClient VARCHAR(30),
	dateNaissanceClient DATE,
	sonAgent INTEGER NOT NULL,

    CONSTRAINT pk_Client PRIMARY KEY(numClient),
	CONSTRAINT fk_Client_Agent FOREIGN KEY(sonAgent) REFERENCES Agent(numAgent)
	);
	
CREATE TABLE Compte
	(
	numCompte INTEGER,
	solde FLOAT,
	typeCompte VARCHAR(30) NOT NULL,

    CONSTRAINT pk_Compte PRIMARY KEY(numCompte),
	CONSTRAINT ck_typeCompte CHECK(typeCompte='COURANT' OR typeCompte='EPARGNE')
	);
	
CREATE TABLE Operation
	(
	numOperation INTEGER,
	dateOperation DATE DEFAULT (CURRENT_DATE),
	typeOperation VARCHAR(30),
	montant FLOAT,
	leClient INTEGER NOT NULL,
	leCompte INTEGER NOT NULL,

    CONSTRAINT pk_Operation PRIMARY KEY(numOperation),
    CONSTRAINT ck_typeOperation CHECK(typeOperation='RETRAIT' OR typeOperation='DEPOT'),
    CONSTRAINT ck_montant CHECK(montant>=0),
    CONSTRAINT fk_Operation_Client FOREIGN KEY(leClient) REFERENCES Client(numClient),
	CONSTRAINT fk_Operation_Compte FOREIGN KEY(leCompte) REFERENCES Compte(numCompte)
	);
	
CREATE TABLE Appartient
	(
	unCompte INTEGER,
	unClient INTEGER,
	
    CONSTRAINT fk_Appartient_Compte FOREIGN KEY(unCompte) REFERENCES Compte(numCompte),
	CONSTRAINT fk_Appartient_Client FOREIGN KEY(unClient) REFERENCES Client(numClient),
	CONSTRAINT pk_Appartient PRIMARY KEY (unCompte,unClient)
	);