package baseNoStates;

import java.util.ArrayList;

public class GetDoorsGivingAccessVisitor implements Visitor {

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
