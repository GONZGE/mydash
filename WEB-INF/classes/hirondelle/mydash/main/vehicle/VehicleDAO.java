
package hirondelle.mydash.main.vehicle;

import java.util.*;
import hirondelle.web4j.database.DAOException;
import hirondelle.web4j.database.Db;
import hirondelle.web4j.model.Id;
import hirondelle.web4j.util.Util;
import static hirondelle.mydash.main.vehicle.VehicleAction.LIST_VEHICLES;
import static hirondelle.mydash.main.vehicle.VehicleAction.FETCH_VEHICLE;
import static hirondelle.mydash.main.vehicle.VehicleAction.ADD_VEHICLE;
import static hirondelle.mydash.main.vehicle.VehicleAction.CHANGE_VEHICLE;
import static hirondelle.mydash.main.vehicle.VehicleAction.DELETE_VEHICLE;

/**
 *
 * @author Eric
 */
public class VehicleDAO {
     List<Vehicle> list() throws DAOException {
     return Db.list(Vehicle.class, LIST_VEHICLES);    
  }
  
  Vehicle fetch(Id aId) throws DAOException {
    return Db.fetch(Vehicle.class, FETCH_VEHICLE, aId);
  }
  
  void add(Vehicle aVehicle) throws DAOException {
    Db.add(ADD_VEHICLE, baseParamsFrom(aVehicle));
  }
  
  boolean change(Vehicle aVehicle) throws DAOException {
    Object[] params = Db.addIdTo(baseParamsFrom(aVehicle), aVehicle.getId()); 
    return Util.isSuccess(Db.edit(CHANGE_VEHICLE, params));    
  }
  
  void delete(Id aId) throws DAOException {
    Db.delete(DELETE_VEHICLE, aId);
  }

  // PRIVATE 
  
  private Object[] baseParamsFrom(Vehicle aVehicle){
    return new Object[]{ 
        aVehicle.getVehicleName(),aVehicle.getVehicleMake(), aVehicle.getVehicleModel(),aVehicle.getVehicleYear(),aVehicle.getMileage()
    };
  }
}
