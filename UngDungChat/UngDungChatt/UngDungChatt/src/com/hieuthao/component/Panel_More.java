
package com.hieuthao.component;

import com.hieuthao.Emoji.Emogi;
import com.hieuthao.Emoji.Model_Emoji;
import com.hieuthao.app.MessageType;
import com.hieuthao.event.PublicEvent;
import com.hieuthao.swing.WrapLayout;
import com.hieuthao.main.main;
import com.hieuthao.model.Model_Send_Message;
import com.hieuthao.model.Model_User_Account;
import com.hieuthao.service.Service;
import com.hieuthao.swing.ScrollBarr;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author MinhHieu
 */
public class Panel_More extends javax.swing.JPanel {

    private JPanel panelHeader;
    private JPanel panelDetail;
    private Model_User_Account user;
    
    private boolean isImageFile(File file){
        String name = file.getName().toLowerCase();
        return name.endsWith(".jpg") || name.endsWith(".png") || name.endsWith(".jpeg") || name.endsWith(".gif");
    }
    
     public Model_User_Account getUser() {
        return user;
    }

    public void setUser(Model_User_Account user) {
        this.user = user;
        
    }
    
    
    public Panel_More() {
        initComponents();
        init();
    }
    
    public void init(){
        setLayout(new MigLayout("fillx"));
        panelHeader = new JPanel();
        panelHeader.setLayout(new BoxLayout(panelHeader, BoxLayout.LINE_AXIS));
        panelHeader.add(getButtonImage());
        panelHeader.add(getButtonFile());
        panelHeader.add(getEmojiStyle1());
        panelHeader.add(getEmojiStyle2());
        add(panelHeader,"w 100%, h 30!, wrap");
        panelDetail = new JPanel();
        panelDetail.setLayout(new WrapLayout(WrapLayout.LEFT));
        JScrollPane th = new JScrollPane(panelDetail);
        th.setBorder(null);
        th.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        th.setVerticalScrollBar(new ScrollBarr());
        add(th, "w 100%, h 100%");
    }

    private JButton getButtonFile(){
        OptionButton cmd = new OptionButton();
        cmd.setIcon(new ImageIcon(getClass().getResource("/com/hieuthao/icon/link.png")));
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser th = new JFileChooser();
                th.showOpenDialog(main.getFrames()[0]);
            }
        });
        return cmd;
    }
    
    private JButton getEmojiStyle1(){
        OptionButton cmd = new OptionButton();
        cmd.setIcon(Emogi.getInstance().getImoji(13).toSize(25, 25).getIcon());
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearSelected();
                cmd.setSelected(true);
                panelDetail.removeAll();
                for(Model_Emoji th : Emogi.getInstance().getStyle1()){
                    panelDetail.add(getButton(th));
                }
                panelDetail.repaint();
                panelDetail.revalidate();
            }
        });
        return cmd;
    }
    
    private JButton getEmojiStyle2(){
       OptionButton cmd = new OptionButton();
        cmd.setIcon(Emogi.getInstance().getImoji(100).toSize(25, 25).getIcon());
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {    
                clearSelected();
                cmd.setSelected(true);
                panelDetail.removeAll();
                for(Model_Emoji th : Emogi.getInstance().getStyle2()){
                    panelDetail.add(getButton(th));
                }
                panelDetail.repaint();
                panelDetail.revalidate();
            }
        });
        return cmd;
    }
    
    private JButton getButtonImage(){
        OptionButton cmd = new OptionButton();
        cmd.setIcon(new ImageIcon(getClass().getResource("/com/hieuthao/icon/image-.png")));
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser th = new JFileChooser();
                th.setMultiSelectionEnabled(true);
                th.setFileFilter(new FileFilter(){
                    @Override
                    public boolean accept(File f) {
                        return f.isDirectory() || isImageFile(f);
                    }

                    @Override
                    public String getDescription() {
                        return "Image File";
                    }
                    
                });
                int option = th.showOpenDialog(main.getFrames()[0]);
                if(option == JFileChooser.APPROVE_OPTION) {
                    File files[] = th.getSelectedFiles();
                    try {
                        for(File file : files){
                            Model_Send_Message message = new Model_Send_Message(MessageType.IMAGE, Service.getInstance().getUser().getUserID(), user.getUserID(), "");
                            Service.getInstance().addFile(file, message);
                            PublicEvent.getInstance().getEventChat().sendMessage(message);
                        }
                    } catch (IOException sbc) {
                        sbc.printStackTrace();
                    }
                }
            }
        });
        return cmd;
    }
    
    private JButton getButton(Model_Emoji data){
        JButton cmd = new JButton(data.getIcon());
        cmd.setName(data.getId() + "");
        cmd.setBorder(new EmptyBorder(3, 3, 3, 3));
        cmd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmd.setContentAreaFilled(false);
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Model_Send_Message message = new Model_Send_Message(MessageType.EMOJI, Service.getInstance().getUser().getUserID(), user.getUserID(), data.getId()+"");
                sendMessage(message);
                PublicEvent.getInstance().getEventChat().sendMessage(message);
            }
        });
        return cmd;
    }
    
    private void sendMessage(Model_Send_Message data){
        Service.getInstance().getClient().emit("send_to_user", data.toJsonObject());
    }
    
    private void clearSelected(){
        for(Component th : panelHeader.getComponents()){
            if(th instanceof OptionButton){
                ((OptionButton) th).setSelected(false);
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
