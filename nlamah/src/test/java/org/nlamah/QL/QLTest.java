package org.nlamah.QL;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class QLTest extends TestCase
{
	public static Test suite()
	{
		final TestSuite suite = new TestSuite("QLTestSuite");

		suite.addTestSuite(QLFormTest.class);
		suite.addTestSuite(QLComputationalExpressionTest.class);
		suite.addTestSuite(QLLogicalExpressionTest.class);
		suite.addTestSuite(QLFormErrorTest.class);
		suite.addTestSuite(QLFragmentiserTest.class);

		return suite;
	}
}