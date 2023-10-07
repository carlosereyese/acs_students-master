package baseNoStates;

abstract class State {

    protected Door door;

    public State(Door door) {
        this.door = door;
    }

    void lock() {}
    void unlock() {}
    void open() {}
    void close() {}

    public abstract String getName();
}
