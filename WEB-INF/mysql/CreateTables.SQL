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
# This is a code table.
CREATE TABLE mileage (  
  id MEDIUMINT UNSIGNED NOT NULL AUTO_INCREMENT,
  entry_date DATE NOT NULL,
  mileage INT NOT NULL,
  PRIMARY KEY (id)
) Engine=InnoDB;
