
package com.hieuthao.form;

import com.hieuthao.component.Item_people;
import com.hieuthao.event.Event_menuLeft;
import com.hieuthao.event.PublicEvent;
import com.hieuthao.model.Model_User_Account;
import com.hieuthao.swing.GradientColor;
import com.hieuthao.swing.ScrollBarr;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author MinhHieu
 */
public class Menu_left extends javax.swing.JPanel {

    private List<Model_User_Account> userAccount;
   
    public Menu_left() {
        initComponents();
        init();
    }
    
    private void init(){
        jScrollPane1.setVerticalScrollBar(new ScrollBarr());
        Menu_List.setLayout(new MigLayout("fillx", "0[]5", "5[]5"));
        userAccount = new ArrayList<>();
        
        PublicEvent.getInstance().addEventMenuLeft(new Event_menuLeft() {
            @Override
            public void newUser(List<Model_User_Account> users) {
                for(Model_User_Account t : users ){
                    userAccount.add(t);
                    Menu_List.add(new Item_people(t), "wrap");
                    refreshMenuList();
                }
            }
            public void userConnect(int userID){
                for(Model_User_Account th : userAccount){
                    if(th.getUserID() == userID){
                        th.setStatus(true);
                        PublicEvent.getInstance().getEventMain().updateUser(th);
                        break;
                    }
                }
                if(MenuMessage.isSelected()){
                    for(Component com : Menu_List.getComponents()){
                        Item_people item = (Item_people) com;
                        if(item.getUser().getUserID() == userID){
                            item.updateStatus();
                            break;
                        }
                    }
                }
            }

            @Override
            public void userDisConnect(int userID) {
                for(Model_User_Account th : userAccount){
                    if(th.getUserID() == userID){
                        th.setStatus(false);
                        PublicEvent.getInstance().getEventMain().updateUser(th);
                        break;
                    }
                }
                if(MenuMessage.isSelected()){
                    for(Component com : Menu_List.getComponents()){
                        Item_people item = (Item_people) com;
                        if(item.getUser().getUserID() == userID){
                            item.updateStatus();
                            break;
                        }
                    }
                }
            }
        });
        
        showPeople();
    }
    
      private void refreshMenuList() {
        Menu_List.repaint();
        Menu_List.revalidate();
    }
    
    private void showPeople(){
        Menu_List.removeAll();
        for(Model_User_Account t : userAccount){
            Menu_List.add(new Item_people(null), "wrap");
        }
        refreshMenuList();
    }
    private void showGroup(){
        Menu_List.removeAll();
        for(int i = 0; i<8; i++){
            Menu_List.add(new Item_people(null), "wrap");
        }
        refreshMenuList();
    }
    private void showBox(){
        Menu_List.removeAll();
        for(int i = 0; i<8; i++){
            Menu_List.add(new Item_people(null), "wrap");
        }
        refreshMenuList();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JLayeredPane();
        MenuMessage = new com.hieuthao.component.menuButton();
        menuGroup = new com.hieuthao.component.menuButton();
        menuBox = new com.hieuthao.component.menuButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Menu_List = new javax.swing.JLayeredPane();

        setBackground(new java.awt.Color(102, 102, 102));
        setForeground(new java.awt.Color(204, 204, 204));

        menu.setBackground(new java.awt.Color(255, 255, 255));
        menu.setLayout(new java.awt.GridLayout(1, 0));

        MenuMessage.setIconSelected(new javax.swing.ImageIcon(getClass().getResource("/com/hieuthao/icon/message (1)_selection.png"))); // NOI18N
        MenuMessage.setIconSimple(new javax.swing.ImageIcon(getClass().getResource("/com/hieuthao/icon/message (2).png"))); // NOI18N
        MenuMessage.setSelected(true);
        MenuMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuMessageActionPerformed(evt);
            }
        });
        menu.add(MenuMessage);

        menuGroup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hieuthao/icon/networking.png"))); // NOI18N
        menuGroup.setIconSelected(new javax.swing.ImageIcon(getClass().getResource("/com/hieuthao/icon/networking (5)_selection.png"))); // NOI18N
        menuGroup.setIconSimple(new javax.swing.ImageIcon(getClass().getResource("/com/hieuthao/icon/networking.png"))); // NOI18N
        menuGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGroupActionPerformed(evt);
            }
        });
        menu.add(menuGroup);

        menuBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hieuthao/icon/letter (1).png"))); // NOI18N
        menuBox.setIconSelected(new javax.swing.ImageIcon(getClass().getResource("/com/hieuthao/icon/letter_selection.png"))); // NOI18N
        menuBox.setIconSimple(new javax.swing.ImageIcon(getClass().getResource("/com/hieuthao/icon/letter (1).png"))); // NOI18N
        menuBox.setPreferredSize(new java.awt.Dimension(80, 80));
        menuBox.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        menuBox.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        menuBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBoxActionPerformed(evt);
            }
        });
        menu.add(menuBox);

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        Menu_List.setBackground(new java.awt.Color(204, 204, 204));
        Menu_List.setOpaque(true);

        javax.swing.GroupLayout Menu_ListLayout = new javax.swing.GroupLayout(Menu_List);
        Menu_List.setLayout(Menu_ListLayout);
        Menu_ListLayout.setHorizontalGroup(
            Menu_ListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Menu_ListLayout.setVerticalGroup(
            Menu_ListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 467, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(Menu_List);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
   
    
    
    private void MenuMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuMessageActionPerformed
        
        
        
        MenuMessage.setSelected(true);
        menuGroup.setSelected(false);
        menuBox.setSelected(false);
        showPeople();   
        
    }//GEN-LAST:event_MenuMessageActionPerformed

    private void menuGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGroupActionPerformed
        
        MenuMessage.setSelected(false);
        menuGroup.setSelected(true);
        menuBox.setSelected(false);
        showGroup();
        
        
    }//GEN-LAST:event_menuGroupActionPerformed

    private void menuBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBoxActionPerformed
        
        MenuMessage.setSelected(false);
        menuGroup.setSelected(false);
        menuBox.setSelected(true);
        showBox();
        
    }//GEN-LAST:event_menuBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hieuthao.component.menuButton MenuMessage;
    private javax.swing.JLayeredPane Menu_List;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLayeredPane menu;
    private com.hieuthao.component.menuButton menuBox;
    private com.hieuthao.component.menuButton menuGroup;
    // End of variables declaration//GEN-END:variables
}
