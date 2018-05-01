/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cscrush;

/**
 *
 * @author Eren Ayture
 */

public class Robin {
    private BookCandy[][] list;
    private GameManager game;
    public Robin(BookCandy[][] list){
        this.list = list;
        this.game = new GameManager(1);
    }

    public BookCandy[][] PowerUpRobin(int positionX, int positionY){
        if( (positionX<0|| positionY<0) || ( positionX>=10 || positionY>=10 ) )
            return null;
        list[positionX][positionY] = game.randomBookGenerator();
        return list;
    }
}
