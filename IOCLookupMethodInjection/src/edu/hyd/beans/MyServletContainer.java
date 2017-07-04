package edu.hyd.beans;

public abstract class MyServletContainer {
	
	
	
//	Performing lookup in this method
	public void processRequest(String data){
		System.out.println("MyServletContainer > processRequest(String data)");
		RequestHandler reqHandler= getRequestHandler();
		System.out.println("Request Handler Object created by proxy class");
		reqHandler.handle(data);
	}
	
	public abstract RequestHandler getRequestHandler();
	
	
}
