package baseNoStates.states;

import baseNoStates.Actions;
import baseNoStates.Door;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Unlock extends State {
  /*
   * The Unlock class represents the unlocked state of a door.
   * It is a concrete state class in the State design pattern.
   * The Unlock state is responsible for handling operations related to an unlocked door,
   * such as locking, opening, closing, and providing the state's name.
   */

  public Unlock(Door d) {
    super(d);
  }

  private static final Logger logger = LoggerFactory.getLogger(Lock.class);

  public void lock() {
    logger.debug("Attempting to lock door...");
    if (!door.isClosed()) {
      logger.warn("Cant lock open door.");
    } else {
      door.setStateDoor(new Lock(door));
      logger.info("Door is locked now");
    }
  }

  public void unlock() {
    logger.debug("Attempting to unlock door...");
    logger.warn("Door is already unlocked");
  }

  public void unlockShortly() {
    logger.debug("Attempting to unlock shortly door...");
    logger.warn("Door is already unlocked");
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
    return Actions.UNLOCK;
  }

}
