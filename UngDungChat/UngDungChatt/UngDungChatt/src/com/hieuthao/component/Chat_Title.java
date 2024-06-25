
package com.hieuthao.component;

import com.hieuthao.model.Model_User_Account;
import java.awt.Color;

/**
 *
 * @author MinhHieu
 */
public class Chat_Title extends javax.swing.JPanel {

    private Model_User_Account user;

    public Model_User_Account getUser() {
        return user;
    }
    
    
    
    public Chat_Title() {
        initComponents();
    }

    public void setUserName(Model_User_Account user){
        this.user = user;
        lbName.setText(user.getUserName());
        if(user.isStatus()){
            statusActive();
        } else {
            setStatus("Offline");
        }
    }
    
    public void updateUser(Model_User_Account user){
        if(this.user == user){
            lbName.setText(user.getUserName());
            if(user.isStatus()){
            statusActive();
            } else {
            setStatus("Offline");
            }
        }
    }
    
    private void statusActive(){
        lbStatus.setText("Active now");
        lbStatus.setForeground(new java.awt.Color(231, 108, 253));
    }
    
    private void setStatus(String text){
        lbStatus.setText(text);
        lbStatus.setForeground(new Color(160, 160, 160));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Layer = new javax.swing.JLayeredPane();
        lbName = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();

        setBackground(new java.awt.Color(225, 223, 223));

        Layer.setLayout(new java.awt.GridLayout(0, 1));

        lbName.setBackground(new java.awt.Color(72, 72, 72));
        lbName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbName.setText("Name");
        Layer.add(lbName);

        lbStatus.setBackground(new java.awt.Color(72, 72, 72));
        lbStatus.setForeground(new java.awt.Color(231, 108, 253));
        lbStatus.setText("Active now");
        Layer.add(lbStatus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Layer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(336, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(Layer, javax.swing.GroupLayout.PREFERRED_SIZE, 34, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane Layer;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbStatus;
    // End of variables declaration//GEN-END:variables
}
