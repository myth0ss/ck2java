
package com.hieuthao.component;

import com.hieuthao.event.PublicEvent;
import com.hieuthao.model.Model_User_Account;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author MinhHieu
 */
public class Item_people extends javax.swing.JPanel {

    private boolean mouseover;
    private final Model_User_Account user;

    public Model_User_Account getUser() {
        return user;
    }
    
    
    
    public Item_people(Model_User_Account user) {
        this.user = user;
        initComponents();
        jlbName.setText(user.getUserName());
        activeStatus.setActive(user.isStatus());
        init();
    }
    
    public void updateStatus(){
        activeStatus.setActive(user.isStatus());
    }

    private void init(){
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent ev){
                setBackground(new Color(204,204,204));
                mouseover = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(new Color(153,153,153));
                mouseover = false;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(mouseover){
                    PublicEvent.getInstance().getEventMain().selectUser(user);
                }
            }
            
            
            
        });
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageAvatar2 = new com.hieuthao.swing.ImageAvatar();
        jlbName = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();
        activeStatus = new com.hieuthao.swing.ActiveStatus();

        setBackground(new java.awt.Color(153, 153, 153));

        imageAvatar2.setBorderSize(0);
        imageAvatar2.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/hieuthao/icon/family.png"))); // NOI18N

        jlbName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlbName.setForeground(new java.awt.Color(102, 102, 102));
        jlbName.setText("Name");

        lbStatus.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        lbStatus.setForeground(new java.awt.Color(51, 51, 51));
        lbStatus.setText("New User");

        activeStatus.setActive(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageAvatar2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbName, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(activeStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlbName, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(activeStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(imageAvatar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hieuthao.swing.ActiveStatus activeStatus;
    private com.hieuthao.swing.ImageAvatar imageAvatar2;
    private javax.swing.JLabel jlbName;
    private javax.swing.JLabel lbStatus;
    // End of variables declaration//GEN-END:variables
}
