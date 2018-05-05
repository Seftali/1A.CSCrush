package cscrush;
import cscrush.BookCandy;
import javax.xml.soap.Node;

/*
 * This class maintains the connection between GUIManager and GameManager to show animations
 */

/*
 *
 * @author tanerduzceer
 *
 * @property: AnimationNode next
   @property: BookCandy[][] oldBookCandy
   @property: int[][] marked
   @property: int[][] fall
   @property: BookCandy[][] newBookCandy
   @property: int score;
 */

public class AnimationList {
    public class AnimationNode{
        AnimationNode next;
        BookCandy[][] oldBookCandy;
        int[][] marked;
        int[][] fall; //How many square will it fall
        BookCandy[][] newBookCandy;
        int score;
        
    };
AnimationNode head;
AnimationNode tail;
/*
 * This constructor creates a node which is null
 */
public AnimationList()
{
    head = null;
}
/*
 * This method adds a BookCandy to the linked list
 */
public void add(AnimationNode node){
    if(head == null)
    {
        head = node;
        tail = head;
    }
    else
    {
        tail.next = node;
        tail = tail.next;
        tail.next = null;
    }
}
/*
 * This method removes all elements
 */
public void removeAll(){
    head = null;
}
/*
 * This method gets the first element of the list
 * @return head
 */
public AnimationNode getFirst(){
    return head;
}

}


