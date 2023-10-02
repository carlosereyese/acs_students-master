package baseNoStates;

public class Lock extends State{

    public Lock(Door puerta) {
        super(puerta);
    }

    @Override
    public void handleaction(String action) {
        if (action.equals(Actions.UNLOCK)) {
            door.setStateDoor(new Unlock(door));
        }
        else {
            System.out.println("La puerta ya esta bloqueada.");
        }

    }
    public String getName() {return Actions.LOCK;}
}
