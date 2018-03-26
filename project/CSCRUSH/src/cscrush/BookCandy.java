package cscrush;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eren Ayture
 */
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.*;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
public class BookCandy {
    private String type;
    protected String typeBar;
    private BufferedImage image;
    private int positionMatrixX;
    private int positionMatrixY;
    private boolean marked;
    
    public BookCandy(){
        marked = false;
        type = (this.getClass().getName()).substring(8);
        typeBar = setTypeBar();
        positionMatrixX = -1;
        positionMatrixY = -1;
        image = null;
    }
    public void setPosition(int x, int y){
        positionMatrixX = x;
        positionMatrixY = y;
    }
    public void setMarked(boolean mark){
        marked = mark;
    }
    public boolean getMarked(){
        return marked;
    }
    public int getPositonX(){
        return positionMatrixX;
    }
    public int getPositonY(){
        return positionMatrixY;
    }
    public String getType(){
        return type;
    }
    public String getTypeBar(){
        return typeBar;
    }
    protected void setImage(String directory){
        image = null;
        try {
            image = ImageIO.read(new File(directory));
        } catch (IOException e) {
            Logger.getLogger(BoostersPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, e);

    }
    }
    
    public BufferedImage getImage()
    {
        return image;
    }
    
    private String setTypeBar(){
         int chance = (int)(Math.random() *100  + 1);
         String str;
         if(chance <= 5)
             str = "vertical";
         else if( ( 5 < chance ) && ( chance <= 10 ) )
             str = "horizontal";
         else
             str = "normal";
         return str;
    }
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
    public void setType (String str){
        type = str;
    }
    
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
