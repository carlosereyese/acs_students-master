package baseNoStates;

import java.util.ArrayList;

public abstract class Area {
  /*Area es la classe madre de partition y space*/
/*En clase area, esta la funcion find area by id la qual itera de forma recursiva tod el arbol de areas y devuelve el area que concuerde con el id
* sigue iterando hasta que entre en la ultima hoja y no haya encontrado ninguna que concuerde con id retorna null*/

  private String id;

  public Area(String id) {
    this.id = id;
  }

  public String getId() {
    return this.id;
  }
  public void setId(String id){
    this.id = id;
  }

  public abstract ArrayList<Door> getDoorsGivingAccess();

  public abstract Area findAreaById(String id);
}
