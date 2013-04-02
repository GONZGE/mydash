
package hirondelle.mydash.main.vehicle;

import hirondelle.web4j.action.ActionTemplateListAndEdit;
import hirondelle.web4j.action.ResponsePage;
import hirondelle.web4j.database.DAOException;
import hirondelle.web4j.database.SqlId;
import hirondelle.web4j.model.ModelCtorException;
import hirondelle.web4j.model.ModelFromRequest;
import hirondelle.web4j.request.RequestParameter;
import hirondelle.web4j.request.RequestParser;
import hirondelle.web4j.util.Util;

import java.util.logging.Logger;

public final class VehicleAction extends ActionTemplateListAndEdit {
  
  public VehicleAction(RequestParser aRequestParser){
    super(FORWARD, REDIRECT, aRequestParser);
  }
  
  public static final SqlId LIST_VEHICLES = new SqlId("LIST_VEHICLES");
  public static final SqlId FETCH_VEHICLE = new SqlId("FETCH_VEHICLE");  
  public static final SqlId ADD_VEHICLE = new SqlId("ADD_VEHICLE");   
  public static final SqlId CHANGE_VEHICLE = new SqlId("CHANGE_VEHICLE");  
  public static final SqlId DELETE_VEHICLE = new SqlId("DELETE_VEHICLE");   

  public static final RequestParameter ID = RequestParameter.withLengthCheck("Id");
  public static final RequestParameter VEHICLE_NAME = RequestParameter.withLengthCheck("VehicleName");
  public static final RequestParameter VEHICLE_MAKE = RequestParameter.withLengthCheck("VehicleMake");
  public static final RequestParameter VEHICLE_MODEL = RequestParameter.withLengthCheck("VehicleModel");
  public static final RequestParameter VEHICLE_YEAR = RequestParameter.withRegexCheck("VehicleYear", "(\\d)+");
  public static final RequestParameter MILEAGE = RequestParameter.withRegexCheck("Mileage", "(\\d)+");
  
    @Override protected void doList() throws DAOException {
    fLogger.fine("Listing all Vehicles.");
    addToRequest(ITEMS_FOR_LISTING, fDAO.list());
  }  
  
      @Override protected void validateUserInput() {
    fLogger.fine("Validating user input.");
    ModelFromRequest builder = new ModelFromRequest(getRequestParser());
    try {
      fModel = builder.build(Vehicle.class, ID, VEHICLE_NAME, VEHICLE_MAKE, VEHICLE_MODEL, VEHICLE_YEAR, MILEAGE);
    }
    catch (ModelCtorException ex){
      addError(ex);
    }
  }
    
        @Override protected void attemptAdd() throws DAOException {
    fLogger.fine("Attempting to add new vehicle.");
    fDAO.add(fModel);
    addMessage("Item added successfully.");
  }
        
  @Override protected void attemptFetchForChange() throws DAOException {
    fLogger.fine("Attempting to fetch an existing Vehicle.");
    Vehicle model = fDAO.fetch(getIdParam(ID));
    if( model == null ){
      addError("Vehicle no longer exists. Likely deleted by another user.");
    }
    else {
      addToRequest(ITEM_FOR_EDIT, model);
    }    
  }
    
  @Override protected void attemptChange() throws DAOException {
    fLogger.fine("Attempting to change an existing Vehicle.");
    boolean success = fDAO.change(fModel);
    if (success){
      addMessage("Item changed successfully.");
    }
    else {
      addError("No update occurred. Item likely deleted by another user.");
    }
  }
    @Override  protected void attemptDelete() throws DAOException {
    fLogger.fine("Attempting to delete an existing Vehicle item.");
    fDAO.delete(getIdParam(ID));
    addMessage("Item deleted successfully.");    
  }
    
   // PRIVATE 
  private static final ResponsePage FORWARD = new ResponsePage("Vehicle", "view.jsp", VehicleAction.class);
  private static final ResponsePage REDIRECT = new ResponsePage("VehicleAction.list");
  private VehicleDAO fDAO = new VehicleDAO();
  private Vehicle fModel;
  private static final Logger fLogger = Util.getLogger(VehicleAction.class);
}