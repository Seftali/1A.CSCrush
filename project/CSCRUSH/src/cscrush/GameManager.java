/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cscrush;

import java.io.IOException;

/**
 *
 * @author tanerduzceer
 */
public class GameManager 
{
    BookCandy[][] list;
    Level level;
    final int matrixSize = 10;
    int score;
    int numberofMarkeds;
    public GameManager(int level) throws IOException
    {
        this.level = new Level(level);
        this.list = new BookCandy[matrixSize][matrixSize];
        
        fillBooks();
        
    }
    private void fillBooks() throws IOException
    {
        int count = 10;
        int randomBookType;
        for(int i = 0; i < matrixSize; i++)
        {
            for(int j = 0; j < matrixSize; j++)
            {
                randomBookType = (int)Math.random()*4;
                if(randomBookType == 0)
                {
                    Cs102 cs102 = new Cs102();
                    list[i][j]=cs102;
                }
                if(randomBookType == 1)
                {
                    Cs201 cs201 = new Cs201();
                    list[i][j]=cs201;
                }
                if(randomBookType == 2)
                {
                    Cs224 cs224 = new Cs224();
                    list[i][j]=cs224;
                }
                if(randomBookType == 3)
                {
                    Cs342 cs342 = new Cs342();
                    list[i][j]=cs342;
                }
                if(randomBookType == 0)
                {
                    Cs476 cs476 = new Cs476();
                    list[i][j]=cs476;
                }
                
            }
         
        }
    }
    public void swap( int x1, int y1, int x2, int y2)//get from clicking
    {
       
        
        if(x1==x2 && Math.abs(y1-y2)<=1) //vertical swapping
        {
            int tempx = x1;
            int tempy = y1;
            x1 = x2;
            y1 = y2;
            x2 = tempx;
            y2 = tempy;
        }
        else if(y1 == y2 && Math.abs(x2-x1)<=1)//horizontal swapping
        {
            int tempx = x1;
            int tempy = y1;
            x1 = x2;
            y1 = y2;
            x2 = tempx;
            y2 = tempy;
        }
        
        else 
        {
            System.out.println("you can't change it");
        }
    }
    
    public void checkMatrix()
    {
        int count = 0;
    
         for(int i = 0; i < matrixSize; i++)
        {
            for(int j = 0; j < matrixSize; j++)
            {
                //horizontal 5 destroying
                if(list[i][j] == list[i][j+1] && list[i][j] == list[i][j+2] &&list[i][j]== list[i][j+3]&&list[i][j] == list [i][j+4])//5 destroy
                {
                    list[i][j] = list[i][j+1] = list[i][j+2] = list[i][j+3] = list [i][j+4] = NULL;
                // add point
                }
                // vertical 5 destroying
                if(list[i][j] == list[i+1][j] && list[i][j] == list[i+2][j] && list[i][j] == list[i+3][j] && list[i][j] == list [i+4][j])//5 destroy
                {
                    list[i][j] = list[i+1][j] = list[i+2][j] = list[i+3][j] = list [i+4][j] = NULL;
                // add point
                }
                
                //horizontal 4 destroying
                else if(list[i][j] == list[i][j+1] && list[i][j] == list[i][j+2] &&list[i][j]== list[i][j+3])//4 destroy
                {
                    list[i][j] = list[i][j+1] = list[i][j+2] = list[i][j+3] = NULL;
                // add point
                }
               // vertical 4 destroying
                else if(list[i][j] == list[i+1][j] && list[i][j] == list[i+2][j] && list[i][j] == list[i+3][j])//4 destroy
                {
                    list[i][j] = list[i+1][j] = list[i+2][j] = list[i+3][j] = NULL;
                // add point
                }
                
                //horizontal 3 destroying
                else if(list[i][j] == list[i][j+1] && list[i][j] == list[i][j+2])//3 destroy
                {
                    list[i][j] = list[i][j+1] = list[i][j+2] = NULL;
                // add point
                }
                // vertical 3 destroying
                else if(list[i][j] == list[i+1][j] && list[i][j] == list[i+2][j])//3 destroy
                {
                    list[i][j] = list[i+1][j] = list[i+2][j]= NULL;
                // add point
                }
                else
                    System.out.println("nothing destroyed");
            }
        }
    }
}
    