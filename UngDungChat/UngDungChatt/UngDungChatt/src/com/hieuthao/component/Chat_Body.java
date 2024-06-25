package com.hieuthao.component;

import com.hieuthao.Emoji.Emogi;
import com.hieuthao.app.MessageType;
import com.hieuthao.model.Model_Receive_Message1;
import com.hieuthao.model.Model_Receiver_Image;
import com.hieuthao.model.Model_Send_Message;
import com.hieuthao.model.Model_User_Account;
import java.awt.Color;
import com.hieuthao.swing.ScrollBarr;
import java.awt.Adjustable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author MinhHieu
 */
public class Chat_Body extends javax.swing.JPanel {
    public Chat_Body() {
        initComponents();
        init();

    }

    private void init() {
        Body.setLayout(new MigLayout("fillx", "", "5[]5"));
        SP.setVerticalScrollBar(new ScrollBarr());
        SP.getVerticalScrollBar().setBackground(Color.WHITE);
    }

    public void addItemImgLeft(Model_Receive_Message1 data, Model_User_Account user) {
        if (data.getMessageType() == MessageType.TEXT) {
            Chat_Left_With_Profile item = new Chat_Left_With_Profile();
            item.setText(data.getText());
            item.setUserProfile(user.getUserName());
            item.setTime();
            item.setSeen();
            Body.add(item, "wrap, w 100::88%");
            
        } else if (data.getMessageType() == MessageType.EMOJI) {
            
            Chat_Left_With_Profile item = new Chat_Left_With_Profile();
            item.setEmoji(Emogi.getInstance().getImoji(Integer.valueOf(data.getText())).getIcon());
            item.setUserProfile(user.getUserName());
            item.setTime();
            item.setSeen();
            Body.add(item, "wrap, w 100::88%");
            
        } else if (data.getMessageType() == MessageType.IMAGE) {
            
            Chat_Left_With_Profile item = new Chat_Left_With_Profile();
            item.setText("");
            item.setUserProfile(user.getUserName());
            item.setImage(data.getDataImage());
            item.setTime();
            item.setSeen();
            Body.add(item, "wrap, w 100::88%");
            
        }
        repaint();
        revalidate();
    }

    public void addItemImgBlurLeft(String text, String user, Model_Receiver_Image dataImage) {
        Chat_Left_With_Profile item = new Chat_Left_With_Profile();
        item.setText(text);
        item.setUserProfile(user);
        item.setImage(dataImage);
        item.setTime();
        item.setSeen();
        Body.add(item, "wrap, w 100::88%");
        Body.repaint();
        Body.revalidate();
    }

    public void addItemFileLeft(String text, String user, String fileName, String fileSize) {
        Chat_Left_With_Profile item = new Chat_Left_With_Profile();
        item.setText(text);
        item.setUserProfile(user);
        item.setFile(fileName, fileSize);
        item.setTime();
        item.setSeen();
        Body.add(item, "wrap, w 100::88%");
        Body.repaint();
        Body.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SP = new javax.swing.JScrollPane();
        Body = new javax.swing.JPanel();

        SP.setBorder(null);
        SP.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        Body.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout BodyLayout = new javax.swing.GroupLayout(Body);
        Body.setLayout(BodyLayout);
        BodyLayout.setHorizontalGroup(
            BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 827, Short.MAX_VALUE)
        );
        BodyLayout.setVerticalGroup(
            BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 477, Short.MAX_VALUE)
        );

        SP.setViewportView(Body);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SP)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SP)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void addItemImgRight(Model_Send_Message data) {
        if (data.getMessageType() == MessageType.TEXT) {
            Chat_Right item = new Chat_Right();
            item.setText(data.getText());
            item.setTime();
            item.setSuccess();
            Body.add(item, "wrap, al right, w 100::88%");
        } else if (data.getMessageType() == MessageType.EMOJI) {
            Chat_Right item = new Chat_Right();
            item.setEmoji(Emogi.getInstance().getImoji(Integer.valueOf(data.getText())).getIcon());
            item.setTime();
            item.setSuccess();
            Body.add(item, "wrap, al right, w 100::88%");
        } else if (data.getMessageType() == MessageType.IMAGE) {
            Chat_Right item = new Chat_Right();
            item.setText("");
            item.setImage(data.getFile());
            item.setTime();
            item.setSuccess();
            Body.add(item, "wrap, al right, w 100::88%");
        }
        repaint();
        revalidate();
        scrollToBottom();
    }

    public void addItemFileRight(String text, String fileName, String fileSize) {
        Chat_Right item = new Chat_Right();
        item.setText(text);
        item.setFile(fileName, fileSize);
        item.setTime();
        item.setSuccess();
        Body.add(item, "wrap, al right, w 100::88%");
        Body.repaint();
        Body.revalidate();
    }

    public void addDate(String date) {
        Chat_Date item = new Chat_Date();
        item.setDate(date);
        Body.add(item, "wrap, al center");
    }

    public void clearChat() {
        Body.removeAll();
        repaint();
        revalidate();
    }

    private void scrollToBottom() {
        JScrollBar verticalBar = SP.getVerticalScrollBar();
        AdjustmentListener downScroller = new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                Adjustable adjustable = e.getAdjustable();
                adjustable.setValue(adjustable.getMaximum());
                verticalBar.removeAdjustmentListener(this);
            }
        };
        verticalBar.addAdjustmentListener(downScroller);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Body;
    private javax.swing.JScrollPane SP;
    // End of variables declaration//GEN-END:variables
}
