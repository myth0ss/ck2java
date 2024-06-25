
package com.hieuthao.component;

import com.hieuthao.model.Model_Receiver_Image;
import java.awt.Color;
import javax.swing.Icon;

/**
 *
 * @author MinhHieu
 */
public class Chat_Left extends javax.swing.JLayeredPane {

   
    public Chat_Left() {
        initComponents();
        txt.setBackground(new Color(242,242, 242));
    }
    
     public void setImage(Icon ...image){
//        txt.setImage(false, image);
    }
     
    public void setImage(Model_Receiver_Image dataImage){
        txt.setImage(true, dataImage);
    }
    
    public void setFile(String fileName, String fileSize){
        txt.setFile(fileName, fileSize);
    }
    
    public void setEmoji(Icon icon){
        txt.hideText();
        txt.setEmoji(false, icon);
    }
    
    public void setTime(){
        txt.setTime("10:30 PM");
    }

    public void setText(String text) {
       if(text.equals("")){
          txt.hideText();
       } else {
           txt.setText(text);
       }
//        txt.setTime("10:30 PM");    //  Testing
    }
    

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt = new com.hieuthao.component.Chat_Item();

        setLayer(txt, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
