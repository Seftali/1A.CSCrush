package cscrush;

/*
 * @author Eren Ayture
 * @description: child class of an BookCandy object with overrided setTypeBarDirectly() 
 * @date: 5.05.2018
 */
public class Cs224 extends BookCandy {
    /*
    @see: super() takes parent class properties
    Constructor 
    */
    public Cs224(){
        super();
      
    }
    @Override
    /*
    @return: void
    with %30 possibility set objec as special book vertical else horizontal
    */
    public void setTypeBarDirectly(){
        int chance = (int)(Math.random() *100  + 1);
        if(chance <= 30)
            typeBar = "vertical";
        else
            typeBar = "horizontal";
    }
}

