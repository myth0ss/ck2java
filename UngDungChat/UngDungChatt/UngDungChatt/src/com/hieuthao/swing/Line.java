
package com.hieuthao.swing;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;

/**
 *
 * @author MinhHieu
 */
public class Line extends JLabel{
    
    public void paintComponent(Graphics grs){
        super.paintComponent(grs);
        grs.setColor(getForeground());
        grs.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);
    }
    
}
