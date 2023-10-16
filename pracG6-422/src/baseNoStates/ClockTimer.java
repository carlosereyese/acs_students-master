package baseNoStates;
import java.util.Observable;
import java.util.Observer;
import java.time.LocalDateTime;
import java.util.Timer;

public class ClockTimer extends Observable {

    public ClockTimer() {}
    private Timer timer;
    private LocalDateTime dateTime;

    public void startTimer() {};
    private void tick() {};

}

