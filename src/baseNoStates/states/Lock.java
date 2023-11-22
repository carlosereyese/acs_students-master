package baseNoStates.states;

import baseNoStates.Actions;
import baseNoStates.ClockTimer;
import baseNoStates.Door;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lock extends State {
  /*
   * The Lock class represents the locked state of a door.
   * It is a concrete state class in the State design pattern.
   * The Lock state is responsible for handling operations related to a locked door,
   * such as unlocking, opening, closing, and providing the state's name.
   */

  private static final Logger logger = LoggerFactory.getLogger(Lock.class);

  public Lock(Door d) {
    super(d);
  }

  public void lock() {
    logger.warn("The door is already locked");
  }

  public void unlock() {
    logger.info("Door is unlocked now");
    door.setStateDoor(new Unlock(door));
  }

  public void unlockShortly() {
    logger.info("Door is unlocked shortly now");
    door.setStateDoor(new UnlockShortly(door));
  }

  public void open() {
    logger.debug("Attempting to open door...");
    if (!door.isClosed()) {
      logger.warn("Door is already open");
    } else {
      logger.warn("Can't open a locked door");
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
    return Actions.LOCK;
  }
}
