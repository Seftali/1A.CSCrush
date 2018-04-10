package cscrush;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Level {
    int lev;
    int count;
    public Level(int lev){
        this.lev = lev;
        count = movementCount();
    }
    private int movementCount(){
        switch (lev) {
            case 1:
                count = 100;
                break;
            case 2:
                count = 90;
                break;
            case 3:
                count = 80;
                break;
            case 4:
                count = 70;
                break;
            case 5:
                count = 60;
                break;
            case 6:
                count = 50;
                break;
            case 7:
                count = 40;
                break;
            case 8:
                count = 30;
                break;
            case 9:
                count = 20;
                break;
            default:
                count = 10;
                break;
        }   
        return count;
    }
    public void setLevel(int updateLevel){
        this.lev = updateLevel;
        this.count = movementCount();
    }
    public int getLevel(){
        return lev;
    }
    public void setMovement(int val){
        count = val;
    }
    public int getMovement(){
        return count;
    }
    
}
