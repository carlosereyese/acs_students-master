package baseNoStates;
import baseNoStates.states.*;
import baseNoStates.requests.RequestReader;
import org.json.JSONObject;


public class Door {
  private final String id;
  private boolean closed; // physically
  private State stateDoor;

  private String from;

  private String to;

  public Door(String id) {
    this.id = id;
    closed = true;
    stateDoor = new Lock(this);
  }

  public Door(String id, String from, String to) {
    this.id = id;
    this.to = to;
    this.from = from;
    closed = true;
    stateDoor = new Lock(this);
  }

  public void processRequest(RequestReader request) {
    // it is the Door that process the request because the door has and knows
    // its state, and if closed or open
    if (request.isAuthorized()) {
      String action = request.getAction();
      doAction(action);
    } else {
      System.out.println("not authorized");
    }
    request.setDoorStateName(getStateName());
  }

  private void doAction(String action) {
    switch (action) {
      case Actions.OPEN:
        stateDoor.open();
        break;
      case Actions.CLOSE:
        stateDoor.close();
        break;
      case Actions.LOCK:
        stateDoor.lock();
        break;
      case Actions.UNLOCK:
        stateDoor.unlock();
        break;
      case Actions.UNLOCK_SHORTLY:
        stateDoor.unlockShortly();
        break;
      default:
        assert false : "Unknown action " + action;
        System.exit(-1);
    }
  }

  public boolean isClosed() {
    return closed;
  }

  public void setClosed(boolean b) {
    closed = b;
  }

  public String getId() {
    return id;
  }

  public String getStateName() {
    return stateDoor.getName();
  }

  @Override
  public String toString() {
    return "Door{"
        + ", id='" + id + '\''
        + ", closed=" + closed
        + ", state=" + getStateName()
        + "}";
  }

  public JSONObject toJson() {
    JSONObject json = new JSONObject();
    json.put("id", id);
    json.put("state", getStateName());
    json.put("closed", closed);
    return json;
  }

  public void setStateDoor(State newState) {
    stateDoor = newState;
  }
}