package baseNoStates;

import java.util.ArrayList;

public class GetDoorsGivingAccessVisitor implements Visitor {
  /*
   * The GetDoorsGivingAccessVisitor class is a specific visitor
   * that handles the getDoorsGivingAccess functionality for each type of area.
   * It is part of the Visitor design pattern.
   */
  private ArrayList<Door> doors;

  public GetDoorsGivingAccessVisitor() {
    this.doors = new ArrayList<Door>();
  }

  public void visitPartition(Partition partition) {
    for (Area a : partition.getAreas()) {
      a.acceptVisitor(this);
    }
  }

  public void visitSpace(Space space) {
    doors.addAll(space.getDoors());
  }

  public Area getArea() {
    return null;
  }

  public ArrayList<Door> getDoors() {
    return doors;
  }
}
