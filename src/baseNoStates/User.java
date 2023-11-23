package baseNoStates;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class User {

  private final String name;
  private final String credential;
  private final Group group;

  public User(String name, String credential, Group group) {
    this.name = name;
    this.credential = credential;
    this.group = group;
  }

  public String getCredential() {
    return credential;
  }

  public boolean canAccess(String areaId, LocalDateTime dateTime, String action) {
    return group.canAccessArea(areaId) && group.isAllowedAtTime(dateTime)
        && group.isAllowedToDoAction(action);
  }

  public Group getGroup() {
    return group;
  }

  @Override
  public String toString() {
    return "User{name=" + name + ", credential=" + credential + "}";
  }
}
