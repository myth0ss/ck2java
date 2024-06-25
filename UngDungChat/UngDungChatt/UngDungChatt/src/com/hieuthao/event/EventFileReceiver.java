package com.hieuthao.event;

import java.io.File;

/**
 *
 * @author MinhHieu
 */
public interface EventFileReceiver {

    public void onReceiving(double percentage);

    public void onStartReceiving();

    public void onFinish(File file);
}
