package baseNoStates.states;
import baseNoStates.Actions;
import baseNoStates.ClockTimer;
import baseNoStates.Door;

import java.util.Observable;

public class UnlockShortly extends State {
/*  Aplica toda la logica de los cambios de estados cuando la puerta esta desbloqueada brevemente.
    Aplica el patron Observer con la clase Observer que implementa State.   */
    public  UnlockShortly(Door door) {
        super(door);
    }
    public  UnlockShortly(Door door, ClockTimer timer) {
        super(door, timer);
        timer.startTimer(); //Comienza un temporizador en el momento que pasa al estado UnlockShortly
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


/*  Redefinicion del metodo update de la clase Observer. Este metodo se ejecuta en el momento que
    el observable(ClockTimer) ejecuta el metodo notifyObservers();   */
    @Override
    public void update(Observable o, Object arg) {
        if (!door.isClosed()) {
            door.setStateDoor(new Propped(door));
        } else {
            door.setStateDoor(new Lock(door));
        }
    }
}
