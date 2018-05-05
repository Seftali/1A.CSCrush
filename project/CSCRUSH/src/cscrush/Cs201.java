package cscrush;



/*
 * @author Eren Ayture
 * @description: child class of an BookCandy object with overrided setTypeBarDirectly() 
 * @date: 5.05.2018
 */
public class Cs201 extends BookCandy {
    /*
    @see: super() takes parent class properties
    Constructor 
    */
    public Cs201(){
        super();
   
    }
    /*
    @return: void
    with %20 possibility set objec as special book vertical else horizontal
    */
    @Override
    public void setTypeBarDirectly(){
        int chance = (int)(Math.random() *100  + 1);
        if(chance <= 20)
            typeBar = "vertical";
        else
            typeBar = "horizontal";
    }
}


