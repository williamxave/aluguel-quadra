CREATE SEQUENCE IF NOT EXISTS owner_id_seq AS INTEGER START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS owner (
    id INTEGER NOT NULL DEFAULT NEXTVAL('owner_id_seq') PRIMARY KEY,
    external_Id UUID,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(30) NOT NULL,
    create_At TIMESTAMP,
    up_date TIMESTAMP
);


