package hirondelle.mydash.main.mileage;

import java.util.*;
import hirondelle.web4j.database.DAOException;
import hirondelle.web4j.database.Db;
import hirondelle.web4j.model.Id;
import hirondelle.web4j.util.Util;
import static hirondelle.mydash.main.mileage.MileageAction.LIST_MILEAGE;
import static hirondelle.mydash.main.mileage.MileageAction.ADD_MILEAGE;

final class MileageDAO {
  
  List<Mileage> list() throws DAOException {
     return Db.list(Mileage.class, LIST_MILEAGE);    
  }
  
  void add(Mileage aMileage) throws DAOException {
    Db.add(ADD_MILEAGE, baseParamsFrom(aMileage));
  }
  
  // PRIVATE 
  
  private Object[] baseParamsFrom(Mileage aMileage){
    return new Object[]{ 
      aMileage.getMileage()
    };
  }
}
