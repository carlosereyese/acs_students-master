package baseNoStates;

public class Lock extends State{

    public Lock(Door d) {
        super(d);
    }

    void lock() {
        System.out.println("The door is already locked");
    }

    void unlock() {
        door.setStateDoor(new Unlock(door));
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
}
