package com.eudi.web.listener;

import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("listener1收到了创建session的消息 " + new Date());

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("listener1收到了销毁session的消息" + new Date());

	}

}
