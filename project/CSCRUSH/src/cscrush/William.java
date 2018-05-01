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
public class William {
    private BookCandy[][] list;
    public William(BookCandy[][] list){
        this.list = list;
    }
    public BookCandy[][] PowerUpWilliam(int positionX, int positionY){
        if( ( positionX < 1 ) || ( positionX > 8 ) || ( positionY < 1 ) || ( positionY > 8 ) )
            return null;
        for(int i = positionX-1; i < positionX+1; i++){
            for(int j = positionY-1; j < positionY+1; j++){
                list[i][j].setMarked(true);
            }
        }
        return list;
    }
}
