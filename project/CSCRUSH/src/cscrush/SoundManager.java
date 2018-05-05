
package cscrush;

/**
 *  @description: This class implements the sound of the game. They are swapping sound, 
 *  destroying sound,vs.
 *  @author TanerMan
 *  @property: File swap
    @property: File destroy
    @property: File end
    @property: File main
    @property: File page
    @property: File theme
 */
//import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;    
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
public class SoundManager {
    File swap;
    File destroy;
    File end;
    File main;
    File page;
    Clip theme;
    
    public SoundManager(){
        try{
        swap = new File("src/sounds/swapSound.wav");
        destroy = new File("src/sounds/battle047.wav");
        end = new File("src/sounds/you-got-it-1.wav");
        page = new File("src/sounds/Page Turn Sound Effect.wav");
        main = new File("src/sounds/mainTheme.wav");
        theme = javax.sound.sampled.AudioSystem.getClip();
        theme.open(javax.sound.sampled.AudioSystem.getAudioInputStream(main));
        }catch(Exception e){}
    }
    /*
    *This method plays swapping sound
    */
    public void playSwap(){
        try
        {
            Clip clip = javax.sound.sampled.AudioSystem.getClip();
            clip.open(javax.sound.sampled.AudioSystem.getAudioInputStream(swap));
            clip.start();
        }catch(IOException | LineUnavailableException | UnsupportedAudioFileException e){}
    }
    /*
    *This method plays destroying sound
    */
    public void playDestroy(){
        try
        {
        Clip clip = javax.sound.sampled.AudioSystem.getClip();
        clip.open(javax.sound.sampled.AudioSystem.getAudioInputStream(destroy));
        clip.start();
        }catch(IOException | LineUnavailableException | UnsupportedAudioFileException e){}
    }
    /*
    *This method plays ending sound
    */
    public void playEnd(){
        try
        {
        Clip clip = javax.sound.sampled.AudioSystem.getClip();
        clip.open(javax.sound.sampled.AudioSystem.getAudioInputStream(end));
        clip.start();
        }catch(IOException | LineUnavailableException | UnsupportedAudioFileException e){}
    }
    /*
    *This method plays changing page sound
    */
    public void changePage(){
        try
        {
        Clip clip = javax.sound.sampled.AudioSystem.getClip();
        clip.open(javax.sound.sampled.AudioSystem.getAudioInputStream(page));
        clip.start();
        }catch(IOException | LineUnavailableException | UnsupportedAudioFileException e){}
    }
    /*
    *This method start the music of the game
    */
    public void playMainTheme(){
        theme.start();
    }
    /*
    *This method stop the music of the game
    */
    public void stopMainTheme(){
        theme.stop();
    }
}
