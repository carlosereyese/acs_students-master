package baseNoStates;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public class ClockTimer extends Observable {
  /*
   * The ClockTimer class has the responsibility to handle
   * the ten seconds timer to Lock after the UnlockShortly state
   *  It is part of the Observer and Singleton design patterns.
   */
  private int seconds;

  private static ClockTimer clockInstance = null;

  private ClockTimer() {
    this.seconds = 0;
    startTimer();
  }

  /*
  *After ten seconds it updates the timer's state and calls the update method
  * of the observers when notifying observers.
  */
  public void startTimer() {
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        seconds += 10;
        if (seconds >= 10) {
          timer.cancel();
        }
        setChanged();
        notifyObservers(seconds);
      }
    }, 10000, 10000);
  }

  public static ClockTimer getInstance() {
    if (clockInstance == null) {
      clockInstance = new ClockTimer();
    }
    return clockInstance;
  }
}
