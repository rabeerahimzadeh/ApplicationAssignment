CREATE TABLE IF NOT EXISTS appassignment.company (
  id_company INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NULL,
  address VARCHAR(45) NULL,
  city VARCHAR(45) NULL,
  country VARCHAR(45) NULL,
  email VARCHAR(45) NULL,
  phone_number VARCHAR(45) NULL,
  PRIMARY KEY (id_company));
  
  

CREATE TABLE IF NOT EXISTS appassignment.employee(
  id_employee INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(45) NULL,
  last_name VARCHAR(45) NULL,
  PRIMARY KEY (id_employee)
  );
  
  
CREATE TABLE IF NOT EXISTS appassignment.owner (
  id_owner INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(45) NULL,
  last_name VARCHAR(45) NULL,
  id_company INT NULL,
  PRIMARY KEY (id_owner));
  


CREATE TABLE IF NOT EXISTS appassignment.employee_company (
  id INT NOT NULL AUTO_INCREMENT,
  id_employee INT NOT NULL,
  id_company INT NOT NULL,
    PRIMARY KEY (id));




CREATE TABLE IF NOT EXISTS appassignment.owner_company (
  id INT NOT NULL AUTO_INCREMENT,
  id_owner INT NOT NULL ,
  id_company INT NULL,
  PRIMARY KEY (id)
  );