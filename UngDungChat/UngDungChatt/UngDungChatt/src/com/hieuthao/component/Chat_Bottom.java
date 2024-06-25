
package com.hieuthao.component;

import com.hieuthao.app.MessageType;
import com.hieuthao.event.PublicEvent;
import com.hieuthao.model.Model_Send_Message;
import com.hieuthao.model.Model_User_Account;
import com.hieuthao.service.Service;
import com.hieuthao.swing.JIMSendTextPane;
import com.hieuthao.swing.ScrollBarr;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author MinhHieu
 */
public class Chat_Bottom extends javax.swing.JPanel {

    private Model_User_Account user;
    private Panel_More panelMore;
    private MigLayout mig;
    
    public Model_User_Account getUser() {
        return user;
    }

    public void setUser(Model_User_Account user) {
        this.user = user;
        panelMore.setUser(user);
    }
    
    
    
    public Chat_Bottom() {
        initComponents();
        init();
    }

    
    public void init(){
        mig = new MigLayout("fillx, filly", "0[fill]0[]0[]2", "2[fill]2[]0");
        setLayout(mig);
        JScrollPane js = new JScrollPane();
        js.setBorder(null);
        JIMSendTextPane txt = new JIMSendTextPane();
        txt.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e) {
                 refresh();
                 if(e.getKeyChar()==10&&e.isControlDown()){
                      eventSend(txt);
                 }
            }
            
        });
        txt.setBorder(new EmptyBorder(5,5,5,5));
        txt.setHintText("Write Message Here...");
        js.setViewportView(txt);
        ScrollBarr sb = new ScrollBarr();
        sb.setBackground(new Color(225,223,223));
        sb.setPreferredSize(new Dimension(2,10));
        js.setVerticalScrollBar(sb);
        add(sb);
        add(js, "w 100%");
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(30, 28));
        panel.setLayout(new MigLayout("filly", "0[]8[]2", "2[bottom]2"));
        panel.setBackground(Color.WHITE);
        JButton cmd = new JButton();
//        cmd.setPreferredSize(new Dimension(88, 22));
        cmd.setBorder(null);
        cmd.setContentAreaFilled(false);
        cmd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmd.setIcon(new ImageIcon(getClass().getResource("/com/hieuthao/icon/send (2).png")));
        cmd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                eventSend(txt);
            }
            
        });
        JButton cmdMore = new JButton();
//        cmd.setPreferredSize(new Dimension(88, 22));
        cmdMore.setBorder(null);
        cmdMore.setContentAreaFilled(false);
        cmdMore.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmdMore.setIcon(new ImageIcon(getClass().getResource("/com/hieuthao/icon/more_disable.png")));
        cmdMore.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               if(panelMore.isVisible()){
                   cmdMore.setIcon(new ImageIcon(getClass().getResource("/com/hieuthao/icon/more_disable.png")));
                   panelMore.setVisible(false);
                   mig.setComponentConstraints(panelMore, "dock south,h 0!");
                   revalidate();
               } else {
                   cmdMore.setIcon(new ImageIcon(getClass().getResource("/com/hieuthao/icon/more (2).png")));
                   panelMore.setVisible(true);
                   mig.setComponentConstraints(panelMore, "dock south,h 178!");
                   revalidate();
               }
            }
            
        });
        panel.add(cmdMore);
        panel.add(cmd);
        add(panel, "wrap");
        panelMore = new Panel_More();
        panelMore.setVisible(false);
        add(panelMore, "dock south,h 0!");
    }
    
    public void send(Model_Send_Message data){
        Service.getInstance().getClient().emit("send_to_user", data.toJsonObject());
        
    }
    
    public void refresh(){
        revalidate();
    }
    
    private void eventSend(JIMSendTextPane txt){
          String text = txt.getText().trim();
               if(!text.equals("")){
                   Model_Send_Message message = new Model_Send_Message(MessageType.TEXT,Service.getInstance().getUser().getUserID(),user.getUserID(),text);
                   send(message);
                   PublicEvent.getInstance().getEventChat().sendMessage(message);
                   txt.setText("");
                   txt.grabFocus();
                   refresh();
               } else {
                   txt.grabFocus();
               }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(225, 223, 223));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
