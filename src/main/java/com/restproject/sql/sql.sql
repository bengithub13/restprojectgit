CREATE TABLE country (
  country_id   NUMBER NOT NULL ENABLE,
  country      VARCHAR(50) NOT NULL,
  last_update  TIMESTAMP   NOT NULL,
  CONSTRAINT COUNTRY_PK PRIMARY KEY  (country_id)
);

create sequence country_seq;


create table owner(
owner_id  Number not null,
first_name varchar(20),
last_name varchar(20),
constraint owner_pk primary key(owner_id)
);

create table owner_address(
owner_id number not null,
address_id number not null,
constraint owner_address_pk primary key(owner_id,address_id),
constraint owner_fk foreign key(owner_id) references owner,
constraint address_fk foreign key(address_id) references address
);


  CREATE OR REPLACE FORCE VIEW "OWNER_ADDRESS_VIEW" ("OWNER_ID", "First Name", "Last Name", "Address ID","Street","zipcode","country") AS
  select oa.owner_fk,o.first_name,o.last_name,oa.address_fk,a.street,a.zip_code,c.country from
  owner_address oa,owner o, address a where oa.owner_fk=owner_id and oa.address_fk=a.address_id and a.country_fk=c.country_id;
  
CREATE OR REPLACE FORCE VIEW "OWNER_ADDRESS_VIEW" ("OWNER_ID", "First Name", "Last Name", "Address ID","Street","zipcode","country") AS
  select oa.owner_fk,o.first_name,o.last_name,oa.address_fk,a.street,a.zip_code,c.country from
  owner_address oa,owner o, address a, country c where oa.owner_fk=owner_id and oa.address_fk=a.address_id and a.country_fk=c.country_id;
