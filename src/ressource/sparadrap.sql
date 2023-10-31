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


INSERT INTO personne (per_nom, per_prenom, per_telephone, per_email, adr_id)
	VALUES ("Dupont", "Jean", "0612345678", "dupont.jean@gmail.com", 1);
INSERT INTO personne (per_nom, per_prenom, per_telephone, per_email, adr_id)
	VALUES ("Martin", "Marie", "0789654321", "Martin.Marie@gmail.com", 2);
INSERT INTO personne (per_nom, per_prenom, per_telephone, per_email, adr_id)
	VALUES ("Durand", "Paul", "0476543210", "durand.paul@gmail.com", 3);
INSERT INTO personne (per_nom, per_prenom, per_telephone, per_email, adr_id)
	VALUES ("aaa", "aa", "4567891234", "aa.a@gmail.com", 4);
INSERT INTO personne (per_nom, per_prenom, per_telephone, per_email, adr_id)
	VALUES ("bbb", "bb", "5678912345", "bb.b@gmail.com", 5);
INSERT INTO personne (per_nom, per_prenom, per_telephone, per_email, adr_id)
	VALUES ("ccc", "cc", "6789123456", "cc.c@gmail.com", 6);
INSERT INTO personne (per_nom, per_prenom, per_telephone, per_email, adr_id)
	VALUES ("zzz", "zz", "9876543219", "z.zz@gmail.com", 7);
INSERT INTO personne (per_nom, per_prenom, per_telephone, per_email, adr_id)
	VALUES ("yyy", "yy", "8765432198", "y.yy@gmail.com", 8);
INSERT INTO personne (per_nom, per_prenom, per_telephone, per_email, adr_id)
	VALUES ("xxx", "xx", "7654321987", "y.yy@gmail.com", 9);
    
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

INSERT INTO pharmacie (pha_nom, adr_id)
	VALUES ("Sparadrap", 10);
 
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










