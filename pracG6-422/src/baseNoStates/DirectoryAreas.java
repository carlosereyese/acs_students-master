package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;

public class DirectoryAreas {

  private static ArrayList<Area> allAreas;

  public static void makeAreas(ArrayList<Door> allDoors) {
    Space parking = new Space(new ArrayList<>(Arrays.asList(allDoors.get(0), allDoors.get(1))));
    Space hall = new Space(new ArrayList<>(Arrays.asList(allDoors.get(2), allDoors.get(3))));
    Space room1 = new Space(new ArrayList<>(Arrays.asList(allDoors.get(4))));
    Space room2 = new Space(new ArrayList<>(Arrays.asList(allDoors.get(5))));
    Space corridor = new Space(new ArrayList<>(Arrays.asList(allDoors.get(6))));
    Space room3 = new Space(new ArrayList<>(Arrays.asList(allDoors.get(7))));
    Space IT = new Space(new ArrayList<>(Arrays.asList(allDoors.get(8))));

    Partition basement = new Partition(new ArrayList<>(Arrays.asList(parking)));
    Partition groundFloor = new Partition(new ArrayList<>(Arrays.asList(hall, room1, room2)));
    Partition floor1 = new Partition(new ArrayList<>(Arrays.asList(room3, corridor, IT)));

    Partition building = new Partition(new ArrayList<>(Arrays.asList(basement, groundFloor, floor1)));

    allAreas = new ArrayList<>(Arrays.asList(building));
  }

}
