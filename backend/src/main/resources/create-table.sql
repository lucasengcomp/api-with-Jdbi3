CREATE TABLE IF NOT EXISTS author (
	id serial PRIMARY KEY,
	lastname VARCHAR (100) NOT NULL,
	firstname VARCHAR (100) NOT NULL
);

CREATE TABLE IF NOT EXISTS book (
	id serial PRIMARY KEY,
	title VARCHAR (100) NOT NULL,
	page int NOT NULL,
	isbn VARCHAR (50) NOT NULL,
	description VARCHAR (200) NOT NULL,
	price decimal(21,2)
);
