package com.noklin.client;

import com.noklin.shared.FieldVerifier;
import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

/**
 * GWT JUnit tests must extend GWTTestCase.
 */
public class DionTest extends GWTTestCase {

  /**
   * Must refer to a valid module that sources this class.
   */
  public String getModuleName() {
    return "com.noklin.DionJUnit";
  }

  /**
   * Tests the FieldVerifier.
   */
  public void testFieldVerifier() { 
  }

  /**
   * This test will send a request to the server using the greetServer method in
   * GreetingService and verify the response.
   */
  public void testGreetingService() { 
        finishTest(); 
  }


}
