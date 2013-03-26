# This is a MySQL script.
# It creates a database named 'mydash', and adds tables to it.
# It has been verified against MySQL version 5.5.8.
#
# If you prefer to use a different database other than MySQL, then porting this script should be simple.
#
# Example of running this script using the mysql client :
# [this directory]>C:\mysql\bin\mysql --local-infile=1 -u myname -pmypass < CreateTables.SQL
#
create database mydash CHARACTER SET = utf8;
use mydash;

CREATE TABLE Users (  
  Id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  LoginName VARCHAR(50)  UNIQUE NOT NULL, 
  ScreenName VARCHAR(50), /* Binary needed to ensure case sensitive. */
  Password VARCHAR(50) BINARY NOT NULL, /* Binary needed to ensure case sensitive. Must hash the password. */
  Email VARCHAR(100) UNIQUE NOT NULL,  /* Used only for password reset. */
  FormSourceId VARCHAR(100) BINARY,   /* Defends against CSRF attacks. */
  PasswordNonce VARCHAR(40),   /* Used only when user loses their password. */
  PasswordNonceCreatedOn DATETIME,  
  PRIMARY KEY (Id)
) Engine=InnoDB;

# Populate tables with some base data.
# *** WARNING *** : this data is for development only, and must be DELETED from production environments.
# The password is in hashed form, and has the cleartext value 'testtest'. 
INSERT INTO Users (Id, LoginName, Password, ScreenName, Email) VALUES(1, 'testeD', '51abb9636078defbf888d8457a7c76f85c8f114c', 'Teste D', 'blah4@blah.com');

# In the style demanded by Tomcat (not a normalized form).
# Tomcat has the weird constraint that the column names must match between UserRole.Name and Users.Name.
CREATE TABLE UserRole (  
  LoginName VARCHAR(50) NOT NULL, 
  Role VARCHAR(50) NOT NULL Default 'user',  /*default to the user role for safety */
  INDEX (LoginName),
  FOREIGN KEY (LoginName) REFERENCES Users(LoginName),
  PRIMARY KEY (LoginName, Role)
) Engine=InnoDB;
INSERT INTO UserRole (LoginName, Role) VALUES('testeD', 'user');

CREATE TABLE mileage (  
  id MEDIUMINT UNSIGNED NOT NULL AUTO_INCREMENT,
  entry_date DATE NOT NULL,
  mileage INT NOT NULL,
  PRIMARY KEY (id)
) Engine=InnoDB;
