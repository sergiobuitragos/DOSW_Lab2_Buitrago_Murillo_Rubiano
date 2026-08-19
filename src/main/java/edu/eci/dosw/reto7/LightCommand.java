package edu.eci.dosw.reto7;

/**
 * Command to turn on / turn off a light
 * Saves the previous state to be able to undo the action
 */
public final class LightCommand implements Command{
    private final Light light;
    private final boolean turnOn;
    private boolean previousState;

    public LightCommand(Light light, boolean turnOn){
        if(light == null){
            throw new IllegalArgumentException("Light cannot be null");
        }
        this.light = light;
        this.turnOn = turnOn;
    }

    @Override
    public void execute(){
        previousState = light.isOn();
        if(turnOn){
            light.turnOn();
        }else {
            light.turnOff();
        }
    }

    @Override
    public void undo(){
        if(previousState){
            light.turnOn();
        } else{
            light.turnOff();
        }
    }
    
}
