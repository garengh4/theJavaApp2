
DROP DATABASE if exists EKART;
CREATE DATABASE EKART;
USE EKART;


CREATE TABLE EK_CUSTOMER(
	EMAIL_ID VARCHAR(50),
	PASSWORD VARCHAR(70) NOT NULL,
	constraint EK_CUSTOMER_EMAIL_ID_PK primary key ( EMAIL_ID )
);

INSERT INTO EK_CUSTOMER (EMAIL_ID, PASSWORD) VALUES ('tom@infosys.com', 'Tom@123');
INSERT INTO EK_CUSTOMER (EMAIL_ID, PASSWORD) VALUES ('harry@infosys.com', 'Harry@123');
INSERT INTO EK_CUSTOMER (EMAIL_ID, PASSWORD) VALUES ('john@infosys.com', 'John@123');
INSERT INTO EK_CUSTOMER (EMAIL_ID, PASSWORD) VALUES ('sara@infosys.com', 'Sara@123');
INSERT INTO EK_CUSTOMER (EMAIL_ID, PASSWORD) VALUES ('mariya@infosys.com', 'Mariya@123');
INSERT INTO EK_CUSTOMER (EMAIL_ID, PASSWORD) VALUES ('james@infosys.com', 'James@123');
INSERT INTO EK_CUSTOMER (EMAIL_ID, PASSWORD) VALUES ('steve@infosys.com', 'Steve@123');
INSERT INTO EK_CUSTOMER (EMAIL_ID, PASSWORD) VALUES ('punya@infosys.com', 'Punya@123');
INSERT INTO EK_CUSTOMER (EMAIL_ID, PASSWORD) VALUES ('animesh@infosys.com', 'Animesh@123');
INSERT INTO EK_CUSTOMER (EMAIL_ID, PASSWORD) VALUES ('rakesh@infosys.com', 'Rakesh@123');

commit;