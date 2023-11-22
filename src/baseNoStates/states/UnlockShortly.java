package baseNoStates.states;

import baseNoStates.Actions;
import baseNoStates.ClockTimer;
import baseNoStates.Door;
import java.util.Observable;
import java.util.Observer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UnlockShortly extends State implements Observer {
  /*  Aplica toda la logica de los cambios de estados cuando la puerta esta desbloqueada brevemente.
      Aplica el patron Observer con la clase Observer que implementa State.   */
  private static final Logger logger = LoggerFactory.getLogger(Lock.class);

  public UnlockShortly(Door door, ClockTimer timer) {
    super(door);
    timer.addObserver(this);
    timer.startTimer(); //Comienza un temporizador en el momento que pasa al estado UnlockShortly
  }

  public void lock() {
    logger.debug("Attempting to lock door...");
    logger.info("Unlock Shortly in process please wait.");
  }

  public void unlock() {
    logger.debug("Attempting to unlock door...");
    logger.info("Unlock Shortly in process please wait.");
  }

  public void unlockShortly() {
    logger.debug("Attempting to unlock shortly door...");
    logger.info("Unlock Shortly in process please wait.");
  }

  public void open() {
    logger.debug("Attempting to open door...");
    if (!door.isClosed()) {
      logger.warn("Door is already open");
    } else {
      door.setClosed(false);
      logger.info("Door is opened now");
    }
  }

  public void close() {
    logger.debug("Attempting to close door...");
    if (door.isClosed()) {
      logger.warn("Door is already closed");
    } else {
      door.setClosed(true);
      logger.info("Door is closed now");
    }
  }

  public String getName() {
    return Actions.UNLOCK_SHORTLY;
  }


  /*  Redefinicion del metodo update de la clase Observer. Este metodo se ejecuta en el momento que
      el observable(ClockTimer) ejecuta el metodo notifyObservers();   */
  @Override
  public void update(Observable o, Object arg) {
    if (!door.isClosed()) {
      door.setStateDoor(new Propped(door));
    } else {
      door.setStateDoor(new Lock(door));
    }
  }
}
