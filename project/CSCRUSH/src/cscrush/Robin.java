
package cscrush;

/**
 *  @description:This class implements the powerup Robin which changes a choosen book with another random book
 *  @author Eren Ayture
 *  @property: BookCandy[][] list
 *  @property: GameManager game
 */

public class Robin {
    private BookCandy[][] list;
    private GameManager game;
    public Robin(BookCandy[][] list){
        this.list = list;
        this.game = new GameManager(1);
    }
/*
 * This method takes the x and y coordinates of a book location and changes it with a random book
 * @param positionX, positionY
 * @return list
 */
    public BookCandy[][] PowerUpRobin(int positionX, int positionY){
        if( (positionX<0|| positionY<0) || ( positionX>=10 || positionY>=10 ) )
            return null;
        list[positionX][positionY] = game.randomBookGenerator();
        return list;
    }
}
