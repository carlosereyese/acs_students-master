package baseNoStates;

import java.util.ArrayList;

public abstract class Area {

  private String id;

  public Area(String id) {
    this.id = id;
  }

  public String getId() {
    return this.id;
  }
  public void setId(String id){
    this.id = id;
  }

  public abstract ArrayList<Door> getDoorsGivingAccess();

  public abstract Area findAreaById(String id);
}
