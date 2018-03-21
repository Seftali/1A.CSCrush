/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cscrush;

import java.awt.event.WindowEvent;

/**
 *
 * @author tendoushuu
 */
public class GUIManager {
    
    public static GUIManager manager = new GUIManager();
    private GameFrame gameFrame;
    private LoginPanel loginPanel;
    private MainMenuPanel mainMenuPanel;
    private GamePlayScreenPanel gamePlayScreenPanel;
    
    GUIManager()
    {
        gameFrame = new GameFrame();
        loginPanel = new LoginPanel();
        mainMenuPanel = new MainMenuPanel();
        gamePlayScreenPanel = new GamePlayScreenPanel();
    }
    
    //Start with login panel
    public void startFrame()
    {
        gameFrame.setContentPane(loginPanel);
        gameFrame.setVisible(true);
    }
    
    //Check login and open main menu
    public void login()
    {
        gameFrame.setContentPane(mainMenuPanel);
        gameFrame.pack();
    }
    
    //Sign up and open main menu
    public void signup()
    {
        gameFrame.setContentPane(mainMenuPanel);
        gameFrame.pack();
    }
    
    //Display levels by clicking play button from main menu
    public void displayLevels()
    {
        openLevel();
    }
    
    //Opening choosed level
    public void openLevel()
    {
        //Get dump level 
        
        gameFrame.setContentPane(gamePlayScreenPanel);
        gameFrame.pack();
    }
    
    //Back from game screen play
    public void backFromGameScreenPlay()
    {
        gameFrame.setContentPane(mainMenuPanel);
        gameFrame.pack();
    }
    
    //Exit game
    public void exitGame()
    {
        gameFrame.dispatchEvent(new WindowEvent(gameFrame, WindowEvent.WINDOW_CLOSING));
    }
    
}
