-- Question 1 :

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

-- Question 2 :

SET SQL_SAFE_UPDATES = 0;

DELETE FROM Apprenti;
DELETE FROM Stagiaire;
DELETE FROM Entreprise;
DELETE FROM Etudiant;
DELETE FROM GroupeInfo1;
DELETE FROM Enseignant;

-- Table Enseignant

INSERT INTO Enseignant VALUES
                           ('PB','Baudont','Pascal'),
                           ('IB','Borne','Isabelle'),
                           ('RF','Fleurquin','Regis'),
                           ('TG','Godin','Thibault'),
                           ('PJ','Joucla','Philippe'),
                           ('JFK','Kamp','Jean-Francois'),
                           ('GK','Kerbellec','Goulven'),
                           ('MLL','Le Lain','Matthieu'),
                           ('NLS','Le Sommer','Nicolas'),
                           ('SL','Lefevre','Sebastien'),
                           ('EL','Lemaitre','Elodie'),
                           ('FL','Lesueur','Francois'),
                           ('MM','Mannevy','Muriel'),
                           ('FME','Merciol','Francois'),
                           ('LN','Naert','Lucie'),
                           ('MTP','Pham','Minh-Tan'),
                           ('SR','Raut','Sophie'),
                           ('XR','Roirand','Xavier'),
                           ('PT','Tonin','Philippe'),
                           ('HT','Tuffigo','Helene'),
                           ('MV','Volin','Manon');

--  Table GroupeInfo1

INSERT INTO GroupeInfo1 VALUES
                            ('A','TG'),
                            ('B','HT'),
                            ('C','LN'),
                            ('D','PT');

--  Table Etudiant

INSERT INTO Etudiant VALUES
                         (21900754,'ADAM','ANTOINE','M','S','LYCEE GENERAL ET TECHNOLOGIQUE FELIX LE',22,'B','IA','App',null),
                         (21900678,'AJELLO','PAUL','M','S','LYCEE GENERAL PRIVE ST FRANCOIS-XAVIER',56,'B',null,null,null),
                         (21905324,'ARTAUD','PAUL','M','STI2D','LYCEE POLYVALENT PRIVE ST JOSEPH LA JOLI',49,'D',null,null,null),
                         (21900265,'AUVRAY','ALEXANDRE','M','S','LYCEE GEN.ET TECHNOL.PRIVE INSTITUT SAIN',50,'A','DA','FI','IFSI Normandie'),
                         (21901052,'BEAUCLAIR','ADRIEN','M','STMG','LYC POLYVAL PRIVE des METIERS JEAN-BAPTI',35,'A','IA','FI','ESNA'),
                         (21906543,'BENABBOU','ANAS','M',null,null,null,'D',null,null,null),
                         (21902500,'BERNIER','ALLAN','M','STI2D','LYCEE GENERAL ET TECHNOLOGIQUE JOLIOT-CU',35,'C','DA','FI','EPITECH Rennes'),
                         (21900646,'BIERI','KERYANN','M','S','LPO LYCEE DES METIERS COLBERT',56,'B',null,null,null),
                         (21903032,'BLIVET','LAURELINE','F','S','LYCEE GENERAL ET TECHNOLOGIQUE EMILE ZOL',35,'A','IA','FI','Licence Pro Nantes'),
                         (21901464,'BOIVENT','PIERRE','M','S','LPO PRIVE DES METIERS INSTITUTION ST MAL',35,'A','IA','FI','ENIBrest'),
                         (21900169,'BONNET','BENJAMIN','M','S','LYCEE GENERAL GALILEE',44,'B','DA','FI','Licence Histoire Nantes'),
                         (21900298,'BOUTINAUD','ALEXANDRE','M','STI2D','LYCEE GENERAL ET TECHNOLOGIQUE BEAUMONT',35,'B',null,null,null),
                         (21900347,'BRAUD','ANTOINE','M','S','LY ST JOSEPH VANNES',56,'B','DA','FI','ESAIP'),
                         (21905341,'BRAULT','MAXIME','M','S','LYCEE EMILE ZOLA RENNES',35,'C',null,null,null),
                         (21901463,'BREIT HOARAU','EMELINE','F','S','LYC POLYVAL PRIVE DES METIERS LA MENNAIS',35,'A',null,null,null),
                         (21901620,'BRUN','DONOVAN','M','STI2D','LYCEE GENERAL ET TECHNOLOGIQUE JOLIOT-CU',35,'B','IA','FI','IMT'),
                         (21900755,'BUAN','KILIAN','M','S','LYCEE GENERAL ET TECHNOLOGIQUE LESAGE',56,'B','IA','FI','Licence info Vannes'),
                         (21901179,'BUCHE','SYLVAIN','M','S','LYCEE GENERAL ET TECHNOLOGIQUE JOLIOT-CU',35,'C','DA','FI','Licence info Vannes'),
                         (21902463,'CALVEZ','LOUIS','M','S','LYCEE GEN TECHNO LE LIKES',29,'B','IA','FI','BUT Génie Biologique'),
                         (21901650,'CARN','YOHAN','M','S','LYCEE GENERAL DE LHARTELOIRE',29,'D','IA','App',null),
                         (21900282,'CASTELLA','MATEO','M','S','LY ST JOSEPH VANNES',56,'D','IA','App','ESIEA Laval'),
                         (21900839,'CHASTANIER','TANGUY','M','S','LYCEE GEN ET TECHNOL PRIVE ST PAUL',56,'C','DA','FI',null),
                         (21903410,'CHIFFOT','CALVIN','M','S','LYCEE GENERAL PRIVE LA PERVERIE SACRE CO',44,'D','DA','FI',null),
                         (21900496,'CHOLLET','QUENTIN','M','S','LYCEE GENERAL ET TECHNOLOGIQUE CITE TECH',86,'C','IA','FI','ENSI Caen'),
                         (21900427,'CHRISTOPH','NIELS','M','STI2D','LYCEE POLYVALENT VAUBAN',29,'D',null,null,null),
                         (21901954,'CLOAREC','THOMAS','M','S','LYCEE GEN TECH PRIVE NOTRE DAME DU VOEU',56,'A','IA','App','CentraleSupelec'),
                         (21901457,'COBAT','GUILLAUME','M','S','LPO PRIVE DES METIERS INSTITUTION ST MAL',35,'C','DA','FI','Licence info Vannes'),
                         (21900537,'COMBRISSON','EWEN','M','S','LYCEE GENERAL ET TECHNOLOGIQUE JEAN BRIT',35,'C','IA','FI','ESIEA Laval'),
                         (21900563,'CORBEAU','REMI','M','S','LYCEE BENJAMIN FRANKLIN (AURAY)',56,'D',null,null,null),
                         (21900448,'COSNIER','QUENTIN','M','S','LYCEE GENERAL ET TECHNOLOGIQUE COLBERT D',72,'D','IA','FI','Licence info Vannes'),
                         (21902355,'DE LA TULLAYE','ADRIEN','M','S','LYCEE GEN ET TECHNOL PRIVE ST LOUIS LORI',29,'B',null,null,null),
                         (21900262,'DELAUNAY','GURWAN','M','S','LPO LYCEE DES METIERS BROCELIANDE',56,'C','IA','FI','ENSSAT Lannion'),
                         (21901481,'DESMONTS','LEO','M','S','LYCEE POLYVALENT JEAN PERRIN',95,'B','IA','App','ENSIBS cyberdéfense'),
                         (21900272,'DESORMEAUX-DELAUNAY','TOM','M','STI2D','LYCEE GENERAL ET TECHNOLOGIQUE BEAUMONT',35,'D','DA','FI','Travail'),
                         (21900976,'DEWILDE','YOANN','M','S','LYCEE GEN TECHNO LE LIKES',29,'D','DA','App','Licence info Vannes'),
                         (21900698,'DIBERDER','EVAN','M','S','LYCEE GENERAL ET TECHNOLOGIQUE LESAGE',56,'A','IA','FI','Licence info Vannes'),
                         (21902446,'DINEL','ROMAIN','M','S','LYCEE F.R de Chateaubriand COMBOURG - CO',35,'D','IA','FI','EPITECH Rennes'),
                         (21900965,'DUFILS','ROMAIN','M','S','LYCEE GENERAL ET TECHNOLOGIQUE PIERRE ME',85,'D','IA','App','EPSI Nantes'),
                         (21901046,'ERMINE','LOUIS','M','S','LYCEE GENERAL FRANCOIS RENE DE CHATEAUBR',35,'C','IA','FI','Travail'),
                         (21901680,'FAUGERON','LUCAS','M','S','LYCEE POLYVALENT JEAN MACE',56,'A','DA','App','Licence Pro Vannes Delice'),
                         (21902089,'FLOHIC','JORIS','M','S','LYCEE GENERAL GALILEE',44,'D','IA','App','EPSI Nantes'),
                         (21900815,'FRANCIS','TEIVA','M','S','LYCEE BENJAMIN FRANKLIN (AURAY)',56,'D','DA','App',null),
                         (21901869,'GARAUD','ORIANNE','F','S','LYCEE POLYVALENT PRIVE STE ANNE-ST LOUIS',56,'A','IA','FI',null),
                         (21901634,'GARCIA','CHRISTOPHE','M','S','LPO LYCEE DES METIERS YVES THEPOT',29,'A','DA','FI','Licence Info Brest'),
                         (21903624,'GARIN-HAMELINE','GILDAS','M','S','LYCEE GEN.ET TECHNOL.PRIVE ASSOMPTION BE',69,'D','IA','App','ENSIBS cyberdéfense'),
                         (21902979,'GARREC','MEVEN','M','STI2D','LPO LYCEE DES METIERS YVES THEPOT',29,'A','DA','FI','Licence Pro Vannes Delice'),
                         (21900989,'GASTEBOIS','LUCY','F','ES','LYCEE GENERAL ET TECHNOLOGIQUE SEVIGNE',35,'B','DA','FI','ESNA'),
                         (21902450,'GLORENNEC','OSCAR','M','S','LYCEE GENERAL ET TECHNOLOGIQUE JOLIOT-CU',35,'A',null,null,null),
                         (21900316,'GODET','LOUIS-XAVIER','M','STI2D','LYCEE TECHNOLOGIQUE PRIVE LES RIMAINS',35,'A','IA','FI','Licence Info Poitiers'),
                         (21902833,'GONTARD','ALICE','F','S','LYCEE GENERAL ET TECHNO DE CORNOUAILLE',29,'B','IA','FI','ESNA'),
                         (21903180,'GOYER','ENZO','M','S','LYCEE GEN.ET TECHNOL.PRIVE DAVESNIERES',53,'C',null,null,null),
                         (21901478,'GREGOIRE','EWAN','M','S','LYCEE METIERS MARCELIN BERTHELOT (QUEST',56,'B','IA','App','Licence Pro Vannes Cyber'),
                         (21900144,'GUENNEC','PAUL','M','S','LYCEE GEN. TECHNO VICTOR HUGO (HENNEBONT',56,'D','IA','FI','ENSIBS cyberdéfense'),
                         (21903367,'GUENNOU','NICOLAS','M','STI2D','LYCEE GEN ET TECHNOL PRIVE ST SEBASTIEN',90,'D',null,null,null),
                         (21902502,'GUILLOU','DORYAN','M','S','LYCEE GENERAL AUGUSTE BRIZEUX',29,'B',null,null,null),
                         (21900788,'GUILLOUZO','BENJAMIN','M','S','LYCEE GENERAL PRIVE ND DE TOUTES AIDES',44,'B','IA','App','ENSIBS cyberdéfense'),
                         (21903081,'HAMON','CLEMENT','M','S','LYCEE GEN ET TECHNOL PRIVE ST MARTIN',35,'C','IA','FI','EPITECH Rennes'),
                         (21902069,'HERARD','THIBAULT','M','S','LYCEE GENERAL ET TECHNOLOGIQUE RENE DESC',35,'B','IA','App','ENSIBS cyberdéfense'),
                         (21802862,'JOSSE','ELOUAN','M','S','LPO LYCEE DES METIERS COLBERT',56,'D','DA','FI',null),
                         (21900318,'JOSSE','SAMUEL','M','S','LYCEE GENERAL ET TECHNOLOGIQUE MAUPERTUI',35,'C','DA','FI','Licence info Vannes'),
                         (21903258,'KERSULLEC','ANTOINE','M','S','LYCEE GEN ET TECHNO DE KERNEUZEC',29,'A','IA','FI','Licence 2 info Rennes'),
                         (21901901,'KOENIGS','THEO','M','S','LYCEE GENERAL ET TECHNOLOGIQUE JACQUES D',37,'A','IA','App','UTT'),
                         (21903040,'LAGUE','PIERRE','M','S','LYCEE GENERAL FRANCOIS RENE DE CHATEAUBR',35,'C','IA','FI','Licence info Vannes'),
                         (21906101,'LALIMAN','SIMON','M','S','LYCEE GENERAL ET TECHNOLOGIQUE MARCEL PA',null,'C',null,null,null),
                         (21900878,'LAMBERT','TANGUY','M','S','LYCEE GEN ET TECHNOL PRIVE ST PAUL',56,'C','IA','App','Licence info Rennes'),
                         (21903405,'LAROQUE','ARTHUR','M','S','LYCEE GEN. ET TECHNOL. PRIVE GERMAIN',50,'D','IA','FI','Licence info Nantes'),
                         (21903763,'LE BORGNE','ANTOINE','M','STI2D','LPO LYCEE DES METIERS COLBERT',56,'B','DA','FI','Licence Pro Vannes Delice'),
                         (21902012,'LE BOT','KILLIAN','M','STI2D','LY ST JOSEPH VANNES',56,'A',null,null,null),
                         (21900924,'LE BRETON','DAN','M','S','LYCEE GEN ET TECHNOL PRIVE ST PAUL',56,'B','DA','App',null),
                         (21901106,'LE CHENADEC','SARAH','F','S','LYCEE GEN. TECHNO VICTOR HUGO (HENNEBONT',56,'A','IA','FI','ENSIBS cyberdéfense'),
                         (21900900,'LE DOUSSAL','RIWAN','M','S','LYCEE GEN. TECHNO VICTOR HUGO (HENNEBONT',56,'C',null,null,null),
                         (21900858,'LE GARREC','VINCENT','M','S','LYCEE GEN. TECHNO VICTOR HUGO (HENNEBONT',56,'A','IA','FI','ENSIBS cyberdéfense'),
                         (21900875,'LE GOFF','BENJAMIN','M','S','LYCEE GEN ET TECHNO DE KERNEUZEC',29,'A','DA','FI','Travail'),
                         (21900911,'LE LAN','QUENTIN','M','S','LYCEE POLYVALENT PRIVE STE ANNE-ST LOUIS',56,'B','IA','FI','ESIR'),
                         (21900219,'LE PORS','YANIS','M','S','LYCEE POLYVALENT PAUL SERUSIER',29,'A','IA','App','Licence info Brest'),
                         (21903169,'LEBOEUF','SULLLIVAN','M','STI2D','LYCEE JEANNE DARC ST IVY',56,'A','DA','FI','Licence Pro Vannes Delice'),
                         (21807519,'LEBORGNE','AYMERICK','M','S','LYCEE GENERAL ET TECHNOLOGIQUE JOLIOT-CU',56,'A','IA','App','Licence info Rennes'),
                         (21901089,'LEDOUX','MATTEO','M','S','LGT LYCEE DES METIERS MARIE CURIE',60,'A','IA','FI','ESNA'),
                         (21908182,'LEDREAU','ERIN','M',null,null,null,'B',null,null,null),
                         (21900432,'LELEUX','KIERAN','M','S','LYCEE POLYVALENT JEAN MACE',56,'B',null,null,null),
                         (21900834,'LENOBLE','ALEXANDRE','M','S','LYCEE GEN ET TECHNOL PRIVE ST PAUL',56,'A','IA','FI','Licence info Vannes'),
                         (21902830,'LEVEL','VALENTIN','M','STI2D','LYCEE GEN ET TECHNOL PRIVE ST SEBASTIEN',29,'D',null,null,null),
                         (21901136,'LICKINDORF','BORIS','M','S','LYCEE GENERAL ET TECHNOLOGIQUE JOLIOT-CU',35,'C','IA','App','ENSIBS cyberdéfense'),
                         (21902778,'LIGER','VICTOR','M','STI2D','LYCEE GEN TECHNO LE LIKES',29,'B',null,null,null),
                         (21900162,'MADELAINE','DYLAN','M','S','LYCEE GEN ET TECHNOL PRIVE ST SAUVEUR',35,'C','DA','App','Licence info Vannes'),
                         (21900748,'MAHEO','CORENTIN','M','S','LYCEE GENERAL ET TECHNOLOGIQUE JOSEPH LO',56,'D','IA','FI','Travail'),
                         (21901709,'MAINDRON','ELOUAN','M','STI2D','LYCEE POLYVALENT LEONARD DE VINCI',85,'C','DA','FI','Bachelor GL  CESI Nantes'),
                         (21901009,'MEAUZE','BAPTISTE','M','S','LYCEE GENERAL ET TECHNOLOGIQUE RENE DESC',35,'C','IA','FI','Licence info Rennes'),
                         (21900422,'MERIC-PONS','MATHIS','M','S','LPO LYCEE DES METIERS COLBERT',72,'C','IA','FI','Licence info Brest'),
                         (21902602,'MESNAGE','MARIUS','M','STI2D','LYCEE TECHNOLOGIQUE PRIVE LES RIMAINS',35,'C',null,null,null),
                         (21900482,'MICHENEAU','TIMOTHE','M','S','LYCEE GENERAL GALILEE',44,'A','DA','FI','Licence Pro Vannes Delice'),
                         (21901766,'MIONET','PIERRE','M','STI2D','LYCEE GENERAL ET TECHNOLOGIQUE FELIX LE',22,'D','IA','FI','ENSIBS cyberdéfense'),
                         (21901272,'MULTAN','GABRIELLE','F','S','LYCEE GEN ET TECHNOL PRIVE ST PAUL',56,'B','IA','FI','ESIEA Laval'),
                         (21901069,'PEDRON','MATISSE','M','S','LYCEE GEN ET TECHNOL PRIVE ST LOUIS LORI',56,'D','IA','FI','ENSIBS cyberlogiciel'),
                         (21900234,'PLOQUIN','NATHAN','M','S','LY ST JOSEPH VANNES',56,'C','IA','App','ENSIBS cyberdéfense'),
                         (21902387,'PLOUZENNEC','MORGAN','M','STI2D','LYCEE GEN TECHNO LE LIKES',29,'C',null,null,null),
                         (21900466,'QUACH','VALENTIN','M','STI2D','LYCEE POLYVALENT DE LA FONTAINE DES EAUX',22,'C','DA','FI','Travail'),
                         (21900244,'QUINIOU','CHRISTOPHE','M','STI2D','LPO LYCEE DES METIERS YVES THEPOT',29,'C','DA','FI','Licence MIAGE Rennes'),
                         (21900078,'RECOLIN','ANGELE','F','S','LYCEE POLYVALENT LES BOURDONNIERES',44,'B','DA','FI','Licence Pro Nantes'),
                         (21901881,'RIAT','PAUL','M','STI2D','LYCEE GEN TECHNO LE LIKES',29,'B',null,null,null),
                         (21902206,'ROUILLIER','JULIEN','M','S','LYCEE GENERAL ET TECHNOLOGIQUE MIREILLE ',60,'B','IA','App','ENSIBS cyberdéfense'),
                         (21900626,'SAMSON','BENOIT','M','STI2D','LYCEE JEANNE DARC ST IVY',56,'A',null,null,null),
                         (21900343,'SIMAR','CEDRIC','M','S','LYCEE GENERAL PRIVE ST FRANCOIS-XAVIER',56,'D','IA','FI','Bachelor Info De vinci'),
                         (21900864,'SUARD','MAEL','M','S','LYCEE GEN TECHNO LE LIKES',29,'D','IA','App','IMT'),
                         (21900238,'TIRLEMONT','KIERIAN','M','S','LYCEE GENERAL ET TECHNOLOGIQUE JULLIOT D',50,'D','IA','App','ESIEA Laval'),
                         (21901836,'TRETON','PIERRE','M','S','LY.GEN CHARLES PEG GORGES',44,'A','DA','FI','Licence 2 Info Rennes'),
                         (21702527,'VIAUD','BENJAMIN','M','S','LYCEE GEN TECH PRIVE NOTRE DAME DU VOEU',29,'C','IA','FI','Licence Info Rennes');

--  Entreprise

INSERT INTO Entreprise VALUES
                           (1,'ACCENTURE',75),
                           (2,'ADAPEI56',56),
                           (3,'ADM',56),
                           (4,'ALADOM',35),
                           (5,'ANVERGUR',56),
                           (6,'APRAS',35),
                           (7,'AWAHOTO',35),
                           (8,'BIOTHOT',56),
                           (9,'BYSTAMP',56),
                           (10,'CADIOU INDUSTRIE',29),
                           (11,'CAISSE DEPARGNE LOIRE DROME ARDECHE',42),
                           (12,'CGI',56),
                           (13,'CGI',35),
                           (14,'CMB',29),
                           (15,'CNRS',35),
                           (16,'COLLEGE SACRE COEUR',56),
                           (17,'CONSEIL DEPARTEMENTAL DU MORBIHAN',56),
                           (18,'CREDIT AGRICOLE',56),
                           (19,'DAVID SYSTEMS GMBH',null),
                           (20,'DAWIZZ',56),
                           (21,'DCODE-IT',27),
                           (22,'DEPARTEMENT DE LA VENDEE',85),
                           (23,'DEPARTEMENT DILLE-ET-VILAINE',35),
                           (24,'DIOTAL SAS',56),
                           (25,'DGFIP',35),
                           (26,'DIRISI',29),
                           (27,'ÉCOLES DE SAINT-CYR COËTQUIDAN',56),
                           (28,'ENSIBS',56),
                           (29,'ERCII',56),
                           (30,'EXOTIC ANIMALS',56),
                           (31,'GROUPE ROCHER',35),
                           (32,'HIPPOCAD',77),
                           (33,'HORIZON SYSTEMES DINFORMATION',60),
                           (34,'IDEMIA',95),
                           (35,'IFREMER',29),
                           (36,'INPIXAL',35),
                           (37,'INRAE ET FN3PT',75),
                           (38,'IOLE SOLUTIONS',56),
                           (39,'IRISA, EQUIPE OBELIX',56),
                           (40,'JEXLPROD',56),
                           (41,'JULIANA MULTIMEDIA',56),
                           (42,'KARROAD',65),
                           (43,'LA BIDOUILLERIE',35),
                           (44,'LACTALIS',53),
                           (45,'LEAD OFF',56),
                           (46,'LETSEAT',87),
                           (47,'LUNION DES FORGERONS',91),
                           (48,'MAIRIE DE SÉNÉ',56),
                           (49,'MENBAT',56),
                           (50,'MONSTOCK',51),
                           (51,'NAVAL GROUP',83),
                           (52,'NIJI',44),
                           (53,'NIRYO',59),
                           (54,'NOVOSYS INGENIERIE',88),
                           (55,'OPTIC PERFORMANCE',56),
                           (56,'ORANGE CYBERDÉFENSE',92),
                           (57,'OUEST BOISSON',56),
                           (58,'PLASTEOL',56),
                           (59,'PORT DE PÊCHE KEROMAN',56),
                           (60,'SCM VIAUD-FORMAGNE',56),
                           (61,'SEM LORIENT KEROMAN',56),
                           (62,'SIB',35),
                           (63,'SITIA',44),
                           (64,'SMARTMOOV',35),
                           (65,'SMURFIT KAPPA FRANCE',56),
                           (66,'SOLIDR',56),
                           (67,'UBS',56),
                           (68,'VIDEOR INFORMATIQUE',56),
                           (69,'WINNOVE MEDICAL',35),
                           (70,'WISEBAND',85),
                           (71,'YOGOKO',35);


--  Table Stagiaire

INSERT INTO Stagiaire  VALUES
                           (21900265,37),
                           (21901052,53),
                           (21902500,2),
                           (21903032,15),
                           (21901464,23),
                           (21900169,30),
                           (21900347,47),
                           (21901620,15),
                           (21900755,18),
                           (21901179,66),
                           (21902463,18),
                           (21900839,28),
                           (21903410,14),
                           (21900496,36),
                           (21901457,42),
                           (21900537,31),
                           (21900448,29),
                           (21900262,46),
                           (21900834,3),
                           (21900272,66),
                           (21900698,17),
                           (21902446,6),
                           (21901046,32),
                           (21901869,28),
                           (21901634,50),
                           (21902979,19),
                           (21900989,34),
                           (21900316,10),
                           (21902833,11),
                           (21900144,39),
                           (21903081,24),
                           (21802862,12),
                           (21900318,38),
                           (21903258,15),
                           (21903040,1),
                           (21903405,21),
                           (21903763,61),
                           (21901106,38),
                           (21908182,55),
                           (21900858,9),
                           (21900875,19),
                           (21900911,41),
                           (21903169,65),
                           (21901089,33),
                           (21900748,16),
                           (21901709,22),
                           (21901009,44),
                           (21900422,12),
                           (21900482,29),
                           (21901766,51),
                           (21901272,20),
                           (21901069,12),
                           (21900466,58),
                           (21900244,30),
                           (21900078,1),
                           (21900343,12),
                           (21901836,63),
                           (21702527,60);

--  Table Apprenti

INSERT INTO Apprenti VALUES
                         (21807519,5,'RF'),
                         (21901901,7,'MM'),
                         (21901680,12,'PT'),
                         (21901136,25,'PB'),
                         (21900282,26,'SL'),
                         (21901463,27,'PB'),
                         (21901650,35,'SL'),
                         (21900878,38,'JFK'),
                         (21901954,40,'PB'),
                         (21903624,40,'PB'),
                         (21900924,48,'MM'),
                         (21900219,49,'MM'),
                         (21900162,49,'MM'),
                         (21902206,56,'MM'),
                         (21901478,57,'JFK'),
                         (21900754,59,'HT'),
                         (21902069,62,'PT'),
                         (21900238,64,'MM'),
                         (21902089,67,'RF'),
                         (21900864,68,'PB'),
                         (21901481,69,'HT'),
                         (21900788,69,'HT'),
                         (21900965,70,'PB'),
                         (21900234,71,'MM');

-- Question 3 :

CREATE TABLE Responsabilite (
                                intituleResp VARCHAR(20),
                                leResp VARCHAR(5),
                                CONSTRAINT pk_intituleResp PRIMARY KEY (intituleResp)
);

INSERT INTO Responsabilite VALUES
                               ('admin', 'LN'),
                               ('stages', 'JFL'),
                               ('apprentis', 'PB)'),
                               ('poursuite', 'RF'),
                               ('chef_departement', 'JFK'),
                               ('direction_etudes', 'AR');

-- Question 4 :

SELECT * FROM Responsabilite ; -- 6
SELECT * FROM Enseignant ; -- 21
SELECT * FROM GroupeInfo1 ; -- 4
SELECT * FROM Etudiant ; -- 107
SELECT * FROM Entreprise ; -- 71
SELECT * FROM Stagiaire ; -- 58
SELECT * FROM Apprenti ; -- 24

-- Question 5 :

/* Fonctionnel */
SELECT DISTINCT UPPER(nomEntreprise)
FROM Entreprise
WHERE depEntreprise IN (22, 29, 35, 56)
ORDER BY UPPER(nomEntreprise);

/* Non fonctionnel : correction */
SELECT DISTINCT UPPER(idEns)
FROM Enseignant
EXCEPT
SELECT DISTINCT UPPER(tuteurApp)
FROM Apprenti;

/* Fonctionnel */
SELECT DISTINCT UPPER(nomEntreprise)
FROM Entreprise, Stagiaire
WHERE entrepriseStage=idEntreprise
  AND depEntreprise = 56;

-- Question 6 :
/* Afficher les noms et prénoms des enseignants qui sont tuteur de groupe*/
SELECT DISTINCT UPPER(nomEns), UPPER(prenomEns)
FROM Enseignant, GroupeInfo1
WHERE idEns = tuteurGroupe ;
/* 4 tuples
UPPER(nomEns), UPPER(prenomEns)
'TUFFIGO', 'HELENE'
'NAERT', 'LUCIE'
'TONIN', 'PHILIPPE'
'GODIN', 'THIBAULT'
*/

-- Question 7 :
/* Afficher les noms des enseignants `a la fois tuteur de groupe en Info1 et tuteur d’apprenti */
SELECT DISTINCT UPPER(nomEns)
FROM Enseignant, GroupeInfo1, Apprenti
WHERE idEns = tuteurGroupe
AND idEns = tuteurApp ;
/* 2 tuples
# UPPER(nomEns)
'TUFFIGO'
'TONIN'
*/

-- Question 8 :
/* Afficher les noms des entreprises ayant des apprentis dont le tuteur est identifi´e par ‘MM’. */
SELECT DISTINCT UPPER(Entreprise.nomEntreprise)
FROM Entreprise, Apprenti
WHERE idEntreprise = Apprenti.entrepriseApp
 AND tuteurApp = 'MM' ;
/* 6 tuples
# UPPER(Entreprise.nomEntreprise)
'MENBAT'
'YOGOKO'
'SMARTMOOV'
'MAIRIE DE SÉNÉ'
'AWAHOTO'
'ORANGE CYBERDÉFENSE'
 */

-- Question 9 :
/* Afficher les noms et pr´enoms des apprentis suivis par Pascal BAUDONT */
SELECT DISTINCT UPPER(Etudiant.nomEtud), UPPER(Etudiant.prenomEtud)
FROM Etudiant, Apprenti, Enseignant
WHERE idEtud = Apprenti.etudApp
AND tuteurApp = Enseignant.idEns
    AND prenomEns = 'Pascal' AND nomEns = 'BAUDONT' ;
/* 6 tuples
# UPPER(Etudiant.nomEtud), UPPER(Etudiant.prenomEtud)
'SUARD', 'MAEL'
'DUFILS', 'ROMAIN'
'LICKINDORF', 'BORIS'
'BREIT HOARAU', 'EMELINE'
'CLOAREC', 'THOMAS'
'GARIN-HAMELINE', 'GILDAS'
*/

-- Question 10 :
/* Afficher les noms des tuteurs ayant suivi un apprenti en dehors de la Bretagne */
SELECT DISTINCT UPPER(Enseignant.nomEns)
FROM Enseignant, Apprenti, Entreprise
WHERE idEns = Apprenti.tuteurApp
AND entrepriseApp = Entreprise.idEntreprise
    AND depEntreprise NOT IN (35, 29, 56, 22) ;
/* 2 tuples
# UPPER(Enseignant.nomEns)
'BAUDONT'
'MANNEVY'
 */