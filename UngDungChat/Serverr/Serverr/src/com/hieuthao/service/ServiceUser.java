
package com.hieuthao.service;

import com.hieuthao.connection.DatabaseConnection;
import com.hieuthao.model.Model_Client;
import com.hieuthao.model.Model_Message;
import com.hieuthao.model.Model_Register;
import com.hieuthao.model.Model_User_Account;
import com.hieuthao.model.Model_login;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author MinhHieu
 */
public class ServiceUser {
    
    public ServiceUser() {
        this.con = DatabaseConnection.getInstance().getConnection();
    }

    public Model_Message register(Model_Register data) {
        //  Check user exit
        System.out.println("Registering user: " + data.getUserName() + " with avatar: " + data.getAvatar());
        Model_Message message = new Model_Message();
        try {
            PreparedStatement p = con.prepareStatement(CHECK_USER);
            p.setString(1, data.getUserName());
            ResultSet r = p.executeQuery();
            if (r.first()) {
                message.setAction(false);
                message.setMessage("User Already Exit");
            } else {
                message.setAction(true);
            }
            r.close();
            p.close();
            if (message.isAction()) {
                //  Insert User Register
                con.setAutoCommit(false);
                p = con.prepareStatement(INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);
                p.setString(1, data.getUserName());
                p.setString(2, data.getPassWord());
//                p.setString(3, data.getAvatar());
                p.execute();
                r = p.getGeneratedKeys();
                r.first();
                int userID = r.getInt(1);
                r.close();
                p.close();
                //  Create user account
                p = con.prepareStatement(INSERT_USER_ACCOUNT);
                p.setInt(1, userID);
                p.setString(2, data.getUserName());
//                p.setString(3, data.getAvatar());
                p.execute();
                p.close();
                con.commit();
                con.setAutoCommit(true);
                message.setAction(true);
                message.setMessage("Ok");
                message.setData(new Model_User_Account(userID, data.getUserName(), "", "", true));
            }
        } catch (SQLException e) {
            message.setAction(false);
            message.setMessage("Server Error");
            try {
                if (con.getAutoCommit() == false) {
                    con.rollback();
                    con.setAutoCommit(true);
                }
            } catch (SQLException e1) {
            }
        }
        return message;
    }
    
    public Model_User_Account login(Model_login login) throws SQLException {
        Model_User_Account data = null;
        PreparedStatement p = con.prepareStatement(LOGIN);
        p.setString(1, login.getUserName());
        p.setString(2, login.getPassWord());
        ResultSet rs = p.executeQuery();
        if(rs.first()){
            int userID = rs.getInt(1);
            String userName = rs.getString(2);
            String gender = rs.getString(3);
            String image = rs.getString(4);
            data = new Model_User_Account(userID, userName, gender, image, true);
        }
        return data;
    }

    public List<Model_User_Account> getUser(int exitUser) throws SQLException {
        List<Model_User_Account> list = new ArrayList<>();
        PreparedStatement p = con.prepareStatement(SELECT_USER_ACCOUNT);
        p.setInt(1, exitUser);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int userID = r.getInt(1);
            String userName = r.getString(2);
            String gender = r.getString(3);
            String image = r.getString(4);
            list.add(new Model_User_Account(userID, userName, gender, image, checkUserStatus(userID)));
        }
        r.close();
        p.close();
        return list;
    }
    
    private boolean checkUserStatus(int userID){
        List<Model_Client> clients =  Service.getInstance(null).getListClient();
        for(Model_Client t : clients){
            if(t.getUser().getUserID() == userID)
                return true;
        }
        return false;
    }
    

    //  SQL
    private final String LOGIN = "SELECT UserID, user_account.UserName, Gender, ImageString FROM `user` join user_account using (UserID) where `user`.UserName = BINARY(?) and `user`.`Password`=BINARY(?) and user_account.`Status`='1'";
    private final String SELECT_USER_ACCOUNT = "select UserID, UserName, Gender, ImageString from user_account where user_account.`Status`='1' and UserID<>?";
    private final String INSERT_USER = "insert into user (UserName, `Password`) values (?,?)";
    private final String INSERT_USER_ACCOUNT = "insert into user_account (UserID, UserName) values (?,?)";
    private final String CHECK_USER = "select UserID from user where UserName =? limit 1";
    //  Instance
    private final Connection con;
}
