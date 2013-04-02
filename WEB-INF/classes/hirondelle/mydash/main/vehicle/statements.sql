LIST_VEHICLES {
SELECT vehicle_id, vehicle_name, make, model, year, mileage
FROM vehicle
ORDER BY  vehicle_id
}

FETCH_VEHICLE {
SELECT vehicle_id, vehicle_name, make, model, year, mileage
FROM vehicle
WHERE vehicle_id = ?
}

ADD_VEHICLE {
INSERT INTO vehicle (vehicle_name, make, model, year, mileage) 
VALUES (?, ?, ?, ?, ?)
}

CHANGE_VEHICLE {
UPDATE vehicle SET vehicle_name=?, make=?, model=?, year=?, mileage=?
WHERE vehicle_id = ?
}


DELETE_VEHICLE {
DELETE FROM vehicle WHERE vehicle_id = ?
}

