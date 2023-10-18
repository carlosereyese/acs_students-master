package baseNoStates.states;

import baseNoStates.Actions;
import baseNoStates.Door;

import java.util.Observable;

public class Unlock extends State {
    public Unlock(Door d){
        super(d);
    }
    public void lock() {
        if (!door.isClosed()){
            System.out.println("Cant lock open door.");
        } else {
            door.setStateDoor(new Lock(door));
        }
    }
    public void unlock() {
        System.out.println("La puerta ya estaba unlocked");
    }
    public void unlockShortly() {System.out.println("La puerta ya estaba unlocked");}
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
    public String getName() {return Actions.UNLOCK;}
    @Override
    public void update(Observable o, Object arg) {

    }
}
