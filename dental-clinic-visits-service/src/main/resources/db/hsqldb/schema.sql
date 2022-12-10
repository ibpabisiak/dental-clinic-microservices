DROP TABLE visits IF EXISTS;

CREATE TABLE visits (
  id              INTEGER IDENTITY PRIMARY KEY,
  dentist_id      INTEGER NOT NULL,
  patient_id      INTEGER NOT NULL,
  visit_date      DATE,
  description     VARCHAR(8192)
);

CREATE INDEX visits_patient_id ON visits (patient_id);