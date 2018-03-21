/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cscrush;

import java.awt.Image;
/**
 *
 * @author tanerduzceer
 */
public class Cs342 extends BookCandy
{

    String type;    //type of book
    Image bookImage;//image of book
    
    int positionMatrixX;// matrix position
    int positionMatrixY;// matrix position
    
    String typeBar; //special books are vertical or horizontal
    boolean marked; //book is special or not
    
    public Cs342()
    {
        this.type = "Cs342";
      //  this.bookImage = Image.
     // this.positionMatrixX = 
      this.marked = false;
      //this.typeBar
    }

    @Override
    void setPosition(int x, int y) 
    {
        this.positionMatrixX = x;
        this.positionMatrixY = y;
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    int getPositionX() 
    {
        return this.positionMatrixX;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    int getPositionY() 
    {
        return this.positionMatrixY;
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    String getType() 
    {
        return this.type;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void setImage(Image image) 
    {
        this.bookImage = image;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void setMarked() 
    {
        if(this.marked == true)
        this.marked = false;
        
        else
        this.marked = true;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
