package baseNoStates;

import java.util.ArrayList;

public class Partition extends Area {

  private ArrayList<Area> areas;

  public Partition(ArrayList<Area> areas, String id) {
    super(id);
    this.areas = areas;
  }

  public ArrayList<Door> getDoorsGivingAccess() {
    ArrayList<Door> doorsAreas = new ArrayList<Door>();
    for (Area i : areas){
     doorsAreas.addAll(i.getDoorsGivingAccess());
    return doorsAreas;
    }
    return null;
  }

  public Area findAreaById(String id) {
    if (this.getId().equals(id)) {
      return this;
    }
    else{
      for (Area area : areas){
        Area res = area.findAreaById(id);
        if(res != null){
          return res;
        }
      }
    }
    System.out.println("area with id " + id + " not found");
    return null; // otherwise we get a Java error
  }


}
