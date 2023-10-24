package baseNoStates;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Group {

  private String id;
  private ArrayList<Area> allowedAreas;
  private ArrayList<String> allowedActions;
  private Schedule schedule;

  public Group(String id, ArrayList<Area> allowedAreas, ArrayList<String> allowedActions, Schedule schedule) {
    this.id = id;
    this.allowedAreas = allowedAreas;
    this.allowedActions = allowedActions;
    this.schedule = schedule;
  }

  public boolean canAccessArea(String areaId){
    for (Area area : allowedAreas){
      if(area.findAreaById(areaId) != null){
        return true;
      }
    }
    return false;
  }

  public boolean isAllowedAtTime(LocalDateTime dateTime){
    return schedule.isAllowedAtTime(dateTime);
  }

  public boolean isAllowedToDoAction(String action){
    return allowedActions.contains(action);
  }

}
