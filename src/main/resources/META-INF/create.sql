create table users2(email varchar(50)  PRIMARY KEY);

CREATE TABLE shop_list(id SERIAL PRIMARY KEY,name VARCHAR(24) NOT NULL, crossed BOOLEAN NOT NULL );
CREATE TABLE recipe_list(id SERIAL PRIMARY KEY,name VARCHAR(24) NOT NULL, crossed BOOLEAN NOT NULL );
CREATE TABLE recipe (id SERIAL PRIMARY KEY, name VARCHAR(24) NOT NULL, crossed BOOLEAN NOT NULL, description VARCHAR(500), list_id INTEGER references recipe_list);
CREATE TABLE item (id SERIAL PRIMARY KEY, name VARCHAR(24) NOT NULL, crossed BOOLEAN NOT NULL, description VARCHAR(500), list_id INTEGER references shop_list);