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
public class Cs102 extends BookCandy {
    public Cs102(){
        super();
    }
    @Override
    public void setTypeBarDirectly(){
        int chance = (int)(Math.random() *100  + 1);
        if(chance <= 10)
            typeBar = "vertical";
        else
            typeBar = "horizontal";
    }
}
