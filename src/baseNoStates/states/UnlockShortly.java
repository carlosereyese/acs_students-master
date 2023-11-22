package baseNoStates.states;

import baseNoStates.Actions;
import baseNoStates.ClockTimer;
import baseNoStates.Door;
import java.util.Observable;
import java.util.Observer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UnlockShortly extends State implements Observer {
  /*
   * The UnlockShortly class represents the brief unlock state of a door.
   * It is a concrete state class in the State design pattern.
   * Also, it implements the Observer design pattern on the update method because
   * we need to lock the door after a certain time seeing the observable class Timer.
   * The UnlockShortly state is responsible for handling operations
   * related to a brief unlocked door, such as locking, opening, closing,
   * and providing the state's name but after 10 seconds the door will be locked again.
   */

  private static final Logger logger = LoggerFactory.getLogger(Lock.class);

  public UnlockShortly(Door door) {
    super(door);
    ClockTimer timer = ClockTimer.getInstance();
    timer.addObserver(this);
    timer.startTimer(); //When the door state becomes to
    // UnlockShortly state a 10 seconds timer starts the count.
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

  /*
   * The update method is part of the Observer pattern.
   * The method is responsible for updating the state of a door based on the
   * notification received from ClockTimer Observable object.
   * This method is executed at the moment when the observable
   * executes the notifyObservers() method.
   */
  @Override
  public void update(Observable o, Object arg) {
    if (!door.isClosed()) {
      door.setStateDoor(new Propped(door));
    } else {
      door.setStateDoor(new Lock(door));
    }
  }
}
