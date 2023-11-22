package baseNoStates.states;

import baseNoStates.Door;

public abstract class State {
  /*
   * The State class represents different states of a door.
   * It is part of the State design pattern, providing a common interface for concrete
   * state classes (e.g., Lock, Unlock, UnlockShortly) to follow. Each concrete state
   * encapsulates the behavior associated with a specific state of the door.
   */

  protected Door door;

  public State(Door door) {
    this.door = door;
  }


  public void lock() {
  }

  public void unlock() {
  }

  public void unlockShortly() {
  }

  public void open() {
  }

  public void close() {
  }

  public abstract String getName();
}
