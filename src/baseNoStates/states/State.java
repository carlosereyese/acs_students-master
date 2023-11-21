package baseNoStates.states;

import baseNoStates.Door;
import java.util.Observable;
import java.util.Observer;

public abstract class State {
  /*  Esta interfaz implementa los patrones State y Observer. A partir de ella derivan diferentes
    estados que redefinen los metodos.  */

  //fALTAN COMENTARIOS Y LOG

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
