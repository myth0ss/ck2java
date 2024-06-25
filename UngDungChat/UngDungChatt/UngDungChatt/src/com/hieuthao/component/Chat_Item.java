
package com.hieuthao.component;

import com.hieuthao.model.Model_File_Sender;
import com.hieuthao.model.Model_Receiver_Image;
import com.hieuthao.model.Model_User_Account;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JLayeredPane;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author MinhHieu
 */
public class Chat_Item extends javax.swing.JLayeredPane {
    private JLabel label;
    
    public Chat_Item() {
        initComponents();
        txt.setEditable(false);
        txt.setBackground(new Color(0, 0, 0, 0));
        txt.setOpaque(false);
    }
    
    public void setUserProfile(String user){
        JLayeredPane jl = new JLayeredPane();
        jl.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        jl.setBorder(new EmptyBorder(10, 10, 0, 10));
        JButton cmd = new JButton( user);
        cmd.setBorder(null);
        cmd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmd.setContentAreaFilled(false);
        cmd.setFocusable(false);
        cmd.setForeground(new Color(231, 108, 253));
        cmd.setFont(new java.awt.Font("Segoe UI", 1, 13));
        txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        jl.add(cmd);
        add(jl, 0);
    }
    
    public void setText(String text){
        txt.setText(text);
    }

    public void setTime(String time){
        JLayeredPane jl = new JLayeredPane();
        jl.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        jl.setBorder(new EmptyBorder(0, 5, 10, 5));
        label = new JLabel(time);
        label.setForeground(new Color(110,110,110));
        label.setHorizontalTextPosition(JLabel.LEFT);
        jl.add(label);
        add(jl);
    }
    
    public void setImage(boolean right, Model_File_Sender fileSender){
        
        JLayeredPane layer = new JLayeredPane();
        layer.setLayout(new FlowLayout(right?FlowLayout.RIGHT:FlowLayout.LEFT));
        layer.setBorder(new EmptyBorder(0, 5, 0, 5));
        Chat_Image chatimage = new Chat_Image(right);
        chatimage.addImage(fileSender);
        layer.add(chatimage);
        add(layer);
        
    }
    
     public void setImage(boolean right, Model_Receiver_Image dataImage){
        JLayeredPane layer = new JLayeredPane();
        layer.setLayout(new FlowLayout(right?FlowLayout.RIGHT:FlowLayout.LEFT));
        layer.setBorder(new EmptyBorder(0, 5, 0, 5));
        Chat_Image chatimage = new Chat_Image(right);
        chatimage.addImage(dataImage);
        layer.add(chatimage);
        add(layer);
    }
     
      public void setFile(String fileName, String fileSize){
        JLayeredPane layer = new JLayeredPane();
        layer.setLayout(new FlowLayout(FlowLayout.LEFT));
        layer.setBorder(new EmptyBorder(0, 5, 0, 5));
        Chat_File chatFile = new Chat_File();
        chatFile.setFile(fileName, fileSize);
        layer.add(chatFile);
        add(layer);
    }
      
      public void setEmoji(boolean right, Icon icon){
        JLayeredPane layer = new JLayeredPane();
        layer.setLayout(new FlowLayout(right?FlowLayout.RIGHT:FlowLayout.LEFT));
        layer.setBorder(new EmptyBorder(0, 5, 0, 5));
        layer.add(new JLabel(icon));
        add(layer);
        setBackground(null);
      }
      
      public void sendSuccess(){
        if(label!=null){
            label.setIcon(new ImageIcon(getClass().getResource("/com/hieuthao/icon/check.png")));
        }
    }
    
    public void hideText(){
        txt.setVisible(false);
    }
    
    public void seen(){
        if(label!=null){
            label.setIcon(new ImageIcon(getClass().getResource("/com/hieuthao/icon/double-check (3).png")));
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if(getBackground() != null){
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        }
        super.paintComponent(g);
        
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt = new com.hieuthao.swing.JIMSendTextPane();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));

        txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 5, 10));
        txt.setSelectionColor(new java.awt.Color(79, 164, 245));
        add(txt);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hieuthao.swing.JIMSendTextPane txt;
    // End of variables declaration//GEN-END:variables
}
