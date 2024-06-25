
package com.hieuthao.model;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author MinhHieu
 */
public class Model_File_Sender {
    Model_File data;
    File file;
    RandomAccessFile accFile;
    long fileSize;

    public Model_File getData() {
        return data;
    }

    public void setData(Model_File data) {
        this.data = data;
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

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public Model_File_Sender() {
    }

    public Model_File_Sender(Model_File data, File file) throws IOException {
        this.data = data;
        this.file = file;
        this.accFile = new RandomAccessFile(file, "r");
        this.fileSize = accFile.length();
    }
    
    public byte[] read(long currentLength) throws IOException {
        accFile.seek(currentLength);
        if(currentLength!=fileSize){
            int max = 2000;
            long length = currentLength + max >= fileSize ? fileSize - currentLength : max;
            byte[] th = new byte[(int) length];
            accFile.read(th);
            return th;
        } else {
            return null;
        }
    }
    
}
