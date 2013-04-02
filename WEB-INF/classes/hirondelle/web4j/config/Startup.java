package hirondelle.web4j.config;

import hirondelle.mydash.util.Captcha;
import hirondelle.web4j.StartupTasks;
import hirondelle.web4j.database.DAOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

/** Implementation of {@link StartupTasks}, required by WEB4J.  */
public final class Startup implements StartupTasks {

  /** 
   Perform startup tasks.
   
   This implementation has 2 tasks:
   <ul>
   <li>look up code tables, and place them into application scope.
   <li>pass along a value in web.xml to {@link Captcha#init(String)}.
   </ul>
  */
  public void startApplication(ServletConfig aConfig) throws DAOException {
    fContext = aConfig.getServletContext();
    Captcha.init(aConfig.getInitParameter("CaptchaPrivateKey"));
  }


  // PRIVATE 
  private static ServletContext fContext;
}
