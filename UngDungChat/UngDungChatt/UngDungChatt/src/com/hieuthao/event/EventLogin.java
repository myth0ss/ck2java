
package com.hieuthao.event;

import com.hieuthao.model.Model_Message;
import com.hieuthao.model.Model_Register;
import com.hieuthao.model.Model_login;

/**
 *
 * @author MinhHieu
 */
public interface EventLogin {
    public void login(Model_login data);
    public void register(Model_Register data, EventMessage message);
    public void goRegister();
    public void goBack();
}
