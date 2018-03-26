package cscrush;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ErenAyture
 */
public class Cs476 extends BookCandy {
    public Cs476(){
        super();
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
    }
}
