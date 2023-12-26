package baseNoStates;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Space extends Area {
  /*
   *  It is the leaf part of the Composite design pattern.
   */

  private final ArrayList<Door> doors;

  public Space(ArrayList<Door> doors, String id) {
    super(id);
    this.doors = doors;
  }

  public void acceptVisitor(Visitor v) {
    v.visitSpace(this);
  }

  public ArrayList<Door> getDoors() {
    return doors;
  }

  public JSONObject toJson(int depth) { // depth not used here
    JSONObject json = new JSONObject();
    json.put("class", "space");
    json.put("id", getId());
    JSONArray jsonDoors = new JSONArray();
    for (Door d : getDoors()) {
      jsonDoors.put(d.toJson());
    }
    json.put("access_doors", jsonDoors);
    return json;
  }

}
