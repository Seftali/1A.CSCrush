package cscrush;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eren Ayture
 * @description: child class of an BookCandy object with overrided setTypeBarDirectly() 
 * @date: 5.05.2018
 */

public class Cs102 extends BookCandy {
    /*
    @see: super() takes parent class properties
    Constructor 
    */
    public Cs102(){
        super();
    }
    /*
    @return: void
    with %10 possibility set objec as special book vertical else horizontal
    */
    @Override
    public void setTypeBarDirectly(){
        int chance = (int)(Math.random() *100  + 1);
        if(chance <= 10)
            typeBar = "vertical";
        else
            typeBar = "horizontal";
    }
}
