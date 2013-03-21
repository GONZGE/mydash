package hirondelle.web4j.config;

import hirondelle.web4j.ApplicationInfo;
import hirondelle.web4j.util.Consts;
import hirondelle.web4j.model.DateTime;


public class AppInfo implements ApplicationInfo {
  
  public String getAuthor() {
    return "Foobar";
  }
  
  public DateTime getBuildDate() {
    return new DateTime("2012-06-09 13:13:48");
  }
  
  public String getLink() {
    return "http://www.web4j.com/";
  }
  
  public String getMessage() {
    return "Minimal Java Web Application, built with WEB4J.";
  }

  public String getName() {
    return "MyDash";
  }
  
  public String getVersion() {
    return "0.1";
  }
  
  /** Return {@link #getName()} + {@link #getVersion()}.  */
  @Override public String toString(){
    return getName() + Consts.SPACE + getVersion();
  }
}
