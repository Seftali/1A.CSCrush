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
    private SettingsPanel settingsPanel;
    private InfoHelPanel infoHelPanel;
    private CreditsPanel creditsPanel;
    private HighScorePanel highScorePanel;
    private LevelPanel levelPanel;
    private GameManager currentLevel;
    
    
    
    GUIManager()
    {
        gameFrame = new GameFrame();
        loginPanel = new LoginPanel();
        mainMenuPanel = new MainMenuPanel();
        gamePlayScreenPanel = new GamePlayScreenPanel();
        settingsPanel = new SettingsPanel();
        creditsPanel = new CreditsPanel();
        levelPanel = new LevelPanel();
        infoHelPanel = new InfoHelPanel();
        highScorePanel = new HighScorePanel();
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
    //Display settings by clicking settings button from main menu
    public void displaySettings(int flag)
    {
        settingsPanel.flag = flag;
        gameFrame.setContentPane(settingsPanel);
        gameFrame.pack();
    }
    //Display credits by clicking credits button from main menu
    public void displayCredits()
    {
        gameFrame.setContentPane(creditsPanel);
        gameFrame.pack();
    }
    //Display levels by clicking play button from main menu
    public void displayLevels()
    {
        gameFrame.setContentPane(levelPanel);
        gameFrame.pack();
    }
    public void displayHelp()
    {
        gameFrame.setContentPane(infoHelPanel);
        gameFrame.pack();
    }
    public void displayHighScores()
    {
        gameFrame.setContentPane(highScorePanel);
        gameFrame.pack();   
    }
    //Opening choosed level
    public void openLevel()
    {
        //Get current level 
        currentLevel = new GameManager(1);
        gamePlayScreenPanel.setGameTable(currentLevel.getSystemCall());
        gamePlayScreenPanel.setScore(currentLevel.getScore());
        gameFrame.setContentPane(gamePlayScreenPanel);
        gameFrame.pack();
    }
    
    //Back from game screen play
    public void backFromGameScreenPlay()
    {
        gameFrame.setContentPane(levelPanel);
        gameFrame.pack();
    }
    public void backToMainMenuPanel()
    {
        gameFrame.setContentPane(mainMenuPanel);
        gameFrame.pack();
    }
    
    public void backToLoginPanel()
    {
        gameFrame.setContentPane(loginPanel);
        gameFrame.pack();
    }
    
    public void backToGamePlayScreen()
    {
        gameFrame.setContentPane(gamePlayScreenPanel);
        gameFrame.pack();
    }

    
    //Swap books in GameTable
    public void swapBooks(int x1, int y1, int x2, int y2)
    {
        currentLevel.swap(y1, x1, y2, x2);
        gamePlayScreenPanel.setGameTable(currentLevel.getSystemCall());
        gamePlayScreenPanel.setScore(currentLevel.getScore());
       // gameFrame.pack();
    }
    
    //Exit game
    public void exitGame()
    {
        gameFrame.dispatchEvent(new WindowEvent(gameFrame, WindowEvent.WINDOW_CLOSING));
    }
    
}
