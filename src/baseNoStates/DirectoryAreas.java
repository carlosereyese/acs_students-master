package baseNoStates;

import baseNoStates.states.Lock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DirectoryAreas {
  /*
   * The DirectoryAreas class initializes the areas with the composite pattern.
   */
  private static ArrayList<Area> allAreas;
  private static final Logger logger = LoggerFactory.getLogger(Lock.class);

  public static void makeAreas(ArrayList<Door> allDoors) {
    Space parking = new Space(
        new ArrayList<>(Arrays.asList(allDoors.get(0), allDoors.get(1))), "parking");
    Space hall = new Space(
        new ArrayList<>(Arrays.asList(allDoors.get(2), allDoors.get(3))), "hall");
    Space room1 = new Space(
        new ArrayList<>(Collections.singletonList(allDoors.get(4))), "room1");
    Space room2 = new Space(
        new ArrayList<>(Collections.singletonList(allDoors.get(5))), "room2");
    Space corridor = new Space(
        new ArrayList<>(Collections.singletonList(allDoors.get(6))), "corridor");
    Space room3 = new Space(
        new ArrayList<>(Collections.singletonList(allDoors.get(7))), "room3");
    Space IT = new Space(
        new ArrayList<>(Collections.singletonList(allDoors.get(8))), "IT");

    Partition basement = new Partition(
        new ArrayList<>(Collections.singletonList(parking)), "basement");
    Partition groundFloor = new Partition(
        new ArrayList<>(Arrays.asList(hall, room1, room2)), "ground_floor");
    Partition floor1 = new Partition(
        new ArrayList<>(Arrays.asList(room3, corridor, IT)), "floor1");

    Partition building = new Partition(
        new ArrayList<>(Arrays.asList(basement, groundFloor, floor1)), "building");

    allAreas = new ArrayList<>(Collections.singletonList(building));
  }

  public static Area findAreaById(String id) {

    if (id.equals("ROOT")) {
      return allAreas.get(0);
    }

    Visitor findAreaById = new FindAreaByIdVisitor(id);
    for (Area area : allAreas) {
      area.acceptVisitor(findAreaById);
    }

    if (findAreaById.getArea() == null) {
      logger.warn("Area with id " + id + " not found");
    } else {
      logger.info("Area with id " + findAreaById.getArea().getId() + " found");
    }
    return findAreaById.getArea();

  }

}
