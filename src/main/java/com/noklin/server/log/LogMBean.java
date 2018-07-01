package com.noklin.server.log;

public interface LogMBean {
	public void setLogerLevel(String name, String level);
	public String getLogerLevel(String name); 
	public String[] getLoggers(); 
}
