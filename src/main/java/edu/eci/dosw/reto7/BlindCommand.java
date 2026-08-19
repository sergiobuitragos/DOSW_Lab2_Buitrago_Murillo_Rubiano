package edu.eci.dosw.reto7;

/**
 * Command to adjust the blind's position
 * BlindCommand
 */
public final class BlindCommand implements Command{
    private final WindowBlind blind;
    private final int position;
    private int previousPosition;

    public BlindCommand(WindowBlind blind, int position){
        if(blind == null){
            throw new IllegalArgumentException("Blind cannot be null");
        }
        this.blind = blind;
        this.position = position;
    }

    @Override
    public void execute(){
        previousPosition = blind.getPosition();
        blind.setPosition(position);
    }

    @Override
    public void undo(){
        blind.setPosition(previousPosition);
    }
}