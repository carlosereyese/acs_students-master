package baseNoStates;

import java.util.ArrayList;

public class FindAreaByIdVisitor implements Visitor {

  private String id;

  private Area area;

  public FindAreaByIdVisitor(String id) {
    this.id = id;
    this.area = null;
  }

  @Override
  public void visitPartition(Partition partition) {
    if (partition.getId().equals(id)) {
      this.area = partition;
    } else {
      for (Area area : partition.getAreas()) {
        area.acceptVisitor(this);
        if(this.getArea() != null)
          break;
      }
      int i = 0;
    }
  }

  @Override
  public void visitSpace(Space space) {
    if (space.getId().equals(id)) {
      area = space;
    }
  }

  public Area getArea() {
    return area;
  }

  public ArrayList<Door> getDoors() {
    return null;
  }
}
