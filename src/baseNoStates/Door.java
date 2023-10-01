package baseNoStates;

import baseNoStates.requests.RequestReader;
import org.json.JSONObject;

import javax.swing.*;


public class Door {
  private final String id;
  private boolean closed; // physically
  private boolean locked; //no abrir.
  private State stateDoor;

  public Door(String id) {
    this.id = id;
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
        if (stateDoor instanceof Lock) {
          System.out.println("Door is locked, unlock first and then open.");
        } else if (closed){
          closed = false;
        } else{
          System.out.println("Door is already open.");
        }
        break;
      case Actions.CLOSE:
        if (closed) {
          System.out.println("Can't close door " + id + " because it's already closed");
        } else {
          closed = true;
        }
        break;
      case Actions.LOCK:
        if(closed){
          stateDoor.handleaction(action);
        }else{
          System.out.println("door must be closed to lock");
        }
        break;
        // fall through
      case Actions.UNLOCK:
        if(closed && stateDoor instanceof Lock){
          stateDoor.handleaction(action);
        }else {
          System.out.println("Puerta ya desbloqueada");
        }
        break;
        // fall through
      case Actions.UNLOCK_SHORTLY:
        // TODO
        System.out.println("Action " + action + " not implemented yet");
        break;
      default:
        assert false : "Unknown action " + action;
        System.exit(-1);
    }
  }

  public boolean isClosed() {
    return closed;
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
