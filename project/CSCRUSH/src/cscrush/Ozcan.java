/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cscrush;

/**
 *
 * @author User
 */
public class Ozcan {
    private BookCandy[][] list;
    private GameManager game;
    public Ozcan(BookCandy[][] list){
        this.list = list;
        this.game = new GameManager(1);
    }

    public BookCandy[][] PowerUpOzcan(int positionX, int positionY){
        if( (positionX<0|| positionY<0) || ( positionX>=10 || positionY>=10 ) )
            return null;
        list[positionX][positionY].setMarked(true);
        return list;
    }
}
