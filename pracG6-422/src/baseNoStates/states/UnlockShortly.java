package baseNoStates.states;
import baseNoStates.Actions;
import baseNoStates.ClockTimer;
import baseNoStates.Door;

import java.util.Observable;

public class UnlockShortly extends State{
    public  UnlockShortly(Door door) {
        super(door);
    }
    public  UnlockShortly(Door door, ClockTimer timer) {
        super(door, timer);
        timer.startTimer();
    }

    public void lock() { System.out.println("Unlock Shortly in process please wait."); }
    public void unlock() {
        System.out.println("Unlock Shortly in process please wait.");
    }
    public void unlockShortly() { System.out.println("Unlock Shortly in process please wait."); }
    public void open() {
        if (!door.isClosed()){
            System.out.println("Door is already open");
        }
        else {
            door.setClosed(false);
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
    public String getName() {return Actions.UNLOCK_SHORTLY;}
    @Override
    public void update(Observable o, Object arg) {
        if (!door.isClosed()) {
            door.setStateDoor(new Propped(door));
        } else {
            door.setStateDoor(new Lock(door));
        }
    }
}
