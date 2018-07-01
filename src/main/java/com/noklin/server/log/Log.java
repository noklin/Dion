package com.noklin.server.log;

import java.util.ArrayList;
import java.util.Enumeration;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Log implements LogMBean{
	@Override
	public void setLogerLevel(String name, String level) { 
		Logger loger = LogManager.getLogger(name);
		if(loger != null) {
			loger.setLevel(Level.toLevel(level)); 
		}
	}

	@Override
	public String getLogerLevel(String name) { 
		Logger loger = LogManager.getLogger(name);
		if(loger != null) {
			return loger.getLevel().toString();
		}
		return "loger not found!";
	}

	@Override
	public String[] getLoggers() { 
		Enumeration en = LogManager.getCurrentLoggers();
		ArrayList<String> array = new ArrayList<>();
		while(en.hasMoreElements()) {
			array.add(en.nextElement().toString());
		}
		return array.toArray(new String[]{});
	}
}