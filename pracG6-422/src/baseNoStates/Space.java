package baseNoStates;

import java.util.ArrayList;

public class Space extends Area {

    private ArrayList<Door> doors;

    public Space(ArrayList<Door> doors) {
        this.doors = doors;
    }
}
