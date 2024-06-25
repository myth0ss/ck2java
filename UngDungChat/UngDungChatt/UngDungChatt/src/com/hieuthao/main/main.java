
package com.hieuthao.main;

import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import com.hieuthao.event.EventImageView;
import com.hieuthao.event.EventMain;
import com.hieuthao.event.PublicEvent;
import com.hieuthao.model.Model_User_Account;
import com.hieuthao.service.Service;
import com.hieuthao.swing.ComponentResizer;
import io.socket.emitter.Emitter;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author MinhHieu
 */
public class main extends javax.swing.JFrame {

   
    public main() {
        initComponents();
        init();
    }
    
    private void init(){
        setIconImage(new ImageIcon(getClass().getResource("/com/hieuthao/icon/butterfly (2).png")).getImage());
        ComponentResizer com = new ComponentResizer();
        com.registerComponent(this);
        com.setMinimumSize(new Dimension(888,500));
        com.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        com.setSnapSize(new Dimension(10, 10));
        login.setVisible(true);
        loading1.setVisible(false);
        view_Image.setVisible(false);
        home.setVisible(false);
        initEvent();
        
        Service.getInstance().startServer();
    }

     private void initEvent() {
         
         PublicEvent.getInstance().addEventMain(new EventMain() {
             @Override
             public void showLoading(boolean show) {
                loading1.setVisible(show);
             }

             @Override
             public void initChat() {
                 home.setVisible(true);
                 login.setVisible(false);
                 Emitter emit = Service.getInstance().getClient().emit("list_user", Service.getInstance().getUser().getUserID());
             }

             @Override
             public void selectUser(Model_User_Account user) {
                 home.setUser(user);
             }

             @Override
             public void updateUser(Model_User_Account user) {
                 home.updateUser(user);
             }
             
             
         });
         
        PublicEvent.getInstance().addEventImageView(new EventImageView() {
            @Override
            public void viewImage(Icon image) {
                view_Image.viewImage(image);
                System.out.println("MinhHieuvaPhuongThao");
            }

            @Override
            public void saveImage(Icon image) {
                System.out.println("Save Image next update");
            }

        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        border = new javax.swing.JPanel();
        background = new javax.swing.JPanel();
        tittle = new javax.swing.JPanel();
        cmdMinimize = new javax.swing.JButton();
        cmdClose = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        loading1 = new com.hieuthao.form.Loading();
        login = new com.hieuthao.form.Login();
        view_Image = new com.hieuthao.form.View_Image();
        home = new com.hieuthao.form.Home();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        border.setBackground(new java.awt.Color(229, 229, 229));

        background.setBackground(new java.awt.Color(255, 255, 255));

        tittle.setBackground(new java.awt.Color(204, 204, 204));
        tittle.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                tittleMouseDragged(evt);
            }
        });
        tittle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tittleMousePressed(evt);
            }
        });

        cmdMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hieuthao/icon/minimize (4).png"))); // NOI18N
        cmdMinimize.setBorder(null);
        cmdMinimize.setContentAreaFilled(false);
        cmdMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdMinimize.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hieuthao/icon/minimize (5)_selection.png"))); // NOI18N
        cmdMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdMinimizeActionPerformed(evt);
            }
        });

        cmdClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hieuthao/icon/close.png"))); // NOI18N
        cmdClose.setBorder(null);
        cmdClose.setContentAreaFilled(false);
        cmdClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdClose.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hieuthao/icon/close (1)_selection.png"))); // NOI18N
        cmdClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tittleLayout = new javax.swing.GroupLayout(tittle);
        tittle.setLayout(tittleLayout);
        tittleLayout.setHorizontalGroup(
            tittleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tittleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmdMinimize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdClose, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        tittleLayout.setVerticalGroup(
            tittleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(cmdClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cmdMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tittle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tittle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout borderLayout = new javax.swing.GroupLayout(border);
        border.setLayout(borderLayout);
        borderLayout.setHorizontalGroup(
            borderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        borderLayout.setVerticalGroup(
            borderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(borderLayout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLayeredPane1.setLayout(new java.awt.CardLayout());
        jLayeredPane1.add(loading1, "card5");
        jLayeredPane1.add(login, "card4");
        jLayeredPane1.add(view_Image, "card3");
        jLayeredPane1.add(home, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(border, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1107, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(border, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private int pX;
    private int pY;
    private void tittleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tittleMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - pX,
                            this.getLocation().y + evt.getY() - pY);
    }//GEN-LAST:event_tittleMouseDragged

    private void tittleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tittleMousePressed
           pX = evt.getX();
           pY = evt.getY();
    }//GEN-LAST:event_tittleMousePressed

    private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_cmdCloseActionPerformed

    private void cmdMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdMinimizeActionPerformed
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_cmdMinimizeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatArcIJTheme.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel border;
    private javax.swing.JButton cmdClose;
    private javax.swing.JButton cmdMinimize;
    private com.hieuthao.form.Home home;
    private javax.swing.JLayeredPane jLayeredPane1;
    private com.hieuthao.form.Loading loading1;
    private com.hieuthao.form.Login login;
    private javax.swing.JPanel tittle;
    private com.hieuthao.form.View_Image view_Image;
    // End of variables declaration//GEN-END:variables
}
