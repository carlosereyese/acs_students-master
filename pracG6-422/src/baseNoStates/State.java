package baseNoStates;
import java.util.Observable;
import java.util.Observer;

abstract class State implements Observer {
    protected Door door;
    public State(Door door) {
        this.door = door;
    }
    public State(Door door, Observable observable) {
        this.door = door;
        observable.addObserver(this);
    }

    void lock() {}
    void unlock() {}
    void unlockShortly() {}
    void open() {}
    void close() {}

    public abstract String getName();
}
