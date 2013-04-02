package hirondelle.mydash.main.vehicle;

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

public final class Vehicle {

    /**
     * Constructor.
     *
     * @param aVehicleName required, text
     * @param aVehicleMake required, text
     * @param aVehicleModel required, text
     * @param aVehicleYear required, Decimal (YYYY)
     * @param aMileage required, Decimal
     */
    public Vehicle(Id aId, SafeText aVehicleName, SafeText aVehicleMake, SafeText aVehicleModel, Decimal aVehicleYear, Decimal aMileage) throws ModelCtorException {
        fId = aId;
        fVehicleName = aVehicleName;
        fVehicleMake = aVehicleMake;
        fVehicleModel = aVehicleModel;
        fVehicleYear = aVehicleYear;
        fMileage = aMileage;
        validateState();
    }

    public Id getId() {
        return fId;
    }

    public SafeText getVehicleName() {
        return fVehicleName;
    }

    public SafeText getVehicleMake() {
        return fVehicleMake;
    }

    public SafeText getVehicleModel() {
        return fVehicleModel;
    }

    public Decimal getVehicleYear() {
        return fVehicleYear;
    }

    public Decimal getMileage() {
        return fMileage;
    }

    @Override
    public String toString() {
        return ModelUtil.toStringFor(this);
    }

    @Override
    public boolean equals(Object aThat) {
        Boolean result = ModelUtil.quickEquals(this, aThat);
        if (result == null) {
            Vehicle that = (Vehicle) aThat;
            result = ModelUtil.equalsFor(this.getSignificantFields(), that.getSignificantFields());
        }
        return result;
    }

    @Override
    public int hashCode() {
        return ModelUtil.hashCodeFor(getSignificantFields());
    }
    // PRIVATE 
    private final Id fId;
    private final SafeText fVehicleName;
    private final SafeText fVehicleMake;
    private final SafeText fVehicleModel;
    private final Decimal fVehicleYear;
    private final Decimal fMileage;
    /* Constants used in validation:  */
    private static final Decimal MIN_YEAR = Decimal.from("1900");
    private static final Decimal MAX_YEAR = Decimal.from("2100");
    private static final Decimal MAX_MILES = Decimal.from("500000");

    private void validateState() throws ModelCtorException {
        ModelCtorException ex = new ModelCtorException();

        if (FAILS == Check.required(fVehicleName, Check.range(0, 32))) {
            ex.add("Name cannot be longer than 32 characters.");
        }
        if (FAILS == Check.required(fVehicleMake, Check.range(0, 32))) {
            ex.add("Make cannot be longer than 32 characters.");
        }
        if (FAILS == Check.required(fVehicleModel, Check.range(0, 32))) {
            ex.add("MOdel cannot be longer than 32 characters.");
        }
        if (FAILS == Check.required(fVehicleYear, Check.range(MIN_YEAR, MAX_YEAR), Check.numDecimalsAlways(0))) {
            ex.add("Year must be between 1900 and 2100.  YYYY Format");
        }
        if (FAILS == Check.required(fMileage, Check.range(ZERO, MAX_MILES), Check.numDecimalsAlways(0))) {
            ex.add("Mileage in range of 0..500,000 (no decimal)");
        }
        if (ex.isNotEmpty()) {
            throw ex;
        }
    }

    private Object[] getSignificantFields() {
        return new Object[]{fVehicleName, fVehicleMake, fVehicleModel, fVehicleYear, fMileage};
    }
}
