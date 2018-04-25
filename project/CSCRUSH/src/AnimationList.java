
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
public class animationNode{
    animationNode next;
    BookCandy[][] oldBookCandy;

};
animationNode head;
animationNode tail;
AnimationList()
{
    head = null;
}
void add(BookCandy[][] list){
    if(head == null){
        head = new animationNode();
        head.next = null;
        head.oldBookCandy = list;
        tail = head;
    }
    else{
        tail.next = new animationNode();
        tail.next.oldBookCandy = list;
        tail = tail.next;
        tail.next = null;
    }
}
void removeAll(){
    head = null;
}
animationNode getFirst(){
    return head;
}
}


