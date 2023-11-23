package baseNoStates;

import java.util.ArrayList;

public class Partition extends Area {
  /*
   *  It is part of the Composite design pattern.
   */
  private final ArrayList<Area> areas;

  public Partition(ArrayList<Area> areas, String id) {
    super(id);
    this.areas = areas;
  }

  public ArrayList<Area> getAreas() {
    return areas;
  }

  public void acceptVisitor(Visitor v) {
    v.visitPartition(this);
  }

}
