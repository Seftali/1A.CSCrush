/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cscrush;

/**
 *
 * @author TanerMan
 */
import javax.sound.sampled.AudioSystem;
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
    public SoundManager(){
        try{
        swap = new File("/Users/tanerduzceer/Desktop/CSCRUSH/project/CSCRUSH/src/sounds/swapSound.wav");
        destroy = new File("/Users/tanerduzceer/Desktop/CSCRUSH/project/CSCRUSH/src/sounds/battle047.wav");
        end = new File("/Users/tanerduzceer/Desktop/CSCRUSH/project/CSCRUSH/src/sounds/youve-been-a-very-good.wav");
        main = new File("/Users/tanerduzceer/Desktop/CSCRUSH/project/CSCRUSH/src/sounds/mainTheme.wav");
        }catch(Exception e){}
    }
    public void playSwap(){
        try
        {
        Clip clip = javax.sound.sampled.AudioSystem.getClip();
        clip.open(javax.sound.sampled.AudioSystem.getAudioInputStream(swap));
        clip.start();
        }catch(IOException | LineUnavailableException | UnsupportedAudioFileException e){}
    }
    public void playDestroy(){
        try
        {
        Clip clip = javax.sound.sampled.AudioSystem.getClip();
        clip.open(javax.sound.sampled.AudioSystem.getAudioInputStream(destroy));
        clip.start();
        }catch(IOException | LineUnavailableException | UnsupportedAudioFileException e){}
    }
    public void playEnd(){
        try
        {
        Clip clip = javax.sound.sampled.AudioSystem.getClip();
        clip.open(javax.sound.sampled.AudioSystem.getAudioInputStream(end));
        clip.start();
        }catch(IOException | LineUnavailableException | UnsupportedAudioFileException e){}
    }
    public void playMainTheme(boolean play){
        
            try
            {
            Clip clip = javax.sound.sampled.AudioSystem.getClip();
            clip.open(javax.sound.sampled.AudioSystem.getAudioInputStream(main));
                while(play){
                    clip.start();
                    if(!play)
                        continue;
                }
                clip.stop();
            }catch(IOException | LineUnavailableException | UnsupportedAudioFileException e){}
    }
}
