package cscrush;

import cscrush.AnimationList.AnimationNode;



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
    
    private BookCandy[][] list;
    private Level level;
    private final int matrixSize = 10;
    private int score;
    private int scoreIncrement;
    private int numberofMarkeds;
    public int minimumDestroyCount;
    AnimationList lists;
    public GameManager(int level){
        this.level = new Level(level);
        this.list = new BookCandy[matrixSize][matrixSize];
        numberofMarkeds = 0;
        score = 0;
        scoreIncrement = 5*(this.level.getLevel());
        this.lists = new AnimationList();
        minimumDestroyCount = 3;
        for(int i = 0; i < matrixSize; i++){
            for(int j = 0; j < matrixSize; j++){
                list[i][j] = new BookCandy();
            }
        }
        rebuild();
    }
    
    public void setDifficulty(int difficulty){
        if( ( difficulty < 3 ) || ( difficulty > matrixSize ) )
            return;
        scoreIncrement = (difficulty-2)*5*(this.level.getLevel());
    }
    
    public void rebuild(){ 
        //lists.removeAll();
        fillBooks(0);
        lists.add(getSystemCall());
        while(traverselyMarkedBooks() != 0){
            lists.add(getSystemCall());
            fall(0);
            lists.add(getSystemCall());
            int temp = destroyTraversally();
            fillBooks(temp);
            lists.add(getSystemCall());
        }
    }
    
    public void reconstruct(int minimumDestroyCount){
        if( ( minimumDestroyCount < 3 ) || ( minimumDestroyCount > matrixSize ) )
            return;
        this.minimumDestroyCount = minimumDestroyCount;
    }
    private boolean notInclude(int x, int arr[]){
        boolean result = true;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == x)
                result = false;
        }
        return result;
    }
    public void fillBooks(int specialBookCount){
        if(specialBookCount == 0 )
            return;
        int count = 10;
        int specialBook = 0;
        if( specialBookCount >= 10 )
            specialBook = specialBookCount/10;
        int specialBookPositions[] = new int[specialBook];
        if( specialBook != 0 ){
            int counter1 = 0;
            int temp = (int)(Math.random() *specialBookCount  + 1);
            while( counter1 != specialBook ){
                if( notInclude( temp, specialBookPositions ) )
                    specialBookPositions[counter1++] = temp;
                else
                    temp = (int)(Math.random() *specialBookCount  + 1);
            }
        }
        int index = 0;
        int counter = 0;
        BookCandy temp = new BookCandy();
        for(int i = 0; i < matrixSize; i++){
            for(int j = 0; j < matrixSize; j++){
                if( ( list[i][j].getType() ).equals( temp.getType()) ){
                    list[i][j] = randomBookGenerator();
                    if( index < specialBookPositions.length && specialBookPositions[index] == counter){
                        list[i][j].setTypeBarDirectly();
                        index++;
                    }
                    counter++;
                }
                else
                    if(--count == 0)
                        break;
            }
            count = 10;
        }
    }
    public BookCandy randomBookGenerator(){
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

    private int markedBooks(int x,int y){
        int countx = x;
        int countxx = 1;
        int county = y;
        int countyy = 1;
        while(( countx+1 < matrixSize ) && (list[countx][y].getType().equals(list[++countx][y].getType())) )
            countxx++;
        while(( county+1 < matrixSize ) && (list[x][county].getType().equals(list[x][++county].getType())) ){
            countyy++;
        }
        int result = 0;   
        if(countxx > minimumDestroyCount-1){
            result += countxx-1;
            for(int i = 0; i < countxx; i++)
                list[x+i][y].setMarked(true);
        }
        if(countyy > minimumDestroyCount-1){
            result += countyy-1;
            for(int i = 0; i < countyy; i++)
                list[x][y+i].setMarked(true);
        }
        return result;
    }
    
    public int traverselyMarkedBooks(){
        int sum = 0;
        for(int i = 0; i < matrixSize; i++){
            for(int j = 0; j < matrixSize; j++){
                //if(!(list[i][j].getMarked()))
                    sum += markedBooks(i,j);
            }
        }
        if(sum != 0)
            (new SoundManager()).playDestroy();
        return sum;
    }
    
    public int destroyTraversally(){
        int sum = 0;
        for(int i = 0; i < matrixSize; i++){
            for(int j = 0; j < matrixSize; j++){
                if(list[i][j].getMarked()){
                    list[i][j] = new BookCandy();
                    sum++;
                    score = score+scoreIncrement;
                }
            }
        }
        return sum;
    }
    public void destroySpecialBook(int x, int y){
        if(list[x][y].getTypeBar().equals("horizontal")){
            if(this.level.getMovement()!= 0){
                for(int i = 0; i < matrixSize; i++){
                    list[x][i].setMarked(true);
                }
                fall(0);
                for(int i = 0; i < matrixSize; i++){
                    list[0][i] = new BookCandy();
                }
                lists.removeAll();
                fillBooks(0);
                lists.add(list);
                rebuild();
                level.setMovement(level.getMovement()-1);
            }
        }
        else if(list[x][y].getTypeBar().equals("vertical")){
            if(this.level.getMovement()!= 0){
                for(int i = 0; i < matrixSize; i++){
                    list[i][y] = new BookCandy();
                }
                fillBooks(0);
                rebuild();
                level.setMovement(level.getMovement()-1);
            }
        }
    }
    public void fall(int y){
        if(y == matrixSize)
            return;
        int i = matrixSize-1;
        int count = 0;
        while (i >= 0){
            if(list[i][y].getMarked())
                count++;
            i--;
        }
        int countCounter = 0;
        i = matrixSize-1;
        int counTemp = 0;
        while( ( count != 0 ) && ( countCounter != count) && (i >= 0)  ){
            countCounter = 0;
            if(list[i][y].getMarked()){
                counTemp = i;
                while((counTemp != countCounter) && (counTemp != 0)){
                    BookCandy temp = list[counTemp][y];
                    list[counTemp][y] = list[counTemp-1][y];
                    list[counTemp-1][y] = temp;
                    counTemp--;
                }
                countCounter++;
            }
            i--;
        }
        fall(y+1); 
    }
    public BookCandy[][] getSystemCall(){
        return list;
    }
    public AnimationNode swap(int x1,int y1, int x2,int y2){
        if( (x1<0|| y1<0||x2<0||y2<0) || ( x1>=matrixSize || y1>=matrixSize || x2>=matrixSize || y2>=matrixSize ) )
            return null;
        if(this.level.getMovement()!= 0){
            (new SoundManager()).playSwap();
            BookCandy temp = list[x1][y1];
            list[x1][y1] = list[x2][y2];
            list[x2][y2] = temp;
            lists.removeAll();
            rebuild();
            level.setMovement(level.getMovement()-1);
        }
        else
            (new SoundManager()).playEnd();
        return lists.getFirst();
    }
    public void PowerUpAltay(){
        if(this.level.getMovement()!= 0){
            lists.removeAll();
            BookCandy[][] temp = new Altay(list).PowerUpAltay();
            if( temp != null ){
                list = temp;
                lists.add(list);
                score = score-100;
                rebuild();
            }
        }
    }
    public void PowerUpWilliam(int positionX, int positionY){
        if(this.level.getMovement()!= 0){
            lists.removeAll();
            BookCandy[][] temp  =   new William(list).PowerUpWilliam(positionX, positionY);
            if( temp != null ){
                list = temp;
                lists.add(list);
                score = score-90;
                rebuild();
            }
        }
    }
    public void PowerUpRobin(int positionX, int positionY){
        if(this.level.getMovement()!= 0){
            lists.removeAll();
            BookCandy[][] temp  =  (new Robin(list)).PowerUpRobin(positionX, positionY);
            if( temp != null ){
                list = temp;
                lists.add(list);
                score = score-50;
                rebuild();
            }
        }
    }
    public void PowerUpOzcan(int positionX, int positionY){
        if(this.level.getMovement()!= 0){
            lists.removeAll();
            BookCandy[][] temp = new Ozcan(list).PowerUpOzcan(positionX, positionY);
            if( temp != null ){
                list = temp;
                lists.add(list);
                score = score-50;
                rebuild();
            }
        }
    }
    public void PowerUpEray(int positionX, int positionY,int positionX2, int positionY2){
        if(this.level.getMovement()!= 0){
            lists.removeAll();
            BookCandy[][] temp = new Eray(list).PowerUpEray(positionX, positionY, positionX2, positionY2);
            if( temp != null ){
                list = temp;
                lists.add(list);
                score = score-70;
                rebuild();
            }
        }
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
    
    public int getMovement()
    {
        return level.getMovement();
    }
}
