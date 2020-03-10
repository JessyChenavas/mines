create table bank (uuid UUID PRIMARY KEY , code text, name text, address text);

create table customer(uuid uuid PRIMARY KEY, first_name text, last_name text, bank_uuid uuid REFERENCES bank(uuid));

create table credit_card(uuid uuid PRIMARY KEY , card_number text, expiration_date date, customer_uuid uuid REFERENCES customer(uuid));

create table transaction (uuid uuid PRIMARY KEY , date date, location text, amount float , credit_card_uuid uuid REFERENCES credit_card(uuid) );

