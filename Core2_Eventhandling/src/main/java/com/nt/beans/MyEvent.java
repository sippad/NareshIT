package com.nt.beans;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent{

	protected String action;
	
	public String getAction() {
		return action;
	}

	public MyEvent(Object source,String action) {
		super(source);
		this.action=action;
	}

}
