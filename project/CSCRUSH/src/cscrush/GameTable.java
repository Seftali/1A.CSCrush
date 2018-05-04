/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cscrush;

import cscrush.AnimationList.AnimationNode;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Timer;

/**
 *
 * @author tendoushuu
 */
public class GameTable extends javax.swing.JPanel {

    private BookCandy[][] tableObjects;
    private Image[] bookImages;
    private String[] dirBookImages;
    private int pressedX, pressedY;
    private boolean fadeCandies;
    private boolean fallCandies;
    private int fadeSize;
    private int maxFallSize;
    private int checkFall, wait;
    private int[][] fallMark, fadeMark, fallSize;
    private AnimationNode cur;
    
    /**
     * Creates new form GameTable
     */
    public GameTable() {
        initComponents();
        
        fadeCandies = false;
        fallCandies = false;
        fadeSize = 1;
        maxFallSize = 0;
        checkFall = 1;
        cur = null;
        wait = 500;
        fallSize = new int[10][10];
        
        
        Timer timer = new Timer(20, (ActionEvent e) -> {
            
            
            if ( wait >= 50 && fallCandies )
            {
                validate();
                repaint();
                checkFall++;
                if (checkFall >= maxFallSize * 50)
                {
                    maxFallSize = 0;
                    checkFall = 1;
                    
                    if ( cur.next != null)
                    {
                        wait = 1;
                        cur = cur.next;
                        fadeCandies = true;
                        fallCandies = false;               
                        
                    }
                    else
                    {
                        fadeCandies = false;
                        fallCandies = false;
                        
                        tableObjects = cur.newBookCandy;
                        validate();
                        repaint();
                        
                        
                        
                    }
                }
            }
            else if ( wait >= 50 && fadeCandies )
            {
                if ( fadeSize == 1)
                {
                    fadeSize = 50;
                    fadeMark = cur.marked;
                    tableObjects = cur.oldBookCandy;
                    fallMark = cur.fall;
                    
                    for ( int i = 0; i < 10; i++)
                    {
                        for ( int j = 0; j < 10; j++)
                        {
                            fallSize[i][j] = 1;
                            if ( fallMark[i][j] >= maxFallSize)
                            {
                                maxFallSize = fallMark[i][j];
                            }
                        }
                    }
                    
                   
                }
                
                validate();
                repaint();
                fadeSize--;
                if (fadeSize == 1)
                {
                    fadeCandies = false;
                    fallCandies = true;
                    checkFall = 1;
                }
            }
            else if ( fallCandies || fadeCandies)
            {
                wait++;
            }
            
        });

        timer.start();
        
        bookImages = new Image[16];
        dirBookImages = new String[16];
        dirBookImages[0] = "src/img/cs102.jpg";
        dirBookImages[1] = "src/img/cs102Vertical.jpg";
        dirBookImages[2] = "src/img/cs102Horizontal.jpg";
        dirBookImages[3] = "src/img/cs201.jpg";
        dirBookImages[4] = "src/img/cs201Vertical.jpg";
        dirBookImages[5] = "src/img/cs201Horizontal.jpg";
        dirBookImages[6] = "src/img/cs224.jpg";
        dirBookImages[7] = "src/img/cs224Vertical.jpg";
        dirBookImages[8] = "src/img/cs224Horizontal.jpg";
        dirBookImages[9] = "src/img/cs342.jpg";
        dirBookImages[10] = "src/img/cs342Vertical.jpg";
        dirBookImages[11] = "src/img/cs342Horizontal.jpg";
        dirBookImages[12] = "src/img/cs476.jpg";
        dirBookImages[13] = "src/img/cs476Vertical.jpg";
        dirBookImages[14] = "src/img/cs476Horizontal.jpg";
        dirBookImages[15] = "src/img/burn.jpg";
        try {
            bookImages[0] = ImageIO.read(new File(dirBookImages[0])).getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            bookImages[1] = ImageIO.read(new File(dirBookImages[1])).getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            bookImages[2] = ImageIO.read(new File(dirBookImages[2])).getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            bookImages[3] = ImageIO.read(new File(dirBookImages[3])).getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            bookImages[4] = ImageIO.read(new File(dirBookImages[4])).getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            bookImages[5] = ImageIO.read(new File(dirBookImages[5])).getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            bookImages[6] = ImageIO.read(new File(dirBookImages[6])).getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            bookImages[7] = ImageIO.read(new File(dirBookImages[7])).getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            bookImages[8] = ImageIO.read(new File(dirBookImages[8])).getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            bookImages[9] = ImageIO.read(new File(dirBookImages[9])).getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            bookImages[10] = ImageIO.read(new File(dirBookImages[10])).getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            bookImages[11] = ImageIO.read(new File(dirBookImages[11])).getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            bookImages[12] = ImageIO.read(new File(dirBookImages[12])).getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            bookImages[13] = ImageIO.read(new File(dirBookImages[13])).getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            bookImages[14] = ImageIO.read(new File(dirBookImages[14])).getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            bookImages[15] = ImageIO.read(new File(dirBookImages[15])).getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        } catch (IOException ex) {
            Logger.getLogger(GameTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
            
        if ( fadeCandies)
        {
            fade(g);
        }
        else if ( fallCandies)
        {
            fall(g);
        }
        else
        {
            drawAllAgain(g);
        }
        
    }
    
    private void fall(Graphics g)
    {
        int[] limit = new int[10];
        for (int i = 0; i < 10; i++)
        {
            int sizeColumn = 0;
            limit[i] = 0;
            for ( int j = 0; j < 10; j++)
            {
                if ( fallSize[j][i] > limit[i])
                {
                    limit[i] = fallSize[j][i];
                }
                if ( fadeMark[j][i] == 1)
                {
                    sizeColumn++;
                }
            }
            for (int j = 0; j < 10; j++)
            {  
                BookCandy temp = tableObjects[j][i];
                if ( fadeMark[j][i] == 0 && fallMark[j][i] == 0)
                {
                    if ( temp.getType().equals("Cs102") && temp.getTypeBar().equals("normal"))
                    {
                        g.drawImage(bookImages[0],i*50,j*50,null);
                    }
                    else if ( temp.getType().equals("Cs102") && temp.getTypeBar().equals("vertical"))
                    {
                        g.drawImage(bookImages[1],i*50,j*50,null);
                    }
                    else if ( temp.getType().equals("Cs102") && temp.getTypeBar().equals("horizontal"))
                    {
                        g.drawImage(bookImages[2],i*50,j*50,null);
                    }
                    else if ( temp.getType().equals("Cs201") && temp.getTypeBar().equals("normal"))
                    {
                        g.drawImage(bookImages[3],i*50,j*50,null);
                    }
                    else if ( temp.getType().equals("Cs201") && temp.getTypeBar().equals("vertical"))
                    {
                        g.drawImage(bookImages[4],i*50,j*50,null);
                    }
                    else if ( temp.getType().equals("Cs201") && temp.getTypeBar().equals("horizontal"))
                    {
                        g.drawImage(bookImages[5],i*50,j*50,null);
                    }
                    else if ( temp.getType().equals("Cs224") && temp.getTypeBar().equals("normal"))
                    {
                        g.drawImage(bookImages[6],i*50,j*50,null);
                    }
                    else if ( temp.getType().equals("Cs224") && temp.getTypeBar().equals("vertical"))
                    {
                        g.drawImage(bookImages[7],i*50,j*50,null);
                    }
                    else if ( temp.getType().equals("Cs224") && temp.getTypeBar().equals("horizontal"))
                    {
                        g.drawImage(bookImages[8],i*50,j*50,null);
                    }
                    else if ( temp.getType().equals("Cs342") && temp.getTypeBar().equals("normal"))
                    {
                        g.drawImage(bookImages[9],i*50,j*50,null);
                    }
                    else if ( temp.getType().equals("Cs342") && temp.getTypeBar().equals("vertical"))
                    {
                        g.drawImage(bookImages[10],i*50,j*50,null);
                    }
                    else if ( temp.getType().equals("Cs342") && temp.getTypeBar().equals("horizontal"))
                    {
                        g.drawImage(bookImages[11],i*50,j*50,null);
                    }
                    else if ( temp.getType().equals("Cs476") && temp.getTypeBar().equals("normal"))
                    {
                        g.drawImage(bookImages[12],i*50,j*50,null);
                    }
                    else if ( temp.getType().equals("Cs476") && temp.getTypeBar().equals("vertical"))
                    {
                        g.drawImage(bookImages[13],i*50,j*50,null);
                    }
                    else if ( temp.getType().equals("Cs476") && temp.getTypeBar().equals("horizontal"))
                    {
                        g.drawImage(bookImages[14],i*50,j*50,null);
                    }
                    else {
                        g.drawImage(bookImages[15],i*50,j*50,null);
                    }
                }
                else if (fadeMark[j][i] == 0 && fallMark[j][i] != 0)
                {
                    if ( temp.getType().equals("Cs102") && temp.getTypeBar().equals("normal"))
                    {
                        g.drawImage(bookImages[0],i*50,j*50 + fallSize[j][i],null);
                    }
                    else if ( temp.getType().equals("Cs102") && temp.getTypeBar().equals("vertical"))
                    {
                        g.drawImage(bookImages[1],i*50,j*50 + fallSize[j][i],null);
                    }
                    else if ( temp.getType().equals("Cs102") && temp.getTypeBar().equals("horizontal"))
                    {
                        g.drawImage(bookImages[2],i*50,j*50 + fallSize[j][i],null);
                    }
                    else if ( temp.getType().equals("Cs201") && temp.getTypeBar().equals("normal"))
                    {
                        g.drawImage(bookImages[3],i*50,j*50 + fallSize[j][i],null);
                    }
                    else if ( temp.getType().equals("Cs201") && temp.getTypeBar().equals("vertical"))
                    {
                        g.drawImage(bookImages[4],i*50,j*50 + fallSize[j][i],null);
                    }
                    else if ( temp.getType().equals("Cs201") && temp.getTypeBar().equals("horizontal"))
                    {
                        g.drawImage(bookImages[5],i*50,j*50 + fallSize[j][i],null);
                    }
                    else if ( temp.getType().equals("Cs224") && temp.getTypeBar().equals("normal"))
                    {
                        g.drawImage(bookImages[6],i*50,j*50 + fallSize[j][i],null);
                    }
                    else if ( temp.getType().equals("Cs224") && temp.getTypeBar().equals("vertical"))
                    {
                        g.drawImage(bookImages[7],i*50,j*50 + fallSize[j][i],null);
                    }
                    else if ( temp.getType().equals("Cs224") && temp.getTypeBar().equals("horizontal"))
                    {
                        g.drawImage(bookImages[8],i*50,j*50 + fallSize[j][i],null);
                    }
                    else if ( temp.getType().equals("Cs342") && temp.getTypeBar().equals("normal"))
                    {
                        g.drawImage(bookImages[9],i*50,j*50 + fallSize[j][i],null);
                    }
                    else if ( temp.getType().equals("Cs342") && temp.getTypeBar().equals("vertical"))
                    {
                        g.drawImage(bookImages[10],i*50,j*50 + fallSize[j][i],null);
                    }
                    else if ( temp.getType().equals("Cs342") && temp.getTypeBar().equals("horizontal"))
                    {
                        g.drawImage(bookImages[11],i*50,j*50 + fallSize[j][i],null);
                    }
                    else if ( temp.getType().equals("Cs476") && temp.getTypeBar().equals("normal"))
                    {
                        g.drawImage(bookImages[12],i*50,j*50 + fallSize[j][i],null);
                    }
                    else if ( temp.getType().equals("Cs476") && temp.getTypeBar().equals("vertical"))
                    {
                        g.drawImage(bookImages[13],i*50,j*50 + fallSize[j][i],null);
                    }
                    else if ( temp.getType().equals("Cs476") && temp.getTypeBar().equals("horizontal"))
                    {
                        g.drawImage(bookImages[14],i*50,j*50 + fallSize[j][i],null);
                    }
                    else 
                    {
                        g.drawImage(bookImages[15],i*50,j*50 + fallSize[j][i],null);
                    }
                    
                    if ( fallMark[j][i] * 50 > fallSize[j][i])
                    {
                        fallSize[j][i]++;
                    }
                }
                else
                {
                    for ( int m = 1; m < limit[i] / 50 + 1; m++)
                    {
                        BookCandy temp2 = cur.newBookCandy[sizeColumn - m][i];
                        if ( temp2.getType().equals("Cs102") && temp2.getTypeBar().equals("normal"))
                        {
                            g.drawImage(bookImages[0], i*50, limit[i] - 50 * m,null);
                        }
                        else if ( temp2.getType().equals("Cs102") && temp2.getTypeBar().equals("vertical"))
                        {
                            g.drawImage(bookImages[1],i*50, limit[i] - 50 * m,null);
                        }
                        else if ( temp2.getType().equals("Cs102") && temp2.getTypeBar().equals("horizontal"))
                        {
                            g.drawImage(bookImages[2],i*50, limit[i] - 50 * m,null);
                        }
                        else if ( temp2.getType().equals("Cs201") && temp2.getTypeBar().equals("normal"))
                        {
                            g.drawImage(bookImages[3],i*50, limit[i] - 50 * m,null);
                        }
                        else if ( temp2.getType().equals("Cs201") && temp2.getTypeBar().equals("vertical"))
                        {
                            g.drawImage(bookImages[4],i*50, limit[i] - 50 * m,null);
                        }
                        else if ( temp2.getType().equals("Cs201") && temp2.getTypeBar().equals("horizontal"))
                        {
                            g.drawImage(bookImages[5],i*50, limit[i] - 50 * m,null);
                        }
                        else if ( temp2.getType().equals("Cs224") && temp2.getTypeBar().equals("normal"))
                        {
                            g.drawImage(bookImages[6],i*50, limit[i] - 50 * m,null);
                        }
                        else if ( temp2.getType().equals("Cs224") && temp2.getTypeBar().equals("vertical"))
                        {
                            g.drawImage(bookImages[7],i*50, limit[i] - 50 * m,null);
                        }
                        else if ( temp2.getType().equals("Cs224") && temp2.getTypeBar().equals("horizontal"))
                        {
                            g.drawImage(bookImages[8],i*50, limit[i] - 50 * m,null);
                        }
                        else if ( temp2.getType().equals("Cs342") && temp2.getTypeBar().equals("normal"))
                        {
                            g.drawImage(bookImages[9],i*50, limit[i] - 50 * m,null);
                        }
                        else if ( temp2.getType().equals("Cs342") && temp2.getTypeBar().equals("vertical"))
                        {
                            g.drawImage(bookImages[10],i*50, limit[i] - 50 * m,null);
                        }
                        else if ( temp2.getType().equals("Cs342") && temp2.getTypeBar().equals("horizontal"))
                        {
                            g.drawImage(bookImages[11],i*50, limit[i] - 50 * m,null);
                        }
                        else if ( temp2.getType().equals("Cs476") && temp2.getTypeBar().equals("normal"))
                        {
                            g.drawImage(bookImages[12],i*50, limit[i] - 50 * m,null);
                        }
                        else if ( temp2.getType().equals("Cs476") && temp2.getTypeBar().equals("vertical"))
                        {
                            g.drawImage(bookImages[13],i*50, limit[i] - 50 * m,null);
                        }
                        else if ( temp2.getType().equals("Cs476") && temp2.getTypeBar().equals("horizontal"))
                        {
                            g.drawImage(bookImages[14],i*50, limit[i] - 50 * m,null);
                        }
                        else 
                        {
                            g.drawImage(bookImages[15],i*50, limit[i] - 50 * m,null);
                        }
                    }
                }
                
            }
                
                
        }
        
        
    }
    
    private void fade(Graphics g)
    {   
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++)
            {  
                BookCandy temp = tableObjects[j][i];
                if ( fadeMark[j][i] == 0)
                {
                    if ( temp.getType().equals("Cs102") && temp.getTypeBar().equals("normal"))
                    {
                        g.drawImage(bookImages[0],i*50,j*50,null);
                    }
                    else if ( temp.getType().equals("Cs102") && temp.getTypeBar().equals("vertical"))
                    {
                        g.drawImage(bookImages[1],i*50,j*50,null);
                    }
                    else if ( temp.getType().equals("Cs102") && temp.getTypeBar().equals("horizontal"))
                    {
                        g.drawImage(bookImages[2],i*50,j*50,null);
                    }
                    else if ( temp.getType().equals("Cs201") && temp.getTypeBar().equals("normal"))
                    {
                        g.drawImage(bookImages[3],i*50,j*50,null);
                    }
                    else if ( temp.getType().equals("Cs201") && temp.getTypeBar().equals("vertical"))
                    {
                        g.drawImage(bookImages[4],i*50,j*50,null);
                    }
                    else if ( temp.getType().equals("Cs201") && temp.getTypeBar().equals("horizontal"))
                    {
                        g.drawImage(bookImages[5],i*50,j*50,null);
                    }
                    else if ( temp.getType().equals("Cs224") && temp.getTypeBar().equals("normal"))
                    {
                        g.drawImage(bookImages[6],i*50,j*50,null);
                    }
                    else if ( temp.getType().equals("Cs224") && temp.getTypeBar().equals("vertical"))
                    {
                        g.drawImage(bookImages[7],i*50,j*50,null);
                    }
                    else if ( temp.getType().equals("Cs224") && temp.getTypeBar().equals("horizontal"))
                    {
                        g.drawImage(bookImages[8],i*50,j*50,null);
                    }
                    else if ( temp.getType().equals("Cs342") && temp.getTypeBar().equals("normal"))
                    {
                        g.drawImage(bookImages[9],i*50,j*50,null);
                    }
                    else if ( temp.getType().equals("Cs342") && temp.getTypeBar().equals("vertical"))
                    {
                        g.drawImage(bookImages[10],i*50,j*50,null);
                    }
                    else if ( temp.getType().equals("Cs342") && temp.getTypeBar().equals("horizontal"))
                    {
                        g.drawImage(bookImages[11],i*50,j*50,null);
                    }
                    else if ( temp.getType().equals("Cs476") && temp.getTypeBar().equals("normal"))
                    {
                        g.drawImage(bookImages[12],i*50,j*50,null);
                    }
                    else if ( temp.getType().equals("Cs476") && temp.getTypeBar().equals("vertical"))
                    {
                        g.drawImage(bookImages[13],i*50,j*50,null);
                    }
                    else if ( temp.getType().equals("Cs476") && temp.getTypeBar().equals("horizontal"))
                    {
                        g.drawImage(bookImages[14],i*50,j*50,null);
                    }
                    else {
                        g.drawImage(bookImages[15],i*50,j*50,null);
                    }
                }
                else 
                {
                    if ( temp.getType().equals("Cs102") && temp.getTypeBar().equals("normal"))
                    {
                        g.drawImage(bookImages[0].getScaledInstance(fadeSize, fadeSize, Image.SCALE_FAST),i*50 + (50-fadeSize)/2,j*50 + (50-fadeSize)/2,null);
                    }
                    else if ( temp.getType().equals("Cs102") && temp.getTypeBar().equals("vertical"))
                    {
                        g.drawImage(bookImages[1].getScaledInstance(fadeSize, fadeSize, Image.SCALE_FAST),i*50 + (50-fadeSize)/2,j*50 + (50-fadeSize)/2,null);
                    }
                    else if ( temp.getType().equals("Cs102") && temp.getTypeBar().equals("horizontal"))
                    {
                        g.drawImage(bookImages[2].getScaledInstance(fadeSize, fadeSize, Image.SCALE_FAST),i*50 + (50-fadeSize)/2,j*50 + (50-fadeSize)/2,null);
                    }
                    else if ( temp.getType().equals("Cs201") && temp.getTypeBar().equals("normal"))
                    {
                        g.drawImage(bookImages[3].getScaledInstance(fadeSize, fadeSize, Image.SCALE_FAST),i*50 + (50-fadeSize)/2,j*50 + (50-fadeSize)/2,null);
                    }
                    else if ( temp.getType().equals("Cs201") && temp.getTypeBar().equals("vertical"))
                    {
                        g.drawImage(bookImages[4].getScaledInstance(fadeSize, fadeSize, Image.SCALE_FAST),i*50 + (50-fadeSize)/2,j*50 + (50-fadeSize)/2,null);
                    }
                    else if ( temp.getType().equals("Cs201") && temp.getTypeBar().equals("horizontal"))
                    {
                        g.drawImage(bookImages[5].getScaledInstance(fadeSize, fadeSize, Image.SCALE_FAST),i*50 + (50-fadeSize)/2,j*50 + (50-fadeSize)/2,null);
                    }
                    else if ( temp.getType().equals("Cs224") && temp.getTypeBar().equals("normal"))
                    {
                        g.drawImage(bookImages[6].getScaledInstance(fadeSize, fadeSize, Image.SCALE_FAST),i*50 + (50-fadeSize)/2,j*50 + (50-fadeSize)/2,null);
                    }
                    else if ( temp.getType().equals("Cs224") && temp.getTypeBar().equals("vertical"))
                    {
                        g.drawImage(bookImages[7].getScaledInstance(fadeSize, fadeSize, Image.SCALE_FAST),i*50 + (50-fadeSize)/2,j*50 + (50-fadeSize)/2,null);
                    }
                    else if ( temp.getType().equals("Cs224") && temp.getTypeBar().equals("horizontal"))
                    {
                        g.drawImage(bookImages[8].getScaledInstance(fadeSize, fadeSize, Image.SCALE_FAST),i*50 + (50-fadeSize)/2,j*50 + (50-fadeSize)/2,null);
                    }
                    else if ( temp.getType().equals("Cs342") && temp.getTypeBar().equals("normal"))
                    {
                        g.drawImage(bookImages[9].getScaledInstance(fadeSize, fadeSize, Image.SCALE_FAST),i*50 + (50-fadeSize)/2,j*50 + (50-fadeSize)/2,null);
                    }
                    else if ( temp.getType().equals("Cs342") && temp.getTypeBar().equals("vertical"))
                    {
                        g.drawImage(bookImages[10].getScaledInstance(fadeSize, fadeSize, Image.SCALE_FAST),i*50 + (50-fadeSize)/2,j*50 + (50-fadeSize)/2,null);
                    }
                    else if ( temp.getType().equals("Cs342") && temp.getTypeBar().equals("horizontal"))
                    {
                        g.drawImage(bookImages[11].getScaledInstance(fadeSize, fadeSize, Image.SCALE_FAST),i*50 + (50-fadeSize)/2,j*50 + (50-fadeSize)/2,null);
                    }
                    else if ( temp.getType().equals("Cs476") && temp.getTypeBar().equals("normal"))
                    {
                        g.drawImage(bookImages[12].getScaledInstance(fadeSize, fadeSize, Image.SCALE_FAST),i*50 + (50-fadeSize)/2,j*50 + (50-fadeSize)/2,null);
                    }
                    else if ( temp.getType().equals("Cs476") && temp.getTypeBar().equals("vertical"))
                    {
                        g.drawImage(bookImages[13].getScaledInstance(fadeSize, fadeSize, Image.SCALE_FAST),i*50 + (50-fadeSize)/2,j*50 + (50-fadeSize)/2,null);
                    }
                    else if ( temp.getType().equals("Cs476") && temp.getTypeBar().equals("horizontal"))
                    {
                        g.drawImage(bookImages[14].getScaledInstance(fadeSize, fadeSize, Image.SCALE_FAST),i*50 + (50-fadeSize)/2,j*50 + (50-fadeSize)/2,null);
                    }
                    else {
                        g.drawImage(bookImages[15].getScaledInstance(fadeSize, fadeSize, Image.SCALE_FAST),i*50 + (50-fadeSize)/2,j*50 + (50-fadeSize)/2,null);
                    }
                   
                }
            }
         
    }
    
    private void drawAllAgain(Graphics g)
    {
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++)
            {  
                BookCandy temp = tableObjects[j][i];
                if ( temp.getType().equals("Cs102") && temp.getTypeBar().equals("normal"))
                {
                    g.drawImage(bookImages[0],i*50,j*50,null);
                }
                else if ( temp.getType().equals("Cs102") && temp.getTypeBar().equals("vertical"))
                {
                    g.drawImage(bookImages[1],i*50,j*50,null);
                }
                else if ( temp.getType().equals("Cs102") && temp.getTypeBar().equals("horizontal"))
                {
                    g.drawImage(bookImages[2],i*50,j*50,null);
                }
                else if ( temp.getType().equals("Cs201") && temp.getTypeBar().equals("normal"))
                {
                    g.drawImage(bookImages[3],i*50,j*50,null);
                }
                else if ( temp.getType().equals("Cs201") && temp.getTypeBar().equals("vertical"))
                {
                    g.drawImage(bookImages[4],i*50,j*50,null);
                }
                else if ( temp.getType().equals("Cs201") && temp.getTypeBar().equals("horizontal"))
                {
                    g.drawImage(bookImages[5],i*50,j*50,null);
                }
                else if ( temp.getType().equals("Cs224") && temp.getTypeBar().equals("normal"))
                {
                    g.drawImage(bookImages[6],i*50,j*50,null);
                }
                else if ( temp.getType().equals("Cs224") && temp.getTypeBar().equals("vertical"))
                {
                    g.drawImage(bookImages[7],i*50,j*50,null);
                }
                else if ( temp.getType().equals("Cs224") && temp.getTypeBar().equals("horizontal"))
                {
                    g.drawImage(bookImages[8],i*50,j*50,null);
                }
                else if ( temp.getType().equals("Cs342") && temp.getTypeBar().equals("normal"))
                {
                    g.drawImage(bookImages[9],i*50,j*50,null);
                }
                else if ( temp.getType().equals("Cs342") && temp.getTypeBar().equals("vertical"))
                {
                    g.drawImage(bookImages[10],i*50,j*50,null);
                }
                else if ( temp.getType().equals("Cs342") && temp.getTypeBar().equals("horizontal"))
                {
                    g.drawImage(bookImages[11],i*50,j*50,null);
                }
                else if ( temp.getType().equals("Cs476") && temp.getTypeBar().equals("normal"))
                {
                    g.drawImage(bookImages[12],i*50,j*50,null);
                }
                else if ( temp.getType().equals("Cs476") && temp.getTypeBar().equals("vertical"))
                {
                    g.drawImage(bookImages[13],i*50,j*50,null);
                }
                else if ( temp.getType().equals("Cs476") && temp.getTypeBar().equals("horizontal"))
                {
                    g.drawImage(bookImages[14],i*50,j*50,null);
                }
                else 
                {
                    g.drawImage(bookImages[15],i*50,j*50,null);
                }
            }
    }
    
    public void setTableObjects(BookCandy[][] tableObjects)
    {
        fadeCandies = false;  
        fallCandies = false;
        this.tableObjects = tableObjects;
        validate();
        repaint();
    }
    
    public void startAnimation(AnimationNode head)
    {
        cur = head;
        if ( cur != null)
        {
            fadeCandies = true;
            fallCandies = false;
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(500, 500));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed

        pressedX = evt.getX();
        pressedY = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        // TODO add your handling code here:
        int x,y;
        x = evt.getX();
        y = evt.getY();
        if ( fallCandies == false && fadeCandies == false)
        {
        if (x > pressedX && y > pressedY && x - pressedX > y - pressedY)
        {
            //swiping right
            GUIManager.manager.swapBooks(pressedX/50, pressedY/50, pressedX/50 + 1, pressedY/50);
        }
        else if (x > pressedX && y > pressedY && x - pressedX < y - pressedY)
        {
            //swiping down
            GUIManager.manager.swapBooks(pressedX/50, pressedY/50, pressedX/50, pressedY/50 + 1);
        }
        else if (x < pressedX && y > pressedY && pressedX - x > y - pressedY)
        {
            //swiping left
            GUIManager.manager.swapBooks(pressedX/50, pressedY/50, pressedX/50 - 1, pressedY/50);
        }
        else if (x < pressedX && y > pressedY && pressedX - x < y - pressedY)
        {
            //swiping down
            GUIManager.manager.swapBooks(pressedX/50, pressedY/50, pressedX/50, pressedY/50 + 1);
        }        
        else if (x > pressedX && y < pressedY && x - pressedX > pressedY - y)
        {
            //swiping right
            GUIManager.manager.swapBooks(pressedX/50, pressedY/50, pressedX/50 + 1, pressedY/50);
        }
        else if (x > pressedX && y < pressedY && x - pressedX < pressedY - y)
        {
            //swiping up
            GUIManager.manager.swapBooks(pressedX/50, pressedY/50, pressedX/50, pressedY/50 - 1);
        }       
        else if (x < pressedX && y < pressedY && pressedX - x > pressedY - y)
        {
            //swiping left
            GUIManager.manager.swapBooks(pressedX/50, pressedY/50, pressedX/50 - 1, pressedY/50);
        }        
        else if (x < pressedX && y < pressedY && pressedX - x < pressedY - y)
        {
            //swiping up
            GUIManager.manager.swapBooks(pressedX/50, pressedY/50, pressedX/50, pressedY/50 - 1);
        }
        }
        
    }//GEN-LAST:event_formMouseReleased

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
                // TODO add your handling code here:
        int X = evt.getX();
        int Y = evt.getY();
       // GUIManager.manager.destroySpecialBooks(X/50, Y/50);
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}