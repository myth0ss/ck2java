
package com.hieuthao.form;

import com.hieuthao.event.EventLogin;
import com.hieuthao.event.EventMessage;
import com.hieuthao.event.PublicEvent;
import com.hieuthao.model.Model_Message;
import com.hieuthao.model.Model_Register;
import com.hieuthao.model.Model_User_Account;
import com.hieuthao.model.Model_login;
import com.hieuthao.service.Service;
import io.socket.client.Ack;

/**
 *
 * @author MinhHieu
 */
public class Login extends javax.swing.JPanel {

   
    public Login() {
        initComponents();
        
        init();
    }

    public void init(){
        
        PublicEvent.getInstance().addEventLogin(new EventLogin() {
            @Override
            public void login(Model_login data) {
               new Thread(new Runnable(){
                   @Override
                   public void run() {
                        PublicEvent.getInstance().getEventMain().showLoading(true);
                        Service.getInstance().getClient().emit("login", data.toJSONObject(), new Ack(){
                             @Override
                             public void call(Object... os) {
                                 if(os.length > 0){
                                     boolean  action  = (boolean) os[0];
                                     if(action){
                                         Service.getInstance().setUser(new Model_User_Account(os[1]));
                                         PublicEvent.getInstance().getEventMain().showLoading(false);
                                         PublicEvent.getInstance().getEventMain().initChat();
                                     } else {
                                         PublicEvent.getInstance().getEventMain().showLoading(false);
                                     }
                                 } else {
                                     PublicEvent.getInstance().getEventMain().showLoading(false);
                                 }
                             }
                            
                        });
                        
                   }
                   
               }).start();
            }

            
            public void register(Model_Register data, EventMessage message) {
                Service.getInstance().getClient().emit("register", data.toJsonObject(), new Ack (){
                    @Override
                    public void call(Object... os) {
                      if(os.length>0){
                          if (os[1] != null) {
                            Model_Message ms = new Model_Message((boolean) os[0], os[1].toString());
                            
                            if(ms.isAction()){
                                Model_User_Account user = new Model_User_Account(os[2]);
                               Service.getInstance().setUser(user);
                            }
                            message.callMessage(ms);
                        }                         
                      }
                    }
                });
            }

            @Override
            public void goRegister() {
               slide.show(1);
            }

            @Override
            public void goBack() {
              slide.show(0);
            }
        });
        P_Login login = new P_Login();
        P_Register register = new P_Register();
        slide.init(login, register);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pictureBox1 = new com.hieuthao.swing.PictureBox();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        slide = new com.hieuthao.swing.PanelSlide();
        jLabel2 = new javax.swing.JLabel();
        pictureBox2 = new com.hieuthao.swing.PictureBox();

        setBackground(new java.awt.Color(255, 255, 255));

        pictureBox1.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/hieuthao/image/mobile-password-forgot.png"))); // NOI18N

        javax.swing.GroupLayout pictureBox1Layout = new javax.swing.GroupLayout(pictureBox1);
        pictureBox1.setLayout(pictureBox1Layout);
        pictureBox1Layout.setHorizontalGroup(
            pictureBox1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 708, Short.MAX_VALUE)
        );
        pictureBox1Layout.setVerticalGroup(
            pictureBox1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel3.setBackground(new java.awt.Color(226, 131, 238));
        jLabel3.setIconTextGap(2);
        jLabel3.setOpaque(true);

        jPanel3.setBackground(new java.awt.Color(226, 131, 238));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        slide.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout slideLayout = new javax.swing.GroupLayout(slide);
        slide.setLayout(slideLayout);
        slideLayout.setHorizontalGroup(
            slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 225, Short.MAX_VALUE)
        );
        slideLayout.setVerticalGroup(
            slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(slide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(slide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Chat Application Tharo");

        pictureBox2.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/hieuthao/image/Vku (2).png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pictureBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(100, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pictureBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pictureBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private com.hieuthao.swing.PictureBox pictureBox1;
    private com.hieuthao.swing.PictureBox pictureBox2;
    private com.hieuthao.swing.PanelSlide slide;
    // End of variables declaration//GEN-END:variables
}
