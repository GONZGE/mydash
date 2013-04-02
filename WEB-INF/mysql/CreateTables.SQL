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

CREATE TABLE vehicle(
  vehicle_id 	MEDIUMINT UNSIGNED NOT NULL AUTO_INCREMENT,
  vehicle_name  varchar(50) NOT NULL,
  make          varchar(30) NOT NULL,
  model         varchar(30) NOT NULL,
  year          INT NOT NULL,
  mileage       INT NOT NULL,
 -- LoginName     VARCHAR(50) NOT NULL, 
 -- FOREIGN KEY (LoginName) REFERENCES Users(LoginName),
  PRIMARY KEY (vehicle_id)
) Engine=InnoDB;