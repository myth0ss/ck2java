package com.hieuthao.event;

/**
 *
 * @author MinhHieu
 */
public interface EventFileSender {

    public void onSending(double percentage);

    public void onStartSending();

    public void onFinish();
}
