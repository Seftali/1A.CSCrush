package cscrush;
/**
 *  @description:This class implements the level of game.
 *  @author TanerMan
    @property: int level
    @property: int count
    @property: int target
 */
public class Level {
    int lev;
    int count;
    int target;
    public Level(int lev){
        this.lev = lev;
        count = movementCount();
    }
/*
 * This method arranges the movement count  according to the chosen level.
 * 
 */
    private int movementCount(){
        switch (lev) {
            case 1:
                count = 30;
                target = 1000;
                
                break;
            case 2:
                count = 30;
                target = 2000;
                break;
            case 3:
                count = 30;
                target = 3000;
                break;
            case 4:
                count = 25;
                target = 4000;
                break;
            case 5:
                count = 25;
                target = 5000;
                break;
            case 6:
                count = 20;
                target = 6000;
                break;
            case 7:
                count = 20;
                target = 7000;
                break;
            case 8:
                count = 20;
                target = 8000;
                break;
            case 9:
                count = 15;
                target = 9000;
                break;
            default:
                count = 15;
                target = 10000;
                break;
        }   
        return count;
    }
/*
 * This method arranges the level according to the user
 * @param: updateLevel
 */
    public void setLevel(int updateLevel){
        this.lev = updateLevel;
        this.count = movementCount();
    }
/*
 * This method returns the level
 * @return lev  
 */
    public int getLevel(){
        return lev;
    }
/*
 * This method sets the movement according to val
 * @param val  
 */
    public void setMovement(int val){
        count = val;
    }
/*
 * This method arranges the movement according to val
 * @return count 
 */
    public int getMovement(){
        return count;
    }
/*
 * This method arranges the target points according to level 
 */
    public void setTarget(){
        target = target;
    }
/*
 * This method arranges the target points according to level 
 * @return target 
 */
    public int getTarget(){
        return target;
        
    }
}
