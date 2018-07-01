package com.noklin.client;

import java.util.HashMap;
import java.util.Map;

public class App {
	
	private static ChromeConsoleLogger logger = new ChromeConsoleLogger(Dion.class);
	private static final Map<String,Scope> SCOPES = new HashMap<>();
	
	public static class ChromeConsoleLogger{
		private String simpleClassName;
		public ChromeConsoleLogger(Class<?> logSourceClass){
			simpleClassName = logSourceClass.getSimpleName() + " ";
		}
		
		public void error(String msg) {
			log("error", simpleClassName + msg);
		}

		public void warn(String msg) {
			log("warn", simpleClassName + msg);
		}

		public void info(String msg) {
			log("info", simpleClassName + msg);
		}
		
		private static native void log(String level, String message) /*-{
			if(console[level])
    			console[level](message);
  		}-*/;
		
	}
	
	
	public static void debug(String msg) {
		logger.info(msg);
	}
 
	public static void info(String msg) {  
		logger.info(msg);
	} 
	public static void error(String msg) {  
		logger.error(msg);
	}

	public static void warn(String msg) {  
		logger.warn(msg);
	}

}
