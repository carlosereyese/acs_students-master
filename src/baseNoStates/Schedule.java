package baseNoStates;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Schedule {
  /*
   * The Schedule class contains the time, date and day
   * of the week that every user can handle a door.
   */
  private LocalDate fromDate;
  private LocalDate toDate;
  private ArrayList<DayOfWeek> daysOfWeeks;
  private LocalTime fromHour;
  private LocalTime toHour;

  public Schedule() {
  }

  public Schedule(LocalDate fromDate, LocalDate toDate, ArrayList<DayOfWeek> daysOfWeeks,
                  LocalTime fromHour, LocalTime toHour) {
    this.fromDate = fromDate;
    this.toDate = toDate;
    this.daysOfWeeks = daysOfWeeks;
    this.fromHour = fromHour;
    this.toHour = toHour;
  }

  public boolean isAllowedAtTime(LocalDateTime dateTime) {
    LocalDate date = dateTime.toLocalDate();
    LocalTime time = dateTime.toLocalTime();
    if (date.isAfter(fromDate) && date.isBefore(toDate)) {
      if (daysOfWeeks.contains(date.getDayOfWeek())) {
        return time.isAfter(fromHour) && time.isBefore(toHour);
      }
    }
    return false;
  }

}
