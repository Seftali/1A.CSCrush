
package cscrush;

/**
 * This class implements the powerup Ozcan which destroys a choosen book
 * @author Eren Ayture
 * @property: BookCandy[][] list
 */
public class Ozcan {
    private BookCandy[][] list;
    public Ozcan(BookCandy[][] list){
        this.list = list;
    }
/*
 * This method takes the x and y coordinates of choosen book and destroys it
 * @param positionX, positionY
 * @return list
 */
    public BookCandy[][] PowerUpOzcan(int positionX, int positionY){
        if( (positionX<0|| positionY<0) || ( positionX>=10 || positionY>=10 ) )
            return null;
        list[positionX][positionY].setMarked(true);
        return list;
    }
}
