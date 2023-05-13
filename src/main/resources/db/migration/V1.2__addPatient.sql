CREATE TABLE patient(
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR NOT NULL,
    last_name VARCHAR NOT NULL,
    email VARCHAR,
    phone VARCHAR NOT NULL,
    family_doctor_id BIGINT REFERENCES family_doctor (id)
);

CREATE TABLE patient_card(
    id BIGSERIAL PRIMARY KEY,
    date_creation date,
    birth date not null,
    allergies varchar not null,
    patient_id BIGINT REFERENCES patient (id) UNIQUE
);