
package com.hieuthao.event;

import com.hieuthao.model.Model_User_Account;

/**
 *
 * @author MinhHieu
 */
public interface EventMain {
    public void showLoading(boolean show);
    public void initChat();
    public void selectUser(Model_User_Account user);
    public void updateUser(Model_User_Account user);
}
