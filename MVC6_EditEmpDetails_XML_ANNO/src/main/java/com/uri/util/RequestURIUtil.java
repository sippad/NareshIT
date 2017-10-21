package com.uri.util;

public class RequestURIUtil {
		
	public static String getRequestURI(String URI) {
		String lastURI = URI.substring(URI.lastIndexOf("/")+1,URI.length());		
		boolean quest = lastURI.contains("?");
		if(quest)
			lastURI = lastURI.substring(0,lastURI.indexOf("?"));
		return lastURI;
	}
}
