DROP TABLE IF EXISTS util;
CREATE TABLE util (
	id SERIAL PRIMARY KEY,
	nom VARCHAR (25),
	prenom VARCHAR (30),
	email VARCHAR (20),
	login VARCHAR (20),
	mdp VARCHAR (20)
 );