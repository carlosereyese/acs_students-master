package baseNoStates;

import java.util.ArrayList;

public class Space extends Area {
/*  Tipo de area que contiene una lista de puertas.  */

    private ArrayList<Door> doors;
    public Space(ArrayList<Door> doors, String id) {
        super(id);
        this.doors = doors;
    }

    public Area findAreaById(String id) {
       if(this.getId().equals(id)) {
           return this;
       }
       else{
           return null;
       }
    }

    public ArrayList<Door> getDoorsGivingAccess() {return doors;}
}
