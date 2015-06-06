package org.nlamah.QBase;

public class Constants 
{
	static protected String baseUri()
	{
		return System.getProperty("user.dir");
	}
	
	static protected String defaultUriSourceQL()
	{
		return baseUri() + "/target/classes/org/nlamah/QL/source.ql";
	}
	
	static protected String defaultUriSourceQLS()
	{
		return baseUri() + "/target/classes/org/nlamah/QLS/stylesheet.qls";
	}
	
	static protected String defaultUriSourceQLTestRoot()
	{
		return baseUri() + "/target/classes/org/nlamah/QL/test/";
	}
	
	static protected String defaultUriSourceQLSTestRoot()
	{
		return baseUri() + "/target/classes/org/nlamah/QLS/test/";
	}
}
