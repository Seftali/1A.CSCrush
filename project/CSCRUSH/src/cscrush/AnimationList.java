package cscrush;
import cscrush.BookCandy;
import javax.xml.soap.Node;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tanerduzceer
 */
public class AnimationList {
    public class AnimationNode{
        AnimationNode next;
        BookCandy[][] oldBookCandy;
        int[][] marked;

    };
AnimationNode head;
AnimationNode tail;
public AnimationList()
{
    head = null;
}
public void add(BookCandy[][] list){
    if(head == null){
        head = new AnimationNode();
        head.next = null;
        head.oldBookCandy = list;
        head.marked = markedMatrix(list);
        tail = head;
    }
    else{
        tail.next = new AnimationNode();
        tail.next.oldBookCandy = list;
        tail.next.marked = markedMatrix(list);
        tail = tail.next;
        tail.next = null;
    }
}
public int[][] markedMatrix(BookCandy[][] temp){
        int[][] marked = new int[10][10]; 
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(temp[i][j].getMarked()){
                    marked[i][j] = 1;
                }
            }
        }
        return marked;
    }
public void removeAll(){
    head = null;
}
public AnimationNode getFirst(){
    return head;
}

}


