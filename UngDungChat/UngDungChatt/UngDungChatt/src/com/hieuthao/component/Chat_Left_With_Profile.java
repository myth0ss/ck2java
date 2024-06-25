
package com.hieuthao.component;

/**
 *
 * @author MinhHieu
 */
import com.hieuthao.model.Model_Receiver_Image;
import com.hieuthao.model.Model_User_Account;
import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Chat_Left_With_Profile extends javax.swing.JLayeredPane {

    public Chat_Left_With_Profile() {
        initComponents();
        txt.setBackground(new Color(242, 242, 242));
    }

    public void setUserProfile(String user) {
        txt.setUserProfile(user);
    }

    public void setImageProfile(ImageIcon image) {
        IaImage.setImage(image);
    }
    
    public void setImage(Model_Receiver_Image dataImage){
        txt.setImage(true, dataImage);
    }
    
     public void setImage(Icon... image){
//        txt.setImage(false, image);
    }
     
     public void setEmoji(Icon icon){
        txt.hideText();
        txt.setEmoji(false, icon);
    }
     
    public void setFile(String fileName, String fileSize){
        txt.setFile(fileName, fileSize);
    }
    
    public void setTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        String currentTime = LocalDateTime.now().format(formatter);
        txt.setTime(currentTime);
    }
    
    public void setSeen(){
        txt.seen();
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        IaImage = new com.hieuthao.swing.ImageAvatar();
        txt = new com.hieuthao.component.Chat_Item();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        IaImage.setBorderSize(0);
        IaImage.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/hieuthao/image/user.jpg"))); // NOI18N
        IaImage.setMaximumSize(new java.awt.Dimension(31, 31));
        IaImage.setMinimumSize(new java.awt.Dimension(31, 31));
        IaImage.setPreferredSize(new java.awt.Dimension(31, 31));

        jLayeredPane1.setLayer(IaImage, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(IaImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(IaImage, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jLayeredPane1);
        add(txt);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hieuthao.swing.ImageAvatar IaImage;
    private javax.swing.JLayeredPane jLayeredPane1;
    private com.hieuthao.component.Chat_Item txt;
    // End of variables declaration//GEN-END:variables
}
