package com.hieuthao.service;

import com.hieuthao.event.EventFileReceiver;
import com.hieuthao.event.PublicEvent;
import com.hieuthao.model.Model_File_Receiver;
import com.hieuthao.model.Model_File_Sender;
import com.hieuthao.model.Model_Receive_Message1;
import com.hieuthao.model.Model_Send_Message;
import com.hieuthao.model.Model_User_Account;
import com.hieuthao.security.EncryptionUtil;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import java.io.File;
import java.io.IOException;
import java.security.KeyPair;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author MinhHieu
 */
public class Service {
    
    

    private static Service instance;
    private Socket client;

    private final int PORT_NUMBER = 8108;
    private final String IP = "localhost";

    private Model_User_Account user;

    private List<Model_File_Sender> fileSender;
    private List<Model_File_Receiver> fileReceiver;
    
     private KeyPair keyPair;

    public static Service getInstance() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }

    private Service() {
        fileSender = new ArrayList<>();
        fileReceiver = new ArrayList<>();
        try {
            keyPair = EncryptionUtil.generateKeyPair();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startServer() {
        try {
            client = IO.socket("http://" + IP + ":" + PORT_NUMBER);
            
            client.on("list_user", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    // list user
                    List<Model_User_Account> users = new ArrayList<>();
                    for (Object o : os) {
                        Model_User_Account u = new Model_User_Account(o);
                        if (u.getUserID() != user.getUserID()) {
                            users.add(u);
                        }
                    }
                    PublicEvent.getInstance().getEvent_menuLeft().newUser(users);
                }
            });
            client.on("user_status", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    int userID = (Integer) os[0];
                    boolean status = (boolean) os[1];
                    if (status) {
                        PublicEvent.getInstance().getEvent_menuLeft().userConnect(userID);
                    } else {
                        PublicEvent.getInstance().getEvent_menuLeft().userDisConnect(userID);
                    }
                }
            });
            client.on("receive_ms", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    Model_Receive_Message1 message = new Model_Receive_Message1(os[0]);
                     try {
                        String decryptedMessage = EncryptionUtil.decrypt(message.getText().getBytes(), keyPair.getPrivate());
                        message.setText(decryptedMessage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    PublicEvent.getInstance().getEventChat().receiveMessage(message);
                }
            });
            client.open();
         } catch (NullPointerException e) {
        System.err.println("NullPointerException caught: " + e.getMessage());
        e.printStackTrace(); // In ra lỗi chi tiết
    } catch (Exception e) {
        System.err.println("Exception caught: " + e.getMessage());
        e.printStackTrace(); // In ra lỗi chi tiết
    }

    }
    
    public void sendMessage(String text, int userID) {
        try {
            // Encrypt the message before sending
            int receiverPublicKey = getReceiverPublicKey(userID);
            byte[] encryptedMessage = EncryptionUtil.encrypt(text, receiverPublicKey);
            
            JSONObject json = new JSONObject();
            json.put("toUserID", userID);
            json.put("message", encryptedMessage);
            client.emit("send_ms", json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fileSendFinish(Model_File_Sender data) throws IOException {
        fileSender.remove(data);
        if (!fileSender.isEmpty()) {
            // Start send new file when old file sending finish.
            fileSender.get(0).initSend();
        }
    }
    
    public int getReceiverPublicKey(int id){
        return id;
    }

    public Model_File_Sender addFile(File file, Model_Send_Message message) throws IOException {
        Model_File_Sender data = new Model_File_Sender(file, client, message);
        message.setFile(data);
        fileSender.add(data);
        //For send file one by one.
        if (fileSender.size() == 1) {
            data.initSend();
        }
        return data;
    }

    public void fileReceiverFinish(Model_File_Receiver data) throws IOException {
        fileReceiver.remove(data);
        if (!fileReceiver.isEmpty()) {
            // Start send new file when old file sending finish.
            fileReceiver.get(0).initReceiver();
        }
    }

    public void addFileReceiver(int fileID, EventFileReceiver event) throws IOException {
        Model_File_Receiver data = new Model_File_Receiver(fileID, client, event);
        fileReceiver.add(data);
        if (fileReceiver.size() == 1) {
            data.initReceiver();
        }
    }

    public Socket getClient() {
        return client;
    }

    public Model_User_Account getUser() {
        return user;
    }

    public void setUser(Model_User_Account user) {
        this.user = user;
    }

    private void error(Exception e) {
        System.err.println(e);
    }
}
