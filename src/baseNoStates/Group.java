package baseNoStates;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Group {
  /*
   * The Group class contains the allowed areas, actions and schedule
   * that every user can have.
   */
  private String id;
  private final ArrayList<Area> allowedAreas;
  private final ArrayList<String> allowedActions;
  private final Schedule schedule;

  public Group(String id, ArrayList<Area> allowedAreas,
               ArrayList<String> allowedActions, Schedule schedule) {
    this.id = id;
    this.allowedAreas = allowedAreas;
    this.allowedActions = allowedActions;
    this.schedule = schedule;
  }

  public boolean canAccessArea(String areaId) {
    Visitor findAreaById = new FindAreaByIdVisitor(areaId);
    for (Area area : allowedAreas) {
      area.acceptVisitor(findAreaById);
    }
    return findAreaById.getArea() != null;
  }

  public boolean isAllowedAtTime(LocalDateTime dateTime) {
    return schedule.isAllowedAtTime(dateTime);
  }

  public boolean isAllowedToDoAction(String action) {
    return allowedActions.contains(action);
  }

}
