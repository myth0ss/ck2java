package com.hieuthao.model;

import com.hieuthao.event.EventFileReceiver;
import com.hieuthao.service.Service;
import io.socket.client.Ack;
import io.socket.client.Socket;
import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.json.JSONException;

/**
 *
 * @author MinhHieu
 */
public class Model_File_Receiver {

    private int fileID;
    private File file;
    private long fileSize;
    private String fileExtension;
    private RandomAccessFile accFile;
    private Socket socket;
    private EventFileReceiver event;
    private final String PATH_FILE = "client_data/";

    public int getFileID() {
        return fileID;
    }

    public void setFileID(int fileID) {
        this.fileID = fileID;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public RandomAccessFile getAccFile() {
        return accFile;
    }

    public void setAccFile(RandomAccessFile accFile) {
        this.accFile = accFile;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public EventFileReceiver getEvent() {
        return event;
    }

    public void setEvent(EventFileReceiver event) {
        this.event = event;
    }

    public Model_File_Receiver() {
    }

    public Model_File_Receiver(int fileID, Socket socket, EventFileReceiver event) {
        this.fileID = fileID;
        this.socket = socket;
        this.event = event;
    }

    public void initReceiver() {
        socket.emit("get_file", fileID, new Ack() {
            @Override
            public void call(Object... os) {
                if (os.length > 0) {
                    try {
                        fileExtension = os[0].toString();
                        fileSize = (int) os[1];
                        file = new File(PATH_FILE + fileID + fileExtension);
                        accFile = new RandomAccessFile(file, "rw");
                        event.onStartReceiving();
                        // start save file
                        startSaveFile();
                    } catch (IOException | JSONException e) {
                    }
                }
            }

        });
    }

    public void startSaveFile() throws IOException, JSONException {
        Model_Reques_File data = new Model_Reques_File(fileID, accFile.length());
        socket.emit("reques_file", data.toJSONObject(), new Ack() {
            @Override
            public void call(Object... os) {
                try {
                    if (os.length > 0) {
                        byte[] th = (byte[]) os[0];
                        writeFile(th);
                        event.onReceiving(getPercentage());
                        startSaveFile();
                    } else {
                        close();
                        event.onFinish(new File(PATH_FILE + fileID + fileExtension));
                        // remove list
                        Service.getInstance().fileReceiverFinish(Model_File_Receiver.this);
                    }
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    private synchronized long writeFile(byte[] data) throws IOException {
        accFile.seek(accFile.length());
        accFile.write(data);
        return accFile.length();
    }
    
    private double getPercentage() throws IOException {
        double percentage;
        long filePointer = accFile.getFilePointer();
        percentage = filePointer*100/fileSize;
        return percentage;
    }

    public void close() throws IOException {
        accFile.close();
    }
}
