
package com.hieuthao.form;

import com.hieuthao.event.PublicEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Icon;
import javax.swing.SwingUtilities;

/**
 *
 * @author MinhHieu
 */
public class View_Image extends javax.swing.JComponent {

    
   
    public View_Image() {
        initComponents();
    }
     private Icon image;

    public void viewImage(Icon image){
        this.image = image;
        pic.setImage(image);
        setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(0, 0, 0, 150));        
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g); 
        
    }
    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pic = new com.hieuthao.swing.PictureBox();
        jButton1 = new javax.swing.JButton();

        pic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                picMousePressed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hieuthao/icon/download (2).png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pic.add(jButton1);
        jButton1.setBounds(1060, 500, 38, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, 1103, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void picMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_picMousePressed
        if(SwingUtilities.isLeftMouseButton(evt)){
            setVisible(false);
        }
    }//GEN-LAST:event_picMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PublicEvent.getInstance().getEventImageView().saveImage(image);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private com.hieuthao.swing.PictureBox pic;
    // End of variables declaration//GEN-END:variables
}
