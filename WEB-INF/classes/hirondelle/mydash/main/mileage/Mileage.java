package hirondelle.mydash.main.mileage;

import static hirondelle.web4j.model.Decimal.ZERO;
import static hirondelle.web4j.util.Consts.FAILS;
import hirondelle.web4j.model.Check;
import hirondelle.web4j.model.Code;
import hirondelle.web4j.model.DateTime;
import hirondelle.web4j.model.Decimal;
import hirondelle.web4j.model.Id;
import hirondelle.web4j.model.ModelCtorException;
import hirondelle.web4j.model.ModelUtil;
import hirondelle.web4j.security.SafeText;
import hirondelle.web4j.util.Util;

public final class Mileage {

  

  /**
  * Constructor.
  * 
  * @param aMileage required, unsigned integer
  */

  public Mileage(Id aId, DateTime aEntryDate, int aMileage) throws ModelCtorException {
    fId = aId;
    fEntryDate = aEntryDate;
    fMileage = aMileage;
    validateState();
  }

  public Id getId() { return fId; }
  public DateTime getEntryDate() {  return fEntryDate; }
  public int getMileage() { return fMileage;  }
  

  @Override public String toString(){
    return ModelUtil.toStringFor(this);
  }
  
  @Override public boolean equals(Object aThat){
    Boolean result = ModelUtil.quickEquals(this, aThat);
    if ( result ==  null ) {
      Mileage that = (Mileage) aThat;
      result = ModelUtil.equalsFor(this.getSignificantFields(), that.getSignificantFields());
    }
    return result;
  }
  
  @Override public int hashCode(){
    return ModelUtil.hashCodeFor(getSignificantFields());
  }
  
  // PRIVATE 
  private final Id fId;
  private final DateTime fEntryDate;
  private final int fMileage;

  private void validateState() throws ModelCtorException {
    ModelCtorException ex = new ModelCtorException();
    if ( ex.isNotEmpty() )  {
      throw ex;
    }
  }
  
  private Object[] getSignificantFields(){
    return new Object[] {fMileage};
  }
}
