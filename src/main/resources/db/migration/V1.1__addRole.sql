CREATE TABLE role(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    family_doctor_id BIGINT REFERENCES family_doctor (id)
);