
package com.hieuthao.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author MinhHieu
 */
public class GradientColor extends JPanel {
     private Color color1;
    private Color color2;

    public GradientColor(Color color1, Color color2) {
        this.color1 = color1;
        this.color2 = color2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        // Tạo gradient từ trên xuống dưới với độ trong suốt dần
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, height, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
    }
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        JPanel jp = new GradientColor(Color.PINK, new Color(0, 0, 255));
        jf.setSize(new Dimension(300, 300));
        jf.add(jp);
        jf.setVisible(true);
    }
}
