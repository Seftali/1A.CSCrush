/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cscrush;
/**
 *
 * @author tanerduzceer
 */
public class Level 
{
    int level;
    int counter;
    
    Level(int level)
    {
        this.level = level;
    }
    
    public int movementCount()
    {
        if(level == 1)
        {
            this.counter = 60;
            counter--;
            return counter;
            
        }
        else if(level == 2)
        {
            this.counter = 55;
            counter--;
            return counter;
       
        }
        else if(level == 3)
        {
            this.counter = 50;
            counter--;
            return counter;
       
        }
        else if(level == 4)
        {
            this.counter = 45;
            counter--;
            return counter;
       
        }
        else if(level == 5)
        {
            this.counter = 40;
            counter--;
            return counter;
       
        }
        else if(level == 6)
        {
            this.counter = 45;
            counter--;
            return counter;
       
        }
        else if(level == 7)
        {
            this.counter = 40;
            counter--;
            return counter;
       
        }
        else if(level == 8)
        {
            this.counter = 35;
            counter--;
            return counter;
       
        }
        else if(level == 7)
        {
            this.counter = 30;
            counter--;
            return counter;
       
        }
        else if(level == 8)
        {
            this.counter = 25;
            counter--;
            return counter;
       
        }
        else if(level == 9)
        {
            this.counter = 20;
            counter--;
            return counter;
       
        }
        else
        {
            this.counter = 15;
            counter--;
            return counter;
       
        }
    }
}
