package baseNoStates;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public class ClockTimer extends Observable {
  /*  ClockTimer gestiona la espera de la funcionalidad UnluckShortly, aplicando el patron Observer.
      Esta clase extiende de Observable, que nos brinda de los metodos necesarios para aplicar el patron. */
  private int seconds;

  private static ClockTimer clockInstance = null;

  private ClockTimer() {
    this.seconds = 0;
    startTimer();
  }

  public void startTimer() {
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        seconds += 10;
        if (seconds >= 10) {
          timer.cancel();
        }
        setChanged(); // Cambia el objeto a estado modificado
        notifyObservers(seconds); // Avisa a los observadores
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
