package cscrash;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eren Ayture
 */
public class GameManager {
    BookCandy[][] list;
    Level level;
    final int matrixSize = 10;
    int score;
    int numberofMarkeds;
    public GameManager(int level){
        this.level = new Level(level);
        this.list = new BookCandy[matrixSize][matrixSize];
        numberofMarkeds = 0;
        score = 0;
        for(int i = 0; i < matrixSize; i++){
            for(int j = 0; j < matrixSize; j++){
                list[i][j] = new BookCandy();
            }
        }
        fillBooks();
        rebuild();
    }
    private void rebuild(){
        traverselyMarkedBooks();
        destroyTraversally();
        fall(0);
        while(numberofMarkeds != 0){
            fillBooks();
            traverselyMarkedBooks();
            destroyTraversally();
            fall(0);
        }        
    }
    
    private void fillBooks(){
        int count = 10;
        for(int i = 0; i < matrixSize; i++){
            for(int j = 0; j < matrixSize; j++){
                if( ( list[i][j].getType() ).equals( (new BookCandy()).getType()) )
                    list[i][j] = randomBookGenerator();
                else
                    if(--count == 0)
                        break;
            }
            count = 10;
        }
    }
    private BookCandy randomBookGenerator(){
        int book = (int)(Math.random() *5  + 1);
        BookCandy randomBook = new BookCandy();
        switch (book) {
            case 1:
                randomBook = new Cs102();
                break;
            case 2:
                randomBook = new Cs201();
                break;
            case 3:
                randomBook = new Cs224();
                break;
            case 4:
                randomBook = new Cs342();
                break;
            case 5:
                randomBook = new Cs476();
                break;
        }
        return randomBook;
    }
    private void markedBooks(int x, int y){
        int countx = x;
        int county = y;
        int temp = 2;
        int count = 0;
        
        while(true){
            if( (countx+1 < matrixSize ) && ( list[x][y].getType().equals( list[++countx][y].getType() ) ) ){
                count++;
                list[countx-1][y].setMarked(true);
                list[countx][y].setMarked(true);
                numberofMarkeds++;
            }
            else
                break;
        }
        if( (count < 2 ) && ( x != matrixSize-1 ) ){
            list[x][y].setMarked(false);
            list[x+1][y].setMarked(false);
            numberofMarkeds--;
        }
        else
            numberofMarkeds++;
            
        count = 0;
        countx = x;
        while(true){
            if( ( countx-1 >= 0 ) && ( list[x][y].getType().equals( list[--countx][y].getType() ) ) ){
                count++;
                list[countx][y].setMarked(true);
                list[countx+1][y].setMarked(true);
                numberofMarkeds++;
            }
            else 
                break;
        }
        if( (count < 2 ) && ( x != 0 ) ){
            list[x][y].setMarked(false);
            list[x-1][y].setMarked(false);
            numberofMarkeds--;
        }
        else
            numberofMarkeds++;
        count = 0;
        county = y;
        while(true){
            if(  ( county+1 < matrixSize ) && list[x][y].getType().equals( list[x][++county].getType() ) ){
                count++;
                list[x][county-1].setMarked(true);
                list[x][county].setMarked(true);
                numberofMarkeds++;
            }
            else
                break;
        }
        if( (count < 2 ) && ( y != matrixSize-1 ) ){
            list[x][y+1].setMarked(false);
            list[x][y].setMarked(false);
            numberofMarkeds--;
        }
        else
            numberofMarkeds++;
        count = 0;
        county = y;
        while(true){
            if(  ( county-1 >= 0 ) && ( list[x][y].getType().equals( list[x][--county].getType() ) ) ){
                count++;
                list[x][county+1].setMarked(true);
                list[x][county].setMarked(true);
                numberofMarkeds++;
            }
            else 
                break;
        }
        if( (count < 2 ) && ( y != 0 ) ){
            list[x][y-1].setMarked(false);
            list[x][y].setMarked(false);
            numberofMarkeds--;
        }
        else
            numberofMarkeds++;
    }
    private void traverselyMarkedBooks(){
        for(int i = 0; i < matrixSize; i++){
            for(int j = 0; j < matrixSize; j++){
                if(list[i][j].getMarked())
                    markedBooks(i,j);
                if(list[j][i].getMarked())
                    markedBooks(j,i);
            }
        }
    }
    private void destroySpecificly(int x,int y){
        int temp = x;    
        while((list[temp++][y].getMarked()) && (temp <= matrixSize) ){
            list[temp-1][y] = new BookCandy();
            numberofMarkeds--;
            score = score+5;
        }
        temp = x;
        while((list[temp--][y].getMarked()) && (temp >= -1) ){
            list[temp+1][y] = new BookCandy();
            numberofMarkeds--;
            score = score+5;
        }
        temp = y;
        while((list[x][temp++].getMarked()) && (temp <= matrixSize) ){
            list[x][temp-1] = new BookCandy();
            numberofMarkeds--;
            score = score+5;
        }
        temp = y;
        while((list[x][temp--].getMarked()) && (temp >= -1) ){
            list[x][temp+1] = new BookCandy();
            numberofMarkeds--;
            score = score+5;
        }
    }
    private void destroyTraversally(){
        for(int i = 0; i < matrixSize; i++){
            for(int j = 0; j < matrixSize; j++){
                destroySpecificly(i,j);
            }
        }
    }
    private void destroySpecialBook(int x, int y){
        if(list[x][y].getTypeBar().equals("horizontal")){
            for(int i = 0; i < matrixSize; i++){
                list[x][i].setMarked(true);
            }
            fall(0);
            for(int i = 0; i < matrixSize; i++){
                list[0][i] = new BookCandy();
            }
            fillBooks();
            rebuild();
        }
        else if(list[x][y].getTypeBar().equals("vertical")){
            for(int i = 0; i < matrixSize; i++){
                list[i][y] = new BookCandy();
            }
            fillBooks();
            rebuild();
        }
    }
    private void fall(int y){
        if(y == matrixSize)
            return;
        int i = matrixSize-1;
        int count = 0;
        while (i >= 0){
            if(list[i][y].getMarked())
                count++;
            i--;
        }
        i = matrixSize;
        int counTemp = i;
        int count2 =1;
        while((i >= count-1) && (count != 0) ){
            while( ( count2 != count ) && ( counTemp!= count ) ){
                if(list[counTemp][y].getMarked()){
                    BookCandy temp = list[i][y];
                    list[counTemp][y] = list[--counTemp][y];
                    list[counTemp+1][y] = temp;  
                }
            count++;
            }
            i--;
        }
        fall(y+1); 
    }
    public BookCandy[][] getSystemCall(){
        return list;
    }
    public void swap(int x1,int y1, int x2,int y2){
        if( (x1<0|| y1<0||x2<0||y2<0) || ( x1>=matrixSize || y1>=matrixSize || x2>=matrixSize || y2>=matrixSize ) )
            return;
        if(this.level.getMovement()!= 0){
            BookCandy temp = list[x1][y1];
            list[x2][y2] = list[x1][y1];
            list[x2][y2] = temp;
            rebuild();
            level.setMovement(level.getMovement()-1);
        }
    }
    public void PowerUpAltay(){
        int x = 0;
        int y = 0;
        score = score-100;
        for(int i = 0; i < 5; i++){
            x = (int)(Math.random() * matrixSize);
            y = (int)(Math.random() * matrixSize);
            list[x][y].setTypeBarDirectly();
        }
    }
    public void PowerUpWilliam(int positionX, int positionY){
        if( ( positionX < 1 ) || ( positionX > 8 ) || ( positionY < 1 ) || ( positionY > 8 ) )
            return;
        score = score -90;
        for(int i = positionX-1; i < positionX+1; i++){
            for(int j = positionY-1; j < positionY+1; j++){
                list[i][j].setMarked(true);
            }
        }
        rebuild();
    }
    public void PowerUpRobin(int positionX, int positionY){
        if( (positionX<0|| positionY<0) || ( positionX>=matrixSize || positionY>=matrixSize ) )
            return;
        score = score -50;
        list[positionX][positionY] = randomBookGenerator();
        rebuild();
    }
    public void PowerUpOzcan(int positionX, int positionY){
        if( (positionX<0|| positionY<0) || ( positionX>=matrixSize || positionY>=matrixSize ) )
            return;
        score = score -80;
        list[positionX][positionY].setMarked(true);
        rebuild();
    }
    public void PowerUpEray(int positionX, int positionY,int positionX2, int positionY2){
        swap(positionX,positionY,positionX2,positionY2);
        score = score -70;
    }
    public void displayMarked(){
        for(int i = 0; i < matrixSize; i++){
            for(int j = 0; j < matrixSize; j++){
                System.out.print(list[i][j].getMarked()+ " ");
            }
            System.out.println("\n");
        }
    }
    public void displayType(){
        for(int i = 0; i < matrixSize; i++){
            for(int j = 0; j < matrixSize; j++){
                System.out.print(list[i][j].getType()+list[i][j].getTypeBar()+ " ");
            }
            System.out.println("\n");
        }
    }
    public boolean check(){
        boolean r = true;
        for(int i = 0; i < matrixSize-2; i++){
            for(int j = 0; j < matrixSize-2; j++){
                if( (list[i][j].getTypeBar().equals("normal"))&& (list[i][j+1].getTypeBar().equals("normal"))&& (list[i][j+2].getTypeBar().equals("normal"))&&((list[i][j].getType() == list[i+1][j].getType())&&(list[i][j].getType() == list[i+1][j].getType() ))){
                    r = false;
                    break;
                }
                else if((list[j][i].getType() == list[j][i+1].getType())&&(list[j][i+1].getType() == list[j][i+2].getType() ) && (list[j][i].getTypeBar().equals("normal"))&& (list[j][i+1].getTypeBar().equals("normal"))&& (list[j][i+2].getTypeBar().equals("normal"))){
                    r = false;
                    break;
                }
            }
        }
        return r;
    }
    public int getScore(){
        return score;
    }
    public void setScore(int val){
        score = val;
    }
}
