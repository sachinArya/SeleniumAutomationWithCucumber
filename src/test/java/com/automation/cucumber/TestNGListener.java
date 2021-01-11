package com.automation.cucumber;

import org.testng.ITestContext;
import org.testng.TestListenerAdapter;
import org.testng.xml.XmlSuite;

public class TestNGListener extends TestListenerAdapter {

    static int threadCount = 0;
    public final void onStart(final ITestContext context)
    {
        XmlSuite suite = context.getSuite().getXmlSuite();
        threadCount = suite.getThreadCount();
    }
}
