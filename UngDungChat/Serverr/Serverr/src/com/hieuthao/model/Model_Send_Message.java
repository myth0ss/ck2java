
package com.hieuthao.model;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;


/**
 *
 * @author MinhHieu
 */
public class Model_Send_Message {
    private int messageType;
    private int fromUserID;
    private int toUserID;
    private String text;

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

    public int getToUserID() {
        return toUserID;
    }

    public void setToUserID(int toUserID) {
        this.toUserID = toUserID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Model_Send_Message() {
    }

    public Model_Send_Message(int messageType, int fromUserID, int toUserID, String text) {
        this.messageType = messageType;
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
        this.text = text;
    }
    
    private byte[] encryptMessage(String message, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES"); // Sử dụng thuật toán AES
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes());
        return encryptedBytes; // Mã hóa dữ liệu thành chuỗi Base64
    }

    private String decryptMessage(byte[] encryptedMessage, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES"); // Sử dụng thuật toán AES
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedMessage);
        return new String(decryptedBytes);
    }

    // Thêm phương thức để mã hóa và giải mã tin nhắn
    public byte[] encryptMessage(SecretKey secretKey) throws Exception {
        return encryptMessage(this.text, secretKey);
    }

    public String decryptMessage(SecretKey secretKey) throws Exception {
        return decryptMessage(this.text.getBytes(), secretKey);
    }
    
    
}
