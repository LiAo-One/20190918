package com.liao.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    /**
     * Session创建时
     */
    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
        System.out.println("Session创建");

    }

    /**
     * Session销毁时
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {

        System.out.println("Session销毁");
    }

}
