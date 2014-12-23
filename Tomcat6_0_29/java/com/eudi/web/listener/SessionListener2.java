package com.eudi.web.listener;

import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener2 implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("listener2�յ��˴���session����Ϣ " + new Date());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("listener2�յ�������session����Ϣ " + new Date());
	}

}
