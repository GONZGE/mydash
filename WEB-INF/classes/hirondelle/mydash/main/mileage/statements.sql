LIST_MILEAGE {
 SELECT id, entry_date, mileage
 FROM mileage
 ORDER BY entry_date DESC
LIMIT 10
}

ADD_MILEAGE  {
  -- Id is an autoincrement field, populated automagically by the database.
 INSERT INTO mileage (entry_date, mileage) VALUES (curdate(),?)
ON DUPLICATE KEY UPDATE id=LAST_INSERT_ID(id), mileage = ?
}

