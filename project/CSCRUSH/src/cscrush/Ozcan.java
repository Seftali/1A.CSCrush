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
public class Ozcan {
    private BookCandy[][] list;
    public Ozcan(BookCandy[][] list){
        this.list = list;
    }

    public BookCandy[][] PowerUpOzcan(int positionX, int positionY){
        if( (positionX<0|| positionY<0) || ( positionX>=10 || positionY>=10 ) )
            return null;
        list[positionX][positionY].setMarked(true);
        return list;
    }
}
