package edu.eci.dosw.reto7;

/**
 * Executes an undo commands without knowing the devices details
 * RemoteControl
 */
public final class RemoteControl {
    public void executeCommand(Command command){
        if(command == null){
            throw new IllegalArgumentException("Command caannot be null");
        }
        command.execute();
    }

    public void undoCommand(Command command){
        if(command == null){
            throw new IllegalArgumentException("Command cannot be null");
        }
        command.undo();
    }
}
