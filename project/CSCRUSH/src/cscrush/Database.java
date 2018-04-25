/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cscrush;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tendoushuu
 */
public class Database {
    
    static String userName = "cscrush";
    static String password = "";
    static String serverURL = "jdbc:mysql://139.179.225.94:3306/cscrush";
    static String portNumber = "80";
    private Connection conn;
    
    public Database()
    {
            conn = getConnection();
    }
    
    public static Connection getConnection(){

        Connection conn = null;

        try
        {
            conn = DriverManager.getConnection(serverURL,userName,password);
            System.out.println("Connected to database");
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }

        return conn;
    }
        
    public void closeConn()
    {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String[] login(String username, String pass)
    {
        try {
            Statement stmt = conn.createStatement();
            
            String[] res = new String[4];
            
            ResultSet rsUser = stmt.executeQuery("SELECT * FROM users WHERE username='" + 
                    username + "' AND password='" + pass + "';");
            
            if ( rsUser.next())
            {
                
                res[0] = rsUser.getString(1);
                res[1] = rsUser.getString(2);
                res[2] = rsUser.getString(3);
                res[3] = rsUser.getString(4);

                stmt.close();
                return res;
            }
            else
            {            
                stmt.close();
                return null;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public String[] signup( String username, String pass, String mail)
    {
        try {
            Statement stmt = conn.createStatement();
            
            int res = stmt.executeUpdate("INSERT INTO users(username, password, email) VALUES ('" + 
                    username + "','" + pass + "','" + mail + "');");
            
            if ( res == 0)
                return null;
            else
                return login(username, pass);
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public ArrayList<String[]> getHigh()
    {
        
        try {
            Statement stmt = conn.createStatement();
            
            ArrayList<String[]> res = null;
            
            ResultSet highScore = stmt.executeQuery("SELECT * FROM highscores");
            
            if ( highScore.next())
            {
                res =new ArrayList<String[]>();
                String[] row = new String[2];
                row[0] = highScore.getString(1);
                row[1] = highScore.getString(2);
                
                res.add(row);
                
                while (highScore.next())
                {
                    row = new String[2];
                    row[0] = highScore.getString(1);
                    row[1] = highScore.getString(2);

                    res.add(row);
                }

                stmt.close();
                return res;
            }
            else
            {            
                stmt.close();
                return null;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
}
