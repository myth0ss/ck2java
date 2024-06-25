
package com.hieuthao.model;

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
}
