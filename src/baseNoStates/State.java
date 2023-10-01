package baseNoStates;

abstract class State {

    protected Door door;

    public State(Door door) {
        this.door = door;
    }

    void Lock(Door door) {
    }

    void Unlock(Door puerta) {
    }

    public abstract void handleaction(String action);


    public abstract String getName();
}
