package baseNoStates;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public final class DirectoryUsers {
  private static final ArrayList<User> users = new ArrayList<>();

  public static void makeUsers() {

    // users without any privilege, just to keep temporally users instead of deleting them,
    // this is to withdraw all permissions but still to keep user data to give back
    // permissions later
    ArrayList<Area> noPrivilegeAreas = new ArrayList<Area>();
    //creamos los users ya con un array de araeas al cual los usuarios tienen accesos
    Group noPrivilege = new Group("noPrivilege", noPrivilegeAreas, new ArrayList<>(), new Schedule());
    users.add(new User("Bernat", "12345", noPrivilege));
    users.add(new User("Blai", "77532", noPrivilege));



    //EMPLOYEES:
    // ground floor, floor1, exterior, stairs (this, for all), that is, everywhere but the parking
    //creamos el array de areas para pasarle al constructor de User.
    Area groundFloor = DirectoryAreas.findAreaById("ground_floor");
    Area floor1 = DirectoryAreas.findAreaById("floor1");
    ArrayList<Area> employeesAreas = new ArrayList<Area>(Arrays.asList(groundFloor, floor1));

    // Sep. 1 2023 to Mar. 1 2024
    //creamos el array de dias y entre que fechas pueden acceder los usuarios para luego pasarlo al construcotr de schedule
    LocalDate fromDate = LocalDate.parse("2023-09-01");
    LocalDate toDate = LocalDate.parse("2024-03-01");
    ArrayList<DayOfWeek> daysOfWeek = new ArrayList<>(Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY));

    // week days 9-17h
    //creamos las horas, y creamos la nueva schedule con las listas de dias, horas a las que pueden acceder los employees.
    LocalTime fromHour = LocalTime.parse("09:00:00");
    LocalTime toHour = LocalTime.parse("17:00:00");
    Schedule schedule = new Schedule(fromDate, toDate, daysOfWeek, fromHour, toHour);

    // just shortly unlock
    // en este caso los employees las unicas acciones que podran realizar son open close y unlock shortly
    //creamos array dde actions para saber que acciones pueden hacer.
    ArrayList<String> allowUnlockShortly = new ArrayList<>(Arrays.asList(Actions.OPEN, Actions.CLOSE, Actions.UNLOCK_SHORTLY));
    Group employees = new Group("employees", employeesAreas, allowUnlockShortly, schedule);
    users.add(new User("Ernest", "74984", employees));
    users.add(new User("Eulalia", "43295", employees));

    // MANAGERS :
    // Sep. 1 2023 to Mar. 1 2024
    // week days + saturday, 8-20h
    daysOfWeek = new ArrayList<>(Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY));
    fromHour = LocalTime.parse("08:00:00");
    toHour = LocalTime.parse("20:00:00");
    schedule = new Schedule(fromDate, toDate, daysOfWeek, fromHour, toHour);

    // all actions, all spaces
    Area building = DirectoryAreas.findAreaById("building");
    ArrayList<Area> managersAndAdmin = new ArrayList<Area>(Arrays.asList(building));
    ArrayList<String> allActions = new ArrayList<>(Arrays.asList(Actions.OPEN, Actions.CLOSE, Actions.LOCK, Actions.UNLOCK, Actions.UNLOCK_SHORTLY));
    Group managers = new Group("managers", managersAndAdmin, allActions, schedule);
    users.add(new User("Manel", "95783", managers));
    users.add(new User("Marta", "05827", managers));

    // ADMIN :
    // always=2023 to 2100
    // all days of the week
    // all actions
    // all spaces
    fromDate = LocalDate.parse("2023-01-01");
    toDate = LocalDate.parse("2100-01-01");
    daysOfWeek = new ArrayList<>(Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY));
    fromHour = LocalTime.parse("00:00:00");
    toHour = LocalTime.parse("23:59:59");
    schedule = new Schedule(fromDate, toDate, daysOfWeek, fromHour, toHour);
    Group admin = new Group("admin", managersAndAdmin, allActions, schedule);
    users.add(new User("Ana", "11343", admin));
  }

  public static User findUserByCredential(String credential) {
    for (User user : users) {
      if (user.getCredential().equals(credential)) {
        return user;
      }
    }
    System.out.println("user with credential " + credential + " not found");
    return null; // otherwise we get a Java error
  }

}
