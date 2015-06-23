package org.nlamah.QLS;

import org.nlamah.QBase.QBaseTestCase;

import junit.framework.Test;
import junit.framework.TestSuite;

public class QLSTest extends QBaseTestCase
{
	public static Test suite()
	{
		final TestSuite suite = new TestSuite("QLSTestSuite");

		suite.addTestSuite(QLStylesheetTest.class);
		suite.addTestSuite(QLStylesheetErrorTest.class);
		suite.addTestSuite(QLStyleCombiningTest.class);

		return suite;
	}
}