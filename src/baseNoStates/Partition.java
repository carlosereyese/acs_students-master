package baseNoStates;

import java.util.ArrayList;

public class Partition extends Area {
  /*  Tipo de area que contiene una arbol de areas.  */
  private final ArrayList<Area> areas;

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
