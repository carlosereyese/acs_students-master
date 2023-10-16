package baseNoStates;
import java.util.Observable;
import java.util.Observer;
public class UnlockShortly extends State{
    public  UnlockShortly(Door door) {
        super(door);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        door.setStateDoor(new Lock(door));
    }

    void lock() {System.out.println("Unlock Shortly in proces plis wait.");}

    void unlock() {
        System.out.println("Unlock Shortly in proces plis wait.");
    }
    void unlockShortly() {System.out.println("Unlock Shortly in proces plis wait.");}
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

    public String getName() {return Actions.UNLOCK_SHORTLY;}

    @Override
    public void update(Observable o, Object arg) {

    }
}
