package baseNoStates.states;

import baseNoStates.Actions;
import baseNoStates.ClockTimer;
import baseNoStates.Door;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lock extends State {
  /*  Aplica toda la logica de los cambios de estados cuando la puerta esta bloqueada.    */

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
    door.setStateDoor(new UnlockShortly(door, ClockTimer.getInstance()));
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
