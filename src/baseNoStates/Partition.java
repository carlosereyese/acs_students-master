package baseNoStates;

import baseNoStates.states.Lock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;

public class Partition extends Area {
  /*  Tipo de area que contiene una arbol de areas.  */
  private final ArrayList<Area> areas;
  private static final Logger logger = LoggerFactory.getLogger(Lock.class);

  public Partition(ArrayList<Area> areas, String id) {
    super(id);
    this.areas = areas;
  }

  public ArrayList<Door> getDoorsGivingAccess() {
    ArrayList<Door> doorsAreas = new ArrayList<Door>();
    for (Area i : areas) {
      doorsAreas.addAll(i.getDoorsGivingAccess());

    }
    return doorsAreas;
  }

  public Area findAreaById(String id) {
    if (this.getId().equals(id)) {
      return this;
    } else {
      for (Area area : areas) {
        Area res = area.findAreaById(id);
        if (res != null) {
          return res;
        }
      }
    }
    logger.info("Area with id " + id + " not found");
    return null; // otherwise we get a Java error
  }


}
