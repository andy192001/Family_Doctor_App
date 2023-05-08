CREATE TABLE family_doctor(
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR NOT NULL,
    last_name VARCHAR NOT NULL,
    email VARCHAR,
    phone VARCHAR NOT NULL,
    address VARCHAR NOT NULL,
    password VARCHAR NOT NULL
);