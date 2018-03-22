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
public class Cs224 extends BookCandy {
    public Cs224(){
        super();
        if(getTypeBar().equals("normal"))
            setImage("img\\cs224.jpeg");
        else if (getTypeBar().equals("vertical"))
            setImage("img\\cs224Vertical.jpeg");
        else
            setImage("c,img\\cs224Horizontal.jpeg");
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
            setImage("img\\cs224Vertical.jpg");
        if(typeBar == "vertical")
            setImage("img\\cs224Horizontal.jpg");
    }
}
