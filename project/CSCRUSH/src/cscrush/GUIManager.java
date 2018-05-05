/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cscrush;

import cscrush.AnimationList.AnimationNode;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private Database dbManager;
    public static String[] user;
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    
    
    
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
        dbManager = new Database();
        user = null;

    }
    
    //Start with login panel
    public void startFrame()
    {
        gameFrame.setContentPane(loginPanel);
        gameFrame.setVisible(true);
    }
    
    //Check login and open main menu
    public void login( String username, String pass)
    {
        /*
        user = dbManager.login(username, pass);
        
        System.out.println(username + pass);
        
        if ( user == null )
        {
            loginPanel.setErrorMessageL("Username or password is wrong!");
        }
        else
        {
*/
            gameFrame.setContentPane(mainMenuPanel);
            gameFrame.pack();
  //      }
    }
    
    public static boolean validateMail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }
    
    //Sign up anda open main menu
    public void signup( String username, String pass, String repass, String mail)
    {   /*
        
        
        if ( !pass.equals(repass))
        {
            loginPanel.setErrorMessageS("Error while retyping password!");
        }
        else if ( !validateMail(mail) )
        {
            loginPanel.setErrorMessageS("E-Mail is not proper!");
        }
        else
        {
            user = dbManager.signup(username, pass, mail);
            if ( user == null)
            {
                loginPanel.setErrorMessageS("Username or email is used!");
            }
            else
            {
*/
                gameFrame.setContentPane(mainMenuPanel);
                new SoundManager().changePage();
                gameFrame.pack();
  //          }
  //      }
        
    }
    //Display settings by clicking settings button from main menu
    public void displaySettings(int flag)
    {
        settingsPanel.flag = flag;
        gameFrame.setContentPane(settingsPanel);
        new SoundManager().changePage();
        gameFrame.pack();
    }
    //Display credits by clicking credits button from main menu
    public void displayCredits()
    {
        gameFrame.setContentPane(creditsPanel);
        new SoundManager().changePage();
        gameFrame.pack();
    }
    //Display levels by clicking play button from main menu
    public void displayLevels()
    {
        gameFrame.setContentPane(levelPanel);
        new SoundManager().changePage();
        gameFrame.pack();
    }
    public void displayHelp()
    {
        gameFrame.setContentPane(infoHelPanel);
        new SoundManager().changePage();
        gameFrame.pack();
    }
    public void displayHighScores()
    {
        ArrayList<String[]> scores = dbManager.getHigh();
        
        for ( int i = 0; i < scores.size(); i++)
        {
            System.out.println(scores.get(i)[0] + "   " +  scores.get(i)[1]);
        }
        
        gameFrame.setContentPane(highScorePanel);
        new SoundManager().changePage();
        gameFrame.pack();   
    }
    //Opening choosed level
    public void openLevel(int lev)
    {
        //Get dump level 
        currentLevel = new GameManager(lev);
        currentLevel.setScore(0);
        gamePlayScreenPanel.setGameTable(currentLevel.getSystemCall());
        gamePlayScreenPanel.setScore(currentLevel.getScore());
        gamePlayScreenPanel.setRemainedMove(currentLevel.getMovement());
        gameFrame.setContentPane(gamePlayScreenPanel);
        gameFrame.pack();
    }
    public void openLevel(int lev, int difficulty)
    {
        //Get dump level 
        currentLevel = new GameManager(lev);
        currentLevel.reconstruct(difficulty);
        currentLevel.setScore(0);
        currentLevel.setDifficulty(difficulty);
        gamePlayScreenPanel.setLevelName(lev);
        gamePlayScreenPanel.setGameTable(currentLevel.getSystemCall());
        gamePlayScreenPanel.setScore(currentLevel.getScore());
        gamePlayScreenPanel.setRemainedMove(currentLevel.getMovement());
        gamePlayScreenPanel.setTargetPoint("" + currentLevel.getLevel().getTarget());
        gameFrame.setContentPane(gamePlayScreenPanel);
        gameFrame.pack();
    }
    
    //Back from game screen play
    public void backFromGameScreenPlay()
    {
        gameFrame.setContentPane(levelPanel);
        new SoundManager().changePage();
        gameFrame.pack();
    }
    public void backToMainMenuPanel()
    {
        gameFrame.setContentPane(mainMenuPanel);
        new SoundManager().changePage();
        gameFrame.pack();
    }
    
    public void backToLoginPanel()
    {
        user = null;
        loginPanel.setErrorMessageL("");
        loginPanel.setErrorMessageS("");
        gameFrame.setContentPane(loginPanel);
        new SoundManager().changePage();
        gameFrame.pack();
    }
    
    public void backToGamePlayScreen()
    {
        gameFrame.setContentPane(gamePlayScreenPanel);
        new SoundManager().changePage();
        gameFrame.pack();
    }
    
    public void destroySpecialBooks(int x1, int y1){
        currentLevel.destroySpecialBook(y1, x1);
        gamePlayScreenPanel.setGameTable(currentLevel.getSystemCall());
        gamePlayScreenPanel.setScore(currentLevel.getScore());
        gamePlayScreenPanel.setRemainedMove(currentLevel.getMovement());
    }
    public void powerupaltay(){
        System.out.println("altay");
        currentLevel.PowerUpAltay();
        gamePlayScreenPanel.setGameTable(currentLevel.getSystemCall());
        gamePlayScreenPanel.setScore(currentLevel.getScore());
        gamePlayScreenPanel.setRemainedMove(currentLevel.getMovement());
        
    }
    public void poweruperay(int positionX, int positionY,int positionX2, int positionY2){
        currentLevel.PowerUpEray(positionX, positionY,positionX2,positionY2);
        gamePlayScreenPanel.setGameTable(currentLevel.getSystemCall());
        gamePlayScreenPanel.setScore(currentLevel.getScore());
        gamePlayScreenPanel.setRemainedMove(currentLevel.getMovement());
        
    }
     public void powerupozcan(int positionX, int positionY){
        currentLevel.PowerUpOzcan(positionX, positionY);
        gamePlayScreenPanel.setGameTable(currentLevel.getSystemCall());
        gamePlayScreenPanel.setScore(currentLevel.getScore());
        gamePlayScreenPanel.setRemainedMove(currentLevel.getMovement());
        
    }
      public void poweruprobin(int positionX, int positionY){
        currentLevel.PowerUpRobin(positionX, positionY);
        gamePlayScreenPanel.setGameTable(currentLevel.getSystemCall());
        gamePlayScreenPanel.setScore(currentLevel.getScore());
        gamePlayScreenPanel.setRemainedMove(currentLevel.getMovement());
        
    }
       public void powerupwilliam(int positionX, int positionY){
        currentLevel.PowerUpWilliam(positionX, positionY);
        gamePlayScreenPanel.setGameTable(currentLevel.getSystemCall());
        gamePlayScreenPanel.setScore(currentLevel.getScore());
        gamePlayScreenPanel.setRemainedMove(currentLevel.getMovement());
        
    }
    
    //Swap books in GameTable
    public void swapBooks(int x1, int y1, int x2, int y2)
    {        
        AnimationNode head = currentLevel.swap(y1, x1, y2, x2);
        
        if ( head != null)
            gamePlayScreenPanel.startAnimation(head);
        else
            gamePlayScreenPanel.setGameTable(currentLevel.getSystemCall());
        
        //gamePlayScreenPanel.setScore(currentLevel.getScore());
        gamePlayScreenPanel.setRemainedMove(currentLevel.getMovement());      
        

    }
    
    public void removeList()
    {
        currentLevel.removeList();
    }
    
    
    //Exit game
    public void exitGame()
    {
        gameFrame.dispatchEvent(new WindowEvent(gameFrame, WindowEvent.WINDOW_CLOSING));
    }
    
}