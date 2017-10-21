package com.nt.beans;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class MyEventSource implements ApplicationEventPublisherAware{

		private ApplicationEventPublisher publisher;
		
		public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
			this.publisher=publisher;
			
		}
		
		public void createEvent(String action) {
			publisher.publishEvent(new MyEvent(this,action));
		}

}
