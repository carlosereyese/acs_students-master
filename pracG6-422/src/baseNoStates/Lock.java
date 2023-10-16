package baseNoStates;
import java.lang.Thread;
import java.time.OffsetTime;
import java.util.Observable;
import java.util.concurrent.TimeUnit;

public class Lock extends State{

    public Lock(Door d) {
        super(d);
    }
    public Lock(Door door, Observable observable) {
        super(door, observable);
    }

    void lock() {
        System.out.println("The door is already locked");
    }

    void unlock() {
        door.setStateDoor(new Unlock(door));
    }
    void unlockShortly() {
        door.setStateDoor(new UnlockShortly(door));
    }
    void open() {
        if (!door.isClosed()){
            System.out.println("Door is already open");
        }
        else {
            System.out.println("Can't open a locked door");
        }
    }

    void close() {
        if (door.isClosed()){
            System.out.println("Door is already closed");
        }
        else {
            door.setClosed(true);
        }
    }

    public String getName() {return Actions.LOCK;}

    @Override
    public void update(Observable o, Object arg) {

    }
}
