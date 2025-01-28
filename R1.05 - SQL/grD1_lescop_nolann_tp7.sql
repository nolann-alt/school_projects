/*
TP7 R1.05 Algèbre relationnelle et Requètes SQL
Nom : LESCOP
Prénom : Nolann
Groupe : 1D1
*/

/*
 Pour cet exercice, nous allons utiliser la base IUTens qui a ´et´e ´etudi´ee dans le TD-TP5. Ex´ecutez
d’abord le script baseIUTens.sql pour la cr´eation et le remplissage de tables. Rappelez vous du sch´ema
relationnel de la base :

EtudiantInfo(noEtu(1), nomEtu, prenom, groupe)
EnseignantInfo(noEns(1), nomEns, prenomEns)

Formulez en alg`ebre relationnel et en SQL les interrogations suivantes, et donnez les
r´eponses. Attention : S’il y a plus de 5 tuples, vous devez donner le nombre de tuples et copier les 5
premiers tuples avec les nom des colonnes.
 */

DROP TABLE EnseignantInfo;
DROP TABLE EtudiantInfo;

CREATE TABLE EnseignantInfo(
                               noEns NUMBER(4)
			CONSTRAINT pk_EnseignantInfo PRIMARY KEY,
                               nomEns VARCHAR2(20),
                               prenomEns VARCHAR2(20)
)
;

INSERT INTO EnseignantInfo VALUES(1,'KAmP','Jean Francois');
INSERT INTO EnseignantInfo VALUES(2,'BEAuDONT','Pascal');
INSERT INTO EnseignantInfo VALUES(3,'GODIN','Thibault');
INSERT INTO EnseignantInfo VALUES(4,'KhayaTa','Mohammed');
INSERT INTO EnseignantInfo VALUES(5,'TONIN','Philippe');
INSERT INTO EnseignantInfo VALUES(6,'ROIRAND','Xavier');
INSERT INTO EnseignantInfo VALUES(7,'LE SOmMER','Nicolas');
INSERT INTO EnseignantInfo VALUES(8,'MErCIOL','Francois');
INSERT INTO EnseignantInfo VALUES(9,'LE Lain','Matthieu');
INSERT INTO EnseignantInfo VALUES(10,'LEFEVRE','Sebastien');
INSERT INTO EnseignantInfo VALUES(11,'BORNE','Isabelle');
INSERT INTO EnseignantInfo VALUES(12,'PHAM','Minh Tan');
INSERT INTO EnseignantInfo VALUES(13,'FLEURQUIN','Regis');
INSERT INTO EnseignantInfo VALUES(14,'NAeRT','Lucie');
INSERT INTO EnseignantInfo VALUES(15,'Belmouhcine','Abdelbadie');
INSERT INTO EnseignantInfo VALUES(16,'LeMaitre','Elodie');
INSERT INTO EnseignantInfo VALUES(17,'TUFFIGOT','Helene');
INSERT INTO EnseignantInfo VALUES(18,'Joucla','Philippe');
INSERT INTO EnseignantInfo VALUES(19,'Kerbellec','Goulven');
INSERT INTO EnseignantInfo VALUES(20,'Raut','Sophie');


CREATE TABLE EtudiantInfo(
                             noEtu NUMBER(4)
			CONSTRAINT pk_EtudiantInfo PRIMARY KEY,
                             nomEtu VARCHAR2(40),
                             prenom VARCHAR2(30),
                             groupe VARCHAR2(5)
)
;

INSERT INTO EtudiantInfo VALUES(1,'ALEXANDRE','Nathan','B');
INSERT INTO EtudiantInfo VALUES(2,'ANNEIX','Amélie','B');
INSERT INTO EtudiantInfo VALUES(3,'ARANDEL','Cyprien','D');
INSERT INTO EtudiantInfo VALUES(4,'BARATHON','Polig','B');
INSERT INTO EtudiantInfo VALUES(5,'BARIOU','Melvyn','A');
INSERT INTO EtudiantInfo VALUES(6,'BELMOKHTAR','Hocin','B');
INSERT INTO EtudiantInfo VALUES(7,'BELOUAHRANI KEBIR HOCEINI','Ilias','D');
INSERT INTO EtudiantInfo VALUES(8,'BELTRAME','Maël','A');
INSERT INTO EtudiantInfo VALUES(9,'BERNARD-GRIFFITHS','Samuel','A');
INSERT INTO EtudiantInfo VALUES(10,'BILLARD','Louis','B');
INSERT INTO EtudiantInfo VALUES(11,'BURBAN','Léo','C');
INSERT INTO EtudiantInfo VALUES(12,'CABARET','Louann','D');
INSERT INTO EtudiantInfo VALUES(13,'CACQUEVEL','Robinson','C');
INSERT INTO EtudiantInfo VALUES(14,'CAMPION','Brayan','B');
INSERT INTO EtudiantInfo VALUES(15,'CAROMEL','Merlin','B');
INSERT INTO EtudiantInfo VALUES(16,'CARRÉ','Louan','B');
INSERT INTO EtudiantInfo VALUES(17,'CELINI','Alvin','D');
INSERT INTO EtudiantInfo VALUES(18,'CESMAT-BELLIARD','Alexis','B');
INSERT INTO EtudiantInfo VALUES(19,'CHAUVELIN','Thomas','A');
INSERT INTO EtudiantInfo VALUES(20,'CHAZEL','Matteo','A');
INSERT INTO EtudiantInfo VALUES(21,'COIGNARD','Maël','C');
INSERT INTO EtudiantInfo VALUES(22,'COUTANT','Jade','C');
INSERT INTO EtudiantInfo VALUES(23,'CRUNCHANT','Manon','D');
INSERT INTO EtudiantInfo VALUES(24,'DESBROUSSES','Victor','A');
INSERT INTO EtudiantInfo VALUES(25,'DIONNE','Clément','D');
INSERT INTO EtudiantInfo VALUES(26,'DITTBERNER','Emmeran','A');
INSERT INTO EtudiantInfo VALUES(27,'DJERBI','Ilies','A');
INSERT INTO EtudiantInfo VALUES(28,'DOLIVET','Milo','C');
INSERT INTO EtudiantInfo VALUES(29,'DUBOIS','Ryann','A');
INSERT INTO EtudiantInfo VALUES(30,'EL HOMADI--LEVEQUE','Ayette','C');
INSERT INTO EtudiantInfo VALUES(31,'EMERAUD','Jean-Louis','A');
INSERT INTO EtudiantInfo VALUES(32,'ESKHADJIEV','Abdul-Malik','D');
INSERT INTO EtudiantInfo VALUES(33,'FERRON','Sarah','A');
INSERT INTO EtudiantInfo VALUES(34,'FRANCERIES','Iban','D');
INSERT INTO EtudiantInfo VALUES(35,'GARCIA','Ellaïs','A');
INSERT INTO EtudiantInfo VALUES(36,'GAUFFENY','PAuL','A');
INSERT INTO EtudiantInfo VALUES(37,'GIRE','Aliaume','A');
INSERT INTO EtudiantInfo VALUES(38,'GODEFROY','Marius','D');
INSERT INTO EtudiantInfo VALUES(39,'GOMEZ--JEGO','Inaki','A');
INSERT INTO EtudiantInfo VALUES(40,'GUHENEUF-LE BREC','NaTHAN','A');
INSERT INTO EtudiantInfo VALUES(41,'GUILLEMAUD','Glenn','B');
INSERT INTO EtudiantInfo VALUES(42,'GUILLOUET','Ismaël','C');
INSERT INTO EtudiantInfo VALUES(43,'GUINOT','William','D');
INSERT INTO EtudiantInfo VALUES(44,'GÜNES','Omer','B');
INSERT INTO EtudiantInfo VALUES(45,'HAMON','Louis','C');
INSERT INTO EtudiantInfo VALUES(46,'HEULAN','Malki','C');
INSERT INTO EtudiantInfo VALUES(47,'HUET CHAPUIS','Martin','C');
INSERT INTO EtudiantInfo VALUES(48,'HUYNH-BA','Baptiste','C');
INSERT INTO EtudiantInfo VALUES(49,'ISMAIL OMAR','Tasnim','B');
INSERT INTO EtudiantInfo VALUES(50,'JAN','Océane','C');
INSERT INTO EtudiantInfo VALUES(51,'JULES--VACHET','Matthéo','A');
INSERT INTO EtudiantInfo VALUES(52,'KERVEILLANT','Elie','D');
INSERT INTO EtudiantInfo VALUES(53,'KOLB','Mattis','D');
INSERT INTO EtudiantInfo VALUES(54,'LABBÉ','Pierre-Louis','D');
INSERT INTO EtudiantInfo VALUES(55,'LABHINI','Lucas','C');
INSERT INTO EtudiantInfo VALUES(56,'LACOUR','Alexandre','C');
INSERT INTO EtudiantInfo VALUES(57,'LE BRECH','Camille','D');
INSERT INTO EtudiantInfo VALUES(58,'LE MAGUER','NATHAN','A');
INSERT INTO EtudiantInfo VALUES(59,'LE PROVOST','Louen','D');
INSERT INTO EtudiantInfo VALUES(60,'LEFÈVRE','Nathan','C');
INSERT INTO EtudiantInfo VALUES(61,'LEFRANC','Théau','B');
INSERT INTO EtudiantInfo VALUES(62,'LEGEAY','Quentin','B');
INSERT INTO EtudiantInfo VALUES(63,'LEGRAND','Gabin','B');
INSERT INTO EtudiantInfo VALUES(64,'LESAUVAGE','Léandre','B');
INSERT INTO EtudiantInfo VALUES(65,'LOISANCE--PINEL','Melen','D');
INSERT INTO EtudiantInfo VALUES(66,'LORCY','Ilan','C');
INSERT INTO EtudiantInfo VALUES(67,'MAREC','Amaury','B');
INSERT INTO EtudiantInfo VALUES(68,'MARIOT','Estéban','B');
INSERT INTO EtudiantInfo VALUES(69,'MARQUE','Dylan','B');
INSERT INTO EtudiantInfo VALUES(70,'MELLAH','Rayanne','C');
INSERT INTO EtudiantInfo VALUES(71,'MICHELET','Eliaz','D');
INSERT INTO EtudiantInfo VALUES(72,'MIGNIER--NHEAN','Aymeric','C');
INSERT INTO EtudiantInfo VALUES(73,'MORHAN','William','B');
INSERT INTO EtudiantInfo VALUES(74,'MORNET','Quentin','C');
INSERT INTO EtudiantInfo VALUES(75,'MOUELLO','Samuel','B');
INSERT INTO EtudiantInfo VALUES(76,'NACHIN','Alexia','D');
INSERT INTO EtudiantInfo VALUES(77,'NATIVELLE','Elliot','C');
INSERT INTO EtudiantInfo VALUES(78,'NDUNGINI','Jérémy-Yoan','B');
INSERT INTO EtudiantInfo VALUES(79,'NOUVION','Mateo','B');
INSERT INTO EtudiantInfo VALUES(80,'PARCOLLET','Noé','C');
INSERT INTO EtudiantInfo VALUES(81,'PATINEC','Francois','A');
INSERT INTO EtudiantInfo VALUES(82,'PÉRON','Romain','B');
INSERT INTO EtudiantInfo VALUES(83,'PICARD','Benjamin','A');
INSERT INTO EtudiantInfo VALUES(84,'PIVRON','Jonas','A');
INSERT INTO EtudiantInfo VALUES(85,'PONDAVEN','Thibault','D');
INSERT INTO EtudiantInfo VALUES(86,'REBOURS','Maxence','C');
INSERT INTO EtudiantInfo VALUES(87,'RIVALLAND','Kyllian','A');
INSERT INTO EtudiantInfo VALUES(88,'RODRIGUES','Mattéo','B');
INSERT INTO EtudiantInfo VALUES(89,'ROUSSEL','Paul','C');
INSERT INTO EtudiantInfo VALUES(90,'SAUNDERS','Benjamin','C');
INSERT INTO EtudiantInfo VALUES(91,'SCHELL','Yanis','A');
INSERT INTO EtudiantInfo VALUES(92,'SITKO','Galian','A');
INSERT INTO EtudiantInfo VALUES(93,'SZCZEPANSKI','Serge','D');
INSERT INTO EtudiantInfo VALUES(94,'THÉBAULT','Claire','A');
INSERT INTO EtudiantInfo VALUES(95,'TRÉVIAN','Benjamin','D');
INSERT INTO EtudiantInfo VALUES(96,'TROUSSELET','Kylian','A');
INSERT INTO EtudiantInfo VALUES(97,'TUCAT','Mathieu','A');
INSERT INTO EtudiantInfo VALUES(98,'VARRIER','Mathis','C');
INSERT INTO EtudiantInfo VALUES(99,'VIDAL','Titouan','D');
INSERT INTO EtudiantInfo VALUES(100,'VION','Iann','D');
INSERT INTO EtudiantInfo VALUES(101,'VRIGNAUD','pAul','B');
INSERT INTO EtudiantInfo VALUES(102,'ZENSEN--DA SILVA','Gabriel','D');
INSERT INTO EtudiantInfo VALUES(103,'ZIEGELMEYER','Eliot','D');

-- Q10 : Quels sont les noms des ´etudiants du groupe A qui ont le mˆeme pr´enom qu’un enseignant ?

-- Algèbre relationnel :
-- EtudiantInfo[[EtudiantInfo.prenom = EnseignantInfo.prenomEns]]EnseignantInfo {groupe = 'A'} [nomEtu]

-- En SQL :
SELECT DISTINCT UPPER(nomEtu)
FROM EtudiantInfo, EnseignantInfo
WHERE UPPER(prenom) = UPPER(prenomEns)
AND UPPER(groupe) = 'A';

--Resultat execution :
/*
 UPPER(NOMETU)
----------------------------------------
PATINEC
 */

--Q11 : Quels sont les noms et pr´enoms des ´etudiants qui ont le mˆeme pr´enom que l’enseignant identifi´e par 3 ou 4 ?

-- Algèbre relationnel
-- EtudiantInfo[[EtudiantInfo.prenom = EnseignantInfo.prenomEns]]EnseignantInfo {noEns = 3 OR noEns = 4 }[nomEtu, prenom]

-- En SQL :
SELECT DISTINCT UPPER(nomEtu), UPPER(prenom)
FROM EtudiantInfo, EnseignantInfo
WHERE UPPER(prenom) = UPPER(prenomEns)
  AND (noEns = 3 OR noEns = 4);

-- Resultat éxecution :
/*
 UPPER(NOMETU)                            UPPER(PRENOM)
---------------------------------------- ------------------------------
PONDAVEN                                 THIBAULT
 */

--Q12 : Quels sont les noms des enseignants qui ont le mˆeme pr´enom que l’enseignant identifi´e par 5 ?

-- En algèbre relationnel
-- EnseignantInfo E1[[E1.prenomEns = E2.prenomEns]]EnseignantInfo E2 {E1.noEns = 5 AND E2.noEns != 5} [E2.nomEns]

-- En SQL :
SELECT DISTINCT  UPPER(E2.nomEns)
FROM EnseignantInfo E1, EnseignantInfo E2
WHERE UPPER(E1.prenomEns) = UPPER(E2.prenomEns)
    AND E1.noEns = 5
    AND E2.noEns != 5;

-- Resultat éxecution :
/*
 UPPER(E2.NOMENS)
--------------------
JOUCLA
 */

--Q13 : Quels sont les noms et pr´enoms des ´etudiants dont le pr´enom est port´e par un autre ?

-- En algèbre relationnel
-- EtudiantInfo E1[[E1.prenom = E2.prenom]]EtudiantInfo E2 {E1.nomEtu != E2.nomEtu} [E2.nomEtu, E2.prenom]

-- En SQL :
SELECT DISTINCT UPPER(E2.nomEtu), UPPER(E2.prenom)
FROM EtudiantInfo E1, EtudiantInfo E2
WHERE UPPER(E1.prenom) = UPPER(E2.prenom)
AND UPPER(E1.nomEtu) != UPPER(E2.nomEtu);

-- Resultat execution :
/*

UPPER(E2.NOMETU)                         UPPER(E2.PRENOM)
---------------------------------------- ------------------------------
ROUSSEL                                  PAUL
COIGNARD                                 MAËL
PICARD                                   BENJAMIN
SAUNDERS                                 BENJAMIN
VRIGNAUD                                 PAUL
BERNARD-GRIFFITHS                        SAMUEL
LEFÈVRE                                  NATHAN
MORHAN                                   WILLIAM
MOUELLO                                  SAMUEL
ALEXANDRE                                NATHAN
GUHENEUF-LE BREC                         NATHAN

UPPER(E2.NOMETU)                         UPPER(E2.PRENOM)
---------------------------------------- ------------------------------
GUINOT                                   WILLIAM
MORNET                                   QUENTIN
GAUFFENY                                 PAUL
BELTRAME                                 MAËL
LEGEAY                                   QUENTIN
BILLARD                                  LOUIS
HAMON                                    LOUIS
LE MAGUER                                NATHAN
TRÉVIAN                                  BENJAMIN

20 lignes sélectionnées.
*/

-- Q14 : Quels sont les pr´enoms qui existent dans au moins 2 groupes ?
-- Alegèbre relationnel :
-- EtudiantInfo E1[[E1.prenom = E2.prenom]]EtudiantInfo E2 {E1.groupe != E2.groupe} [E2.prenom]

-- En SQL :
SELECT DISTINCT UPPER(E2.prenom)
FROM EtudiantInfo E1, EtudiantInfo E2
WHERE UPPER(E1.prenom) = UPPER(E2.prenom)
    AND UPPER(E1.groupe) != UPPER(E2.groupe);

-- Resultat execution :
/*

UPPER(E2.PRENOM)
------------------------------
WILLIAM
BENJAMIN
SAMUEL
LOUIS
PAUL
QUENTIN
NATHAN
MAËL

8 lignes sélectionnées.

*/

-- Q15 : Quels sont les cinq premiers pr´enoms par ordre alphab´etique port´es par les ´etudiants ?
SELECT *
FROM (SELECT DISTINCT UPPER (prenom)
    FROM EtudiantInfo
    ORDER BY UPPER(prenom)
    )
WHERE ROWNUM <= 5;

-- Resultat execution :
/*

UPPER(PRENOM)
------------------------------
ABDUL-MALIK
ALEXANDRE
ALEXIA
ALEXIS
ALIAUME
*/


-- Q16 : Quels sont les cinq derniers pr´enoms des ´etudiants ordonn´es par ordre alphab´etique des pr´enoms ?
SELECT *
FROM (SELECT DISTINCT UPPER (prenom)
    FROM EtudiantInfo
    ORDER BY UPPER(prenom) DESC)
WHERE ROWNUM <= 5;

-- Resultat execution :
/*

UPPER(PRENOM)
------------------------------
YANIS
WILLIAM
VICTOR
TITOUAN
THOMAS

 */

-- Q17 : Quels sont les cinq premiers pr´enoms commen¸cant par S et ordonn´es par ordre alphab´etique
-- port´es par les ´etudiants ou les enseignants ?
SELECT *
FROM (SELECT DISTINCT UPPER(prenom)
    FROM EtudiantInfo, EnseignantInfo
    WHERE UPPER(prenom) LIKE 'S%'
    ORDER BY UPPER(prenom))
WHERE ROWNUM <= 5;

-- Resultat execution :
/*

UPPER(PRENOM)
------------------------------
SAMUEL
SARAH
SERGE

 */



-- Q18 : Pour chaque enseignant identifi´e son num´ero, afficher les noms et pr´enoms des ´etudiants qui ont
-- le mˆeme pr´enom que lui.
SELECT noEns, UPPER(nomEtu), UPPER(prenom)
FROM EnseignantInfo, EtudiantInfo
WHERE UPPER (prenomEns) = UPPER(prenom);

-- Resultat execution :
/*

     NOENS UPPER(NOMETU)                            UPPER(PRENOM)
---------- ---------------------------------------- ------------------------------
         8 PATINEC                                  FRANCOIS
         3 PONDAVEN                                 THIBAULT

 */

-- Q19 : Pour chaque enseignant identifi´e son num´ero, afficher les noms et pr´enoms des ´etudiants qui ont
-- le mˆeme pr´enom que lui, s’il existe et rien sinon.

SELECT noEns, UPPER(nomEtu), UPPER(prenom)
FROM EnseignantInfo, EtudiantInfo
WHERE UPPER (prenomEns) = UPPER(prenom)
UNION
SELECT noEns, 'rien', 'rien'
FROM EnseignantInfo
WHERE noEns NOT IN (SELECT noEns
                    FROM EnseignantInfo, EtudiantInfo
                    WHERE UPPER (prenomEns) = UPPER(prenom));

-- Resultat execution :
/*

     NOENS UPPER(NOMETU)                            UPPER(PRENOM)
---------- ---------------------------------------- ------------------------------
         1 rien                                     rien
         2 rien                                     rien
         3 PONDAVEN                                 THIBAULT
         4 rien                                     rien
         5 rien                                     rien
         6 rien                                     rien
         7 rien                                     rien
         8 PATINEC                                  FRANCOIS
         9 rien                                     rien
        10 rien                                     rien
        11 rien                                     rien

     NOENS UPPER(NOMETU)                            UPPER(PRENOM)
---------- ---------------------------------------- ------------------------------
        12 rien                                     rien
        13 rien                                     rien
        14 rien                                     rien
        15 rien                                     rien
        16 rien                                     rien
        17 rien                                     rien
        18 rien                                     rien
        19 rien                                     rien
        20 rien                                     rien

20 lignes sélectionnées.

 */

-- Q20 : Proposez d’autres requˆetes de jointures et d’auto-jointures s’il vous reste le temps.

-- Requête de jointure
-- Pour chaque enseignant identifié par son numéro, afficher les noms et prénoms des étudiants qui ont le même prénom que lui.
SELECT noEns, UPPER(nomEtu), UPPER(prenom)
FROM EnseignantInfo, EtudiantInfo
WHERE UPPER(prenomEns) = UPPER(prenom)
ORDER BY noEns;