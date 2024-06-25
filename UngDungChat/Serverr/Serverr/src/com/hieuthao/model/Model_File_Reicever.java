
package com.hieuthao.model;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author MinhHieu
 */
public class Model_File_Reicever {
    public Model_Send_Message getMessage() {
        return message;
    }

    public void setMessage(Model_Send_Message message) {
        this.message = message;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public RandomAccessFile getAccFile() {
        return accFile;
    }

    public void setAccFile(RandomAccessFile accFile) {
        this.accFile = accFile;
    }

    public Model_File_Reicever(Model_Send_Message message, File file) throws IOException {
        this.message = message;
        this.file = file;
        this.accFile = new RandomAccessFile(file, "rw");
    }

    public Model_File_Reicever() {
    }

    private Model_Send_Message message;
    private File file;
    private RandomAccessFile accFile;

    public synchronized long writeFile(byte[] data) throws IOException {
        accFile.seek(accFile.length());
        accFile.write(data);
        return accFile.length();
    }

    public void close() throws IOException {
        accFile.close();
    }
}
