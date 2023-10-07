package baseNoStates;
public class Unlock extends State {
    public Unlock(Door d){
        super(d);
    }

    void lock() {
        door.setStateDoor(new Lock(door));
    }

    void unlock() {
        System.out.println("La puerta ya estaba unlocked");
    }

    void open() {
        if (!door.isClosed()){
            System.out.println("Door is already open");
        }
        else {
            door.setClosed(false);
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
    public String getName() {return Actions.UNLOCK;}
}
