/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cscrush;

/**
 *
 * @author berka
 */
public class LevelPanel extends javax.swing.JPanel {

    /**
     * Creates new form LevelPanel
     */
    public LevelPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

<<<<<<< HEAD
        levelLable = new javax.swing.JLabel();
        level1Butt = new javax.swing.JButton();
        levelBack = new javax.swing.JButton();
        level2Butt = new javax.swing.JButton();
        level7Butt = new javax.swing.JButton();
        level3Butt = new javax.swing.JButton();
        Level4Butt = new javax.swing.JButton();
        level8Butt = new javax.swing.JButton();
        level5Butt = new javax.swing.JButton();
        Level6Butt = new javax.swing.JButton();
        level9Butt = new javax.swing.JButton();
        level10Butt = new javax.swing.JButton();
=======
        jLabel1 = new javax.swing.JLabel();
        level1Button = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        level2Button = new javax.swing.JButton();
        level7Button = new javax.swing.JButton();
        level3Button = new javax.swing.JButton();
        level4Button = new javax.swing.JButton();
        level8Button = new javax.swing.JButton();
        level5Button = new javax.swing.JButton();
        level6Button = new javax.swing.JButton();
        level9Button = new javax.swing.JButton();
        level10Button = new javax.swing.JButton();
>>>>>>> origin/master

        setBackground(new java.awt.Color(255, 255, 255));

        levelLable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        levelLable.setText("LEVELS");

<<<<<<< HEAD
        level1Butt.setText("LEVEL 1");
        level1Butt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level1ButtActionPerformed(evt);
            }
        });

        levelBack.setText("<< Back");
        levelBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                levelBackActionPerformed(evt);
            }
        });

        level2Butt.setText("LEVEL 2");

        level7Butt.setText("LEVEL 7");

        level3Butt.setText("LEVEL 3");

        Level4Butt.setText("LEVEL 4");

        level8Butt.setText("LEVEL 8");

        level5Butt.setText("LEVEL 5");

        Level6Butt.setText("LEVEL 6");

        level9Butt.setText("LEVEL 9");

        level10Butt.setText("LEVEL 10");
=======
        level1Button.setText("LEVEL 1");
        level1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level1ButtonActionPerformed(evt);
            }
        });

        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        level2Button.setText("LEVEL 2");
        level2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level2ButtonActionPerformed(evt);
            }
        });

        level7Button.setText("LEVEL 7");
        level7Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level7ButtonActionPerformed(evt);
            }
        });

        level3Button.setText("LEVEL 3");
        level3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level3ButtonActionPerformed(evt);
            }
        });

        level4Button.setText("LEVEL 4");
        level4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level4ButtonActionPerformed(evt);
            }
        });

        level8Button.setText("LEVEL 8");
        level8Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level8ButtonActionPerformed(evt);
            }
        });

        level5Button.setText("LEVEL 5");
        level5Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level5ButtonActionPerformed(evt);
            }
        });

        level6Button.setText("LEVEL 6");
        level6Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level6ButtonActionPerformed(evt);
            }
        });

        level9Button.setText("LEVEL 9");
        level9Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level9ButtonActionPerformed(evt);
            }
        });

        level10Button.setText("LEVEL 10");
        level10Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level10ButtonActionPerformed(evt);
            }
        });
>>>>>>> origin/master

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
<<<<<<< HEAD
                        .addComponent(level1Butt, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(level3Butt, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
=======
                        .addComponent(level1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(level3Button, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
>>>>>>> origin/master
                        .addGap(77, 77, 77))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
<<<<<<< HEAD
                                .addComponent(level7Butt)
                                .addGap(96, 96, 96)
                                .addComponent(level8Butt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(level2Butt, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                                .addComponent(Level4Butt)
                                .addGap(87, 87, 87)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(level5Butt)
                        .addGap(117, 117, 117))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Level6Butt, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
=======
                                .addComponent(level7Button)
                                .addGap(96, 96, 96)
                                .addComponent(level8Button)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(level2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                                .addComponent(level4Button)
                                .addGap(87, 87, 87)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(level5Button)
                        .addGap(117, 117, 117))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(level6Button, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
>>>>>>> origin/master
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
<<<<<<< HEAD
                                .addComponent(level9Butt)
                                .addGap(104, 104, 104)
                                .addComponent(level10Butt, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
=======
                                .addComponent(level9Button)
                                .addGap(104, 104, 104)
                                .addComponent(level10Button, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
>>>>>>> origin/master
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(levelLable)
                                .addGap(274, 274, 274))))
                    .addGroup(layout.createSequentialGroup()
<<<<<<< HEAD
                        .addComponent(levelBack)
=======
                        .addComponent(backButton)
>>>>>>> origin/master
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(levelLable)
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
<<<<<<< HEAD
                            .addComponent(level1Butt, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(level3Butt, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addComponent(level2Butt, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(level7Butt, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(level8Butt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(level5Butt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Level6Butt, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Level4Butt, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(level10Butt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(level9Butt, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126)
                        .addComponent(levelBack)
=======
                            .addComponent(level1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(level3Button, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addComponent(level2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(level7Button, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(level8Button, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(level5Button, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(level6Button, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(level4Button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(level10Button, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(level9Button, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126)
                        .addComponent(backButton)
>>>>>>> origin/master
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

<<<<<<< HEAD
    private void levelBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_levelBackActionPerformed
        GUIManager.manager.backToMainMenuPanel();        // TODO add your handling code here:
    }//GEN-LAST:event_levelBackActionPerformed

    private void level1ButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level1ButtActionPerformed
        GUIManager.manager.openLevel();        // TODO add your handling code here:
    }//GEN-LAST:event_level1ButtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Level4Butt;
    private javax.swing.JButton Level6Butt;
    private javax.swing.JButton level10Butt;
    private javax.swing.JButton level1Butt;
    private javax.swing.JButton level2Butt;
    private javax.swing.JButton level3Butt;
    private javax.swing.JButton level5Butt;
    private javax.swing.JButton level7Butt;
    private javax.swing.JButton level8Butt;
    private javax.swing.JButton level9Butt;
    private javax.swing.JButton levelBack;
    private javax.swing.JLabel levelLable;
=======
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        GUIManager.manager.backToMainMenuPanel();        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonActionPerformed

    private void level1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level1ButtonActionPerformed
        GUIManager.manager.openLevel(1);        // TODO add your handling code here:
    }//GEN-LAST:event_level1ButtonActionPerformed

    private void level2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level2ButtonActionPerformed
        GUIManager.manager.openLevel(2);   
    }//GEN-LAST:event_level2ButtonActionPerformed

    private void level3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level3ButtonActionPerformed
        GUIManager.manager.openLevel(3);   
    }//GEN-LAST:event_level3ButtonActionPerformed

    private void level4ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level4ButtonActionPerformed
        GUIManager.manager.openLevel(4);   
    }//GEN-LAST:event_level4ButtonActionPerformed

    private void level5ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level5ButtonActionPerformed
        GUIManager.manager.openLevel(5);   
    }//GEN-LAST:event_level5ButtonActionPerformed

    private void level6ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level6ButtonActionPerformed
        GUIManager.manager.openLevel(6);   
    }//GEN-LAST:event_level6ButtonActionPerformed

    private void level7ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level7ButtonActionPerformed
        GUIManager.manager.openLevel(7);   
    }//GEN-LAST:event_level7ButtonActionPerformed

    private void level8ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level8ButtonActionPerformed
        GUIManager.manager.openLevel(8);   
    }//GEN-LAST:event_level8ButtonActionPerformed

    private void level9ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level9ButtonActionPerformed
        GUIManager.manager.openLevel(9);   
    }//GEN-LAST:event_level9ButtonActionPerformed

    private void level10ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level10ButtonActionPerformed
        GUIManager.manager.openLevel(10);   
    }//GEN-LAST:event_level10ButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton level10Button;
    private javax.swing.JButton level1Button;
    private javax.swing.JButton level2Button;
    private javax.swing.JButton level3Button;
    private javax.swing.JButton level4Button;
    private javax.swing.JButton level5Button;
    private javax.swing.JButton level6Button;
    private javax.swing.JButton level7Button;
    private javax.swing.JButton level8Button;
    private javax.swing.JButton level9Button;
>>>>>>> origin/master
    // End of variables declaration//GEN-END:variables
}
