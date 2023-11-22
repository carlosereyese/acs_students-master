package baseNoStates.states;

import baseNoStates.Actions;
import baseNoStates.Door;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Propped extends State {
  /*  Aplica toda la logica de los cambios de estados cuando la puerta esta propped.  */

  public Propped(Door d) {
    super(d);
  }

  private static final Logger logger = LoggerFactory.getLogger(Lock.class);

  public void lock() {
    logger.debug("Attempting to lock door...");
    logger.warn("Cant lock propped door.");
  }

  public void unlock() {
    logger.debug("Attempting to unlock door...");
    logger.warn("Cant unlock propped door.");
  }

  public void unlockShortly() {
    logger.debug("Attempting to unlock shortly door...");
    logger.warn("Cant unlock shortly propped door.");
  }

  public void open() {
    logger.debug("Attempting to open door...");
    logger.warn("Cant open propped door.");
  }

  public void close() {
    door.setClosed(true);
    door.setStateDoor(new Lock(door));
  }

  public String getName() {
    return Actions.PROPPED;
  }
}
