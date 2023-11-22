package baseNoStates;

import java.util.ArrayList;

public interface Visitor {
  void visitPartition(Partition partition);
  void visitSpace(Space space);
  Area getArea();
  ArrayList<Door> getDoors();

}
