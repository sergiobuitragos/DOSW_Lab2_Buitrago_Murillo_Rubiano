package edu.eci.dosw.reto7;

/**
 * Comand to manage the music system volume
 */
public final class MusicCommand implements Command{
    private final MusicSystem musicSystem;
    private final int volume;
    private int previousVolume;

    public MusicCommand(MusicSystem musicSystem, int volume){
        if(musicSystem == null){
            throw new IllegalArgumentException("Music System cannot be null");
        }
        this.musicSystem = musicSystem;
        this.volume = volume;
    }

    @Override
    public void execute(){
        previousVolume = musicSystem.getVolume();
        musicSystem.setVolume(volume);
    }

    @Override
    public void undo(){
        musicSystem.setVolume(previousVolume);
    }
}
