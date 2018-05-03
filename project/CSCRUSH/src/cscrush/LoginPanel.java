/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cscrush;

import javax.swing.ImageIcon;


/**
 *
 * @author tendoushuu
 */
public class LoginPanel extends javax.swing.JPanel {
    
    //Image bck;
    /**
     * Creates new form LoginPanel
     */
    public LoginPanel() {
        initComponents();
        errorMessageL.setText("");
        errorMessageS.setText("");
    }
    
    public void setErrorMessageL(String text)
    {
        errorMessageL.setText(text);
    }
    
    public void setErrorMessageS(String text)
    {
        errorMessageS.setText(text);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginButt = new javax.swing.JLabel();
        signButt = new javax.swing.JLabel();
        usernameL = new javax.swing.JTextField();
        usernameS = new javax.swing.JTextField();
        emailS = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        passwordL = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        errorMessageL = new javax.swing.JLabel();
        errorMessageS = new javax.swing.JLabel();
        passwordS = new javax.swing.JPasswordField();
        repasswordS = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(700, 700));
        setLayout(null);

        loginButt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/login1.png")));
        loginButt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginButtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginButtMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginButtMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                loginButtMouseReleased(evt);
            }
        });
        add(loginButt);
        loginButt.setBounds(110, 420, 140, 50);

        signButt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/signup1.png"))); // NOI18N
        signButt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signButtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signButtMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                signButtMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                signButtMouseReleased(evt);
            }
        });
        add(signButt);
        signButt.setBounds(430, 450, 160, 50);

        usernameL.setToolTipText("");
        usernameL.setPreferredSize(new java.awt.Dimension(50, 20));
        add(usernameL);
        usernameL.setBounds(190, 340, 50, 20);

        usernameS.setToolTipText("");
        usernameS.setPreferredSize(new java.awt.Dimension(50, 20));
        add(usernameS);
        usernameS.setBounds(520, 330, 60, 20);

        emailS.setToolTipText("");
        emailS.setPreferredSize(new java.awt.Dimension(50, 20));
        add(emailS);
        emailS.setBounds(520, 420, 60, 20);

        jLabel1.setText("Username");
        add(jLabel1);
        jLabel1.setBounds(110, 340, 60, 14);

        jLabel2.setText("Password");
        add(jLabel2);
        jLabel2.setBounds(110, 380, 60, 14);

        jLabel3.setText("Username");
        add(jLabel3);
        jLabel3.setBounds(430, 330, 60, 14);

        jLabel4.setText("Password");
        add(jLabel4);
        jLabel4.setBounds(430, 360, 70, 14);

        jLabel5.setText("RePassword");
        add(jLabel5);
        jLabel5.setBounds(430, 390, 80, 14);

        jLabel6.setText("E-mail");
        add(jLabel6);
        jLabel6.setBounds(430, 420, 40, 14);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ask17.png"))); // NOI18N
        add(jLabel7);
        jLabel7.setBounds(100, 290, 300, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ask2.png"))); // NOI18N
        add(jLabel8);
        jLabel8.setBounds(420, 280, 212, 40);
        add(passwordL);
        passwordL.setBounds(190, 380, 52, 20);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/welcome.png"))); // NOI18N
        add(jLabel9);
        jLabel9.setBounds(90, 210, 550, 22);

        errorMessageL.setText("jLabel10");
        add(errorMessageL);
        errorMessageL.setBounds(280, 440, 90, 14);

        errorMessageS.setText("jLabel10");
        add(errorMessageS);
        errorMessageS.setBounds(430, 510, 180, 14);

        passwordS.setPreferredSize(new java.awt.Dimension(50, 20));
        passwordS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordSActionPerformed(evt);
            }
        });
        add(passwordS);
        passwordS.setBounds(520, 360, 60, 20);
        add(repasswordS);
        repasswordS.setBounds(520, 390, 60, 20);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1.jpg"))); // NOI18N
        add(jLabel10);
        jLabel10.setBounds(0, 0, 710, 690);
    }// </editor-fold>//GEN-END:initComponents

    private void passwordSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordSActionPerformed

    private void loginButtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtMouseEntered

    }//GEN-LAST:event_loginButtMouseEntered

    private void loginButtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtMouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("/icons/login1.png"));
        loginButt.setIcon(II);
    }//GEN-LAST:event_loginButtMouseExited

    private void loginButtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtMousePressed
        ImageIcon II = new ImageIcon(getClass().getResource("/icons/login2.png"));
        loginButt.setIcon(II);
    }//GEN-LAST:event_loginButtMousePressed

    private void loginButtMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtMouseReleased
        GUIManager.manager.login( usernameL.getText(), passwordL.getText());
        ImageIcon II = new ImageIcon(getClass().getResource("/icons/login1.png"));
        loginButt.setIcon(II);
    }//GEN-LAST:event_loginButtMouseReleased

    private void signButtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signButtMouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("/icons/signup1.png"));
        signButt.setIcon(II);       // TODO add your handling code here:
    }//GEN-LAST:event_signButtMouseExited

    private void signButtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signButtMousePressed
        ImageIcon II = new ImageIcon(getClass().getResource("/icons/signup2.jpg"));
        signButt.setIcon(II);
    }//GEN-LAST:event_signButtMousePressed

    private void signButtMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signButtMouseReleased
        ImageIcon II = new ImageIcon(getClass().getResource("/icons/signup1.png"));
        signButt.setIcon(II);
        GUIManager.manager.signup( usernameS.getText(), passwordS.getText(), repasswordS.getText(), emailS.getText());        

    }//GEN-LAST:event_signButtMouseReleased

    private void signButtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signButtMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_signButtMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailS;
    private javax.swing.JLabel errorMessageL;
    private javax.swing.JLabel errorMessageS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel loginButt;
    private javax.swing.JPasswordField passwordL;
    private javax.swing.JPasswordField passwordS;
    private javax.swing.JPasswordField repasswordS;
    private javax.swing.JLabel signButt;
    private javax.swing.JTextField usernameL;
    private javax.swing.JTextField usernameS;
    // End of variables declaration//GEN-END:variables
}
