CREATE TABLE pubblicazioni (
    codice_isbn VARCHAR(20) PRIMARY KEY,
    titolo VARCHAR(255) NOT NULL,
    anno_pubblicazione INT NOT NULL,
    numero_pagine INT NOT NULL
);


CREATE TABLE riviste (
    codice_isbn VARCHAR(20) PRIMARY KEY REFERENCES pubblicazioni(codice_isbn),
    periodicita VARCHAR(15) CHECK (periodicita IN ('SETTIMANALE', 'MENSILE', 'SEMESTRALE'))
);

CREATE TABLE autore (
    uniqueID UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome VARCHAR(100) NOT NULL,
    cognome VARCHAR(100) NOT NULL
);

CREATE TABLE genere (
    uniqueID UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    tipo VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE libri (
    codice_isbn VARCHAR(20) PRIMARY KEY REFERENCES pubblicazioni(codice_isbn),
    autore_id UUID NOT NULL,
    genere_id UUID NOT NULL,
    FOREIGN KEY (autore_id) REFERENCES autore(uniqueID),
    FOREIGN KEY (genere_id) REFERENCES genere(uniqueID)
);

CREATE TABLE utente (
    numero_tessera SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cognome VARCHAR(100) NOT NULL,
    data_nascita DATE NOT NULL
);


CREATE TABLE prestito (
    uniqueID UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    utente_id INT NOT NULL REFERENCES utente(numero_tessera),
    pubblicazione_id VARCHAR(20) NOT NULL REFERENCES pubblicazioni(codice_isbn),
    data_inizio_prestito DATE NOT NULL,
    data_restituzione_prevista DATE NOT NULL DEFAULT (CURRENT_DATE + INTERVAL '30 days'),
    data_restituzione_effettiva DATE
);
