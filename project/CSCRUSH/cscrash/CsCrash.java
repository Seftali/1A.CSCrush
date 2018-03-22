/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cscrash;
/**
 *
 * @author User
 */
public class CsCrash {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BookCandy x = new BookCandy();
        System.out.println(x.toString());
        Cs102  y = new Cs102();
        System.out.println(y.toString());
        GameManager game;
        game = new GameManager(1);
        game.displayMarked();
        System.out.println();
        game.displayType();
        
    }
    
}
