package baseNoStates;
public class Unlock extends State {
    public Unlock(Door puerta){
        super(puerta);
    }

    @Override
    public void handleaction(String action) {
        if(action.equals(Actions.LOCK)){
            door.setStateDoor(new Lock(door));
        }

    }
    public String getName() {return Actions.UNLOCK;}
}
