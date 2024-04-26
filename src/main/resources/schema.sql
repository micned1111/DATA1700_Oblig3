CREATE TABLE Kinobillett
(
    nr INTEGER AUTO_INCREMENT,
    film VARCHAR(100) NOT NULL,
    antall INTEGER NOT NULL,
    fornavn VARCHAR(50) NOT NULL,
    etternavn VARCHAR(50) NOT NULL,
    telefonNr CHAR(8) NOT NULL,
    epost VARCHAR(100) NOT NULL,
    PRIMARY KEY (nr)
);

CREATE TABLE Film
(
    filmNr INTEGER AUTO_INCREMENT,
    tittel VARCHAR(100) NOT NULL,
    PRIMARY KEY (filmNr)
);