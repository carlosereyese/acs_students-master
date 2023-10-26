package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;

public class DirectoryAreas {

  private static ArrayList<Area> allAreas;

  public static void makeAreas(ArrayList<Door> allDoors) {
    //creamos primero las hojas del arbol, los spaces, a partir de las puertas que la commponen
    // para luego poder meterlos en una lista i crear las partitions.
    Space parking = new Space(new ArrayList<>(Arrays.asList(allDoors.get(0), allDoors.get(1))), "parking");
    Space hall = new Space(new ArrayList<>(Arrays.asList(allDoors.get(2), allDoors.get(3))), "hall");
    Space room1 = new Space(new ArrayList<>(Arrays.asList(allDoors.get(4))), "room1");
    Space room2 = new Space(new ArrayList<>(Arrays.asList(allDoors.get(5))), "room2");
    Space corridor = new Space(new ArrayList<>(Arrays.asList(allDoors.get(6))), "corridor");
    Space room3 = new Space(new ArrayList<>(Arrays.asList(allDoors.get(7))), "room3");
    Space IT = new Space(new ArrayList<>(Arrays.asList(allDoors.get(8))), "IT");

    //creamos las partitions a partir de coger todas areas que la componen.
    Partition basement = new Partition(new ArrayList<>(Arrays.asList(parking)), "basement");
    Partition groundFloor = new Partition(new ArrayList<>(Arrays.asList(hall, room1, room2)), "ground_floor");
    Partition floor1 = new Partition(new ArrayList<>(Arrays.asList(room3, corridor, IT)), "floor1");

    //esta partition, es building de la qual cogemos todas  las partitions.
    Partition building = new Partition(new ArrayList<>(Arrays.asList(basement, groundFloor, floor1)), "building");

    allAreas = new ArrayList<>(Arrays.asList(building));
  }

  public static Area findAreaById(String id) {
    for (Area area : allAreas) {
      Area res = area.findAreaById(id); //llamamos recursivo para poder recorrer el arbol y diferenciar space y partition.
      if (res != null) {
        return res;
      }
    }
    System.out.println("area with id " + id + " not found");
    return null;
  }

  public static ArrayList<Area> getAllAreas() { return allAreas; }
}
