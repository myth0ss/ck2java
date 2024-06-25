
package com.hieuthao.form;

import com.hieuthao.component.Chat_Title;
import com.hieuthao.component.Chat_Body;
import com.hieuthao.component.Chat_Bottom;
import com.hieuthao.event.EventChat;
import com.hieuthao.event.PublicEvent;
import com.hieuthao.model.Model_Receive_Message1;
import com.hieuthao.model.Model_Send_Message;
import com.hieuthao.model.Model_User_Account;
import net.miginfocom.swing.MigLayout;
/**
 *
 * @author MinhHieu
 */

public class Chat extends javax.swing.JPanel {
    
    private  Model_User_Account user;
    private  Chat_Title title;
    private  Chat_Body body;
    private Chat_Bottom bottom;
    
    public Chat() {
        initComponents();
        init();
        
    }
    
    public void init(){
        setLayout(new MigLayout("fillx", "0[fill]0", "0[]0[100%, fill]0[shrink 0]0"));
        title = new Chat_Title();
        body = new Chat_Body();
        bottom = new Chat_Bottom();
       
        PublicEvent.getInstance().addEventChat(new EventChat(){
            @Override
            public void sendMessage(Model_Send_Message data) {
              body.addItemImgRight(data);
            }

            @Override
            public void receiveMessage(Model_Receive_Message1 data  ) {
                 if (title.getUser().getUserID() == data.getFromUserID()) {
                    body.addItemImgLeft(data, user);
                }
            }
            
        });
        add(title, "wrap");
        add(body, "wrap");
        add(bottom, "h ::50%");
    }
    
    public void setUser(Model_User_Account user){
        this.user = user;
        title.setUserName(user);
        bottom.setUser(user);
        body.clearChat();
    }
    
    public void updateUser(Model_User_Account user){
        title.updateUser(user);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(229, 229, 229));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 794, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
