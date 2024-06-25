
package com.hieuthao.event;

import com.hieuthao.model.Model_Receive_Message1;
import com.hieuthao.model.Model_Send_Message;

/**
 *
 * @author MinhHieu
 */
public interface EventChat {
    public void sendMessage(Model_Send_Message data);
    public void receiveMessage(Model_Receive_Message1 data);
}
