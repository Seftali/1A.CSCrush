package cscrush;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eren Ayture
 * @description: This class represents Book Objects as Candies,It is a parent class of 5 other sub book ojects like CS102,CS201,CS224,CS342,CS476
 * @date: 5.05.2018
 * @property: String type: type of an object as CS102,CS201,CS224,CS342,CS476
 * @property: String typeBar: speciality of an object as normal,vertical,horizontal
 * @property boolean marked: While trversing 2d array  3 or same consecutive objects are to be marked.
 */
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.*;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
public class BookCandy {
    private String type;
    protected String typeBar;//only child classes can reach.
    private boolean marked;
    /*
    Default Constructor
    @see getClass(): gets this class
    @see getName(): gets this classes name
    @see substring(int index): substring deletes package name except class identifier.
    */
    public BookCandy(){
        marked = false;
        type = (this.getClass().getName()).substring(8);
        typeBar = "normal";
    }
    /*
    @param: boolean mark: if true sets marked property true;
    @return: void
    Setter for marking objects
    */
    public void setMarked(boolean mark){
        marked = mark;
    }
    /*
    @return: void
    Getter for marked of an BookCandy objects
    */
    public boolean getMarked(){
        return marked;
    }
    /*
    @return: void
    Getter for type of an BookCandy objects
    */
    public String getType(){
        return type;
    }
    /*
    @return: void
    Getter for typeBar of an BookCandy objects
    */
    public String getTypeBar(){
        return typeBar;
    }
    
    //to determine the special books are horizontal or vertical
    /*
    @return: void
    with %50 possibility set objec as special book vertical or horizontal
    */
    public void setTypeBarDirectly(){
        int chance = (int)(Math.random() *2  + 1);
        switch ( chance ) {
            case 1:
                typeBar = "vertical";
                break;
            case 2:
                typeBar = "horizontal";
                break;
        }
    }
    /*
    @param: String str
    @return: void
    sets type as CS102,CS201,CS224,CS342,CS476
    */
    public void setType (String str){
        type = str;
    }
    /*
    @param: String str
    @return: void
    sets type as "horizontal", "vertical" or "normal"
    */
    public void setTypeBar( String str)
    {
        typeBar = str;
    }
    /*
    @return: String str
    to string method in the form of (type typeBar marked) 
    */
    public String toString(){
       String str;
       String str2;
       if(marked)
           str2 = "true";
       else
           str2 = "false";
       str = type +"  "+ typeBar+"  "+ str2;
       return str;
    }
    
}
