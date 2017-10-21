package com.nt.beans;

import org.springframework.context.ApplicationListener;

public class MyEventListener implements ApplicationListener<MyEvent>{

	public void onApplicationEvent(MyEvent event) {
		System.out.println("Performing action "+event.getAction());
	}

}
