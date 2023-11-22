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

  public ArrayList<Area> getAreas() {
    return areas;
  }

  public void acceptVisitor(Visitor v){
    v.visitPartition(this);
  }

}
