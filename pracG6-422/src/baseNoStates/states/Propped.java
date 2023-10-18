package baseNoStates.states;

import baseNoStates.Actions;
import baseNoStates.Door;

import java.util.Observable;

public class Propped extends State {
  public Propped(Door d){
    super(d);
  }
  public void lock() {
    System.out.println("Cant lock propped door.");
  }
  public void unlock() {
    System.out.println("Cant unlock propped door.");
  }
  public void unlockShortly() { System.out.println("Cant unlock shortly propped door."); }
  public void open() {
    System.out.println("Cant open propped door.");
  }
  public void close() {
    door.setClosed(true);
    door.setStateDoor(new Lock(door));
  }
  public String getName() {return Actions.PROPPED;}
  @Override
  public void update(Observable o, Object arg) {

  }
}