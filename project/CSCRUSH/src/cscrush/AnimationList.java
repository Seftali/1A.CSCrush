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
        int[][] fall; //How many square will it fall
        BookCandy[][] newBookCandy;
        
        
    };
AnimationNode head;
AnimationNode tail;
public AnimationList()
{
    head = null;
}
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

public void removeAll(){
    head = null;
}
public AnimationNode getFirst(){
    return head;
}

}


