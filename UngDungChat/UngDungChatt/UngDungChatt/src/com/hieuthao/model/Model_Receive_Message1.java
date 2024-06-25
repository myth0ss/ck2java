
package com.hieuthao.model;

import com.hieuthao.app.MessageType;
import com.hieuthao.model.Model_Receiver_Image;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author MinhHieu
 */
public class Model_Receive_Message1 {

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
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

    public Model_Receiver_Image getDataImage() {
        return dataImage;
    }

    public void setDataImage(Model_Receiver_Image dataImage) {
        this.dataImage = dataImage;
    }

    public Model_Receive_Message1(Object json) {
        JSONObject obj = (JSONObject) json;
        try {
            messageType = MessageType.toMessageType(obj.getInt("messageType"));
            fromUserID = obj.getInt("fromUserID");
            text = obj.getString("text");
            if (!obj.isNull("dataImage")) {
                dataImage = new Model_Receiver_Image(obj.get("dataImage"));
            }
        } catch (JSONException e) {
            System.err.println(e);
        }
    }
    private MessageType messageType;
    private int fromUserID;
    private String text;
    private Model_Receiver_Image dataImage;

    public JSONObject toJsonObject() {
        try {
            JSONObject json = new JSONObject();
            json.put("messageType", messageType.getValue());
            json.put("fromUserID", fromUserID);
            json.put("text", text);
            if (dataImage != null) {
                json.put("dataImage", dataImage.toJsonObject());
            }
            return json;
        } catch (JSONException e) {
            return null;
        }
    }
}
