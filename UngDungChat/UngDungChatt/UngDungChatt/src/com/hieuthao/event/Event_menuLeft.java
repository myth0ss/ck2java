
package com.hieuthao.event;

import com.hieuthao.model.Model_User_Account;
import java.util.List;

/**
 *
 * @author MinhHieu
 */
public interface Event_menuLeft {
    public void newUser(List<Model_User_Account> users);
    public void userConnect(int userID);
    public void userDisConnect(int userID);
}
