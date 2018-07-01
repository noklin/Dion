package com.noklin.server;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.logging.LogManager;

import javax.management.MBeanException;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

import com.noklin.server.log.Log;

public class ResFilter implements Filter{
	
	private static final Logger LOG = Logger.getLogger(ResFilter.class);

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain arg2)
			throws IOException, ServletException { 
		HttpServletRequest req = (HttpServletRequest)request;
		LOG.info("URI: " + req.getRequestURI()); 
		LOG.debug("URI: " + req.getRequestURI()); 
		org.apache.log4j.ConsoleAppender f;
		org.apache.log4j.DailyRollingFileAppender g;
		if(req.getRequestURI().contains(".")){
			arg2.doFilter(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		LOG.info("init filter");
		try {
			MBeanServer mbs = ManagementFactory.getPlatformMBeanServer(); 
			ObjectName name = new ObjectName("com.noklin:type=Log"); 
			Log mbean = new Log(); 
			mbs.registerMBean(mbean, name); 
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
	}

}