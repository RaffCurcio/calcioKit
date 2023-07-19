CREATE SCHEMA calciokitdb;
USE calciokitdb;

CREATE TABLE Cliente (
  username VARCHAR(50) NOT NULL UNIQUE,
  email VARCHAR(100) NOT NULL,
  pwd VARCHAR(50) NOT NULL,
  nome VARCHAR(50) ,
  cognome VARCHAR(50),
  indirizzo VARCHAR(100) ,
  citta VARCHAR(50) ,
  provincia VARCHAR(50) ,
  ruolo_cliente VARCHAR(50) ,
  cap VARCHAR(10),
  PRIMARY KEY (username, email)
); 

CREATE TABLE Ordine (
  ID_ordine INT  PRIMARY KEY NOT NULL AUTO_INCREMENT,
  data_inserimento DATE NOT NULL,
  prezzo_vendita DECIMAL(10, 2) NOT NULL,
  iva_cout DECIMAL(5, 2) NOT NULL,
  stato_ordine VARCHAR(50) NOT NULL,
  username_cli VARCHAR(50) NOT NULL,
  email_cli VARCHAR(100) NOT NULL,
  FOREIGN KEY (username_cli, email_cli) REFERENCES Cliente (username, email)
  ON UPDATE CASCADE ON DELETE CASCADE
  );

CREATE TABLE Telefono (
  numero_tel VARCHAR(20) NOT NULL,
  prefisso VARCHAR(10) NOT NULL,
  username_cli VARCHAR(50)NOT NULL,
  email_cli VARCHAR(100)NOT NULL ,
  FOREIGN KEY (username_cli, email_cli) REFERENCES Cliente (username, email)
  ON DELETE CASCADE ON UPDATE CASCADE 
);


CREATE TABLE Pagamento (
  ID_pagamento INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  data_pag DATE NOT NULL,
  importo_pag DECIMAL(10, 2) NOT NULL,
  num_carta VARCHAR(20),
  data_scadenza DATE,
  titolare_conto VARCHAR(100),
  id_ordine INT NOT NULL,
  FOREIGN KEY (id_ordine) REFERENCES Ordine (ID_ordine)
  ON DELETE CASCADE ON UPDATE CASCADE 
);



CREATE TABLE Prodotto (
  ID_Prodotto INT PRIMARY KEY AUTO_INCREMENT,
  nome_Prodotto VARCHAR(100) NOT NULL,
  prezzo DECIMAL(10, 2) NOT NULL,
  descrizione TEXT,
  iva_p DECIMAL(5, 2) NOT NULL,
  path_immagine VARCHAR(255),
  raccomandato boolean default false,
  cancellato boolean default false
);

CREATE TABLE composizione (
  composizione_id INT PRIMARY KEY AUTO_INCREMENT,

  id_Prodotto INT NOT NULL,
  id_ordine INT ,
  prezzo_Prodotto DECIMAL(10,2) ,
  quantita INT NOT NULL,
  username_cli VARCHAR(50) NOT NULL,
  email_cli VARCHAR(100) NOT NULL,
  FOREIGN KEY (id_Prodotto) REFERENCES Prodotto (ID_Prodotto),
  FOREIGN KEY (id_ordine) REFERENCES Ordine (ID_ordine),
  FOREIGN KEY (username_cli, email_cli) REFERENCES Cliente (username, email) ON DELETE CASCADE
 
  );



INSERT INTO cliente (username, email, pwd, nome, cognome, indirizzo, citta, provincia, cap, ruolo_cliente)
VALUES ('johndoe', 'john.doe@example.com', 'Password1@', 'John', 'Doe', 'Via Roma 123', 'Milano', 'MI', '20100', 'admin');

INSERT INTO cliente (username, email, pwd, nome, cognome, indirizzo, citta, provincia, cap, ruolo_cliente)
VALUES ('janesmith', 'jane.smith@example.com', 'Password1@', 'Jane', 'Smith', 'Via Verdi 456', 'Roma', 'RM', '20100' , 'cliente');

INSERT INTO cliente (username, email, pwd, nome, cognome, indirizzo, citta, provincia, cap, ruolo_cliente)
VALUES ('markwilliams', 'mark.williams@example.com', 'Password1@', 'Mark', 'Williams', 'Via Italia 789', 'Torino', 'TO', '10100', 'cliente');

INSERT INTO cliente (username, email, pwd, nome, cognome, indirizzo, citta, provincia, cap, ruolo_cliente)
VALUES ('amyjohnson', 'amy.johnson@example.com', 'Password1@', 'Amy', 'Johnson', 'Via Europa 10', 'Firenze', 'FI', '50100','cliente' );

INSERT INTO cliente (username, email, pwd, nome, cognome, indirizzo, citta, provincia, cap, ruolo_cliente)
VALUES ('peterdavis', 'peter.davis@example.com', 'Password1@', 'Peter', 'Davis', 'Via Leonardo 23', 'Napoli', 'NA', '80100' ,'cliente');


-- Inserimento di un numero di telefono per il cliente "john.doe"
INSERT INTO Telefono (numero_tel, prefisso, username_cli, email_cli)
VALUES ('1234567890', '+39', 'johndoe', 'john.doe@example.com');

-- Inserimento di un numero di telefono per il cliente "jane.smith"
INSERT INTO Telefono (numero_tel, prefisso, username_cli, email_cli)
VALUES ('9876543210', '+39', 'janesmith', 'jane.smith@example.com');

-- Inserimento di un numero di telefono per il cliente "mark.williams"
INSERT INTO Telefono (numero_tel, prefisso, username_cli, email_cli)
VALUES ('5555555555', '+39', 'markwilliams', 'mark.williams@example.com');

-- Inserimento di un numero di telefono per il cliente "amy.johnson"
INSERT INTO Telefono (numero_tel, prefisso, username_cli, email_cli)
VALUES ('1111111111', '+39', 'amyjohnson', 'amy.johnson@example.com');

-- Inserimento di un numero di telefono per il cliente "peter.davis"
INSERT INTO Telefono (numero_tel, prefisso, username_cli, email_cli)
VALUES ('9999999999', '+39', 'peterdavis', 'peter.davis@example.com');


-- Inserimento di un Prodotto
INSERT INTO Prodotto (nome_Prodotto, prezzo, descrizione, iva_p, path_immagine)
VALUES ('Maglia Maradona', 10.99, 'Maglia Maradona Vintage', 22.00, 'img/magliaMaradona.jpg ');

-- Inserimento di un altro Prodotto
INSERT INTO Prodotto (nome_Prodotto, prezzo, descrizione, iva_p, path_immagine)
VALUES ('Maglia Milan', 19.99, 'Maglia Milan 2022/2023', 15.50, 'img/magliaMilan.jpg ');

-- Inserimento di un altro Prodotto
INSERT INTO Prodotto (nome_Prodotto, prezzo, descrizione, iva_p, path_immagine)
VALUES ('Maglia Napoli', 7.50, 'Maglia Napoli 2022/2023', 20.00, 'img/magliaNapoli.jpg ');

-- Inserimento di un altro Prodotto
INSERT INTO Prodotto (nome_Prodotto, prezzo, descrizione, iva_p, path_immagine)
VALUES ('Maglia Napoli San Valentino', 24.99, 'Maglia Napoli San Valentino', 12.80,'img/magliaNapoliSanValentino.jpg ');

-- Inserimento di un altro Prodotto
INSERT INTO Prodotto (nome_Prodotto, prezzo, descrizione, iva_p, path_immagine)
VALUES ('Maglia Roma', 15.00, 'Maglia Roma 2022/2023', 18.20, 'img/magliaRoma.jpg ');

