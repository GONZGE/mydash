package hirondelle.mydash.main.mileage;

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

public final class MileageAction extends ActionTemplateListAndEdit {
  
  public MileageAction(RequestParser aRequestParser){
    super(FORWARD, REDIRECT, aRequestParser);
  }
  
  public static final SqlId LIST_MILEAGE = new SqlId("LIST_MILEAGE");
  public static final SqlId ADD_MILEAGE = new SqlId("ADD_MILEAGE");

  
  public static final RequestParameter ID = RequestParameter.withLengthCheck("Id");
  public static final RequestParameter ENTRY_DATE = RequestParameter.withLengthCheck("EntryDate");
  public static final RequestParameter MILEAGE = RequestParameter.withLengthCheck("Mileage");
  
  @Override protected void doList() throws DAOException {
    fLogger.fine("Listing all mileage entries");
    addToRequest(ITEMS_FOR_LISTING, fDAO.list());
  }
  
  @Override protected void validateUserInput() {
    fLogger.fine("Validating user input.");
    ModelFromRequest builder = new ModelFromRequest(getRequestParser());
    try {
      fModel = builder.build(Mileage.class, ID, ENTRY_DATE, MILEAGE);
    }
    catch (ModelCtorException ex){
      addError(ex);
    }
  }
  
  @Override protected void attemptAdd() throws DAOException {
    fLogger.fine("Attempting to add new Mileage item.");
    fDAO.add(fModel);
    addMessage("Item added successfully.");
  }
  
  
  @Override protected void attemptFetchForChange() throws DAOException {
  }
  
  @Override protected void attemptChange() throws DAOException {
  }
  
  @Override  protected void attemptDelete() throws DAOException {
  }
  
  // PRIVATE 
  private static final ResponsePage FORWARD = new ResponsePage("Mileage", "view.jsp", MileageAction.class);
  private static final ResponsePage REDIRECT = new ResponsePage("MileageAction.list");
  private MileageDAO fDAO = new MileageDAO();
  private Mileage fModel;
  private static final Logger fLogger = Util.getLogger(MileageAction.class);
}
