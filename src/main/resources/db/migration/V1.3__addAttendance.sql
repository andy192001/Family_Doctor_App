CREATE TABLE attendance(
    id BIGSERIAL PRIMARY KEY,
    date_creation date,
    diagnose varchar,
    symptoms text,
    patient_card_id BIGINT references patient_card (id)
);