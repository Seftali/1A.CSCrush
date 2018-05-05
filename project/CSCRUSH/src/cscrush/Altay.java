
package cscrush;

/**
 * @description:This class changes five random books with special random books
 * @author Eren Ayture
   @property: BookCandy[][] list;
   @property: BookCandy[][] list
 */
public class Altay {
    private BookCandy[][] list;
    public Altay(BookCandy[][] list){
        this.list = list;
    }
    public BookCandy[][] PowerUpAltay(){
        int x = 0;
        int y = 0;
        for(int i = 0; i < 5; i++){
            x = (int)(Math.random() * 10);
            y = (int)(Math.random() * 10);
            list[x][y].setTypeBarDirectly();
        }
        return list;
    }
}
