package edu.hyd.beans;

public class RequestHandler {
	/*
	 * Proxy class will implement this abstract method.
	 *  
	 * public RequestHandler getRequestHandler(){ }
	 * 
	 */
	
	private static int count;
	
//	Constructor
	public RequestHandler(){
		count++;
		System.out.println(" RequestHandler > constructor");		
	}
	
	public void handle(String data){
		System.out.println(" RequestHandler > handle(String data)");
		System.out.println("Handling request no."+count+" with "+data);
	}

//	
	
}
