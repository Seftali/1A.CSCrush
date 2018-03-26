package cscrush;



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
        rebuild();
    }
    private void rebuild(){ 
        fillBooks();
        while(traverselyMarkedBooks() != 0){
            fall(0);
            destroyTraversally();
            fillBooks();
        }
    }
    
    private void fillBooks(){
        int count = 10;
        BookCandy temp = new BookCandy();
        for(int i = 0; i < matrixSize; i++){
            for(int j = 0; j < matrixSize; j++){
                if( ( list[i][j].getType() ).equals( temp.getType()) )
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

    public int markedBooks(int x,int y){
        int countx = x;
        int countxx = 1;
        int county = y;
        int countyy = 1;
        while(( countx+1 < matrixSize ) && (list[countx][y].getType().equals(list[++countx][y].getType())) && ( !( list[countx-1][y].getMarked() || list[countx][y].getMarked() ) ) )
            countxx++;
        while(( county+1 < matrixSize ) && (list[x][county].getType().equals(list[x][++county].getType())) && ( !( list[x][county-1].getMarked() || list[x][county].getMarked() ) ) ){
            countyy++;
        }
        int result = 0;   
        if(countxx > 2){
            result = countxx-1;
            for(int i = 0; i < countxx; i++)
                list[x+i][y].setMarked(true);
        }
        if(countyy > 2){
            result = countyy-1;
            for(int i = 0; i < countyy; i++)
                list[x][y+i].setMarked(true);
        }
        return result;
    }
    
    private int traverselyMarkedBooks(){
        int sum = 0;
        for(int i = 0; i < matrixSize; i++){
            for(int j = 0; j < matrixSize; j++){
                if(!(list[i][j].getMarked()))
                    sum += markedBooks(i,j);
            }
        }
        return sum;
    }
    
    private void destroyTraversally(){
        for(int i = 0; i < matrixSize; i++){
            for(int j = 0; j < matrixSize; j++){
                if(list[i][j].getMarked()){
                    list[i][j] = new BookCandy();
                    score = score+5;
                }
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
    
    public int getScore(){
        return score;
    }
    public void setScore(int val){
        score = val;
    }
}
