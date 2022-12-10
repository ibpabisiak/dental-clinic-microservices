DROP TABLE patients IF EXISTS;

CREATE TABLE patients
(
    id         INTEGER IDENTITY PRIMARY KEY,
    first_name VARCHAR(30),
    last_name  VARCHAR(30),
    address    VARCHAR(30),
    city       VARCHAR(30),
    telephone  VARCHAR(9),
    pesel      VARCHAR(11)
);