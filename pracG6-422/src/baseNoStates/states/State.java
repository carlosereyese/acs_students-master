package baseNoStates.states;
import baseNoStates.Door;

import java.util.Observable;
import java.util.Observer;

public abstract class State implements Observer {
    protected Door door;
    public State(Door door) {
        this.door = door;
    }
    public State(Door door, Observable observable) {
        this.door = door;
        observable.addObserver(this);
    }

    public void lock() {}
    public void unlock() {}
    public void unlockShortly() {}
    public void open() {}
    public void close() {}

    public abstract String getName();
}