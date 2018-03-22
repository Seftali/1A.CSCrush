package cscrash;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eren Ayture
 */
public class Cs201 extends BookCandy {
    public Cs201(){
        super();
        if(getTypeBar().equals("normal"))
            setImage("img\\cs201.jpeg");
        else if (getTypeBar().equals("vertical"))
            setImage("img\\cs201Vertical.jpeg");
        else
            setImage("img\\cs201Horizontal.jpeg");
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
            setImage("img\\cs201Vertical.jpg");
        if(typeBar == "vertical")
            setImage("img\\cs201Horizontal.jpg");
    }

}
