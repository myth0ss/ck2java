
package com.hieuthao.model;

import org.json.JSONObject;

/**
 *
 * @author MinhHieu
 */
public class Model_Reques_File {
    int fileID;
    private long currentLength;

    public int getFileID() {
        return fileID;
    }

    public void setFileID(int fileID) {
        this.fileID = fileID;
    }

    public long getCurrentLength() {
        return currentLength;
    }

    public void setCurrentLength(long currentLength) {
        this.currentLength = currentLength;
    }

    public Model_Reques_File() {
    }

    public Model_Reques_File(int fileID, long currentLength) {
        this.fileID = fileID;
        this.currentLength = currentLength;
    }
    
    public JSONObject toJSONObject() {
        try {
            JSONObject json = new JSONObject();
            json.put("fileID", fileID);
            json.put("currentLength", currentLength);
            return json;
        } catch (Exception e) {
            return null;
        }
    }
}
