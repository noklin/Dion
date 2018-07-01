package com.noklin;

import com.noklin.client.DionTest;
import com.google.gwt.junit.tools.GWTTestSuite;
import junit.framework.Test;
import junit.framework.TestSuite;

public class DionSuite extends GWTTestSuite {
  public static Test suite() {
    TestSuite suite = new TestSuite("Tests for Dion");
    suite.addTestSuite(DionTest.class);
    return suite;
  }
}
