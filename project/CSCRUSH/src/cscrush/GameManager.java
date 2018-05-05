package cscrush;

import cscrush.AnimationList.AnimationNode;



/*
 * @description: This class implements the logic part of the game.This class controls the game ,
 * logically according to the level. Score, number of movements, minimum destroy number
 * and animations are executed. 
 * @author Eren Ayture
 *  @property: BookCandy[][] list;
    @property: Level level;
    @property: final int matrixSize = 10;
    @property: int score;
    @property: int scoreIncrement;
    @property: int numberofMarkeds;
    @property: int minimumDestroyCount;
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
    
    public void removeList()
    {
        lists.removeAll();
    }
    
    public Level getLevel()
    {
        return level;
    }
    
    public void setDifficulty(int difficulty){
        if( ( difficulty < 3 ) || ( difficulty > matrixSize ) )
            return;
        scoreIncrement = (difficulty-2)*5*(this.level.getLevel());
    }
    /*
    @param: BookCandy[][] temp , take a list 
    @return: marked 2d int array as 0's and 1's,
    takes a list  and creates 2d int array to represent marked or not  
    */
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
    /*
    @return void
    @see traverselyMarkedBooks() returns how many book marked
    @see fall(int y); falls unmarked objects in the same order
    @see destroyTraversally() destroys marked books
    @see fillBooks(temp) fills books and updates special books
    this is a mutual recursive algorythim. after swap , special book destruction or powerups list is updated to inconsecutive state again 
    and animation list is added according to all positions
    */
    public void rebuild(){ 
        
        while(traverselyMarkedBooks() != 0){
            AnimationList.AnimationNode node = lists.new AnimationNode();
            node.next = null;
            
            
            node.oldBookCandy = copyList(list);
            node.marked = markedMatrix(list);
            node.fall = fallAnimate();
            
            fall(0);
            
            
            int temp = destroyTraversally();
            fillBooks(temp);

            
            node.newBookCandy = copyList(list);
            node.score = getScore();
            lists.add(node);
        }
    }
    /*
    @param: int minimumDestroyCount
    @return: void
    determines minimum or maximum  number of  consecutive permission
    */
    public void reconstruct(int minimumDestroyCount){
        if( ( minimumDestroyCount < 3 ) || ( minimumDestroyCount > matrixSize ) )//control
            return;
        this.minimumDestroyCount = minimumDestroyCount;
    }
    /*
    @param: int x object to be checked
    @param: int arr[] x in arr to be checked
    @return: boolean result 
    it cheks whether a x is in arr[]
    */
    private boolean notInclude(int x, int arr[]){
        boolean result = true;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == x)
                result = false;
        }
        return result;
    }
    /*
    @param int specialBookCount
    @return: void
    fillbooks according to destroy count. destroy count is more than 10 it gives one special book
    */
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
        }//special book places are determined randomly 
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
        }//books are added to the empty places
    }
    
    /*
    @see Math.random() create random number between 0 and 1
    @return BookCandy
    creates random objects with %20 possibilityas sub classes of BookCandy objects as CS102,CS201,CS224,CS342,CS476
    */
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
        /*
        @param: int x position x of list
        @param: int y position y of list
        @see: setMarked() markes objects true
        @see: getTypeBar() gets special objects
        @see: equals() checks speciality
        @return: result how many marking is done
        According to minimum destroy count minumum number of same consecutive objects are determined and marked true
        */
        private int markedBooks(int x,int y){
        int countx = x;
        int countxx = 1;
        int county = y;
        int countyy = 1;
        while(( countx+1 < matrixSize ) && (list[countx][y].getType().equals(list[++countx][y].getType())) )
            countxx++;
        while(( county+1 < matrixSize ) && (list[x][county].getType().equals(list[x][++county].getType())) ){
            countyy++;
        }//number of consecutives
        int result = 0;   
        if(countxx > minimumDestroyCount-1){
            result += countxx-1;
            for(int i = 0; i < countxx; i++){
                list[x+i][y].setMarked(true);
                if(list[x+i][y].getTypeBar().equals("vertical")){
                    for(int j = 0; j <  matrixSize; j++)
                        list[j][y].setMarked(true);
                }
                else if(list[x+i][y].getTypeBar().equals("horizontal")){
                    for(int j = 0; j <  matrixSize; j++)
                        list[x+i][j].setMarked(true);
                }
            }
        }//special books  and consecutives are marked in direction x
        if(countyy > minimumDestroyCount-1){
            result += countyy-1;
            for(int i = 0; i < countyy; i++){
                list[x][y+i].setMarked(true);
                if(list[x][y+i].getTypeBar().equals("vertical")){
                    for(int j = 0; j <  matrixSize; j++)
                        list[j][y+i].setMarked(true);
                }
                else if(list[x][y+i].getTypeBar().equals("horizontal")){
                    for(int j = 0; j <  matrixSize; j++)
                        list[x][j].setMarked(true);
                }
            } 
        }//special books  and consecutives are marked in direction y
        return result;
    }
    /*
    @see markedBooks()  mark objects according to each index
    @return: sum return how many marking is done
    traverse 2d array and consecutive same objects are marked according to the minimum destroy count
    */
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
    /*
    @return:int sum return how many destruction is done
    @see: markedBooks() marks objects
    travers array and marked objects are destroyed to become mother class BookCandy
    */
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
    /*
    @param: int x: Position x of a list
    @param: int y: Position y of a list
    @see: getMovement() gets remaining 
    @see: setMarked() sets true 
    @return: void
    test of distruction for special books 
    */
    public void destroySpecialBook(int x, int y){
        if(list[x][y].getTypeBar().equals("horizontal")){
            if(this.level.getMovement()!= 0){
                for(int i = 0; i < matrixSize; i++){
                    list[x][i].setMarked(true);
                }
                AnimationList.AnimationNode node = lists.new AnimationNode();
                node.next = null;
                node.oldBookCandy = copyList(list);
                node.marked = markedMatrix(list);
                node.fall = fallAnimate();
                fall(0);
                for(int i = 0; i < matrixSize; i++){
                    list[x][i] = new BookCandy();
                }
                fillBooks(0);
                node.newBookCandy = copyList(list);
                lists.add(node);
                rebuild();
                level.setMovement(level.getMovement()-1);
            }
        }
        else if(list[x][y].getTypeBar().equals("vertical")){
            if(this.level.getMovement()!= 0){
                for(int i = 0; i < matrixSize; i++){
                    list[i][y].setMarked(true);
                }
                AnimationList.AnimationNode node = lists.new AnimationNode();
                node.next = null;
                node.oldBookCandy = copyList(list);
                node.marked = markedMatrix(list);
                node.fall = fallAnimate();
                fillBooks(destroyTraversally());
                node.newBookCandy = copyList(list);
                lists.add(node);
                rebuild();
                level.setMovement(level.getMovement()-1);
            }
        }
    }
    /*
    @param: int y, column of list[x][y]
    @see: setMarkedTrue() sets true
    @return: void
    recursive algorythm, segregates marked objets to the begining of column and protects other objects order
    
    */
    public void fall(int y){
        if(y == matrixSize)
            return;
        BookCandy[] temp = new BookCandy[matrixSize];
        int fallCount = 0;
        for( int i = 0;  i < matrixSize; i++  ){
            temp[i]= list[i][y];
        }
        
        for( int i = 0;  i < matrixSize; i++  ){
            if(temp[i].getMarked())
                fallCount++;
        }
        
        for( int i = 0;  i < fallCount; i++  ){
            temp[i]= randomBookGenerator();
            temp[i].setMarked(true);
        }
        for( int i = 0;  i < matrixSize; i++  ){
            if( !( list[i][y].getMarked() ) )
                temp[fallCount++]= list[i][y];
        }
        for( int i = 0;  i < matrixSize; i++  ){
            list[i][y] = temp[i];
        }
        fall(y+1);
    }
    /*
    @see: getMarked() gets marked
    @return int[][] arr
    calculate all objects in the array and how many to fall and creates an array for this
    */
    public int[][] fallAnimate(){
        int arr[][] = new int[matrixSize][matrixSize];
        int count = 0;
        for(int i = 0; i < matrixSize; i++){
            for(int j = matrixSize-2; j>=0; j--){
                int temp = j;
                while( temp < matrixSize ){
                    if(list[temp++][i].getMarked()){
                        count++;
                    }
                }
                arr[j][i] = count;
                count = 0;
            }
        }
        
        return arr;
    }
    /*
    @return BookCandy[][] list
    returns list of an 2d array
    */
    public BookCandy[][] getSystemCall(){
        return list;
    }
    /*
    @param: int x1 list[x1][]
    @param: int y1 list[][y1]
    @param: int x2 list[x2][]
    @param: int y2 list[][y2]
    @see: getMovement() movement count
    @see: setMovement() decrement remaining movement with 1
    @see: rebuild() rebuild the table 
    @return: AnimationNode
    swap operation is made and than destruction and fill operations are made and each state Animationlist is updated. 
    */
    public AnimationNode swap(int x1,int y1, int x2,int y2){
        if( (x1<0|| y1<0||x2<0||y2<0) || ( x1>=matrixSize || y1>=matrixSize || x2>=matrixSize || y2>=matrixSize ) )//control
            return null;
        if(this.level.getMovement()!= 0)
        {
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
    /*
    @param BookCandy[][] list
    @return BookCandy[][] tempList
    coppies an array
    */
    public BookCandy[][] copyList( BookCandy[][] list)
    {
        BookCandy[][] tempList = new BookCandy[10][10];
        
        for ( int i = 0; i < 10; i++)
            for ( int j = 0; j < 10; j++)
            {
                tempList[i][j] = list[i][j];
            }
        
        return tempList;
    }
    /*
    @return: void
    sets five random objects in the table special book:
    */
    public void PowerUpAltay(){
        if(this.level.getMovement()!= 0){
            lists.removeAll();
            BookCandy[][] temp = new Altay(list).PowerUpAltay();
            if( temp != null ){
                list = temp;
            //    lists.add(list);
                score = score-100;
                lists.removeAll();
                rebuild();
            }
        }
    }
    /*
    @param: positionX list[positionX][]
    @param: positionY list[][positionY]
    @return: void
    destroys 3x3 matrix in the table
    */
    public void PowerUpWilliam(int positionX, int positionY){
        if(this.level.getMovement()!= 0){
            lists.removeAll();
            BookCandy[][] temp  =   new William(list).PowerUpWilliam(positionX, positionY);
            if( temp != null ){
                list = temp;
            //    lists.add(list);
                score = score-90;
                lists.removeAll();
                rebuild();
            }
        }
    }
    /*
    @param: positionX list[positionX][]
    @param: positionY list[][positionY]
    @return: void
    changes one object randomly
    */
    public void PowerUpRobin(int positionX, int positionY){
        if(this.level.getMovement()!= 0){
            lists.removeAll();
            BookCandy[][] temp  =  (new Robin(list)).PowerUpRobin(positionX, positionY);
            if( temp != null ){
                list = temp;
            //    lists.add(list);
                score = score-50;
                lists.removeAll();
                rebuild();
            }
        }
    }
    /*
    @param: int positionX
    @param: int positionY
    @return: void
    destroys 1 choosen object
    */
    public void PowerUpOzcan(int positionX, int positionY){
        if(this.level.getMovement()!= 0){
            lists.removeAll();
            BookCandy[][] temp = new Ozcan(list).PowerUpOzcan(positionX, positionY);
            if( temp != null ){
                list = temp;
               // lists.add(list);
                score = score-50;
                lists.removeAll();
                rebuild();
            }
        }
    }
    /*
    @param: int positionX list[positionX][]
    @param: int positionY list[][positionY]
    @param: int  positionX2 list[ positionX2][]
    @param: int positionY2 list[][positionY2]
    @see: getMovement() movement count
    @return: void
    swaps 2 objects in the list in anyplace
    */
    public void PowerUpEray(int positionX, int positionY,int positionX2, int positionY2){
        if(this.level.getMovement()!= 0){
            lists.removeAll();
            BookCandy[][] temp = new Eray(list).PowerUpEray(positionX, positionY, positionX2, positionY2);
            if( temp != null ){
                list = temp;
               // lists.add(list);
                score = score-70;
                lists.removeAll();
                rebuild();
            }
        }
    }
    /*
    @return void;
    display marked array
    */
    public void displayMarked(){
        for(int i = 0; i < matrixSize; i++){
            for(int j = 0; j < matrixSize; j++){
                System.out.print(list[i][j].getMarked()+ " ");
            }
            System.out.println("\n");
        }
    }
    /*
    @return: void
    displays tepe and speciality
    */
    public void displayType(){
        for(int i = 0; i < matrixSize; i++){
            for(int j = 0; j < matrixSize; j++){
                System.out.print(list[i][j].getType()+list[i][j].getTypeBar()+ " ");
            }
            System.out.println("\n");
        }
    }
    /*
    @return int score
    getter for score
    */
    public int getScore(){
        return score;
    }
    /*
    @param: int val
    @return: void
    sets score
    */
    public void setScore(int val){
        score = val;
    }
    /*
    @see getMovement()
    @return:int  movementcount
    getter for movement
    */
    public int getMovement()
    {
        return level.getMovement();
    }
}
