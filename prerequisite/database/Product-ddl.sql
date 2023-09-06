CREATE TABLE Product (
     id SERIAL PRIMARY KEY,
     code VARCHAR(10) UNIQUE NOT NULL,
     name VARCHAR(255) NOT NULL,
     price_eur NUMERIC CHECK (price_eur >= 0) NOT NULL,
     price_usd NUMERIC CHECK (price_usd >= 0) NOT NULL,
     description TEXT,
     is_available BOOLEAN NOT NULL
);