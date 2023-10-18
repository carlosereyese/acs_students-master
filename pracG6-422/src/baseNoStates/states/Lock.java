package baseNoStates.states;
import baseNoStates.Actions;
import baseNoStates.ClockTimer;
import baseNoStates.Door;

import java.util.Observable;

public class Lock extends State{

    public Lock(Door d) {
        super(d);
    }
    public Lock(Door door, Observable observable) {
        super(door, observable);
    }
    public void lock() {
        System.out.println("The door is already locked");
    }
    public void unlock() {
        door.setStateDoor(new Unlock(door));
    }
    public void unlockShortly() {
        door.setStateDoor(new UnlockShortly(door, new ClockTimer()));
    }
    public void open() {
        if (!door.isClosed()){
            System.out.println("Door is already open");
        }
        else {
            System.out.println("Can't open a locked door");
        }
    }
    public void close() {
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
