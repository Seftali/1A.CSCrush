/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cscrush;

/**
 *
 * @author User
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
