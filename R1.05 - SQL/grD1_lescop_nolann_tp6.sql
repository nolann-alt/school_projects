/*
TP5 R1.05 Algèbre relationnelle et Requètes SQL
Nom : LESCOP
Prénom : Nolann
Groupe : 1D1
*/

/*
 T´el´echargez le fichier baseCINEMA.sql sur Moodle qui contient les scripts pour la cr´eation la base de
donn´ees CINEMA dont le sch´ema relationnel :
Film (code(1),titre, leRealisateur = @Personne[idPersonne], anneeSortie, duree)
Personne(idPersonne(1), nom, prenom, pays, dateNaissance)
Acteur((unActeur = @Personne[idPersonne], unFilm = @Film[code])(1), cachet)
1
Exprimez les questions suivantes en utilisant les op´erateurs de l’alg`ebre relationnelle, puis traduisez en
SQL et donnez la r´eponse. (Attention : Si le nombre de tuples est sup´erieur `a 5, vous copiez et affichez
les 5 premiers tuples dans votre r´eponse. Si le nombre est inf´erieur ou ´egal `a 5, vous copiez et afficher
tous les tuples.)
 */

DROP TABLE Acteur;
DROP TABLE Film;
DROP TABLE Personne;

CREATE TABLE Personne(
                         idPersonne NUMBER(4)
		CONSTRAINT pk_Personne PRIMARY KEY,
                         nom VARCHAR2(20),
                         prenom VARCHAR2(20),
                         pays VARCHAR2(20),
                         dateNaissance DATE
);

INSERT INTO Personne VALUES(1,'Pagnol','Marcel','France',TO_DATE('28/02/1895','DD/MM/YYYY'));
INSERT INTO Personne VALUES(2,'KurosawA','Akira','Japon',TO_DATE('23/03/1910','DD/MM/YYYY'));
INSERT INTO Personne VALUES(3,'McQueen','Steve','USA',TO_DATE('24/03/1930','DD/MM/YYYY'));
INSERT INTO Personne VALUES(4,'L''Espagnol','Andre','France',null);
INSERT INTO Personne VALUES(5,'FERNANDEL','  ','France',null);
INSERT INTO Personne VALUES(6,'Howard','Trevor','USA',null);
INSERT INTO Personne VALUES(7,'RAIMU','  ','France',null);
INSERT INTO Personne VALUES(8,'Capriolo','Leonardo','Italia',null);
INSERT INTO Personne VALUES(9,'McGovern','Lawrence','USA',null);
INSERT INTO Personne VALUES(10,'Moreno','Guy','France',null);
INSERT INTO Personne VALUES(11,'Volkswagen','Karl','Deutschland',null);
INSERT INTO Personne VALUES(12,'Griffith','Trevor','GB',null);
INSERT INTO Personne VALUES(13,'Zanuck','Daryll','USA',null);
INSERT INTO Personne VALUES(14,'Cantona','Jean','France',null);
INSERT INTO Personne VALUES(15,'Neige','Blanche','Norway',null);
INSERT INTO Personne VALUES(16,'Tarkovsky','Alexandre','Russie',null);
INSERT INTO Personne VALUES(17,'Jugnot','G�rard','France',TO_DATE('12/06/1987','DD/MM/YYYY'));
INSERT INTO Personne VALUES(18,'Huston','John','USA',null);
INSERT INTO Personne VALUES(19,'Makoute','Tonton','Haiti',TO_DATE('30/11/2000','DD/MM/YYYY'));
INSERT INTO Personne VALUES(20,'Moreno','Felipo','Italia',null);
INSERT INTO Personne VALUES(21,'Blunt','Groom','Somalia',TO_DATE('13/02/1932','DD/MM/YYYY'));
INSERT INTO Personne VALUES(23,'Williams','Trevor','Eire',null);
INSERT INTO Personne VALUES(24,'Bardot','Brigitte','Espagne',TO_DATE('11/08/2018','DD/MM/YYYY'));
INSERT INTO Personne VALUES(26,'Gaffiot','Gilles','Maroc',TO_DATE('21/06/1938','DD/MM/YYYY'));
INSERT INTO Personne VALUES(29,'Marceau','Sophie','France',TO_DATE('22/03/2023','DD/MM/YYYY'));
INSERT INTO Personne VALUES(34,'LE VIGAN','Robert','France',TO_DATE('07/01/2000','DD/MM/YYYY'));
INSERT INTO Personne VALUES(50,'Luhrman','Baz','AUSTRALIA',TO_DATE('17/09/1962','DD/MM/YYYY'));
INSERT INTO Personne VALUES(53,'Mifune','Toshiro','Japon',TO_DATE('01/04/2020','DD/MM/YYYY'));
INSERT INTO Personne VALUES(54,'PASNE','Alfred','USA',TO_DATE('17/06/2029','DD/MM/YYYY'));
INSERT INTO Personne VALUES(55,'LeJEUNE','John','USA',TO_DATE('03/01/2010','DD/MM/YYYY'));
INSERT INTO Personne VALUES(56,'Cruise','Tom','USA',TO_DATE('03/07/1962','DD/MM/YYYY'));
INSERT INTO Personne VALUES(57,'Scott','Tony','USA',TO_DATE('21/06/1944','DD/MM/YYYY'));
INSERT INTO Personne VALUES(58,'Kosinski','Joseph','USA',TO_DATE('03/05/1974','DD/MM/YYYY'));
INSERT INTO Personne VALUES(59,'Redford','Robert','USA',TO_DATE('18/08/1936','DD/MM/YYYY'));
INSERT INTO Personne VALUES(60,'Allen','Woody','USA',TO_DATE('01/12/1935','DD/MM/YYYY'));
INSERT INTO Personne VALUES(61,'Cottilard','Marion','France',TO_DATE('30/09/1975','DD/MM/YYYY'));
INSERT INTO Personne VALUES(62,'Elmaleh','Gad','France',TO_DATE('19/04/1971','DD/MM/YYYY'));
INSERT INTO Personne VALUES(63,'Blanchett','Kate','Australie',TO_DATE('14/05/1969','DD/MM/YYYY'));
INSERT INTO Personne VALUES(64,'Cruz','Penelope','Espagne',TO_DATE('28/04/1974','DD/MM/YYYY'));
INSERT INTO Personne VALUES(65,'Besson','Luc','France',TO_DATE('18/03/1959','DD/MM/YYYY'));
INSERT INTO Personne VALUES(66,'Scott','Ridley','GB',TO_DATE('30/11/1937','DD/MM/YYYY'));
INSERT INTO Personne VALUES(67,'Johansson','Scarlett','USA',TO_DATE('22/11/1984','DD/MM/YYYY'));
INSERT INTO Personne VALUES(68,'FREEMAN','Morgan','USA',TO_DATE('01/06/1937','DD/MM/YYYY'));
INSERT INTO Personne VALUES(69,'TIPTON','Analeigh','USA',TO_DATE('09/11/1988','DD/MM/YYYY'));
/* les james bond : acteurs */
INSERT INTO Personne VALUES(70,'Connery','Sean','Ecosse',TO_DATE('25/08/1930','DD/MM/YYYY'));
INSERT INTO Personne VALUES(71,'Lazenby','George','Australie',TO_DATE('05/09/1939','DD/MM/YYYY'));
INSERT INTO Personne VALUES(72,'Moore','Roger','GB',TO_DATE('24/10/1927','DD/MM/YYYY'));
INSERT INTO Personne VALUES(73,'Dalton','Timothy','Pays de Galle',TO_DATE('21/03/1946','DD/MM/YYYY'));
INSERT INTO Personne VALUES(74,'Craig','Daniel','GB',TO_DATE('02/03/1968','DD/MM/YYYY'));
INSERT INTO Personne VALUES(75,'Brosnan','Pierse','Irlande',TO_DATE('09/11/1988','DD/MM/YYYY'));
/* les harry potter */
INSERT INTO Personne VALUES(76,'Columbus','Chris','usa',TO_DATE('10/09/1958','DD/MM/YYYY'));
INSERT INTO Personne VALUES(77,'Cuaron','Alphonso','Mexique',TO_DATE('28/11/1961','DD/MM/YYYY'));
INSERT INTO Personne VALUES(78,'Newell','Mike','GB',TO_DATE('28/03/1942','DD/MM/YYYY'));
INSERT INTO Personne VALUES(79,'Yates','David','GB',TO_DATE('30/11/1963','DD/MM/YYYY'));
INSERT INTO Personne VALUES(80,'Radcliffe','Daniel','GB',TO_DATE('23/07/1989','DD/MM/YYYY'));
INSERT INTO Personne VALUES(81,'Harris','Richard','Irlande',TO_DATE('01/10/1930','DD/MM/YYYY'));
INSERT INTO Personne VALUES(82,'Smith','Maggie','GB',TO_DATE('28/12/1934','DD/MM/YYYY'));
INSERT INTO Personne VALUES(83,'Watson','Emma','GB',TO_DATE('15/04/1990','DD/MM/YYYY'));
/* les hunger games */
INSERT INTO Personne VALUES(84,'Ross','Gary','USA',TO_DATE('03/11/1956','DD/MM/YYYY'));
INSERT INTO Personne VALUES(85,'Lawrence','Francis','Autriche',TO_DATE('26/03/1971','DD/MM/YYYY'));
INSERT INTO Personne VALUES(86,'Lawrence','Jennifer','USA',TO_DATE('15/08/1990','DD/MM/YYYY'));
INSERT INTO Personne VALUES(87,'Hutcherson','Joshua','USA',TO_DATE('12/10/1992','DD/MM/YYYY'));
INSERT INTO Personne VALUES(88,'Hemsworth','Liam','Australie',TO_DATE('13/01/1990','DD/MM/YYYY'));
/* les divergentes */
INSERT INTO Personne VALUES(89,'Burger','Neil','usa',Null);
INSERT INTO Personne VALUES(90,'Schwentke','Robert','Allemagne',null);
INSERT INTO Personne VALUES(91,'Woodley','Shailene','USA',TO_DATE('15/11/1991','DD/MM/YYYY'));
INSERT INTO Personne VALUES(92,'James','Theo','GB',TO_DATE('16/12/1984','DD/MM/YYYY'));
INSERT INTO Personne VALUES(93,'Winslet','Kate','GB',TO_DATE('15/10/1975','DD/MM/YYYY'));
/* les james bonds : r�alisateurs */
INSERT INTO Personne VALUES(94,'Young','Terence','GB',TO_DATE('20/06/1915','DD/MM/YYYY'));
INSERT INTO Personne VALUES(95,'Hamilton','Guy','GB',TO_DATE('16/09/1922','DD/MM/YYYY'));
INSERT INTO Personne VALUES(96,'Gilbert','Lewis','GB',TO_DATE('06/03/1920','DD/MM/YYYY'));
INSERT INTO Personne VALUES(97,'Hunt','Peter','GB',TO_DATE('11/03/1925','DD/MM/YYYY'));
INSERT INTO Personne VALUES(98,'Glen','John','GB',TO_DATE('15/05/1932','DD/MM/YYYY'));
INSERT INTO Personne VALUES(99,'Campbell','Martin','Nouvelle Zelande',TO_DATE('24/10/1943','DD/MM/YYYY'));
INSERT INTO Personne VALUES(100,'Spottiswoode','Roger','Canada',TO_DATE('05/01/1945','DD/MM/YYYY'));
INSERT INTO Personne VALUES(101,'Apted','Michael','GB',TO_DATE('10/02/1941','DD/MM/YYYY'));
INSERT INTO Personne VALUES(102,'Tamahori','Lee','Nouvelle Zelande',TO_DATE('17/06/1950','DD/MM/YYYY'));
INSERT INTO Personne VALUES(103,'Forster','Marc','Suisse',TO_DATE('30/11/1969','DD/MM/YYYY'));
INSERT INTO Personne VALUES(104,'Mendes','Sam','GB',TO_DATE('01/08/1965','DD/MM/YYYY'));
/* le monde de Narnia */
INSERT INTO Personne VALUES(105,'Adamson','Andrew','Nouvelle Zelande',TO_DATE('01/12/1966','DD/MM/YYYY'));
INSERT INTO Personne VALUES(106,'Moseley','William','GB',TO_DATE('29/04/1987','DD/MM/YYYY'));
INSERT INTO Personne VALUES(107,'Popplewell','Anna','GB',TO_DATE('16/12/1988','DD/MM/YYYY'));
INSERT INTO Personne VALUES(108,'Keynes','Skandar','GB',TO_DATE('05/09/1991','DD/MM/YYYY'));
INSERT INTO Personne VALUES(109,'Henley','Georgie','GB',TO_DATE('09/07/1995','DD/MM/YYYY'));
INSERT INTO Personne VALUES(110,'Swinton','Tilda','GB',TO_DATE('05/11/1960','DD/MM/YYYY'));
INSERT INTO Personne VALUES(111,'Barnes','Ben','GB',TO_DATE('20/08/1981','DD/MM/YYYY'));
/* chocolat */
INSERT INTO Personne VALUES(112,'Roschdy','Zem','France',TO_DATE('28/09/1965','DD/MM/YYYY'));
INSERT INTO Personne VALUES(113,'Thierree','James','Suisse',TO_DATE('02/05/1974','DD/MM/YYYY'));
INSERT INTO Personne VALUES(114,'Sy','Omar','France',TO_DATE('20/01/1978','DD/MM/YYYY'));
/* Dunkerque */
INSERT INTO Personne VALUES(115,'Nolan','Christopher','GB',TO_DATE('30/07/1970','DD/MM/YYYY'));
INSERT INTO Personne VALUES(116,'Glynn-Carney','Tom','GB',TO_DATE('07/02/1995','DD/MM/YYYY'));
INSERT INTO Personne VALUES(117,'Lowden','Jack','GB',TO_DATE('02/06/1990','DD/MM/YYYY'));
/* pirates des caraibes */
INSERT INTO Personne VALUES(118,'verbinsky','Gore','USA',TO_DATE('16/03/1964','DD/MM/YYYY'));
INSERT INTO Personne VALUES(119,'Marshall','Rob','USA',TO_DATE('17/10/1960','DD/MM/YYYY'));
INSERT INTO Personne VALUES(120,'Sandberg','Espen','norvege',TO_DATE('17/06/1971','DD/MM/YYYY'));
INSERT INTO Personne VALUES(121,'Deep','Johnny','USA',TO_DATE('09/06/1963','DD/MM/YYYY'));
INSERT INTO Personne VALUES(122,'Rush','Jeoffrey','australie',TO_DATE('06/07/1951','DD/MM/YYYY'));
INSERT INTO Personne VALUES(123,'Bloom','Orlando','GB',TO_DATE('13/01/1977','DD/MM/YYYY'));
INSERT INTO Personne VALUES(124,'Knightley','Keira','GB',TO_DATE('26/03/1985','DD/MM/YYYY'));
/* mission impossible */
INSERT INTO Personne VALUES(125,'DE PALMA','Brian','USA',TO_DATE('11/09/1940','DD/MM/YYYY'));
INSERT INTO Personne VALUES(126,'WOO','John','Chine',TO_DATE('01/05/1946','DD/MM/YYYY'));
INSERT INTO Personne VALUES(127,'ABRAMS','Jeffrey','USA',TO_DATE('27/06/1966','DD/MM/YYYY'));
INSERT INTO Personne VALUES(128,'BIRD','Brad','USA',TO_DATE('15/09/1957','DD/MM/YYYY'));
INSERT INTO Personne VALUES(129,'McQUARRIE','Christopher','USA',TO_DATE('12/06/1968','DD/MM/YYYY'));
INSERT INTO Personne VALUES(131,'PEGG','Simon','GB',TO_DATE('14/02/1970','DD/MM/YYYY'));
INSERT INTO Personne VALUES(132,'RHAMES','Ving','USA',TO_DATE('12/05/1959','DD/MM/YYYY'));
INSERT INTO Personne VALUES(133,'Mohnagan','Michelle','USA',TO_DATE('23/03/1976','DD/MM/YYYY'));
/* Alita : Battle Angel */
INSERT INTO Personne VALUES(140,'RODRIGUES','Robert','USA',TO_DATE('20/06/1968','DD/MM/YYYY'));
INSERT INTO Personne VALUES(141,'SALAZAR','Rosa','USA',TO_DATE('16/07/1985','DD/MM/YYYY'));
INSERT INTO Personne VALUES(142,'Waltz','Christoph','Autriche',TO_DATE('04/10/1956','DD/MM/YYYY'));
INSERT INTO Personne VALUES(143,'Connelly','Jennifer','USA',TO_DATE('12/12/1970','DD/MM/YYYY'));
/* Once Upon a time ... in Hollywood */
INSERT INTO Personne VALUES(150,'TARANTINO','Quentin','USA',TO_DATE('27/03/1963','DD/MM/YYYY'));
INSERT INTO Personne VALUES(151,'DI CAPRIO','Leonardo','USA',TO_DATE('11/11/1974','DD/MM/YYYY'));
INSERT INTO Personne VALUES(152,'PITT','Brad','USA',TO_DATE('18/12/1963','DD/MM/YYYY'));
INSERT INTO Personne VALUES(153,'ROBBIE','Margot','Australie',TO_DATE('02/07/1990','DD/MM/YYYY'));
/* AD ASTRA */
INSERT INTO Personne VALUES(160, 'GRAY','James', 'USA',TO_DATE('14/04/1969','DD/MM/YYYY'));
INSERT INTO Personne VALUES(161, 'LEE JONES','Tommy', 'USA',TO_DATE('15/09/1946','DD/MM/YYYY'));
INSERT INTO Personne VALUES(162, 'NEGGA','Ruth', 'Ethiopie',TO_DATE('07/01/1982','DD/MM/YYYY'));
INSERT INTO Personne VALUES(163, 'SUTHERLAND','Donald', 'Canada',TO_DATE('17/07/1935','DD/MM/YYYY'));
INSERT INTO Personne VALUES(164, 'TYLER','Liv', 'USA',TO_DATE('01/07/1967','DD/MM/YYYY'));


CREATE TABLE Film(
                     code NUMBER(4)
		CONSTRAINT pk_Film PRIMARY KEY,
                     titre VARCHAR2(80),
                     leRealisateur NUMBER(4)
		CONSTRAINT fk_Film REFERENCES Personne(idPersonne),
                     anneeSortie NUMBER(4),
                     duree NUMBER(4)
);

INSERT INTO Film VALUES(1,'Marius',1,1934,130);
INSERT INTO Film VALUES(2,'80 chasseurs',4,1974,140);
INSERT INTO Film VALUES(3,'Les sept mercenaires',23,1985,120);
INSERT INTO Film VALUES(4,'Les sept samourais',2,1945,110);
INSERT INTO Film VALUES(5,'La forteresse cachee',2,1989,132);
INSERT INTO Film VALUES(6,'Le transporteur',11,1960,105);
INSERT INTO Film VALUES(7,'Dust in the drones',23,1989,150);
INSERT INTO Film VALUES(8,'Le tracteur',11,1960,121);
INSERT INTO Film VALUES(9,'Les sept boules de cristal',4,1985,122);
INSERT INTO Film VALUES(10,'Les sept nains',15,2005,320);
INSERT INTO Film VALUES(11,'Behind the hell',23,1968,118);
INSERT INTO Film VALUES(12,'The maltese hawk',18,1941,97);
INSERT INTO Film VALUES(13,'Andrei Rublev',16,1971,106);
INSERT INTO Film VALUES(14,'La carapace du monstre',10,1961,145);
INSERT INTO Film VALUES(15,'Le myst�re du brancard creux',18,1931,57);
INSERT INTO Film VALUES(16,'Cesar',1,1935,130);
INSERT INTO Film VALUES(17,'Fanny',1,1936,130);
INSERT INTO Film VALUES(18,'Le moulin rouge',50,1973,150);
INSERT INTO Film VALUES(19,'La route de Maggersfontein',9,1973,156);
INSERT INTO Film VALUES(20,'La dent bleue',16,1957,130);
INSERT INTO Film VALUES(21,'This glen is mine',9,2007,144);
INSERT INTO Film VALUES(22,'Temp�te dans les bourdons',23,1992,150);
INSERT INTO Film VALUES(23,'Le vent soufflera deux fois',14,1973,134);
INSERT INTO Film VALUES(24,'Lads with a kilt',9,1991,128);
INSERT INTO Film VALUES(25,'LA DENT BLEUE',16,1957,130);
INSERT INTO Film VALUES(26,'Le moulin rouge',50,1994,150);
INSERT INTO Film VALUES(40,'Les Sept Samourais',2,1945,110);
INSERT INTO Film VALUES(42,'Dersou Ouzala',2,1973,141);
INSERT INTO Film VALUES(43,'mission impossible',55,1963,172);
INSERT INTO Film VALUES(44,'Great Escape',55,1963,172);
INSERT INTO Film VALUES(45,'Top Gun',57,1986,172);
INSERT INTO Film VALUES(46,'Oblivion',58,2013,172);
INSERT INTO Film VALUES(47,'Lions et agneaux',58,2007,172);
INSERT INTO Film VALUES(48,'Buck',59,2011,172);
INSERT INTO Film VALUES(49,'minuit a paris',60,2011,172);
INSERT INTO Film VALUES(50,'to rome with love',60,2012,172);
INSERT INTO Film VALUES(51,'Blue jasmine',60,2013,172);
INSERT INTO Film VALUES(52,'Les aventures extraordinaires d adele blanc sec',65,2010,172);
INSERT INTO Film VALUES(53,'Cartel',66,2012,117);
INSERT INTO Film VALUES(54,'Lucy',65,2014,90);
INSERT INTO Film VALUES(55,'Le grand bleu',65,1988,132);
INSERT INTO Film VALUES(56,'Harry Potter a l ecole des sorciers',76,2001,152);
INSERT INTO Film VALUES(57,'Harry Potter et la chambre des secrets',76,2002,174);
INSERT INTO Film VALUES(58,'Harry Potter et le prisonnier d Azkaban',77,2004,142);
INSERT INTO Film VALUES(59,'Harry Potter et la coupe de feu',78,2005,157);
INSERT INTO Film VALUES(60,'Harry Potter et l ordre du phenix',79,2007,138);
INSERT INTO Film VALUES(61,'Harry Potter et le prince de sang mele',79,2009,154);
INSERT INTO Film VALUES(62,'Harry Potter et les reliques de la mort 1 ere partie',79,2010,146);
INSERT INTO Film VALUES(63,'Harry Potter et les reliques de la mort 2 eme partie',79,2011,132);
INSERT INTO Film VALUES(64,'Hunger Games',84,2012,142);
INSERT INTO Film VALUES(65,'Hunger Games : l embrasement',85,2013,142);
INSERT INTO Film VALUES(66,'Hunger Games : la revolte partie 1',85,2014,123);
INSERT INTO Film VALUES(67,'Hunger Games : la revolte partie 2',85,2015,137);
INSERT INTO Film VALUES(68,'Divergente',89,2014,139);
INSERT INTO Film VALUES(69,'Divergente 2 : l Insurrection',90,2015,119);
INSERT INTO Film VALUES(70,'Divergente 3 : Au dela du mur',90,2016,121);
INSERT INTO Film VALUES(71,'James Bond 007 contre Dr No',94,1962,110);
INSERT INTO Film VALUES(72,'Bons Baisers de Russie',94,1963,110);
INSERT INTO Film VALUES(73,'GoldFinger',95,1964,105);
INSERT INTO Film VALUES(74,'Operation Tonnerre',94,1965,125);
INSERT INTO Film VALUES(75,'On ne vit que deux fois',96,1967,112);
INSERT INTO Film VALUES(76,'Au service secret de sa majeste',97,1969,136);
INSERT INTO Film VALUES(77,'Les diamants sont eternels',95,1971,115);
INSERT INTO Film VALUES(78,'Vivre et laisser mourir',95,1973,116);
INSERT INTO Film VALUES(79,'L Homme au pistolet d or',95,1974,119);
INSERT INTO Film VALUES(80,'L espion qui m aimait',96,1977,120);
INSERT INTO Film VALUES(81,'Moonraker',96,1979,121);
INSERT INTO Film VALUES(82,'Rien que pour vos yeux',98,1981,123);
INSERT INTO Film VALUES(83,'Octopussy',98,1983,125);
INSERT INTO Film VALUES(84,'Dangeureusement votre',98,1985,126);
INSERT INTO Film VALUES(85,'Tuer n est pas jouer',98,1987,125);
INSERT INTO Film VALUES(86,'Permis de tuer',98,1989,127);
INSERT INTO Film VALUES(87,'GoldenEye',99,1995,130);
INSERT INTO Film VALUES(88,'Demain ne meurt jamais',100,1997,114);
INSERT INTO Film VALUES(89,'Le monde ne suffit pas',101,1999,128);
INSERT INTO Film VALUES(90,'Meurs un autre jour',102,2002,132);
INSERT INTO Film VALUES(91,'Casino Royale',99,2006,138);
INSERT INTO Film VALUES(92,'Quantum of Solace',103,2008,106);
INSERT INTO Film VALUES(93,'Skyfall',104,2012,143);
INSERT INTO Film VALUES(94,'Spectre',104,2015,148);
INSERT INTO Film VALUES(95,'Le Monde de Narnia : le lion,la sorciere blanche,l armoire magique',105,2005,143);
INSERT INTO Film VALUES(96,'Le Monde de Narnia : le Prince Caspian',105,2008,150);
INSERT INTO Film VALUES(97,'Le Monde de Narnia : l Odyssee du Passeur d Aurore',101,2010,115);
INSERT INTO Film VALUES(98,'Chocolat',112,2016,110);
INSERT INTO Film VALUES(99,'Dunkerque',115,2017,107);
INSERT INTO Film VALUES(100,'Pirates des Caraibes : la malediction du Black Pearl',118,2003,143);
INSERT INTO Film VALUES(101,'Pirates des Caraibes : Le secret du coffre maudit',118,2006,151);
INSERT INTO Film VALUES(102,'Pirates des Caraibes : jusqu au bout du monde',118,2007,169);
INSERT INTO Film VALUES(103,'Pirates des Caraibes : La fontaine de Jouvence',119,2011,137);
INSERT INTO Film VALUES(104,'Pirates des Caraibes : La Vengeance de Salazar',120,2017,129);
INSERT INTO Film VALUES(105,'Mission impossible',125,1996,110);
INSERT INTO Film VALUES(106,'Mission impossible 2',126,2000,123);
INSERT INTO Film VALUES(107,'Mission impossible 3',127,2006,126);
INSERT INTO Film VALUES(108,'Mission impossible : protocole fantome',128,2011,133);
INSERT INTO Film VALUES(109,'Mission impossible : Rogue nation',129,2015,132);
INSERT INTO Film VALUES(110,'Mission impossible : FALLOUT',129,2018,147);
INSERT INTO Film VALUES(111,'Alita : Battle Angel',140,2019,122);
INSERT INTO Film VALUES(112,'Once Upon a Time ... in Hollywood',150,2019,161);
INSERT INTO Film VALUES(113,'AD ASTRA',160,2019,124);


CREATE TABLE Acteur(
                       unActeur NUMBER(4)
		CONSTRAINT fk1_Acteur REFERENCES Personne(idPersonne),
                       unFilm NUMBER(4)
		CONSTRAINT fk2_Acteur REFERENCES Film(code),
                       CONSTRAINT pk_Acteur PRIMARY KEY(unActeur,unFilm),
                       cachet NUMBER(6)
);


INSERT INTO Acteur VALUES(7,1,1500);
INSERT INTO Acteur VALUES(6,3,2500);
INSERT INTO Acteur VALUES(12,7,null);
INSERT INTO Acteur VALUES(7,10,null);
INSERT INTO Acteur VALUES(6,6,null);
INSERT INTO Acteur VALUES(10,4,null);
INSERT INTO Acteur VALUES(14,5,18);
INSERT INTO Acteur VALUES(14,10,234);
INSERT INTO Acteur VALUES(4,2,1300);
INSERT INTO Acteur VALUES(2,5,400);
INSERT INTO Acteur VALUES(11,14,null);
INSERT INTO Acteur VALUES(14,15,2340);
INSERT INTO Acteur VALUES(7,16,1600);
INSERT INTO Acteur VALUES(7,17,1700);
INSERT INTO Acteur VALUES(7,18,1500);
INSERT INTO Acteur VALUES(10,16,1400);
INSERT INTO Acteur VALUES(3,3,15000);
INSERT INTO Acteur VALUES(3,7,14000);
INSERT INTO Acteur VALUES(3,11,12000);
INSERT INTO Acteur VALUES(10,11,1400);
INSERT INTO Acteur VALUES(16,20,null);
INSERT INTO Acteur VALUES(15,23,50);
INSERT INTO Acteur VALUES(8,1,150);
INSERT INTO Acteur VALUES(8,16,250);
INSERT INTO Acteur VALUES(8,17,null);
INSERT INTO Acteur VALUES(8,18,null);
INSERT INTO Acteur VALUES(53,4,3500);
INSERT INTO Acteur VALUES(53,5,3000);
INSERT INTO Acteur VALUES(3,43,20000);
INSERT INTO Acteur VALUES(29,43,500);
INSERT INTO Acteur VALUES(17,7,null);
INSERT INTO Acteur VALUES(56,43,10000);
INSERT INTO Acteur VALUES(56,46,10000);
INSERT INTO Acteur VALUES(56,47,10000);
INSERT INTO Acteur VALUES(59,48,10000);
INSERT INTO Acteur VALUES(61,49,10000);
INSERT INTO Acteur VALUES(62,49,10000);
INSERT INTO Acteur VALUES(63,51,10000);
INSERT INTO Acteur VALUES(64,50,10000);
INSERT INTO Acteur VALUES(60,50,10000);
INSERT INTO Acteur VALUES(64,53,15000);
INSERT INTO Acteur VALUES(67,54,15000);
INSERT INTO Acteur VALUES(65,55,15000);
INSERT INTO Acteur VALUES(68,54,15000);
INSERT INTO Acteur VALUES(69,54,15000);
INSERT INTO Acteur VALUES(80,56,15000);
INSERT INTO Acteur VALUES(80,57,15000);
INSERT INTO Acteur VALUES(80,58,15000);
INSERT INTO Acteur VALUES(80,59,15000);
INSERT INTO Acteur VALUES(80,60,15000);
INSERT INTO Acteur VALUES(80,61,15000);
INSERT INTO Acteur VALUES(80,62,15000);
INSERT INTO Acteur VALUES(80,63,15000);
INSERT INTO Acteur VALUES(81,56,15000);
INSERT INTO Acteur VALUES(81,57,15000);
INSERT INTO Acteur VALUES(81,58,15000);
INSERT INTO Acteur VALUES(81,59,15000);
INSERT INTO Acteur VALUES(81,60,15000);
INSERT INTO Acteur VALUES(81,61,15000);
INSERT INTO Acteur VALUES(81,62,15000);
INSERT INTO Acteur VALUES(81,63,15000);
INSERT INTO Acteur VALUES(82,56,15000);
INSERT INTO Acteur VALUES(82,57,15000);
INSERT INTO Acteur VALUES(82,58,15000);
INSERT INTO Acteur VALUES(82,59,15000);
INSERT INTO Acteur VALUES(82,60,15000);
INSERT INTO Acteur VALUES(82,61,15000);
INSERT INTO Acteur VALUES(82,62,15000);
INSERT INTO Acteur VALUES(82,63,15000);
INSERT INTO Acteur VALUES(83,56,15000);
INSERT INTO Acteur VALUES(83,57,15000);
INSERT INTO Acteur VALUES(83,58,15000);
INSERT INTO Acteur VALUES(83,59,15000);
INSERT INTO Acteur VALUES(83,60,15000);
INSERT INTO Acteur VALUES(83,61,15000);
INSERT INTO Acteur VALUES(83,62,15000);
INSERT INTO Acteur VALUES(83,63,15000);
INSERT INTO Acteur VALUES(86,64,15000);
INSERT INTO Acteur VALUES(86,65,15000);
INSERT INTO Acteur VALUES(86,66,15000);
INSERT INTO Acteur VALUES(86,67,15000);
INSERT INTO Acteur VALUES(87,64,15000);
INSERT INTO Acteur VALUES(87,65,15000);
INSERT INTO Acteur VALUES(87,66,15000);
INSERT INTO Acteur VALUES(87,67,15000);
INSERT INTO Acteur VALUES(88,64,15000);
INSERT INTO Acteur VALUES(88,65,15000);
INSERT INTO Acteur VALUES(88,66,15000);
INSERT INTO Acteur VALUES(88,67,15000);
INSERT INTO Acteur VALUES(91,68,15000);
INSERT INTO Acteur VALUES(91,69,15000);
INSERT INTO Acteur VALUES(91,70,15000);
INSERT INTO Acteur VALUES(92,68,15000);
INSERT INTO Acteur VALUES(92,69,15000);
INSERT INTO Acteur VALUES(92,70,15000);
INSERT INTO Acteur VALUES(93,68,15000);
INSERT INTO Acteur VALUES(93,69,15000);
INSERT INTO Acteur VALUES(70,71,15000);
INSERT INTO Acteur VALUES(70,72,15000);
INSERT INTO Acteur VALUES(70,73,15000);
INSERT INTO Acteur VALUES(70,74,15000);
INSERT INTO Acteur VALUES(70,75,15000);
INSERT INTO Acteur VALUES(70,77,15000);
INSERT INTO Acteur VALUES(71,76,15000);
INSERT INTO Acteur VALUES(72,78,15000);
INSERT INTO Acteur VALUES(72,79,15000);
INSERT INTO Acteur VALUES(72,80,15000);
INSERT INTO Acteur VALUES(72,81,15000);
INSERT INTO Acteur VALUES(72,82,15000);
INSERT INTO Acteur VALUES(72,83,15000);
INSERT INTO Acteur VALUES(72,84,15000);
INSERT INTO Acteur VALUES(73,85,15000);
INSERT INTO Acteur VALUES(73,86,15000);
INSERT INTO Acteur VALUES(75,87,15000);
INSERT INTO Acteur VALUES(75,88,15000);
INSERT INTO Acteur VALUES(75,89,15000);
INSERT INTO Acteur VALUES(75,90,15000);
INSERT INTO Acteur VALUES(74,91,15000);
INSERT INTO Acteur VALUES(74,92,15000);
INSERT INTO Acteur VALUES(74,93,15000);
INSERT INTO Acteur VALUES(74,94,15000);
INSERT INTO Acteur VALUES(106,95,15000);
INSERT INTO Acteur VALUES(106,96,15000);
INSERT INTO Acteur VALUES(106,97,15000);
INSERT INTO Acteur VALUES(107,95,15000);
INSERT INTO Acteur VALUES(107,96,15000);
INSERT INTO Acteur VALUES(107,97,15000);
INSERT INTO Acteur VALUES(108,95,15000);
INSERT INTO Acteur VALUES(108,96,15000);
INSERT INTO Acteur VALUES(108,97,15000);
INSERT INTO Acteur VALUES(109,95,15000);
INSERT INTO Acteur VALUES(109,96,15000);
INSERT INTO Acteur VALUES(109,97,15000);
INSERT INTO Acteur VALUES(110,95,15000);
INSERT INTO Acteur VALUES(110,96,15000);
INSERT INTO Acteur VALUES(110,97,15000);
INSERT INTO Acteur VALUES(111,96,15000);
INSERT INTO Acteur VALUES(111,97,15000);
INSERT INTO Acteur VALUES(113,98,15000);
INSERT INTO Acteur VALUES(114,98,15000);
INSERT INTO Acteur VALUES(116,99,15000);
INSERT INTO Acteur VALUES(117,99,15000);
INSERT INTO Acteur VALUES(121,100,15000);
INSERT INTO Acteur VALUES(122,100,15000);
INSERT INTO Acteur VALUES(123,100,15000);
INSERT INTO Acteur VALUES(124,100,15000);
INSERT INTO Acteur VALUES(121,101,15000);
INSERT INTO Acteur VALUES(122,101,15000);
INSERT INTO Acteur VALUES(123,101,15000);
INSERT INTO Acteur VALUES(124,101,15000);
INSERT INTO Acteur VALUES(121,102,15000);
INSERT INTO Acteur VALUES(122,102,15000);
INSERT INTO Acteur VALUES(123,102,15000);
INSERT INTO Acteur VALUES(124,102,15000);
INSERT INTO Acteur VALUES(121,103,15000);
INSERT INTO Acteur VALUES(122,103,15000);
INSERT INTO Acteur VALUES(123,103,15000);
INSERT INTO Acteur VALUES(124,103,15000);
INSERT INTO Acteur VALUES(121,104,15000);
INSERT INTO Acteur VALUES(122,104,15000);
INSERT INTO Acteur VALUES(123,104,15000);
INSERT INTO Acteur VALUES(56,105,15000);
INSERT INTO Acteur VALUES(56,106,15000);
INSERT INTO Acteur VALUES(56,107,15000);
INSERT INTO Acteur VALUES(56,108,15000);
INSERT INTO Acteur VALUES(56,109,15000);
INSERT INTO Acteur VALUES(56,110,15000);
INSERT INTO Acteur VALUES(131,107,15000);
INSERT INTO Acteur VALUES(131,108,15000);
INSERT INTO Acteur VALUES(131,109,15000);
INSERT INTO Acteur VALUES(131,110,15000);
INSERT INTO Acteur VALUES(132,105,15000);
INSERT INTO Acteur VALUES(132,106,15000);
INSERT INTO Acteur VALUES(132,107,15000);
INSERT INTO Acteur VALUES(132,108,15000);
INSERT INTO Acteur VALUES(132,109,15000);
INSERT INTO Acteur VALUES(132,110,15000);
INSERT INTO Acteur VALUES(133,107,15000);
INSERT INTO Acteur VALUES(133,108,15000);
INSERT INTO Acteur VALUES(133,109,15000);
INSERT INTO Acteur VALUES(133,110,15000);
INSERT INTO Acteur VALUES(141,111,15000);
INSERT INTO Acteur VALUES(142,111,15000);
INSERT INTO Acteur VALUES(143,111,15000);
INSERT INTO Acteur VALUES(151,112,15000);
INSERT INTO Acteur VALUES(152,112,15000);
INSERT INTO Acteur VALUES(153,112,15000);
INSERT INTO Acteur VALUES(152,113,152000);
INSERT INTO Acteur VALUES(161,113,152000);
INSERT INTO Acteur VALUES(162,113,152000);
INSERT INTO Acteur VALUES(163,113,152000);
INSERT INTO Acteur VALUES(164,113,152000);

-- ======================Q3 : Quels sont les titres des films de la base ? V´erifier l’importance de l’utilisation de UPPER

-- En algèbre relationnel :
-- Film{titres}

--En SQL :
SELECT DISTINCT UPPER(titres)
FROM Films;

--Resultat execution :
-- 95 lignes sélectionnées.

-- ====================== Q4 : Quels sont les films sortis en 2019 ?

-- En algèbre relationnel :
--Film{anneeSortie = 2019}[titres]

-- En SQL :
SELECT DISTINCT UPPER(titre)
FROM Film
WHERE anneeSortie = 2019;

-- Resultat execution :
/*
 UPPER(TITRE)
--------------------------------------------------------------------------------
ALITA : BATTLE ANGEL
ONCE UPON A TIME ... IN HOLLYWOOD
AD ASTRA
 */

-- ===================== Q5 : Quels sont les titres des films sortis entre 2017 et 2019 ?

-- En algèbre relationnel :
-- Film{anneeSortie >= 2017 AND anneeSortie <= 2019}[titre]

-- En SQL
SELECT DISTINCT UPPER(titre)
FROM Film
WHERE anneeSortie >= 2017 AND anneeSortie <= 2019;

-- Resultat :
/*
 DUNKERQUE
PIRATES DES CARAIBES : LA VENGEANCE DE SALAZAR
ALITA : BATTLE ANGEL
MISSION IMPOSSIBLE : FALLOUT
ONCE UPON A TIME ... IN HOLLYWOOD
AD ASTRA

6 lignes sélectionnées.
 */

-- ====================== Q6 : Quels sont les noms des personnes qui sont r´ealisateurs ou acteurs ?

SELECT DISTINCT  UPPER(nom)
FROM Personne, Film, Acteur
WHERE idPersonne = leRealisateur
OR idPersonne = unActeur;

-- (Personne[[idPersonne = leRealisateur]]Film) UNION (Personne{idPersonne = unActeur}Acteur)[nom]
SELECT DISTINCT  UPPER(nom)
FROM Personne, Film
WHERE idPersonne = leRealisateur
UNION
SELECT DISTINCT  UPPER(nom)
FROM Personne, Acteur
WHERE idPersonne = unActeur;

-- Resultat execution :
/*
 UPPER(NOM)
--------------------
ABRAMS
ADAMSON
ALLEN
APTED
BARNES
 */

-- ======================= Q7 : Quels sont les titres des films r´ealis´es par un Japonais ( regardez dans la base comment est mise
-- cette information ) ?

-- En algèbre relationnel :
-- (Film[[leRealisateur = idPersonne]]Personne){pays = 'Japon'}[titre]

-- En SQL :
SELECT DISTINCT UPPER(titre)
FROM Film, Personne
WHERE leRealisateur = idPersonne
AND UPPER(pays) = 'JAPON';

-- Resultat execution :

/*
UPPER(TITRE)
--------------------------------------------------------------------------------
LA FORTERESSE CACHEE
LES SEPT SAMOURAIS
DERSOU OUZALA
 */

-- =================== Q8 : Quels sont les pr´enoms et noms des r´ealisateurs fran¸cais ayant sorti des films entre 2014 et 2020 ?

-- En algèbre relationnel :
-- (Personne[[idPersonne = leRealisateur]]Film){pays = 'France' AND anneeSortie >= 2014 AND anneeSortie <= 2020}[prenom, nom]

-- En SQL :
SELECT DISTINCT UPPER(prenom), UPPER(nom)
FROM Personne, Film
WHERE idPersonne = leRealisateur
AND UPPER(pays) = 'FRANCE'
AND anneeSortie >= 2014 AND anneeSortie <= 2020;

-- Resultat execution :
/*
 UPPER(PRENOM)        UPPER(NOM)
-------------------- --------------------
LUC                  BESSON
ZEM                  ROSCHDY
 */

-- ================== Q9 : Quelles sont les titres et les ann´ees de sortie des films tourn´es par le r´ealisateur Luc Besson ?

-- En algèbre relationnel :
-- Personne[[idPersonne = leRealisateur]]Film{nom = 'Besson'}[titre, anneeSortie]

-- En SQL :
SELECT DISTINCT UPPER(titre), anneeSortie
FROM Personne, Film
WHERE idPersonne = leRealisateur
AND UPPER(nom) = 'BESSON';

-- Resultat
/*
 UPPER(TITRE)                                                                     ANNEESORTIE
-------------------------------------------------------------------------------- -----------
LUCY                                                                                    2014
LES AVENTURES EXTRAORDINAIRES D ADELE BLANC SEC                                         2010
LE GRAND BLEU                                                                           1988
 */

SELECT DISTINCT UPPER(nom), UPPER(prenom)
FROM Personne, Film
WHERE idPersonne = leRealisateur
AND idPersonne;

-- ============= Q10 : Quels sont les noms et pr´enoms des personnes qui ne sont pas des r´ealisateurs de films ?

-- En algèbre relationnel :
-- Personne - (Personne[[idPersonne = leRealisateur]]Film){idPersonne}[nom, prenom]

SELECT DISTINCT UPPER(nom), UPPER(prenom)
FROM Personne
MINUS
SELECT DISTINCT UPPER(nom), UPPER(prenom)
FROM Personne, Film
WHERE idPersonne = leRealisateur;

-- en algèbre relationnel :


-- Resultat execution :
/*
 UPPER(NOM)           UPPER(PRENOM)
-------------------- --------------------
BARDOT               BRIGITTE
BARNES               BEN
BLANCHETT            KATE
BLOOM                ORLANDO
BLUNT                GROOM
 68 lignes selectionnées
 */

-- ================= Q11 : Quels sont les noms et pr´enoms des acteurs ayant un cachet moins de 10000 ?
-- En algèbre relationnel :
-- Acteur{cachet < 10000}[nom, prenom]

-- En SQL :
SELECT DISTINCT UPPER(nom), UPPER(prenom)
FROM Personne, Acteur
WHERE idPersonne = unActeur
AND cachet < 10000;

-- Resultat execution :
/*
 UPPER(NOM)           UPPER(PRENOM)
-------------------- --------------------
HOWARD               TREVOR
MORENO               GUY
MARCEAU              SOPHIE
RAIMU
CANTONA              JEAN
L'ESPAGNOL           ANDRE
  6 lignes selectionnées
 */


-- =============== Q12 : Quels sont les titres des 2 films qui sont sortis dans la mˆeme ann´ee ?
SELECT DISTINCT UPPER(F1.titre), UPPER(F2.titre)
FROM Film F1, Film F2
WHERE F1.anneeSortie = F2.anneeSortie
AND UPPER(F1.titre) < UPPER(F2.titre);

-- Resultat
/*
 UPPER(F1.TITRE)                                                                  UPPER(F2.TITRE)
-------------------------------------------------------------------------------- --------------------------------------------------------------------------------
LA ROUTE DE MAGGERSFONTEIN                                                       LE MOULIN ROUGE
DERSOU OUZALA                                                                    LA ROUTE DE MAGGERSFONTEIN
PIRATES DES CARAIBES : JUSQU AU BOUT DU MONDE                                    THIS GLEN IS MINE
BONS BAISERS DE RUSSIE                                                           MISSION IMPOSSIBLE
BLUE JASMINE                                                                     OBLIVION
CARTEL                                                                           TO ROME WITH LOVE
 72 lignes selectionnées
 */

-- ================== Q13 : Quels sont les noms et pr´enoms des acteurs ayant jou´e dans le film ’Hunger Games’ ?

-- En SQL :
SELECT DISTINCT UPPER(nom), UPPER(prenom)
FROM Personne, Acteur, Film
WHERE idPersonne = unActeur
AND unFilm = code
AND UPPER(titre) = 'HUNGER GAMES';

-- Resultat execution :
    /*
     UPPER(NOM)           UPPER(PRENOM)
-------------------- --------------------
LAWRENCE             JENNIFER
HUTCHERSON           JOSHUA
HEMSWORTH            LIAM
     3 lignes selectionnées
     */


-- ================== Q14 : Quels sont les titres des films dans lesquels a jou´e l’acteur Tom Cruise ?

-- En SQL :
SELECT DISTINCT UPPER(titre)
FROM Personne, Acteur, Film
WHERE idPersonne = unActeur
AND unFilm = code
AND UPPER(nom) = 'CRUISE' AND UPPER(prenom) = 'TOM';

-- Resultat execution :
/*
UPPER(TITRE)
--------------------------------------------------------------------------------
MISSION IMPOSSIBLE : ROGUE NATION
MISSION IMPOSSIBLE 3
LIONS ET AGNEAUX
MISSION IMPOSSIBLE 2
MISSION IMPOSSIBLE : PROTOCOLE FANTOME
MISSION IMPOSSIBLE : FALLOUT
OBLIVION
MISSION IMPOSSIBLE

8 lignes sélectionnées.
 */

-- =================== Q15 : Quels sont les noms et pr´enoms des acteurs qui ont jou´e dans des films avec Woody Allen comme
-- r´ealisateur ?

-- En SQL :
SELECT DISTINCT UPPER(P1.nom), UPPER(P1.prenom)
FROM Personne P1, Personne P2, Acteur, Film
WHERE P1.idPersonne = unActeur
AND P2.idPersonne = leRealisateur
AND unFilm = code
AND UPPER(P2.nom) = 'ALLEN' AND UPPER(P2.prenom) = 'WOODY';

-- Resultat execution :
/*
 UPPER(P1.NOM)        UPPER(P1.PRENOM)
-------------------- --------------------
CRUZ                 PENELOPE
ELMALEH              GAD
ALLEN                WOODY
COTTILARD            MARION
BLANCHETT            KATE
 */

-- =================== Q16 : Quels sont les titres des films o`u le r´ealisateur est aussi acteur ?

-- En SQL :
SELECT DISTINCT UPPER(titre)
FROM Personne, Film
WHERE idPersonne = leRealisateur
AND idPersonne IN (SELECT unActeur
                   FROM Acteur
                   WHERE unActeur = leRealisateur);

/*
 UPPER(TITRE)
--------------------------------------------------------------------------------
80 CHASSEURS
LE TRACTEUR
LES SEPT BOULES DE CRISTAL
LA FORTERESSE CACHEE
LES SEPT NAINS
 */

-- ===================== Q17 : Proposez d’autres requˆetes de jointures et d’auto-jointures s’il vous reste le temps

-- En SQL :
SELECT DISTINCT UPPER(nom), UPPER(prenom)
FROM Personne, Acteur
WHERE idPersonne = unActeur
AND idPersonne IN (SELECT unActeur
                   FROM Acteur
                   WHERE unActeur = leRealisateur);


