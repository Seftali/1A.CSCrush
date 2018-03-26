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
public class Cs342 extends BookCandy {
    public Cs342(){
        super();
        if(getTypeBar().equals("normal"))
            setImage("C:\\Users\\tendoushuu\\Documents\\1A.CSCrush\\project\\CSCRUSH\\src\\cscrush\\cs342.jpg");
        else if (getTypeBar().equals("vertical"))
            setImage("C:\\Users\\tendoushuu\\Documents\\1A.CSCrush\\project\\CSCRUSH\\src\\cscrush\\cs342Vertical.jpg");
        else
            setImage("C:\\Users\\tendoushuu\\Documents\\1A.CSCrush\\project\\CSCRUSH\\src\\cscrush\\cs342Horizontal.jpg");
    }
    
    @Override
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
        if(typeBar == "vertical")
            setImage("C:\\Users\\tendoushuu\\Documents\\1A.CSCrush\\project\\CSCRUSH\\src\\cscrush\\cs342Vertical.jpg");
        if(typeBar == "vertical")
            setImage("C:\\Users\\tendoushuu\\Documents\\1A.CSCrush\\project\\CSCRUSH\\src\\cscrush\\cs342Horizontal.jpg");
    }
}
