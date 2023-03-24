CREATE TYPE status AS ENUM ( 'INACTIVE', 'ENGAGED' , 'FREE' , 'BOOKED'  );

CREATE  TABLE vendors ( 
	id                   integer  NOT NULL GENERATED ALWAYS AS IDENTITY  ,
	name                 varchar(100)  NOT NULL  ,
	CONSTRAINT pk_vendors PRIMARY KEY ( id )
 );

CREATE  TABLE scooter_models ( 
	id                   integer  NOT NULL GENERATED ALWAYS AS IDENTITY  ,
	model                varchar(100)  NOT NULL  ,
	vendor_id            integer  NOT NULL  ,
	max_speed            real    ,
	CONSTRAINT pk_scooter_models PRIMARY KEY ( id ),
	CONSTRAINT fk_scooter_models_vendors FOREIGN KEY ( vendor_id ) REFERENCES vendors( id )   
 );

CREATE  TABLE scooters ( 
	id                   integer  NOT NULL GENERATED ALWAYS AS IDENTITY  ,
	serial_number        varchar(100)  NOT NULL  ,
	status               status  NOT NULL  ,
	charge_percentage    integer  NOT NULL  ,
	model_id             integer  NOT NULL  ,
	CONSTRAINT pk_scooters PRIMARY KEY ( id ),
	CONSTRAINT fk_scooters_scooter_models FOREIGN KEY ( model_id ) REFERENCES scooter_models( id )   
 );
