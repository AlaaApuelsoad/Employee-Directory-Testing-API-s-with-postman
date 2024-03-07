CREATE DATABASE  IF NOT EXISTS demo;
USE demo;
--
-- Table structure for table `qnet_employee`
--
Drop table if exists qnet_employees;

CREATE TABLE qnet_employees(
  id int NOT NULL AUTO_INCREMENT,
  first_name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  age int NOT NULL,
  department varchar(45) Default Null,
  salary int Not Null,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-
-- Data for table `qnet_employee`
--

INSERT INTO qnet_employees VALUES 
	(1,'John','Doe','John@qnet.com',26,'HR',15000),
    (2,'Maryy','Jane','Marry@qnet.com',30,'Engineering',12000),
    (3,'Peter','Kane','Peter@qnet.com',25,'Acoountant',8000),
    (4,'Leslie','Han','Leslie@qnet.com',27,'Customer Service',9000),
    (5,'Bruce','Wayne','Bruce@qnet.com',50,'Legal',13000),
    (6,'Randy','Pau','Randy@qnet.com',27,'HR',15000);
    
    insert into demo.qnet_employees values
    (7,'Josh','Alex','Josh@qnet.com',27,'DBA',11000);
    
    insert into demo.qnet_employees values
    (8,'Max','Payne','Max@qnet.com',37,'Manager',20000);
	
