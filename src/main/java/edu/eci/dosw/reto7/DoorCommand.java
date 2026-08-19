package edu.eci.dosw.reto7;

/**
 * Command to open/close a door
 */
public final class DoorCommand implements Command{
    private final Door door;
    private final boolean open;
    private boolean previousState;

    public DoorCommand(Door door, boolean open){
        if(door == null){
            throw new IllegalArgumentException("Door cannot be null");
        }
        this.door = door;
        this.open = open;
    }

    @Override
    public void execute(){
        previousState = door.isOpen();
        if(open){
            door.open();
        }else{
            door.close();
        }
    }

    @Override
    public void undo(){
        if(previousState){
            door.open();
        }else{
            door.close();
        }
    }
}
