package baseNoStates;

import java.util.ArrayList;

public interface Visitor {
  /*
   *  It is the interface of the Visitor design pattern.
   */
  void visitPartition(Partition partition);

  void visitSpace(Space space);

  Area getArea();

  ArrayList<Door> getDoors();

}
