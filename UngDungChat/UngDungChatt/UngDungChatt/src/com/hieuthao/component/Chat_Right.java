
package com.hieuthao.component;

import com.hieuthao.model.Model_File_Sender;
import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.Icon;

/**
 *
 * @author MinhHieu
 */
public class Chat_Right extends javax.swing.JLayeredPane {

   
    public Chat_Right() {
        initComponents();
        txt.setBackground(new Color(179,233, 255));
    }
    
    public void setImage(Model_File_Sender fileSender){
        txt.setImage(true, fileSender);
    }
    
    public void setImage(String... image){
//        txt.setImage(true, image);
    }
    
    public void setFile(String fileName, String fileSize){
        txt.setFile(fileName, fileSize);
    }
    
    public void setEmoji(Icon icon){
        txt.hideText();
        txt.setEmoji(true, icon);
    }
    
    public void setTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        String currentTime = LocalDateTime.now().format(formatter);
        txt.setTime(currentTime);
    }
    
    public void setSuccess(){
        txt.sendSuccess();
    }

    public void setText(String text) {
       if(text.equals("")){
          txt.hideText();
       } else {
           txt.setText(text);
       }
       txt.seen();
//        txt.setTime("10:30 PM");    //  Testing
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt = new com.hieuthao.component.Chat_Item();

        txt.setBackground(new java.awt.Color(255, 255, 255));

        setLayer(txt, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hieuthao.component.Chat_Item txt;
    // End of variables declaration//GEN-END:variables
}
