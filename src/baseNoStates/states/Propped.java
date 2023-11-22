package baseNoStates.states;

import baseNoStates.Actions;
import baseNoStates.Door;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Propped extends State {
  /*
   * The Propped class represents the state of a door where the
   * door was open in an UnlockShortly state and was never closed again.
   * It is a concrete state class in the State design pattern.
   * The Propped state is responsible for handling operations related to a propped door,
   * such as closing and providing the state's name the other states can't be executed.
   */

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
