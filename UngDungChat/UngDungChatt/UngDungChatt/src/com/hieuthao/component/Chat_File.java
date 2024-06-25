
package com.hieuthao.component;

/**
 *
 * @author MinhHieu
 */
public class Chat_File extends javax.swing.JPanel {

    
    public Chat_File() {
        initComponents();
        setOpaque(false);
    }
    
    public void setFile(String fileName, String size){
        lbFileName.setText(fileName);
        lbFileSize.setText(size);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progress1 = new com.hieuthao.swing.Progress();
        jPanel1 = new javax.swing.JPanel();
        lbFileName = new javax.swing.JLabel();
        lbFileSize = new javax.swing.JLabel();

        progress1.setProgressType(com.hieuthao.swing.Progress.ProgressType.FILE);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        lbFileName.setText(" MinhHieuPhuongThao");
        jPanel1.add(lbFileName);

        lbFileSize.setForeground(new java.awt.Color(196, 32, 193));
        lbFileSize.setText("8 MB");
        jPanel1.add(lbFileSize);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(progress1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(progress1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbFileName;
    private javax.swing.JLabel lbFileSize;
    private com.hieuthao.swing.Progress progress1;
    // End of variables declaration//GEN-END:variables
}
