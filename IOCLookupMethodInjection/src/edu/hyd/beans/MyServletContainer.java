package edu.hyd.beans;

public abstract class MyServletContainer {
	
	
	
//	Performing lookup in this method
	public void processRequest(String data){
		RequestHandler reqHandler= getRequestHandler();
		reqHandler.handle(data);
		System.out.println("MyServletContainer > processRequest(String data)");
	}
	
	public abstract RequestHandler getRequestHandler();
	
	
}
