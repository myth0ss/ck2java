
package com.hieuthao.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author MinhHieu
 */
public class Model_login {
    private String userName;
    private String passWord;
    

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

    public Model_login(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }
    
    public Model_login(){
        
    }
    
    public JSONObject toJSONObject(){
        try {
            JSONObject obj = new JSONObject();
            obj.put("userName", userName);
            obj.put("passWord", passWord);
            return obj;
        } catch (JSONException e) {
            return null;
        }
    }
}
