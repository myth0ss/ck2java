
package com.hieuthao.model;

import javax.swing.ImageIcon;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author MinhHieu
 */
public class Model_Register {
    String userName;
    String passWord;
    String avatar;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Model_Register(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
//        this.avatar = avatar; 
    }
    
    public Model_Register() {
        
    }
    
    public JSONObject toJsonObject(){
        try {
            JSONObject json = new JSONObject();
        json.put("userName", userName);
        json.put("passWord", passWord);
//        json.put("avatar", avatar);
         return json;
        } catch (JSONException e) {
            return null;
        }
    }
}
