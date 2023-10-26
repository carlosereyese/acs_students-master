package baseNoStates;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class User {

  /*Esta clase tiene el metodo canAcces el cual comprueva que el usuario pueda acceder a esa area en ese schedule en esa date
  * y si tiene permiso para hacer esa action.*/
  private final String name;
  private final String credential;
  private Group group;

  public User(String name, String credential, Group group) {
    this.name = name;
    this.credential = credential;
    this.group = group;
  }

  public String getCredential() {
    return credential;
  }

  public boolean canAccess(String areaId, LocalDateTime dateTime, String action){
    return group.canAccessArea(areaId) && group.isAllowedAtTime(dateTime) && group.isAllowedToDoAction(action);
  }

  @Override
  public String toString() {
    return "User{name=" + name + ", credential=" + credential + "}";
  }
}
