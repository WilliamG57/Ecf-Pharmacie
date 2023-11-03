/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de création :  30/10/2023                               */
/* Auteur : William GILLET										*/	
/* Description : BDD de Sparadrap     		 					*/
/*==============================================================*/

CREATE DATABASE IF NOT EXISTS sparadrap;

DROP TABLE IF EXISTS ordonnance;
DROP TABLE IF EXISTS pharmacie;
DROP TABLE IF EXISTS facture;
DROP TABLE IF EXISTS medicament;
DROP TABLE IF EXISTS categorie;
DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS mutuelle;
DROP TABLE IF EXISTS medecin;
DROP TABLE IF EXISTS specialiste;
DROP TABLE IF EXISTS personne;



CREATE TABLE personne
(
	per_id INT AUTO_INCREMENT NOT NULL,
    per_nom VARCHAR(20) NOT NULL,
    per_prenom VARCHAR(20) NOT NULL,
    per_telephone VARCHAR(15) NOT NULL,
    per_email VARCHAR(50) NOT NULL,
    per_adr VARCHAR(50) NOT NULL,
    per_codepostal VARCHAR(5) NOT NULL,
    per_ville VARCHAR(20),
    PRIMARY KEY (per_id)
);


CREATE TABLE mutuelle
(
	mut_id INT AUTO_INCREMENT NOT NULL,
    mut_nom VARCHAR (20) NOT NULL,
    PRIMARY KEY (mut_id)
);


CREATE TABLE medecin
(
	med_id INT AUTO_INCREMENT NOT NULL,
    med_agreement INT NOT NULL,
    per_id INT NOT NULL,
    PRIMARY KEY (med_id),
    FOREIGN KEY (per_id)
		REFERENCES personne (per_id)
);

CREATE TABLE specialiste
(
	spe_id INT AUTO_INCREMENT NOT NULL,
    spe_specialite VARCHAR(20) NOT NULL,
    per_id INT NOT NULL,
    PRIMARY KEY (spe_id),
    FOREIGN KEY (per_id)
		REFERENCES personne (per_id)
);


CREATE TABLE client 
(
	cli_id INT AUTO_INCREMENT NOT NULL,
    cli_secu VARCHAR(15) NOT NULL,
    cli_datenaissance DATE,
	per_id INT NOT NULL,
	spe_id INT NOT NULL,
    med_id INT NOT NULL,
    mut_id INT NOT NULL,
    PRIMARY KEY (cli_id),
    FOREIGN KEY (per_id)
    REFERENCES personne (per_id),
    FOREIGN KEY (spe_id)
    REFERENCES specialiste (spe_id),
    FOREIGN KEY (med_id)
    REFERENCES medecin (med_id),
    FOREIGN KEY (mut_id)
    REFERENCES mutuelle (mut_id)
);


CREATE TABLE pharmacie
(
	pha_id INT AUTO_INCREMENT NOT NULL,
    pha_nom VARCHAR(50) NOT NULL,
	pha_adr VARCHAR(50) NOT NULL,
    pha_codepostal VARCHAR(5) NOT NULL,
    pha_ville VARCHAR(20),
    PRIMARY KEY (pha_id)
);

CREATE TABLE categorie
(
	cat_id INT AUTO_INCREMENT NOT NULL,
    cat_categorie VARCHAR(20) NOT NULL,
    PRIMARY KEY (cat_id)
);

CREATE TABLE medicament 
(
	medi_id INT AUTO_INCREMENT NOT NULL,
    medi_nom VARCHAR(20) NOT NULL,
    medi_prix NUMERIC(8,2) NOT NULL,
    medi_miseenservice DATE NOT NULL,
    cat_id INT NOT NULL,
    PRIMARY KEY (medi_id),
    FOREIGN KEY (cat_id)
		REFERENCES categorie (cat_id)
);
 

CREATE TABLE ordonnance
(
	ord_date DATE NOT NULL,
    spe_id INT NOT NULL,
    med_id INT NOT NULL,
    cli_id INT NOT NULL,
    medi_id INT NOT NULL,
    PRIMARY KEY (spe_id, med_id, cli_id, medi_id),
    FOREIGN KEY (spe_id)
		REFERENCES specialiste (spe_id),
    FOREIGN KEY (med_id)
		REFERENCES medecin (med_id),
    FOREIGN KEY (cli_id)
		REFERENCES client (cli_id),
	FOREIGN KEY (medi_id)
		REFERENCES medicament (medi_id)
);

 CREATE TABLE facture
 (
	cli_id INT NOT NULL,
    medi_id INT NOT NULL,
    PRIMARY KEY (cli_id, medi_id),
    FOREIGN KEY (cli_id)
		REFERENCES client (cli_id),
	FOREIGN KEY (medi_id)
		REFERENCES medicament (medi_id)
 );







INSERT INTO adresse (adr_adresse, adr_codepostal, adr_ville)
	VALUES ("123 place de la république", "75001", "Paris");
INSERT INTO adresse (adr_adresse, adr_codepostal, adr_ville)
	VALUES ("456 avenue de la gare", "92100", "Boulogne");
INSERT INTO adresse (adr_adresse, adr_codepostal, adr_ville)
	VALUES ("789 rue de la liberté", "69002", "Lyon");
INSERT INTO adresse (adr_adresse, adr_codepostal, adr_ville)
	VALUES ("123 rue a", "10000", "abc");
INSERT INTO adresse (adr_adresse, adr_codepostal, adr_ville)
	VALUES ("456 rue b", "20000", "efg");
INSERT INTO adresse (adr_adresse, adr_codepostal, adr_ville)
	VALUES ("789 rue c", "30000", "hij");
INSERT INTO adresse (adr_adresse, adr_codepostal, adr_ville)
	VALUES ("321 rue z", "90000", "xyz");
INSERT INTO adresse (adr_adresse, adr_codepostal, adr_ville)
	VALUES ("654 rue y", "80000", "uvw");
INSERT INTO adresse (adr_adresse, adr_codepostal, adr_ville)
	VALUES ("987 rue x", "70000", "rst");
INSERT INTO adresse (adr_adresse, adr_codepostal, adr_ville)
	VALUES ("528 rue pharma", "75002", "Paris");


INSERT INTO personne (per_nom, per_prenom, per_telephone, per_email, per_adr, per_codepostal, per_ville)
	VALUES ("Dupont", "Jean", "0612345678", "dupont.jean@gmail.com","123 place de la république", "75001", "Paris");
INSERT INTO personne (per_nom, per_prenom, per_telephone, per_email, per_adr, per_codepostal, per_ville)
	VALUES ("Martin", "Marie", "0789654321", "Martin.Marie@gmail.com", "456 avenue de la gare", "92100", "Boulogne");
INSERT INTO personne (per_nom, per_prenom, per_telephone, per_email, per_adr, per_codepostal, per_ville)
	VALUES ("Durand", "Paul", "0476543210", "durand.paul@gmail.com", "789 rue de la liberté", "69002", "Lyon");
INSERT INTO personne (per_nom, per_prenom, per_telephone, per_email, per_adr, per_codepostal, per_ville)
	VALUES ("aaa", "aa", "4567891234", "aa.a@gmail.com", "123 rue a", "10000", "abc");
INSERT INTO personne (per_nom, per_prenom, per_telephone, per_email, per_adr, per_codepostal, per_ville)
	VALUES ("bbb", "bb", "5678912345", "bb.b@gmail.com", "456 rue b", "20000", "efg");
INSERT INTO personne (per_nom, per_prenom, per_telephone, per_email, per_adr, per_codepostal, per_ville)
	VALUES ("ccc", "cc", "6789123456", "cc.c@gmail.com", "789 rue c", "30000", "hij");
INSERT INTO personne (per_nom, per_prenom, per_telephone, per_email, per_adr, per_codepostal, per_ville)
	VALUES ("zzz", "zz", "9876543219", "z.zz@gmail.com", "321 rue z", "90000", "xyz");
INSERT INTO personne (per_nom, per_prenom, per_telephone, per_email, per_adr, per_codepostal, per_ville)
	VALUES ("yyy", "yy", "8765432198", "y.yy@gmail.com", "654 rue y", "80000", "uvw");
INSERT INTO personne (per_nom, per_prenom, per_telephone, per_email, per_adr, per_codepostal, per_ville)
	VALUES ("xxx", "xx", "7654321987", "x.xx@gmail.com", "987 rue x", "70000", "rst");
    
INSERT INTO mutuelle (mut_nom)
	VALUES ("CCMO");
INSERT INTO mutuelle (mut_nom)
	VALUES ("Mutami");
INSERT INTO mutuelle (mut_nom)
	VALUES ("GFP");
    
INSERT INTO medecin (med_agreement, per_id)
	VALUES (458, 4);
INSERT INTO medecin (med_agreement, per_id)
	VALUES (126, 5);
INSERT INTO medecin (med_agreement, per_id)
	VALUES (824, 6);

INSERT INTO specialiste (spe_specialite, per_id)
	VALUES ("somnoliste", 7);
INSERT INTO specialiste (spe_specialite, per_id)
	VALUES ("ophtalmologiste", 8);
INSERT INTO specialiste (spe_specialite, per_id)
	VALUES ("urologiste", 9);

INSERT INTO client (cli_secu, cli_datenaissance, per_id, spe_id, med_id, mut_id)
	VALUES ("123456789123456", "1988-08-01", 1, 1, 1, 1);
INSERT INTO client (cli_secu, cli_datenaissance, per_id, spe_id, med_id, mut_id)
	VALUES ("234567891234567", "2000-03-01", 2, 2, 2, 2);
INSERT INTO client (cli_secu, cli_datenaissance, per_id, spe_id, med_id, mut_id)
	VALUES ("345678912345678", "1958-02-01", 3, 3, 3, 3);

INSERT INTO pharmacie (pha_nom, pha_adr, pha_codepostal, pha_ville)
	VALUES ("Sparadrap", "528 rue pharma", "75002", "Paris");
 
 INSERT INTO categorie (cat_categorie)
	VALUES ("anti-douleur");
 INSERT INTO categorie (cat_categorie)
	VALUES ("somnifere");
 INSERT INTO categorie (cat_categorie)
	VALUES ("goutte");
 INSERT INTO categorie (cat_categorie)
	VALUES ("viagra");

INSERT INTO medicament (medi_nom, medi_prix, medi_miseenservice, cat_id)
	VALUES ("doliprane", 4.50, "1964-03-05", 1);
INSERT INTO medicament (medi_nom, medi_prix, medi_miseenservice, cat_id)
	VALUES ("millepertuis", 7.90, "1985-06-28", 2);
INSERT INTO medicament (medi_nom, medi_prix, medi_miseenservice, cat_id)
	VALUES ("collyre", 3.39, "1954-03-16", 3);
INSERT INTO medicament (medi_nom, medi_prix, medi_miseenservice, cat_id)
	VALUES ("sildenafil", 9.99, "1998-04-17", 4);
    
    