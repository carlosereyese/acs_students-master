package baseNoStates;

import org.json.JSONObject;

import java.util.ArrayList;

public abstract class Area {
  /*
   * The Area class represents the compound of partitions or spaces (child classes)
   *  It is part of the Composite and Visitor design patterns.
   */

  private String id;

  public Area(String id) {
    this.id = id;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void acceptVisitor(Visitor v) {}

  public abstract JSONObject toJson(int depth);
}
