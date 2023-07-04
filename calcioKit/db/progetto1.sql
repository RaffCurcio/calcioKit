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
  stato_ordine VARCHAR(20) NOT NULL,
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

CREATE TABLE Spedizione (
  ID_spedizione INT PRIMARY KEY NOT NULL,
  data_sp DATE NOT NULL,
  costi_sp DECIMAL(10, 2) NOT NULL,
  costi_exp DECIMAL(10, 2) NOT NULL,
  ordine_spedito INT NOT NULL,
  FOREIGN KEY (ordine_spedito) REFERENCES Ordine (ID_ordine)
  ON DELETE CASCADE ON UPDATE CASCADE 
);

CREATE TABLE Pagamento (
  ID_pagamento INT PRIMARY KEY NOT NULL,
  data_pag DATE NOT NULL,
  importo_pag DECIMAL(10, 2) NOT NULL,
  tipo_pag VARCHAR(50) NOT NULL,
  num_carta VARCHAR(20),
  data_scadenza DATE,
  cvc VARCHAR(4),
  titolare_conto VARCHAR(100),
  iban VARCHAR(30),
  bic VARCHAR(20),
  email_payp VARCHAR(100),
  pwd_payp VARCHAR(50),
  id_ordine INT NOT NULL,
  FOREIGN KEY (id_ordine) REFERENCES Ordine (ID_ordine)
  ON DELETE CASCADE ON UPDATE CASCADE 
);
 CREATE TABLE Fattura (
  ID_fattura INT PRIMARY KEY NOT NULL,
  data_fattura DATE NOT NULL,
  anno INT NOT NULL,
  iva_fattura DECIMAL(10, 2) NOT NULL,
  ID_P INT NOT NULL,
  FOREIGN KEY (ID_P) REFERENCES Pagamento (ID_pagamento)
  ON DELETE CASCADE ON UPDATE CASCADE 
);


CREATE TABLE Prodotto (
  ID_Prodotto INT PRIMARY KEY AUTO_INCREMENT,
  nome_Prodotto VARCHAR(100) NOT NULL,
  prezzo DECIMAL(10, 2) NOT NULL,
  descrizione TEXT,
  iva_p DECIMAL(5, 2) NOT NULL,
  path_immagine VARCHAR(255),
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
VALUES ('john.doe', 'john.doe@example.com', 'password', 'John', 'Doe', 'Via Roma 123', 'Milano', 'MI', '20100', 'admin');

INSERT INTO cliente (username, email, pwd, nome, cognome, indirizzo, citta, provincia, cap, ruolo_cliente)
VALUES ('jane.smith', 'jane.smith@example.com', 'password', 'Jane', 'Smith', 'Via Verdi 456', 'Roma', 'RM', '00100' , 'cliente');

INSERT INTO cliente (username, email, pwd, nome, cognome, indirizzo, citta, provincia, cap, ruolo_cliente)
VALUES ('mark.williams', 'mark.williams@example.com', 'password', 'Mark', 'Williams', 'Via Italia 789', 'Torino', 'TO', '10100', 'cliente');

INSERT INTO cliente (username, email, pwd, nome, cognome, indirizzo, citta, provincia, cap, ruolo_cliente)
VALUES ('amy.johnson', 'amy.johnson@example.com', 'password', 'Amy', 'Johnson', 'Via Europa 10', 'Firenze', 'FI', '50100','cliente' );

INSERT INTO cliente (username, email, pwd, nome, cognome, indirizzo, citta, provincia, cap, ruolo_cliente)
VALUES ('peter.davis', 'peter.davis@example.com', 'password', 'Peter', 'Davis', 'Via Leonardo 23', 'Napoli', 'NA', '80100' ,'cliente');

INSERT INTO Ordine (ID_ordine, data_inserimento, prezzo_vendita, iva_cout, stato_ordine, username_cli, email_cli)
VALUES
  (1, '2023-05-01', 50.00, 10.00, 'Confermato', 'john.doe', 'john.doe@example.com'),
  (2, '2023-05-02', 75.50, 15.00, 'Spedito', 'jane.smith', 'jane.smith@example.com'),
  (3, '2023-05-03', 120.00, 24.00, 'Confermato', 'mark.williams', 'mark.williams@example.com'),
  (4, '2023-05-04', 45.80, 9.16, 'Spedito', 'amy.johnson', 'amy.johnson@example.com'),
  (5, '2023-05-05', 90.20, 18.04, 'Spedito', 'peter.davis', 'peter.davis@example.com');

-- Inserimento di un numero di telefono per il cliente "john.doe"
INSERT INTO Telefono (numero_tel, prefisso, username_cli, email_cli)
VALUES ('1234567890', '+39', 'john.doe', 'john.doe@example.com');

-- Inserimento di un numero di telefono per il cliente "jane.smith"
INSERT INTO Telefono (numero_tel, prefisso, username_cli, email_cli)
VALUES ('9876543210', '+39', 'jane.smith', 'jane.smith@example.com');

-- Inserimento di un numero di telefono per il cliente "mark.williams"
INSERT INTO Telefono (numero_tel, prefisso, username_cli, email_cli)
VALUES ('5555555555', '+39', 'mark.williams', 'mark.williams@example.com');

-- Inserimento di un numero di telefono per il cliente "amy.johnson"
INSERT INTO Telefono (numero_tel, prefisso, username_cli, email_cli)
VALUES ('1111111111', '+39', 'amy.johnson', 'amy.johnson@example.com');

-- Inserimento di un numero di telefono per il cliente "peter.davis"
INSERT INTO Telefono (numero_tel, prefisso, username_cli, email_cli)
VALUES ('9999999999', '+39', 'peter.davis', 'peter.davis@example.com');

-- Inserimento di una spedizione
INSERT INTO Spedizione (ID_spedizione, data_sp, costi_sp, costi_exp, ordine_spedito)
VALUES (1, '2023-05-01', 10.00, 5.00, 1);

-- Inserimento di un'altra spedizione
INSERT INTO Spedizione (ID_spedizione, data_sp, costi_sp, costi_exp, ordine_spedito)
VALUES (2, '2023-05-02', 15.50, 7.50, 2);

-- Inserimento di un'altra spedizione
INSERT INTO Spedizione (ID_spedizione, data_sp, costi_sp, costi_exp, ordine_spedito)
VALUES (3, '2023-05-03', 20.00, 10.00, 3);

-- Inserimento di un'altra spedizione
INSERT INTO Spedizione (ID_spedizione, data_sp, costi_sp, costi_exp, ordine_spedito)
VALUES (4, '2023-05-04', 12.80, 6.40, 4);

-- Inserimento di un'altra spedizione
INSERT INTO Spedizione (ID_spedizione, data_sp, costi_sp, costi_exp, ordine_spedito)
VALUES (5, '2023-05-05', 18.20, 9.10, 5);

 -- Inserimento di un pagamento
INSERT INTO pagamento (ID_pagamento, data_pag, importo_pag, tipo_pag, num_carta, data_scadenza, cvc, titolare_conto, iban, bic, email_payp, pwd_payp, id_ordine)
VALUES (1, '2023-05-01', 50.00, 'Carta di credito', '1234567890123456', '2024-05-01', '123', NULL, NULL, NULL, NULL, NULL, 1);

-- Inserimento di un altro pagamento
INSERT INTO pagamento (ID_pagamento, data_pag, importo_pag, tipo_pag, num_carta, data_scadenza, cvc, titolare_conto, iban, bic, email_payp, pwd_payp, id_ordine)
VALUES (2, '2023-05-02', 100.00, 'Carta di credito', '9876543210987654', '2025-05-01', '456', NULL, NULL, NULL, NULL, NULL, 2);

-- Inserimento di un altro pagamento
INSERT INTO pagamento (ID_pagamento, data_pag, importo_pag, tipo_pag, num_carta, data_scadenza, cvc, titolare_conto, iban, bic, email_payp, pwd_payp, id_ordine)
VALUES (3, '2023-05-03', 75.50, 'PayPal', NULL, NULL, NULL, NULL, NULL, NULL, 'john.doe@example.com', 'password', 3);

-- Inserimento di un altro pagamento
INSERT INTO pagamento (ID_pagamento, data_pag, importo_pag, tipo_pag, num_carta, data_scadenza, cvc, titolare_conto, iban, bic, email_payp, pwd_payp, id_ordine)
VALUES (4, '2023-05-04', 30.80, 'Carta di credito', '1111222233334444', '2024-06-01', '789', NULL, NULL, NULL, NULL, NULL, 4);

-- Inserimento di un altro pagamento
INSERT INTO pagamento (ID_pagamento, data_pag, importo_pag, tipo_pag, num_carta, data_scadenza, cvc, titolare_conto, iban, bic, email_payp, pwd_payp, id_ordine)
VALUES (5, '2023-05-05', 20.00, 'Bonifico bancario', NULL, NULL, NULL, 'Peter Davis', 'IT12345678901234567890', 'BICCODE', NULL, NULL, 5);

-- Inserimento di una fattura
INSERT INTO fattura (ID_fattura, data_fattura, anno, iva_fattura, ID_P)
VALUES (1, '2023-05-01', 2023, 22.00, 1);

-- Inserimento di un'altra fattura
INSERT INTO fattura (ID_fattura, data_fattura, anno, iva_fattura, ID_P)
VALUES (2, '2023-05-02', 2023, 15.50, 2);

-- Inserimento di un'altra fattura
INSERT INTO fattura (ID_fattura, data_fattura, anno, iva_fattura, ID_P)
VALUES (3, '2023-05-03', 2023, 20.00, 3);

-- Inserimento di un'altra fattura
INSERT INTO fattura (ID_fattura, data_fattura, anno, iva_fattura, ID_P)
VALUES (4, '2023-05-04', 2023, 12.80, 4);

-- Inserimento di un'altra fattura
INSERT INTO fattura (ID_fattura, data_fattura, anno, iva_fattura, ID_P)
VALUES (5, '2023-05-05', 2023, 18.20, 5);

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

