-- liquibase formatted sql

-- changeset pbal:202303281113
CREATE  TABLE countries ( 
	id                   integer  NOT NULL GENERATED ALWAYS AS IDENTITY  ,
	name                 varchar(100)  NOT NULL  ,
	CONSTRAINT pk_countries PRIMARY KEY ( id )
 );

CREATE  TABLE users ( 
	id                   bigint  NOT NULL GENERATED ALWAYS AS IDENTITY  ,
	first_name           varchar(100)    ,
	last_name            varchar(100)    ,
	active               boolean  NOT NULL  ,
	email                varchar    ,
	password             varchar(100)    ,
	"role"               varchar(64)  NOT NULL  ,
	CONSTRAINT pk_users PRIMARY KEY ( id )
 );

CREATE  TABLE vendors ( 
	id                   integer  NOT NULL GENERATED ALWAYS AS IDENTITY  ,
	name                 varchar(100)  NOT NULL  ,
	CONSTRAINT pk_vendors PRIMARY KEY ( id )
 );

CREATE  TABLE cities ( 
	id                   integer  NOT NULL GENERATED ALWAYS AS IDENTITY  ,
	name                 varchar(100)  NOT NULL  ,
	country_id           integer  NOT NULL  ,
	CONSTRAINT pk_cities PRIMARY KEY ( id ),
	CONSTRAINT fk_cities_countries FOREIGN KEY ( country_id ) REFERENCES countries( id )   
 );

CREATE  TABLE parking_stations ( 
	id                   integer  NOT NULL GENERATED ALWAYS AS IDENTITY  ,
	address              varchar(100)  NOT NULL  ,
	slots_number         integer  NOT NULL  ,
	free_slots_number    integer  NOT NULL  ,
	city_id              integer    ,
	CONSTRAINT pk_parking_stations PRIMARY KEY ( id ),
	CONSTRAINT fk_parking_stations_cities FOREIGN KEY ( city_id ) REFERENCES cities( id )   
 );

CREATE  TABLE scooter_models ( 
	id                   integer  NOT NULL GENERATED ALWAYS AS IDENTITY  ,
	name                varchar(100)  NOT NULL  ,
	vendor_id            integer  NOT NULL  ,
	CONSTRAINT pk_scooter_models PRIMARY KEY ( id ),
	CONSTRAINT fk_scooter_models_vendors FOREIGN KEY ( vendor_id ) REFERENCES vendors( id )   
 );

CREATE  TABLE scooters ( 
	id                   integer  NOT NULL GENERATED ALWAYS AS IDENTITY  ,
	serial_number        varchar(100)  NOT NULL  ,
	status               varchar(16)  NOT NULL  ,
	charge_percentage    integer  NOT NULL  ,
	model_id             integer  NOT NULL  ,
	CONSTRAINT pk_scooters PRIMARY KEY ( id ),
	CONSTRAINT fk_scooters_scooter_models FOREIGN KEY ( model_id ) REFERENCES scooter_models( id )   
 );

CREATE  TABLE rental_sessions ( 
	id                   bigint  NOT NULL GENERATED ALWAYS AS IDENTITY  ,
	user_id              bigint  NOT NULL  ,
	scooter_id           integer  NOT NULL  ,
	begin_time           timestamp  NOT NULL  ,
	end_time             timestamp    ,
	begin_station_id     integer  NOT NULL  ,
	end_station_id       integer    ,
	CONSTRAINT pk_rental_sessions PRIMARY KEY ( id ),
	CONSTRAINT fk_rental_sessions_users FOREIGN KEY ( user_id ) REFERENCES users( id )   ,
	CONSTRAINT fk_rental_sessions_scooters FOREIGN KEY ( scooter_id ) REFERENCES scooters( id )   ,
	CONSTRAINT fk_rental_sessions_parking_stations FOREIGN KEY ( begin_station_id ) REFERENCES parking_stations( id )   ,
	CONSTRAINT fk_rental_sessions_parking_stations_0 FOREIGN KEY ( end_station_id ) REFERENCES parking_stations( id )   
 );

--changeset pbal:202303281149
INSERT INTO public.vendors (name) VALUES ('Samokat.RU');
INSERT INTO public.vendors (name) VALUES ('Samokatka.by');

INSERT INTO public.countries (name) VALUES ('Belarus');
INSERT INTO public.countries (name) VALUES ('Russia');

INSERT INTO public.cities (name, country_id) VALUES ('Gomel', 1);
INSERT INTO public.cities (name, country_id) VALUES ('Vitebsk', 1);
INSERT INTO public.cities (name, country_id) VALUES ('Moscow', 2);
INSERT INTO public.cities (name, country_id) VALUES ('Petersburg', 2);
