/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cscrush;

import javax.swing.ImageIcon;

/**
 *
 * @author berka
 */
public class SettingsPanel extends javax.swing.JPanel {
    
    public static int flag;
    SoundManager manager;
    /**
     * Creates new form SettingsPanel
     */
    public SettingsPanel() {
        this.manager = new SoundManager();
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

        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        backBS = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(664, 670));

        jToggleButton1.setText("Sound On/Off");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("SETTINGS");

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        backBS.setBackground(new java.awt.Color(255, 255, 255));
        backBS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back1.png"))); // NOI18N
        backBS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backBSMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backBSMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backBSMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                backBSMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(273, 273, 273)
                            .addComponent(jLabel1))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backBS)))
                .addContainerGap(288, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(157, 157, 157)
                .addComponent(jToggleButton1)
                .addGap(31, 31, 31)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 324, Short.MAX_VALUE)
                .addComponent(backBS)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
            // TODO add your handling code here:
            if(jToggleButton1.isSelected())
                (manager).playMainTheme();
            else
                (manager).stopMainTheme();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed

        GUIManager.manager.backToLoginPanel();
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void backBSMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBSMouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("/icons/back2.png"));
        backBS.setIcon(II);
    }//GEN-LAST:event_backBSMouseEntered

    private void backBSMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBSMouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("/icons/back1.png"));
        backBS.setIcon(II);
    }//GEN-LAST:event_backBSMouseExited

    private void backBSMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBSMousePressed
        ImageIcon II = new ImageIcon(getClass().getResource("/icons/back3.png"));
        backBS.setIcon(II);
    }//GEN-LAST:event_backBSMousePressed

    private void backBSMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBSMouseReleased
        
        if ( flag == 0){//Go to main menu
            GUIManager.manager.backToMainMenuPanel();
            ImageIcon II = new ImageIcon(getClass().getResource("/icons/back1.png"));
            backBS.setIcon(II);}// TODO add your handling code here:
        else {//Go to gameplayscreen 
            GUIManager.manager.backToGamePlayScreen();
            ImageIcon II = new ImageIcon(getClass().getResource("/icons/back1.png"));
            backBS.setIcon(II);}
    }//GEN-LAST:event_backBSMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backBS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JButton logoutButton;
    // End of variables declaration//GEN-END:variables
}
