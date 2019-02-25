CREATE TABLE registeration
(
id int CONSTRAINT pk_registeration_id primary key,
username VARCHAR2(25) not null,
email VARCHAR2(30) not null,
password VARCHAR2(15) not null,
phone_number number(10) not null,
dateofbirth date,
created_date timestamp);


CREATE SEQUENCE registeration_id_seq
START WITH 1
INCREMENT BY 1;

SELECT * FROM registeration;


CREATE TABLE product
(
id NUMBER(10) CONSTRAINT pk_product_id primary key ,
category_id NUMBER(10) CONSTRAINT rk_category_id REFERENCES category(id),
product VARCHAR2(15) not null,
description VARCHAR2(70),
quantity NUMBER(3),
price NUMBER(6) not null,
expired_date date,
created_date timestamp,
status VARCHAR2(10));

CREATE SEQUENCE product_id_seq
START WITH 1
INCREMENT BY 1;

CREATE TABLE category
(id NUMBER(10) CONSTRAINT pk_category_id PRIMARY KEY,
name VARCHAR2(20) not null);

CREATE SEQUENCE category_id_seq 
START WITH 1
INCREMENT BY 1;



CREATE TABLE orders
(
id INT  CONSTRAINT pk_order_id PRIMARY KEY,
product_id INT  CONSTRAINT rk_product_id REFERENCES product(id) , 
quantity NUMBER(3),
order_no NUMBER(3),
ordered_date date,
registered_id INT CONSTRAINT rk_registeration_id REFERENCES registeration(id));

CREATE SEQUENCE orders_order_no_seq
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE orders_id_seq
START WITH 1
INCREMENT BY 1;

select * from registeration;
select * from product;
select * from orders;
select * from category;