package baseNoStates;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public class ClockTimer extends Observable {
    private int seconds;

    public ClockTimer() {
        this.seconds = 0;
        startTimer();
    }

    public void startTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                seconds += 10;
                if (seconds >= 10)
                    timer.cancel();
                setChanged(); // Mark the subject as changed
                notifyObservers(seconds); // Notify the observers
            }
        }, 10000, 10000);
    }
}
