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
public abstract class BookCandy
{
    String type;    //type of book
    Image bookImage;//image of book
    
    int positionMatrixX;// matrix position
    int positionMatrixY;// matrix position
    
    String typeBar; //special books are vertical or horizontal
    boolean marked; //book is special or not
    
    BookCandy bookCandy;
    
    abstract void setPosition (int x, int y); //
    abstract int getPositionX ();
    abstract int getPositionY ();
    abstract String getType();  //gets type of book
    abstract void setImage(Image image);   // arrange image
    abstract void setMarked();   //set book as special
    
}
