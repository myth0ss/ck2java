
package com.hieuthao.form;

import com.hieuthao.event.EventLogin;
import com.hieuthao.event.EventMessage;
import com.hieuthao.event.PublicEvent;
import com.hieuthao.model.Model_Message;
import com.hieuthao.model.Model_Register;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author MinhHieu
 */
public class P_Register extends javax.swing.JPanel {

    
    public P_Register() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        cmdRegister = new javax.swing.JButton();
        cmdBackLogin = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtRePassword = new javax.swing.JPasswordField();
        lbError = new javax.swing.JLabel();
        Choose_avt = new javax.swing.JButton();
        imageAvatar1 = new com.hieuthao.swing.ImageAvatar();

        jLabel1.setText("jLabel1");

        setBackground(new java.awt.Color(255, 255, 255));

        lbTitle.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(204, 141, 243));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Register");

        jLabel2.setText("User Name");

        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        jLabel3.setText("PassWord");

        cmdRegister.setText("Register");
        cmdRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdRegisterActionPerformed(evt);
            }
        });

        cmdBackLogin.setBackground(new java.awt.Color(223, 85, 225));
        cmdBackLogin.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        cmdBackLogin.setForeground(new java.awt.Color(224, 62, 245));
        cmdBackLogin.setText("Back Login");
        cmdBackLogin.setContentAreaFilled(false);
        cmdBackLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdBackLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBackLoginActionPerformed(evt);
            }
        });

        jLabel4.setText("Comfrim Password");

        lbError.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        lbError.setForeground(new java.awt.Color(122, 56, 239));
        lbError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Choose_avt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hieuthao/icon/image-.png"))); // NOI18N
        Choose_avt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Choose_avtActionPerformed(evt);
            }
        });

        imageAvatar1.setToolTipText("");
        imageAvatar1.setBorderColor(new java.awt.Color(255, 255, 255));
        imageAvatar1.setBorderSize(0);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPass)
                    .addComponent(cmdRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdBackLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRePassword)
                    .addComponent(lbError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(75, 75, 75)
                        .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Choose_avt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
                    .addComponent(txtUser))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lbTitle)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Choose_avt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imageAvatar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(cmdRegister)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmdBackLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbError, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void cmdBackLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBackLoginActionPerformed
       PublicEvent.getInstance().getEventLogin().goBack();
    }//GEN-LAST:event_cmdBackLoginActionPerformed

    private void cmdRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdRegisterActionPerformed
        String userName = txtUser.getText().trim();
        String passWord = String.valueOf(txtPass.getPassword());
        String confirmPassWord = String.valueOf(txtPass.getPassword());
        if(userName.equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên người dùng", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtUser.grabFocus();
        } else if(passWord.equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mật khẩu mới", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtPass.grabFocus();
        } else if(confirmPassWord.equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mật khẩu xác nhận", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtRePassword.grabFocus();
        }
        else if(!passWord.equals(confirmPassWord)){
            JOptionPane.showMessageDialog(this, "Mật khẩu xác nhận không khớp", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtPass.grabFocus();
        } else if(imageAvatar1.getImage() == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ảnh đại diện", "Lỗi", JOptionPane.ERROR_MESSAGE);
            Choose_avt.grabFocus();
        }
        else {
//            ImageIcon icon = imageAvatar1.getImage();
            
//            String avatarBase64 = encodeImageToBase64(icon);
//             System.out.println("Avatar Base64: " + avatarBase64);
              Model_Register data = new Model_Register(userName, passWord);
               System.out.println("Register Data: " + data.toJsonObject());
               EventLogin eventLogin = PublicEvent.getInstance().getEventLogin();
            if (eventLogin != null) {
//                System.out.println("EventLogin instance found"); // Debug print
                eventLogin.register(data, (Model_Message message) -> {
                    if(!message.isAction()){
                        lbError.setText(message.getMessage());
//                        System.out.println("Registration failed: " + message.getMessage()); // Debug print
                    } else {
                        PublicEvent.getInstance().getEventMain().initChat();
//                        System.out.println("Registration successful"); // Debug print
                    }
                });
            } else {
//                System.out.println("EventLogin instance not found"); // Debug print
            }
       
            
        }
        
        
        
    }//GEN-LAST:event_cmdRegisterActionPerformed
     
        
      private String encodeImageToBase64(ImageIcon icon) {
        try {
            BufferedImage bufferedImage = (BufferedImage) icon.getImage();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", baos);
            byte[] bytes = baos.toByteArray();
            return Base64.getEncoder().encodeToString(bytes);
        } catch (IOException e) {
            return null;
        }
    }
    
    private void Choose_avtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Choose_avtActionPerformed
    JFileChooser chooser = new JFileChooser();
    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    int result = chooser.showOpenDialog(this);
    if(result == JFileChooser.APPROVE_OPTION){
        File selectedFile = chooser.getSelectedFile();
        try {
            BufferedImage buffered = ImageIO.read(selectedFile);
             if (buffered != null) {  
                ImageIcon icon = new ImageIcon(buffered);
                imageAvatar1.setImage(icon);
            } else {
                JOptionPane.showMessageDialog(this, "Định dạng ảnh không hợp lệ hoặc không thể đọc ảnh", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException | IOException e) {
        }
    } 
    
    }//GEN-LAST:event_Choose_avtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Choose_avt;
    private javax.swing.JButton cmdBackLogin;
    private javax.swing.JButton cmdRegister;
    private com.hieuthao.swing.ImageAvatar imageAvatar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbError;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JPasswordField txtRePassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
