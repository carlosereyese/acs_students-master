package baseNoStates;

import java.util.ArrayList;

public class Space extends Area {
  /*
   *  It is the leaf part of the Composite design pattern.
   */

  private final ArrayList<Door> doors;

  public Space(ArrayList<Door> doors, String id) {
    super(id);
    this.doors = doors;
  }

  public void acceptVisitor(Visitor v) {
    v.visitSpace(this);
  }

  public ArrayList<Door> getDoors() {
    return doors;
  }
}
