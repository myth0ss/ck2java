
package com.hieuthao.model;



/**
 *
 * @author MinhHieu
 */
public class Model_Receive_Message1 {
    private int messageType;
    private int fromUserID;
    private String text;

    Model_Reicever_Img dataImage;

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public int getFromUserID() {
        return fromUserID;
    }

    public void setFromUserID(int fromUserID) {
        this.fromUserID = fromUserID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Model_Reicever_Img getDataImage() {
        return dataImage;
    }

    public void setDataImage(Model_Reicever_Img dataImage) {
        this.dataImage = dataImage;
    }

    public Model_Receive_Message1() {
    }

    public Model_Receive_Message1(int messageType, int fromUserID, String text, Model_Reicever_Img dataImage) {
        this.messageType = messageType;
        this.fromUserID = fromUserID;
        this.text = text;
        this.dataImage = dataImage;
    }
    
    
}
