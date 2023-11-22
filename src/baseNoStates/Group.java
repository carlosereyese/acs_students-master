package baseNoStates;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Group {
  /*  Clase que recoge todos los permisos que puede tener un usuario que contenga este objeto. */
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

  /*  Metodo que verifica que un usuario que
  pertenezca a un grupo tenga acceso a una determinada area.  */
  public boolean canAccessArea(String areaId) {
    Visitor findAreaById = new FindAreaByIdVisitor(areaId);
    for (Area area : allowedAreas) {
      area.acceptVisitor(findAreaById);
    }
    return findAreaById.getArea() != null;
  }

  /*  Metodo que verifica que un usuario que pertenezca a un
   grupo tenga acceso a una determinada hora.  */
  public boolean isAllowedAtTime(LocalDateTime dateTime) {
    return schedule.isAllowedAtTime(dateTime);
  }

  /*  Metodo que verifica que un usuario que pertenezca a un grupo pueda hacer una accion.  */
  public boolean isAllowedToDoAction(String action) {
    return allowedActions.contains(action);
  }

}
