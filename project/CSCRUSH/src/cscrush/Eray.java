
package cscrush;

/**
 * @description: This class implements the powerup Eray which swaps choosen books which are not neighbor
 * @author Eren Ayture
   @property: BookCandy[][] list
 
 */
public class Eray {
    private BookCandy[][] list;
    public Eray(BookCandy[][] list){
        this.list = list;
    }
/*
 * This method takes the x and y coordinates of a book and another book to swap them
 * @param x1,y1,x2,y2
 * @return list
 */
    public BookCandy[][] PowerUpEray(int x1,int y1, int x2,int y2){
        if( (x1<0|| y1<0||x2<0||y2<0) || ( x1>= 10 || y1>= 10 || x2 >= 10 || y2 >= 10 ) )
            return null;
        BookCandy temp = list[x1][y1];
        list[x1][y1] = list[x2][y2];
        list[x2][y2] = temp;
        return list;
    }
}
