-- SQL TP5 Division
-- Prenom : Nolann
-- Nom : LESCOP
-- Groupe : 1D1

-- USE bd_r206 ;

DROP TABLE IF EXISTS ATravaillePour;
DROP TABLE IF EXISTS Avion;
DROP TABLE IF EXISTS Qualification;
DROP TABLE IF EXISTS TypeAvion;
DROP TABLE IF EXISTS Pilote;
DROP TABLE IF EXISTS Compagnie;

CREATE TABLE Compagnie
(
    idComp INTEGER,
    nomComp VARCHAR(30),
    pays VARCHAR(20),
    estLowCost INTEGER,

    CONSTRAINT pk_Compagnie PRIMARY KEY (idComp)
)
;

CREATE TABLE Pilote
(
    idPilote INTEGER,
    nomPilote VARCHAR(20),
    nbHVol INTEGER,
    compPil INTEGER,

    CONSTRAINT pk_Pilote PRIMARY KEY (idPilote),
    CONSTRAINT fk_Pilote_Compagnie FOREIGN KEY (compPil) REFERENCES Compagnie (idComp)
)
;

CREATE TABLE TypeAvion
(
    idTypeAvion VARCHAR(20),
    nbPassagers INTEGER,

    CONSTRAINT pk_TypeAvion PRIMARY KEY (idTypeAvion)
)
;

CREATE TABLE Qualification
(
    unPilote INTEGER,
    unTypeAvion VARCHAR(20),

    CONSTRAINT pk_Qualification	PRIMARY KEY (unPilote, unTypeAvion),
    CONSTRAINT fk_Qualification_Pilote FOREIGN KEY (unPilote) REFERENCES Pilote(idPilote),
    CONSTRAINT fk_Qualification_TypeAvion FOREIGN KEY (unTypeAvion) REFERENCES TypeAvion(idTypeAvion)
)
;

CREATE TABLE Avion
(
    idAvion INTEGER,
    leTypeAvion VARCHAR(20),
    compAv INTEGER,

    CONSTRAINT pk_Avion	PRIMARY KEY (idAvion),
    CONSTRAINT fk_Avion_TypeAvion FOREIGN KEY (leTypeAvion) REFERENCES TypeAvion(idTypeAvion),
    CONSTRAINT fk_Avion_Compagnie FOREIGN KEY (compAv) REFERENCES Compagnie(idComp)
)
;

CREATE TABLE ATravaillePour
(
    lePilote INTEGER,
    laComp INTEGER,

    CONSTRAINT pk_ATravaillePour PRIMARY KEY (lePilote, laComp),
    CONSTRAINT fk_ATravaillePour_Pilote FOREIGN KEY (lePilote) REFERENCES Pilote(idPilote),
    CONSTRAINT fk_ATravaillePour_Compagnie FOREIGN KEY (laComp) REFERENCES Compagnie(idComp)
)
;

------------------------------ Partie 1 -------------------------------
-- Question 1
/* Afficher les noms des pilotes possédant une qualification pour tous les avions */
SELECT Pilote.nomPilote
FROM Pilote
WHERE NOT EXISTS(
    SELECT TypeAvion.idTypeAvion
    FROM TypeAvion
    EXCEPT
    SELECT Qualification.unTypeAvion
    FROM Qualification
    WHERE unPilote = Pilote.idPilote
    )
;
/* 1 tuple
 # nomPilote
'Fleurquin'
 */

/* Afficher les noms des pilotes possédant une qualification pour tous les avions de leur compagnie */
SELECT Pilote.nomPilote
FROM Pilote
WHERE NOT EXISTS (
    SELECT Avion.leTypeAvion
    FROM Avion
    WHERE compAv = compPil
    EXCEPT
    SELECT Qualification.unTypeAvion
    FROM Qualification
    WHERE unPilote = Pilote.idPilote
);
/*
 # nomPilote
'Naert'
'Godin'
'Fleurquin'
'Kerbellec'
'Kamp'
 */

/* Afficher les noms des pilotes possédant une qualification pour exactement tous les avions de leur compagnie */
SELECT Pilote.nomPilote
FROM Pilote
WHERE NOT EXISTS
    (
    SELECT Avion.leTypeAvion
    FROM Avion
    WHERE compAv = compPil
    EXCEPT
    SELECT Qualification.unTypeAvion
    FROM Qualification
    WHERE unPilote = Pilote.idPilote
    )
AND NOT EXISTS
    (
    SELECT Qualification.unTypeAvion
    FROM Qualification
    WHERE unPilote = Pilote.idPilote
    EXCEPT
    SELECT leTypeAvion
    FROM Avion
    WHERE compAv = compPil
    )
AND compPil IS NOT NULL
;
/*
 # nomPilote
'Fleurquin'
'Kamp'
'Godin'
 */

------------------------------ Partie 2 -------------------------------
-- Question 2 :
/* Q2 : les noms des pilotes ayant travaill´e pour toutes les compagnies. */
SELECT Pilote.nomPilote
FROM Pilote
WHERE NOT EXISTS(
    SELECT idComp
    FROM Compagnie
    EXCEPT
    SELECT laComp
    FROM ATravaillePour
    WHERE lePilote = Pilote.idPilote
);
/* 1 tuple
 # nomPilote
'Fleurquin'
*/

-- Question 3 :
/* les noms des pilotes ayant travaill´e pour toutes les compagnies low cost. */
SELECT Pilote.nomPilote
FROM Pilote
WHERE NOT EXISTS(
    SELECT Compagnie.idComp
    FROM Compagnie
    WHERE estLowCost = 1
    EXCEPT
    SELECT ATravaillePour.laComp
    FROM ATravaillePour
    WHERE lePilote = Pilote.idPilote
);
/**
# nomPilote
'Ridard'
'Naert'
'Fleurquin'
 */

-- Question 4 :
/* les noms des pilotes ayant travaill´e pour exactement toutes les compagnies low cost. */
SELECT Pilote.nomPilote
FROM Pilote
WHERE NOT EXISTS
    (
        SELECT Compagnie.idComp
        FROM Compagnie
        WHERE estLowCost = 1
        EXCEPT
        SELECT ATravaillePour.laComp
        FROM ATravaillePour
        WHERE lePilote = Pilote.idPilote
    )
AND NOT EXISTS
    (
        SELECT ATravaillePour.laComp
        FROM ATravaillePour
        WHERE lePilote = Pilote.idPilote
        EXCEPT
        SELECT Compagnie.idComp
        FROM Compagnie
        WHERE estLowCost = 1
    );
/* 1 tuple
# nomPilote
'Naert'
 */

-- Question 5 :
/* les noms des compagnies poss´edant tous les types d’Airbus. */
SELECT Compagnie.nomComp
FROM Compagnie
WHERE NOT EXISTS(
    SELECT TypeAvion.idTypeAvion
    FROM TypeAvion
    WHERE idTypeAvion LIKE '%A%'
    EXCEPT
    SELECT Avion.leTypeAvion
    FROM Avion
    WHERE compAv = Compagnie.idComp
);
/* 1 tuple
 # nomComp
'Air France'
 */

-- Question 6
/* les noms des compagnies poss´edant exactement tous les types d’Airbus. */
SELECT Compagnie.nomComp
FROM Compagnie
WHERE NOT EXISTS(
    SELECT TypeAvion.idTypeAvion
    FROM TypeAvion
    WHERE idTypeAvion LIKE '%A%'
    EXCEPT
    SELECT Avion.leTypeAvion
    FROM Avion
    WHERE compAv = Compagnie.idComp
    )
AND NOT EXISTS
    (
        SELECT Avion.leTypeAvion
        FROM Avion
        WHERE compAv = Compagnie.idComp
        EXCEPT
        SELECT TypeAvion.idTypeAvion
        FROM TypeAvion
        WHERE idTypeAvion LIKE '%A%'
    )
;
/*
 0 tuples
*/

-- Question 7 :
/* Afficher le nombre de compagnies low cost (de deux mani`eres diff´erentes). */
SELECT COUNT(DISTINCT estLowCost)
FROM Compagnie;
/*
 # COUNT(DISTINCT estLowCost)
'2'
 */

SELECT COUNT(*)
FROM Compagnie
WHERE estLowCost = 1;
/*
 # COUNT(*)
'2'
 */

-- Question 8 :
/* Afficher le nombre d’avions appartenant `a Air France. */
SELECT COUNT(*)
FROM Avion, Compagnie
WHERE Avion.compAv = idComp
    AND UPPER(nomComp) = 'AIR FRANCE';
/*
 # COUNT(*)
'3'
 */

-- Question 9 :
/* Afficher le nombre de type d’avions appartenant `a Ryanair. */
SELECT COUNT(DISTINCT idTypeAvion)
FROM TypeAvion, Avion, Compagnie
WHERE compAv = Compagnie.idComp
    AND leTypeAvion = TypeAvion.idTypeAvion
    AND UPPER(nomComp) = 'RYANAIR';
/*
 # COUNT(DISTINCT idTypeAvion)
'1'
 */

-- Question 10 :
/* Afficher le nombre total de passagers que peut transporter Air France. */
SELECT SUM(DISTINCT nbPassagers)
FROM TypeAvion, Avion, Compagnie
WHERE compAv = Compagnie.idComp
  AND leTypeAvion = TypeAvion.idTypeAvion
  AND UPPER(nomComp) = 'AIR FRANCE';
/*
 # SUM(DISTINCT nbPassagers)
'777'
 */

-- Question 11 :
/* Afficher le type d’avion ayant la capacit´e maximale. */
SELECT DISTINCT leTypeAvion
FROM Avion, TypeAvion
WHERE leTypeAvion = idTypeAvion
GROUP BY leTypeAvion
ORDER BY nbPassagers DESC
LIMIT 1;
/* 1 tuple
 # leTypeAvion
'A350'
 */

-- Question 12 :
/* Afficher les compagnies (nom) ayant le type d’avion de capacit´e maximale. */
SELECT DISTINCT nomComp
FROM Compagnie, Avion, TypeAvion
WHERE compAv = Compagnie.idComp
AND leTypeAvion = TypeAvion.idTypeAvion
AND leTypeAvion = (
    SELECT DISTINCT leTypeAvion
    FROM Avion, TypeAvion
    WHERE leTypeAvion = idTypeAvion
    GROUP BY leTypeAvion
    ORDER BY nbPassagers DESC
    LIMIT 1
);
/*
 # nomComp
'Air France'
'American Airlines'
 */

-- Question 13 :
/* Afficher le(s) pilote(s) ayant au moins deux qualifications. */
SELECT DISTINCT Pilote.nomPilote
FROM Pilote
WHERE idPilote IN (
    SELECT unPilote
    FROM Qualification
    GROUP BY unPilote
    HAVING COUNT(unTypeAvion) >= 2
);
/* 5 tupeles
 # nomPilote
'Ridard'
'Naert'
'Fleurquin'
'Pham'
'Kamp'
 */

-- Question 14 :
/* Afficher le(s) pilote(s) ayant le plus grand nombre de qualifications. */
SELECT DISTINCT Pilote.nomPilote
FROM Pilote
WHERE idPilote IN ( SELECT unPilote
                    FROM Qualification
                    GROUP BY unPilote
                    HAVING COUNT(unTypeAvion) = (SELECT MAX(nbQualif)
                                                 FROM (SELECT COUNT(DISTINCT unTypeAvion) AS nbQualif
                                                       FROM Qualification
                                                       GROUP BY unPilote
                                                       ) AS Subquery
                                                 )
);
/* 1 tuple
 # nomPilote
'Fleurquin'
 */

-- Question 15 :
/* Afficher le(s) pilote(s) ayant le plus petit nombre de qualifications, ´eventuellement 0. */
SELECT DISTINCT Pilote.nomPilote
FROM Pilote
WHERE idPilote IN ( SELECT unPilote
                    FROM Qualification
                    GROUP BY unPilote
                    HAVING COUNT(unTypeAvion) = (SELECT MIN(nbQualif)
                                                 FROM (SELECT COUNT(DISTINCT unTypeAvion) AS nbQualif
                                                       FROM Qualification
                                                       GROUP BY unPilote
                                                       ) AS Subquery
                                                 )
);
/* 1 tuple
 # nomPilote
'Godin'
 */

-- Question 16 :
/* Pour chaque compagnie d´esign´ee par son nom (tri´ee dans l’ordre alphab´etique), afficher le nombre d’heures de vol moyen des pilotes. */
SELECT nomComp, AVG(nbHVol)
FROM Compagnie
LEFT JOIN Pilote ON compPil = idComp
GROUP BY nomComp
ORDER BY nomComp;
/* 5 tuples
   # nomComp, AVG(nbHVol)
'Air France', '2250.0000'
'American Airlines', '1950.0000'
'Corsair International', NULL
'EasyJet', '450.0000'
'Ryanair', '450.0000'
 */

-- Question 17 :
/* Afficher la compagnie ayant le plus grand nombre de places. */
SELECT nomComp, MAX(TypeAvion.nbPassagers)
FROM Compagnie
LEFT JOIN Avion ON compAv = idComp
LEFT JOIN TypeAvion ON leTypeAvion = idTypeAvion
GROUP BY nomComp
ORDER BY MAX(TypeAvion.nbPassagers) DESC
LIMIT 1;
/* 1 tuple
# nomComp, MAX(TypeAvion.nbPassagers)
'Air France', '324'
 */

-- Question 18 :
/* (Bonus) Proposer d’autres requˆetes pour pratiquer le regroupement et la division. */
-- Afficher le nombre de pilotes par compagnie
SELECT nomComp, COUNT(idPilote)
FROM Compagnie
LEFT JOIN Pilote ON compPil = idComp
GROUP BY nomComp
ORDER BY nomComp;
/* 5 tuples
 # nomComp, COUNT(idPilote)
'Air France', '2'
'American Airlines', '2'
'Corsair International', '0'
'EasyJet', '1'
'Ryanair', '1'
 */