DROP TABLE patients IF EXISTS;

CREATE TABLE visits
(
    id               INTEGER IDENTITY PRIMARY KEY,
    visit_date       DATE,
    description      VARCHAR(8192),
    patient_id       INTEGER,
    dentist_id       INTEGER
);