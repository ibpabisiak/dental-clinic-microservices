DROP TABLE dentists IF EXISTS;

CREATE TABLE dentists (
                      id         INTEGER IDENTITY PRIMARY KEY,
                      first_name VARCHAR(30),
                      last_name  VARCHAR(30),
                      speciality VARCHAR(30)
);