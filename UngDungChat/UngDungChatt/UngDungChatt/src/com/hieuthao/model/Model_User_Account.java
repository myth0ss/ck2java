
package com.hieuthao.model;

import org.json.JSONObject;

/**
 *
 * @author MinhHieu
 */
public class Model_User_Account {

    int userID;
    String userName;
    String gender;
    String image;
    boolean status;
    String publicKey;  // Thêm thuộc tính này

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // Thêm getter và setter cho publicKey
    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public Model_User_Account(int userID, String userName, String gender, String image, boolean status) {
        this.userID = userID;
        this.userName = userName;
        this.gender = gender;
        this.image = image;
        this.status = status;
    }

    public Model_User_Account(Object json) {
        JSONObject obj = (JSONObject) json;
        try {
            userID = obj.getInt("userID");
            userName = obj.getString("userName");
            gender = obj.getString("gender");
            image = obj.getString("image");
            status = obj.getBoolean("status");
//            publicKey = obj.getString("publicKey");  // Thêm dòng này để lấy khóa công khai
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
