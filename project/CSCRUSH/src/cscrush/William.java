/*
 * This class implements the powerup William which destroys the book and its neighbors
 */
package cscrush;

/**
 *
 * @author Eren Ayture
 * *
   @property: BookCandy[][] list
 */
public class William {
    private BookCandy[][] list;
    public William(BookCandy[][] list){
        this.list = list;
    }
/*
 * This method takes the x and y coordinates of a book and destroys the book and its neighbors
 * @param positionX, positionY
 * @return list
 */
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
