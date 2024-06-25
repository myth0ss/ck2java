
package com.hieuthao.swing;

import javax.swing.Icon;
import javax.swing.JProgressBar;

/**
 *
 * @author MinhHieu
 */
public class Progress extends JProgressBar {
    
    public ProgressType getProgressType(){
        return progressType;
    }
    
    public void setProgressType(ProgressType progressType){
        this.progressType = progressType;
        repaint();
    }
    
    
    private ProgressType progressType = ProgressType.NONE;
    
    public Progress(){
        setOpaque(false);
        setUI(new ProgressCircleUI(this));
    }
    
    public static enum ProgressType{
        NONE, DOWN_FILE, CANCEL, FILE     
    }
}